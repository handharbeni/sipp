/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.pelabuhan;

/**
 *
 * @author I Putu Medagia A
 */
public class ItemAnalisisHargaSatuan {
    
    private String id;
    private String jenisPekerjaan;
    private String satuan;
    private double volume;
    private double hrg_bahan;
    private double hrg_upah;
    private double hrg_jumlah;
    private double hrg_total;

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
     * @return the hrg_bahan
     */
    public double getHrg_bahan() {
        return hrg_bahan;
    }

    /**
     * @param hrg_bahan the hrg_bahan to set
     */
    public void setHrg_bahan(double hrg_bahan) {
        this.hrg_bahan = hrg_bahan;
    }

    /**
     * @return the hrg_upah
     */
    public double getHrg_upah() {
        return hrg_upah;
    }

    /**
     * @param hrg_upah the hrg_upah to set
     */
    public void setHrg_upah(double hrg_upah) {
        this.hrg_upah = hrg_upah;
    }

    /**
     * @return the hrg_jumlah
     */
    public double getHrg_jumlah() {
        return hrg_jumlah;
    }

    /**
     * @param hrg_jumlah the hrg_jumlah to set
     */
    public void setHrg_jumlah(double hrg_jumlah) {
        this.hrg_jumlah = hrg_jumlah;
    }

    /**
     * @return the hrg_total
     */
    public double getHrg_total() {
        return hrg_total;
    }

    /**
     * @param hrg_total the hrg_total to set
     */
    public void setHrg_total(double hrg_total) {
        this.hrg_total = hrg_total;
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
