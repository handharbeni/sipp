/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model;

/**
 *
 * @author meda
 */
public class JpbDayaDukungKu {
    
    private int id;
    private String tahun;
    private int dy_dkg_min;
    private int dy_dkg_max;
    private String type_kons;
    private double biaya;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the dy_dkg_min
     */
    public int getDy_dkg_min() {
        return dy_dkg_min;
    }

    /**
     * @param dy_dkg_min the dy_dkg_min to set
     */
    public void setDy_dkg_min(int dy_dkg_min) {
        this.dy_dkg_min = dy_dkg_min;
    }

    /**
     * @return the dy_dkg_max
     */
    public int getDy_dkg_max() {
        return dy_dkg_max;
    }

    /**
     * @param dy_dkg_max the dy_dkg_max to set
     */
    public void setDy_dkg_max(int dy_dkg_max) {
        this.dy_dkg_max = dy_dkg_max;
    }

    /**
     * @return the type_kons
     */
    public String getType_kons() {
        return type_kons;
    }

    /**
     * @param type_kons the type_kons to set
     */
    public void setType_kons(String type_kons) {
        this.type_kons = type_kons;
    }

    /**
     * @return the biaya
     */
    public double getBiaya() {
        return biaya;
    }

    /**
     * @param biaya the biaya to set
     */
    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
    
}
