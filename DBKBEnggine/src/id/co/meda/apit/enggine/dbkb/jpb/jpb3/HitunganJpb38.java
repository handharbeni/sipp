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
public class HitunganJpb38 {
    final private String thnPenilaian;
    private ArrayList<ItemHitungan> listPekerjaanTanah; 
    private ArrayList<ItemHitungan> listPekerjaanPondasi; 
    private ArrayList<ItemHitungan> listStrukturKolom; 
    private ItemHitungan strukturBata; 
    private ItemHitungan strukturRingbalk; 
    private ArrayList<ItemHitungan> listAtap; 
    private ItemHitungan strukturSlabBeton; 
    private final Double lsLantai = 1692.0;
    private final Double panjang = 72.0;
    private final Double lebar = 23.5;
    private final Double tinggi = 9.0;
    
    public HitunganJpb38(String thnPenilaian){
        this.thnPenilaian = thnPenilaian;
    };
    
    //bingung kan ? :D
    //---------------------------------------
    public Double getTotE() {
        return getStrukturRingbalk().getJmlHitungan()+getTotListAtap()+getStrukturSlabBeton().getJmlHitungan(); 
    }

    public Double getTotD() {return getTotListStrukturKolom()+getStrukturBata().getJmlHitungan(); }
    public Double getTotC() {return getTotListPekerjaanTanah()+getTotListPekerjaanPondasi(); }
    public Double getTotB() {return getTotListAtap()+getStrukturSlabBeton().getJmlHitungan();}
    
    public Double getTotA() {
        return getTotListPekerjaanTanah()+getTotListPekerjaanPondasi()
             + getTotListStrukturKolom()+getStrukturBata().getJmlHitungan()
             + getStrukturRingbalk().getJmlHitungan();
    }
    
    //----------------------------------------
    
    public Double getJmlDbkb() {return getJmlTotal()/getLsLantai();}
    public Double getJmlTotal() {return getJmlHitPre()+getJmlImb()+getJmlPpnFee();}
    public Double getJmlPpnFee() { return 0.2*getJmlHitPre();}
    public Double getJmlImb() {return 0.02*getJmlHitPre();}

    public Double getJmlHitPre() {return getJmlHitungan()+getPreliminaries();}
    public Double getPreliminaries() {return getJmlHitungan()*0.012;}

    public Double getJmlHitungan() {
        return getTotListPekerjaanTanah()+getTotListPekerjaanPondasi()
                +getTotListStrukturKolom()+getStrukturBata().getJmlHitungan()
                +getStrukturRingbalk().getJmlHitungan()+getTotListAtap()
                +getStrukturSlabBeton().getJmlHitungan();
    }
    
    
    public Double getTotListPekerjaanTanah() {
        return getNilaiTotalPerKomponen(listPekerjaanTanah);
    }

    public Double getTotListPekerjaanPondasi() {
        return getNilaiTotalPerKomponen(listPekerjaanPondasi);
    }

    public Double getTotListStrukturKolom() {
        return getNilaiTotalPerKomponen(listStrukturKolom);
    }
    
    public Double getTotListAtap() {
        return getNilaiTotalPerKomponen(listAtap);
    }

    private Double getNilaiTotalPerKomponen(ArrayList<ItemHitungan> namaKomponen) {
        Double nilTotal = 0.0;
        try {
            for (int i = 0; i < namaKomponen.size(); i++) {
                    nilTotal = nilTotal+namaKomponen.get(i).getJmlHitungan();
            }
            return nilTotal;
        } catch (Exception e) {
            return nilTotal;
        }
    }
    
    /**
     * @return the listPekerjaanTanah
     */
    public ArrayList<ItemHitungan> getListPekerjaanTanah() {
        return listPekerjaanTanah;
    }

    /**
     * @param listPekerjaanTanah the listPekerjaanTanah to set
     */
    public void setListPekerjaanTanah(ArrayList<ItemHitungan> listPekerjaanTanah) {
        this.listPekerjaanTanah = listPekerjaanTanah;
    }

    /**
     * @return the listPekerjaanPondasi
     */
    public ArrayList<ItemHitungan> getListPekerjaanPondasi() {
        return listPekerjaanPondasi;
    }

    /**
     * @param listPekerjaanPondasi the listPekerjaanPondasi to set
     */
    public void setListPekerjaanPondasi(ArrayList<ItemHitungan> listPekerjaanPondasi) {
        this.listPekerjaanPondasi = listPekerjaanPondasi;
    }

    /**
     * @return the listStrukturKolom
     */
    public ArrayList<ItemHitungan> getListStrukturKolom() {
        return listStrukturKolom;
    }

    /**
     * @param listStrukturKolom the listStrukturKolom to set
     */
    public void setListStrukturKolom(ArrayList<ItemHitungan> listStrukturKolom) {
        this.listStrukturKolom = listStrukturKolom;
    }

    /**
     * @return the strukturBata
     */
    public ItemHitungan getStrukturBata() {
        return strukturBata;
    }

    /**
     * @param strukturBata the strukturBata to set
     */
    public void setStrukturBata(ItemHitungan strukturBata) {
        this.strukturBata = strukturBata;
    }

    /**
     * @return the strukturRingbalk
     */
    public ItemHitungan getStrukturRingbalk() {
        return strukturRingbalk;
    }

    /**
     * @param strukturRingbalk the strukturRingbalk to set
     */
    public void setStrukturRingbalk(ItemHitungan strukturRingbalk) {
        this.strukturRingbalk = strukturRingbalk;
    }

    /**
     * @return the listAtap
     */
    public ArrayList<ItemHitungan> getListAtap() {
        return listAtap;
    }

    /**
     * @param listAtap the listAtap to set
     */
    public void setListAtap(ArrayList<ItemHitungan> listAtap) {
        this.listAtap = listAtap;
    }

    /**
     * @return the strukturSlabBeton
     */
    public ItemHitungan getStrukturSlabBeton() {
        return strukturSlabBeton;
    }

    /**
     * @param strukturSlabBeton the strukturSlabBeton to set
     */
    public void setStrukturSlabBeton(ItemHitungan strukturSlabBeton) {
        this.strukturSlabBeton = strukturSlabBeton;
    }

    /**
     * @return the lsLantai
     */
    public Double getLsLantai() {
        return lsLantai;
    }

    /**
     * @return the panjang
     */
    public Double getPanjang() {
        return panjang;
    }

    /**
     * @return the lebar
     */
    public Double getLebar() {
        return lebar;
    }

    /**
     * @return the tinggi
     */
    public Double getTinggi() {
        return tinggi;
    }

}
