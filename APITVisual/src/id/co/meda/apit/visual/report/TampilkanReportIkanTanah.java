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
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportIkanTanah {
    private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private HasilPenilaianPerikanan penilaianIkan;
    private DataPerikanan data;
    
    public TampilkanReportIkanTanah( HasilPenilaianPerikanan penilaianIkan,DataPerikanan data)
    {
       this.penilaianIkan = penilaianIkan;
       this.data = data;
    }
    
    private LaporanPenilaianIkanUmum<LaporanPenilaianIkanTanahDetil> isiUmumPerikanan()
    {
        LaporanPenilaianIkanUmum<LaporanPenilaianIkanTanahDetil> LaporanUmumIkan = new LaporanPenilaianIkanUmum<LaporanPenilaianIkanTanahDetil>();
        
        Spop spop = data.getSpopIkan().getSpop();
        String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
        
        
        LaporanUmumIkan.setNop(nop);
        LaporanUmumIkan.setNoIzin(data.getSpopIkan().getSpopTambahan().getNoIzinPerikanan());
        LaporanUmumIkan.setNamaWp(data.getSpopIkan().getSpop().getNamaWp());
        LaporanUmumIkan.setAlamatOP(data.getSpopIkan().getSpop().getJalanOp());
        LaporanUmumIkan.setTahun(penilaianIkan.getTahun());
        LaporanUmumIkan.setArrIkan(isiNilaiTanah());
        LaporanUmumIkan.setNjop("Rp "+numFormat.format(penilaianIkan.getNjopTanah())+"");
        return LaporanUmumIkan;
    }
    
    
    private ArrayList<LaporanPenilaianIkanTanahDetil> isiNilaiTanah()
    {
        ArrayList<LaporanPenilaianIkanTanahDetil> arrTanah = new ArrayList<LaporanPenilaianIkanTanahDetil>();
        for(int i = 0;i < penilaianIkan.getArrTanahIkan().size();i++)
        {
            if(data.getSpopIkan().getSpopBumi().get(i).getLuas() != 0)
            {
                System.out.println(data.getSpopIkan().getSpopBumi().get(i).getLuas());
                
                LaporanPenilaianIkanTanahDetil tempTanah = new LaporanPenilaianIkanTanahDetil();
                tempTanah.setLuas(numFormat.format(data.getSpopIkan().getSpopBumi().get(i).getLuas())+" m2");
                tempTanah.setPeruntukan(data.getSpopIkan().getSpopBumi().get(i).getPeruntukan());
                tempTanah.setNilaiPerM2(numFormat.format(penilaianIkan.getArrTanahIkan().get(i).getNilaiPerm2())+"");
                tempTanah.setNilaiKeseluruhan(numFormat.format(penilaianIkan.getArrTanahIkan().get(i).getNilaiKeseluruhan())+"");
                arrTanah.add(tempTanah);
            }
         }
        
        return arrTanah;
    }
    
    public void tampilkanReportTanah()
    {
        ArrayList<LaporanPenilaianIkanUmum> listLprnUmumIkan = new ArrayList<LaporanPenilaianIkanUmum>();
        listLprnUmumIkan.add(isiUmumPerikanan());
        
        ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLprnUmumIkan, "id/co/meda/apit/visual/report/rptLapTanahIkan.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }
    
    
    
    
    
}
