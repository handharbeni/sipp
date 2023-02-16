/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.ItemPenilaian;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.ArrayList;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author I Made Sugiada
 */
public class TampilkanReportPenilBngIkan {
    NumberFormat numFormat = NumberFormat.getNumberInstance();
    
    private final Spop spop;
    private final ArrayList<NilaiBangunan> listNilBng;
    private final ArrayList<LaporanPenilaianMaster> listLapPenilMaster = new ArrayList<>();
    
    public TampilkanReportPenilBngIkan(Spop spop, ArrayList<NilaiBangunan> listNilBng) {
        this.spop = spop;
        this.listNilBng = listNilBng;
    }
    
    private void isiLaporanPenilaian() {
        for (int i=0;i<listNilBng.size();i++) {
            LaporanPenilaianMaster lPM = new LaporanPenilaianMaster();
            String nop = spop.getNop().substring(0,2)+"."+spop.getNop().substring(2,4)+"."+spop.getNop().substring(4,7)+
                    "."+spop.getNop().substring(7,10)+"."+spop.getNop().substring(10,13)+"-"+spop.getNop().substring(13,17)+
                    "."+spop.getNop().substring(17,18);
            lPM.setThnPenilaian(listNilBng.get(i).getThnPenilaian());       
            lPM.setNop(nop); 
            lPM.setNamaWp(spop.getNamaWp());                                
            lPM.setAlamatOp(spop.getJalanOp()+", "+spop.getNoJalanOp());
            lPM.setKelurahanOp(spop.getKelurahanOp());
            lPM.setKabupaten(spop.getKabupaten());
            lPM.setBngKe(listNilBng.get(i).getBngKe());
            lPM.setJpb(listNilBng.get(i).getJpb());
            lPM.setLuasBng(numFormat.format(listNilBng.get(i).getLuasBng())+" m2");
            lPM.setLuasBase(numFormat.format(listNilBng.get(i).getLuasBase())+" m2");
            lPM.setJmlLtBng(numFormat.format(listNilBng.get(i).getJmlLtBng())+" lt");
            lPM.setJmlLtBase(numFormat.format(listNilBng.get(i).getJmlLtBase())+" lt");
            lPM.setKompUtama(isiListLaporan(0,listNilBng.get(i).getKompUtama(),null));
            lPM.setMatDinDal(isiListLaporan(0,listNilBng.get(i).getMatDinDal(),null));
            lPM.setMatDinLuar(isiListLaporan(0,listNilBng.get(i).getMatDinLuar(),null));
            lPM.setPelDinDal(isiListLaporan(0,listNilBng.get(i).getPelDinDal(),null));
            lPM.setPelDinLuar(isiListLaporan(0,listNilBng.get(i).getPelDinLuar(),null));
            lPM.setKompLangit(isiListLaporan(0,listNilBng.get(i).getKompLangit(),null));
            lPM.setKompAtap(isiListLaporan(0,listNilBng.get(i).getKompAtap(),null));
            lPM.setKompLantai(isiListLaporan(0,listNilBng.get(i).getKompLantai(),null));
            lPM.setTotKompFasilitas(numFormat.format(listNilBng.get(i).getKompFasilitas().getNilaiFasilitas()));
            lPM.setNilSblmSusut(numFormat.format(listNilBng.get(i).getNilaiBngSblmSusut()));
            lPM.setPersenSusut(numFormat.format(listNilBng.get(i).getPersenPenyusutan()*100)+" %");
            lPM.setNilPenyusutan(numFormat.format(listNilBng.get(i).getNilaiPenyusutan()));
            lPM.setNilStlhSusut(numFormat.format(listNilBng.get(i).getNilaiBngStlhSusut()));
            lPM.setFasilitasTdkSusut(isiListLaporan(0,listNilBng.get(i).getFasilitasTdkSusut(),null));
            lPM.setNilBng(numFormat.format(listNilBng.get(i).getNilaiBangunan()));
            lPM.setAcSentral(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getAcSentral(),null));
            lPM.setLift(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getLift(),null));
            lPM.setEskalator(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getEskalator(),null));
            lPM.setPagar(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getPagar(),null));
            lPM.setProteksiApi(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getProteksiApi(),null));
            lPM.setPabx(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getPabx()));
            lPM.setSumurArtesis(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getSumurArtesis()));
            lPM.setSistemAirPanas(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getSistemAirPanas()));
            lPM.setPenangkalPetir(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getPenangkalPetir()));
            lPM.setSistemLimbah(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getSistemLimbah()));
            lPM.setSistemTataSuara(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getSistemTataSuara()));
            lPM.setVideoInterkom(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getVideoInterkom()));
            lPM.setReservoir(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getReservoir()));
            lPM.setTelevisi(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getTelevisi(),null));
            lPM.setKolamRenang(isiListLaporan(1,null,listNilBng.get(i).getKompFasilitas().getKolamRenang()));
            lPM.setPerkerasan(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getPerkerasan(),null));
            lPM.setLapanganTenis(isiListLaporan(0,listNilBng.get(i).getKompFasilitas().getLapanganTenis(),null));
            //ini utk keperluan isi ringkasan
            lPM.setNilBngAll(numFormat.format(Math.round(ToolsPenilaian.totalSemuaNilaiBng(listNilBng))));
            lPM.setRingkasan(isiListRingkasan(listNilBng));
            //----------------------------------
            listLapPenilMaster.add(lPM);
        }
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
    
    private ArrayList<LaporanPenilaianDetil> isiListLaporan(int kode, ArrayList<ItemPenilaian> listItemPenil, ItemPenilaian itemPenil) {
        ArrayList<LaporanPenilaianDetil> listLapDetil = new ArrayList<>();
        
        if (kode==0) {
            for (int i=0;i<listItemPenil.size();i++) {
                LaporanPenilaianDetil lapDetil = new LaporanPenilaianDetil();
                lapDetil.setNamaItem(listItemPenil.get(i).getNamaItem());
                lapDetil.setLuasItem(numFormat.format(listItemPenil.get(i).getLuasItem()));
                lapDetil.setSatuanItem(listItemPenil.get(i).getSatuanItem());
                lapDetil.setNamaKomponen(listItemPenil.get(i).getNamaKomponen());
                lapDetil.setNilaiKomponen(numFormat.format(listItemPenil.get(i).getNilaiKomponen()));
                lapDetil.setNilaiTotal(numFormat.format(listItemPenil.get(i).getTotalNilaiItem()));
                listLapDetil.add(lapDetil);
            }
        } else {
            LaporanPenilaianDetil lapDetil = new LaporanPenilaianDetil();
            lapDetil.setNamaItem(itemPenil.getNamaItem());
            lapDetil.setLuasItem(numFormat.format(itemPenil.getLuasItem()));
            lapDetil.setSatuanItem(itemPenil.getSatuanItem());
            lapDetil.setNamaKomponen(itemPenil.getNamaKomponen());
            lapDetil.setNilaiKomponen(numFormat.format(itemPenil.getNilaiKomponen()));
            lapDetil.setNilaiTotal(numFormat.format(itemPenil.getTotalNilaiItem()));
            listLapDetil.add(lapDetil);
        }
        return listLapDetil;
    }
    
    public void tampilReport() {
            isiLaporanPenilaian();
            ToolsReport tool = new ToolsReport();
            JasperPrint jspPrtMaster = tool.bentukReport(listLapPenilMaster, "id/co/meda/apit/visual/report/rptLapPenilMasterBngIkan.jrxml");

            JasperViewer jv = new JasperViewer(jspPrtMaster,false);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
    }
}
