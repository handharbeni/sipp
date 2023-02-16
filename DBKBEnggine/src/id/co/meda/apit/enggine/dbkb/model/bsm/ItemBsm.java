/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.bsm;

/**
 *
 * @author meda
 */
public class ItemBsm {
    
    private String tahunDBKB;
    private String id;
    private String jenisPekerjaan;
    private double volume;
    private double material;
    private double upah;
    private double faktor;
    private double cost;
    
    public ItemBsm(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }

    /**
     * @return the jenisPekerjaan
     */
    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    /**
     * @param jenisPekerjaan the jenisPekerjaan to set
     */
    public void setJenisPekerjaan(String jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * @return the material
     */
    public double getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(double material) {
        this.material = material;
    }

    /**
     * @return the upah
     */
    public double getUpah() {
        return upah;
    }

    /**
     * @param upah the upah to set
     */
    public void setUpah(double upah) {
        this.upah = upah;
    }

    /**
     * @return the faktor
     */
    public double getFaktor() {
        return faktor;
    }

    /**
     * @param faktor the faktor to set
     */
    public void setFaktor(double faktor) {
        this.faktor = faktor;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        cost = (getMaterial()+getUpah())*getFaktor()*getVolume();
        return cost;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
   
    
    
}
