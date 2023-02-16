/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import java.util.ArrayList;

/**
 *
 * @author I Made Sugiada
 */
public class LaporanPenilaianMaster {
    private String thnPenilaian;
    private String nop;
    private String namaWp;
    private String alamatOp;
    private String kelurahanOp;
    private String kabupaten;
    private String bngKe;
    private String jpb;
    private String luasBng;
    private String luasBase;
    private String jmlLtBng;
    private String jmlLtBase;
    private String totKompUtama;
    private String totKompMaterial;
    private String totKompFasilitas;
    private String nilSblmSusut;
    private String persenSusut;
    private String nilPenyusutan;
    private String nilStlhSusut;
    private String nilFasTdkSusut;
    private String nilBng;
    //ini utk keperluan isi ringkasan
    private String nilBngAll;
    private ArrayList<LaporanPenilaianRingkas> ringkasan;
    //-------------------------------------------------
    private ArrayList<LaporanPenilaianDetil> KompUtama;
    private ArrayList<LaporanPenilaianDetil> MatDinDal;
    private ArrayList<LaporanPenilaianDetil> MatDinLuar;
    private ArrayList<LaporanPenilaianDetil> PelDinDal;
    private ArrayList<LaporanPenilaianDetil> PelDinLuar;
    private ArrayList<LaporanPenilaianDetil> KompLangit; 
    private ArrayList<LaporanPenilaianDetil> KompAtap;
    private ArrayList<LaporanPenilaianDetil> KompLantai;
    private ArrayList<LaporanPenilaianDetil> FasilitasTdkSusut;
    
    private ArrayList<LaporanPenilaianDetil> acSentral;
    private ArrayList<LaporanPenilaianDetil> lift;
    private ArrayList<LaporanPenilaianDetil> eskalator;
    private ArrayList<LaporanPenilaianDetil> pagar;
    private ArrayList<LaporanPenilaianDetil> proteksiApi;
    
    private ArrayList<LaporanPenilaianDetil> genset;
    private ArrayList<LaporanPenilaianDetil> pabx;
    private ArrayList<LaporanPenilaianDetil> sumurArtesis;
    private ArrayList<LaporanPenilaianDetil> sistemAirPanas;
    private ArrayList<LaporanPenilaianDetil> penangkalPetir;
    private ArrayList<LaporanPenilaianDetil> sistemLimbah;
    private ArrayList<LaporanPenilaianDetil> sistemTataSuara;
    private ArrayList<LaporanPenilaianDetil> videoInterkom;
    private ArrayList<LaporanPenilaianDetil> reservoir;
    private ArrayList<LaporanPenilaianDetil> televisi;
    private ArrayList<LaporanPenilaianDetil> kolamRenang;
    private ArrayList<LaporanPenilaianDetil> lapanganTenis;
    private ArrayList<LaporanPenilaianDetil> perkerasan;
    
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
     * @return the alamatOp
     */
    public String getAlamatOp() {
        return alamatOp;
    }

    /**
     * @param alamatOp the alamatOp to set
     */
    public void setAlamatOp(String alamatOp) {
        this.alamatOp = alamatOp;
    }

    /**
     * @return the kelurahanOp
     */
    public String getKelurahanOp() {
        return kelurahanOp;
    }

    /**
     * @param kelurahanOp the kelurahanOp to set
     */
    public void setKelurahanOp(String kelurahanOp) {
        this.kelurahanOp = kelurahanOp;
    }

    /**
     * @return the kabupaten
     */
    public String getKabupaten() {
        return kabupaten;
    }

    /**
     * @param kabupaten the kabupaten to set
     */
    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
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
     * @return the jpb
     */
    public String getJpb() {
        return jpb;
    }

    /**
     * @param jpb the jpb to set
     */
    public void setJpb(String jpb) {
        this.jpb = jpb;
    }

    /**
     * @return the luasBng
     */
    public String getLuasBng() {
        return luasBng;
    }

    /**
     * @param luasBng the luasBng to set
     */
    public void setLuasBng(String luasBng) {
        this.luasBng = luasBng;
    }

    /**
     * @return the luasBase
     */
    public String getLuasBase() {
        return luasBase;
    }

    /**
     * @param luasBase the luasBase to set
     */
    public void setLuasBase(String luasBase) {
        this.luasBase = luasBase;
    }

    /**
     * @return the jmlLtBng
     */
    public String getJmlLtBng() {
        return jmlLtBng;
    }

    /**
     * @param jmlLtBng the jmlLtBng to set
     */
    public void setJmlLtBng(String jmlLtBng) {
        this.jmlLtBng = jmlLtBng;
    }

