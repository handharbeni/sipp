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
public class FasilitasPengolahanLimbah {
    
    private final double LUAS_LANTAI_TOTAL = 106884.0;
    private final double TINGGI_LANTAI = 29.0;
    private final double LUAS_PERLANTAI = 3686.0;
    private double konversi = 0.0;
    private String tahunDBKB;
    
    public FasilitasPengolahanLimbah(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesPerhitungan()
    {
        try{
            String sql = "update pros_limbah_harga set model_jumlah_harga = model_harga*model_jumlah where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalModelJumlah = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_limbah_harga "
                    + "where tahun = '"+tahunDBKB+"'"); 

            sql = "update pros_limbah_harga set model_bobot = model_jumlah_harga/"+totalModelJumlah+ ""
                     + "where tahun = "+tahunDBKB+" and id_other not like '%NON%'";;
            DBFetching.setComandToDB(sql);

            double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_limbah_harga "
                    + "where tahun = '"+tahunDBKB+"'"); 

            sql = "update pros_limbah_harga,ref_dhkmf set aktual_harga = hrg_dhkm "
                    + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                    + "and id_other = kd_dhkm";     
            DBFetching.setComandToDB(sql);

            sql = "update pros_limbah_harga set aktual_jumlah_harga = aktual_harga*model_jumlah "
                     + "where tahun = "+tahunDBKB+" and id_other not like '%NON%'";
            DBFetching.setComandToDB(sql);

            double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_limbah_harga where tahun = '"+tahunDBKB+"'");

            double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
            double subTotal = totalAktualHarga+jumlahLain;
            double ppn = subTotal*0.1;
            double fee = subTotal*0.3;
            double totalHitung = subTotal+ppn+fee;
            konversi = totalHitung/this.LUAS_LANTAI_TOTAL; 
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesJpb()
    {
        try{
            String sql = "update pros_limbah_jpb set harga = koefisien*"+konversi+" where tahun = '"+tahunDBKB+"'";
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
