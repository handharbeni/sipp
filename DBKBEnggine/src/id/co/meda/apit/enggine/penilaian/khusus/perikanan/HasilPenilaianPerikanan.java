/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class HasilPenilaianPerikanan {
    
    private String nop;
    private String tahun;
    
    private NilaiBangunanIkan BangunanIkan;
    private ArrayList<NilaiTanahIkan> arrTanahIkan;
    private ArrayList<NilaiPendapatanIkan> arrPendapatanIkan;
    
    
    private double njopTanah;
    private double njopBangunan;
    private double njopPerikanan;

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
     * @return the arrBangunanIkan
     */
    public NilaiBangunanIkan getBangunanIkan() {
        return BangunanIkan;
    }

    /**
     * @param arrBangunanIkan the arrBangunanIkan to set
     */
    public void setBangunanIkan(NilaiBangunanIkan BangunanIkan) {
        this.BangunanIkan = BangunanIkan;
    }

    /**
     * @return the arrTanahIkan
     */
    public ArrayList<NilaiTanahIkan> getArrTanahIkan() {
        return arrTanahIkan;
    }

    /**
     * @param arrTanahIkan the arrTanahIkan to set
     */
    public void setArrTanahIkan(ArrayList<NilaiTanahIkan> arrTanahIkan) {
        this.arrTanahIkan = arrTanahIkan;
    }

    /**
     * @return the arrPendapatanIkan
     */
    public ArrayList<NilaiPendapatanIkan> getArrPendapatanIkan() {
        return arrPendapatanIkan;
    }

    /**
     * @param arrPendapatanIkan the arrPendapatanIkan to set
     */
    public void setArrPendapatanIkan(ArrayList<NilaiPendapatanIkan> arrPendapatanIkan) {
        this.arrPendapatanIkan = arrPendapatanIkan;
    }

    /**
     * @return the njopTanah
     */
    public double getNjopTanah() {
        return njopTanah;
    }

    /**
     * @param njopTanah the njopTanah to set
     */
    public void setNjopTanah(double njopTanah) {
        this.njopTanah = njopTanah;
    }

    /**
     * @return the njopBangunan
     */
    public double getNjopBangunan() {
        return njopBangunan;
    }

    /**
     * @param njopBangunan the njopBangunan to set
     */
    public void setNjopBangunan(double njopBangunan) {
        this.njopBangunan = njopBangunan;
    }

    /**
     * @return the njopPerikanan
     */
    public double getNjopPerikanan() {
        return njopPerikanan;
    }

    /**
     * @param njopPerikanan the njopPerikanan to set
     */
    public void setNjopPerikanan(double njopPerikanan) {
        this.njopPerikanan = njopPerikanan;
    }

    
}
