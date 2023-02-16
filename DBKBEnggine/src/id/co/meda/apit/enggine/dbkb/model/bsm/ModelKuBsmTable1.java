/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.bsm;

/**
 *
 * @author meda
 */
public class ModelKuBsmTable1 {
    
    private String tahunDBKB;
    private double lantai = 0;
    private double dbkbPerLantai = 0;
    private double str = 0;
    private double pre = 0;
    private double preKaliStr = 0;
    private double site = 0;
    private double siteKaliStr = 0;
    private double roof = 0;
    private double rail = 0;
    private double stp = 0;
    private double res = 0;
    private double tot = 0;
    private double ppn = 0;
    private double totSetelahPpn = 0;
    private double area = 0;
    private double dbkb = 0;

    public ModelKuBsmTable1(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }
    
    
    
    /**
     * @return the lantai
     */
    public double getLantai() {
        return lantai;
    }

    /**
     * @param lantai the lantai to set
     */
    public void setLantai(double lantai) {
        this.lantai = lantai;
    }

    /**
     * @return the dbkbPerLantai
     */
    public double getDbkbPerLantai() {
        return dbkbPerLantai;
    }

    /**
     * @param dbkbPerLantai the dbkbPerLantai to set
     */
    public void setDbkbPerLantai(double dbkbPerLantai) {
        this.dbkbPerLantai = dbkbPerLantai;
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
     * @return the site
     */
    public double getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(double site) {
        this.site = site;
    }

    /**
     * @return the siteKaliStr
     */
    public double getSiteKaliStr() {
        siteKaliStr = getSite()*getStr();
        return siteKaliStr;
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
     * @return the rail
     */
    public double getRail() {
        return rail;
    }

    /**
     * @param rail the rail to set
     */
    public void setRail(double rail) {
        this.rail = rail;
    }

    /**
     * @return the stp
     */
    public double getStp() {
        return stp;
    }

    /**
     * @param stp the stp to set
     */
    public void setStp(double stp) {
        this.stp = stp;
    }

    /**
     * @return the res
     */
    public double getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(double res) {
        this.res = res;
    }

    /**
     * @return the tot
     */
    public double getTot() {
        tot = this.getStr()+this.getSiteKaliStr()+this.getPreKaliStr()+this.getRail();
        return tot;
    }

    
    /**
     * @return the ppn
     */
    public double getPpn(double ppnFee) {
        ppn = this.getTot()*ppnFee;
        return ppn;
    }

    
    /**
     * @return the totSetelahPpn
     */
    public double getTotSetelahPpn(double ppnFee) {
        totSetelahPpn = this.getPpn(ppnFee)+getTot();
        return totSetelahPpn;
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
     * @return the dbkb
     */
    public double getDbkbdanDbkbKum(double ppn) {
        dbkb = this.getTotSetelahPpn(ppn)/this.getArea();
        return dbkb;
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
