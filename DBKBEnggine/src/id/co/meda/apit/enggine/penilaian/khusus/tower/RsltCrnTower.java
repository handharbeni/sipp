/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class RsltCrnTower {
    private String thnCrn;
    private String kdCrn;
    private String tipe;
    private Integer tinggiMin;
    private Integer tinggiMax;
    private Integer jmlKaki;
    private String konstruksi;
    private String pemasangan;
    private Double nilaiCrn;

    public RsltCrnTower() {
        
    }
    public RsltCrnTower(String thnCrn, String kdCrn, String tipe, Integer tinggiMin, Integer tinggiMax, Integer jmlKaki,
        String konstruksi, String pemasangan, Double nilaiCrn) {
        this.thnCrn=thnCrn;
        this.kdCrn=kdCrn;
        this.tipe=tipe;
        this.tinggiMin=tinggiMin;
        this.tinggiMax=tinggiMax;
        this.jmlKaki=jmlKaki;
        this.konstruksi=konstruksi;
        this.pemasangan=pemasangan;
        this.nilaiCrn=nilaiCrn;
    }

    public String getThnCrn() {
        return thnCrn;
    }

    /**
     * @param thnCrn the thnCrn to set
     */
    public void setThnCrn(String thnCrn) {
        this.thnCrn = thnCrn;
    }

    /**
     * @return the kdCrn
     */
    public String getKdCrn() {
        return kdCrn;
    }

    /**
     * @param kdCrn the kdCrn to set
     */
    public void setKdCrn(String kdCrn) {
        this.kdCrn = kdCrn;
    }

    /**
     * @return the tipe
     */
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
     * @return the nilaiCrn
     */
    public Double getNilaiCrn() {
        return nilaiCrn;
    }

    /**
     * @param nilaiCrn the nilaiCrn to set
     */
    public void setNilaiCrn(Double nilaiCrn) {
        this.nilaiCrn = nilaiCrn;
    }
    
}
