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
public class LspopNonStandar {
    private String Nop;
    private String BngKe;
    private String Jpb;
    private String Kondisi;
    private String ThnBangun;
    private String ThnRenov;
    private Integer JmlLtBng;
    private Integer JmlLtBase;
    private Double LsBngUtama;
    private Double LsBngLain;
    private Double LsBase;
    private String Konstruksi;
    private String DinDalamStr;
    private String DinDalamBsm;
    private Integer DinLuarKacaJmlLt;
    private Integer DinLuarPasBatuJmlLt;
    private Integer DinLuarSengJmlLt;
    private Integer DinLuarCelconJmlLt;
    private Integer DinLuarBetonJmlLt;
    private Integer DinLuarKayuJmlLt;
    private Integer PelDalamKacaImporStrJmlLt;
    private Integer PelDalamKacaImporBsmJmlLt;
    private Integer PelDalamKacaLokalStrJmlLt;
    private Integer PelDalamKacaLokalBsmJmlLt;
    private Integer PelDalamMarmerImporStrJmlLt;
    private Integer PelDalamMarmerImporBsmJmlLt;
    private Integer PelDalamMarmerLokalStrJmlLt;
    private Integer PelDalamMarmerLokalBsmJmlLt;
    private Integer PelDalamCatStrJmlLt;
    private Integer PelDalamCatBsmJmlLt;
    private Integer PelDalamWallpaperStrJmlLt;
    private Integer PelDalamWallpaperBsmJmlLt;
    private Integer PelDalamGranitImporStrJmlLt;
    private Integer PelDalamGranitImporBsmJmlLt;
    private Integer PelDalamGranitLokalStrJmlLt;
    private Integer PelDalamGranitLokalBsmJmlLt;
    private Integer PelDalamKeramikStdStrJmlLt;
    private Integer PelDalamKeramikStdBsmJmlLt;
    private Integer PelLuarGranitImporJmlLt;
    private Integer PelLuarKacaImporJmlLt;
    private Integer PelLuarMarmerLokalJmlLt;
    private Integer PelLuarKeramikStdJmlLt;
    private Integer PelLuarMarmerImporJmlLt;
    private Integer PelLuarGranitLokalJmlLt;
    private Integer PelLuarKacaLokalJmlLt;
    private Integer PelLuarCatJmlLt;
    private Integer LangitGipsumStrJmlLt;
    private Integer LangitGipsumBsmJmlLt;
    private Integer LangitTriplekStrJmlLt;
    private Integer LangitTriplekBsmJmlLt;
    private Integer LangitAkustikStrJmlLt;
    private Integer LangitAkustikBsmJmlLt;
    private Integer LangitEternitStrJmlLt;
    private Integer LangitEternitBsmJmlLt;
    private String Atap;
    private Integer LantaiGranitImporStrJmlLt;
    private Integer LantaiGranitImporBsmJmlLt;
    private Integer LantaiMarmerLokalStrJmlLt;
    private Integer LantaiMarmerLokalBsmJmlLt;
    private Integer LantaiMarmerImporStrJmlLt;
    private Integer LantaiMarmerImporBsmJmlLt;
    private Integer LantaiKarpetImporStrJmlLt;
    private Integer LantaiKarpetImporBsmJmlLt;
    private Integer LantaiVinilStrJmlLt;
    private Integer LantaiVinilBsmJmlLt;
    private Integer LantaiKayuStrJmlLt;
    private Integer LantaiKayuBsmJmlLt;
    private Integer LantaiTerasoStrJmlLt;
    private Integer LantaiTerasoBsmJmlLt;
    private Integer LantaiGranitLokalStrJmlLt;
    private Integer LantaiGranitLokalBsmJmlLt;
    private Integer LantaiKeramikStdStrJmlLt;
    private Integer LantaiKeramikStdBsmJmlLt;
    private Integer LantaiKarpetLokalStrJmlLt;
    private Integer LantaiKarpetLokalBsmJmlLt;
    private Integer LantaiUbinStrJmlLt;
    private Integer LantaiUbinBsmJmlLt;
    private Integer LantaiSemenStrJmlLt;
    private Integer LantaiSemenBsmJmlLt;
    private Integer AcSplitJml;
    private String AcSplitPk;
    private Integer AcWindowJml;
    private String AcWindowPk;
    private Integer AcFloorJml;
    private String AcFloorPk;
    
    private boolean AcSentral;
    private String AcSentralStr;
    
    private Integer LiftPenumpangJml;
    private Integer LiftBarangJml;
    private Integer EskalatorLess08Jml;
    private Integer EskalatorGreat08Jml;
    private Double PagarBatakoPanjang;
    private Double PagarBatakoTinggi;
    private Double PagarBataPanjang;
    private Double PagarBataTinggi;    
    private Double PagarBetonPanjang;
    private Double PagarBetonTinggi;    
    private Double PagarBesiPanjang;
    private Double PagarBesiTinggi;    
    private Double PagarBrcPanjang;
    private Double PagarBrcTinggi;    
    private Double TvMatvLuas;
    private Integer TvMatvJmlLt;    
    private Double TvCctvLuas;
    private Integer TvCctvJmlLt;     
    
    private boolean Hydrant;
    private boolean Sprinkler;     
    private boolean Alarm;
    private boolean Interkom;     
    private boolean AirPanas;
    private boolean Reservoir;
    
    private String ReservoirStr;
    private String AirPanasStr;
    private String InterkomStr;     
    private String AlarmStr;
    private String HydrantStr; 
    private String SprinklerStr;     
    
    private Integer JmlPabx;
    private Integer DayaListrik;
    private Double VideoInterkomLuas;
    private Integer VideoInterkomJmlLt;
    private Double SumurArtesis;
    
    private boolean PenangkalPetir;
    private boolean PengolahLimbah;
    private boolean TataSuara;
    
    private String TataSuaraStr;
    private String PengolahLimbahStr;
    private String PenangkalPetirStr;
    
    private Double KolamRenangLs;
    private String KolamRenangFinish;
    private Integer LapTenisBetonLampuJml;
    private Integer LapTenisAspalLampuJml;
    private Integer LapTenisTanahLampuJml;
    private Integer LapTenisBetonNoLampuJml;
    private Integer LapTenisAspalNoLampuJml;
    private Integer LapTenisTanahNoLampuJml;
    private Double PerkerasanRinganLs;
    private Double PerkerasanSedangLs;
    private Double PerkerasanKerasLs;
    private Integer Jpb38TinggiKolom;
    private Integer Jpb38LebarBentang;
    private Double Jpb38LantaiDyDkg;
    private String Jpb38LantaiTipe;
    private Double Jpb38LsMezzanin;
    private Integer Jpb14JmlKanopi;
    private String Jpb15Posisi;
    private Double Jpb15Kapasitas;

    public LspopNonStandar() {}
    
    public LspopNonStandar(String Nop, String BngKe) {
        this.Nop = Nop;
        this.BngKe = BngKe;
    }
    
    
    /**
     * @return the Nop
     */
    public String getNop() {
        return Nop;
    }

    /**
     * @param Nop the Nop to set
     */
    public void setNop(String Nop) {
        this.Nop = Nop;
    }


    /**
     * @return the Jpb
     */
    public String getJpb() {
        return Jpb;
    }

    /**
     * @param Jpb the Jpb to set
     */
    public void setJpb(String Jpb) {
        this.Jpb = Jpb;
    }

    /**
     * @return the Kondisi
     */
    public String getKondisi() {
        return Kondisi;
    }

    /**
     * @param Kondisi the Kondisi to set
     */
    public void setKondisi(String Kondisi) {
        this.Kondisi = Kondisi;
    }

    /**
     * @return the ThnBangun
     */
    public String getThnBangun() {
        return ThnBangun;
    }

    /**
     * @param ThnBangun the ThnBangun to set
     */
    public void setThnBangun(String ThnBangun) {
        this.ThnBangun = ThnBangun;
    }

    /**
     * @return the ThnRenov
     */
    public String getThnRenov() {
        return ThnRenov;
    }

    /**
     * @param ThnRenov the ThnRenov to set
     */
    public void setThnRenov(String ThnRenov) {
        this.ThnRenov = ThnRenov;
    }

    /**
     * @return the JmlLtBng
     */
    public Integer getJmlLtBng() {
        return JmlLtBng;
    }

    /**
     * @param JmlLtBng the JmlLtBng to set
     */
    public void setJmlLtBng(Integer JmlLtBng) {
        this.JmlLtBng = JmlLtBng;
    }

    /**
     * @return the JmlLtBase
     */
    public Integer getJmlLtBase() {
        return JmlLtBase;
    }

    /**
     * @param JmlLtBase the JmlLtBase to set
     */
    public void setJmlLtBase(Integer JmlLtBase) {
        this.JmlLtBase = JmlLtBase;
    }

