/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianIkanTanahDetil {
    
    private String peruntukan;
    private String luas;
    private String nilaiPerM2;
    private String nilaiKeseluruhan;

    /**
     * @return the peruntukan
     */
    public String getPeruntukan() {
        return peruntukan;
    }

    /**
     * @param peruntukan the peruntukan to set
     */
    public void setPeruntukan(String peruntukan) {
        this.peruntukan = peruntukan;
    }

    /**
     * @return the luas
     */
    public String getLuas() {
        return luas;
    }

    /**
     * @param luas the luas to set
     */
    public void setLuas(String luas) {
        this.luas = luas;
    }

    /**
     * @return the nilaiPerM2
     */
    public String getNilaiPerM2() {
        return nilaiPerM2;
    }

    /**
     * @param nilaiPerM2 the nilaiPerM2 to set
     */
    public void setNilaiPerM2(String nilaiPerM2) {
        this.nilaiPerM2 = nilaiPerM2;
    }

    /**
     * @return the nilaiKeseluruhan
     */
    public String getNilaiKeseluruhan() {
        return nilaiKeseluruhan;
    }

    /**
     * @param nilaiKeseluruhan the nilaiKeseluruhan to set
     */
    public void setNilaiKeseluruhan(String nilaiKeseluruhan) {
        this.nilaiKeseluruhan = nilaiKeseluruhan;
    }
}
