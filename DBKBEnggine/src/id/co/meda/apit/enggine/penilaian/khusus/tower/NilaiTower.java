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
public class NilaiTower {
    private String thnPenilaian;
    private String nop;
    private String bngKe;
    private String thnBangun;
    private String thnRenov;
    private String tipe;
    private Integer tinggi;
    private Double nilaiTowerSblmSusut;
    private Double persenPenyusutan;

    
    public Double getNilaiTower() {
        return getNilaiTowerSblmSusut()-getNilaiSusut();
    }
    
    public Double getNilaiSusut() {
        return getNilaiTowerSblmSusut()*getPersenPenyusutan();
    }
    
    /**
     * @return the thnPenilaian
     */
    public String getThnPenilaian() {
        return thnPenilaian;
    }

    /**
     * @param thnPenilaian the thnPenilaian to set
     */
    public void setThnPenilaian(String thnPenilaian) {
        this.thnPenilaian = thnPenilaian;
    }

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
     * @return the bngKe
     */
    public String getBngKe() {
        return bngKe;
    }

    /**
     * @param bngKe the bngKe to set
     */
    public void setBngKe(String bngKe) {
        this.bngKe = bngKe;
    }

    /**
     * @return the thnBangun
     */
    public String getThnBangun() {
        return thnBangun;
    }

    /**
     * @param thnBangun the thnBangun to set
     */
    public void setThnBangun(String thnBangun) {
        this.thnBangun = thnBangun;
    }

    /**
     * @return the thnRenov
     */
    public String getThnRenov() {
        return thnRenov;
    }

    /**
     * @param thnRenov the thnRenov to set
     */
    public void setThnRenov(String thnRenov) {
        this.thnRenov = thnRenov;
    }

    /**
     * @return the tipe
     */
    public String getTipe() {
        return tipe;
    }

    /**
     * @param tipe the tipe to set
     */
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /**
     * @return the tinggi
     */
    public Integer getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(Integer tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the nilaiTowerSblmSusut
     */
    public Double getNilaiTowerSblmSusut() {
        return nilaiTowerSblmSusut;
    }

    /**
     * @param nilaiTowerSblmSusut the nilaiTowerSblmSusut to set
     */
    public void setNilaiTowerSblmSusut(Double nilaiTowerSblmSusut) {
        this.nilaiTowerSblmSusut = nilaiTowerSblmSusut;
    }

    /**
     * @return the persenPenyusutan
     */
    public Double getPersenPenyusutan() {
        return persenPenyusutan;
    }

    /**
     * @param persenPenyusutan the persenPenyusutan to set
     */
    public void setPersenPenyusutan(Double persenPenyusutan) {
        this.persenPenyusutan = persenPenyusutan;
    }
    
    
}
