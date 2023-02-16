/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.bsm;

import java.util.HashMap;

/**
 *
 * @author meda
 */
public class ModelTableBsm1 {
    private String tahunDBKB;
    private HashMap<String,ItemBsm> preliminaries;
    private HashMap<String,ItemBsm> siteWork;
    private HashMap<String,ItemBsm> basementTwo;
    private HashMap<String,ItemBsm> basementOne;
    private HashMap<String,ItemBsm> semiBasement;
    private HashMap<String,ItemBsm> roof;
    private HashMap<String,ItemBsm> raillingRamp;
    private HashMap<String,ItemBsm> stp;
    private HashMap<String,ItemBsm> reservoir;
    
    private double sumCostPreliminaries;
    private double sumCostSiteWork;
    private double sumCostBasementTwo;
    private double sumCostBasementOne;
    private double sumCostSemiBasement;
    private double sumCostRoof;
    private double sumCostRaillingRamp;
    private double sumCostStp;
    private double sumCostReservoir;
    
    private double jumlah;
    private double ppnFee;
    private double imb;
    private double jumlahPekerjaanSubdanSup;
    private double luasBangunan;
    private double nilaiDBKB;
    private double nilaiSanitary;
    
    
    
    
    
        
    public ModelTableBsm1(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        preliminaries = new HashMap<String,ItemBsm>();
        siteWork = new HashMap<String,ItemBsm>();
        basementTwo = new HashMap<String,ItemBsm>();
        basementOne = new HashMap<String,ItemBsm>();
        semiBasement = new HashMap<String,ItemBsm>();
        roof = new HashMap<String,ItemBsm>();
        raillingRamp = new HashMap<String,ItemBsm>();
        stp = new HashMap<String,ItemBsm>();
        reservoir = new HashMap<String,ItemBsm>();
    }
    

    /**
     * @return the preliminaries
     */
    public HashMap<String,ItemBsm> getPreliminaries() {
        return preliminaries;
    }

    /**
     * @param preliminaries the preliminaries to set
     */
    public void setPreliminaries(HashMap<String,ItemBsm> preliminaries) {
        this.preliminaries = preliminaries;
    }

    /**
     * @return the siteWork
     */
    public HashMap<String,ItemBsm> getSiteWork() {
        return siteWork;
    }

    /**
     * @param siteWork the siteWork to set
     */
    public void setSiteWork(HashMap<String,ItemBsm> siteWork) {
        this.siteWork = siteWork;
    }

    /**
     * @return the basementTwo
     */
    public HashMap<String,ItemBsm> getBasementTwo() {
        return basementTwo;
    }

    /**
     * @param basementTwo the basementTwo to set
     */
    public void setBasementTwo(HashMap<String,ItemBsm> basementTwo) {
        this.basementTwo = basementTwo;
    }

    /**
     * @return the basementOne
     */
    public HashMap<String,ItemBsm> getBasementOne() {
        return basementOne;
    }

    /**
     * @param basementOne the basementOne to set
     */
    public void setBasementOne(HashMap<String,ItemBsm> basementOne) {
        this.basementOne = basementOne;
    }

    /**
     * @return the semiBasement
     */
    public HashMap<String,ItemBsm> getSemiBasement() {
        return semiBasement;
    }

    /**
     * @param semiBasement the semiBasement to set
     */
    public void setSemiBasement(HashMap<String,ItemBsm> semiBasement) {
        this.semiBasement = semiBasement;
    }

    /**
     * @return the roof
     */
    public HashMap<String,ItemBsm> getRoof() {
        return roof;
    }

    /**
     * @param roof the roof to set
     */
    public void setRoof(HashMap<String,ItemBsm> roof) {
        this.roof = roof;
    }

    /**
     * @return the raillingRamp
     */
    public HashMap<String,ItemBsm> getRaillingRamp() {
        return raillingRamp;
    }

    /**
     * @param raillingRamp the raillingRamp to set
     */
    public void setRaillingRamp(HashMap<String,ItemBsm> raillingRamp) {
        this.raillingRamp = raillingRamp;
    }

    /**
     * @return the stp
     */
    public HashMap<String,ItemBsm> getStp() {
        return stp;
    }

    /**
     * @param stp the stp to set
     */
    public void setStp(HashMap<String,ItemBsm> stp) {
        this.stp = stp;
    }

    /**
     * @return the reservoir
     */
    public HashMap<String,ItemBsm> getReservoir() {
        return reservoir;
    }

    /**
     * @param reservoir the reservoir to set
     */
    public void setReservoir(HashMap<String,ItemBsm> reservoir) {
        this.reservoir = reservoir;
    }

