/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlLkokTanahBandara {
    
    public boolean cekNOP(String nop)
    {
            String sql = "select count(*) from lkok_tanah_bandara where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            return jmlh > 0;
    }
    
    private LkokTanahBandara buatLkokTanah(String nop,String nama,
            String alamat,double tanahKomersial, double tanahNonKomersial, 
            double tanahCadangan, double areaLain)
    {
        LkokTanahBandara lkokTanah = new LkokTanahBandara();
        lkokTanah.setNop(nop);
        lkokTanah.setNamaBandara(nama);
        lkokTanah.setAlamat(alamat);
        lkokTanah.setLuasKomersial(tanahKomersial);
        lkokTanah.setLuasNonKomersial(tanahNonKomersial);
        lkokTanah.setLuasCadangan(tanahCadangan);
        lkokTanah.setLuasArealLain(areaLain);
      
        
        return lkokTanah;
    }
    
    public boolean simpan(String nop,String nama,
            String alamat,double tanahKomersial, double tanahNonKomersial, 
            double tanahCadangan, double areaLain)
    {
        //isi database
        boolean temp = ToolsPenilaianBandara.isiDbLkokTanah(this.buatLkokTanah(nop, nama, 
                alamat, tanahKomersial, tanahNonKomersial, tanahCadangan, areaLain));
       
        return temp;
    }
    
    public LkokTanahBandara getLkokTanah(String nop)
    {
        return ToolsPenilaianBandara.getModelLkokTanah(nop);   
    }
    
}
