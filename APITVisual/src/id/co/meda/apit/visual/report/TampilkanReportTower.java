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
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author I Made Sugiada
 */
public class TampilkanReportTower {
    private final Spop spop;
    private final ArrayList<Tower> listTower;
    private final ArrayList<NilaiTower> listNilaiTower;
    private final ArrayList<LaporanPenilaianTower> listLapTower = new ArrayList<>();
    
    NumberFormat numFormat = NumberFormat.getNumberInstance();
    
    public TampilkanReportTower(Spop spop, ArrayList<Tower> listTower, ArrayList<NilaiTower> listNilaiTower) {
        this.spop=spop;
        this.listTower=listTower;
        this.listNilaiTower=listNilaiTower;
    }
    
    public void tampilReport() {
        isiLaporanPenilaian();
        ToolsReport tool = new ToolsReport();
        JasperPrint jspPrtMaster = tool.bentukReport(listLapTower, "id/co/meda/apit/visual/report/rptLapTower.jrxml");

        JasperViewer jv = new JasperViewer(jspPrtMaster,false);
        jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jv.setVisible(true);
    }
    
    private void isiLaporanPenilaian() {
        for (int i=0;i<listNilaiTower.size();i++) {
            LaporanPenilaianTower lpt = new LaporanPenilaianTower();
            lpt.setThnPenilaian(listNilaiTower.get(i).getThnPenilaian());
            String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
            lpt.setNop(nop);
            lpt.setNamaWp(spop.getNamaWp());
            lpt.setAlamatOp(spop.getJalanOp()+" "+spop.getNoJalanOp());
            lpt.setNoBng(listNilaiTower.get(i).getBngKe());
            lpt.setThnBangun(listTower.get(i).getThnBangun());
            lpt.setThnRenov(listTower.get(i).getThnRenov());
            lpt.setKondisi(listTower.get(i).getKondisi());
            lpt.setTipe(listTower.get(i).getTipe());
            lpt.setTinggi(listTower.get(i).getTinggi().toString()+" meter");
            lpt.setJmlKaki(listTower.get(i).getJmlKaki().toString());
            lpt.setKonstruksi(listTower.get(i).getKonstruksi());
            lpt.setPemasangan(listTower.get(i).getPemasangan());
            lpt.setNilaiTowerSblmSusut("Rp. "+numFormat.format(round(listNilaiTower.get(i).getNilaiTowerSblmSusut())));
            lpt.setPersenPenyusutan(numFormat.format(listNilaiTower.get(i).getPersenPenyusutan()*100)+" %");
            lpt.setNilaiSusut("Rp. "+numFormat.format(round(listNilaiTower.get(i).getNilaiSusut())));
            lpt.setNilaiTowerSblmSusut("Rp. "+numFormat.format(round(listNilaiTower.get(i).getNilaiTowerSblmSusut())));
            lpt.setNilaiTower("Rp. "+numFormat.format(round(listNilaiTower.get(i).getNilaiTower())));
            
                  ArrayList<ModelJabatan> arrJabatan = isiJabatan();
        
            for(int a = 0; a < arrJabatan.size();a++)
            {
                switch (i) {
                    case 1:
                        lpt.setJabPenilai(arrJabatan.get(i).getJabatan());
                        lpt.setNamaPenilai(arrJabatan.get(i).getNama());
                        lpt.setNipPenilai(arrJabatan.get(i).getNip());
                        break;
                    case 0:
                        lpt.setJabUptd(arrJabatan.get(i).getJabatan());
                        lpt.setNamaUptd(arrJabatan.get(i).getNama());
                        lpt.setNipUptd(arrJabatan.get(i).getNip());
                        break;
                    case 2:
                        lpt.setJabKadis(arrJabatan.get(i).getJabatan());
                        lpt.setNamaKadis(arrJabatan.get(i).getNama());
                        lpt.setNipKadis(arrJabatan.get(i).getNip());
                        break;
                    default:
                        break;
                }
            }

            ModelHeadReport head = ProsesHeadReport.getModelHead();
            lpt.setNamaPemDaerah(head.getNamaPemDaerah());
            lpt.setDinasDaerah(head.getDinasDaerah());
            lpt.setAlamatDinas(head.getAlamatDinas());

            listLapTower.add(lpt);
        }
    }
    
     private ArrayList<ModelJabatan> isiJabatan()
    {
        ArrayList<ModelJabatan> arrJabatan = new ArrayList<ModelJabatan>();
        arrJabatan = BuatModelPejabat.buatModelJabatan();
        return arrJabatan;
    }
}
