/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.jalantol;

/**
 *
 * @author I Putu Medagia A
 */
public class DetailTanahJatol {
    
    private String zona;
    private double luas;
    private double njopPerM;
    private double totalNjop;

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
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
     * @return the njopPerM
     */
    public double getNjopPerM() {
        return njopPerM;
    }

    /**
     * @param njopPerM the njopPerM to set
     */
    public void setNjopPerM(double njopPerM) {
        this.njopPerM = njopPerM;
    }

    /**
     * @return the totalNjop
     */
    public double getTotalNjop() {
        return totalNjop;
    }

    /**
     * @param totalNjop the totalNjop to set
     */
    public void setTotalNjop(double totalNjop) {
        this.totalNjop = totalNjop;
    }
}