    /**
     * @return the LsBngUtama
     */
    public Double getLsBngUtama() {
        return LsBngUtama;
    }

    /**
     * @param LsBngUtama the LsBngUtama to set
     */
    public void setLsBngUtama(Double LsBngUtama) {
        this.LsBngUtama = LsBngUtama;
    }

    /**
     * @return the LsBngLain
     */
    public Double getLsBngLain() {
        return LsBngLain;
    }

    /**
     * @param LsBngLain the LsBngLain to set
     */
    public void setLsBngLain(Double LsBngLain) {
        this.LsBngLain = LsBngLain;
    }

    /**
     * @return the LsBase
     */
    public Double getLsBase() {
        return LsBase;
    }

    /**
     * @param LsBase the LsBase to set
     */
    public void setLsBase(Double LsBase) {
        this.LsBase = LsBase;
    }

    /**
     * @return the Konstruksi
     */
    public String getKonstruksi() {
        return Konstruksi;
    }

    /**
     * @param Konstruksi the Konstruksi to set
     */
    public void setKonstruksi(String Konstruksi) {
        this.Konstruksi = Konstruksi;
    }

    /**
     * @return the DinDalamStr
     */
    public String getDinDalamStr() {
        return DinDalamStr;
    }

    /**
     * @param DinDalamStr the DinDalamStr to set
     */
    public void setDinDalamStr(String DinDalamStr) {
        this.DinDalamStr = DinDalamStr;
    }

    /**
     * @return the DinDalamBsm
     */
    public String getDinDalamBsm() {
        return DinDalamBsm;
    }

    /**
     * @param DinDalamBsm the DinDalamBsm to set
     */
    public void setDinDalamBsm(String DinDalamBsm) {
        this.DinDalamBsm = DinDalamBsm;
    }

    /**
     * @return the DinLuarKacaJmlLt
     */
    public Integer getDinLuarKacaJmlLt() {
        return DinLuarKacaJmlLt;
    }

    /**
     * @param DinLuarKacaJmlLt the DinLuarKacaJmlLt to set
     */
    public void setDinLuarKacaJmlLt(Integer DinLuarKacaJmlLt) {
        this.DinLuarKacaJmlLt = DinLuarKacaJmlLt;
    }

    /**
     * @return the DinLuarPasBatuJmlLt
     */
    public Integer getDinLuarPasBatuJmlLt() {
        return DinLuarPasBatuJmlLt;
    }

    /**
     * @param DinLuarPasBatuJmlLt the DinLuarPasBatuJmlLt to set
     */
    public void setDinLuarPasBatuJmlLt(Integer DinLuarPasBatuJmlLt) {
        this.DinLuarPasBatuJmlLt = DinLuarPasBatuJmlLt;
    }

    /**
     * @return the DinLuarSengJmlLt
     */
    public Integer getDinLuarSengJmlLt() {
        return DinLuarSengJmlLt;
    }

    /**
     * @param DinLuarSengJmlLt the DinLuarSengJmlLt to set
     */
    public void setDinLuarSengJmlLt(Integer DinLuarSengJmlLt) {
        this.DinLuarSengJmlLt = DinLuarSengJmlLt;
    }

    /**
     * @return the DinLuarCelconJmlLt
     */
    public Integer getDinLuarCelconJmlLt() {
        return DinLuarCelconJmlLt;
    }

    /**
     * @param DinLuarCelconJmlLt the DinLuarCelconJmlLt to set
     */
    public void setDinLuarCelconJmlLt(Integer DinLuarCelconJmlLt) {
        this.DinLuarCelconJmlLt = DinLuarCelconJmlLt;
    }

    /**
     * @return the DinLuarBetonJmlLt
     */
    public Integer getDinLuarBetonJmlLt() {
        return DinLuarBetonJmlLt;
    }

    /**
     * @param DinLuarBetonJmlLt the DinLuarBetonJmlLt to set
     */
    public void setDinLuarBetonJmlLt(Integer DinLuarBetonJmlLt) {
        this.DinLuarBetonJmlLt = DinLuarBetonJmlLt;
    }

    /**
     * @return the DinLuarKayuJmlLt
     */
    public Integer getDinLuarKayuJmlLt() {
        return DinLuarKayuJmlLt;
    }

    /**
     * @param DinLuarKayuJmlLt the DinLuarKayuJmlLt to set
     */
    public void setDinLuarKayuJmlLt(Integer DinLuarKayuJmlLt) {
        this.DinLuarKayuJmlLt = DinLuarKayuJmlLt;
    }

    /**
     * @return the PelDalamKacaImporStrJmlLt
     */
    public Integer getPelDalamKacaImporStrJmlLt() {
        return PelDalamKacaImporStrJmlLt;
    }

    /**
     * @param PelDalamKacaImporStrJmlLt the PelDalamKacaImporStrJmlLt to set
     */
    public void setPelDalamKacaImporStrJmlLt(Integer PelDalamKacaImporStrJmlLt) {
        this.PelDalamKacaImporStrJmlLt = PelDalamKacaImporStrJmlLt;
    }

    /**
     * @return the PelDalamKacaImporBsmJmlLt
     */
    public Integer getPelDalamKacaImporBsmJmlLt() {
        return PelDalamKacaImporBsmJmlLt;
    }

    /**
     * @param PelDalamKacaImporBsmJmlLt the PelDalamKacaImporBsmJmlLt to set
     */
    public void setPelDalamKacaImporBsmJmlLt(Integer PelDalamKacaImporBsmJmlLt) {
        this.PelDalamKacaImporBsmJmlLt = PelDalamKacaImporBsmJmlLt;
    }

    /**
     * @return the PelDalamKacaLokalStrJmlLt
     */
    public Integer getPelDalamKacaLokalStrJmlLt() {
        return PelDalamKacaLokalStrJmlLt;
    }

    /**
     * @param PelDalamKacaLokalStrJmlLt the PelDalamKacaLokalStrJmlLt to set
     */
    public void setPelDalamKacaLokalStrJmlLt(Integer PelDalamKacaLokalStrJmlLt) {
        this.PelDalamKacaLokalStrJmlLt = PelDalamKacaLokalStrJmlLt;
    }

    /**
     * @return the PelDalamKacaLokalBsmJmlLt
     */
    public Integer getPelDalamKacaLokalBsmJmlLt() {
        return PelDalamKacaLokalBsmJmlLt;
    }

    /**
     * @param PelDalamKacaLokalBsmJmlLt the PelDalamKacaLokalBsmJmlLt to set
     */
    public void setPelDalamKacaLokalBsmJmlLt(Integer PelDalamKacaLokalBsmJmlLt) {
        this.PelDalamKacaLokalBsmJmlLt = PelDalamKacaLokalBsmJmlLt;
    }

    /**
     * @return the PelDalamMarmerImporStrJmlLt
     */
    public Integer getPelDalamMarmerImporStrJmlLt() {
        return PelDalamMarmerImporStrJmlLt;
    }

    /**
     * @param PelDalamMarmerImporStrJmlLt the PelDalamMarmerImporStrJmlLt to set
     */
    public void setPelDalamMarmerImporStrJmlLt(Integer PelDalamMarmerImporStrJmlLt) {
        this.PelDalamMarmerImporStrJmlLt = PelDalamMarmerImporStrJmlLt;
    }

    /**
     * @return the PelDalamMarmerImporBsmJmlLt
     */
    public Integer getPelDalamMarmerImporBsmJmlLt() {
        return PelDalamMarmerImporBsmJmlLt;
    }

    /**
     * @param PelDalamMarmerImporBsmJmlLt the PelDalamMarmerImporBsmJmlLt to set
     */
    public void setPelDalamMarmerImporBsmJmlLt(Integer PelDalamMarmerImporBsmJmlLt) {
        this.PelDalamMarmerImporBsmJmlLt = PelDalamMarmerImporBsmJmlLt;
    }

    /**
     * @return the PelDalamCatStrJmlLt
     */
    public Integer getPelDalamCatStrJmlLt() {
        return PelDalamCatStrJmlLt;
    }

    /**
     * @param PelDalamCatStrJmlLt the PelDalamCatStrJmlLt to set
     */
    public void setPelDalamCatStrJmlLt(Integer PelDalamCatStrJmlLt) {
        this.PelDalamCatStrJmlLt = PelDalamCatStrJmlLt;
    }

    /**
     * @return the PelDalamCatBsmJmlLt
     */
    public Integer getPelDalamCatBsmJmlLt() {
        return PelDalamCatBsmJmlLt;
    }

    /**
     * @param PelDalamCatBsmJmlLt the PelDalamCatBsmJmlLt to set
     */
    public void setPelDalamCatBsmJmlLt(Integer PelDalamCatBsmJmlLt) {
        this.PelDalamCatBsmJmlLt = PelDalamCatBsmJmlLt;
    }

