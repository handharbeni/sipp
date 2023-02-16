/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class DataPerikanan {
   
    private ModelSpopPerikanan spop;
    private ModelPendapatanPerikanan pendapatan;
    private ArrayList<LspopNonStandar> lspop;

    /**
     * @return the spop
     */
    public ModelSpopPerikanan getSpopIkan() {
        return spop;
    }

    /**
     * @param spop the spop to set
     */
    public void setSpop(ModelSpopPerikanan spop) {
        this.spop = spop;
    }

    /**
     * @return the pendapatan
     */
    public ModelPendapatanPerikanan getPendapatan() {
        return pendapatan;
    }

    /**
     * @param pendapatan the pendapatan to set
     */
    public void setPendapatan(ModelPendapatanPerikanan pendapatan) {
        this.pendapatan = pendapatan;
    }

    /**
     * @return the lspop
     */
    public ArrayList<LspopNonStandar> getLspop() {
        return lspop;
    }

    /**
     * @param lspop the lspop to set
     */
    public void setLspop(ArrayList<LspopNonStandar> lspop) {
        this.lspop = lspop;
    }
    
    
            
}
