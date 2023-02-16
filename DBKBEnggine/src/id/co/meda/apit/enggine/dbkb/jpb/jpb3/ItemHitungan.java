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
public class ItemHitungan {
    private String kdItem;
    private String namaItem;
    private String satuan;
    private Double quantity;
    private String kdMaterial;
    private Double hrgSatuan;
    private Double hrgMaterial;
    private Double hrgUpah;
    //ini utk membedakan proses hitung komponen utama dan daya dukung
    private final String kdProses;
    
    
    public ItemHitungan(String kdProses) {
        this.kdProses = kdProses;
    }
    
    public Double getJmlHitungan() {
        Double nilai =0.0;
        switch(kdProses) {
            case "KU":
               nilai = quantity*(hrgMaterial+hrgUpah);
                break;
            case "DY":
               nilai = hrgMaterial;
                break;
            case "MZ":
               nilai = quantity*hrgUpah;
                break;
        }
        return nilai;
    }
    /**
     * @return the kdItem
     */
    public String getKdItem() {
        return kdItem;
    }

    /**
     * @param kdItem the kdItem to set
     */
    public void setKdItem(String kdItem) {
        this.kdItem = kdItem;
    }

    /**
     * @return the namaItem
     */
    public String getNamaItem() {
        return namaItem;
    }

    /**
     * @param namaItem the namaItem to set
     */
    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
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
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the kdMaterial
     */
    public String getKdMaterial() {
        return kdMaterial;
    }

    /**
     * @param kdMaterial the kdMaterial to set
     */
    public void setKdMaterial(String kdMaterial) {
        this.kdMaterial = kdMaterial;
    }

    /**
     * @return the hrgMaterial
     */
    public Double getHrgMaterial() {
        return hrgMaterial;
    }

    /**
     * @param hrgMaterial the hrgMaterial to set
     */
    public void setHrgMaterial(Double hrgMaterial) {
        this.hrgMaterial = hrgMaterial;
    }

    /**
     * @return the hrgUpah
     */
    public Double getHrgUpah() {
        return hrgUpah;
    }

    /**
     * @param hrgUpah the hrgUpah to set
     */
    public void setHrgUpah(Double hrgUpah) {
        this.hrgUpah = hrgUpah;
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