    /**
     * @return the PelDalamWallpaperStrJmlLt
     */
    public Integer getPelDalamWallpaperStrJmlLt() {
        return PelDalamWallpaperStrJmlLt;
    }

    /**
     * @param PelDalamWallpaperStrJmlLt the PelDalamWallpaperStrJmlLt to set
     */
    public void setPelDalamWallpaperStrJmlLt(Integer PelDalamWallpaperStrJmlLt) {
        this.PelDalamWallpaperStrJmlLt = PelDalamWallpaperStrJmlLt;
    }

    /**
     * @return the PelDalamWallpaperBsmJmlLt
     */
    public Integer getPelDalamWallpaperBsmJmlLt() {
        return PelDalamWallpaperBsmJmlLt;
    }

    /**
     * @param PelDalamWallpaperBsmJmlLt the PelDalamWallpaperBsmJmlLt to set
     */
    public void setPelDalamWallpaperBsmJmlLt(Integer PelDalamWallpaperBsmJmlLt) {
        this.PelDalamWallpaperBsmJmlLt = PelDalamWallpaperBsmJmlLt;
    }

    /**
     * @return the PelDalamGranitImporStrJmlLt
     */
    public Integer getPelDalamGranitImporStrJmlLt() {
        return PelDalamGranitImporStrJmlLt;
    }

    /**
     * @param PelDalamGranitImporStrJmlLt the PelDalamGranitImporStrJmlLt to set
     */
    public void setPelDalamGranitImporStrJmlLt(Integer PelDalamGranitImporStrJmlLt) {
        this.PelDalamGranitImporStrJmlLt = PelDalamGranitImporStrJmlLt;
    }

    /**
     * @return the PelDalamGranitImporBsmJmlLt
     */
    public Integer getPelDalamGranitImporBsmJmlLt() {
        return PelDalamGranitImporBsmJmlLt;
    }

    /**
     * @param PelDalamGranitImporBsmJmlLt the PelDalamGranitImporBsmJmlLt to set
     */
    public void setPelDalamGranitImporBsmJmlLt(Integer PelDalamGranitImporBsmJmlLt) {
        this.PelDalamGranitImporBsmJmlLt = PelDalamGranitImporBsmJmlLt;
    }

    /**
     * @return the PelDalamGranitLokalStrJmlLt
     */
    public Integer getPelDalamGranitLokalStrJmlLt() {
        return PelDalamGranitLokalStrJmlLt;
    }

    /**
     * @param PelDalamGranitLokalStrJmlLt the PelDalamGranitLokalStrJmlLt to set
     */
    public void setPelDalamGranitLokalStrJmlLt(Integer PelDalamGranitLokalStrJmlLt) {
        this.PelDalamGranitLokalStrJmlLt = PelDalamGranitLokalStrJmlLt;
    }

    /**
     * @return the PelDalamGranitLokalBsmJmlLt
     */
    public Integer getPelDalamGranitLokalBsmJmlLt() {
        return PelDalamGranitLokalBsmJmlLt;
    }

    /**
     * @param PelDalamGranitLokalBsmJmlLt the PelDalamGranitLokalBsmJmlLt to set
     */
    public void setPelDalamGranitLokalBsmJmlLt(Integer PelDalamGranitLokalBsmJmlLt) {
        this.PelDalamGranitLokalBsmJmlLt = PelDalamGranitLokalBsmJmlLt;
    }

    /**
     * @return the PelDalamKeramikStdStrJmlLt
     */
    public Integer getPelDalamKeramikStdStrJmlLt() {
        return PelDalamKeramikStdStrJmlLt;
    }

    /**
     * @param PelDalamKeramikStdStrJmlLt the PelDalamKeramikStdStrJmlLt to set
     */
    public void setPelDalamKeramikStdStrJmlLt(Integer PelDalamKeramikStdStrJmlLt) {
        this.PelDalamKeramikStdStrJmlLt = PelDalamKeramikStdStrJmlLt;
    }

    /**
     * @return the PelDalamKeramikStdBsmJmlLt
     */
    public Integer getPelDalamKeramikStdBsmJmlLt() {
        return PelDalamKeramikStdBsmJmlLt;
    }

    /**
     * @param PelDalamKeramikStdBsmJmlLt the PelDalamKeramikStdBsmJmlLt to set
     */
    public void setPelDalamKeramikStdBsmJmlLt(Integer PelDalamKeramikStdBsmJmlLt) {
        this.PelDalamKeramikStdBsmJmlLt = PelDalamKeramikStdBsmJmlLt;
    }

    /**
     * @return the PelLuarGranitImporJmlLt
     */
    public Integer getPelLuarGranitImporJmlLt() {
        return PelLuarGranitImporJmlLt;
    }

    /**
     * @param PelLuarGranitImporJmlLt the PelLuarGranitImporJmlLt to set
     */
    public void setPelLuarGranitImporJmlLt(Integer PelLuarGranitImporJmlLt) {
        this.PelLuarGranitImporJmlLt = PelLuarGranitImporJmlLt;
    }

    /**
     * @return the PelLuarKacaImporJmlLt
     */
    public Integer getPelLuarKacaImporJmlLt() {
        return PelLuarKacaImporJmlLt;
    }

    /**
     * @param PelLuarKacaImporJmlLt the PelLuarKacaImporJmlLt to set
     */
    public void setPelLuarKacaImporJmlLt(Integer PelLuarKacaImporJmlLt) {
        this.PelLuarKacaImporJmlLt = PelLuarKacaImporJmlLt;
    }

    /**
     * @return the PelLuarMarmerLokalJmlLt
     */
    public Integer getPelLuarMarmerLokalJmlLt() {
        return PelLuarMarmerLokalJmlLt;
    }

    /**
     * @param PelLuarMarmerLokalJmlLt the PelLuarMarmerLokalJmlLt to set
     */
    public void setPelLuarMarmerLokalJmlLt(Integer PelLuarMarmerLokalJmlLt) {
        this.PelLuarMarmerLokalJmlLt = PelLuarMarmerLokalJmlLt;
    }

    /**
     * @return the PelLuarKeramikStdJmlLt
     */
    public Integer getPelLuarKeramikStdJmlLt() {
        return PelLuarKeramikStdJmlLt;
    }

    /**
     * @param PelLuarKeramikStdJmlLt the PelLuarKeramikStdJmlLt to set
     */
    public void setPelLuarKeramikStdJmlLt(Integer PelLuarKeramikStdJmlLt) {
        this.PelLuarKeramikStdJmlLt = PelLuarKeramikStdJmlLt;
    }

    /**
     * @return the PelLuarMarmerImporJmlLt
     */
    public Integer getPelLuarMarmerImporJmlLt() {
        return PelLuarMarmerImporJmlLt;
    }

    /**
     * @param PelLuarMarmerImporJmlLt the PelLuarMarmerImporJmlLt to set
     */
    public void setPelLuarMarmerImporJmlLt(Integer PelLuarMarmerImporJmlLt) {
        this.PelLuarMarmerImporJmlLt = PelLuarMarmerImporJmlLt;
    }

    /**
     * @return the PelLuarGranitLokalJmlLt
     */
    public Integer getPelLuarGranitLokalJmlLt() {
        return PelLuarGranitLokalJmlLt;
    }

    /**
     * @param PelLuarGranitLokalJmlLt the PelLuarGranitLokalJmlLt to set
     */
    public void setPelLuarGranitLokalJmlLt(Integer PelLuarGranitLokalJmlLt) {
        this.PelLuarGranitLokalJmlLt = PelLuarGranitLokalJmlLt;
    }

    /**
     * @return the PelLuarKacaLokalJmlLt
     */
    public Integer getPelLuarKacaLokalJmlLt() {
        return PelLuarKacaLokalJmlLt;
    }

    /**
     * @param PelLuarKacaLokalJmlLt the PelLuarKacaLokalJmlLt to set
     */
    public void setPelLuarKacaLokalJmlLt(Integer PelLuarKacaLokalJmlLt) {
        this.PelLuarKacaLokalJmlLt = PelLuarKacaLokalJmlLt;
    }

    /**
     * @return the PelLuarCatJmlLt
     */
    public Integer getPelLuarCatJmlLt() {
        return PelLuarCatJmlLt;
    }

    /**
     * @param PelLuarCatJmlLt the PelLuarCatJmlLt to set
     */
    public void setPelLuarCatJmlLt(Integer PelLuarCatJmlLt) {
        this.PelLuarCatJmlLt = PelLuarCatJmlLt;
    }

    /**
     * @return the LangitGipsumStrJmlLt
     */
    public Integer getLangitGipsumStrJmlLt() {
        return LangitGipsumStrJmlLt;
    }