    /**
     * @return the jmlLtBase
     */
    public String getJmlLtBase() {
        return jmlLtBase;
    }

    /**
     * @param jmlLtBase the jmlLtBase to set
     */
    public void setJmlLtBase(String jmlLtBase) {
        this.jmlLtBase = jmlLtBase;
    }

    /**
     * @return the totKompUtama
     */
    public String getTotKompUtama() {
        return totKompUtama;
    }

    /**
     * @param totKompUtama the totKompUtama to set
     */
    public void setTotKompUtama(String totKompUtama) {
        this.totKompUtama = totKompUtama;
    }

    /**
     * @return the totKompMaterial
     */
    public String getTotKompMaterial() {
        return totKompMaterial;
    }

    /**
     * @param totKompMaterial the totKompMaterial to set
     */
    public void setTotKompMaterial(String totKompMaterial) {
        this.totKompMaterial = totKompMaterial;
    }

    /**
     * @return the totKompFasilitas
     */
    public String getTotKompFasilitas() {
        return totKompFasilitas;
    }

    /**
     * @param totKompFasilitas the totKompFasilitas to set
     */
    public void setTotKompFasilitas(String totKompFasilitas) {
        this.totKompFasilitas = totKompFasilitas;
    }

    /**
     * @return the nilSblmSusut
     */
    public String getNilSblmSusut() {
        return nilSblmSusut;
    }

    /**
     * @param nilSblmSusut the nilSblmSusut to set
     */
    public void setNilSblmSusut(String nilSblmSusut) {
        this.nilSblmSusut = nilSblmSusut;
    }

    /**
     * @return the persenSusut
     */
    public String getPersenSusut() {
        return persenSusut;
    }

    /**
     * @param persenSusut the persenSusut to set
     */
    public void setPersenSusut(String persenSusut) {
        this.persenSusut = persenSusut;
    }

    /**
     * @return the nilPenyusutan
     */
    public String getNilPenyusutan() {
        return nilPenyusutan;
    }

    /**
     * @param nilPenyusutan the nilPenyusutan to set
     */
    public void setNilPenyusutan(String nilPenyusutan) {
        this.nilPenyusutan = nilPenyusutan;
    }

    /**
     * @return the nilStlhSusut
     */
    public String getNilStlhSusut() {
        return nilStlhSusut;
    }

    /**
     * @param nilStlhSusut the nilStlhSusut to set
     */
    public void setNilStlhSusut(String nilStlhSusut) {
        this.nilStlhSusut = nilStlhSusut;
    }

    /**
     * @return the nilFasTdkSusut
     */
    public String getNilFasTdkSusut() {
        return nilFasTdkSusut;
    }

    /**
     * @param nilFasTdkSusut the nilFasTdkSusut to set
     */
    public void setNilFasTdkSusut(String nilFasTdkSusut) {
        this.nilFasTdkSusut = nilFasTdkSusut;
    }

    /**
     * @return the nilBng
     */
    public String getNilBng() {
        return nilBng;
    }

    /**
     * @param nilBng the nilBng to set
     */
    public void setNilBng(String nilBng) {
        this.nilBng = nilBng;
    }

    /**
     * @return the KompUtama
     */
    public ArrayList<LaporanPenilaianDetil> getKompUtama() {
        return KompUtama;
    }

    /**
     * @param KompUtama the KompUtama to set
     */
    public void setKompUtama(ArrayList<LaporanPenilaianDetil> KompUtama) {
        this.KompUtama = KompUtama;
    }

    /**
     * @return the MatDinDal
     */
    public ArrayList<LaporanPenilaianDetil> getMatDinDal() {
        return MatDinDal;
    }

    /**
     * @param MatDinDal the MatDinDal to set
     */
    public void setMatDinDal(ArrayList<LaporanPenilaianDetil> MatDinDal) {
        this.MatDinDal = MatDinDal;
    }

    /**
     * @return the MatDinLuar
     */
    public ArrayList<LaporanPenilaianDetil> getMatDinLuar() {
        return MatDinLuar;
    }

    /**
     * @param MatDinLuar the MatDinLuar to set
     */
    public void setMatDinLuar(ArrayList<LaporanPenilaianDetil> MatDinLuar) {
        this.MatDinLuar = MatDinLuar;
    }

    /**
     * @return the PelDinDal
     */
    public ArrayList<LaporanPenilaianDetil> getPelDinDal() {
        return PelDinDal;
    }

    /**
     * @param PelDinDal the PelDinDal to set
     */
    public void setPelDinDal(ArrayList<LaporanPenilaianDetil> PelDinDal) {
        this.PelDinDal = PelDinDal;
    }

