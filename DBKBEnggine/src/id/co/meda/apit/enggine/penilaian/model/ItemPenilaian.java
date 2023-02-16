/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.model;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ItemPenilaian {
    private String namaItem;
    private Double luasItem;
    private String satuanItem;
    private String namaKomponen;
    private Double nilaiKomponen;

    /**
     * @return the NamaItem
     */
    public String getNamaItem() {
        return namaItem;
    }

    /**
     * @param NamaItem the NamaItem to set
     */
    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    /**
     * @return the LuasItem
     */
    public Double getLuasItem() {
        return luasItem;
    }

    /**
     * @param LuasItem the LuasItem to set
     */
    public void setLuasItem(Double luasItem) {
        this.luasItem = luasItem;
    }

    /**
     * @return the SatuanItem
     */
    public String getSatuanItem() {
        return satuanItem;
    }

    /**
     * @param SatuanItem the SatuanItem to set
     */
    public void setSatuanItem(String satuanItem) {
        this.satuanItem = satuanItem;
    }

    /**
     * @return the NilaiItem
     */
    public Double getNilaiKomponen() {
        return nilaiKomponen;
    }

    /**
     * @param NilaiItem the NilaiItem to set
     */
    public void setNilaiKomponen(Double nilaiKomponen) {
        this.nilaiKomponen = nilaiKomponen;
    }

    /**
     * @return the TotalNilaiItem
     */
    public Double getTotalNilaiItem() {
        return getLuasItem()*getNilaiKomponen();
    }


    /**
     * @return the NamaKomponen
     */
    public String getNamaKomponen() {
        return namaKomponen;
    }

    /**
     * @param NamaKomponen the NamaKomponen to set
     */
    public void setNamaKomponen(String namaKomponen) {
        this.namaKomponen = namaKomponen;
    }
}
