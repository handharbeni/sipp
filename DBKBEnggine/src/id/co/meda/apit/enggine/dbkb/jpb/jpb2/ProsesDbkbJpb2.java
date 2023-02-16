/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb2;

import id.co.meda.apit.database.connection.DBFetching;
import javax.swing.JProgressBar;

/**
 * Class ini digunakan untuk merekap hasil perhitungan DBKKB kumulatif
 * jpb2 lt 10 dan jpb2 lt 32
 * @author I Putu Medagia A
 */
public class ProsesDbkbJpb2 {
    
   ProsesTable32jpb2 table32;
   private String tahunDBKB;
   private JProgressBar progressBar;
    
   public ProsesDbkbJpb2(String tahunDBKB,JProgressBar progressBar)
   {
       this.progressBar = progressBar;
       this.tahunDBKB = tahunDBKB;
       ProsesTable32jpb2 table32 = new ProsesTable32jpb2(tahunDBKB,this.progressBar);
       DBFetching.setAutoCommit(false);
   }
   /*
    * method untuk mengisi table data DBKB Kumulatif
    */
    public void isiDataDbkb()
    {
        try{
            for(int i = 1; i < 15; i++)
            {
                double tempDbkb = DBFetching.getDoubleResult("select dbkb from pros_rekap_jpb2lt10 where jumlah_lantai = "+i+""
                                                                 + " and tahun = '"+tahunDBKB+"'");
                DBFetching.setComandToDB("update pros_dbkb_jpb2 set "
                                         + "dbkb_kumulatif = "+tempDbkb+""
                                         + " where jumlah_lantai = "+i+""
                                         + " and tahun = '"+tahunDBKB+"'");
            }

            for(int i = 15; i < 33; i++)
            {
                double tempDbkb = DBFetching.getDoubleResult("select dbkb from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                                                             + " and tahun = '"+tahunDBKB+"'");
                DBFetching.setComandToDB("update pros_dbkb_jpb2 set "
                                         + "dbkb_kumulatif = "+tempDbkb+""
                                         + " where jumlah_lantai = "+i+""
                                          + " and tahun = '"+tahunDBKB+"'");
            }

            DBFetching.setComandToDB("update pros_dbkb_jpb2 set "
                                     + "dbkb_perlantai = "+(table32.getDbkbTotal()/32)+""
                                     + " and tahun = '"+tahunDBKB+"'");
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
   }
    
   public void done()
   {
       DBFetching.Simpan();
   }
    
}
