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
public class ModelPendapatanPerikanan {

private String nop;
private ArrayList<ModelIkan> penangkapanIkan;
private ArrayList<ModelIkan> pembudidayaIkan;

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
     * @return the pembudidayaIkan
     */
    public ArrayList<ModelIkan> getPembudidayaIkan() {
        return pembudidayaIkan;
    }

    /**
     * @param pembudidayaIkan the pembudidayaIkan to set
     */
    public void setPembudidayaIkan(ArrayList<ModelIkan> pembudidayaIkan) {
        this.pembudidayaIkan = pembudidayaIkan;
    }

    /**
     * @return the penangkapanIkan
     */
    public ArrayList<ModelIkan> getPenangkapanIkan() {
        return penangkapanIkan;
    }

    /**
     * @param penangkapanIkan the penangkapanIkan to set
     */
    public void setPenangkapanIkan(ArrayList<ModelIkan> penangkapanIkan) {
        this.penangkapanIkan = penangkapanIkan;
    }


    
}
