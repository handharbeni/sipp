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
public class JpbMezzaineKu {
    
    private int id;
    private String thn_penilaian;
    private String kd_jpb;
    private String satuan;
    private double nilai;

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
     * @return the thn_penilaian
     */
    public String getThn_penilaian() {
        return thn_penilaian;
    }

    /**
     * @param thn_penilaian the thn_penilaian to set
     */
    public void setThn_penilaian(String thn_penilaian) {
        this.thn_penilaian = thn_penilaian;
    }

    /**
     * @return the kd_jpb
     */
    public String getKd_jpb() {
        return kd_jpb;
    }

    /**
     * @param kd_jpb the kd_jpb to set
     */
    public void setKd_jpb(String kd_jpb) {
        this.kd_jpb = kd_jpb;
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
     * @return the nilai
     */
    public double getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
}
