/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.headreport.ModelHeadReport;
import id.co.meda.apit.enggine.headreport.ProsesHeadReport;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianBngKhususBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianBngPTBandaraDBKB;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianLspopBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportBandara {
    
    private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private String tahun;
    private String nop;
    private LaporanRingkasanBandara ringkasan;
    
            
    public TampilkanReportBandara(String nop, String tahun){
        this.nop = nop;
        this.tahun = tahun;
    }
    
    private ArrayList<LaporanTanahBandara> isiTanahBandara()
    {
        ArrayList<PenilaianTanahBandara> temp = ToolsPenilaianBandara.getPenilTanahBandara(nop, tahun);
        ArrayList<LaporanTanahBandara> arrPenilTanah = new ArrayList<LaporanTanahBandara>();
        for(int i =0; i<temp.size();i++)
        {
            PenilaianTanahBandara tempPenil = temp.get(i);
            LaporanTanahBandara tempPenil2 = new LaporanTanahBandara();
            tempPenil2.setJnsPenggunaanTanah(tempPenil.getJnsPenggunaanTanah());
            tempPenil2.setLuas(numFormat.format(tempPenil.getLuas()));
            tempPenil2.setNilPerM(numFormat.format(tempPenil.getNilPerM()));
            tempPenil2.setNilTotal(numFormat.format(tempPenil.getNilTotal()));
            tempPenil2.setNir(numFormat.format(tempPenil.getNir()));
            
            arrPenilTanah.add(tempPenil2);
        }
        
        return arrPenilTanah;
    }
    
      private ArrayList<LaporanBngKhususBandara> isiBngKhususBandara()
    {
        ArrayList<PenilaianBngKhususBandara> temp = ToolsPenilaianBandara.getPenilBngKhususBandara(nop, tahun);
        ArrayList<LaporanBngKhususBandara> arrPenil = new ArrayList<LaporanBngKhususBandara>();
        for(int i =0; i<temp.size();i++)
        {
            PenilaianBngKhususBandara tempPenil = temp.get(i);
            LaporanBngKhususBandara tempPenil2 = new LaporanBngKhususBandara();
            tempPenil2.setJpb(tempPenil.getJpb());
            tempPenil2.setLuas(numFormat.format(tempPenil.getLuas()));
            tempPenil2.setNilTotal(numFormat.format(tempPenil.getNilTotal()));
            tempPenil2.setNilPerM2(numFormat.format(tempPenil.getNilPerM2()));
            
            
            arrPenil.add(tempPenil2);
        }
        
        return arrPenil;
    }
      
      private ArrayList<LaporanLspopBandara> isiLspopBandara()
    {
        ArrayList<PenilaianLspopBandara> temp = ToolsPenilaianBandara.getPenilLspopBandara(nop, tahun);
        ArrayList<LaporanLspopBandara> arrPenil = new ArrayList<LaporanLspopBandara>();
        for(int i =0; i<temp.size();i++)
        {
            PenilaianLspopBandara tempPenil = temp.get(i);
            LaporanLspopBandara tempPenil2 = new LaporanLspopBandara();
            tempPenil2.setJpb(tempPenil.getLspop().getJpb());
            tempPenil2.setLuas(numFormat.format(tempPenil.getLspop().getLuas()));
            tempPenil2.setNilTotal(numFormat.format(tempPenil.getNilaiTotal()));
            tempPenil2.setNilPerM(numFormat.format(tempPenil.getNilaiPerM()));
            
            arrPenil.add(tempPenil2);
        }
        
        return arrPenil;
    }
      
       private ArrayList<LaporanBngPTBandara> isiBngPTBandara()
    {
        ArrayList<PenilaianBngPTBandaraDBKB> temp = ToolsPenilaianBandara.getPenilBngPTDBKBBandara(nop, tahun);
        ArrayList<LaporanBngPTBandara> arrPenil = new ArrayList<LaporanBngPTBandara>();
        for(int i =0; i<temp.size();i++)
        {
            PenilaianBngPTBandaraDBKB tempPenil = temp.get(i);
            LaporanBngPTBandara tempPenil2 = new LaporanBngPTBandara();
            tempPenil2.setJpb(tempPenil.getJpb());
            tempPenil2.setLuas(numFormat.format(tempPenil.getLuas()));
            tempPenil2.setNilai_bangunan(numFormat.format(tempPenil.getNilai_bangunan()));
            tempPenil2.setNilai_njop(numFormat.format(tempPenil.getNilai_njop()));
            tempPenil2.setNir(numFormat.format(tempPenil.getNir()));
            
            arrPenil.add(tempPenil2);
        }
        
        return arrPenil;
    }
       
       public void isiRingkasan(String njopTanah, String njopBngKhusus,
               String njopPTDbkb, String njopPTPerM, String njopBandara)
    {
           ringkasan = new LaporanRingkasanBandara();
           ringkasan.setNJOPBandara(njopBandara);
           ringkasan.setNJOPBngKhusus(njopBngKhusus);
           ringkasan.setNJOPBngPTDbkb(njopPTDbkb);
           ringkasan.setNJOPBngPTNilPerM(njopPTPerM);
           ringkasan.setNJOPTanah(njopTanah);
    }
      
    
    private LaporanPenilaianBandara isiBandara()
    {
        LkokTanahBandara tempTanah = ToolsPenilaianBandara.getModelLkokTanah(nop);
        LaporanPenilaianBandara laporan = new LaporanPenilaianBandara();
        laporan.setTahun(tahun);
        laporan.setNop(tempTanah.getNop());
        laporan.setNamaBandara(tempTanah.getNamaBandara());
        laporan.setAlamatBandara(tempTanah.getAlamat());
        
        laporan.setArrPenilTanah(isiTanahBandara());
        laporan.setArrPenilBngKhusus(isiBngKhususBandara());
        laporan.setArrLspopBandara(isiLspopBandara());
        laporan.setArrBngPTBandara(isiBngPTBandara());
        
        ArrayList<ModelJabatan> arrJabatan = isiJabatan();
        
        for(int i = 0; i < arrJabatan.size();i++)
        {
                switch (i) {
                    case 1:
                        laporan.setJabPenilai(arrJabatan.get(i).getJabatan());
                        laporan.setNamaPenilai(arrJabatan.get(i).getNama());
                        laporan.setNipPenilai(arrJabatan.get(i).getNip());
                        break;
                    case 0:
                        laporan.setJabUptd(arrJabatan.get(i).getJabatan());
                        laporan.setNamaUptd(arrJabatan.get(i).getNama());
                        laporan.setNipUptd(arrJabatan.get(i).getNip());
                        break;
                    case 2:
                        laporan.setJabKadis(arrJabatan.get(i).getJabatan());
                        laporan.setNamaKadis(arrJabatan.get(i).getNama());
                        laporan.setNipKadis(arrJabatan.get(i).getNip());
                        break;
                    default:
                        break;
                }
        }
        
        ModelHeadReport head = ProsesHeadReport.getModelHead();
        laporan.setNamaPemDaerah(head.getNamaPemDaerah());
        laporan.setDinasDaerah(head.getDinasDaerah());
        laporan.setAlamatDinas(head.getAlamatDinas());
        
        ArrayList<LaporanRingkasanBandara> arrRingkas = new ArrayList<LaporanRingkasanBandara>();
        arrRingkas.add(ringkasan);
        laporan.setRingkasBandara(arrRingkas);
        return laporan;
    }
    
    private ArrayList<ModelJabatan> isiJabatan()
    {
        ArrayList<ModelJabatan> arrJabatan = new ArrayList<ModelJabatan>();
        arrJabatan = BuatModelPejabat.buatModelJabatan();
        return arrJabatan;
    }
    
     public void tampilkanReportBandara()
    {
        ArrayList<LaporanPenilaianBandara> listLprnBandara = new ArrayList<LaporanPenilaianBandara>();
        listLprnBandara.add(this.isiBandara());
        
        ToolsReport tool = new ToolsReport();
        
            JasperPrint jspPrtMaster = tool.bentukReport(listLprnBandara, "id/co/meda/apit/visual/report/RptLapBandara.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }

   
}
