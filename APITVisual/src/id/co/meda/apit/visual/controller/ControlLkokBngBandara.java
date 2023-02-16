/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokBangunanKhususBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokBangunanUmumBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlLkokBngBandara {
    
     public boolean cekNOPTanah(String nop)
    {
            String sql = "select count(*) from lkok_tanah_bandara where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            return jmlh > 0;
    }
    
      public boolean cekNOP(String nop)
    {
            String sql = "select count(*) from lkok_bangunan_umum_bandara where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            return jmlh > 0;
    }
      
      public LkokBangunanUmumBandara getLkokBng(String nop)
    {
         return ToolsPenilaianBandara.getModelLkokBangunan(nop);
    }
      
     
     private LkokBangunanUmumBandara buatLkokBng(String nop,String runway, 
             String apron, String taxiway, String inspeksiLbh4, String inspeksiKrg4, 
             String konstruksi, String kondUmum, String thnDibangun, String thnRenovasi,
             ArrayList<LkokBangunanKhususBandara> lkokBangunan)
    {
        LkokBangunanUmumBandara lkokBng = new LkokBangunanUmumBandara();
        lkokBng.setNop(nop);
        lkokBng.setJPB_runway(runway);
        lkokBng.setJPB_apron(apron);
        lkokBng.setJPB_taxiway(taxiway);
        lkokBng.setJPB_inpeksiLbh4(inspeksiLbh4);
        lkokBng.setJPB_inpeksiKrg4(inspeksiKrg4);
        lkokBng.setKonstruksi(konstruksi);
        lkokBng.setKondUmum(kondUmum);
        lkokBng.setThnDibangun(thnDibangun);
        lkokBng.setThnRenovasi(thnRenovasi);
        lkokBng.setArrLkokBng(lkokBangunan);
        
        return lkokBng;
    }
    
     
     
     
        public boolean simpan(String nop,String runway, 
             String apron, String taxiway, String inspeksiLbh4, String inspeksiKrg4, 
             String konstruksi, String kondUmum, String thnDibangun, String thnRenovasi,
             ArrayList<LkokBangunanKhususBandara> lkokBangunan)
    {
        //isi database
        boolean temp = ToolsPenilaianBandara.isiDbLkokBangunan(this.buatLkokBng(nop, runway, apron, 
                                                                taxiway, inspeksiLbh4, 
                                                                inspeksiKrg4, konstruksi, 
                                                                kondUmum, thnDibangun, 
                                                                thnRenovasi, lkokBangunan));

        return temp;
    }
      
}
