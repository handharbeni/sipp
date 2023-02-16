/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb14;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author meda
 */
public class ProsesJpb14 {
    private double nilaiDBKBkanopiSatu;
    private double nilaiDBKBkanopiLebihSatu;
    private double ppnFee;
    private double nilaiSanitary;
    private String tahunDBKB;
    private final double LUAS_KANOPI = 36;
    private final double PPN_PERSEN = 0.2;
    
    public ProsesJpb14(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
   
    public void prosesTable()
    {
        try{
            //proses tabel harga1 dan harga2
            String sql = "update pros_jpb14,pros_hsku set hrg2 = hrg_upah/faktor,hrg1 = hrg_komp/faktor where kd_hsku = id_other "
                    + "and pros_jpb14.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"' and id in('A1','A2','B1','B2')";
            DBFetching.setComandToDB(sql);
            
            //proses tabel harga3 dan harga4
            sql = "update pros_jpb14 set hrg3 = hrg1*vol ,hrg4 = hrg2*vol where "
                    + "pros_jpb14.tahun = '"+tahunDBKB+"' and id in ('A1','A2','B1','B2')";
            
            DBFetching.setComandToDB(sql);
            
            //proses tabel harga5
            sql = "update pros_jpb14 set hrg5 = hrg3 + hrg4 where "
                    + "pros_jpb14.tahun = '"+tahunDBKB+"' and id in('A1','A2','B1','B2')";
            DBFetching.setComandToDB(sql);
            
            //proses KU kanopi 1
            double jumlah = DBFetching.getDoubleResult("select sum(hrg5) from pros_jpb14 where tahun = '"+tahunDBKB+"' and id like '%A%'");
            ppnFee = jumlah*this.PPN_PERSEN;
            double imb = jumlah*0.02;
            double jumlahSubSuperStruktur = jumlah+ppnFee+imb;
            nilaiDBKBkanopiSatu = jumlahSubSuperStruktur/this.LUAS_KANOPI;
            
            
            //proses KU kanopi lebih dari 1
            jumlah = DBFetching.getDoubleResult("select sum(hrg5) from pros_jpb14 where tahun = '"+tahunDBKB+"' and id like '%B%'");
            ppnFee = jumlah*this.PPN_PERSEN;
            imb = jumlah*0.02;
            jumlahSubSuperStruktur = jumlah+ppnFee+imb;
            nilaiDBKBkanopiLebihSatu = jumlahSubSuperStruktur/this.LUAS_KANOPI;
            
           //proses update tableResult
            sql = "update rslt_ku_jpb14 set nilai = "+this.nilaiDBKBkanopiSatu+" where "
                    + "rslt_ku_jpb14.tahun = '"+tahunDBKB+"' and id = 1";
            DBFetching.setComandToDB(sql);
             sql = "update rslt_ku_jpb14 set nilai = "+this.nilaiDBKBkanopiLebihSatu+" where "
                    + "rslt_ku_jpb14.tahun = '"+tahunDBKB+"' and id = 2";
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