    /**
     * @param LangitGipsumStrJmlLt the LangitGipsumStrJmlLt to set
     */
    public void setLangitGipsumStrJmlLt(Integer LangitGipsumStrJmlLt) {
        this.LangitGipsumStrJmlLt = LangitGipsumStrJmlLt;
    }

    /**
     * @return the LangitGipsumBsmJmlLt
     */
    public Integer getLangitGipsumBsmJmlLt() {
        return LangitGipsumBsmJmlLt;
    }

    /**
     * @param LangitGipsumBsmJmlLt the LangitGipsumBsmJmlLt to set
     */
    public void setLangitGipsumBsmJmlLt(Integer LangitGipsumBsmJmlLt) {
        this.LangitGipsumBsmJmlLt = LangitGipsumBsmJmlLt;
    }

    /**
     * @return the LangitTriplekStrJmlLt
     */
    public Integer getLangitTriplekStrJmlLt() {
        return LangitTriplekStrJmlLt;
    }

    /**
     * @param LangitTriplekStrJmlLt the LangitTriplekStrJmlLt to set
     */
    public void setLangitTriplekStrJmlLt(Integer LangitTriplekStrJmlLt) {
        this.LangitTriplekStrJmlLt = LangitTriplekStrJmlLt;
    }

    /**
     * @return the LangitTriplekBsmJmlLt
     */
    public Integer getLangitTriplekBsmJmlLt() {
        return LangitTriplekBsmJmlLt;
    }

    /**
     * @param LangitTriplekBsmJmlLt the LangitTriplekBsmJmlLt to set
     */
    public void setLangitTriplekBsmJmlLt(Integer LangitTriplekBsmJmlLt) {
        this.LangitTriplekBsmJmlLt = LangitTriplekBsmJmlLt;
    }

    /**
     * @return the LangitAkustikStrJmlLt
     */
    public Integer getLangitAkustikStrJmlLt() {
        return LangitAkustikStrJmlLt;
    }

    /**
     * @param LangitAkustikStrJmlLt the LangitAkustikStrJmlLt to set
     */
    public void setLangitAkustikStrJmlLt(Integer LangitAkustikStrJmlLt) {
        this.LangitAkustikStrJmlLt = LangitAkustikStrJmlLt;
    }

    /**
     * @return the LangitAkustikBsmJmlLt
     */
    public Integer getLangitAkustikBsmJmlLt() {
        return LangitAkustikBsmJmlLt;
    }

    /**
     * @param LangitAkustikBsmJmlLt the LangitAkustikBsmJmlLt to set
     */
    public void setLangitAkustikBsmJmlLt(Integer LangitAkustikBsmJmlLt) {
        this.LangitAkustikBsmJmlLt = LangitAkustikBsmJmlLt;
    }

    /**
     * @return the LangitEternitStrJmlLt
     */
    public Integer getLangitEternitStrJmlLt() {
        return LangitEternitStrJmlLt;
    }

    /**
     * @param LangitEternitStrJmlLt the LangitEternitStrJmlLt to set
     */
    public void setLangitEternitStrJmlLt(Integer LangitEternitStrJmlLt) {
        this.LangitEternitStrJmlLt = LangitEternitStrJmlLt;
    }

    /**
     * @return the LangitEternitBsmJmlLt
     */
    public Integer getLangitEternitBsmJmlLt() {
        return LangitEternitBsmJmlLt;
    }

    /**
     * @param LangitEternitBsmJmlLt the LangitEternitBsmJmlLt to set
     */
    public void setLangitEternitBsmJmlLt(Integer LangitEternitBsmJmlLt) {
        this.LangitEternitBsmJmlLt = LangitEternitBsmJmlLt;
    }

    /**
     * @return the Atap
     */
    public String getAtap() {
        return Atap;
    }

    /**
     * @param Atap the Atap to set
     */
    public void setAtap(String Atap) {
        this.Atap = Atap;
    }

    /**
     * @return the LantaiGranitImporStrJmlLt
     */
    public Integer getLantaiGranitImporStrJmlLt() {
        return LantaiGranitImporStrJmlLt;
    }

    /**
     * @param LantaiGranitImporStrJmlLt the LantaiGranitImporStrJmlLt to set
     */
    public void setLantaiGranitImporStrJmlLt(Integer LantaiGranitImporStrJmlLt) {
        this.LantaiGranitImporStrJmlLt = LantaiGranitImporStrJmlLt;
    }

    /**
     * @return the LantaiGranitImporBsmJmlLt
     */
    public Integer getLantaiGranitImporBsmJmlLt() {
        return LantaiGranitImporBsmJmlLt;
    }

    /**
     * @param LantaiGranitImporBsmJmlLt the LantaiGranitImporBsmJmlLt to set
     */
    public void setLantaiGranitImporBsmJmlLt(Integer LantaiGranitImporBsmJmlLt) {
        this.LantaiGranitImporBsmJmlLt = LantaiGranitImporBsmJmlLt;
    }

    /**
     * @return the LantaiMarmerLokalStrJmlLt
     */
    public Integer getLantaiMarmerLokalStrJmlLt() {
        return LantaiMarmerLokalStrJmlLt;
    }

    /**
     * @param LantaiMarmerLokalStrJmlLt the LantaiMarmerLokalStrJmlLt to set
     */
    public void setLantaiMarmerLokalStrJmlLt(Integer LantaiMarmerLokalStrJmlLt) {
        this.LantaiMarmerLokalStrJmlLt = LantaiMarmerLokalStrJmlLt;
    }

    /**
     * @return the LantaiMarmerLokalBsmJmlLt
     */
    public Integer getLantaiMarmerLokalBsmJmlLt() {
        return LantaiMarmerLokalBsmJmlLt;
    }

    /**
     * @param LantaiMarmerLokalBsmJmlLt the LantaiMarmerLokalBsmJmlLt to set
     */
    public void setLantaiMarmerLokalBsmJmlLt(Integer LantaiMarmerLokalBsmJmlLt) {
        this.LantaiMarmerLokalBsmJmlLt = LantaiMarmerLokalBsmJmlLt;
    }

    /**
     * @return the LantaiKarpetImporStrJmlLt
     */
    public Integer getLantaiKarpetImporStrJmlLt() {
        return LantaiKarpetImporStrJmlLt;
    }

    /**
     * @param LantaiKarpetImporStrJmlLt the LantaiKarpetImporStrJmlLt to set
     */
    public void setLantaiKarpetImporStrJmlLt(Integer LantaiKarpetImporStrJmlLt) {
        this.LantaiKarpetImporStrJmlLt = LantaiKarpetImporStrJmlLt;
    }

    /**
     * @return the LantaiKarpetImporBsmJmlLt
     */
    public Integer getLantaiKarpetImporBsmJmlLt() {
        return LantaiKarpetImporBsmJmlLt;
    }

    /**
     * @param LantaiKarpetImporBsmJmlLt the LantaiKarpetImporBsmJmlLt to set
     */
    public void setLantaiKarpetImporBsmJmlLt(Integer LantaiKarpetImporBsmJmlLt) {
        this.LantaiKarpetImporBsmJmlLt = LantaiKarpetImporBsmJmlLt;
    }

    /**
     * @return the LantaiVinilStrJmlLt
     */
    public Integer getLantaiVinilStrJmlLt() {
        return LantaiVinilStrJmlLt;
    }

    /**
     * @param LantaiVinilStrJmlLt the LantaiVinilStrJmlLt to set
     */
    public void setLantaiVinilStrJmlLt(Integer LantaiVinilStrJmlLt) {
        this.LantaiVinilStrJmlLt = LantaiVinilStrJmlLt;
    }

    /**
     * @return the LantaiVinilBsmJmlLt
     */
    public Integer getLantaiVinilBsmJmlLt() {
        return LantaiVinilBsmJmlLt;
    }

    /**
     * @param LantaiVinilBsmJmlLt the LantaiVinilBsmJmlLt to set
     */
    public void setLantaiVinilBsmJmlLt(Integer LantaiVinilBsmJmlLt) {
        this.LantaiVinilBsmJmlLt = LantaiVinilBsmJmlLt;
    }

    /**
     * @return the LantaiKayuStrJmlLt
     */
    public Integer getLantaiKayuStrJmlLt() {
        return LantaiKayuStrJmlLt;
    }

    /**
     * @param LantaiKayuStrJmlLt the LantaiKayuStrJmlLt to set
     */
    public void setLantaiKayuStrJmlLt(Integer LantaiKayuStrJmlLt) {
        this.LantaiKayuStrJmlLt = LantaiKayuStrJmlLt;
    }

    /**
     * @return the LantaiKayuBsmJmlLt
     */
    public Integer getLantaiKayuBsmJmlLt() {
        return LantaiKayuBsmJmlLt;
    }

