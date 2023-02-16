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
public class ModelTableBsm2 {
    
    private String tahunDBKB;
    private HashMap<String,ItemBsm> preliminaries;
    private HashMap<String,ItemBsm> earthWork;
    private HashMap<String,ItemBsm> underSubstructureWorks;
    private HashMap<String,ItemBsm> basementTwo;
    private HashMap<String,ItemBsm> basementOne;
    private HashMap<String,ItemBsm> semiBasement;
    
    
    private double sumCostPreliminaries;
    private double sumCostEarthWork;
    private double sumCostUnderSubstructureWorks;
    private double sumCostBasementTwo;
    private double sumCostBasementOne;
    private double sumCostSemiBasement;
    
    private double jumlah;
    private double ppnFee;
    private double imb;
    private double jumlahPekerjaanSubdanSup;
    private double luasBangunan;
    private double nilaiDBKB;
    
        
    
    
    
    
    public ModelTableBsm2(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
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
     * @return the earthWork
     */
    public HashMap<String,ItemBsm> getEarthWork() {
        return earthWork;
    }

    /**
     * @param earthWork the earthWork to set
     */
    public void setEarthWork(HashMap<String,ItemBsm> earthWork) {
        this.earthWork = earthWork;
    }

    /**
     * @return the underSubstructureWorks
     */
    public HashMap<String,ItemBsm> getUnderSubstructureWorks() {
        return underSubstructureWorks;
    }

    /**
     * @param underSubstructureWorks the underSubstructureWorks to set
     */
    public void setUnderSubstructureWorks(HashMap<String,ItemBsm> underSubstructureWorks) {
        this.underSubstructureWorks = underSubstructureWorks;
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
     * @return the sumCostEarthWork
     */
    public double getSumCostEarthWork() {
      double sumCostEarthWork = 0;
      for(ItemBsm value : earthWork.values())
      {
          sumCostEarthWork += value.getCost();
      }
        return sumCostEarthWork;
    }

    /**
     * @return the sumCostUnderSubstructureWorks
     */
    public double getSumCostUnderSubstructureWorks() {
      double sumCostUnderSubstructureWorks = 0;
      for(ItemBsm value : underSubstructureWorks.values())
      {
          sumCostUnderSubstructureWorks += value.getCost();
      }
        return sumCostUnderSubstructureWorks;
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
     * @return the jumlah
     */
    public double getJumlah() {
        jumlah = this.getSumCostPreliminaries()+this.getSumCostEarthWork()+this.getSumCostUnderSubstructureWorks()
                +this.getSumCostBasementOne()+this.getSumCostBasementTwo()+this.getSumCostSemiBasement();
        return jumlah;
    }

    /**
     * @return the ppnFee
     */
    public double getPpnFee(double ppn) {
        ppnFee = this.getJumlah()*ppn;
        return ppnFee;
    }

    /**
     * @return the imb
     */
    public double getImb(double imbFee) {
        imb = this.getJumlah()*imbFee;
        return imb;
    }

    /**
     * @return the jumlahPekerjaanSubdanSup
     */
    public double getJumlahPekerjaanSubdanSup(double ppn,double imbFee) {
        jumlahPekerjaanSubdanSup = this.getJumlah()+this.getPpnFee(ppn)+this.getImb(imbFee); 
        return jumlahPekerjaanSubdanSup;
    }

    /**
     * @return the luasBangunan
     */
    public double getLuasBangunan() {
        return luasBangunan;
    }
    
    public void setLuasBangunan(double luasBangunan) {
        this.luasBangunan = luasBangunan;
    }

    /**
     * @return the nilaiDBKB
     */
    public double getNilaiDBKB(double ppn,double imbFee) {
        nilaiDBKB = this.getJumlahPekerjaanSubdanSup(ppn,imbFee)/this.getLuasBangunan();
        return nilaiDBKB;
    }
    
    
    
}
