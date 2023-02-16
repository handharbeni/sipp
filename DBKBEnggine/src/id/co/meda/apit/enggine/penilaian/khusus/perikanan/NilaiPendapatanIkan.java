/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

/**
 *
 * @author I Putu Medagia A
 */
public class NilaiPendapatanIkan {
    
    private String nop;
    private String jenis; //kode 01 untuk pembudidayaan dan 02 untuk penangkapan
    private String tahun;
    private double hasilProduksi = 0;
    private double hargaPasar = 0;
    private double hasilProduksiSeluruhnya = 0;
    private double biayaOperasional = 0;
    private double hasilBersih = 0;
    private double nilaiKeseluruhan = 0;

    /**
     * @return the jenis
     */
    public String getJenis() {
        
        if(jenis.equalsIgnoreCase("01"))
        {
            return "pembudidayaan";
        }else
        {
            return "penangkapan";
        }
        
    }
    
    public String getKodeJenis()
    {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the tahun
     */
    public String getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    /**
     * @return the hasilProduksi
     */
    public double getHasilProduksi() {
        return hasilProduksi;
    }

    /**
     * @param hasilProduksi the hasilProduksi to set
     */
    public void setHasilProduksi(double hasilProduksi) {
        this.hasilProduksi = hasilProduksi;
    }

    /**
     * @return the hargaPasar
     */
    public double getHargaPasar() {
        return hargaPasar;
    }

    /**
     * @param hargaPasar the hargaPasar to set
     */
    public void setHargaPasar(double hargaPasar) {
        this.hargaPasar = hargaPasar;
    }

    /**
     * @return the hasilProduksiSeluruhnya
     */
    public double getHasilProduksiSeluruhnya() {
        hasilProduksiSeluruhnya = hargaPasar*hasilProduksi;
        return hasilProduksiSeluruhnya;
    }

    /**
     * @return the biayaOperasional
     */
    public double getBiayaOperasional() {
        return biayaOperasional;
    }

    /**
     * @param biayaOperasional the biayaOperasional to set
     */
    public void setBiayaOperasional(double biayaOperasional) {
        this.biayaOperasional = biayaOperasional;
    }

    /**
     * @return the hasilBersih
     */
    public double getHasilBersih() {
        hasilBersih = this.getHasilProduksiSeluruhnya() - this.getBiayaOperasional();
        return hasilBersih;
    }

    /**
     * @return the nilaiKeseluruhan
     */
    public double getNilaiKeseluruhan() {
        if(jenis.equalsIgnoreCase("01"))
        {
            this.nilaiKeseluruhan = this.getHasilBersih() * 8;
        }else
        {
            this.nilaiKeseluruhan = this.getHasilBersih() * 10;
        }
        return nilaiKeseluruhan;
    }

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
    
    
}
