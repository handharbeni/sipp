/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlLspopNonStd {
    public void isiCombo (JComboBox cbAll, String kdCombo) {
        String strQuery="";
        
        if (kdCombo.equals("JPB")) {
            strQuery = "select concat(concat(no_jpb,' - '),nama) kdjpb from ref_jpb order by no_jpb";
        }
        
        ResultSet rs = DBFetching.getResultSet(strQuery);
        try {
            while (rs.next()) {
                cbAll.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean cekNoBng(String nop, String noBng) {
        int jmlRec = DBFetching.getIntegerResult("select count(*) jml from lspop_non_standar where Nop='" 
                + nop +"' and BngKe='" + noBng + "'");
        return jmlRec>0;
    }
    
    public String simpanLspop(int kdSimpan, LspopNonStandar lspop) {
        String strQuery = "";
        
        
        if (kdSimpan == 0) {
            strQuery = "insert into lspop_non_standar values('"+lspop.getNop()+"','"+lspop.getBngKe()
                    +"','"+lspop.getJpb()+"','"+lspop.getKondisi()+"','"+lspop.getThnBangun()
                    +"','"+lspop.getThnRenov()+"',"+lspop.getJmlLtBng()+","+lspop.getJmlLtBase()
                    +","+lspop.getLsBngUtama()+","+lspop.getLsBngLain()+","+lspop.getLsBase()
                    +",'"+lspop.getKonstruksi()+"','"+lspop.getDinDalamStr()+"','"+lspop.getDinDalamBsm()
                    +"',"+lspop.getDinLuarKacaJmlLt()+","+lspop.getDinLuarPasBatuJmlLt()
                    +","+lspop.getDinLuarSengJmlLt()+","+lspop.getDinLuarCelconJmlLt()
                    +","+lspop.getDinLuarBetonJmlLt()+","+lspop.getDinLuarKayuJmlLt()
                    +","+lspop.getPelDalamKacaImporStrJmlLt()+","+lspop.getPelDalamKacaImporBsmJmlLt()
                    +","+lspop.getPelDalamKacaLokalStrJmlLt()+","+lspop.getPelDalamKacaLokalBsmJmlLt()
                    +","+lspop.getPelDalamMarmerImporStrJmlLt()+","+lspop.getPelDalamMarmerImporBsmJmlLt()
                    +","+lspop.getPelDalamMarmerLokalStrJmlLt()+","+lspop.getPelDalamMarmerLokalBsmJmlLt()
                    +","+lspop.getPelDalamCatStrJmlLt()+","+lspop.getPelDalamCatBsmJmlLt()
                    +","+lspop.getPelDalamWallpaperStrJmlLt()+","+lspop.getPelDalamWallpaperBsmJmlLt()
                    +","+lspop.getPelDalamGranitImporStrJmlLt()+","+lspop.getPelDalamGranitImporBsmJmlLt()
                    +","+lspop.getPelDalamGranitLokalStrJmlLt()+","+lspop.getPelDalamGranitLokalBsmJmlLt()
                    +","+lspop.getPelDalamKeramikStdStrJmlLt()+","+lspop.getPelDalamKeramikStdBsmJmlLt()
                    +","+lspop.getPelLuarGranitImporJmlLt()+","+lspop.getPelLuarKacaImporJmlLt()
                    +","+lspop.getPelLuarMarmerLokalJmlLt()+","+lspop.getPelLuarKeramikStdJmlLt()
                    +","+lspop.getPelLuarMarmerImporJmlLt()+","+lspop.getPelLuarGranitLokalJmlLt()
                    +","+lspop.getPelLuarKacaLokalJmlLt()+","+lspop.getPelLuarCatJmlLt()
                    +","+lspop.getLangitGipsumStrJmlLt()+","+lspop.getLangitGipsumBsmJmlLt()
                    +","+lspop.getLangitTriplekStrJmlLt()+","+lspop.getLangitTriplekBsmJmlLt()
                    +","+lspop.getLangitAkustikStrJmlLt()+","+lspop.getLangitAkustikBsmJmlLt()
                    +","+lspop.getLangitEternitStrJmlLt()+","+lspop.getLangitEternitBsmJmlLt()
                    +",'"+lspop.getAtap()
                    +"',"+lspop.getLantaiGranitImporStrJmlLt()+","+lspop.getLantaiGranitImporBsmJmlLt()
                    +","+lspop.getLantaiMarmerLokalStrJmlLt()+","+lspop.getLantaiMarmerLokalBsmJmlLt()
                    +","+lspop.getLantaiMarmerImporStrJmlLt()+","+lspop.getLantaiMarmerImporBsmJmlLt()
                    +","+lspop.getLantaiKarpetImporStrJmlLt()+","+lspop.getLantaiKarpetImporBsmJmlLt()
                    +","+lspop.getLantaiVinilStrJmlLt()+","+lspop.getLantaiVinilBsmJmlLt()
                    +","+lspop.getLantaiKayuStrJmlLt()+","+lspop.getLantaiKayuBsmJmlLt()
                    +","+lspop.getLantaiTerasoStrJmlLt()+","+lspop.getLantaiTerasoBsmJmlLt()
                    +","+lspop.getLantaiGranitLokalStrJmlLt()+","+lspop.getLantaiGranitLokalBsmJmlLt()
                    +","+lspop.getLantaiKeramikStdStrJmlLt()+","+lspop.getLantaiKeramikStdBsmJmlLt()
                    +","+lspop.getLantaiKarpetLokalStrJmlLt()+","+lspop.getLantaiKarpetLokalBsmJmlLt()
                    +","+lspop.getLantaiUbinStrJmlLt()+","+lspop.getLantaiUbinBsmJmlLt()
                    +","+lspop.getLantaiSemenStrJmlLt()+","+lspop.getLantaiSemenBsmJmlLt()
                    +","+lspop.getAcSplitJml()+",'"+lspop.getAcSplitPk()
                    +"',"+lspop.getAcWindowJml()+",'"+lspop.getAcWindowPk()
                    +"',"+lspop.getAcFloorJml()+",'"+lspop.getAcFloorPk()
                    +"',"+(lspop.isAcSentral()?"1":"0")
                    +","+lspop.getLiftPenumpangJml()+","+lspop.getLiftBarangJml()
                    +","+lspop.getEskalatorLess08Jml()+","+lspop.getEskalatorGreat08Jml()
                    +","+lspop.getPagarBatakoPanjang()+","+lspop.getPagarBatakoTinggi()
                    +","+lspop.getPagarBataPanjang()+","+lspop.getPagarBataTinggi()
                    +","+lspop.getPagarBetonPanjang()+","+lspop.getPagarBetonTinggi()
                    +","+lspop.getPagarBesiPanjang()+","+lspop.getPagarBesiTinggi()
                    +","+lspop.getPagarBrcPanjang()+","+lspop.getPagarBrcTinggi()
                    +","+lspop.getTvMatvLuas()+","+lspop.getTvMatvJmlLt()
                    +","+lspop.getTvCctvLuas()+","+lspop.getTvCctvJmlLt()
                    +","+(lspop.isHydrant()?"1":"0")+","+(lspop.isSprinkler()?"1":"0")+","+(lspop.isAlarm()?"1":"0")
                    +","+(lspop.isInterkom()?"1":"0")+","+(lspop.isAirPanas()?"1":"0")+","+(lspop.isReservoir()?"1":"0")
                    +","+lspop.getJmlPabx()+","+lspop.getDayaListrik()
                    +","+lspop.getVideoInterkomLuas()+","+lspop.getVideoInterkomJmlLt()
                    +","+lspop.getSumurArtesis()
                    +","+(lspop.isPenangkalPetir()?"1":"0")+","+(lspop.isPengolahLimbah()?"1":"0")+","+(lspop.isTataSuara()?"1":"0")
                    +","+lspop.getKolamRenangLs()+",'"+lspop.getKolamRenangFinish()
                    +"',"+lspop.getLapTenisBetonLampuJml()+","+lspop.getLapTenisAspalLampuJml()+","+lspop.getLapTenisTanahLampuJml()
                    +","+lspop.getLapTenisBetonNoLampuJml()+","+lspop.getLapTenisAspalNoLampuJml()+","+lspop.getLapTenisTanahNoLampuJml()
                    +","+lspop.getPerkerasanRinganLs()+","+lspop.getPerkerasanSedangLs()+","+lspop.getPerkerasanKerasLs()
                    +","+lspop.getJpb38TinggiKolom()+","+lspop.getJpb38LebarBentang()+","+lspop.getJpb38LantaiDyDkg()
                    +",'"+lspop.getJpb38LantaiTipe()+"',"+lspop.getJpb38LsMezzanin()
                    +","+lspop.getJpb14JmlKanopi()
                    +",'"+lspop.getJpb15Posisi()+"',"+lspop.getJpb15Kapasitas()+")";
        } else {
            strQuery = "update lspop_non_standar set Jpb = '"+lspop.getJpb()+"', Kondisi = '"+lspop.getKondisi()
                    +"', ThnBangun = '"+lspop.getThnBangun()+"', ThnRenov = '"+lspop.getThnRenov()+"', JmlLtBng = "
                    +lspop.getJmlLtBng()+", JmlLtBase = "+lspop.getJmlLtBase()+", LsBngUtama = "+lspop.getLsBngUtama()
                    +", LsBngLain = "+lspop.getLsBngLain()+", LsBase = "+lspop.getLsBase()+", Konstruksi = '"
                    +lspop.getKonstruksi()+"', DinDalamStr = '"+lspop.getDinDalamStr()+"', DinDalamBsm = '"
                    +lspop.getDinDalamBsm()+"', DinLuarKacaJmlLt = "+lspop.getDinLuarKacaJmlLt()
                    +", DinLuarPasBatuJmlLt = "+lspop.getDinLuarPasBatuJmlLt()+", DinLuarSengJmlLt = "
                    +lspop.getDinLuarSengJmlLt()+", DinLuarCelconJmlLt = "+lspop.getDinLuarCelconJmlLt()
                    +", DinLuarBetonJmlLt = "+lspop.getDinLuarBetonJmlLt()+" , DinLuarKayuJmlLt = "+lspop.getDinLuarKayuJmlLt()
                    +", PelDalamKacaImporStrJmlLt = "+lspop.getPelDalamKacaImporStrJmlLt()+", PelDalamKacaImporBsmJmlLt  = "
                    +lspop.getPelDalamKacaImporBsmJmlLt()+", PelDalamKacaLokalStrJmlLt = "+lspop.getPelDalamKacaLokalStrJmlLt()
                    +", PelDalamKacaLokalBsmJmlLt = "+lspop.getPelDalamKacaLokalBsmJmlLt()+", PelDalamMarmerImporStrJmlLt = "
                    +lspop.getPelDalamMarmerImporStrJmlLt()+", PelDalamMarmerImporBsmJmlLt = "+lspop.getPelDalamMarmerImporBsmJmlLt()
                    +", PelDalamMarmerLokalStrJmlLt = "+lspop.getPelDalamMarmerLokalStrJmlLt()+", PelDalamMarmerLokalBsmJmlLt = "
                    +lspop.getPelDalamMarmerLokalBsmJmlLt()+", PelDalamCatStrJmlLt = "+lspop.getPelDalamCatStrJmlLt()
                    +", PelDalamCatBsmJmlLt = "+lspop.getPelDalamCatBsmJmlLt()+", PelDalamWallpaperStrJmlLt = "
                    +lspop.getPelDalamWallpaperStrJmlLt()+", PelDalamWallpaperBsmJmlLt = "+lspop.getPelDalamWallpaperBsmJmlLt()
                    +", PelDalamGranitImporStrJmlLt = "+lspop.getPelDalamGranitImporStrJmlLt()+", PelDalamGranitImporBsmJmlLt = "
                    +lspop.getPelDalamGranitImporBsmJmlLt()+", PelDalamGranitLokalStrJmlLt = "+lspop.getPelDalamGranitLokalStrJmlLt()
                    +", PelDalamGranitLokalBsmJmlLt = "+lspop.getPelDalamGranitLokalBsmJmlLt()+", PelDalamKeramikStdStrJmlLt = "
                    +lspop.getPelDalamKeramikStdStrJmlLt()+", PelDalamKeramikStdBsmJmlLt = "+lspop.getPelDalamKeramikStdBsmJmlLt()
                    +", PelLuarGranitImporJmlLt = "+lspop.getPelLuarGranitImporJmlLt()+", PelLuarKacaImporJmlLt = "
                    +lspop.getPelLuarKacaImporJmlLt()+", PelLuarMarmerLokalJmlLt = "+lspop.getPelLuarMarmerLokalJmlLt()
                    +", PelLuarKeramikStdJmlLt = "+lspop.getPelLuarKeramikStdJmlLt()+", PelLuarMarmerImporJmlLt = "
                    +lspop.getPelLuarMarmerImporJmlLt()+", PelLuarGranitLokalJmlLt = "+lspop.getPelLuarGranitLokalJmlLt()
                    +", PelLuarKacaLokalJmlLt = "+lspop.getPelLuarKacaLokalJmlLt()+", PelLuarCatJmlLt = "+lspop.getPelLuarCatJmlLt()
                    +", LangitGipsumStrJmlLt = "+lspop.getLangitGipsumStrJmlLt()+", LangitGipsumBsmJmlLt ="+lspop.getLangitGipsumBsmJmlLt()
                    +" , LangitTriplekStrJmlLt = "+lspop.getLangitTriplekStrJmlLt()+", LangitTriplekBsmJmlLt = "+lspop.getLangitTriplekBsmJmlLt()
                    +", LangitAkustikStrJmlLt = "+lspop.getLangitAkustikStrJmlLt()+", LangitAkustikBsmJmlLt = "+lspop.getLangitAkustikBsmJmlLt()
                    +", LangitEternitStrJmlLt = "+lspop.getLangitEternitStrJmlLt()+", LangitEternitBsmJmlLt = "+lspop.getLangitEternitBsmJmlLt()
                    +", Atap = '"+lspop.getAtap()+"', LantaiGranitImporStrJmlLt = "+lspop.getLantaiGranitImporStrJmlLt()
                    +", LantaiGranitImporBsmJmlLt = "+lspop.getLantaiGranitImporBsmJmlLt()+", LantaiMarmerLokalStrJmlLt = "
                    +lspop.getLantaiMarmerLokalStrJmlLt()+", LantaiMarmerLokalBsmJmlLt = "+lspop.getLantaiMarmerLokalBsmJmlLt()
                    +", LantaiMarmerImporStrJmlLt = "+lspop.getLantaiMarmerImporStrJmlLt()+", LantaiMarmerImporBsmJmlLt = "
                    +lspop.getLantaiMarmerImporBsmJmlLt()+", LantaiKarpetImporStrJmlLt = "+lspop.getLantaiKarpetImporStrJmlLt()
                    +", LantaiKarpetImporBsmJmlLt = "+lspop.getLantaiKarpetImporBsmJmlLt()+", LantaiVinilStrJmlLt = "+lspop.getLantaiVinilStrJmlLt()
                    +", LantaiVinilBsmJmlLt = "+lspop.getLantaiVinilBsmJmlLt()+", LantaiKayuStrJmlLt = "+lspop.getLantaiKayuStrJmlLt()
                    +", LantaiKayuBsmJmlLt = "+lspop.getLantaiKayuBsmJmlLt()+", LantaiTerasoStrJmlLt = "+lspop.getLantaiTerasoStrJmlLt()
                    +", LantaiTerasoBsmJmlLt = "+lspop.getLantaiTerasoBsmJmlLt()+", LantaiGranitLokalStrJmlLt = "+lspop.getLantaiGranitLokalStrJmlLt()
                    +", LantaiGranitLokalBsmJmlLt = "+lspop.getLantaiGranitLokalBsmJmlLt()+", LantaiKeramikStdStrJmlLt = "+lspop.getLantaiKeramikStdStrJmlLt()
                    +", LantaiKeramikStdBsmJmlLt = "+lspop.getLantaiKeramikStdBsmJmlLt()+", LantaiKarpetLokalStrJmlLt = "+lspop.getLantaiKarpetLokalStrJmlLt()
                    +", LantaiKarpetLokalBsmJmlLt = "+lspop.getLantaiKarpetLokalBsmJmlLt()+", LantaiUbinStrJmlLt = "+lspop.getLantaiUbinStrJmlLt()
                    +", LantaiUbinBsmJmlLt = "+lspop.getLantaiUbinBsmJmlLt()+", LantaiSemenStrJmlLt = "+lspop.getLantaiSemenStrJmlLt()
                    +", LantaiSemenBsmJmlLt = "+lspop.getLantaiSemenBsmJmlLt()+", AcSplitJml = "+lspop.getAcSplitJml()
                    +", AcSplitPk = '"+lspop.getAcSplitPk()+"', AcWindowJml = "+lspop.getAcWindowJml()+", AcWindowPk = '"+lspop.getAcWindowPk()
                    +"', AcFloorJml = "+lspop.getAcFloorJml()+", AcFloorPk = '"+lspop.getAcFloorPk()+"', AcSentral = "+(lspop.isAcSentral()?"1":"0")
                    +", LiftPenumpangJml = "+lspop.getLiftPenumpangJml()+", LiftBarangJml = "+lspop.getLiftBarangJml()
                    +", EskalatorLess08Jml = "+lspop.getEskalatorLess08Jml()+", EskalatorGreat08Jml = "+lspop.getEskalatorGreat08Jml()
                    +", PagarBatakoPanjang = "+lspop.getPagarBatakoPanjang()+", PagarBatakoTinggi = "+lspop.getPagarBatakoTinggi()
                    +", PagarBataPanjang = "+lspop.getPagarBataPanjang()+", PagarBataTinggi = "+lspop.getPagarBataTinggi()
                    +", PagarBetonPanjang = "+lspop.getPagarBetonPanjang()+", PagarBetonTinggi = "+lspop.getPagarBetonTinggi()
                    +", PagarBesiPanjang = "+lspop.getPagarBesiPanjang()+", PagarBesiTinggi = "+lspop.getPagarBesiTinggi()
                    +", PagarBrcPanjang = "+lspop.getPagarBrcPanjang()+", PagarBrcTinggi = "+lspop.getPagarBrcTinggi()
                    +", TvMatvLuas = "+lspop.getTvMatvLuas()+", TvMatvJmlLt = "+lspop.getTvMatvJmlLt()+", TvCctvLuas = "+lspop.getTvCctvLuas()
                    +", TvCctvJmlLt = "+lspop.getTvCctvJmlLt()+", Hydrant = "+(lspop.isHydrant()?"1":"0")
                    +", Sprinkler = "+(lspop.isSprinkler()?"1":"0")+", Alarm = "+(lspop.isAlarm()?"1":"0")+", Interkom = "+(lspop.isInterkom()?"1":"0")
                    +", AirPanas = "+(lspop.isAirPanas()?"1":"0")+", Reservoir = "+(lspop.isReservoir()?"1":"0")
                    +", JmlPabx = "+lspop.getJmlPabx()+", DayaListrik = "+lspop.getDayaListrik()+", VideoInterkomLuas = "+lspop.getVideoInterkomLuas()
                    +", VideoInterkomJmlLt = "+lspop.getVideoInterkomJmlLt()+", SumurArtesis = "+lspop.getSumurArtesis()
                    +", PenangkalPetir = "+(lspop.isPenangkalPetir()?"1":"0")+", PengolahLimbah = "+(lspop.isPengolahLimbah()?"1":"0")
                    +", TataSuara = "+(lspop.isTataSuara()?"1":"0")+", KolamRenangLs = "+lspop.getKolamRenangLs()+", KolamRenangFinish = '"+lspop.getKolamRenangFinish()
                    +"', LapTenisBetonLampuJml = "+lspop.getLapTenisBetonLampuJml()+", LapTenisAspalLampuJml = "+lspop.getLapTenisAspalLampuJml()
                    +", LapTenisTanahLampuJml = "+lspop.getLapTenisTanahLampuJml()+", LapTenisBetonNoLampuJml = "+lspop.getLapTenisBetonNoLampuJml()
                    +", LapTenisAspalNoLampuJml = "+lspop.getLapTenisAspalNoLampuJml()+", LapTenisTanahNoLampuJml = "+lspop.getLapTenisTanahNoLampuJml()
                    +", PerkerasanRinganLs = "+lspop.getPerkerasanRinganLs()+", PerkerasanSedangLs = "+lspop.getPerkerasanSedangLs()
                    +", PerkerasanKerasLs = "+lspop.getPerkerasanKerasLs()+", Jpb38TinggiKolom = "+lspop.getJpb38TinggiKolom()
                    +", Jpb38LebarBentang = "+lspop.getJpb38LebarBentang()+", Jpb38LantaiDyDkg = "+lspop.getJpb38LantaiDyDkg()
                    +", Jpb38LantaiTipe = '"+lspop.getJpb38LantaiTipe()+"', Jpb38LsMezzanin = "+lspop.getJpb38LsMezzanin()
                    +", Jpb14JmlKanopi = "+lspop.getJpb14JmlKanopi()+", Jpb15Posisi = '"+lspop.getJpb15Posisi()+"', Jpb15Kapasitas = "
                    +lspop.getJpb15Kapasitas()+ " where Nop='"+lspop.getNop()+"' and BngKe='"+lspop.getBngKe()+"'";
        }
        
        try {
            DBFetching.setComandToDB(strQuery);
            return "OK";
        } catch (Exception e) {
            return "Terjadi kesalahan, dgn pesan sbb : " + e.getMessage();
        }
    }
    
    public void isiLspop(String nop, String bngKe, LspopNonStandar lspop) {
        ToolsPenilaian.ambilLspopFromDb(nop, bngKe, lspop);
    }
}