    /**
     * @param LantaiKayuBsmJmlLt the LantaiKayuBsmJmlLt to set
     */
    public void setLantaiKayuBsmJmlLt(Integer LantaiKayuBsmJmlLt) {
        this.LantaiKayuBsmJmlLt = LantaiKayuBsmJmlLt;
    }

    /**
     * @return the LantaiTeraasoStrJmlLt
     */
    public Integer getLantaiTerasoStrJmlLt() {
        return LantaiTerasoStrJmlLt;
    }

    /**
     * @param LantaiTeraasoStrJmlLt the LantaiTeraasoStrJmlLt to set
     */
    public void setLantaiTerasoStrJmlLt(Integer LantaiTeraasoStrJmlLt) {
        this.LantaiTerasoStrJmlLt = LantaiTeraasoStrJmlLt;
    }

    /**
     * @return the LantaiTerasoBsmJmlLt
     */
    public Integer getLantaiTerasoBsmJmlLt() {
        return LantaiTerasoBsmJmlLt;
    }

    /**
     * @param LantaiTerasoBsmJmlLt the LantaiTerasoBsmJmlLt to set
     */
    public void setLantaiTerasoBsmJmlLt(Integer LantaiTerasoBsmJmlLt) {
        this.LantaiTerasoBsmJmlLt = LantaiTerasoBsmJmlLt;
    }

    /**
     * @return the LantaiMarmerImporStrJmlLt
     */
    public Integer getLantaiMarmerImporStrJmlLt() {
        return LantaiMarmerImporStrJmlLt;
    }

    /**
     * @param LantaiMarmerImporStrJmlLt the LantaiMarmerImporStrJmlLt to set
     */
    public void setLantaiMarmerImporStrJmlLt(Integer LantaiMarmerImporStrJmlLt) {
        this.LantaiMarmerImporStrJmlLt = LantaiMarmerImporStrJmlLt;
    }

    /**
     * @return the LantaiMarmerImporBsmJmlLt
     */
    public Integer getLantaiMarmerImporBsmJmlLt() {
        return LantaiMarmerImporBsmJmlLt;
    }

    /**
     * @param LantaiMarmerImporBsmJmlLt the LantaiMarmerImporBsmJmlLt to set
     */
    public void setLantaiMarmerImporBsmJmlLt(Integer LantaiMarmerImporBsmJmlLt) {
        this.LantaiMarmerImporBsmJmlLt = LantaiMarmerImporBsmJmlLt;
    }

    /**
     * @return the LantaiGranitLokalStrJmlLt
     */
    public Integer getLantaiGranitLokalStrJmlLt() {
        return LantaiGranitLokalStrJmlLt;
    }

    /**
     * @param LantaiGranitLokalStrJmlLt the LantaiGranitLokalStrJmlLt to set
     */
    public void setLantaiGranitLokalStrJmlLt(Integer LantaiGranitLokalStrJmlLt) {
        this.LantaiGranitLokalStrJmlLt = LantaiGranitLokalStrJmlLt;
    }

    /**
     * @return the LantaiGranitLokalBsmJmlLt
     */
    public Integer getLantaiGranitLokalBsmJmlLt() {
        return LantaiGranitLokalBsmJmlLt;
    }

    /**
     * @param LantaiGranitLokalBsmJmlLt the LantaiGranitLokalBsmJmlLt to set
     */
    public void setLantaiGranitLokalBsmJmlLt(Integer LantaiGranitLokalBsmJmlLt) {
        this.LantaiGranitLokalBsmJmlLt = LantaiGranitLokalBsmJmlLt;
    }

    /**
     * @return the LantaiKeramikStdStrJmlLt
     */
    public Integer getLantaiKeramikStdStrJmlLt() {
        return LantaiKeramikStdStrJmlLt;
    }

    /**
     * @param LantaiKeramikStdStrJmlLt the LantaiKeramikStdStrJmlLt to set
     */
    public void setLantaiKeramikStdStrJmlLt(Integer LantaiKeramikStdStrJmlLt) {
        this.LantaiKeramikStdStrJmlLt = LantaiKeramikStdStrJmlLt;
    }

    /**
     * @return the LantaiKeramikStdBsmJmlLt
     */
    public Integer getLantaiKeramikStdBsmJmlLt() {
        return LantaiKeramikStdBsmJmlLt;
    }

    /**
     * @param LantaiKeramikStdBsmJmlLt the LantaiKeramikStdBsmJmlLt to set
     */
    public void setLantaiKeramikStdBsmJmlLt(Integer LantaiKeramikStdBsmJmlLt) {
        this.LantaiKeramikStdBsmJmlLt = LantaiKeramikStdBsmJmlLt;
    }

    /**
     * @return the LantaiKarpetLokalStrJmlLt
     */
    public Integer getLantaiKarpetLokalStrJmlLt() {
        return LantaiKarpetLokalStrJmlLt;
    }

    /**
     * @param LantaiKarpetLokalStrJmlLt the LantaiKarpetLokalStrJmlLt to set
     */
    public void setLantaiKarpetLokalStrJmlLt(Integer LantaiKarpetLokalStrJmlLt) {
        this.LantaiKarpetLokalStrJmlLt = LantaiKarpetLokalStrJmlLt;
    }

    /**
     * @return the LantaiKarpetLokalBsmJmlLt
     */
    public Integer getLantaiKarpetLokalBsmJmlLt() {
        return LantaiKarpetLokalBsmJmlLt;
    }

    /**
     * @param LantaiKarpetLokalBsmJmlLt the LantaiKarpetLokalBsmJmlLt to set
     */
    public void setLantaiKarpetLokalBsmJmlLt(Integer LantaiKarpetLokalBsmJmlLt) {
        this.LantaiKarpetLokalBsmJmlLt = LantaiKarpetLokalBsmJmlLt;
    }

    /**
     * @return the LantaiUbinStrJmlLt
     */
    public Integer getLantaiUbinStrJmlLt() {
        return LantaiUbinStrJmlLt;
    }

    /**
     * @param LantaiUbinStrJmlLt the LantaiUbinStrJmlLt to set
     */
    public void setLantaiUbinStrJmlLt(Integer LantaiUbinStrJmlLt) {
        this.LantaiUbinStrJmlLt = LantaiUbinStrJmlLt;
    }

    /**
     * @return the LantaiUbinBsmJmlLt
     */
    public Integer getLantaiUbinBsmJmlLt() {
        return LantaiUbinBsmJmlLt;
    }

    /**
     * @param LantaiUbinBsmJmlLt the LantaiUbinBsmJmlLt to set
     */
    public void setLantaiUbinBsmJmlLt(Integer LantaiUbinBsmJmlLt) {
        this.LantaiUbinBsmJmlLt = LantaiUbinBsmJmlLt;
    }

    /**
     * @return the LantaiSemenStrJmlLt
     */
    public Integer getLantaiSemenStrJmlLt() {
        return LantaiSemenStrJmlLt;
    }

    /**
     * @param LantaiSemenStrJmlLt the LantaiSemenStrJmlLt to set
     */
    public void setLantaiSemenStrJmlLt(Integer LantaiSemenStrJmlLt) {
        this.LantaiSemenStrJmlLt = LantaiSemenStrJmlLt;
    }

    /**
     * @return the LantaiSemenBsmJmlLt
     */
    public Integer getLantaiSemenBsmJmlLt() {
        return LantaiSemenBsmJmlLt;
    }

    /**
     * @param LantaiSemenBsmJmlLt the LantaiSemenBsmJmlLt to set
     */
    public void setLantaiSemenBsmJmlLt(Integer LantaiSemenBsmJmlLt) {
        this.LantaiSemenBsmJmlLt = LantaiSemenBsmJmlLt;
    }

    /**
     * @return the AcSplitJml
     */
    public Integer getAcSplitJml() {
        return AcSplitJml;
    }

    /**
     * @param AcSplitJml the AcSplitJml to set
     */
    public void setAcSplitJml(Integer AcSplitJml) {
        this.AcSplitJml = AcSplitJml;
    }

    /**
     * @return the AcSplitPk
     */
    public String getAcSplitPk() {
        return AcSplitPk;
    }

    /**
     * @param AcSplitPk the AcSplitPk to set
     */
    public void setAcSplitPk(String AcSplitPk) {
        this.AcSplitPk = AcSplitPk;
    }

    /**
     * @return the AcWindowJml
     */
    public Integer getAcWindowJml() {
        return AcWindowJml;
    }

    /**
     * @param AcWindowJml the AcWindowJml to set
     */
    public void setAcWindowJml(Integer AcWindowJml) {
        this.AcWindowJml = AcWindowJml;
    }

