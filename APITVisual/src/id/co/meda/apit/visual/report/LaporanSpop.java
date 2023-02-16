/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanSpop {
    
    private String namaPemDaerah;
    private String dinasDaerah;
    private String alamatDinas;
    private ArrayList<Spop> arrSpop;

    /**
     * @return the namaPemDaerah
     */
    public String getNamaPemDaerah() {
        return namaPemDaerah;
    }

    /**
     * @param namaPemDaerah the namaPemDaerah to set
     */
    public void setNamaPemDaerah(String namaPemDaerah) {
        this.namaPemDaerah = namaPemDaerah;
    }

    /**
     * @return the dinasDaerah
     */
    public String getDinasDaerah() {
        return dinasDaerah;
    }

    /**
     * @param dinasDaerah the dinasDaerah to set
     */
    public void setDinasDaerah(String dinasDaerah) {
        this.dinasDaerah = dinasDaerah;
    }

    /**
     * @return the alamatDinas
     */
    public String getAlamatDinas() {
        return alamatDinas;
    }

    /**
     * @param alamatDinas the alamatDinas to set
     */
    public void setAlamatDinas(String alamatDinas) {
        this.alamatDinas = alamatDinas;
    }

    /**
     * @return the arrSpop
     */
    public ArrayList<Spop> getArrSpop() {
        return arrSpop;
    }

    /**
     * @param arrSpop the arrSpop to set
     */
    public void setArrSpop(ArrayList<Spop> arrSpop) {
        this.arrSpop = arrSpop;
    }

   
    
}
