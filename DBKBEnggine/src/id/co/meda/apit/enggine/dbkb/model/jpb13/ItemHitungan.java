/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.jpb13;

/**
 *
 * @author meda
 */
public class ItemHitungan {
    
    private String id;
    private String description;
    private String unit;
    private double quantity;
    private double material;
    private double upah;
    private double cost;
    private String tahun;
    
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
     * @return the cost
     */
    public double getCost() {
        cost = (this.getMaterial()+this.getUpah())*this.getQuantity();
        return cost;
    }
    
    
    
    
    
}
