/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;


import id.co.meda.apit.enggine.headreport.ModelHeadReport;
import id.co.meda.apit.enggine.headreport.ProsesHeadReport;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.SpopPelabuhan;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.ToolsPenilaianPelabuhan;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class TampilkanReportPelabuhan {
    
    
    private NumberFormat numFormat = NumberFormat.getNumberInstance();
    private String tahun;
    private String nop;
    private ArrayList<LaporanCrnPelabuhan> arrCrn;
    private String totalCRN;
            
    public TampilkanReportPelabuhan(String nop, String tahun, ArrayList<LaporanCrnPelabuhan> arr, String totalCRN){
        this.nop = nop;
        this.tahun = tahun;
        this.arrCrn = arr;
        this.totalCRN = totalCRN;
    }
    
    private LaporanPelabuhan isiPelabuhan()
    {
        SpopPelabuhan spop = ToolsPenilaianPelabuhan.getSpopPelabuhan(nop);
        
        LaporanPelabuhan lprnPelabuhan = new LaporanPelabuhan();
        lprnPelabuhan.setNop(spop.getNop());
        lprnPelabuhan.setNamaPelabuhan(spop.getNamaPelabuhan());
        lprnPelabuhan.setAlamatPelabuhan(spop.getAlamatPelabuhan());
        lprnPelabuhan.setJenisPelabuhan(spop.getJenisPelabuhan());
        lprnPelabuhan.setTotalCRN(totalCRN);
        lprnPelabuhan.setThnPenilaian(tahun);
        lprnPelabuhan.setArrCrn(arrCrn);
        
           ArrayList<ModelJabatan> arrJabatan = isiJabatan();
        
        for(int i = 0; i < arrJabatan.size();i++)
        {
                switch (i) {
                    case 1:
                        lprnPelabuhan.setJabPenilai(arrJabatan.get(i).getJabatan());
                        lprnPelabuhan.setNamaPenilai(arrJabatan.get(i).getNama());
                        lprnPelabuhan.setNipPenilai(arrJabatan.get(i).getNip());
                        break;
                    case 0:
                        lprnPelabuhan.setJabUptd(arrJabatan.get(i).getJabatan());
                        lprnPelabuhan.setNamaUptd(arrJabatan.get(i).getNama());
                        lprnPelabuhan.setNipUptd(arrJabatan.get(i).getNip());
                        break;
                    case 2:
                        lprnPelabuhan.setJabKadis(arrJabatan.get(i).getJabatan());
                        lprnPelabuhan.setNamaKadis(arrJabatan.get(i).getNama());
                        lprnPelabuhan.setNipKadis(arrJabatan.get(i).getNip());
                        break;
                    default:
                        break;
                }
        }
        
        ModelHeadReport head = ProsesHeadReport.getModelHead();
        lprnPelabuhan.setNamaPemDaerah(head.getNamaPemDaerah());
        lprnPelabuhan.setDinasDaerah(head.getDinasDaerah());
        lprnPelabuhan.setAlamatDinas(head.getAlamatDinas());
        
        return lprnPelabuhan;
        
    }
    
     private ArrayList<ModelJabatan> isiJabatan()
    {
        ArrayList<ModelJabatan> arrJabatan = new ArrayList<ModelJabatan>();
        arrJabatan = BuatModelPejabat.buatModelJabatan();
        return arrJabatan;
    }
    
    public void tampilkanReportPelabuhan()
    {
        ArrayList<LaporanPelabuhan> listLprn = new ArrayList<LaporanPelabuhan>();
        listLprn.add(isiPelabuhan());
        
        ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLprn, "id/co/meda/apit/visual/report/rptLapPelabuhan.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }
}
