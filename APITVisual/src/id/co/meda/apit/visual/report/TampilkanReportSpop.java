/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.headreport.ModelHeadReport;
import id.co.meda.apit.enggine.headreport.ProsesHeadReport;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportSpop {
    
     private ArrayList<Spop> arrSpop;
    private LaporanSpop lprn;
    
    public TampilkanReportSpop(ArrayList<Spop> arrSpop)
    {
        this.arrSpop = arrSpop;
        this.lprn = new LaporanSpop();
    }
    
    public void tampilReport()
    {
         ModelHeadReport head = ProsesHeadReport.getModelHead();
        lprn.setNamaPemDaerah(head.getNamaPemDaerah());
        lprn.setDinasDaerah(head.getDinasDaerah());
        lprn.setAlamatDinas(head.getAlamatDinas());
        lprn.setArrSpop(arrSpop);
        
        
        List<LaporanSpop> lstLprn = new ArrayList<LaporanSpop>();
        lstLprn.add(lprn);
        
        ToolsReport tool = new ToolsReport();
        JasperPrint jspPrtMaster = tool.bentukReport(lstLprn, "id/co/meda/apit/visual/report/RptLapSpop.jrxml");

        JasperViewer jv = new JasperViewer(jspPrtMaster,false);
        jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jv.setVisible(true);
    }
    
}
