/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb;

import id.co.meda.apit.database.connection.Konfigurasi;
import id.co.meda.apit.database.connection.ToolsKonfigurasi;
import id.co.meda.apit.enggine.dbkb.jpb.jpb3.HitunganJpb38;
import id.co.meda.apit.enggine.dbkb.jpb.jpb3.ProsesJpb38;
import javax.swing.JProgressBar;



/**
 *
 * @author I Putu Medagia A
 */
public class tesJPB {
    
    public static void main(String[]args)
    {
        
        
      if (ToolsKonfigurasi.cekFileKonf()) {
                System.out.println("udah ada");
            } else {
                ToolsKonfigurasi.buatFileKonf();
            }
            
            Konfigurasi konf = ToolsKonfigurasi.bacaKonf();
            System.out.println(konf.getDbAppConnStr());
            System.out.println(konf.getDbAppConnStr());
      
      
        
        
        
        
    }
}
