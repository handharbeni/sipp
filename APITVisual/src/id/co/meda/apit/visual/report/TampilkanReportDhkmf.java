/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.headreport.ModelHeadReport;
import id.co.meda.apit.enggine.headreport.ProsesHeadReport;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import id.co.meda.apit.enggine.penilaian.khusus.tower.NilaiTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.Tower;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.awt.Dialog;
import static java.lang.Math.round;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author I Made Sugiada
 */
public class TampilkanReportDhkmf {
    
    private LaporanHargaKomponenMaterial lprn; 
    NumberFormat numFormat = NumberFormat.getNumberInstance();
    
    public TampilkanReportDhkmf(LaporanHargaKomponenMaterial lprn) {
        this.lprn = lprn;
    }
    
    public void tampilReport() {
        
        ModelHeadReport head = ProsesHeadReport.getModelHead();
        lprn.setNamaPemDaerah(head.getNamaPemDaerah());
        lprn.setDinasDaerah(head.getDinasDaerah());
        lprn.setAlamatDinas(head.getAlamatDinas());
        
        List<LaporanHargaKomponenMaterial> lstLprn = new ArrayList<LaporanHargaKomponenMaterial>();
        lstLprn.add(lprn);
        
        ToolsReport tool = new ToolsReport();
        JasperPrint jspPrtMaster = tool.bentukReport(lstLprn, "id/co/meda/apit/visual/report/rptLapResourceMaterial.jrxml");

        JasperViewer jv = new JasperViewer(jspPrtMaster,false);
        jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jv.setVisible(true);
    }
    
    
}
