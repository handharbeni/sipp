/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.jalantol;

import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class TanahJatol {
    
    private String nop;
    private String tahun;
    private String namaJatol;
    private double panjangJatol;
    private double lebarJatol;
    private ArrayList<DetailTanahJatol> arrDetailTanah;

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

    /**
     * @return the namaJatol
     */
    public String getNamaJatol() {
        return namaJatol;
    }

    /**
     * @param namaJatol the namaJatol to set
     */
    public void setNamaJatol(String namaJatol) {
        this.namaJatol = namaJatol;
    }

    /**
     * @return the panjangJatol
     */
    public double getPanjangJatol() {
        return panjangJatol;
    }

    /**
     * @param panjangJatol the panjangJatol to set
     */
    public void setPanjangJatol(double panjangJatol) {
        this.panjangJatol = panjangJatol;
    }

    /**
     * @return the lebarJatol
     */
    public double getLebarJatol() {
        return lebarJatol;
    }

    /**
     * @param lebarJatol the lebarJatol to set
     */
    public void setLebarJatol(double lebarJatol) {
        this.lebarJatol = lebarJatol;
    }

    /**
     * @return the arrDetailTanah
     */
    public ArrayList<DetailTanahJatol> getArrDetailTanah() {
        return arrDetailTanah;
    }

    /**
     * @param arrDetailTanah the arrDetailTanah to set
     */
    public void setArrDetailTanah(ArrayList<DetailTanahJatol> arrDetailTanah) {
        this.arrDetailTanah = arrDetailTanah;
    }
    
}
