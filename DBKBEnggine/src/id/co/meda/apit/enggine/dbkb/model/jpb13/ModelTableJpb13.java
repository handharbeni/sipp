/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.jpb13;

import id.co.meda.apit.enggine.dbkb.model.jpb13.ItemHitungan;
import java.util.HashMap;

/**
 *
 * @author meda
 */
public class ModelTableJpb13 {
    
    private HashMap<String,ItemHitungan> subStruktur = new HashMap<String,ItemHitungan>();
    private HashMap<String,ItemHitungan> superStruktur = new HashMap<String,ItemHitungan>();
    private HashMap<String,ItemHitungan> preliminaries = new HashMap<String,ItemHitungan>();
    private double totalCostSubStruktur = 0;
    private double totalCostSuperStruktur = 0;
    private double totalCostPreliminaries = 0;
    private double jumlah = 0;
    private double ppnfee = 0;
    private double imb = 0;
    private double jmlhPekSubSuperStruktur = 0;
    private double luasBangunan = 0;
    private double nilaiDBKB = 0;
    private double nilaiSanitary = 0;
   
    
    
    private String tahunDBKB;
    
    public ModelTableJpb13(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }

    /**
     * @return the subStruktur
     */
    public HashMap<String,ItemHitungan> getSubStruktur() {
        return subStruktur;
    }

    /**
     * @param subStruktur the subStruktur to set
     */
    public void setSubStruktur(HashMap<String,ItemHitungan> subStruktur) {
        this.subStruktur = subStruktur;
    }

    /**
     * @return the superStruktur
     */
    public HashMap<String,ItemHitungan> getSuperStruktur() {
        return superStruktur;
    }

    /**
     * @param superStruktur the superStruktur to set
     */
    public void setSuperStruktur(HashMap<String,ItemHitungan> superStruktur) {
        this.superStruktur = superStruktur;
    }

    /**
     * @return the preliminaries
     */
    public HashMap<String,ItemHitungan> getPreliminaries() {
        return preliminaries;
    }

    /**
     * @param preliminaries the preliminaries to set
     */
    public void setPreliminaries(HashMap<String,ItemHitungan> preliminaries) {
        this.preliminaries = preliminaries;
    }

    /**
     * @return the totalCostSubStruktur
     */
    public double getTotalCostSubStruktur() {
        return totalCostSubStruktur;
    }

    /**
     * @param totalCostSubStruktur the totalCostSubStruktur to set
     */
    public void setTotalCostSubStruktur(double totalCostSubStruktur) {
        this.totalCostSubStruktur = totalCostSubStruktur;
    }

    /**
     * @return the totalCostSuperStruktur
     */
    public double getTotalCostSuperStruktur() {
        return totalCostSuperStruktur;
    }

    /**
     * @param totalCostSuperStruktur the totalCostSuperStruktur to set
     */
    public void setTotalCostSuperStruktur(double totalCostSuperStruktur) {
        this.totalCostSuperStruktur = totalCostSuperStruktur;
    }

    /**
     * @return the totalCostPreliminaries
     */
    public double getTotalCostPreliminaries() {
        return totalCostPreliminaries;
    }

    /**
     * @param totalCostPreliminaries the totalCostPreliminaries to set
     */
    public void setTotalCostPreliminaries(double totalCostPreliminaries) {
        this.totalCostPreliminaries = totalCostPreliminaries;
    }

    /**
     * @return the jumlah
     */
    public double getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the ppnfee
     */
    public double getPpnfee() {
        return ppnfee;
    }

    /**
     * @param ppnfee the ppnfee to set
     */
    public void setPpnfee(double ppnfee) {
        this.ppnfee = ppnfee;
    }

    /**
     * @return the imb
     */
    public double getImb() {
        return imb;
    }

    /**
     * @param imb the imb to set
     */
    public void setImb(double imb) {
        this.imb = imb;
    }

    /**
     * @return the jmlhPekSubSuperStruktur
     */
    public double getJmlhPekSubSuperStruktur() {
        return jmlhPekSubSuperStruktur;
    }

    /**
     * @param jmlhPekSubSuperStruktur the jmlhPekSubSuperStruktur to set
     */
    public void setJmlhPekSubSuperStruktur(double jmlhPekSubSuperStruktur) {
        this.jmlhPekSubSuperStruktur = jmlhPekSubSuperStruktur;
    }

    /**
     * @return the luasBangunan
     */
    public double getLuasBangunan() {
        return luasBangunan;
    }

    /**
     * @param luasBangunan the luasBangunan to set
     */
    public void setLuasBangunan(double luasBangunan) {
        this.luasBangunan = luasBangunan;
    }

    /**
     * @return the nilaiDBKB
     */
    public double getNilaiDBKB() {
        return nilaiDBKB;
    }

    /**
     * @param nilaiDBKB the nilaiDBKB to set
     */
    public void setNilaiDBKB(double nilaiDBKB) {
        this.nilaiDBKB = nilaiDBKB;
    }

    /**
     * @return the nilaiSanitary
     */
    public double getNilaiSanitary() {
        return nilaiSanitary;
    }

    /**
     * @param nilaiSanitary the nilaiSanitary to set
     */
    public void setNilaiSanitary(double nilaiSanitary) {
        this.nilaiSanitary = nilaiSanitary;
    }
    
    
}
