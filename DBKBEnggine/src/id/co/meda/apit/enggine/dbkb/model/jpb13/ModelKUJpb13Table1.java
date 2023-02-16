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
public class ModelKUJpb13Table1 extends ModelKUJpb13 {

    private double DbkbPerLantai;
    private double DbkbKumulatif;
    
    
    public ModelKUJpb13Table1(String tahunDBKB) {
        super(tahunDBKB);
    }
    
    
    public double getTotTable1(double PpnFee)
    {
        double total = (super.getStr()+super.getPreKaliStr()
                +super.getSubKaliStr()+super.getPrecast()
                +super.getRoof()+super.getStair())+PpnFee*(super.getStr()+super.getPreKaliStr()
                +super.getSubKaliStr()+super.getPrecast()
                +super.getRoof()+super.getStair());
        
        return total;
        
    }
    
    public double getTotBagiAreaTable1(double PpnFee)
    {
        double total = this.getTotTable1(PpnFee)/super.getArea();
        return total;
        
    }
    
    
    

    /**
     * @return the DbkbPerLantai
     */
    public double getDbkbPerLantai() {
        return DbkbPerLantai;
    }

    /**
     * @param DbkbPerLantai the DbkbPerLantai to set
     */
    public void setDbkbPerLantai(double DbkbPerLantai) {
        this.DbkbPerLantai = DbkbPerLantai;
    }

    /**
     * @return the DbkbKumulatif
     */
    public double getDbkbKumulatif() {
        return DbkbKumulatif;
    }

    /**
     * @param DbkbKumulatif the DbkbKumulatif to set
     */
    public void setDbkbKumulatif(double DbkbKumulatif) {
        this.DbkbKumulatif = DbkbKumulatif;
    }
    
    
    
}
