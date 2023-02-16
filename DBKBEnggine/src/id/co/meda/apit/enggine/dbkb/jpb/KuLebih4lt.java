/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.jpb.jpb13.ProsesHitungJpb13;
import java.util.Stack;
import javax.swing.JProgressBar;

/**
 * Class ini untuk mengisi data harga DBKB Kumulatif bangunan
 * lebih dari 4 lantai
 * @author I Putu Medagia A
 */
public class KuLebih4lt {
    
    private String tahunDBKB;
    private JProgressBar progressBar;
    
    public KuLebih4lt(String tahunDBKB,JProgressBar progressBar){
        this.progressBar = progressBar;
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }

    
    /**
      * Method untuk mengisi kolom jpb_2dan9 pada table rslt_ku_lbh_4lt
      */
    public void isiJpb2dan9()
    {
        try{
            String sql = "select cum from pros_statistik where id_stat = 'jpb2' and tahun = '"+tahunDBKB+"'";
            Stack <Double> stJpb = DBFetching.getStackResult(sql,1);

            int stackSize = stJpb.size();
            while(!stJpb.isEmpty())
            {
                sql = "update rslt_ku_lbh_4lt set jpb_2dan9 = "+stJpb.pop()+" where jumlah_lantai = "+stackSize+""
                        + " and thn_dbkb ='"+tahunDBKB+"'";
                
                stackSize--;
                DBFetching.setComandToDB(sql);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(100);
       progressBar.setString(100+"%");
    }
    
    
    /**
      * Method untuk mengisi kolom jpb_4 pada table rslt_ku_lbh_4lt
      */
    public void isiJpb4()
    {
        try{
            String sql = "select cum from pros_statistik where id_stat = 'jpb4' and tahun = '"+tahunDBKB+"'";
            Stack <Double> stJpb = DBFetching.getStackResult(sql,1);

            int stackSize = stJpb.size();
            while(!stJpb.isEmpty())
            {
                sql = "update rslt_ku_lbh_4lt set jpb_4 = "+stJpb.pop()+" where jumlah_lantai = "+stackSize+""
                        + " and thn_dbkb ='"+tahunDBKB+"'";
                
                stackSize--;
                DBFetching.setComandToDB(sql);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(100);
       progressBar.setString(100+"%");
    }
    
    /**
      * Method untuk mengisi kolom jpb_7 pada table rslt_ku_lbh_4lt
      */
    public void isiJpb7()
    {
        try{
            String sql = "select cum from pros_statistik where id_stat = 'jpb7' and tahun = '"+tahunDBKB+"'";
            Stack <Double> stJpb = DBFetching.getStackResult(sql,1);

            int stackSize = stJpb.size();
            while(!stJpb.isEmpty())
            {
                sql = "update rslt_ku_lbh_4lt set jpb_7 = "+stJpb.pop()+" where jumlah_lantai = "+stackSize+""
                        + " and thn_dbkb ='"+tahunDBKB+"'";
                
                
                stackSize--;
                DBFetching.setComandToDB(sql);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(100);
       progressBar.setString(100+"%");
    }

    /**
      * Method untuk mengisi kolom jpb_12 pada table rslt_ku_lbh_4lt
      */
    public void isiJpb12()
    {
        try{
            String sql = "select exp from pros_fordat where id_fordat = 'jpb12' and tahun = '"+tahunDBKB+"'";
            Stack <Double> stJpb = DBFetching.getStackResult(sql,1);

            int stackSize = stJpb.size();
            while(!stJpb.isEmpty())
            {
                sql = "update rslt_ku_lbh_4lt set jpb_12 = "+stJpb.pop()+" where jumlah_lantai = "+stackSize+""
                        + " and thn_dbkb ='"+tahunDBKB+"'";
               
                stackSize--;
                DBFetching.setComandToDB(sql);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(100);
       progressBar.setString(100+"%");
    
    }
    
    public void isiJpb13()
    {
         try{
           ProsesHitungJpb13 proses = new ProsesHitungJpb13(this.tahunDBKB);
           proses.prosesKeTableKu();
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
