/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb3;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ItemTabelJpb38 {
    private String satuan;
    private Integer lbrBtgMin;
    private Integer lbrBtgMax;
    private Integer tingKolMin;
    private Integer tingKolMax;
    private String satNilai;
    private Double nilai;
    
    public ItemTabelJpb38(String satuan,Integer lbrBtgMin,Integer lbrBtgMax,
            Integer tingKolMin,Integer tingKolMax,String satNilai,Double nilai) {
            this.satuan=satuan;
            this.lbrBtgMin=lbrBtgMin;
            this.lbrBtgMax=lbrBtgMax;
            this.tingKolMin=tingKolMin;
            this.tingKolMax=tingKolMax;
            this.satNilai=satNilai;
            this.nilai=nilai;
    }

    /**
     * @return the satuan
     */
    public String getSatuan() {
        return satuan;
    }

    /**
     * @param satuan the satuan to set
     */
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    /**
     * @return the lbrBtgMin
     */
    public Integer getLbrBtgMin() {
        return lbrBtgMin;
    }

    /**
     * @param lbrBtgMin the lbrBtgMin to set
     */
    public void setLbrBtgMin(Integer lbrBtgMin) {
        this.lbrBtgMin = lbrBtgMin;
    }

    /**
     * @return the lbrBtgMax
     */
    public Integer getLbrBtgMax() {
        return lbrBtgMax;
    }

    /**
     * @param lbrBtgMax the lbrBtgMax to set
     */
    public void setLbrBtgMax(Integer lbrBtgMax) {
        this.lbrBtgMax = lbrBtgMax;
    }

    /**
     * @return the tingKolMin
     */
    public Integer getTingKolMin() {
        return tingKolMin;
    }

    /**
     * @param tingKolMin the tingKolMin to set
     */
    public void setTingKolMin(Integer tingKolMin) {
        this.tingKolMin = tingKolMin;
    }

    /**
     * @return the tingKolMax
     */
    public Integer getTingKolMax() {
        return tingKolMax;
    }

    /**
     * @param tingKolMax the tingKolMax to set
     */
    public void setTingKolMax(Integer tingKolMax) {
        this.tingKolMax = tingKolMax;
    }

    /**
     * @return the satNilai
     */
    public String getSatNilai() {
        return satNilai;
    }

    /**
     * @param satNilai the satNilai to set
     */
    public void setSatNilai(String satNilai) {
        this.satNilai = satNilai;
    }

    /**
     * @return the nilai
     */
    public Double getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
    
    
}
