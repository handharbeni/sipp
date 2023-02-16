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
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class PenilaianBangunan {
    private String nop;
    private String thnPenilaian;
    private final ArrayList<LspopNonStandar> listLspop = new ArrayList<LspopNonStandar>();
    private final ArrayList<NilaiBangunan> listNilaiBangunan = new ArrayList<NilaiBangunan>();
    
    public PenilaianBangunan(String nop, String thnPenilaian) {
        this.nop = nop;
        this.thnPenilaian = thnPenilaian;
    }
    
    public void mulaiPenilaian() {
        ToolsPenilaian.ambilLspopFromDbPerNop(nop, listLspop);
        for (int i = 0; i < listLspop.size(); i++) {
            NilaiBangunan nilBng = penilaianBngKe(listLspop.get(i));
            listNilaiBangunan.add(nilBng);
        }
        
        simpanKeDB(listNilaiBangunan);
    //    NumberFormat numFormat = NumberFormat.getNumberInstance();

    }
    
    private NilaiBangunan penilaianBngKe(LspopNonStandar lspop) {
        NilaiBangunan nilBng = new NilaiBangunan();
        //data umum
        nilBng.setThnPenilaian(thnPenilaian);
        nilBng.setNop(lspop.getNop());              nilBng.setBngKe(lspop.getBngKe());
        nilBng.setJpb(lspop.getJpb());
        nilBng.setLuasBng(lspop.getLsBngUtama()+lspop.getLsBngLain());          
        nilBng.setLuasBase(lspop.getLsBase());
        nilBng.setJmlLtBng(lspop.getJmlLtBng());    nilBng.setJmlLtBase(lspop.getJmlLtBase());
        
//        System.out.println(nilBng.getBngKe());
  
        //hitungan komponen utama
        ArrayList<ItemPenilaian> listKompUtama = new ArrayList<ItemPenilaian>();
        KomponenUtama.hitung(lspop, thnPenilaian, listKompUtama);
        nilBng.setKompUtama(listKompUtama);
        
        //hitungan komponen material dinding dalam
        ArrayList<ItemPenilaian> listMatDinDal = new ArrayList<>();
        KomponenMaterial.hitungDindingDalam(lspop, thnPenilaian, listMatDinDal);
        nilBng.setMatDinDal(listMatDinDal);

        //hitungan komponen material dinding luar
        ArrayList<ItemPenilaian> listMatDinLuar = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungDindingLuar(lspop, thnPenilaian, listMatDinLuar);
        nilBng.setMatDinLuar(listMatDinLuar);

        //hitungan komponen pelapis dinding dalam
        ArrayList<ItemPenilaian> listPelDinDal = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungPelDindingDalam(lspop, thnPenilaian, listPelDinDal);
        nilBng.setPelDinDal(listPelDinDal);

        //hitungan komponen pelapis dinding luar
        ArrayList<ItemPenilaian> listPelDinLuar = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungPelDindingLuar(lspop, thnPenilaian, listPelDinLuar);
        nilBng.setPelDinLuar(listPelDinLuar);

        //hitungan komponen langit2
        ArrayList<ItemPenilaian> listKompLangit = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungKompLangit(lspop, thnPenilaian, listKompLangit);
        nilBng.setKompLangit(listKompLangit);

        //hitungan komponen atap
        ArrayList<ItemPenilaian> listKompAtap = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungKompAtap(lspop, thnPenilaian, listKompAtap);
        nilBng.setKompAtap(listKompAtap);

        //hitungan komponen lantai
        ArrayList<ItemPenilaian> listKompLantai = new ArrayList<ItemPenilaian>();
        KomponenMaterial.hitungKompLantai(lspop, thnPenilaian, listKompLantai);
        nilBng.setKompLantai(listKompLantai);
        
        //hitungan fasilitas
        FasilitasBangunan fasBng = new FasilitasBangunan();
        KomponenFasilitas.hitungFasilitas(lspop, thnPenilaian, fasBng);
        nilBng.setKompFasilitas(fasBng);
        
        //cari penyusutan
        String kdKondisiBng="";
        switch (lspop.getKondisi()) {
            case "Sangat Baik" : kdKondisiBng="1";
            case "Baik" : kdKondisiBng="2";
            case "Sedang" : kdKondisiBng="3";
            case "Jelek" : kdKondisiBng="4";
        }
        nilBng.setPersenPenyusutan(
          ToolsPenilaian.hitungSusut(thnPenilaian, lspop.getThnBangun(), lspop.getThnRenov(), 
          kdKondisiBng, nilBng.getNilaiBngSblmSusut(), nilBng.getLuasBng()));
        
        //hitungan fasilitas tdk susut
        ArrayList<ItemPenilaian> listFasTdkSusut = new ArrayList<ItemPenilaian>();
        KomponenFasilitas.hitungFasTdkSusut(lspop, thnPenilaian, listFasTdkSusut);
        nilBng.setFasilitasTdkSusut(listFasTdkSusut);
        
        
        return nilBng;
    }

    private void simpanKeDB(ArrayList<NilaiBangunan> lNB) {
        //hapus dulu data di db
        for (int i=0;i<lNB.size();i++) {
            DBFetching.setComandToDB(
            "delete from rslt_penilaian where thn_penilaian='"+lNB.get(i).getThnPenilaian()
            +"' and nop='"+lNB.get(i).getNop()+"' and bng_ke='"+lNB.get(i).getBngKe()+"'");
            DBFetching.setComandToDB(
            "delete from rslt_penilaian_detil where thn_penilaian='"+lNB.get(i).getThnPenilaian()
            +"' and nop='"+lNB.get(i).getNop()+"' and bng_ke='"+lNB.get(i).getBngKe()+"'");
        }
        
        DBFetching.setAutoCommit(false);
        
        try {
            for (int i=0;i<lNB.size();i++) {
                String thn = lNB.get(i).getThnPenilaian();
                String nop = lNB.get(i).getNop();
                String bngKe = lNB.get(i).getBngKe();
                
                //insert totalnya
                DBFetching.setComandToDB(
                "insert into rslt_penilaian values('"+thn+"','"+nop+"','"+bngKe+"','"+lNB.get(i).getJpb()+"',"+lNB.get(i).getLuasBng()
                +","+lNB.get(i).getLuasBase()+","+lNB.get(i).getJmlLtBng()+","+lNB.get(i).getJmlLtBase()
                +","+lNB.get(i).getTotalKompUtama()+","+lNB.get(i).getTotalMatDinDal()+","+lNB.get(i).getTotalMatDinLuar()
                +","+lNB.get(i).getTotalPelDinDal()+","+lNB.get(i).getTotalPelDinLuar()+","+lNB.get(i).getTotalKompLangit()
                +","+lNB.get(i).getTotalKompAtap()+","+lNB.get(i).getTotalKompLantai()+","+lNB.get(i).getKompFasilitas().getNilaiFasilitas()
                +","+lNB.get(i).getTotalKompMaterial()+","+lNB.get(i).getNilaiBngSblmSusut()+","+lNB.get(i).getPersenPenyusutan()
                +","+lNB.get(i).getNilaiPenyusutan()+","+lNB.get(i).getNilaiBngStlhSusut()+","+lNB.get(i).getTotalFasilitasTdkSusut()
                +","+lNB.get(i).getNilaiBangunan()+")");
                
                //insert semua detil
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompUtama(), "KOMPUTAMA");
                insertDetil(thn,nop,bngKe,lNB.get(i).getMatDinDal(), "MATDINDAL");
                insertDetil(thn,nop,bngKe,lNB.get(i).getMatDinLuar(), "MATDINLUAR");
                insertDetil(thn,nop,bngKe,lNB.get(i).getPelDinDal(), "PELDINDAL");
                insertDetil(thn,nop,bngKe,lNB.get(i).getPelDinLuar(), "PELDINLUAR");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompLangit(), "KOMPLANGIT");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompAtap(), "KOMPATAP");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompLantai(), "KOMPLANTAI");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getAcSentral(), "FASACSENT");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getLift(), "FASLIFT");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getEskalator(), "FASESKALATOR");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getPagar(), "FASPAGAR");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getProteksiApi(), "FASPROAPI");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getPabx()), "FASPABX");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getSumurArtesis()), "FASSUMUR");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getSistemAirPanas()), "FASAIRPANAS");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getPenangkalPetir()), "FASPETIR");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getSistemLimbah()), "FASLIMBAH");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getSistemTataSuara()), "FASTATASUARA");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getVideoInterkom()), "FASVIDEOINT");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getReservoir()), "FASRESERVOIR");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getTelevisi(), "FASTELEVISI");
                insertDetil(thn,nop,bngKe,ubahKeList(lNB.get(i).getKompFasilitas().getKolamRenang()), "FASKOLAM");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getLapanganTenis(), "FASLAPTENIS");
                insertDetil(thn,nop,bngKe,lNB.get(i).getKompFasilitas().getPerkerasan(), "FASPERKERASAN");
                insertDetil(thn,nop,bngKe,lNB.get(i).getFasilitasTdkSusut(), "FASTDKSUSUT");
                
               
                DBFetching.Simpan();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            DBFetching.RollBackDB();
        }
        
        DBFetching.setAutoCommit(true);
    }

private void insertDetil(String thn, String nop, String bngKe, ArrayList<ItemPenilaian> listProses, String kdDetil) {
    for (int a=0;a<listProses.size();a++) {
        DBFetching.setComandToDB(
        "insert into rslt_penilaian_detil values('"+thn+"','"+nop+"','"+bngKe+"','"+kdDetil+"',"+a+",'"
        +listProses.get(a).getNamaItem()+"',"+listProses.get(a).getLuasItem()+",'"+listProses.get(a).getSatuanItem()
        +"','"+listProses.get(a).getNamaKomponen()+"',"+listProses.get(a).getNilaiKomponen()+","
        +listProses.get(a).getTotalNilaiItem()+")");
    }
}

private ArrayList<ItemPenilaian> ubahKeList(ItemPenilaian nmKomp) {
    ArrayList<ItemPenilaian> lKomp = new ArrayList<ItemPenilaian>();
    lKomp.add(nmKomp);
    return lKomp;
}
    
    
}
