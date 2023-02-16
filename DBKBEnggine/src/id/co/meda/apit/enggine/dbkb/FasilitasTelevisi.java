/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author meda
 */
public class FasilitasTelevisi {
    
    private String tahunDBKB;
    private final double LUAS_LANTAI_TOTAL = 106884.0;
    private final double PRAKIRAAN_LUAS_MATV = 85507.0;
    private final double PRAKIRAAN_LUAS_CCTV = 10688.0;
    private final double TINGGI_LANTAI = 29.0;
    private final double LUAS_PERLANTAI = 3685.66;
    
    public FasilitasTelevisi(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesMatv()
    {
        try{
        
        String sql = "update pros_tv set model_jumlah_harga = model_harga*model_jumlah where id like '%MATV%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_tv where id like '%MATV%' "
                + "and tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_tv set model_bobot = model_jumlah_harga/"+totalJumlahHarga+" where id like '%MATV%' and tahun = '"+tahunDBKB+"'"
                +"and id_other not like '%NON%'";
        DBFetching.setComandToDB(sql);
        
        double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_tv where id like '%MATV%' "
                + "and tahun = '"+tahunDBKB+"' and id_other not like '%NON%'");
        
        
       //proses general CCTV dan MATV
        sql = "update pros_tv,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";     
        DBFetching.setComandToDB(sql);
        //-----------------------------------------------------------------------
        
        sql = "update pros_tv set aktual_jumlah_harga = aktual_harga*model_jumlah where id like '%MATV%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_tv "
                + "where id like '%MATV%' and tahun = '"+tahunDBKB+"'");
           
        double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = totalAktualHarga*0.1;
        double fee = totalAktualHarga*0.3;
        double totalHitung = totalAktualHarga+ppn+fee;
        double konversi = totalHitung/this.PRAKIRAAN_LUAS_MATV; 
        
        sql = "update rslt_fasilitas set harga = "+konversi+" where id = 'FTV001' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
  
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
            
        }
        
        
    
    }
    
    public void prosesCctv()
    {
        try{
            String sql = "update pros_tv set model_jumlah_harga = model_harga*model_jumlah where id like '%CCTV%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_tv where id like '%CCTV%' "
                    + "and tahun = '"+tahunDBKB+"'");

            sql = "update pros_tv set model_bobot = model_jumlah_harga/"+totalJumlahHarga+" where id like '%CCTV%' and tahun = '"+tahunDBKB+"'"
                      +"and id_other not like '%NON%'";
            DBFetching.setComandToDB(sql);

            double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_tv where id like '%CCTV%' "
                    + "and tahun = '"+tahunDBKB+"' and id_other not like '%NON%'");

            sql = "update pros_tv set aktual_jumlah_harga = aktual_harga*model_jumlah where id like '%CCTV%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_tv "
                    + "where id like '%CCTV%' and tahun = '"+tahunDBKB+"'");

            double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
            double subTotal = totalAktualHarga+jumlahLain;
            double ppn = subTotal*0.1;
            double fee = subTotal*0.3;
            double totalHitung = subTotal+ppn+fee;
            double konversi = totalHitung/this.PRAKIRAAN_LUAS_CCTV; 
            
            sql = "update rslt_fasilitas set harga = "+konversi+" where id = 'FTV002' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
         
         }catch(Exception e)
         {
             e.printStackTrace();
             DBFetching.RollBackDB();
             System.exit(1);
         }
            
    }
    
    
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
    
    
    
    
}
