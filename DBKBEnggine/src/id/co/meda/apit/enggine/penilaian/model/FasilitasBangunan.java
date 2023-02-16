/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.model;

import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class FasilitasBangunan {
    private ArrayList<ItemPenilaian> acSentral;
    private ArrayList<ItemPenilaian> lift;
    private ArrayList<ItemPenilaian> eskalator;
    private ArrayList<ItemPenilaian> pagar;
    private ArrayList<ItemPenilaian> proteksiApi;
    private ItemPenilaian genset;
    private ItemPenilaian pabx;
    private ItemPenilaian sumurArtesis;
    private ItemPenilaian sistemAirPanas;
    private ItemPenilaian penangkalPetir;
    private ItemPenilaian sistemLimbah;
    private ItemPenilaian sistemTataSuara;
    private ItemPenilaian videoInterkom;
    private ItemPenilaian reservoir;
    private ArrayList<ItemPenilaian> televisi;
    private ItemPenilaian kolamRenang;
    private ArrayList<ItemPenilaian> lapanganTenis;
    private ArrayList<ItemPenilaian> perkerasan;


    public Double getNilaiFasilitas() {
        return getNilaiTotalAcSentral()+getNilaiTotalLift()+getNilaiTotalEskalator()+getNilaiTotalPagar()
                +getNilaiTotalProteksiApi()+getPabx().getTotalNilaiItem()
                +getSumurArtesis().getTotalNilaiItem()+getSistemAirPanas().getTotalNilaiItem()
                +getPenangkalPetir().getTotalNilaiItem()+getSistemLimbah().getTotalNilaiItem()
                +getSistemTataSuara().getTotalNilaiItem()+getVideoInterkom().getTotalNilaiItem()
                +getReservoir().getTotalNilaiItem()+getNilaiTotalTelevisi()+getKolamRenang().getTotalNilaiItem()
                +getNilaiTotalLapanganTenis()+getNilaiTotalPerkerasan();
    }
    
    public Double getNilaiTotalAcSentral() {
        return getNilaiTotalPerKomponen(acSentral);
    }

    public Double getNilaiTotalLift() {
        return getNilaiTotalPerKomponen(lift);
    }
    
    public Double getNilaiTotalEskalator() {
        return getNilaiTotalPerKomponen(eskalator);
    }
    
    public Double getNilaiTotalPagar() {
        return getNilaiTotalPerKomponen(pagar);
    }
    
    public Double getNilaiTotalProteksiApi() {
        return getNilaiTotalPerKomponen(proteksiApi);
    }
    
    public Double getNilaiTotalTelevisi() {
        return getNilaiTotalPerKomponen(televisi);
    }
    
    public Double getNilaiTotalLapanganTenis() {
        return getNilaiTotalPerKomponen(lapanganTenis);
    }

    public Double getNilaiTotalPerkerasan() {
        return getNilaiTotalPerKomponen(perkerasan);
    }
    
    private Double getNilaiTotalPerKomponen(ArrayList<ItemPenilaian> namaKomponen) {
        Double nilTotal = 0.0;
        try {
            for (int i = 0; i < namaKomponen.size(); i++) {
                    nilTotal = nilTotal+namaKomponen.get(i).getTotalNilaiItem();
            }
            return nilTotal;
        } catch (Exception e) {
            return nilTotal;
        }
    }
    
    
    /**
     * @return the acSentral
     */
    public ArrayList<ItemPenilaian> getAcSentral() {
        return acSentral;
    }

    /**
     * @param acSentral the acSentral to set
     */
    public void setAcSentral(ArrayList<ItemPenilaian> acSentral) {
        this.acSentral = acSentral;
    }

    /**
     * @return the lift
     */
    public ArrayList<ItemPenilaian> getLift() {
        return lift;
    }

    /**
     * @param lift the lift to set
     */
    public void setLift(ArrayList<ItemPenilaian> lift) {
        this.lift = lift;
    }

    /**
     * @return the eskalator
     */
    public ArrayList<ItemPenilaian> getEskalator() {
        return eskalator;
    }

    /**
     * @param eskalator the eskalator to set
     */
    public void setEskalator(ArrayList<ItemPenilaian> eskalator) {
        this.eskalator = eskalator;
    }

    /**
     * @return the pagar
     */
    public ArrayList<ItemPenilaian> getPagar() {
        return pagar;
    }

    /**
     * @param pagar the pagar to set
     */
    public void setPagar(ArrayList<ItemPenilaian> pagar) {
        this.pagar = pagar;
    }

    /**
     * @return the proteksiApi
     */
    public ArrayList<ItemPenilaian> getProteksiApi() {
        return proteksiApi;
    }

    /**
     * @param proteksiApi the proteksiApi to set
     */
    public void setProteksiApi(ArrayList<ItemPenilaian> proteksiApi) {
        this.proteksiApi = proteksiApi;
    }

    /**
     * @return the genset
     */
    public ItemPenilaian getGenset() {
        return genset;
    }

    /**
     * @param genset the genset to set
     */
    public void setGenset(ItemPenilaian genset) {
        this.genset = genset;
    }

    /**
     * @return the pabx
     */
    public ItemPenilaian getPabx() {
        return pabx;
    }

    /**
     * @param pabx the pabx to set
     */
    public void setPabx(ItemPenilaian pabx) {
        this.pabx = pabx;
    }

    /**
     * @return the sumurArtesis
     */
    public ItemPenilaian getSumurArtesis() {
        return sumurArtesis;
    }

    /**
     * @param sumurArtesis the sumurArtesis to set
     */
    public void setSumurArtesis(ItemPenilaian sumurArtesis) {
        this.sumurArtesis = sumurArtesis;
    }

    /**
     * @return the sistemAirPanas
     */
    public ItemPenilaian getSistemAirPanas() {
        return sistemAirPanas;
    }

    /**
     * @param sistemAirPanas the sistemAirPanas to set
     */
    public void setSistemAirPanas(ItemPenilaian sistemAirPanas) {
        this.sistemAirPanas = sistemAirPanas;
    }

    /**
     * @return the penangkalPetir
     */
    public ItemPenilaian getPenangkalPetir() {
        return penangkalPetir;
    }

    /**
     * @param penangkalPetir the penangkalPetir to set
     */
    public void setPenangkalPetir(ItemPenilaian penangkalPetir) {
        this.penangkalPetir = penangkalPetir;
    }

    /**
     * @return the sistemLimbah
     */
    public ItemPenilaian getSistemLimbah() {
        return sistemLimbah;
    }

    /**
     * @param sistemLimbah the sistemLimbah to set
     */
    public void setSistemLimbah(ItemPenilaian sistemLimbah) {
        this.sistemLimbah = sistemLimbah;
    }

    /**
     * @return the sistemTataSuara
     */
    public ItemPenilaian getSistemTataSuara() {
        return sistemTataSuara;
    }

    /**
     * @param sistemTataSuara the sistemTataSuara to set
     */
    public void setSistemTataSuara(ItemPenilaian sistemTataSuara) {
        this.sistemTataSuara = sistemTataSuara;
    }

    /**
     * @return the videoInterkom
     */
    public ItemPenilaian getVideoInterkom() {
        return videoInterkom;
    }

    /**
     * @param videoInterkom the videoInterkom to set
     */
    public void setVideoInterkom(ItemPenilaian videoInterkom) {
        this.videoInterkom = videoInterkom;
    }

    /**
     * @return the reservoir
     */
    public ItemPenilaian getReservoir() {
        return reservoir;
    }

    /**
     * @param reservoir the reservoir to set
     */
    public void setReservoir(ItemPenilaian reservoir) {
        this.reservoir = reservoir;
    }

    /**
     * @return the televisi
     */
    public ArrayList<ItemPenilaian> getTelevisi() {
        return televisi;
    }

    /**
     * @param televisi the televisi to set
     */
    public void setTelevisi(ArrayList<ItemPenilaian> televisi) {
        this.televisi = televisi;
    }

    /**
     * @return the lapanganTenis
     */
    public ArrayList<ItemPenilaian> getLapanganTenis() {
        return lapanganTenis;
    }

    /**
     * @param lapanganTenis the lapanganTenis to set
     */
    public void setLapanganTenis(ArrayList<ItemPenilaian> lapanganTenis) {
        this.lapanganTenis = lapanganTenis;
    }

    /**
     * @return the kolamRenang
     */
    public ItemPenilaian getKolamRenang() {
        return kolamRenang;
    }

    /**
     * @param kolamRenang the kolamRenang to set
     */
    public void setKolamRenang(ItemPenilaian kolamRenang) {
        this.kolamRenang = kolamRenang;
    }

    /**
     * @return the perkerasan
     */
    public ArrayList<ItemPenilaian> getPerkerasan() {
        return perkerasan;
    }

    /**
     * @param perkerasan the perkerasan to set
     */
    public void setPerkerasan(ArrayList<ItemPenilaian> perkerasan) {
        this.perkerasan = perkerasan;
    }
    
}
