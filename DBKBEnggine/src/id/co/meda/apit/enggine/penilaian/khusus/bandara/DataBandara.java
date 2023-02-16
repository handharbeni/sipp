/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.bandara;

/**
 *
 * @author I Putu Medagia A
 */
public class DataBandara {
   
    private LkokBangunanUmumBandara bngUmumBandara;
    private LkokTanahBandara tanahBandara;

    /**
     * @return the bngUmumBandara
     */
    public LkokBangunanUmumBandara getBngUmumBandara() {
        return bngUmumBandara;
    }

    /**
     * @param bngUmumBandara the bngUmumBandara to set
     */
    public void setBngUmumBandara(LkokBangunanUmumBandara bngUmumBandara) {
        this.bngUmumBandara = bngUmumBandara;
    }

    /**
     * @return the tanahBandara
     */
    public LkokTanahBandara getTanahBandara() {
        return tanahBandara;
    }

    /**
     * @param tanahBandara the tanahBandara to set
     */
    public void setTanahBandara(LkokTanahBandara tanahBandara) {
        this.tanahBandara = tanahBandara;
    }
    
}
