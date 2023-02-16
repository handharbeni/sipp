/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.model.bsm;

import id.co.meda.apit.enggine.dbkb.model.bsm.ModelKuBsmTable1;

/**
 *
 * @author meda
 */
public class ModelKuBsmTable2 extends ModelKuBsmTable1 {

    private String tahunDBKB;
    private double mis;
    
    public ModelKuBsmTable2(String tahunDBKB) {
        super(tahunDBKB);
        this.tahunDBKB = tahunDBKB;
    }

    /**
     * @return the mis
     */
    public double getMis() {
        return mis;
    }

    /**
     * @param mis the mis to set
     */
    public void setMis(double mis) {
        this.mis = mis;
    }
    
    public double getTot()
    {
        double tot = (super.getStr()+super.getPreKaliStr()+this.getMis())+0.2*(super.getStr()+super.getPreKaliStr()+this.getMis());
        return tot;
    }
    
    public double getDbkb()
    {
        double dbkb = getTot()/getArea();
        return dbkb;
    }
    
    
    
    
    
}
