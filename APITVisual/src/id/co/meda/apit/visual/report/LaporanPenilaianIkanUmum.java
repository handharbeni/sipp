/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianIkanUmum <T> {
    
    private String nop;
    private String alamatOP;
    private String namaWp;
    private String noIzin;
    private String tahun;
    private ArrayList<T> arrIkan;
    private T objIkan; // variable untuk mendapatkan objek dari Tipe T
    private String njop;

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

    /**
     * @return the alamatOP
     */
    public String getAlamatOP() {
        return alamatOP;
    }

    /**
     * @param alamatOP the alamatOP to set
     */
    public void setAlamatOP(String alamatOP) {
        this.alamatOP = alamatOP;
    }

    /**
     * @return the namaWp
     */
    public String getNamaWp() {
        return namaWp;
    }

    /**
     * @param namaWp the namaWp to set
     */
    public void setNamaWp(String namaWp) {
        this.namaWp = namaWp;
    }

    /**
     * @return the noIzin
     */
    public String getNoIzin() {
        return noIzin;
    }

    /**
     * @param noIzin the noIzin to set
     */
    public void setNoIzin(String noIzin) {
        this.noIzin = noIzin;
    }

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
     * @return the arrIkan
     */
    public ArrayList<T> getArrIkan() {
        return arrIkan;
    }

    /**
     * @param arrIkan the arrIkan to set
     */
    public void setArrIkan(ArrayList<T> arrIkan) {
        this.arrIkan = arrIkan;
    }

    /**
     * @return the njop
     */
    public String getNjop() {
        return njop;
    }

    /**
     * @param njop the njop to set
     */
    public void setNjop(String njop) {
        this.njop = njop;
    }

    /**
     * @return the objIkan
     */
    public T getObjIkan() {
        return objIkan;
    }

    /**
     * @param objIkan the objIkan to set
     */
    public void setObjIkan(T objIkan) {
        this.objIkan = objIkan;
    }

  
    
    
    
}