    /**
     * @return the AcWindowPk
     */
    public String getAcWindowPk() {
        return AcWindowPk;
    }

    /**
     * @param AcWindowPk the AcWindowPk to set
     */
    public void setAcWindowPk(String AcWindowPk) {
        this.AcWindowPk = AcWindowPk;
    }

    /**
     * @return the AcFloorJml
     */
    public Integer getAcFloorJml() {
        return AcFloorJml;
    }

    /**
     * @param AcFloorJml the AcFloorJml to set
     */
    public void setAcFloorJml(Integer AcFloorJml) {
        this.AcFloorJml = AcFloorJml;
    }

    /**
     * @return the AcFloorPk
     */
    public String getAcFloorPk() {
        return AcFloorPk;
    }

    /**
     * @param AcFloorPk the AcFloorPk to set
     */
    public void setAcFloorPk(String AcFloorPk) {
        this.AcFloorPk = AcFloorPk;
    }

    /**
     * @return the AcSentral
     */
    public boolean isAcSentral() {
        return AcSentral;
    }

    /**
     * @param AcSentral the AcSentral to set
     */
    public void setAcSentral(boolean AcSentral) {
        this.AcSentral = AcSentral;
        
        if(AcSentral)
        {
            this.AcSentralStr= "Ada";
        }else
        {
            this.AcSentralStr = "Tidak ada";
        }
        
    }

    /**
     * @return the LiftPenumpangJml
     */
    public Integer getLiftPenumpangJml() {
        return LiftPenumpangJml;
    }

    /**
     * @param LiftPenumpangJml the LiftPenumpangJml to set
     */
    public void setLiftPenumpangJml(Integer LiftPenumpangJml) {
        this.LiftPenumpangJml = LiftPenumpangJml;
    }

    /**
     * @return the LiftBarangJml
     */
    public Integer getLiftBarangJml() {
        return LiftBarangJml;
    }

    /**
     * @param LiftBarangJml the LiftBarangJml to set
     */
    public void setLiftBarangJml(Integer LiftBarangJml) {
        this.LiftBarangJml = LiftBarangJml;
    }

    /**
     * @return the EskalatorLess08Jml
     */
    public Integer getEskalatorLess08Jml() {
        return EskalatorLess08Jml;
    }

    /**
     * @param EskalatorLess08Jml the EskalatorLess08Jml to set
     */
    public void setEskalatorLess08Jml(Integer EskalatorLess08Jml) {
        this.EskalatorLess08Jml = EskalatorLess08Jml;
    }

    /**
     * @return the EskalatorGreat08Jml
     */
    public Integer getEskalatorGreat08Jml() {
        return EskalatorGreat08Jml;
    }

    /**
     * @param EskalatorGreat08Jml the EskalatorGreat08Jml to set
     */
    public void setEskalatorGreat08Jml(Integer EskalatorGreat08Jml) {
        this.EskalatorGreat08Jml = EskalatorGreat08Jml;
    }

    /**
     * @return the PagarBatakoPanjang
     */
    public Double getPagarBatakoPanjang() {
        return PagarBatakoPanjang;
    }

    /**
     * @param PagarBatakoPanjang the PagarBatakoPanjang to set
     */
    public void setPagarBatakoPanjang(Double PagarBatakoPanjang) {
        this.PagarBatakoPanjang = PagarBatakoPanjang;
    }

    /**
     * @return the PagarBatakoTinggi
     */
    public Double getPagarBatakoTinggi() {
        return PagarBatakoTinggi;
    }

    /**
     * @param PagarBatakoTinggi the PagarBatakoTinggi to set
     */
    public void setPagarBatakoTinggi(Double PagarBatakoTinggi) {
        this.PagarBatakoTinggi = PagarBatakoTinggi;
    }

    /**
     * @return the PagarBataPanjang
     */
    public Double getPagarBataPanjang() {
        return PagarBataPanjang;
    }

    /**
     * @param PagarBataPanjang the PagarBataPanjang to set
     */
    public void setPagarBataPanjang(Double PagarBataPanjang) {
        this.PagarBataPanjang = PagarBataPanjang;
    }

    /**
     * @return the PagarBataTinggi
     */
    public Double getPagarBataTinggi() {
        return PagarBataTinggi;
    }

    /**
     * @param PagarBataTinggi the PagarBataTinggi to set
     */
    public void setPagarBataTinggi(Double PagarBataTinggi) {
        this.PagarBataTinggi = PagarBataTinggi;
    }

    /**
     * @return the PagarBetonPanjang
     */
    public Double getPagarBetonPanjang() {
        return PagarBetonPanjang;
    }

    /**
     * @param PagarBetonPanjang the PagarBetonPanjang to set
     */
    public void setPagarBetonPanjang(Double PagarBetonPanjang) {
        this.PagarBetonPanjang = PagarBetonPanjang;
    }

    /**
     * @return the PagarBetonTinggi
     */
    public Double getPagarBetonTinggi() {
        return PagarBetonTinggi;
    }

    /**
     * @param PagarBetonTinggi the PagarBetonTinggi to set
     */
    public void setPagarBetonTinggi(Double PagarBetonTinggi) {
        this.PagarBetonTinggi = PagarBetonTinggi;
    }

    /**
     * @return the PagarBesiPanjang
     */
    public Double getPagarBesiPanjang() {
        return PagarBesiPanjang;
    }

    /**
     * @param PagarBesiPanjang the PagarBesiPanjang to set
     */
    public void setPagarBesiPanjang(Double PagarBesiPanjang) {
        this.PagarBesiPanjang = PagarBesiPanjang;
    }

    /**
     * @return the PagarBesiTinggi
     */
    public Double getPagarBesiTinggi() {
        return PagarBesiTinggi;
    }

    /**
     * @param PagarBesiTinggi the PagarBesiTinggi to set
     */
    public void setPagarBesiTinggi(Double PagarBesiTinggi) {
        this.PagarBesiTinggi = PagarBesiTinggi;
    }

    /**
     * @return the PagarBrcPanjang
     */
    public Double getPagarBrcPanjang() {
        return PagarBrcPanjang;
    }

    /**
     * @param PagarBrcPanjang the PagarBrcPanjang to set
     */
    public void setPagarBrcPanjang(Double PagarBrcPanjang) {
        this.PagarBrcPanjang = PagarBrcPanjang;
    }

    /**
     * @return the PagarBrcTinggi
     */
    public Double getPagarBrcTinggi() {
        return PagarBrcTinggi;
    }

    /**
     * @param PagarBrcTinggi the PagarBrcTinggi to set
     */
    public void setPagarBrcTinggi(Double PagarBrcTinggi) {
        this.PagarBrcTinggi = PagarBrcTinggi;
    }

    /**
     * @return the TvMatvLuas
     */
    public Double getTvMatvLuas() {
        return TvMatvLuas;
    }

    /**
     * @param TvMatvLuas the TvMatvLuas to set
     */
    public void setTvMatvLuas(Double TvMatvLuas) {
        this.TvMatvLuas = TvMatvLuas;
    }

    /**
     * @return the TvMatvJmlLt
     */
    public Integer getTvMatvJmlLt() {
        return TvMatvJmlLt;
    }

    /**
     * @param TvMatvJmlLt the TvMatvJmlLt to set
     */
    public void setTvMatvJmlLt(Integer TvMatvJmlLt) {
        this.TvMatvJmlLt = TvMatvJmlLt;
    }

    /**
     * @return the TvCctvLuas
     */
    public Double getTvCctvLuas() {
        return TvCctvLuas;
    }

    /**
     * @param TvCctvLuas the TvCctvLuas to set
     */
    public void setTvCctvLuas(Double TvCctvLuas) {
        this.TvCctvLuas = TvCctvLuas;
    }

    /**
     * @return the TvCctvJmlLt
     */
    public Integer getTvCctvJmlLt() {
        return TvCctvJmlLt;
    }

    /**
     * @param TvCctvJmlLt the TvCctvJmlLt to set
     */
    public void setTvCctvJmlLt(Integer TvCctvJmlLt) {
        this.TvCctvJmlLt = TvCctvJmlLt;
    }

    /**
     * @return the Hydrant
     */
    public boolean isHydrant() {
        return Hydrant;
    }

    /**
     * @param Hydrant the Hydrant to set
     */
    public void setHydrant(boolean Hydrant) {
        this.Hydrant = Hydrant;
        
        if(Hydrant)
        {
            HydrantStr = "Ada";
        }else
        {
            HydrantStr = "Tidak ada";
        }
    }

    /**
     * @return the Sprinkler
     */
    public boolean isSprinkler() {
        return Sprinkler;
    }

    /**
     * @param Sprinkler the Sprinkler to set
     */
    public void setSprinkler(boolean Sprinkler) {
        this.Sprinkler = Sprinkler;
        
        if(Sprinkler)
        {
            SprinklerStr = "Ada";
        }else
        {
            SprinklerStr = "Tidak ada";
        }
    }

