/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.khusus.perikanan.DataPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.HasilPenilaianPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.NilaiBangunanIkan;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportIkanBangunan {
    
    private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private HasilPenilaianPerikanan penilaianIkan;
    private DataPerikanan data;
    
    public TampilkanReportIkanBangunan( HasilPenilaianPerikanan penilaianIkan,DataPerikanan data)
    {
       this.penilaianIkan = penilaianIkan;
       this.data = data;
    }
    
    private LaporanPenilaianIkanUmumBng isiUmumPerikanan()
    {
        LaporanPenilaianIkanUmumBng LaporanUmumIkan = new LaporanPenilaianIkanUmumBng();
        
        Spop spop = data.getSpopIkan().getSpop();
        String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
        
        LaporanUmumIkan.setNop(nop);
        LaporanUmumIkan.setNoIzin(data.getSpopIkan().getSpopTambahan().getNoIzinPerikanan());
        LaporanUmumIkan.setNamaWp(data.getSpopIkan().getSpop().getNamaWp());
        LaporanUmumIkan.setAlamatOP(data.getSpopIkan().getSpop().getJalanOp());
        LaporanUmumIkan.setTahun(penilaianIkan.getTahun());
        LaporanUmumIkan.setArrNilai(isiListRingkasan(penilaianIkan.getBangunanIkan().getNilaiBangunanLspop()));
       LaporanUmumIkan.setObjIkan(isiNilaiBangunan());
        LaporanUmumIkan.setNjop("Rp "+numFormat.format(penilaianIkan.getNjopBangunan())+"");
        return LaporanUmumIkan;
    }
    
    
    private ArrayList<LaporanPenilaianIkanBngRingkas> isiNilaiBangunan()
    {
        
        ArrayList<LaporanPenilaianIkanBngRingkas> arr = new ArrayList<LaporanPenilaianIkanBngRingkas>();
        LaporanPenilaianIkanBngRingkas bngRingkas =  new LaporanPenilaianIkanBngRingkas(); 
        NilaiBangunanIkan temp = penilaianIkan.getBangunanIkan();
        
        bngRingkas.setLuasTotal(numFormat.format(temp.getLuasTotal()));
        bngRingkas.setNilaiTotal(numFormat.format(temp.getNilaiTotal()));
        bngRingkas.setKelasBangunan(temp.getKelasBangunan());
        bngRingkas.setNilaiPerM2(numFormat.format(temp.getNjopPerM2()));
        bngRingkas.setNjop("Rp "+numFormat.format(temp.getNilaiKeseluruhan()));
        
        arr.add(bngRingkas);
        
        return arr;
    }
    
    private ArrayList<LaporanPenilaianRingkas> isiListRingkasan(ArrayList<NilaiBangunan> listNB) {
        ArrayList<LaporanPenilaianRingkas> listPenilRingkas = new ArrayList<>();
        
        for (int i=0;i<listNB.size();i++) {
            LaporanPenilaianRingkas pr = new LaporanPenilaianRingkas();
            pr.setBngKe(listNB.get(i).getBngKe());
            pr.setJpb(listNB.get(i).getJpb());
            pr.setLuasBng(numFormat.format(listNB.get(i).getLuasBng())+" m2");
            pr.setJmlLtBng(numFormat.format(listNB.get(i).getJmlLtBng()));
            pr.setNilBng(numFormat.format(Math.round(listNB.get(i).getNilaiBangunan())));
            listPenilRingkas.add(pr);
        }
        return listPenilRingkas;
    }
    
    public void tampilkanReportBangunan()
    {
        ArrayList<LaporanPenilaianIkanUmumBng> listLprnUmumIkanBng = new ArrayList<LaporanPenilaianIkanUmumBng>();
        listLprnUmumIkanBng.add(isiUmumPerikanan());
        
        
      
        ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLprnUmumIkanBng, "id/co/meda/apit/visual/report/rptLapBangunanIkan.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
      
    }
    
}
