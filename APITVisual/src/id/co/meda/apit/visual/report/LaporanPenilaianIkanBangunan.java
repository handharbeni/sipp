/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class LaporanPenilaianIkanBangunan {
    
    private LaporanPenilaianIkanBngRingkas bngRks = new LaporanPenilaianIkanBngRingkas();
    private ArrayList<LaporanPenilaianRingkas> arrNilai = new ArrayList<LaporanPenilaianRingkas>();

    /**
     * @return the bngRks
     */
    public LaporanPenilaianIkanBngRingkas getBngRks() {
        return bngRks;
    }

    /**
     * @param bngRks the bngRks to set
     */
    public void setBngRks(LaporanPenilaianIkanBngRingkas bngRks) {
        this.bngRks = bngRks;
    }

    /**
     * @return the arrNilai
     */
    public ArrayList<LaporanPenilaianRingkas> getArrNilai() {
        return arrNilai;
    }

    /**
     * @param arrNilai the arrNilai to set
     */
    public void setArrNilai(ArrayList<LaporanPenilaianRingkas> arrNilai) {
        this.arrNilai = arrNilai;
    }
    
    
}