    /**
     * @return the PelDinLuar
     */
    public ArrayList<LaporanPenilaianDetil> getPelDinLuar() {
        return PelDinLuar;
    }

    /**
     * @param PelDinLuar the PelDinLuar to set
     */
    public void setPelDinLuar(ArrayList<LaporanPenilaianDetil> PelDinLuar) {
        this.PelDinLuar = PelDinLuar;
    }

    /**
     * @return the KompLangit
     */
    public ArrayList<LaporanPenilaianDetil> getKompLangit() {
        return KompLangit;
    }

    /**
     * @param KompLangit the KompLangit to set
     */
    public void setKompLangit(ArrayList<LaporanPenilaianDetil> KompLangit) {
        this.KompLangit = KompLangit;
    }

    /**
     * @return the KompAtap
     */
    public ArrayList<LaporanPenilaianDetil> getKompAtap() {
        return KompAtap;
    }

    /**
     * @param KompAtap the KompAtap to set
     */
    public void setKompAtap(ArrayList<LaporanPenilaianDetil> KompAtap) {
        this.KompAtap = KompAtap;
    }

    /**
     * @return the KompLantai
     */
    public ArrayList<LaporanPenilaianDetil> getKompLantai() {
        return KompLantai;
    }

    /**
     * @param KompLantai the KompLantai to set
     */
    public void setKompLantai(ArrayList<LaporanPenilaianDetil> KompLantai) {
        this.KompLantai = KompLantai;
    }

    /**
     * @return the FasilitasTdkSusut
     */
    public ArrayList<LaporanPenilaianDetil> getFasilitasTdkSusut() {
        return FasilitasTdkSusut;
    }

    /**
     * @param FasilitasTdkSusut the FasilitasTdkSusut to set
     */
    public void setFasilitasTdkSusut(ArrayList<LaporanPenilaianDetil> FasilitasTdkSusut) {
        this.FasilitasTdkSusut = FasilitasTdkSusut;
    }

    /**
     * @return the acSentral
     */
    public ArrayList<LaporanPenilaianDetil> getAcSentral() {
        return acSentral;
    }

    /**
     * @param acSentral the acSentral to set
     */
    public void setAcSentral(ArrayList<LaporanPenilaianDetil> acSentral) {
        this.acSentral = acSentral;
    }

    /**
     * @return the lift
     */
    public ArrayList<LaporanPenilaianDetil> getLift() {
        return lift;
    }

    /**
     * @param lift the lift to set
     */
    public void setLift(ArrayList<LaporanPenilaianDetil> lift) {
        this.lift = lift;
    }

    /**
     * @return the eskalator
     */
    public ArrayList<LaporanPenilaianDetil> getEskalator() {
        return eskalator;
    }

    /**
     * @param eskalator the eskalator to set
     */
    public void setEskalator(ArrayList<LaporanPenilaianDetil> eskalator) {
        this.eskalator = eskalator;
    }

    /**
     * @return the pagar
     */
    public ArrayList<LaporanPenilaianDetil> getPagar() {
        return pagar;
    }

    /**
     * @param pagar the pagar to set
     */
    public void setPagar(ArrayList<LaporanPenilaianDetil> pagar) {
        this.pagar = pagar;
    }

    /**
     * @return the proteksiApi
     */
    public ArrayList<LaporanPenilaianDetil> getProteksiApi() {
        return proteksiApi;
    }

    /**
     * @param proteksiApi the proteksiApi to set
     */
    public void setProteksiApi(ArrayList<LaporanPenilaianDetil> proteksiApi) {
        this.proteksiApi = proteksiApi;
    }

    /**
     * @return the genset
     */
    public ArrayList<LaporanPenilaianDetil> getGenset() {
        return genset;
    }

    /**
     * @param genset the genset to set
     */
    public void setGenset(ArrayList<LaporanPenilaianDetil> genset) {
        this.genset = genset;
    }

    /**
     * @return the pabx
     */
    public ArrayList<LaporanPenilaianDetil> getPabx() {
        return pabx;
    }

    /**
     * @param pabx the pabx to set
     */
    public void setPabx(ArrayList<LaporanPenilaianDetil> pabx) {
        this.pabx = pabx;
    }

    /**
     * @return the sumurArtesis
     */
    public ArrayList<LaporanPenilaianDetil> getSumurArtesis() {
        return sumurArtesis;
    }

