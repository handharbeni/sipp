/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanLspop {
    
    private String tahun;
    private String namaPemDaerah;
    private String dinasDaerah;
    private String alamatDinas;
    private String nop;
    private ArrayList<LspopNonStandar> arrLspop;

    /**
     * @return the tahun
     */
    public String getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

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
     * @return the arrLspop
     */
    public ArrayList<LspopNonStandar> getArrLspop() {
        return arrLspop;
    }

    /**
     * @param arrLspop the arrLspop to set
     */
    public void setArrLspop(ArrayList<LspopNonStandar> arrLspop) {
        this.arrLspop = arrLspop;
    }

    /**
     * @return the nop
     */
    public String getNop() {
        return nop;
    }

    /**
     * @param nop the nop to set
     */
    public void setNop(String nop) {
        this.nop = nop;
    }
    
}
