/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.jpb13;

/**
 *
 * @author meda
 */
public class ModelKUJpb13 {
    private String tahunDBKB;
    private int jumlahLantai = 0;
    private double str = 0;
    private double pre = 0;
    private double preKaliStr = 0;
    private double sub = 0;
    private double subKaliStr = 0;
    private double roof = 0;
    private double precast = 0;
    private double stair = 0;
    private double tot = 0;
    private double area = 0;
    private double totBagiArea = 0;
    
    public ModelKUJpb13(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }

    /**
     * @return the jumlahLantai
     */
    public int getJumlahLantai() {
        return jumlahLantai;
    }

    /**
     * @param jumlahLantai the jumlahLantai to set
     */
    public void setJumlahLantai(int jumlahLantai) {
        this.jumlahLantai = jumlahLantai;
    }

    /**
     * @return the str
     */
    public double getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(double str) {
        this.str = str;
    }

    /**
     * @return the pre
     */
    public double getPre() {
        return pre;
    }

    /**
     * @param pre the pre to set
     */
    public void setPre(double pre) {
        this.pre = pre;
    }

    /**
     * @return the preKaliStr
     */
    public double getPreKaliStr() {
        preKaliStr = getPre()*getStr();
        return preKaliStr;
    }

    /**
     * @return the sub
     */
    public double getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(double sub) {
        this.sub = sub;
    }

    /**
     * @return the subKaliStr
     */
    public double getSubKaliStr() {
        subKaliStr = getSub()*getStr();
        return subKaliStr;
    }

    /**
     * @return the roof
     */
    public double getRoof() {
        return roof;
    }

    /**
     * @param roof the roof to set
     */
    public void setRoof(double roof) {
        this.roof = roof;
    }

    /**
     * @return the precast
     */
    public double getPrecast() {
        return precast;
    }

    /**
     * @param precast the precast to set
     */
    public void setPrecast(double precast) {
        this.precast = precast;
    }

    /**
     * @return the stair
     */
    public double getStair() {
        return stair;
    }

    /**
     * @param stair the stair to set
     */
    public void setStair(double stair) {
        this.stair = stair;
    }

    /**
     * @return the tot
     */
    public double getTot(double PpnFee) {
        tot = getStr()+getPreKaliStr()+getSubKaliStr()+PpnFee*(getStr()+getPreKaliStr()+getSubKaliStr());
        return tot;
    }
    
    public double getTotSpesial(double PpnFee) {
        tot = getStr()+getPreKaliStr()+getSubKaliStr()+this.getPrecast()+PpnFee*(getStr()+this.getPrecast()+getPreKaliStr()+getSubKaliStr());
        return tot;
    }
    
    

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the totKaliArea
     */
    public double getTotBagiArea(double PpnFee) {
        totBagiArea = getTot(PpnFee)/getArea();
        return totBagiArea;
    }
    
    /**
     * @return the totKaliArea
     */
    public double getTotBagiAreaSpesial(double PpnFee) {
        totBagiArea = getTotSpesial(PpnFee)/getArea();
        return totBagiArea;
    }
    
    
    
    
    
    
}
