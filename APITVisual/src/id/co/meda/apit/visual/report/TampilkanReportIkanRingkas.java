/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.khusus.perikanan.DataPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.HasilPenilaianPerikanan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportIkanRingkas {
    private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private HasilPenilaianPerikanan penilaianIkan;
    private DataPerikanan data;
    
    public TampilkanReportIkanRingkas( HasilPenilaianPerikanan penilaianIkan,DataPerikanan data)
    {
       this.penilaianIkan = penilaianIkan;
       this.data = data;
    }
    
    private LaporanPenilaianIkanUmum isiUmumPerikanan()
    {
        LaporanPenilaianIkanUmum<LaporanPenilaianIkanRingkas> LaporanUmumIkan = new LaporanPenilaianIkanUmum<LaporanPenilaianIkanRingkas>();
        
        Spop spop = data.getSpopIkan().getSpop();
        String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
        
        LaporanUmumIkan.setNop(nop);
        LaporanUmumIkan.setNoIzin(data.getSpopIkan().getSpopTambahan().getNoIzinPerikanan());
        LaporanUmumIkan.setNamaWp(data.getSpopIkan().getSpop().getNamaWp());
        LaporanUmumIkan.setAlamatOP(data.getSpopIkan().getSpop().getJalanOp());
        LaporanUmumIkan.setTahun(penilaianIkan.getTahun());
        LaporanUmumIkan.setArrIkan(isiNilaiRingkas());
        LaporanUmumIkan.setNjop("Rp "+numFormat.format(penilaianIkan.getNjopTanah())+"");
        return LaporanUmumIkan;
    }
    
    
    private ArrayList<LaporanPenilaianIkanRingkas> isiNilaiRingkas()
    {
        LaporanPenilaianIkanRingkas ringkas = new LaporanPenilaianIkanRingkas();
        ringkas.setNjopTanah(numFormat.format(penilaianIkan.getNjopTanah())+"");
        ringkas.setNjopBangunan(numFormat.format(penilaianIkan.getNjopBangunan())+"");
        ringkas.setNjopPerikanan(numFormat.format(penilaianIkan.getNjopPerikanan())+"");
        ringkas.setTotalNjop("Rp."+numFormat.format(penilaianIkan.getNjopTanah()+penilaianIkan.getNjopBangunan()+penilaianIkan.getNjopPerikanan())+"");
        
        ArrayList<LaporanPenilaianIkanRingkas> arrRingkas= new ArrayList<LaporanPenilaianIkanRingkas>();
        arrRingkas.add(ringkas);
        
        return arrRingkas;
    }
    
    public void tampilkanReportRingkasan()
    {
        ArrayList<LaporanPenilaianIkanUmum> listLprnUmumIkan = new ArrayList<LaporanPenilaianIkanUmum>();
        listLprnUmumIkan.add(isiUmumPerikanan());
        
        ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLprnUmumIkan, "id/co/meda/apit/visual/report/rptLapRingkasanIkan.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }
    
    
    
    
    
}
