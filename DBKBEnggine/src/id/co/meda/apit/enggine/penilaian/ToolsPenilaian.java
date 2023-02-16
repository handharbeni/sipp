/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.model.FasilitasBangunan;
import id.co.meda.apit.enggine.penilaian.model.ItemPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ToolsPenilaian {
    public static void ambilSpopFromDb(String nop, Spop spop) {
        ResultSet rs = DBFetching.getResultSet("select * from spop where nop='"+nop+"'");
        
        try {
            while (rs.next()) {
                spop.setNop(rs.getString("nop"));
                spop.setJalanOp(rs.getString("jalan_op"));
                spop.setNoJalanOp(rs.getString("no_jalan_op"));
                spop.setKelurahanOp(rs.getString("kelurahan_op"));
                spop.setRwRtOp(rs.getString("rw_rt_op"));
                spop.setStatusWp(rs.getString("status_wp"));
                spop.setPekerjaanWp(rs.getString("pekerjaan_wp"));
                spop.setNamaWp(rs.getString("nama_wp"));
                spop.setNpwp(rs.getString("npwp"));
                spop.setJalanWp(rs.getString("jalan_wp"));
                spop.setNoJalanWp(rs.getString("no_jalan_wp"));
                spop.setKelurahanWp(rs.getString("kelurahan_wp"));
                spop.setRwRtWp(rs.getString("rw_rt_wp"));
                spop.setKabupaten(rs.getString("kabupaten"));
                spop.setNomorKtp(rs.getString("nomor_ktp"));
                spop.setLuasTanah(Double.parseDouble((rs.getString("luas_tanah")!=null)?rs.getString("luas_tanah"):"0"));
                spop.setZnt(rs.getString("znt"));
                spop.setJenisTanah(rs.getString("jns_tanah"));
                spop.setJumlahBangunan(rs.getInt("jml_bng"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void ambilLspopFromDb(String nop, String bngKe, LspopNonStandar lspop) {
        ResultSet rs = DBFetching.getResultSet("select *, concat(concat(no_jpb,' - '),nama) nmJpb from lspop_non_standar a, ref_jpb b where nop='"
                +nop+"' and bngke='"+bngKe+"' and a.jpb=b.no_jpb");
        
        try {
            while (rs.next()) {
                lspop.setNop(rs.getString("Nop"));
                lspop.setBngKe(rs.getString("BngKe"));
                lspop.setJpb(rs.getString("nmJpb"));
                lspop.setKondisi(rs.getString("Kondisi"));
                lspop.setThnBangun(rs.getString("ThnBangun"));
                lspop.setThnRenov(rs.getString("ThnRenov"));
                lspop.setJmlLtBng(Integer.parseInt((rs.getString("JmlLtBng")!=null)?rs.getString("JmlLtBng"):"0"));
                lspop.setJmlLtBase(Integer.parseInt((rs.getString("JmlLtBase")!=null)?rs.getString("JmlLtBase"):"0"));
                lspop.setLsBngUtama(Double.parseDouble((rs.getString("LsBngUtama")!=null)?rs.getString("LsBngUtama"):"0"));
                lspop.setLsBngLain(Double.parseDouble((rs.getString("LsBngLain")!=null)?rs.getString("LsBngLain"):"0"));
                lspop.setLsBase(Double.parseDouble((rs.getString("LsBase")!=null)?rs.getString("LsBase"):"0"));
                lspop.setKonstruksi(rs.getString("Konstruksi"));
                lspop.setDinDalamStr(rs.getString("DinDalamStr"));
                lspop.setDinDalamBsm(rs.getString("DinDalamBsm"));
                lspop.setDinLuarKacaJmlLt(Integer.parseInt((rs.getString("DinLuarKacaJmlLt")!=null)?rs.getString("DinLuarKacaJmlLt"):"0"));
                lspop.setDinLuarPasBatuJmlLt(Integer.parseInt((rs.getString("DinLuarPasBatuJmlLt")!=null)?rs.getString("DinLuarPasBatuJmlLt"):"0"));
                lspop.setDinLuarSengJmlLt(Integer.parseInt((rs.getString("DinLuarSengJmlLt")!=null)?rs.getString("DinLuarSengJmlLt"):"0"));
                lspop.setDinLuarCelconJmlLt(Integer.parseInt((rs.getString("DinLuarCelconJmlLt")!=null)?rs.getString("DinLuarCelconJmlLt"):"0"));
                lspop.setDinLuarBetonJmlLt(Integer.parseInt((rs.getString("DinLuarBetonJmlLt")!=null)?rs.getString("DinLuarBetonJmlLt"):"0"));
                lspop.setDinLuarKayuJmlLt(Integer.parseInt((rs.getString("DinLuarKayuJmlLt")!=null)?rs.getString("DinLuarKayuJmlLt"):"0"));
                lspop.setPelDalamKacaImporStrJmlLt(Integer.parseInt((rs.getString("PelDalamKacaImporStrJmlLt")!=null)?rs.getString("PelDalamKacaImporStrJmlLt"):"0"));
                lspop.setPelDalamKacaImporBsmJmlLt(Integer.parseInt((rs.getString("PelDalamKacaImporBsmJmlLt")!=null)?rs.getString("PelDalamKacaImporBsmJmlLt"):"0"));
                lspop.setPelDalamKacaLokalStrJmlLt(Integer.parseInt((rs.getString("PelDalamKacaLokalStrJmlLt")!=null)?rs.getString("PelDalamKacaLokalStrJmlLt"):"0"));
                lspop.setPelDalamKacaLokalBsmJmlLt(Integer.parseInt((rs.getString("PelDalamKacaLokalBsmJmlLt")!=null)?rs.getString("PelDalamKacaLokalBsmJmlLt"):"0"));
                lspop.setPelDalamMarmerImporStrJmlLt(Integer.parseInt((rs.getString("PelDalamMarmerImporStrJmlLt")!=null)?rs.getString("PelDalamMarmerImporStrJmlLt"):"0"));
                lspop.setPelDalamMarmerImporBsmJmlLt(Integer.parseInt((rs.getString("PelDalamMarmerImporBsmJmlLt")!=null)?rs.getString("PelDalamMarmerImporBsmJmlLt"):"0"));
                lspop.setPelDalamMarmerLokalStrJmlLt(Integer.parseInt((rs.getString("PelDalamMarmerLokalStrJmlLt")!=null)?rs.getString("PelDalamMarmerLokalStrJmlLt"):"0"));
                lspop.setPelDalamMarmerLokalBsmJmlLt(Integer.parseInt((rs.getString("PelDalamMarmerLokalBsmJmlLt")!=null)?rs.getString("PelDalamMarmerLokalBsmJmlLt"):"0"));
                lspop.setPelDalamCatStrJmlLt(Integer.parseInt((rs.getString("PelDalamCatStrJmlLt")!=null)?rs.getString("PelDalamCatStrJmlLt"):"0"));
                lspop.setPelDalamCatBsmJmlLt(Integer.parseInt((rs.getString("PelDalamCatBsmJmlLt")!=null)?rs.getString("PelDalamCatBsmJmlLt"):"0"));
                lspop.setPelDalamWallpaperStrJmlLt(Integer.parseInt((rs.getString("PelDalamWallpaperStrJmlLt")!=null)?rs.getString("PelDalamWallpaperStrJmlLt"):"0"));
                lspop.setPelDalamWallpaperBsmJmlLt(Integer.parseInt((rs.getString("PelDalamWallpaperBsmJmlLt")!=null)?rs.getString("PelDalamWallpaperBsmJmlLt"):"0"));
                lspop.setPelDalamGranitImporStrJmlLt(Integer.parseInt((rs.getString("PelDalamGranitImporStrJmlLt")!=null)?rs.getString("PelDalamGranitImporStrJmlLt"):"0"));
                lspop.setPelDalamGranitImporBsmJmlLt(Integer.parseInt((rs.getString("PelDalamGranitImporBsmJmlLt")!=null)?rs.getString("PelDalamGranitImporBsmJmlLt"):"0"));
                lspop.setPelDalamGranitLokalStrJmlLt(Integer.parseInt((rs.getString("PelDalamGranitLokalStrJmlLt")!=null)?rs.getString("PelDalamGranitLokalStrJmlLt"):"0"));
                lspop.setPelDalamGranitLokalBsmJmlLt(Integer.parseInt((rs.getString("PelDalamGranitLokalBsmJmlLt")!=null)?rs.getString("PelDalamGranitLokalBsmJmlLt"):"0"));
                lspop.setPelDalamKeramikStdStrJmlLt(Integer.parseInt((rs.getString("PelDalamKeramikStdStrJmlLt")!=null)?rs.getString("PelDalamKeramikStdStrJmlLt"):"0"));
                lspop.setPelDalamKeramikStdBsmJmlLt(Integer.parseInt((rs.getString("PelDalamKeramikStdBsmJmlLt")!=null)?rs.getString("PelDalamKeramikStdBsmJmlLt"):"0"));
                lspop.setPelLuarGranitImporJmlLt(Integer.parseInt((rs.getString("PelLuarGranitImporJmlLt")!=null)?rs.getString("PelLuarGranitImporJmlLt"):"0"));
                lspop.setPelLuarKacaImporJmlLt(Integer.parseInt((rs.getString("PelLuarKacaImporJmlLt")!=null)?rs.getString("PelLuarKacaImporJmlLt"):"0"));
                lspop.setPelLuarMarmerLokalJmlLt(Integer.parseInt((rs.getString("PelLuarMarmerLokalJmlLt")!=null)?rs.getString("PelLuarMarmerLokalJmlLt"):"0"));
                lspop.setPelLuarKeramikStdJmlLt(Integer.parseInt((rs.getString("PelLuarKeramikStdJmlLt")!=null)?rs.getString("PelLuarKeramikStdJmlLt"):"0"));
                lspop.setPelLuarMarmerImporJmlLt(Integer.parseInt((rs.getString("PelLuarMarmerImporJmlLt")!=null)?rs.getString("PelLuarMarmerImporJmlLt"):"0"));
                lspop.setPelLuarGranitLokalJmlLt(Integer.parseInt((rs.getString("PelLuarGranitLokalJmlLt")!=null)?rs.getString("PelLuarGranitLokalJmlLt"):"0"));
                lspop.setPelLuarKacaLokalJmlLt(Integer.parseInt((rs.getString("PelLuarKacaLokalJmlLt")!=null)?rs.getString("PelLuarKacaLokalJmlLt"):"0"));
                lspop.setPelLuarCatJmlLt(Integer.parseInt((rs.getString("PelLuarCatJmlLt")!=null)?rs.getString("PelLuarCatJmlLt"):"0"));
                lspop.setLangitGipsumStrJmlLt(Integer.parseInt((rs.getString("LangitGipsumStrJmlLt")!=null)?rs.getString("LangitGipsumStrJmlLt"):"0"));
                lspop.setLangitGipsumBsmJmlLt(Integer.parseInt((rs.getString("LangitGipsumBsmJmlLt")!=null)?rs.getString("LangitGipsumBsmJmlLt"):"0"));
                lspop.setLangitTriplekStrJmlLt(Integer.parseInt((rs.getString("LangitTriplekStrJmlLt")!=null)?rs.getString("LangitTriplekStrJmlLt"):"0"));
                lspop.setLangitTriplekBsmJmlLt(Integer.parseInt((rs.getString("LangitTriplekBsmJmlLt")!=null)?rs.getString("LangitTriplekBsmJmlLt"):"0"));
                lspop.setLangitAkustikStrJmlLt(Integer.parseInt((rs.getString("LangitAkustikStrJmlLt")!=null)?rs.getString("LangitAkustikStrJmlLt"):"0"));
                lspop.setLangitAkustikBsmJmlLt(Integer.parseInt((rs.getString("LangitAkustikBsmJmlLt")!=null)?rs.getString("LangitAkustikBsmJmlLt"):"0"));
                lspop.setLangitEternitStrJmlLt(Integer.parseInt((rs.getString("LangitEternitStrJmlLt")!=null)?rs.getString("LangitEternitStrJmlLt"):"0"));
                lspop.setLangitEternitBsmJmlLt(Integer.parseInt((rs.getString("LangitEternitBsmJmlLt")!=null)?rs.getString("LangitEternitBsmJmlLt"):"0"));
                lspop.setAtap(rs.getString("Atap"));
                lspop.setLantaiGranitImporStrJmlLt(Integer.parseInt((rs.getString("LantaiGranitImporStrJmlLt")!=null)?rs.getString("LantaiGranitImporStrJmlLt"):"0"));
                lspop.setLantaiGranitImporBsmJmlLt(Integer.parseInt((rs.getString("LantaiGranitImporBsmJmlLt")!=null)?rs.getString("LantaiGranitImporBsmJmlLt"):"0"));
                lspop.setLantaiMarmerLokalStrJmlLt(Integer.parseInt((rs.getString("LantaiMarmerLokalStrJmlLt")!=null)?rs.getString("LantaiMarmerLokalStrJmlLt"):"0"));
                lspop.setLantaiMarmerLokalBsmJmlLt(Integer.parseInt((rs.getString("LantaiMarmerLokalBsmJmlLt")!=null)?rs.getString("LantaiMarmerLokalBsmJmlLt"):"0"));
                lspop.setLantaiMarmerImporStrJmlLt(Integer.parseInt((rs.getString("LantaiMarmerImporStrJmlLt")!=null)?rs.getString("LantaiMarmerImporStrJmlLt"):"0"));
                lspop.setLantaiMarmerImporBsmJmlLt(Integer.parseInt((rs.getString("LantaiMarmerImporBsmJmlLt")!=null)?rs.getString("LantaiMarmerImporBsmJmlLt"):"0"));
                lspop.setLantaiKarpetImporStrJmlLt(Integer.parseInt((rs.getString("LantaiKarpetImporStrJmlLt")!=null)?rs.getString("LantaiKarpetImporStrJmlLt"):"0"));
                lspop.setLantaiKarpetImporBsmJmlLt(Integer.parseInt((rs.getString("LantaiKarpetImporBsmJmlLt")!=null)?rs.getString("LantaiKarpetImporBsmJmlLt"):"0"));
                lspop.setLantaiVinilStrJmlLt(Integer.parseInt((rs.getString("LantaiVinilStrJmlLt")!=null)?rs.getString("LantaiVinilStrJmlLt"):"0"));
                lspop.setLantaiVinilBsmJmlLt(Integer.parseInt((rs.getString("LantaiVinilBsmJmlLt")!=null)?rs.getString("LantaiVinilBsmJmlLt"):"0"));
                lspop.setLantaiKayuStrJmlLt(Integer.parseInt((rs.getString("LantaiKayuStrJmlLt")!=null)?rs.getString("LantaiKayuStrJmlLt"):"0"));
                lspop.setLantaiKayuBsmJmlLt(Integer.parseInt((rs.getString("LantaiKayuBsmJmlLt")!=null)?rs.getString("LantaiKayuBsmJmlLt"):"0"));
                lspop.setLantaiTerasoStrJmlLt(Integer.parseInt((rs.getString("LantaiTerasoStrJmlLt")!=null)?rs.getString("LantaiTerasoStrJmlLt"):"0"));
                lspop.setLantaiTerasoBsmJmlLt(Integer.parseInt((rs.getString("LantaiTerasoBsmJmlLt")!=null)?rs.getString("LantaiTerasoBsmJmlLt"):"0"));
                lspop.setLantaiGranitLokalStrJmlLt(Integer.parseInt((rs.getString("LantaiGranitLokalStrJmlLt")!=null)?rs.getString("LantaiGranitLokalStrJmlLt"):"0"));
                lspop.setLantaiGranitLokalBsmJmlLt(Integer.parseInt((rs.getString("LantaiGranitLokalBsmJmlLt")!=null)?rs.getString("LantaiGranitLokalBsmJmlLt"):"0"));
                lspop.setLantaiKeramikStdStrJmlLt(Integer.parseInt((rs.getString("LantaiKeramikStdStrJmlLt")!=null)?rs.getString("LantaiKeramikStdStrJmlLt"):"0"));
                lspop.setLantaiKeramikStdBsmJmlLt(Integer.parseInt((rs.getString("LantaiKeramikStdBsmJmlLt")!=null)?rs.getString("LantaiKeramikStdBsmJmlLt"):"0"));
                lspop.setLantaiKarpetLokalStrJmlLt(Integer.parseInt((rs.getString("LantaiKarpetLokalStrJmlLt")!=null)?rs.getString("LantaiKarpetLokalStrJmlLt"):"0"));
                lspop.setLantaiKarpetLokalBsmJmlLt(Integer.parseInt((rs.getString("LantaiKarpetLokalBsmJmlLt")!=null)?rs.getString("LantaiKarpetLokalBsmJmlLt"):"0"));
                lspop.setLantaiUbinStrJmlLt(Integer.parseInt((rs.getString("LantaiUbinStrJmlLt")!=null)?rs.getString("LantaiUbinStrJmlLt"):"0"));
                lspop.setLantaiUbinBsmJmlLt(Integer.parseInt((rs.getString("LantaiUbinBsmJmlLt")!=null)?rs.getString("LantaiUbinBsmJmlLt"):"0"));
                lspop.setLantaiSemenStrJmlLt(Integer.parseInt((rs.getString("LantaiSemenStrJmlLt")!=null)?rs.getString("LantaiSemenStrJmlLt"):"0"));
                lspop.setLantaiSemenBsmJmlLt(Integer.parseInt((rs.getString("LantaiSemenBsmJmlLt")!=null)?rs.getString("LantaiSemenBsmJmlLt"):"0"));
                lspop.setAcSplitJml(Integer.parseInt((rs.getString("AcSplitJml")!=null)?rs.getString("AcSplitJml"):"0"));
                lspop.setAcSplitPk(rs.getString("AcSplitPk"));
                lspop.setAcWindowJml(Integer.parseInt((rs.getString("AcWindowJml")!=null)?rs.getString("AcWindowJml"):"0"));
                lspop.setAcWindowPk(rs.getString("AcWindowPk"));
                lspop.setAcFloorJml(Integer.parseInt((rs.getString("AcFloorJml")!=null)?rs.getString("AcFloorJml"):"0"));
                lspop.setAcFloorPk(rs.getString("AcFloorPk"));
                lspop.setAcSentral((Integer.parseInt(rs.getString("AcSentral"))==1?true:false));
                lspop.setLiftPenumpangJml(Integer.parseInt((rs.getString("LiftPenumpangJml")!=null)?rs.getString("LiftPenumpangJml"):"0"));
                lspop.setLiftBarangJml(Integer.parseInt((rs.getString("LiftBarangJml")!=null)?rs.getString("LiftBarangJml"):"0"));
                lspop.setEskalatorLess08Jml(Integer.parseInt((rs.getString("EskalatorLess08Jml")!=null)?rs.getString("EskalatorLess08Jml"):"0"));
                lspop.setEskalatorGreat08Jml(Integer.parseInt((rs.getString("EskalatorGreat08Jml")!=null)?rs.getString("EskalatorGreat08Jml"):"0"));
                lspop.setPagarBatakoPanjang(Double.parseDouble((rs.getString("PagarBatakoPanjang")!=null)?rs.getString("PagarBatakoPanjang"):"0"));
                lspop.setPagarBatakoTinggi(Double.parseDouble((rs.getString("PagarBatakoTinggi")!=null)?rs.getString("PagarBatakoTinggi"):"0"));
                lspop.setPagarBataPanjang(Double.parseDouble((rs.getString("PagarBataPanjang")!=null)?rs.getString("PagarBataPanjang"):"0"));
                lspop.setPagarBataTinggi(Double.parseDouble((rs.getString("PagarBataTinggi")!=null)?rs.getString("PagarBataTinggi"):"0"));    
                lspop.setPagarBetonPanjang(Double.parseDouble((rs.getString("PagarBetonPanjang")!=null)?rs.getString("PagarBetonPanjang"):"0"));
                lspop.setPagarBetonTinggi(Double.parseDouble((rs.getString("PagarBetonTinggi")!=null)?rs.getString("PagarBetonTinggi"):"0"));    
                lspop.setPagarBesiPanjang(Double.parseDouble((rs.getString("PagarBesiPanjang")!=null)?rs.getString("PagarBesiPanjang"):"0"));
                lspop.setPagarBesiTinggi(Double.parseDouble((rs.getString("PagarBesiTinggi")!=null)?rs.getString("PagarBesiTinggi"):"0"));    
                lspop.setPagarBrcPanjang(Double.parseDouble((rs.getString("PagarBrcPanjang")!=null)?rs.getString("PagarBrcPanjang"):"0"));
                lspop.setPagarBrcTinggi(Double.parseDouble((rs.getString("PagarBrcTinggi")!=null)?rs.getString("PagarBrcTinggi"):"0"));    
                lspop.setTvMatvLuas(Double.parseDouble((rs.getString("TvMatvLuas")!=null)?rs.getString("TvMatvLuas"):"0"));
                lspop.setTvMatvJmlLt(Integer.parseInt((rs.getString("TvMatvJmlLt")!=null)?rs.getString("TvMatvJmlLt"):"0"));    
                lspop.setTvCctvLuas(Double.parseDouble((rs.getString("TvCctvLuas")!=null)?rs.getString("TvCctvLuas"):"0"));
                lspop.setTvCctvJmlLt(Integer.parseInt((rs.getString("TvCctvJmlLt")!=null)?rs.getString("TvCctvJmlLt"):"0"));     
                lspop.setHydrant((Integer.parseInt(rs.getString("Hydrant"))==1?true:false));
                lspop.setSprinkler((Integer.parseInt(rs.getString("Sprinkler"))==1?true:false));     
                lspop.setAlarm((Integer.parseInt(rs.getString("Alarm"))==1?true:false));     
                lspop.setInterkom((Integer.parseInt(rs.getString("Interkom"))==1?true:false));     
                lspop.setAirPanas((Integer.parseInt(rs.getString("AirPanas"))==1?true:false));
                lspop.setReservoir((Integer.parseInt(rs.getString("Reservoir"))==1?true:false));
                lspop.setJmlPabx(Integer.parseInt((rs.getString("JmlPabx")!=null)?rs.getString("JmlPabx"):"0"));
                lspop.setDayaListrik(Integer.parseInt((rs.getString("DayaListrik")!=null)?rs.getString("DayaListrik"):"0"));
                lspop.setVideoInterkomLuas(Double.parseDouble((rs.getString("VideoInterkomLuas")!=null)?rs.getString("VideoInterkomLuas"):"0"));
                lspop.setVideoInterkomJmlLt(Integer.parseInt((rs.getString("VideoInterkomJmlLt")!=null)?rs.getString("VideoInterkomJmlLt"):"0"));
                lspop.setSumurArtesis(Double.parseDouble((rs.getString("SumurArtesis")!=null)?rs.getString("SumurArtesis"):"0"));
                lspop.setPenangkalPetir((Integer.parseInt(rs.getString("PenangkalPetir"))==1?true:false));
                lspop.setPengolahLimbah((Integer.parseInt(rs.getString("PengolahLimbah"))==1?true:false));
                lspop.setTataSuara((Integer.parseInt(rs.getString("TataSuara"))==1?true:false));
                lspop.setKolamRenangLs(Double.parseDouble((rs.getString("KolamRenangLs")!=null)?rs.getString("KolamRenangLs"):"0"));
                lspop.setKolamRenangFinish(rs.getString("KolamRenangFinish"));
                lspop.setLapTenisBetonLampuJml(Integer.parseInt((rs.getString("LapTenisBetonLampuJml")!=null)?rs.getString("LapTenisBetonLampuJml"):"0"));
                lspop.setLapTenisAspalLampuJml(Integer.parseInt((rs.getString("LapTenisAspalLampuJml")!=null)?rs.getString("LapTenisAspalLampuJml"):"0"));
                lspop.setLapTenisTanahLampuJml(Integer.parseInt((rs.getString("LapTenisTanahLampuJml")!=null)?rs.getString("LapTenisTanahLampuJml"):"0"));
                lspop.setLapTenisBetonNoLampuJml(Integer.parseInt((rs.getString("LapTenisBetonNoLampuJml")!=null)?rs.getString("LapTenisBetonNoLampuJml"):"0"));
                lspop.setLapTenisAspalNoLampuJml(Integer.parseInt((rs.getString("LapTenisAspalNoLampuJml")!=null)?rs.getString("LapTenisAspalNoLampuJml"):"0"));
                lspop.setLapTenisTanahNoLampuJml(Integer.parseInt((rs.getString("LapTenisTanahNoLampuJml")!=null)?rs.getString("LapTenisTanahNoLampuJml"):"0"));
                lspop.setPerkerasanRinganLs(Double.parseDouble((rs.getString("PerkerasanRinganLs")!=null)?rs.getString("PerkerasanRinganLs"):"0"));
                lspop.setPerkerasanSedangLs(Double.parseDouble((rs.getString("PerkerasanSedangLs")!=null)?rs.getString("PerkerasanSedangLs"):"0"));
                lspop.setPerkerasanKerasLs(Double.parseDouble((rs.getString("PerkerasanKerasLs")!=null)?rs.getString("PerkerasanKerasLs"):"0"));
                lspop.setJpb38TinggiKolom(Integer.parseInt((rs.getString("Jpb38TinggiKolom")!=null)?rs.getString("Jpb38TinggiKolom"):"0"));
                lspop.setJpb38LebarBentang(Integer.parseInt((rs.getString("Jpb38LebarBentang")!=null)?rs.getString("Jpb38LebarBentang"):"0"));
                lspop.setJpb38LantaiDyDkg(Double.parseDouble((rs.getString("Jpb38LantaiDyDkg")!=null)?rs.getString("Jpb38LantaiDyDkg"):"0"));
                lspop.setJpb38LantaiTipe(rs.getString("Jpb38LantaiTipe"));
                lspop.setJpb38LsMezzanin(Double.parseDouble((rs.getString("Jpb38LsMezzanin")!=null)?rs.getString("Jpb38LsMezzanin"):"0"));
                lspop.setJpb14JmlKanopi(Integer.parseInt((rs.getString("Jpb14JmlKanopi")!=null)?rs.getString("Jpb14JmlKanopi"):"0"));
                lspop.setJpb15Posisi(rs.getString("Jpb15Posisi"));
                lspop.setJpb15Kapasitas(Double.parseDouble((rs.getString("Jpb15Kapasitas")!=null)?rs.getString("Jpb15Kapasitas"):"0"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void ambilLspopFromDbPerNop(String nop, ArrayList<LspopNonStandar> lspops) {
        ResultSet rs = DBFetching.getResultSet("select Nop, BngKe from lspop_non_standar where nop='" + nop + "'");
        try {
            while (rs.next()) {
                LspopNonStandar lspop = new LspopNonStandar();
                ambilLspopFromDb(nop, rs.getString("BngKe"), lspop);
                lspops.add(lspop);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void isiItemPenilaian(String namaItem, Double luasItem, 
    String satuanItem, String namaKomponen,Double nilaiKomponen, ItemPenilaian itemPenil, 
    ArrayList<ItemPenilaian> listItemPenil) {
        itemPenil.setNamaItem(namaItem);
        itemPenil.setLuasItem(luasItem);
        itemPenil.setSatuanItem(satuanItem);
        itemPenil.setNamaKomponen(namaKomponen);
        itemPenil.setNilaiKomponen(nilaiKomponen);
        listItemPenil.add(itemPenil);
        
    }
    
    public static Double hitungSusut(String thnPenilaian, String thnDibangun, String thnRenov,
            String kondisiBng, Double nilaiBng, Double lsBng) {
        
        Double nilaiSusut =0.0;
        Integer umurEfektif = 0; 
        Integer intThnPenilaian = (thnPenilaian.trim().length()>0)?Integer.parseInt(thnPenilaian):0;
        Integer intThnDibangun = (thnDibangun.trim().length()>0)?Integer.parseInt(thnDibangun):0;
        Integer intThnRenov = (thnRenov.trim().length()>0)?Integer.parseInt(thnRenov):0;
        Double nilaiBng1 = (nilaiBng>0)?nilaiBng:0;
        Double lsBng1 = (lsBng>0)?lsBng:0;
        Double nilaiPenggantiBaru = 0.0;
        String rangePenyusutan = "";
        
        //mencari umur efektif
        if (intThnDibangun>0) {
            if (intThnRenov>0) {
                if ((intThnPenilaian-intThnRenov)>10) {
                    umurEfektif = Math.round(((intThnPenilaian-intThnDibangun)+(2*10))/3);
                } else {
                    umurEfektif = Math.round(((intThnPenilaian-intThnDibangun)+(2*(intThnPenilaian-intThnRenov)))/3);
                }
            } else {
                if ((intThnPenilaian-intThnDibangun)>10) {
                    umurEfektif = Math.round(((intThnPenilaian-intThnDibangun)+(2*10))/3);
                } else {
                    umurEfektif = intThnPenilaian-intThnDibangun;
                }
            }
        } 

        //mencari nilai pengganti baru /m2
        nilaiPenggantiBaru = nilaiBng1/lsBng1;
        
        //mencari range penyusutan
        rangePenyusutan = DBFetching.getStringResult(
                "select kd_range_penyusutan from range_penyusutan where " 
                +nilaiPenggantiBaru.toString()+" between nilai_min_penyusutan and nilai_max_penyusutan", 
                1);
        
        //mencari nilai penyusutan
        try {
            nilaiSusut = DBFetching.getDoubleResult(
                "select nilai_penyusutan from penyusutan where umur_efektif="+umurEfektif.toString()
                +" and kd_range_penyusutan='"+rangePenyusutan+"' and kondisi_bng_susut='"+kondisiBng+"'");
        } catch (Exception e) {
            nilaiSusut=0.0;
        }
        
        return nilaiSusut/100;
    }

    public static NilaiBangunan ambilNilBngFromDB(String thn, String nop, String bngKe) {
        return ambilBng(thn,nop, bngKe);
    }
    public static ArrayList<NilaiBangunan> ambilNilBngFromDB(String thn,String nop) {
        ArrayList<NilaiBangunan> listNilBng = new ArrayList<NilaiBangunan>();
        
        ArrayList<String> daftarBng = DBFetching.getArrayListStringResult(
          "select bng_ke from rslt_penilaian where thn_penilaian='"+thn+"' and nop='"+nop+"'", 1);
        
        for(int i=0;i<daftarBng.size();i++) {
            listNilBng.add(ambilBng(thn, nop, daftarBng.get(i)));
        }
        return listNilBng;
    }
    
    private static NilaiBangunan ambilBng(String thn,String nop, String bngKe) {
        NilaiBangunan nilBng = new NilaiBangunan();
        
        ResultSet rs = DBFetching.getResultSet(
        "select * from rslt_penilaian where thn_penilaian = '"+thn+"' and nop='"+nop+"' and bng_ke='"+bngKe+"'");
        
        try {
            while(rs.next()) {
                nilBng.setThnPenilaian(rs.getString("thn_penilaian"));      nilBng.setNop(rs.getString("nop"));
                nilBng.setBngKe(rs.getString("bng_ke"));                    nilBng.setJpb(rs.getString("jpb"));
                nilBng.setLuasBng(Double.parseDouble(rs.getString("luas_bng")));
                nilBng.setLuasBase(Double.parseDouble(rs.getString("luas_base")));
                nilBng.setJmlLtBng(Integer.parseInt(rs.getString("jml_lt_bng")));
                nilBng.setJmlLtBase(Integer.parseInt(rs.getString("jml_lt_base")));
                nilBng.setPersenPenyusutan(Double.parseDouble(rs.getString("persen_susut")));
            }
        } catch (Exception e) {}
        
        //ambil detil
        nilBng.setKompUtama(ambilDetil(thn, nop, bngKe, "KOMPUTAMA"));
        nilBng.setMatDinDal(ambilDetil(thn, nop, bngKe, "MATDINDAL"));
        nilBng.setMatDinLuar(ambilDetil(thn, nop, bngKe, "MATDINLUAR"));
        nilBng.setPelDinDal(ambilDetil(thn, nop, bngKe, "PELDINDAL"));
        nilBng.setPelDinLuar(ambilDetil(thn, nop, bngKe, "PELDINLUAR"));
        nilBng.setKompLangit(ambilDetil(thn, nop, bngKe, "KOMPLANGIT"));
        nilBng.setKompAtap(ambilDetil(thn, nop, bngKe, "KOMPATAP"));
        nilBng.setKompLantai(ambilDetil(thn, nop, bngKe, "KOMPLANTAI"));
        
        FasilitasBangunan fasBng = new FasilitasBangunan();
        fasBng.setAcSentral(ambilDetil(thn, nop, bngKe, "FASACSENT"));
        fasBng.setLift(ambilDetil(thn, nop, bngKe, "FASLIFT"));
        fasBng.setEskalator(ambilDetil(thn, nop, bngKe, "FASESKALATOR"));
        fasBng.setPagar(ambilDetil(thn, nop, bngKe, "FASPAGAR"));
        fasBng.setProteksiApi(ambilDetil(thn, nop, bngKe, "FASPROAPI"));
        fasBng.setPabx((ambilDetil(thn, nop, bngKe, "FASPABX").size()>0)?ambilDetil(thn, nop, bngKe, "FASPABX").get(0):null);
        fasBng.setSumurArtesis((ambilDetil(thn, nop, bngKe, "FASSUMUR").size()>0)?ambilDetil(thn, nop, bngKe, "FASSUMUR").get(0):null);
        fasBng.setSistemAirPanas((ambilDetil(thn, nop, bngKe, "FASAIRPANAS").size()>0)?ambilDetil(thn, nop, bngKe, "FASAIRPANAS").get(0):null);
        fasBng.setPenangkalPetir((ambilDetil(thn, nop, bngKe, "FASPETIR").size()>0)?ambilDetil(thn, nop, bngKe, "FASPETIR").get(0):null);
        fasBng.setSistemLimbah((ambilDetil(thn, nop, bngKe, "FASLIMBAH").size()>0)?ambilDetil(thn, nop, bngKe, "FASLIMBAH").get(0):null);
        fasBng.setSistemTataSuara((ambilDetil(thn, nop, bngKe, "FASTATASUARA").size()>0)?ambilDetil(thn, nop, bngKe, "FASTATASUARA").get(0):null);
        fasBng.setVideoInterkom((ambilDetil(thn, nop, bngKe, "FASVIDEOINT").size()>0)?ambilDetil(thn, nop, bngKe, "FASVIDEOINT").get(0):null);
        fasBng.setReservoir((ambilDetil(thn, nop, bngKe, "FASRESERVOIR").size()>0)?ambilDetil(thn, nop, bngKe, "FASRESERVOIR").get(0):null);
        fasBng.setTelevisi(ambilDetil(thn, nop, bngKe, "FASTELEVISI"));
        fasBng.setKolamRenang((ambilDetil(thn, nop, bngKe, "FASKOLAM").size()>0)?ambilDetil(thn, nop, bngKe, "FASKOLAM").get(0):null);
        fasBng.setLapanganTenis(ambilDetil(thn, nop, bngKe, "FASLAPTENIS"));
        fasBng.setPerkerasan(ambilDetil(thn, nop, bngKe, "FASPERKERASAN"));
        nilBng.setKompFasilitas(fasBng);
        nilBng.setFasilitasTdkSusut(ambilDetil(thn, nop, bngKe, "FASTDKSUSUT"));

        return nilBng;
    }

    private static ArrayList<ItemPenilaian> ambilDetil(String thn, String nop, String bngKe, String kdDetil) {
        ResultSet rs = DBFetching.getResultSet(
        "select * from rslt_penilaian_detil where thn_penilaian='"+thn+"' and nop='"
        +nop+"' and bng_ke='"+bngKe+"' and kd_detil='"+kdDetil+"'");
        
        ArrayList<ItemPenilaian> lItem = new ArrayList<ItemPenilaian>();
        try {
            while (rs.next()) {
                ItemPenilaian itemPenil = new ItemPenilaian();
                isiItemPenilaian(rs.getString("nama_item"), Double.parseDouble(rs.getString("luas_item")), 
                rs.getString("satuan_item"), rs.getString("nm_komp"), Double.parseDouble(rs.getString("nilai_komp")), itemPenil, lItem);
            }
        } catch (Exception e) {}
        return lItem;
    }
    
    public static Double totalSemuaNilaiBng(ArrayList<NilaiBangunan> lisNilBng) {
        Double totNilai=0.0;
        for (int i=0;i<lisNilBng.size();i++) {
            totNilai = totNilai+lisNilBng.get(i).getNilaiBangunan();
        }
        return totNilai;
    }
}
