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
public class FasilitasSumurArtesis {
    
    private String tahunDBKB;
    private final double LUAS_LANTAI_TOTAL = 106884.0; 
    private final double TINGGI_LANTAI = 29;
    private final double LUAS_PERLANTAI = 3686;
    private final double KEDALAMAN_SUMUR = 300;
    
    public FasilitasSumurArtesis(String tahunDBKB)
    {
         DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesPerhitungan()
    {
        try{
            
            //proses kolom table
            String sql = "update pros_sumurartesis set model_jumlah_harga = model_harga*model_jumlah where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            double totalModelHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_sumurartesis "
                    + "where tahun = '"+tahunDBKB+"'");
            
            sql = "update pros_sumurartesis set model_bobot = model_jumlah_harga/"+totalModelHarga+" "
                    + "where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
            DBFetching.setComandToDB(sql);
            
             double totalModelBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_sumurartesis "
                    + "where tahun = '"+tahunDBKB+"'");
            
            sql = "update pros_sumurartesis,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";    
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_sumurartesis set aktual_jumlah_harga = aktual_harga*model_jumlah "
                    + "where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
            DBFetching.setComandToDB(sql);
            
        //proses perhitungan
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) "
                + "from pros_sumurartesis where tahun = '"+tahunDBKB+"'");
            
        double jumlahLain = (totalAktualHarga/totalModelBobot) - totalAktualHarga;
        double subTotal = totalAktualHarga + jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        double total = subTotal+ppn+fee;
        double konversi = total/this.KEDALAMAN_SUMUR;
        
       sql = "update rslt_fasilitas set harga = "+konversi+" where tahun = '"+tahunDBKB+"' and "
                + "id = 'FMR001'";
        DBFetching.setComandToDB(sql);
            
        
        }catch(Exception e){
            
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