    /**
     * @return the Alarm
     */
    public boolean isAlarm() {
        return Alarm;
    }

    /**
     * @param Alarm the Alarm to set
     */
    public void setAlarm(boolean Alarm) {
        this.Alarm = Alarm;
        
        if(Alarm)
        {
            AlarmStr = "Ada";
        }else
        {
            AlarmStr = "Tidak ada";
        }
    }

    /**
     * @return the Interkom
     */
    public boolean isInterkom() {
        return Interkom;
    }

    /**
     * @param Interkom the Interkom to set
     */
    public void setInterkom(boolean Interkom) {
        this.Interkom = Interkom;
        if(Interkom)
        {
            InterkomStr = "Ada";
        }else
        {
            InterkomStr = "Tidak ada";
        }
    }

    /**
     * @return the AirPanas
     */
    public boolean isAirPanas() {
        return AirPanas;
    }

    /**
     * @param AirPanas the AirPanas to set
     */
    public void setAirPanas(boolean AirPanas) {
        this.AirPanas = AirPanas;
        if(AirPanas)
        {
            this.AirPanasStr = "Ada";
        }else
        {
            this.AirPanasStr = "Tidak ada";
        }
    }

    /**
     * @return the Reservoir
     */
    public boolean isReservoir() {
        return Reservoir;
    }

    /**
     * @param Reservoir the Reservoir to set
     */
    public void setReservoir(boolean Reservoir) {
        this.Reservoir = Reservoir;
        if(Reservoir)
        {
            ReservoirStr = "Ada";
        }else
        {
            ReservoirStr = "Tidak ada";
        }
    }

    /**
     * @return the JmlPabx
     */
    public Integer getJmlPabx() {
        return JmlPabx;
    }

    /**
     * @param JmlPabx the JmlPabx to set
     */
    public void setJmlPabx(Integer JmlPabx) {
        this.JmlPabx = JmlPabx;
    }

    /**
     * @return the DayaListrik
     */
    public Integer getDayaListrik() {
        return DayaListrik;
    }

    /**
     * @param DayaListrik the DayaListrik to set
     */
    public void setDayaListrik(Integer DayaListrik) {
        this.DayaListrik = DayaListrik;
    }

    /**
     * @return the VideoInterkomLuas
     */
    public Double getVideoInterkomLuas() {
        return VideoInterkomLuas;
    }

    /**
     * @param VideoInterkomLuas the VideoInterkomLuas to set
     */
    public void setVideoInterkomLuas(Double VideoInterkomLuas) {
        this.VideoInterkomLuas = VideoInterkomLuas;
    }

    /**
     * @return the VideoInterkomJmlLt
     */
    public Integer getVideoInterkomJmlLt() {
        return VideoInterkomJmlLt;
    }

    /**
     * @param VideoInterkomJmlLt the VideoInterkomJmlLt to set
     */
    public void setVideoInterkomJmlLt(Integer VideoInterkomJmlLt) {
        this.VideoInterkomJmlLt = VideoInterkomJmlLt;
    }

    /**
     * @return the SumurArtesis
     */
    public Double getSumurArtesis() {
        return SumurArtesis;
    }

    /**
     * @param SumurArtesis the SumurArtesis to set
     */
    public void setSumurArtesis(Double SumurArtesis) {
        this.SumurArtesis = SumurArtesis;
    }

    /**
     * @return the PenangkalPetir
     */
    public boolean isPenangkalPetir() {
        return PenangkalPetir;
    }

    /**
     * @param PenangkalPetir the PenangkalPetir to set
     */
    public void setPenangkalPetir(boolean PenangkalPetir) {
        this.PenangkalPetir = PenangkalPetir;
        if(PenangkalPetir)
        {
            PenangkalPetirStr = "Ada";
        }else
        {
            PenangkalPetirStr = "Tidak ada";
        }
    }

    /**
     * @return the PengolahLimbah
     */
    public boolean isPengolahLimbah() {
        return PengolahLimbah;
    }

    /**
     * @param PengolahLimbah the PengolahLimbah to set
     */
    public void setPengolahLimbah(boolean PengolahLimbah) {
        this.PengolahLimbah = PengolahLimbah;
        if(PengolahLimbah)
        {
            PengolahLimbahStr = "Ada";
        }else
        {
            PengolahLimbahStr = "Tidak ada";
        }
        
        
    }


    /**
     * @return the KolamRenangLs
     */
    public Double getKolamRenangLs() {
        return KolamRenangLs;
    }

    /**
     * @param KolamRenangLs the KolamRenangLs to set
     */
    public void setKolamRenangLs(Double KolamRenangLs) {
        this.KolamRenangLs = KolamRenangLs;
    }

    /**
     * @return the KolamRenangFinish
     */
    public String getKolamRenangFinish() {
        return KolamRenangFinish;
    }

    /**
     * @param KolamRenangFinish the KolamRenangFinish to set
     */
    public void setKolamRenangFinish(String KolamRenangFinish) {
        this.KolamRenangFinish = KolamRenangFinish;
    }

    /**
     * @return the LapTenisBetonLampuJml
     */
    public Integer getLapTenisBetonLampuJml() {
        return LapTenisBetonLampuJml;
    }

    /**
     * @param LapTenisBetonLampuJml the LapTenisBetonLampuJml to set
     */
    public void setLapTenisBetonLampuJml(Integer LapTenisBetonLampuJml) {
        this.LapTenisBetonLampuJml = LapTenisBetonLampuJml;
    }

    /**
     * @return the LapTenisAspalLampuJml
     */
    public Integer getLapTenisAspalLampuJml() {
        return LapTenisAspalLampuJml;
    }

    /**
     * @param LapTenisAspalLampuJml the LapTenisAspalLampuJml to set
     */
    public void setLapTenisAspalLampuJml(Integer LapTenisAspalLampuJml) {
        this.LapTenisAspalLampuJml = LapTenisAspalLampuJml;
    }

    /**
     * @return the LapTenisTanahLampuJml
     */
    public Integer getLapTenisTanahLampuJml() {
        return LapTenisTanahLampuJml;
    }

    /**
     * @param LapTenisTanahLampuJml the LapTenisTanahLampuJml to set
     */
    public void setLapTenisTanahLampuJml(Integer LapTenisTanahLampuJml) {
        this.LapTenisTanahLampuJml = LapTenisTanahLampuJml;
    }

    /**
     * @return the LapTenisBetonNoLampuJml
     */
    public Integer getLapTenisBetonNoLampuJml() {
        return LapTenisBetonNoLampuJml;
    }

    /**
     * @param LapTenisBetonNoLampuJml the LapTenisBetonNoLampuJml to set
     */
    public void setLapTenisBetonNoLampuJml(Integer LapTenisBetonNoLampuJml) {
        this.LapTenisBetonNoLampuJml = LapTenisBetonNoLampuJml;
    }

    /**
     * @return the LapTenisAspalNoLampuJml
     */
    public Integer getLapTenisAspalNoLampuJml() {
        return LapTenisAspalNoLampuJml;
    }

    /**
     * @param LapTenisAspalNoLampuJml the LapTenisAspalNoLampuJml to set
     */
    public void setLapTenisAspalNoLampuJml(Integer LapTenisAspalNoLampuJml) {
        this.LapTenisAspalNoLampuJml = LapTenisAspalNoLampuJml;
    }

    /**
     * @return the LapTenisTanahNoLampuJml
     */
    public Integer getLapTenisTanahNoLampuJml() {
        return LapTenisTanahNoLampuJml;
    }

    /**
     * @param LapTenisTanahNoLampuJml the LapTenisTanahNoLampuJml to set
     */
    public void setLapTenisTanahNoLampuJml(Integer LapTenisTanahNoLampuJml) {
        this.LapTenisTanahNoLampuJml = LapTenisTanahNoLampuJml;
    }

    /**
     * @return the PerkerasanRinganLs
     */
    public Double getPerkerasanRinganLs() {
        return PerkerasanRinganLs;
    }

    /**
     * @param PerkerasanRinganLs the PerkerasanRinganLs to set
     */
    public void setPerkerasanRinganLs(Double PerkerasanRinganLs) {
        this.PerkerasanRinganLs = PerkerasanRinganLs;
    }

    /**
     * @return the PerkerasanSedangLs
     */
    public Double getPerkerasanSedangLs() {
        return PerkerasanSedangLs;
    }

    /**
     * @param PerkerasanSedangLs the PerkerasanSedangLs to set
     */
    public void setPerkerasanSedangLs(Double PerkerasanSedangLs) {
        this.PerkerasanSedangLs = PerkerasanSedangLs;
    }

