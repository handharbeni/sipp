/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.util.ArrayList;

/**
 * Class ini khusus untuk bangunan ikan
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianIkanUmumBng <T> {
    
    private String nop;
    private String alamatOP;
    private String namaWp;
    private String noIzin;
    private String tahun;
    private ArrayList<LaporanPenilaianRingkas> arrNilai;
    private ArrayList<LaporanPenilaianIkanBngRingkas> objIkan; 
    private String njop;

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
     * @return the alamatOP
     */
    public String getAlamatOP() {
        return alamatOP;
    }

    /**
     * @param alamatOP the alamatOP to set
     */
    public void setAlamatOP(String alamatOP) {
        this.alamatOP = alamatOP;
    }

    /**
     * @return the namaWp
     */
    public String getNamaWp() {
        return namaWp;
    }

    /**
     * @param namaWp the namaWp to set
     */
    public void setNamaWp(String namaWp) {
        this.namaWp = namaWp;
    }

    /**
     * @return the noIzin
     */
    public String getNoIzin() {
        return noIzin;
    }

    /**
     * @param noIzin the noIzin to set
     */
    public void setNoIzin(String noIzin) {
        this.noIzin = noIzin;
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
     * @return the arrNilai
     */
    public ArrayList<LaporanPenilaianRingkas> getArrNilai() {
        return arrNilai;
    }

    /**
     * @param arrNilai the arrNilai to set
     */
    public void setArrNilai(ArrayList<LaporanPenilaianRingkas> arrNilai) {
        this.arrNilai = arrNilai;
    }

    /**
     * @return the objIkan
     */
    public ArrayList<LaporanPenilaianIkanBngRingkas> getObjIkan() {
        return objIkan;
    }

    /**
     * @param objIkan the objIkan to set
     */
    public void setObjIkan(ArrayList<LaporanPenilaianIkanBngRingkas> objIkan) {
        this.objIkan = objIkan;
    }

    /**
     * @return the njop
     */
    public String getNjop() {
        return njop;
    }

    /**
     * @param njop the njop to set
     */
    public void setNjop(String njop) {
        this.njop = njop;
    }

   
}
