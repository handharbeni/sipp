/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ModelSpopPerikanan {
    
    private Spop spop;
    private ModelSpopTambahan spopTambahan;
    private ArrayList<ModelSpopBumi> spopBumi;

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
     * @return the spopTambahan
     */
    public ModelSpopTambahan getSpopTambahan() {
        return spopTambahan;
    }

    /**
     * @param spopTambahan the spopTambahan to set
     */
    public void setSpopTambahan(ModelSpopTambahan spopTambahan) {
        this.spopTambahan = spopTambahan;
    }

    /**
     * @return the spopBumi
     */
    public ArrayList<ModelSpopBumi> getSpopBumi() {
        return spopBumi;
    }

    /**
     * @param spopBumi the spopBumi to set
     */
    public void setSpopBumi(ArrayList<ModelSpopBumi> spopBumi) {
        this.spopBumi = spopBumi;
    }
    
}
