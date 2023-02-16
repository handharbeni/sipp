/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.tower.Tower;
import java.sql.ResultSet;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlTower {
    public boolean cekNoBng(String nop, String noBng) {
        int jmlRec = DBFetching.getIntegerResult("select count(*) jml from lspop_tower where nop='" 
                + nop +"' and bngKe='" + noBng + "'");
        return jmlRec>0;
    }    
    
    public void ambilTower(String nop, String noBng, Tower tower) {
        ResultSet rs = DBFetching.getResultSet("select * from lspop_tower where nop='"+nop+"' and bngKe='"+noBng+"'");
        
        try {
            while (rs.next()) {
                tower.setNop(nop);
                tower.setNoBng(noBng);
                tower.setThnBangun(rs.getString("thnBgn"));
                tower.setThnRenov(rs.getString("thnRenov"));
                tower.setKondisi(rs.getString("kondisi"));
                tower.setTipe(rs.getString("tipe"));
                tower.setTinggi(Integer.parseInt(rs.getString("tinggi")));
                tower.setJmlKaki(4);
                tower.setKonstruksi("baja");
                tower.setPemasangan("di atas tanah");
            }
        } catch (Exception e) {}
    }

    public String simpanData(Integer kode, Tower tower) {
        try {
            String sqlnya = "";
            if (kode==0) {
                sqlnya = "insert into lspop_tower values('"+tower.getNop()+"','"+tower.getNoBng()
                        +"','"+tower.getThnBangun()+"','"+tower.getThnRenov()
                        +"','"+tower.getKondisi()
                        +"','"+tower.getTipe()+"',"+tower.getTinggi()+","+tower.getJmlKaki()
                        +",'"+tower.getKonstruksi()+"','"+tower.getPemasangan()+"')";
            } else if (kode==1) {
                sqlnya = "update lspop_tower  set thnBgn='"+tower.getThnBangun()+"', thnRenov='"+tower.getThnRenov()
                        +"', kondisi='"+tower.getKondisi()+"', tipe='"+tower.getTipe()+"', tinggi="+tower.getTinggi()
                        +" where nop='"+tower.getNop()+"' and bngKe='"+tower.getNoBng()+"'";
            }
            //System.out.println(sqlnya);
            DBFetching.setComandToDB(sqlnya);
            return "ok";
        } catch (Exception e) {
            return "error : " + e.getMessage();
        }
    }

}

