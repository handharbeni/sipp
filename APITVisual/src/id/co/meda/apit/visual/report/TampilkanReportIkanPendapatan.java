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
public class TampilkanReportIkanPendapatan {
    
       private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private HasilPenilaianPerikanan penilaianIkan;
    private DataPerikanan data;
    
    public TampilkanReportIkanPendapatan( HasilPenilaianPerikanan penilaianIkan,DataPerikanan data)
    {
       this.penilaianIkan = penilaianIkan;
       this.data = data;
    }
    
    private LaporanPenilaianIkanUmum isiUmumPerikanan()
    {
        LaporanPenilaianIkanUmum<LaporanPenilaianIkanPendDetil> LaporanUmumIkan = new LaporanPenilaianIkanUmum<LaporanPenilaianIkanPendDetil>();
        
        Spop spop = data.getSpopIkan().getSpop();
        String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
        
        LaporanUmumIkan.setNop(nop);
        LaporanUmumIkan.setNoIzin(data.getSpopIkan().getSpopTambahan().getNoIzinPerikanan());
        LaporanUmumIkan.setNamaWp(data.getSpopIkan().getSpop().getNamaWp());
        LaporanUmumIkan.setAlamatOP(data.getSpopIkan().getSpop().getJalanOp());
        LaporanUmumIkan.setTahun(penilaianIkan.getTahun());
        LaporanUmumIkan.setArrIkan(isiNilaiPendapatan());
        LaporanUmumIkan.setNjop("Rp "+numFormat.format(penilaianIkan.getNjopPerikanan())+"");
        return LaporanUmumIkan;
    }
    
    
    private ArrayList<LaporanPenilaianIkanPendDetil> isiNilaiPendapatan()
    {
        ArrayList<LaporanPenilaianIkanPendDetil> arrPend = new ArrayList<LaporanPenilaianIkanPendDetil>();
        for(int i = 0;i < penilaianIkan.getArrPendapatanIkan().size();i++)
        {
            if(penilaianIkan.getArrPendapatanIkan().get(i).getHasilProduksi() != 0)
            {
                LaporanPenilaianIkanPendDetil tempPend = new LaporanPenilaianIkanPendDetil();
                tempPend.setJenisUsaha(penilaianIkan.getArrPendapatanIkan().get(i).getJenis()+" ikan");
                tempPend.setHasilProduksi(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getHasilProduksi())+"");
                tempPend.setHasilBersih(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getHasilBersih())+"");
                tempPend.setBiayaOperasional(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getBiayaOperasional())+"");
                tempPend.setHargaPasar(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getHargaPasar())+"");
                tempPend.setHasilProduksiSeluruhnya(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getHasilProduksiSeluruhnya())+"");
                tempPend.setNilaiSeluruh(numFormat.format(penilaianIkan.getArrPendapatanIkan().get(i).getNilaiKeseluruhan())+"");
                if(penilaianIkan.getArrPendapatanIkan().get(i).getKodeJenis().equalsIgnoreCase("01"))
                tempPend.setKonstanta("8");
                else
                tempPend.setKonstanta("10");
                   
                arrPend.add(tempPend);
            }
          }
        
        return arrPend;
    }
    
    public void tampilkanReportPendapatan()
    {
        ArrayList<LaporanPenilaianIkanUmum> listLprnUmumIkan = new ArrayList<LaporanPenilaianIkanUmum>();
        listLprnUmumIkan.add(isiUmumPerikanan());
        
        ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLprnUmumIkan, "id/co/meda/apit/visual/report/rptLapPendapatanIkan.jrxml");
            
            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }
    
}
