/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.pelabuhan;

import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class AnalisisHargaSatuanCRN {
  
    private String nop;
    private String tahun;
    private ArrayList<ItemAnalisisHargaSatuan> arrPersiapan;
    private ArrayList<ItemAnalisisHargaSatuan> arrKonstruksiUtama;
    private ArrayList<ItemAnalisisHargaSatuan> arrFinishing;
    private ArrayList<ItemAnalisisHargaSatuan> arrAsesoris;

    /**
     * @return the arrPersiapan
     */
    public ArrayList<ItemAnalisisHargaSatuan> getArrPersiapan() {
        return arrPersiapan;
    }

    /**
     * @param arrPersiapan the arrPersiapan to set
     */
    public void setArrPersiapan(ArrayList<ItemAnalisisHargaSatuan> arrPersiapan) {
        this.arrPersiapan = arrPersiapan;
    }

    /**
     * @return the arrKonstruksiUtama
     */
    public ArrayList<ItemAnalisisHargaSatuan> getArrKonstruksiUtama() {
        return arrKonstruksiUtama;
    }

    /**
     * @param arrKonstruksiUtama the arrKonstruksiUtama to set
     */
    public void setArrKonstruksiUtama(ArrayList<ItemAnalisisHargaSatuan> arrKonstruksiUtama) {
        this.arrKonstruksiUtama = arrKonstruksiUtama;
    }

    /**
     * @return the arrFinishing
     */
    public ArrayList<ItemAnalisisHargaSatuan> getArrFinishing() {
        return arrFinishing;
    }

    /**
     * @param arrFinishing the arrFinishing to set
     */
    public void setArrFinishing(ArrayList<ItemAnalisisHargaSatuan> arrFinishing) {
        this.arrFinishing = arrFinishing;
    }

    /**
     * @return the arrAsesoris
     */
    public ArrayList<ItemAnalisisHargaSatuan> getArrAsesoris() {
        return arrAsesoris;
    }

    /**
     * @param arrAsesoris the arrAsesoris to set
     */
    public void setArrAsesoris(ArrayList<ItemAnalisisHargaSatuan> arrAsesoris) {
        this.arrAsesoris = arrAsesoris;
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
   
    
}
