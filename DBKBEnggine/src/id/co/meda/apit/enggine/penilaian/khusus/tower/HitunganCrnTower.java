/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class HitunganCrnTower {
    private final String thnPenilaian;
    
    private String tipe;
    private Integer tinggiMin;
    private Integer tinggiMax;
    private Integer jmlKaki;
    private String konstruksi;
    private String pemasangan;
    private ArrayList<ItemCrnTower> listAnalisis;
    
    public HitunganCrnTower(String thn) {
        this.thnPenilaian=thn;
    }

    public Double getJumlah() {
        Double jml = 0.0;
        for (int i=0;i<listAnalisis.size();i++) {
            jml=jml+listAnalisis.get(i).getTotal();
        }
        return jml;
    }
    
    public Double getTes() { return 0.01*getJumlah(); } 
    public Double getPpnIjin() { return 0.12*getJumlah(); } 
    public Double getKeuntungan() { return 0.1*getJumlah(); } 
    
    public Double getCrn() { return getJumlah()+getTes()+getPpnIjin()+getKeuntungan(); }
    

    /**
     * @return the thnPenilaian
     */
    public String getThnPenilaian() {
        return thnPenilaian;
    }

    public String getTipe() {
        return tipe;
    }

    /**
     * @param tipe the tipe to set
     */
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /**
     * @return the tinggiMin
     */
    public Integer getTinggiMin() {
        return tinggiMin;
    }

    /**
     * @param tinggiMin the tinggiMin to set
     */
    public void setTinggiMin(Integer tinggiMin) {
        this.tinggiMin = tinggiMin;
    }

    /**
     * @return the tinggiMax
     */
    public Integer getTinggiMax() {
        return tinggiMax;
    }

    /**
     * @param tinggiMax the tinggiMax to set
     */
    public void setTinggiMax(Integer tinggiMax) {
        this.tinggiMax = tinggiMax;
    }

    /**
     * @return the jmlKaki
     */
    public Integer getJmlKaki() {
        return jmlKaki;
    }

    /**
     * @param jmlKaki the jmlKaki to set
     */
    public void setJmlKaki(Integer jmlKaki) {
        this.jmlKaki = jmlKaki;
    }

    /**
     * @return the konstruksi
     */
    public String getKonstruksi() {
        return konstruksi;
    }

    /**
     * @param konstruksi the konstruksi to set
     */
    public void setKonstruksi(String konstruksi) {
        this.konstruksi = konstruksi;
    }

    /**
     * @return the pemasangan
     */
    public String getPemasangan() {
        return pemasangan;
    }

    /**
     * @param pemasangan the pemasangan to set
     */
    public void setPemasangan(String pemasangan) {
        this.pemasangan = pemasangan;
    }

    /**
     * @return the listAnalisis
     */
    public ArrayList<ItemCrnTower> getListAnalisis() {
        return listAnalisis;
    }

    /**
     * @param listAnalisis the listAnalisis to set
     */
    public void setListAnalisis(ArrayList<ItemCrnTower> listAnalisis) {
        this.listAnalisis = listAnalisis;
    }
}
