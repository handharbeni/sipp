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
public class ItemAhsTower {
    private String jnsPekerjaan;
    private String satuan;
    private Double volume;
    private Double hrgKomp;

    public ItemAhsTower() {
    }

    public ItemAhsTower(String jnsPekerjaan, String satuan, Double volume, Double hrgKomp) {
        this.jnsPekerjaan=jnsPekerjaan;
        this.satuan=satuan;
        this.volume=volume;
        this.hrgKomp=hrgKomp;
    }
    
    public Double getHrgSatuan() {
        return getVolume()*getHrgKomp();
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
     * @return the hrgKomp
     */
    public Double getHrgKomp() {
        return hrgKomp;
    }

    /**
     * @param hrgKomp the hrgKomp to set
     */
    public void setHrgKomp(Double hrgKomp) {
        this.hrgKomp = hrgKomp;
    }

}
