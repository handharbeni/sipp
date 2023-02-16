/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model;

/**
 *
 * @author meda
 */
public class modelFordat {

    private String tahunDBKB;
    private double jumlahLantai = 0;
    private double y = 0;
    private double u = 0;
    private double logY = 0;
    private double uLogY = 0;
    private double u2 = 0;
    private double logY2 = 0;
    private double y2 = 0;
    private double pol = 0;
    private double exp = 0;
    private double diff = 0;
    
    public modelFordat(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }

    /**
     * @return the jumlahLantai
     */
    public double getJumlahLantai() {
        return jumlahLantai;
    }

    /**
     * @param jumlahLantai the jumlahLantai to set
     */
    public void setJumlahLantai(double jumlahLantai) {
        this.jumlahLantai = jumlahLantai;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the u
     */
    public double getU(double totalLantai) {
        u = getJumlahLantai()-totalLantai;
        return u;
    }

    /**
     * @return the logY
     */
    public double getLogY() {
        logY = Math.log10(getY());
        return logY;
    }

    /**
     * @return the uLogY
     */
    public double getuLogY(double totalLantai) {
        uLogY = getU(totalLantai)*getLogY();
        return uLogY;
    }

    /**
     * @return the u2
     */
    public double getU2(double totalLantai) {
        u2 = getU(totalLantai)*getU(totalLantai);
        return u2;
    }

    /**
     * @return the logY2
     */
    public double getLogY2(double logA,double logB,double totalLantai) {
        logY2 = logA+logB*getU(totalLantai);
        return logY2;
    }

    /**
     * @return the y2
     */
    public double getY2(double logA,double logB,double totalLantai) {
        y2 = Math.pow(10,getLogY2(logA,logB,totalLantai));
        return y2;
    }

    /**
     * @return the pol
     */
    public double getPol() {
        return pol;
    }

    /**
     * @param pol the pol to set
     */
    public void setPol(double pol) {
        this.pol = pol;
    }

    /**
     * @return the exp
     */
    public double getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(double exp) {
        this.exp = exp;
    }

    /**
     * @return the diff
     */
    public double getDiff() {
        return diff;
    }

    /**
     * @param diff the diff to set
     */
    public void setDiff(double diff) {
        this.diff = diff;
    }
    
    
    
    
    
    
    
    
    
   
   
    
    
    
}