    /**
     * @return the sumCostPreliminaries
     */
    public double getSumCostPreliminaries() {
      double sumCostPreliminaries = 0;
      for(ItemBsm value : preliminaries.values())
      {
            
          sumCostPreliminaries += value.getCost();
          
      }
        return sumCostPreliminaries;
    }

    /**
     * @return the sumCostSiteWork
     */
    public double getSumCostSiteWork() {
       double sumCostSiteWork = 0;
      for(ItemBsm value : siteWork.values())
      {
          sumCostSiteWork += value.getCost();
      }
        return sumCostSiteWork;
    }

    /**
     * @return the sumCostBasementTwo
     */
    public double getSumCostBasementTwo() {
      double sumCostBasementTwo = 0;
      for(ItemBsm value : basementTwo.values())
      {
          sumCostBasementTwo += value.getCost();
      
      }
        return sumCostBasementTwo;
    }

    /**
     * @return the sumCostBasementOne
     */
    public double getSumCostBasementOne() {
      double sumCostBasementOne = 0;
      for(ItemBsm value : basementOne.values())
      {
          sumCostBasementOne += value.getCost();
      }
        return sumCostBasementOne;
    
    }

    /**
     * @return the sumCostSemiBasement
     */
    public double getSumCostSemiBasement() {
      double sumCostSemiBasement = 0;
      for(ItemBsm value : semiBasement.values())
      {
          sumCostSemiBasement += value.getCost();
      }
        return sumCostSemiBasement;
    }

    /**
     * @return the sumCostRoof
     */
    public double getSumCostRoof() {
      double sumCostRoof = 0;
      for(ItemBsm value : roof.values())
      {
          sumCostRoof += value.getCost();
      }
        return sumCostRoof;
    }

    /**
     * @return the sumCostRaillingRamp
     */
    public double getSumCostRaillingRamp() {
       double sumCostRaillingRamp = 0;
       for(ItemBsm value : raillingRamp.values())
       {
          sumCostRaillingRamp += value.getCost();
       } 
        return sumCostRaillingRamp;
    }

    /**
     * @return the sumCostStp
     */
    public double getSumCostStp() {
       double sumCostStp = 0;
       for(ItemBsm value : stp.values())
       {
          sumCostStp += value.getCost();
       }
        
        return sumCostStp;
    }

    /**
     * @return the sumCostReservoir
     */
    public double getSumCostReservoir() {
       double sumCostReservoir = 0;
       for(ItemBsm value : reservoir.values())
       {
          sumCostReservoir += value.getCost();
       }
        return sumCostReservoir;
    }
    
    public double getJumlah()
    {
        jumlah = this.getSumCostBasementOne()+
               this.getSumCostBasementTwo()+
               this.getSumCostPreliminaries()+
               this.getSumCostRaillingRamp()+
               this.getSumCostReservoir()+
               this.getSumCostRoof()+
               this.getSumCostSemiBasement()+
               this.getSumCostSiteWork()+
               this.getSumCostStp();
        return jumlah;
    }

    /**
     * @return the ppnFee
     */
    public double getPpnFee(double ppnFee) {
        ppnFee = getJumlah()*ppnFee;
        return ppnFee;
    }

    /**
     * @return the imb
     */
    public double getImb(double persenImb) {
        imb = getJumlah()*persenImb;
        return imb;
    }

    /**
     * @return the jumlahPekerjaanSubdanSup
     */
    public double getJumlahPekerjaanSubdanSup(double persenImb,double ppnFee) {
        jumlahPekerjaanSubdanSup = getJumlah()+getPpnFee(ppnFee)+getImb(persenImb);
        return jumlahPekerjaanSubdanSup;
    }

    /**
     * @return the luasBangunan
     */
    public double getLuasBangunan() {
        return luasBangunan;
    }

    /**
     * @param luasBangunan the luasBangunan to set
     */
    public void setLuasBangunan(double luasBangunan) {
        this.luasBangunan = luasBangunan;
    }

    /**
     * @return the nilaiDBKB
     */
    public double getNilaiDBKB(double persenImb,double ppnFee) {
        nilaiDBKB = this.getJumlahPekerjaanSubdanSup(persenImb, ppnFee)/this.getLuasBangunan();
        return nilaiDBKB;
    }

    /**
     * @return the nilaiSanitary
     */
    public double getNilaiSanitary(double persenImb,double ppnFee,double persenSanitary) {
        nilaiSanitary = this.getNilaiDBKB(persenImb, ppnFee)*persenSanitary;
        return nilaiSanitary;
    }
    
    
    
        
    
    
    
}
