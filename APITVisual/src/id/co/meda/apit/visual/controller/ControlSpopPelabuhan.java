/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.SpopPelabuhan;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.ToolsPenilaianPelabuhan;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlSpopPelabuhan {
    
    public boolean cekNOP(String nop)
    {
            String sql = "select count(*) from spop_pelabuhan where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            return jmlh > 0;
    }
    
    public boolean simpan(SpopPelabuhan spop)
    {
        return ToolsPenilaianPelabuhan.simpanSpopPelabuhan(spop);
    }
    
    public SpopPelabuhan getSpopPelabuhan(String nop)
    {
        return ToolsPenilaianPelabuhan.getSpopPelabuhan(nop);
    }
    
    
    
}
