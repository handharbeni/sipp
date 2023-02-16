/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author I Putu Medagia A
 */
public class FasilitasPabx {
    
    private String tahunDBKB;
    private final double LUAS_LANTAI_TOTAL = 106884;
    private final double TINGGI_LANTAI = 29;
    private final double LUAS_PERLANTAI = 3685.66;
    
    public FasilitasPabx(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesHitungPabx()
    {
        try{
        
        // proses kolom table
        String sql = "update pros_pabx set model_jumlah_berubah_total = model_jumlah_berubah_perlt*"+this.TINGGI_LANTAI+" "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set model_total_jumlah = model_jumlah_berubah_total+model_jumlah_tetap "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set model_harga_tetap = model_harga*model_jumlah_tetap "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set model_harga_berubah_perlt = model_harga*model_jumlah_berubah_perlt "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set model_harga_berubah_total = model_harga*model_jumlah_berubah_total "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set model_jumlah_harga = model_harga_berubah_total+model_harga_tetap "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        double totalJumlah = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_pabx where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_pabx set model_bobot = model_jumlah_harga/"+totalJumlah+""
                + "where tahun = '"+tahunDBKB+"' "
                + "and id_other not like '%NON%'";    
        DBFetching.setComandToDB(sql); 
        
        double totalBobot  = DBFetching.getDoubleResult("select sum(model_bobot) from pros_pabx where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_pabx,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_pabx set aktual_jumlah_harga = aktual_harga*model_total_jumlah "
                + "where tahun = '"+tahunDBKB+"'";    
        DBFetching.setComandToDB(sql);
        
        
        //proses perhitungan
        
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) "
                + "from pros_pabx where tahun = '"+tahunDBKB+"'");
        double jumlahLain = (totalAktualHarga/totalBobot) - totalAktualHarga;
        double subTotal = totalAktualHarga + jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        double total = subTotal+ppn+fee;
        double konversi = total/(8*this.TINGGI_LANTAI);
        
        sql = "update rslt_fasilitas set harga = "+konversi+" where tahun = '"+tahunDBKB+"' and "
                + "id = 'FBX001'";
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
