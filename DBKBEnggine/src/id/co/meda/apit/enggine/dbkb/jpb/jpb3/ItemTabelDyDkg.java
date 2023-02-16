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
public class ItemTabelDyDkg {
    private Integer dayaDukungMin;
    private Integer dayaDukungMax;
    private String tipeKons;
    private Double biaya;
    
    public ItemTabelDyDkg(Integer dayaDukungMin, Integer dayaDukungMax, String tipeKons, Double biaya) {
        this.dayaDukungMin=dayaDukungMin;
        this.dayaDukungMax=dayaDukungMax;
        this.tipeKons=tipeKons;
        this.biaya=biaya;
    }

    /**
     * @return the dayaDukungMin
     */
    public Integer getDayaDukungMin() {
        return dayaDukungMin;
    }

    /**
     * @param dayaDukungMin the dayaDukungMin to set
     */
    public void setDayaDukungMin(Integer dayaDukungMin) {
        this.dayaDukungMin = dayaDukungMin;
    }

    /**
     * @return the dayaDukungMax
     */
    public Integer getDayaDukungMax() {
        return dayaDukungMax;
    }

    /**
     * @param dayaDukungMax the dayaDukungMax to set
     */
    public void setDayaDukungMax(Integer dayaDukungMax) {
        this.dayaDukungMax = dayaDukungMax;
    }

    /**
     * @return the tipeKons
     */
    public String getTipeKons() {
        return tipeKons;
    }

    /**
     * @param tipeKons the tipeKons to set
     */
    public void setTipeKons(String tipeKons) {
        this.tipeKons = tipeKons;
    }

    /**
     * @return the biaya
     */
    public Double getBiaya() {
        return biaya;
    }

    /**
     * @param biaya the biaya to set
     */
    public void setBiaya(Double biaya) {
        this.biaya = biaya;
    }
    
}
