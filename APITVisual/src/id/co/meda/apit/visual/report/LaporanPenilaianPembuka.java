/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianPembuka {
    
    private Spop spop;
    private ArrayList<LspopNonStandar> lspopNonStandar;
    private ArrayList<LaporanPenilaianDataMaterialPembuka> datMaterial;
    private NilaiBangunan nilaiBng;
    private String kotaPenilai;
    private String kantorPenilai;
    
    
    /**
     * @return the kotaPenilai
     */
    public String getKotaPenilai() {
        return kotaPenilai;
    }

    /**
     * @param kotaPenilai the kotaPenilai to set
     */
    public void setKotaPenilai(String kotaPenilai) {
        this.kotaPenilai = kotaPenilai;
    }

    /**
     * @return the kantorPenilai
     */
    public String getKantorPenilai() {
        return kantorPenilai;
    }

    /**
     * @param kantorPenilai the kantorPenilai to set
     */
    public void setKantorPenilai(String kantorPenilai) {
        this.kantorPenilai = kantorPenilai;
    }

   

   

    /**
     * @return the spop
     */
    public Spop getSpop() {
        return spop;
    }

    /**
     * @param spop the spop to set
     */
    public void setSpop(Spop spop) {
        this.spop = spop;
    }

    /**
     * @return the nilaiBng
     */
    public NilaiBangunan getNilaiBng() {
        return nilaiBng;
    }

    /**
     * @param nilaiBng the nilaiBng to set
     */
    public void setNilaiBng(NilaiBangunan nilaiBng) {
        this.nilaiBng = nilaiBng;
    }

    /**
     * @return the datMaterial
     */
    public ArrayList<LaporanPenilaianDataMaterialPembuka> getDatMaterial() {
        return datMaterial;
    }

    /**
     * @param datMaterial the datMaterial to set
     */
    public void setDatMaterial(ArrayList<LaporanPenilaianDataMaterialPembuka> datMaterial) {
        this.datMaterial = datMaterial;
    }

    /**
     * @return the lspopNonStandar
     */
    public ArrayList<LspopNonStandar> getLspopNonStandar() {
        return lspopNonStandar;
    }

    /**
     * @param lspopNonStandar the lspopNonStandar to set
     */
    public void setLspopNonStandar(ArrayList<LspopNonStandar> lspopNonStandar) {
        this.lspopNonStandar = lspopNonStandar;
    }

    
    
    
    
    
    
    
    
}
