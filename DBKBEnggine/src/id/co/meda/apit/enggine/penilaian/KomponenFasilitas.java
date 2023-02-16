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
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class KomponenFasilitas {
    public static void hitungFasilitas(LspopNonStandar lspop, String thn, FasilitasBangunan fasBng) {
        //hitungan Ac Sentral
        ArrayList<ItemPenilaian> listAcSentral = new ArrayList<ItemPenilaian>();
        hitungAcSentral(lspop, thn, listAcSentral);
        fasBng.setAcSentral(listAcSentral);

        //hitungan Lift
        ArrayList<ItemPenilaian> listLift = new ArrayList<ItemPenilaian>();
        hitungLift(lspop, thn, listLift);
        fasBng.setLift(listLift);

        //hitungan Eskalator
        ArrayList<ItemPenilaian> listEskalator = new ArrayList<ItemPenilaian>();
        hitungEskalator(lspop, thn, listEskalator);
        fasBng.setEskalator(listEskalator);

        //hitungan Pagar
        ArrayList<ItemPenilaian> listPagar = new ArrayList<ItemPenilaian>();
        hitungPagar(lspop, thn, listPagar);
        fasBng.setPagar(listPagar);

        //hitungan Proteksi Api
        ArrayList<ItemPenilaian> listProApi = new ArrayList<ItemPenilaian>();
        hitungProApi(lspop, thn, listProApi);
        fasBng.setProteksiApi(listProApi);
        
        //hitungan Pabx
        ItemPenilaian pabx = new ItemPenilaian();
        hitungPabx(lspop,thn,pabx);
        fasBng.setPabx(pabx);

        //hitungan Sumur Artesis
        ItemPenilaian sumur = new ItemPenilaian();
        hitungSumur(lspop,thn,sumur);
        fasBng.setSumurArtesis(sumur);

        //hitungan Sistem Air Panas
        ItemPenilaian airPanas = new ItemPenilaian();
        hitungAirPanas(lspop,thn,airPanas);
        fasBng.setSistemAirPanas(airPanas);

        //hitungan Penangkal Petir
        ItemPenilaian petir = new ItemPenilaian();
        hitungPetir(lspop,thn,petir);
        fasBng.setPenangkalPetir(petir);
        
        //hitungan Pengolah Limbah
        ItemPenilaian limbah = new ItemPenilaian();
        hitungLimbah(lspop,thn,limbah);
        fasBng.setSistemLimbah(limbah);

        //hitungan Tata Suara
        ItemPenilaian tataSuara = new ItemPenilaian();
        hitungTataSuara(lspop,thn,tataSuara);
        fasBng.setSistemTataSuara(tataSuara);

        //hitungan Video Interkom
        ItemPenilaian videoInterkom = new ItemPenilaian();
        hitungVideoInterkom(lspop,thn,videoInterkom);
        fasBng.setVideoInterkom(videoInterkom);

        //hitungan Reservoir
        ItemPenilaian reservoir = new ItemPenilaian();
        hitungReservoir(lspop,thn,reservoir);
        fasBng.setReservoir(reservoir);

        //hitungan Televisi
        ArrayList<ItemPenilaian> listTv = new ArrayList<ItemPenilaian>();
        hitungTv(lspop, thn, listTv);
        fasBng.setTelevisi(listTv);
        
        //hitungan Kolam Renang
        ItemPenilaian kolamRenang = new ItemPenilaian();
        hitungKolamRenang(lspop,thn,kolamRenang);
        fasBng.setKolamRenang(kolamRenang);
        
        //hitungan Perkerasan
        ArrayList<ItemPenilaian> perkerasan = new ArrayList<ItemPenilaian>();
        hitungPerkerasan(lspop, thn, perkerasan);
        fasBng.setPerkerasan(perkerasan);

        //hitungan Lapangan Tenis
        ArrayList<ItemPenilaian> lapTenis = new ArrayList<ItemPenilaian>();
        hitungLapTenis(lspop, thn, lapTenis);
        fasBng.setLapanganTenis(lapTenis);
        
    }


    
    private static void hitungAcSentral(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listAcSentral) {
        if (lspop.isAcSentral()) {
            switch (lspop.getJpb().substring(0,2)) {
                case "02":
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL200' and tahun='"+thn+"'", 
                        "Bangunan Lain", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listAcSentral);
                    break;
                case "07":
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL701' and tahun='"+thn+"'", 
                        "Kamar", lspop.getLsBngUtama(), "m2", "", listAcSentral);
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL702' and tahun='"+thn+"'", 
                        "Ruangan Lain", lspop.getLsBngLain(), "m2", "", listAcSentral);
                    break;
                case "04":
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL400' and tahun='"+thn+"'", 
                        "Bangunan Lain", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listAcSentral);
                    break;
                case "05":
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL501' and tahun='"+thn+"'", 
                        "Kamar", lspop.getLsBngUtama(), "m2", "", listAcSentral);
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL502' and tahun='"+thn+"'", 
                        "Ruangan Lain", lspop.getLsBngLain(), "m2", "", listAcSentral);
                    break;
                case "13":
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL131' and tahun='"+thn+"'", 
                        "Ruang Apartemen", lspop.getLsBngUtama(), "m2", "", listAcSentral);
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL132' and tahun='"+thn+"'", 
                        "Ruangan Lain", lspop.getLsBngLain(), "m2", "", listAcSentral);
                    break;
                default:
                    ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCL001' and tahun='"+thn+"'", 
                        "Bangunan Lain", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listAcSentral);
            }
        }
    }
   
    private static void hitungLift(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listLift) {
        if (lspop.getLiftPenumpangJml()>0) {
            if (lspop.getJmlLtBng()<5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLP001' and tahun='"+thn+"'", 
                    "Penumpang", lspop.getLiftPenumpangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>=5 && lspop.getJmlLtBng()<10) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLP002' and tahun='"+thn+"'", 
                    "Penumpang", lspop.getLiftPenumpangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>=10 && lspop.getJmlLtBng()<20) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLP003' and tahun='"+thn+"'", 
                    "Penumpang", lspop.getLiftPenumpangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>20) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLP004' and tahun='"+thn+"'", 
                    "Penumpang", lspop.getLiftPenumpangJml().doubleValue(), "Unit", "", listLift);
            }
        }
        if (lspop.getLiftBarangJml()>0) {
            if (lspop.getJmlLtBng()<5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLS001' and tahun='"+thn+"'", 
                    "Barang", lspop.getLiftBarangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>=5 && lspop.getJmlLtBng()<10) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLS002' and tahun='"+thn+"'", 
                    "Barang", lspop.getLiftBarangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>=10 && lspop.getJmlLtBng()<20) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLS003' and tahun='"+thn+"'", 
                    "Barang", lspop.getLiftBarangJml().doubleValue(), "Unit", "", listLift);
            }
            else if (lspop.getJmlLtBng()>20) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FLS004' and tahun='"+thn+"'", 
                    "Barang", lspop.getLiftBarangJml().doubleValue(), "Unit", "", listLift);
            }
        }
    }
    
    private static void hitungEskalator(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listEskalator) {
        if (lspop.getEskalatorLess08Jml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FES001' and tahun='"+thn+"'", 
                "Lebar < 0,8 m", lspop.getEskalatorLess08Jml().doubleValue(), "Unit", "", listEskalator);
        }
        if (lspop.getEskalatorGreat08Jml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FES002' and tahun='"+thn+"'", 
                "Lebar > 0,8 m", lspop.getEskalatorGreat08Jml().doubleValue(), "Unit", "", listEskalator);
        }
    }
    
    private static void hitungPagar(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listPagar) {
        if (lspop.getPagarBatakoPanjang()>0) {
            if (lspop.getPagarBatakoTinggi()<=1) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPA001' and tahun='"+thn+"'", 
                "Batako, Tinggi s/d 1m", lspop.getPagarBatakoPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBatakoTinggi()>1 && lspop.getPagarBatakoTinggi()<=1.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPA002' and tahun='"+thn+"'", 
                "Batako, Tinggi > 1m s/d 1.5m", lspop.getPagarBatakoPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBatakoTinggi()>1.5 && lspop.getPagarBatakoTinggi()<=2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPA003' and tahun='"+thn+"'", 
                "Batako, Tinggi > 1.5m s/d 2m", lspop.getPagarBatakoPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBatakoTinggi()>2 && lspop.getPagarBatakoTinggi()<=2.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPA004' and tahun='"+thn+"'", 
                "Batako, Tinggi > 2m s/d 2.5m", lspop.getPagarBatakoPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBatakoTinggi()>2.5 && lspop.getPagarBatakoTinggi()<=3) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPA005' and tahun='"+thn+"'", 
                "Batako, Tinggi > 2.5m s/d 3m", lspop.getPagarBatakoPanjang().doubleValue(), "m", "", listPagar);
            }
        }
        if (lspop.getPagarBataPanjang()>0) {
            if (lspop.getPagarBataTinggi()<=1) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPB001' and tahun='"+thn+"'", 
                "Bata, Tinggi s/d 1m", lspop.getPagarBataPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBataTinggi()>1 && lspop.getPagarBataTinggi()<=1.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPB002' and tahun='"+thn+"'", 
                "Bata, Tinggi > 1m s/d 1.5m", lspop.getPagarBataPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBataTinggi()>1.5 && lspop.getPagarBataTinggi()<=2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPB003' and tahun='"+thn+"'", 
                "Bata, Tinggi > 1.5m s/d 2m", lspop.getPagarBataPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBataTinggi()>2 && lspop.getPagarBataTinggi()<=2.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPB004' and tahun='"+thn+"'", 
                "Bata, Tinggi > 2m s/d 2.5m", lspop.getPagarBataPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBataTinggi()>2.5 && lspop.getPagarBataTinggi()<=3) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPB005' and tahun='"+thn+"'", 
                "Bata, Tinggi > 2.5m s/d 3m", lspop.getPagarBataPanjang().doubleValue(), "m", "", listPagar);
            }
        }
        if (lspop.getPagarBetonPanjang()>0) {
            if (lspop.getPagarBetonTinggi()==2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC001' and tahun='"+thn+"'", 
                "Beton, Tinggi 2m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBetonTinggi()==2.2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC002' and tahun='"+thn+"'", 
                "Beton, Tinggi 2.2m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBetonTinggi()==2.4) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC003' and tahun='"+thn+"'", 
                "Beton, Tinggi 2.4m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBetonTinggi()==2.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC004' and tahun='"+thn+"'", 
                "Beton, Tinggi 2.5m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBetonTinggi()==2.8) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC005' and tahun='"+thn+"'", 
                "Beton, Tinggi 2.8m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBetonTinggi()==3) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPC006' and tahun='"+thn+"'", 
                "Beton, Tinggi 3m", lspop.getPagarBetonPanjang().doubleValue(), "m", "", listPagar);
            }
        }
        if (lspop.getPagarBesiPanjang()>0) {
            if (lspop.getPagarBesiTinggi()<=1) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPD001' and tahun='"+thn+"'", 
                "Besi, Tinggi s/d 1m", lspop.getPagarBesiPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBesiTinggi()>1 && lspop.getPagarBesiTinggi()<=1.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPD002' and tahun='"+thn+"'", 
                "Besi, Tinggi > 1m s/d 1.5m", lspop.getPagarBesiPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBesiTinggi()>1.5 && lspop.getPagarBesiTinggi()<=2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPD003' and tahun='"+thn+"'", 
                "Besi, Tinggi > 1.5m s/d 2m", lspop.getPagarBesiPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBesiTinggi()>2 && lspop.getPagarBesiTinggi()<=2.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPD004' and tahun='"+thn+"'", 
                "Besi, Tinggi > 2m s/d 2.5m", lspop.getPagarBesiPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBesiTinggi()>2.5 && lspop.getPagarBesiTinggi()<=3) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPD005' and tahun='"+thn+"'", 
                "Besi, Tinggi > 2.5m s/d 3m", lspop.getPagarBesiPanjang().doubleValue(), "m", "", listPagar);
            }
        }
        if (lspop.getPagarBrcPanjang()>0) {
            if (lspop.getPagarBrcTinggi()<=1) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPE001' and tahun='"+thn+"'", 
                "BRC, Tinggi s/d 1m", lspop.getPagarBrcPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBrcTinggi()>1 && lspop.getPagarBrcTinggi()<=1.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPE002' and tahun='"+thn+"'", 
                "BRC, Tinggi > 1m s/d 1.5m", lspop.getPagarBrcPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBrcTinggi()>1.5 && lspop.getPagarBrcTinggi()<=2) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPE003' and tahun='"+thn+"'", 
                "BRC, Tinggi > 1.5m s/d 2m", lspop.getPagarBrcPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBrcTinggi()>2 && lspop.getPagarBrcTinggi()<=2.5) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPE004' and tahun='"+thn+"'", 
                "BRC, Tinggi > 2m s/d 2.5m", lspop.getPagarBrcPanjang().doubleValue(), "m", "", listPagar);
            }
            else if (lspop.getPagarBrcTinggi()>2.5 && lspop.getPagarBrcTinggi()<=3) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FPE005' and tahun='"+thn+"'", 
                "BRC, Tinggi > 2.5m s/d 3m", lspop.getPagarBrcPanjang().doubleValue(), "m", "", listPagar);
            }
        }
    }
    
    private static void hitungProApi(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listProApi) {
        if (lspop.isHydrant()) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FAP001' and tahun='"+thn+"'", 
            "Hydrant", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listProApi);
        }
        if (lspop.isSprinkler()) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FAP002' and tahun='"+thn+"'", 
            "Sprinkler", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listProApi);
        }
        if (lspop.isAlarm()) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FAP003' and tahun='"+thn+"'", 
            "Alarm Kebakaran", lspop.getLsBngUtama()+lspop.getLsBngLain(), "m2", "", listProApi);
        }
        if (lspop.isInterkom()) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FAP004' and tahun='"+thn+"'", 
            "Interkom", lspop.getJmlLtBng().doubleValue(), "lt", "", listProApi);
        }
    }
    
    private static void hitungPabx(LspopNonStandar lspop, String thn, ItemPenilaian pabx) {
        Double nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FBX001' and tahun='"+thn+"'");
        pabx.setNamaItem("PABX");           pabx.setLuasItem(lspop.getJmlPabx().doubleValue());
        pabx.setSatuanItem("saluran");      pabx.setNamaKomponen("");           pabx.setNilaiKomponen(nilaiNya);
    }
    
    private static void hitungSumur(LspopNonStandar lspop, String thn, ItemPenilaian sumur) {
        Double nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FMR001' and tahun='"+thn+"'");
        sumur.setNamaItem("Sumur Artesis");           sumur.setLuasItem(lspop.getSumurArtesis());
        sumur.setSatuanItem("m");      sumur.setNamaKomponen("");           sumur.setNilaiKomponen(nilaiNya);
        
    }
    
    private static void hitungAirPanas(LspopNonStandar lspop, String thn, ItemPenilaian airPanas) {
        Double nilaiNya = 0.0;
        airPanas.setNamaItem("Sistem Air Panas");      airPanas.setLuasItem(lspop.getLsBngUtama());
        airPanas.setSatuanItem("m2");      airPanas.setNamaKomponen("");           airPanas.setNilaiKomponen(0.0);

        if (lspop.isAirPanas()) {
            switch (lspop.getJpb().substring(0, 2)) {
                case "02": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS001' and tahun='"+thn+"'"); break;
                case "04": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS002' and tahun='"+thn+"'"); break;
                case "05": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS003' and tahun='"+thn+"'"); break;
                case "07": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS004' and tahun='"+thn+"'"); break;
                case "12": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS005' and tahun='"+thn+"'"); break;
                case "13": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FRS006' and tahun='"+thn+"'"); break;
            }
            airPanas.setNilaiKomponen(nilaiNya);
        } 
    }
    
    private static void hitungPetir(LspopNonStandar lspop, String thn, ItemPenilaian petir) {
        Double nilaiNya = 0.0;
        petir.setNamaItem("Penangkal Petir");      petir.setLuasItem(lspop.getJmlLtBng().doubleValue());
        petir.setSatuanItem("lt");      petir.setNamaKomponen("");           petir.setNilaiKomponen(0.0);
        
        if (lspop.isPenangkalPetir()) {
            nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PNR001' and tahun='"+thn+"'");
            petir.setNilaiKomponen(nilaiNya);
        } 
    }
    
    private static void hitungLimbah(LspopNonStandar lspop, String thn, ItemPenilaian limbah) {
        Double nilaiNya = 0.0;
        limbah.setNamaItem("Pengolah Limbah");      limbah.setLuasItem(lspop.getJmlLtBng().doubleValue());
        limbah.setSatuanItem("m2");      limbah.setNamaKomponen("");           limbah.setNilaiKomponen(0.0);
        
        if (lspop.isPengolahLimbah()) {
            switch (lspop.getJpb().substring(0, 2)) {
                case "02": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH001' and tahun='"+thn+"'"); break;
                case "04": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH002' and tahun='"+thn+"'"); break;
                case "05": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH003' and tahun='"+thn+"'"); break;
                case "07": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH004' and tahun='"+thn+"'"); break;
                case "12": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH005' and tahun='"+thn+"'"); break;
                case "13": nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='PMH006' and tahun='"+thn+"'"); break;
            }
            limbah.setNilaiKomponen(nilaiNya);
        }
    }
    
    private static void hitungTataSuara(LspopNonStandar lspop, String thn, ItemPenilaian tataSuara) {
        Double nilaiNya = 0.0;
        tataSuara.setNamaItem("Sistem Tata Suara");      tataSuara.setLuasItem(lspop.getLsBngUtama());
        tataSuara.setSatuanItem("m2");      tataSuara.setNamaKomponen("");           tataSuara.setNilaiKomponen(0.0);
        
        if (lspop.isTataSuara()) {
            nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FUR001' and tahun='"+thn+"'");
            tataSuara.setNilaiKomponen(nilaiNya);
        } 
    }

    private static void hitungVideoInterkom(LspopNonStandar lspop, String thn, ItemPenilaian videoInterkom) {
        Double nilaiNya = 0.0;
        videoInterkom.setNamaItem("Video Interkom");      videoInterkom.setLuasItem(0.0);
        videoInterkom.setSatuanItem("m2");      videoInterkom.setNamaKomponen("");           videoInterkom.setNilaiKomponen(0.0);
        
        if (lspop.getVideoInterkomLuas()>0.0 && lspop.getVideoInterkomJmlLt()>0) {
            nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FVD001' and tahun='"+thn+"'");
            videoInterkom.setNilaiKomponen(nilaiNya);
            videoInterkom.setLuasItem(lspop.getVideoInterkomLuas()*lspop.getVideoInterkomJmlLt().doubleValue());
        } 
    }

    private static void hitungReservoir(LspopNonStandar lspop, String thn, ItemPenilaian reservoir) {
        Double nilaiNya = 0.0;
        reservoir.setNamaItem("Reservoir");      reservoir.setLuasItem(lspop.getLsBngUtama());
        reservoir.setSatuanItem("m2");      reservoir.setNamaKomponen("");           reservoir.setNilaiKomponen(0.0);
        
        if (lspop.isReservoir()) {
            nilaiNya = DBFetching.getDoubleResult("select harga from rslt_fasilitas where id='FVE001' and tahun='"+thn+"'");
            reservoir.setNilaiKomponen(nilaiNya);
        } 
    }
    
    private static void hitungTv(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listTv) {
        if (lspop.getTvCctvJmlLt()>0 && lspop.getTvCctvLuas()>0.0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FTV002' and tahun='"+thn+"'", 
            "CCTV", lspop.getTvCctvJmlLt().doubleValue()*lspop.getTvCctvLuas(), "m2", "", listTv);
        }
        if (lspop.getTvMatvJmlLt()>0 && lspop.getTvMatvLuas()>0.0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FTV001' and tahun='"+thn+"'", 
            "MATV", lspop.getTvMatvJmlLt().doubleValue()*lspop.getTvMatvLuas(), "m2", "", listTv);
        }
    }
    
    private static void hitungKolamRenang(LspopNonStandar lspop, String thn, ItemPenilaian kolRenang) {
        Double nilaiNya = 0.0;
        kolRenang.setNamaItem("Kolam Renang");      kolRenang.setLuasItem(0.0);
        kolRenang.setSatuanItem("m2");      kolRenang.setNamaKomponen("");           kolRenang.setNilaiKomponen(0.0);
        
        if (lspop.getKolamRenangLs()>0) {
            String kdFinish = (lspop.getKolamRenangFinish().equals("Diplester"))?"Plester":"Pelapis";
            
            String kdNilai = "";
            if (lspop.getKolamRenangLs()<=50) {kdNilai = "K1";}
            else if (lspop.getKolamRenangLs()>50 && lspop.getKolamRenangLs()<=100) {kdNilai = "K2";}
            else if (lspop.getKolamRenangLs()>100 && lspop.getKolamRenangLs()<=200) {kdNilai = "K3";}
            else if (lspop.getKolamRenangLs()>200 && lspop.getKolamRenangLs()<=400) {kdNilai = "K4";}
            else if (lspop.getKolamRenangLs()>400) {kdNilai = "K5";}
            
            Integer nilaiTemp = DBFetching.getIntegerResult("select "+kdFinish
                    +" from rslt_fasilitaskolam where id='"+kdNilai+"' and tahun='"+thn+"'");
            nilaiNya = nilaiTemp.doubleValue();
            
            kolRenang.setLuasItem(lspop.getKolamRenangLs());
            kolRenang.setNamaKomponen(lspop.getKolamRenangFinish());           
            kolRenang.setNilaiKomponen(nilaiNya);
        }
    }
    
    private static void hitungPerkerasan(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> perkerasan) {
        if (lspop.getPerkerasanKerasLs()>0) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='PER003' and tahun='"+thn+"'", 
                "Keras", lspop.getPerkerasanKerasLs(), "m2", "", perkerasan);
            }
        if (lspop.getPerkerasanSedangLs()>0) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='PER002' and tahun='"+thn+"'", 
                "Sedang", lspop.getPerkerasanSedangLs(), "m2", "", perkerasan);
            }
        if (lspop.getPerkerasanRinganLs()>0) {
                ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='PER001' and tahun='"+thn+"'", 
                "Ringan", lspop.getPerkerasanRinganLs(), "m2", "", perkerasan);
            }
    }
    
    private static void hitungLapTenis(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> lapTenis) {
        if (lspop.getLapTenisAspalLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT002' and tahun='"+thn+"'", 
                "Aspal 1 Ban Dengan Lampu", lspop.getLapTenisAspalLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisAspalLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT002' and tahun='"+thn+"'", 
                "Aspal "+lspop.getLapTenisAspalLampuJml().toString()+" Ban Dengan Lampu", lspop.getLapTenisAspalLampuJml().doubleValue(), "ban", "", lapTenis);
        }
        if (lspop.getLapTenisAspalNoLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT002' and tahun='"+thn+"'", 
                "Aspal 1 Ban Tanpa Lampu", lspop.getLapTenisAspalNoLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisAspalNoLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT002' and tahun='"+thn+"'", 
                "Aspal "+lspop.getLapTenisAspalNoLampuJml().toString()+" Ban Tanpa Lampu", lspop.getLapTenisAspalNoLampuJml().doubleValue(), "ban", "", lapTenis);
        }
        if (lspop.getLapTenisTanahLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Tanah Liat 1 Ban Dengan Lampu", lspop.getLapTenisTanahLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisTanahLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Tanah Liat "+lspop.getLapTenisTanahLampuJml().toString()+" Ban Dengan Lampu", lspop.getLapTenisTanahLampuJml().doubleValue(), "ban", "", lapTenis);
        }
        if (lspop.getLapTenisTanahNoLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Tanah Liat 1 Ban Tanpa Lampu", lspop.getLapTenisTanahNoLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisTanahNoLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Tanah Liat "+lspop.getLapTenisTanahNoLampuJml().toString()+" Ban Tanpa Lampu", lspop.getLapTenisTanahNoLampuJml().doubleValue(), "ban", "", lapTenis);
        }
        if (lspop.getLapTenisBetonLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Beton 1 Ban Dengan Lampu", lspop.getLapTenisBetonLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisBetonLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_DgLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Beton "+lspop.getLapTenisBetonLampuJml().toString()+" Ban Dengan Lampu", lspop.getLapTenisBetonLampuJml().doubleValue(), "ban", "", lapTenis);
        }
        if (lspop.getLapTenisBetonNoLampuJml()==1) {
            ambilNilaiDbMasukkanKeItemPenilaian("select SatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Beton 1 Ban Tanpa Lampu", lspop.getLapTenisBetonNoLampuJml().doubleValue(), "ban", "", lapTenis);
        } else if (lspop.getLapTenisBetonNoLampuJml()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("select LSatuBan_TnpLampu from rslt_fasilitaslaptenis where id='LT003' and tahun='"+thn+"'", 
                "Beton "+lspop.getLapTenisBetonNoLampuJml().toString()+" Ban Tanpa Lampu", lspop.getLapTenisBetonNoLampuJml().doubleValue(), "ban", "", lapTenis);
        }
    }
    
    public static void hitungFasTdkSusut(LspopNonStandar lspop, String thn, ArrayList<ItemPenilaian> listFasTdkSusut) {
        if (lspop.getDayaListrik()>0) {
            switch (lspop.getJpb().substring(0,2)) {
                case "02":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FK001' and tahun='"+thn+"'", 
                   "Daya Listrik", lspop.getDayaListrik().doubleValue(), "KVA", "", listFasTdkSusut); break;
                case "07":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FK002' and tahun='"+thn+"'", 
                   "Daya Listrik", lspop.getDayaListrik().doubleValue(), "KVA", "", listFasTdkSusut); break;
                case "04":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FK003' and tahun='"+thn+"'", 
                   "Daya Listrik", lspop.getDayaListrik().doubleValue(), "KVA", "", listFasTdkSusut); break;
                case "13":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FK004' and tahun='"+thn+"'", 
                   "Daya Listrik", lspop.getDayaListrik().doubleValue(), "KVA", "", listFasTdkSusut); break;
            }
        }
        if (lspop.getAcSplitJml()>0) {
            switch (lspop.getAcSplitPk()) {
                case "1":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCA001' and tahun='"+thn+"'", 
                   "AC Split 1 PK", lspop.getAcSplitJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "1.5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCA002' and tahun='"+thn+"'", 
                   "AC Split 1.5 PK", lspop.getAcSplitJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "2":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCA003' and tahun='"+thn+"'", 
                   "AC Split 2 PK", lspop.getAcSplitJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "2.5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCA004' and tahun='"+thn+"'", 
                   "AC Split 2.5 PK", lspop.getAcSplitJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "3":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCA005' and tahun='"+thn+"'", 
                   "AC Split 3 PK", lspop.getAcSplitJml().doubleValue(), "buah", "", listFasTdkSusut); break;
            }
        }
        if (lspop.getAcWindowJml()>0) {
            switch (lspop.getAcWindowPk()) {
                case "0.5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCB001' and tahun='"+thn+"'", 
                   "AC Window 0.5 PK", lspop.getAcWindowJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "1":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCB002' and tahun='"+thn+"'", 
                   "AC Window 1 PK", lspop.getAcWindowJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "1.5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCB003' and tahun='"+thn+"'", 
                   "AC Window 1.5 PK", lspop.getAcWindowJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "2":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCB004' and tahun='"+thn+"'", 
                   "AC Window 2 PK", lspop.getAcWindowJml().doubleValue(), "buah", "", listFasTdkSusut); break;
            }
        }
        if (lspop.getAcFloorJml()>0) {
            switch (lspop.getAcFloorPk()) {
                case "2":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC001' and tahun='"+thn+"'", 
                   "AC Floor 2 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "2.5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC002' and tahun='"+thn+"'", 
                   "AC Floor 2.5 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "3":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC003' and tahun='"+thn+"'", 
                   "AC Floor 3 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "5":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC004' and tahun='"+thn+"'", 
                   "AC Floor 5 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "10":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC005' and tahun='"+thn+"'", 
                   "AC Floor 10 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "15":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC006' and tahun='"+thn+"'", 
                   "AC Floor 15 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "20":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC007' and tahun='"+thn+"'", 
                   "AC Floor 20 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "25":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC008' and tahun='"+thn+"'", 
                   "AC Floor 25 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
                case "30":
                   ambilNilaiDbMasukkanKeItemPenilaian("select harga from rslt_fasilitas where id='FCC009' and tahun='"+thn+"'", 
                   "AC Floor 30 PK", lspop.getAcFloorJml().doubleValue(), "buah", "", listFasTdkSusut); break;
            }
        }
    }
    
    private static void ambilNilaiDbMasukkanKeItemPenilaian(String strQuery, String nmItem, 
            Double lsBng, String nmSat, String nmKomp, ArrayList<ItemPenilaian> listItemPenil) {
            Double nilaiNya = DBFetching.getDoubleResult(strQuery);
            ItemPenilaian itemPenil = new ItemPenilaian();
            ToolsPenilaian.isiItemPenilaian(nmItem, lsBng, 
                    nmSat, nmKomp, nilaiNya, itemPenil, listItemPenil);
        
    }

}