    /**
     * @param sumurArtesis the sumurArtesis to set
     */
    public void setSumurArtesis(ArrayList<LaporanPenilaianDetil> sumurArtesis) {
        this.sumurArtesis = sumurArtesis;
    }

    /**
     * @return the sistemAirPanas
     */
    public ArrayList<LaporanPenilaianDetil> getSistemAirPanas() {
        return sistemAirPanas;
    }

    /**
     * @param sistemAirPanas the sistemAirPanas to set
     */
    public void setSistemAirPanas(ArrayList<LaporanPenilaianDetil> sistemAirPanas) {
        this.sistemAirPanas = sistemAirPanas;
    }

    /**
     * @return the penangkalPetir
     */
    public ArrayList<LaporanPenilaianDetil> getPenangkalPetir() {
        return penangkalPetir;
    }

    /**
     * @param penangkalPetir the penangkalPetir to set
     */
    public void setPenangkalPetir(ArrayList<LaporanPenilaianDetil> penangkalPetir) {
        this.penangkalPetir = penangkalPetir;
    }

    /**
     * @return the sistemLimbah
     */
    public ArrayList<LaporanPenilaianDetil> getSistemLimbah() {
        return sistemLimbah;
    }

    /**
     * @param sistemLimbah the sistemLimbah to set
     */
    public void setSistemLimbah(ArrayList<LaporanPenilaianDetil> sistemLimbah) {
        this.sistemLimbah = sistemLimbah;
    }

    /**
     * @return the sistemTataSuara
     */
    public ArrayList<LaporanPenilaianDetil> getSistemTataSuara() {
        return sistemTataSuara;
    }

    /**
     * @param sistemTataSuara the sistemTataSuara to set
     */
    public void setSistemTataSuara(ArrayList<LaporanPenilaianDetil> sistemTataSuara) {
        this.sistemTataSuara = sistemTataSuara;
    }

    /**
     * @return the videoInterkom
     */
    public ArrayList<LaporanPenilaianDetil> getVideoInterkom() {
        return videoInterkom;
    }

    /**
     * @param videoInterkom the videoInterkom to set
     */
    public void setVideoInterkom(ArrayList<LaporanPenilaianDetil> videoInterkom) {
        this.videoInterkom = videoInterkom;
    }

    /**
     * @return the reservoir
     */
    public ArrayList<LaporanPenilaianDetil> getReservoir() {
        return reservoir;
    }

    /**
     * @param reservoir the reservoir to set
     */
    public void setReservoir(ArrayList<LaporanPenilaianDetil> reservoir) {
        this.reservoir = reservoir;
    }

    /**
     * @return the televisi
     */
    public ArrayList<LaporanPenilaianDetil> getTelevisi() {
        return televisi;
    }

    /**
     * @param televisi the televisi to set
     */
    public void setTelevisi(ArrayList<LaporanPenilaianDetil> televisi) {
        this.televisi = televisi;
    }

    /**
     * @return the kolamRenang
     */
    public ArrayList<LaporanPenilaianDetil> getKolamRenang() {
        return kolamRenang;
    }

    /**
     * @param kolamRenang the kolamRenang to set
     */
    public void setKolamRenang(ArrayList<LaporanPenilaianDetil> kolamRenang) {
        this.kolamRenang = kolamRenang;
    }

    /**
     * @return the lapanganTenis
     */
    public ArrayList<LaporanPenilaianDetil> getLapanganTenis() {
        return lapanganTenis;
    }

    /**
     * @param lapanganTenis the lapanganTenis to set
     */
    public void setLapanganTenis(ArrayList<LaporanPenilaianDetil> lapanganTenis) {
        this.lapanganTenis = lapanganTenis;
    }

    /**
     * @return the perkerasan
     */
    public ArrayList<LaporanPenilaianDetil> getPerkerasan() {
        return perkerasan;
    }

    /**
     * @param perkerasan the perkerasan to set
     */
    public void setPerkerasan(ArrayList<LaporanPenilaianDetil> perkerasan) {
        this.perkerasan = perkerasan;
    }

    /**
     * @return the ringkasan
     */
    public ArrayList<LaporanPenilaianRingkas> getRingkasan() {
        return ringkasan;
    }

    /**
     * @param ringkasan the ringkasan to set
     */
    public void setRingkasan(ArrayList<LaporanPenilaianRingkas> ringkasan) {
        this.ringkasan = ringkasan;
    }

    /**
     * @return the nilBngAll
     */
    public String getNilBngAll() {
        return nilBngAll;
    }

    /**
     * @param nilBngAll the nilBngAll to set
     */
    public void setNilBngAll(String nilBngAll) {
        this.nilBngAll = nilBngAll;
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
