/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb3;

import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class HitunganDayaDukung {
    private String thnPenilaian;
    private ArrayList<ItemHitungan> listItemHitungan;
    private ItemHitungan slabBeton;
    
    
    public Double getJumlah() { return slabBeton.getJmlHitungan(); }
    public Double getImb() { return getJumlah()*0.02; }
    public Double getPpnFee() { return getJumlah()*0.2; }
    public Double getTotal() { return getJumlah()+getImb()+getPpnFee(); }
    
    
    public HitunganDayaDukung(String thnPenilaian) {
        this.thnPenilaian=thnPenilaian;
    }

    /**
     * @return the listItemHitungan
     */
    public ArrayList<ItemHitungan> getListItemHitungan() {
        return listItemHitungan;
    }

    /**
     * @param listItemHitungan the listItemHitungan to set
     */
    public void setListItemHitungan(ArrayList<ItemHitungan> listItemHitungan) {
        this.listItemHitungan = listItemHitungan;
    }

    /**
     * @return the slabBeton
     */
    public ItemHitungan getSlabBeton() {
        return slabBeton;
    }

    /**
     * @param slabBeton the slabBeton to set
     */
    public void setSlabBeton(ItemHitungan slabBeton) {
        this.slabBeton = slabBeton;
    }

}
