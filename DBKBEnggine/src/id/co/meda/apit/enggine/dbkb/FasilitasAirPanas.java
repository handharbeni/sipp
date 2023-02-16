/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.Stack;

/**
 *
 * @author meda
 */
public class FasilitasAirPanas {
    
    private String tahunDBKB;
    
    private final double LUAS_LANTAI_TOTAL = 106884;
    private final double TINGGI_LANTAI = 29;
    private final double LUAS_PERLANTAI = 3686;
    private double konversi = 0;
    
    public FasilitasAirPanas(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
       this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesTableHargaAktual()
    {
        try{
            
           String sql = "update pros_airpanas set model_jumlah_harga = model_jumlah*model_harga where tahun = '"+tahunDBKB+"'";
           DBFetching.setComandToDB(sql);
           
           double totalJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_airpanas where tahun = '"+tahunDBKB+"'");
           
           sql = "update pros_airpanas set model_bobot = model_jumlah_harga/"+totalJumlahHarga+" "
                   + " where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
           DBFetching.setComandToDB(sql);
           
           double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_airpanas where tahun = '"+tahunDBKB+"'");
           
           sql = "update pros_airpanas,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";    
           DBFetching.setComandToDB(sql);
            
           sql = "update pros_airpanas set aktual_jumlah_harga = aktual_harga*model_jumlah"
                   + " where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
           DBFetching.setComandToDB(sql);
           
            double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_airpanas where tahun = '"+tahunDBKB+"'");
           
            double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
            double subTotal = totalAktualHarga+jumlahLain;
            double ppn = subTotal*0.1;
            double fee = subTotal*0.3;
            double totalHitung = subTotal+ppn+fee;
            this.konversi = totalHitung/this.LUAS_LANTAI_TOTAL; 
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesKoefisien()
    {
        try{
            String sql = "update pros_koef_airpanas set harga = koefisien*"+this.konversi+" "
                    + "where tahun = '"+this.tahunDBKB+"'";

            DBFetching.setComandToDB(sql);

            Stack stIdAirPanas = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FRS%' "
                    + "and tahun = '"+this.tahunDBKB+"'", 1);

            Stack stHrgAirPanas = DBFetching.getStackResult("select harga from pros_koef_airpanas where "
                    + "tahun = '"+this.tahunDBKB+"'", 1);

            while(!stIdAirPanas.isEmpty())
            {
                sql = "update rslt_fasilitas set harga = "+(Double)stHrgAirPanas.pop()+" "
                        + "where id = '"+stIdAirPanas.pop()+"' and tahun = '"+this.tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
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
