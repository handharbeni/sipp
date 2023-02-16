/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.awt.Dialog;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportPembuka {
    
    private ArrayList<LspopNonStandar> arrLspop; 
    private ArrayList<LaporanPenilaianDataMaterialPembuka> arrMaterial;
    private JasperPrint jspPrtMaster;
   
    public TampilkanReportPembuka(String nop)
    {
        LaporanPenilaianPembuka lprnPembuka = new LaporanPenilaianPembuka();
        arrLspop = new ArrayList<LspopNonStandar>();
        ToolsPenilaian.ambilLspopFromDbPerNop(nop, arrLspop);
        buatDataMaterial();
        lprnPembuka.setDatMaterial(arrMaterial);
        lprnPembuka.setLspopNonStandar(arrLspop);

        ArrayList <LaporanPenilaianPembuka> arrLprnPembuka = new ArrayList<LaporanPenilaianPembuka>();
        arrLprnPembuka.add(lprnPembuka);
        ToolsReport tools = new ToolsReport();
        jspPrtMaster = tools.bentukReport(arrLprnPembuka,"id/co/meda/apit/visual/report/rptLapPenilPembuka.jrxml");
        
    
    }
    
    public void tampilReport()
    {
        JasperViewer jv = new JasperViewer(jspPrtMaster,false);
        jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jv.setVisible(true);
    }
    
    private void buatDataMaterial()
    {
        arrMaterial = new ArrayList<LaporanPenilaianDataMaterialPembuka>();
        ToolsReport tools = new ToolsReport();
        for(int i = 0; i < arrLspop.size();i++)
        {
            arrMaterial.add(tools.bentukDataMaterial(arrLspop.get(i)));
        }
    }
    
    
    
    
    
}
