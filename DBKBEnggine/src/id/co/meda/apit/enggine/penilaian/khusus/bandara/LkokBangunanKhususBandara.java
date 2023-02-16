/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.bandara;

/**
 *
 * @author I Putu Medagia A
 */
public class LkokBangunanKhususBandara {
    
    private String nop;
    private String idJpb;
    private String jpbBandara;
    private double panjang = 0;
    private double lebar = 0;
    private double luas = 0;
    private double perkerasanKaku = 0;
    private double perkerasanLentur = 0;
    
    /**
     * @return the nop
     */
    public String getNop() {
        return nop;
    }

    /**
     * @param nop the nop to set
     */
    public void setNop(String nop) {
        this.nop = nop;
    }

    /**
     * @return the idJpb
     */
    public String getIdJpb() {
        return idJpb;
    }

    /**
     * @param idJpb the idJpb to set
     */
    public void setIdJpb(String idJpb) {
        this.idJpb = idJpb;
    }

    /**
     * @return the jpbBandara
     */
    public String getJpbBandara() {
        return jpbBandara;
    }

    /**
     * @param jpbBandara the jpbBandara to set
     */
    public void setJpbBandara(String jpbBandara) {
        this.jpbBandara = jpbBandara;
    }

    /**
     * @return the panjang
     */
    public double getPanjang() {
        return panjang;
    }

    /**
     * @param panjang the panjang to set
     */
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    
    
    /**
     * @return the lebar
     */
    public double getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the luas
     */
    public double getLuas() {
        return luas;
    }

    /**
     * @param luas the luas to set
     */
    public void setLuas(double luas) {
        this.luas = luas;
    }

    /**
     * @return the perkerasanKaku
     */
    public double getPerkerasanKaku() {
        return perkerasanKaku;
    }

    /**
     * @param perkerasanKaku the perkerasanKaku to set
     */
    public void setPerkerasanKaku(double perkerasanKaku) {
        this.perkerasanKaku = perkerasanKaku;
    }

    /**
     * @return the perkerasanLentur
     */
    public double getPerkerasanLentur() {
        return perkerasanLentur;
    }

    /**
     * @param perkerasanLentur the perkerasanLentur to set
     */
    public void setPerkerasanLentur(double perkerasanLentur) {
        this.perkerasanLentur = perkerasanLentur;
    }
    
}
