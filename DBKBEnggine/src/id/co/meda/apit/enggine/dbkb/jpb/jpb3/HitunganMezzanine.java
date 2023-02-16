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
public class HitunganMezzanine {
    private final String thnPenilaian;
    private ArrayList<ItemHitungan> listItemHitungan;
    private final Double luas = 3927.0;

    public HitunganMezzanine(String thnPenilaian) {
        this.thnPenilaian=thnPenilaian;
    }
    
    public Double getMezzanine() { return getTotal()/luas; }
    public Double getTotal() { return getJumlah()+getImb()+getPpnFee(); }
    public Double getPpnFee() { return 0.2 * getJumlah();}
    public Double getImb() { return 0.02 * getJumlah();}
    public Double getJumlah() { return getTotListItemHitungan()+getPrelim();}
    public Double getPrelim() { return 0.011 * getTotListItemHitungan();}  
    
    public Double getTotListItemHitungan() {
        Double nilTotal = 0.0;
         try {
             for (int i = 0; i < listItemHitungan.size(); i++) {
                     nilTotal = nilTotal+listItemHitungan.get(i).getJmlHitungan();
             }
             return nilTotal;
         } catch (Exception e) {
             return nilTotal;
         }
    }

    public String getThnPenilaian() {
        return this.thnPenilaian;
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


 }