    /**
     * @return the PerkerasanKerasLs
     */
    public Double getPerkerasanKerasLs() {
        return PerkerasanKerasLs;
    }

    /**
     * @param PerkerasanKerasLs the PerkerasanKerasLs to set
     */
    public void setPerkerasanKerasLs(Double PerkerasanKerasLs) {
        this.PerkerasanKerasLs = PerkerasanKerasLs;
    }

    /**
     * @return the Jpb38TinggiKolom
     */
    public Integer getJpb38TinggiKolom() {
        return Jpb38TinggiKolom;
    }

    /**
     * @param Jpb38TinggiKolom the Jpb38TinggiKolom to set
     */
    public void setJpb38TinggiKolom(Integer Jpb38TinggiKolom) {
        this.Jpb38TinggiKolom = Jpb38TinggiKolom;
    }

    /**
     * @return the Jpb38LebarBentang
     */
    public Integer getJpb38LebarBentang() {
        return Jpb38LebarBentang;
    }

    /**
     * @param Jpb38LebarBentang the Jpb38LebarBentang to set
     */
    public void setJpb38LebarBentang(Integer Jpb38LebarBentang) {
        this.Jpb38LebarBentang = Jpb38LebarBentang;
    }

    /**
     * @return the Jpb38LantaiDyDkg
     */
    public Double getJpb38LantaiDyDkg() {
        return Jpb38LantaiDyDkg;
    }

    /**
     * @param Jpb38LantaiDyDkg the Jpb38LantaiDyDkg to set
     */
    public void setJpb38LantaiDyDkg(Double Jpb38LantaiDyDkg) {
        this.Jpb38LantaiDyDkg = Jpb38LantaiDyDkg;
    }

    /**
     * @return the Jpb38LantaiTipe
     */
    public String getJpb38LantaiTipe() {
        return Jpb38LantaiTipe;
    }

    /**
     * @param Jpb38LantaiTipe the Jpb38LantaiTipe to set
     */
    public void setJpb38LantaiTipe(String Jpb38LantaiTipe) {
        this.Jpb38LantaiTipe = Jpb38LantaiTipe;
    }

    /**
     * @return the Jpb38LsMezzanin
     */
    public Double getJpb38LsMezzanin() {
        return Jpb38LsMezzanin;
    }

    /**
     * @param Jpb38LsMezzanin the Jpb38LsMezzanin to set
     */
    public void setJpb38LsMezzanin(Double Jpb38LsMezzanin) {
        this.Jpb38LsMezzanin = Jpb38LsMezzanin;
    }

    /**
     * @return the Jpb14JmlKanopi
     */
    public Integer getJpb14JmlKanopi() {
        return Jpb14JmlKanopi;
    }

    /**
     * @param Jpb14JmlKanopi the Jpb14JmlKanopi to set
     */
    public void setJpb14JmlKanopi(Integer Jpb14JmlKanopi) {
        this.Jpb14JmlKanopi = Jpb14JmlKanopi;
    }

    /**
     * @return the Jpb15Posisi
     */
    public String getJpb15Posisi() {
        return Jpb15Posisi;
    }

    /**
     * @param Jpb15Posisi the Jpb15Posisi to set
     */
    public void setJpb15Posisi(String Jpb15Posisi) {
        this.Jpb15Posisi = Jpb15Posisi;
    }

    /**
     * @return the Jpb15Kapasitas
     */
    public Double getJpb15Kapasitas() {
        return Jpb15Kapasitas;
    }

    /**
     * @param Jpb15Kapasitas the Jpb15Kapasitas to set
     */
    public void setJpb15Kapasitas(Double Jpb15Kapasitas) {
        this.Jpb15Kapasitas = Jpb15Kapasitas;
    }

    /**
     * @return the BngKe
     */
    public String getBngKe() {
        return BngKe;
    }

    /**
     * @param BngKe the BngKe to set
     */
    public void setBngKe(String BngKe) {
        this.BngKe = BngKe;
    }

    /**
     * @return the PelDalamMarmerLokalStrJmlLt
     */
    public Integer getPelDalamMarmerLokalStrJmlLt() {
        return PelDalamMarmerLokalStrJmlLt;
    }

    /**
     * @param PelDalamMarmerLokalStrJmlLt the PelDalamMarmerLokalStrJmlLt to set
     */
    public void setPelDalamMarmerLokalStrJmlLt(Integer PelDalamMarmerLokalStrJmlLt) {
        this.PelDalamMarmerLokalStrJmlLt = PelDalamMarmerLokalStrJmlLt;
    }

    /**
     * @return the PelDalamMarmerLokalBsmJmlLt
     */
    public Integer getPelDalamMarmerLokalBsmJmlLt() {
        return PelDalamMarmerLokalBsmJmlLt;
    }

    /**
     * @param PelDalamMarmerLokalBsmJmlLt the PelDalamMarmerLokalBsmJmlLt to set
     */
    public void setPelDalamMarmerLokalBsmJmlLt(Integer PelDalamMarmerLokalBsmJmlLt) {
        this.PelDalamMarmerLokalBsmJmlLt = PelDalamMarmerLokalBsmJmlLt;
    }

    /**
     * @return the TataSuara
     */
    public boolean isTataSuara() {
        return TataSuara;
    }

    /**
     * @param TataSuara the TataSuara to set
     */
    public void setTataSuara(boolean TataSuara) {
        this.TataSuara = TataSuara;
    }
    
    public Double getLsBngPerLantaiUtama() {
        return (getLsBngUtama()+getLsBngLain())/getJmlLtBng().doubleValue();
    }

    public Double getLsBngPerLantaiBase() {
        return getLsBase()/getJmlLtBng().doubleValue();
    }

    /**
     * @return the AcSentralStr
     */
    public String getAcSentralStr() {
        return AcSentralStr;
    }

    /**
     * @param AcSentralStr the AcSentralStr to set
     */
    public void setAcSentralStr(String AcSentralStr) {
        this.AcSentralStr = AcSentralStr;
    }

    /**
     * @return the ReservoirStr
     */
    public String getReservoirStr() {
        return ReservoirStr;
    }

    /**
     * @param ReservoirStr the ReservoirStr to set
     */
    public void setReservoirStr(String ReservoirStr) {
        this.ReservoirStr = ReservoirStr;
    }

    /**
     * @return the AirPanasStr
     */
    public String getAirPanasStr() {
        return AirPanasStr;
    }

    /**
     * @param AirPanasStr the AirPanasStr to set
     */
    public void setAirPanasStr(String AirPanasStr) {
        this.AirPanasStr = AirPanasStr;
    }

    /**
     * @return the InterkomStr
     */
    public String getInterkomStr() {
        return InterkomStr;
    }

    /**
     * @param InterkomStr the InterkomStr to set
     */
    public void setInterkomStr(String InterkomStr) {
        this.InterkomStr = InterkomStr;
    }

    /**
     * @return the AlarmStr
     */
    public String getAlarmStr() {
        return AlarmStr;
    }

    /**
     * @param AlarmStr the AlarmStr to set
     */
    public void setAlarmStr(String AlarmStr) {
        this.AlarmStr = AlarmStr;
    }

    /**
     * @return the HydrantStr
     */
    public String getHydrantStr() {
        return HydrantStr;
    }

    /**
     * @param HydrantStr the HydrantStr to set
     */
    public void setHydrantStr(String HydrantStr) {
        this.HydrantStr = HydrantStr;
    }

    /**
     * @return the SprinklerStr
     */
    public String getSprinklerStr() {
        return SprinklerStr;
    }

    /**
     * @param SprinklerStr the SprinklerStr to set
     */
    public void setSprinklerStr(String SprinklerStr) {
        this.SprinklerStr = SprinklerStr;
    }

    /**
     * @return the TataSuaraStr
     */
    public String getTataSuaraStr() {
        return TataSuaraStr;
    }

    /**
     * @param TataSuaraStr the TataSuaraStr to set
     */
    public void setTataSuaraStr(String TataSuaraStr) {
        this.TataSuaraStr = TataSuaraStr;
    }

    /**
     * @return the PengolahLimbahStr
     */
    public String getPengolahLimbahStr() {
        return PengolahLimbahStr;
    }

    /**
     * @param PengolahLimbahStr the PengolahLimbahStr to set
     */
    public void setPengolahLimbahStr(String PengolahLimbahStr) {
        this.PengolahLimbahStr = PengolahLimbahStr;
    }

    /**
     * @return the PenangkalPetirStr
     */
    public String getPenangkalPetirStr() {
        return PenangkalPetirStr;
    }

    /**
     * @param PenangkalPetirStr the PenangkalPetirStr to set
     */
    public void setPenangkalPetirStr(String PenangkalPetirStr) {
        this.PenangkalPetirStr = PenangkalPetirStr;
    }
}
