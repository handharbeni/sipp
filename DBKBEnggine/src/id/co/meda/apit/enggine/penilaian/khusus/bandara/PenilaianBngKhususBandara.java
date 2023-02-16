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
public class PenilaianBngKhususBandara {
    private String jpb;
    private double luas = 0;
    private double nilPerM2 = 0;
    private double nilTotal = 0;

   
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
     * @return the luas
     */
    public double getLuas() {
        return luas;
    }

    /**
     * @param luas the luas to set
     */
    public void setLuas(double luas) {
        this.luas = luas;
    }

    /**
     * @return the nilPerM2
     */
    public double getNilPerM2() {
        return nilPerM2;
    }

    /**
     * @param nilPerM2 the nilPerM2 to set
     */
    public void setNilPerM2(double nilPerM2) {
        this.nilPerM2 = nilPerM2;
    }

    /**
     * @return the nilTotal
     */
    public double getNilTotal() {
        return nilTotal;
    }

    /**
     * @param nilTotal the nilTotal to set
     */
    public void setNilTotal(double nilTotal) {
        this.nilTotal = nilTotal;
    }
    
}
