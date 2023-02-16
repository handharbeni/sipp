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
public class ModelStat {
    
    private double cum;
    private double avg1;
    private double avg2;
    private double smooth;
    private String tahunDBKB;
    private double jumlahLantai;
    
    
    public ModelStat(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }
    /**
     * @return the cum
     */
    public double getCum() {
        return cum;
    }

    /**
     * @param cum the cum to set
     */
    public void setCum(double cum) {
        this.cum = cum;
    }

    /**
     * @return the avg1
     */
    public double getAvg1() {
        return avg1;
    }

    /**
     * @param avg1 the avg1 to set
     */
    public void setAvg1(double avg1) {
        this.avg1 = avg1;
    }

    /**
     * @return the avg2
     */
    public double getAvg2() {
        return avg2;
    }

    /**
     * @param avg2 the avg2 to set
     */
    public void setAvg2(double avg2) {
        this.avg2 = avg2;
    }

    /**
     * @return the smooth
     */
    public double getSmooth() {
        return smooth;
    }

    /**
     * @param smooth the smooth to set
     */
    public void setSmooth(double smooth) {
        this.smooth = smooth;
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
    
    
    
    
    
    
}
