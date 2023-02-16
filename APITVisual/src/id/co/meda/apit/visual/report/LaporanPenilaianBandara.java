/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianBandara {
    
    private String nop;
    private String namaBandara;
    private String alamatBandara;
    private String tahun;
    
    private String JabKadis;
    private String NamaKadis;
    private String NipKadis;
    private String JabUptd;
    private String NamaUptd;
    private String NipUptd;
    private String JabPenilai;
    private String NamaPenilai;
    private String NipPenilai;
    
    private String namaPemDaerah;
    private String dinasDaerah;
    private String alamatDinas;
    
    private ArrayList<LaporanTanahBandara> arrPenilTanah;
    private ArrayList<LaporanBngKhususBandara> arrPenilBngKhusus;
    private ArrayList<LaporanLspopBandara> arrLspopBandara;
    private ArrayList<LaporanBngPTBandara> arrBngPTBandara;
    private ArrayList<LaporanRingkasanBandara> ringkasBandara;

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
     * @return the namaBandara
     */
    public String getNamaBandara() {
        return namaBandara;
    }

    /**
     * @param namaBandara the namaBandara to set
     */
    public void setNamaBandara(String namaBandara) {
        this.namaBandara = namaBandara;
    }

    /**
     * @return the alamatBandara
     */
    public String getAlamatBandara() {
        return alamatBandara;
    }

    /**
     * @param alamatBandara the alamatBandara to set
     */
    public void setAlamatBandara(String alamatBandara) {
        this.alamatBandara = alamatBandara;
    }

    /**
     * @return the arrPenilTanah
     */
    public ArrayList<LaporanTanahBandara> getArrPenilTanah() {
        return arrPenilTanah;
    }

    /**
     * @param arrPenilTanah the arrPenilTanah to set
     */
    public void setArrPenilTanah(ArrayList<LaporanTanahBandara> arrPenilTanah) {
        this.arrPenilTanah = arrPenilTanah;
    }

    /**
     * @return the arrPenilBngKhusus
     */
    public ArrayList<LaporanBngKhususBandara> getArrPenilBngKhusus() {
        return arrPenilBngKhusus;
    }

    /**
     * @param arrPenilBngKhusus the arrPenilBngKhusus to set
     */
    public void setArrPenilBngKhusus(ArrayList<LaporanBngKhususBandara> arrPenilBngKhusus) {
        this.arrPenilBngKhusus = arrPenilBngKhusus;
    }

    /**
     * @return the arrLspopBandara
     */
    public ArrayList<LaporanLspopBandara> getArrLspopBandara() {
        return arrLspopBandara;
    }

    /**
     * @param arrLspopBandara the arrLspopBandara to set
     */
    public void setArrLspopBandara(ArrayList<LaporanLspopBandara> arrLspopBandara) {
        this.arrLspopBandara = arrLspopBandara;
    }

    /**
     * @return the arrBngPTBandara
     */
    public ArrayList<LaporanBngPTBandara> getArrBngPTBandara() {
        return arrBngPTBandara;
    }

    /**
     * @param arrBngPTBandara the arrBngPTBandara to set
     */
    public void setArrBngPTBandara(ArrayList<LaporanBngPTBandara> arrBngPTBandara) {
        this.arrBngPTBandara = arrBngPTBandara;
    }

    /**
     * @return the ringkasBandara
     */
    public ArrayList<LaporanRingkasanBandara> getRingkasBandara() {
        return ringkasBandara;
    }

    /**
     * @param ringkasBandara the ringkasBandara to set
     */
    public void setRingkasBandara(ArrayList<LaporanRingkasanBandara> ringkasBandara) {
        this.ringkasBandara = ringkasBandara;
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
     * @return the NamaKadis
     */
    public String getNamaKadis() {
        return NamaKadis;
    }

    /**
     * @param NamaKadis the NamaKadis to set
     */
    public void setNamaKadis(String NamaKadis) {
        this.NamaKadis = NamaKadis;
    }

    /**
     * @return the NipKadis
     */
    public String getNipKadis() {
        return NipKadis;
    }

    /**
     * @param NipKadis the NipKadis to set
     */
    public void setNipKadis(String NipKadis) {
        this.NipKadis = NipKadis;
    }

    /**
     * @return the NamaUptd
     */
    public String getNamaUptd() {
        return NamaUptd;
    }

    /**
     * @param NamaUptd the NamaUptd to set
     */
    public void setNamaUptd(String NamaUptd) {
        this.NamaUptd = NamaUptd;
    }

    /**
     * @return the NipUptd
     */
    public String getNipUptd() {
        return NipUptd;
    }

    /**
     * @param NipUptd the NipUptd to set
     */
    public void setNipUptd(String NipUptd) {
        this.NipUptd = NipUptd;
    }

    /**
     * @return the NamaPenilai
     */
    public String getNamaPenilai() {
        return NamaPenilai;
    }

    /**
     * @param NamaPenilai the NamaPenilai to set
     */
    public void setNamaPenilai(String NamaPenilai) {
        this.NamaPenilai = NamaPenilai;
    }

    /**
     * @return the NipPenilai
     */
    public String getNipPenilai() {
        return NipPenilai;
    }

    /**
     * @param NipPenilai the NipPenilai to set
     */
    public void setNipPenilai(String NipPenilai) {
        this.NipPenilai = NipPenilai;
    }

    /**
     * @return the namaPemDaerah
     */
    public String getNamaPemDaerah() {
        return namaPemDaerah;
    }

    /**
     * @param namaPemDaerah the namaPemDaerah to set
     */
    public void setNamaPemDaerah(String namaPemDaerah) {
        this.namaPemDaerah = namaPemDaerah;
    }

    /**
     * @return the dinasDaerah
     */
    public String getDinasDaerah() {
        return dinasDaerah;
    }

    /**
     * @param dinasDaerah the dinasDaerah to set
     */
    public void setDinasDaerah(String dinasDaerah) {
        this.dinasDaerah = dinasDaerah;
    }

    /**
     * @return the alamatDinas
     */
    public String getAlamatDinas() {
        return alamatDinas;
    }

    /**
     * @param alamatDinas the alamatDinas to set
     */
    public void setAlamatDinas(String alamatDinas) {
        this.alamatDinas = alamatDinas;
    }

    /**
     * @return the JabKadis
     */
    public String getJabKadis() {
        return JabKadis;
    }

    /**
     * @param JabKadis the JabKadis to set
     */
    public void setJabKadis(String JabKadis) {
        this.JabKadis = JabKadis;
    }

    /**
     * @return the JabUptd
     */
    public String getJabUptd() {
        return JabUptd;
    }

    /**
     * @param JabUptd the JabUptd to set
     */
    public void setJabUptd(String JabUptd) {
        this.JabUptd = JabUptd;
    }

    /**
     * @return the JabPenilai
     */
    public String getJabPenilai() {
        return JabPenilai;
    }

    /**
     * @param JabPenilai the JabPenilai to set
     */
    public void setJabPenilai(String JabPenilai) {
        this.JabPenilai = JabPenilai;
    }

   
    
    
    
    
}
