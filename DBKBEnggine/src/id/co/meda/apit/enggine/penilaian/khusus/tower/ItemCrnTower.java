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
public class ItemCrnTower {
    private String jnsPekerjaan;
    private String satuan;
    private Double volume;
    private Double hrgSatuan;

    
    public Double getTotal() {
        return getVolume()*getHrgSatuan();
    }
    
    /**
     * @return the jnsPekerjaan
     */
    public String getJnsPekerjaan() {
        return jnsPekerjaan;
    }

    /**
     * @param jnsPekerjaan the jnsPekerjaan to set
     */
    public void setJnsPekerjaan(String jnsPekerjaan) {
        this.jnsPekerjaan = jnsPekerjaan;
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
     * @return the volume
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * @return the hrgSatuan
     */
    public Double getHrgSatuan() {
        return hrgSatuan;
    }

    /**
     * @param hrgSatuan the hrgSatuan to set
     */
    public void setHrgSatuan(Double hrgSatuan) {
        this.hrgSatuan = hrgSatuan;
    }
    
}
