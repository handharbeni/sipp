/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

/**
 *
 * @author I Putu Medagia A
 */
public class ModelIkan {
    
    private String namaIkan;
    private String jenisUsaha;
    private double berat;
    private double hargaPerTon;
    private String keterangan;

    /**
     * @return the namaIkan
     */
    public String getNamaIkan() {
        return namaIkan;
    }

    /**
     * @param namaIkan the namaIkan to set
     */
    public void setNamaIkan(String namaIkan) {
        this.namaIkan = namaIkan;
    }

    /**
     * @return the berat
     */
    public double getBerat() {
        return berat;
    }

    /**
     * @param berat the berat to set
     */
    public void setBerat(double berat) {
        this.berat = berat;
    }

    /**
     * @return the hargaPerTon
     */
    public double getHargaPerTon() {
        return hargaPerTon;
    }

    /**
     * @param beratPerTon the hargaPerTon to set
     */
    public void setHargaPerTon(double hargaPerTon) {
        this.hargaPerTon = hargaPerTon;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the jenisUsaha
     */
    public String getJenisUsaha() {
        return jenisUsaha;
    }

    /**
     * @param jenisUsaha the jenisUsaha to set
     */
    public void setJenisUsaha(String jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
    }
    
}
