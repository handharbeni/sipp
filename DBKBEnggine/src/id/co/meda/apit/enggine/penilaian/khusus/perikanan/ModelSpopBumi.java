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
public class ModelSpopBumi {
    
    private String nop;
    private String kode;
    private String peruntukan;
    private double luas;
    private String keterangan;

    /**
     * @return the nop
     */
    public String getNop() {
        return nop;
    }

    /**
     * @param nop the nop to set
     */
    public void setNop(String nop) {
        this.nop = nop;
    }

    /**
     * @return the kode
     */
    public String getKode() {
        return kode;
    }

    /**
     * @param kode the kode to set
     */
    public void setKode(String kode) {
        this.kode = kode;
    }

    /**
     * @return the peruntukan
     */
    public String getPeruntukan() {
        return peruntukan;
    }

    /**
     * @param kodePeruntukan the peruntukan to set
     */
    public void setPeruntukan(String kodePeruntukan) {
        this.peruntukan = kodePeruntukan;
    }

    /**
     * @return the luas
     */
    public double getLuas() {
        return luas;
    }

    /**
     * @param luas the luas to set
     */
    public void setLuas(double luas) {
        this.luas = luas;
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
    
}
