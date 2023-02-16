/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb3;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ProsesJpb38 {
    final private String thnPenilaian;
    private HitunganJpb38 hit38;
    private ArrayList<tmpTabel> lT; // tabel temporer
    private ArrayList<ItemTabelJpb38> tblJpb3;
    private ArrayList<ItemTabelJpb38> tblJpb8;
    private HitunganDayaDukung hitDyDkg;
    private ArrayList<ItemTabelDyDkg> tblDyDkg;
    private HitunganMezzanine hitMezz;
    
    
    public ProsesJpb38(String thnPenilaian) {
        this.thnPenilaian = thnPenilaian;
    }
    
    public void prosesAll() {
        hitungJpb38();
        bentukTblTemp();
        bentukTblJpb38();
        
        hitungDyDkg();
        bentukTblDyDkg();
        
        hitungMezz();
        
        simpankeDb();
    }
    
    private void hitungMezz() {
        hitMezz = new HitunganMezzanine(thnPenilaian);
        
        ArrayList<ItemHitungan> listTmp = new ArrayList<>();
        listTmp.add(isiItemHitungan("HSKU","B040700",1900.0,"KU"));
        listTmp.add(isiItemHitungan("HSKU","B040700",584.0,"KU"));
        listTmp.add(isiItemHitungan("HSKU","B040700",632.0,"KU"));
        listTmp.add(isiItemHitungan("HSKU","B040700",68.0,"KU"));
        listTmp.add(isiItemHitungan("HSKU","B040600",112580.0,"KU"));
        listTmp.get(4).setHrgMaterial(listTmp.get(4).getHrgMaterial()/100);
        listTmp.get(4).setHrgUpah(listTmp.get(4).getHrgUpah()/100);

        //formwork
        listTmp.add(isiItemHitungan(8260.0, 0.0, hitFormWork(), "KU"));
        listTmp.add(isiItemHitungan(2727.0, 0.0, hitFormWork(), "KU"));
        listTmp.add(isiItemHitungan(4452.0, 0.0, hitFormWork(), "KU"));
        listTmp.add(isiItemHitungan(581.0, 0.0, hitFormWork(), "KU"));
        
        hitMezz.setListItemHitungan(listTmp);
    }
    
    //hitungan lihat di excel JPB2 row 50
    private Double hitFormWork() {
        Double nilai = 0.0;
        ArrayList<ItemHitungan> listNilai = new ArrayList<>();
        listNilai.add(isiItemHitungan("MATERIAL","M01004",0.1,"MZ"));
        listNilai.add(isiItemHitungan("MATERIAL","M01002",0.5,"MZ"));
        listNilai.add(isiItemHitungan("MATERIAL","M01010",0.6,"MZ"));
        listNilai.add(isiItemHitungan("MATERIAL","M01005",4.0,"MZ"));
        
        for (int i=0;i<listNilai.size();i++) {
            nilai = nilai + listNilai.get(i).getJmlHitungan();
        }

        return nilai;
    }
    
    private void bentukTblDyDkg() {
        tblDyDkg = new ArrayList<ItemTabelDyDkg>();
        
        tblDyDkg.add(new ItemTabelDyDkg(1, 600, "Ringan", prosesHitunganTblDyDkg("R")));
        tblDyDkg.add(new ItemTabelDyDkg(601, 1200, "Sedang", hitDyDkg.getTotal()));
        tblDyDkg.add(new ItemTabelDyDkg(1201, 2400, "Menengah", prosesHitunganTblDyDkg("M")));
        tblDyDkg.add(new ItemTabelDyDkg(2401, 5000, "Berat", prosesHitunganTblDyDkg("B")));
        tblDyDkg.add(new ItemTabelDyDkg(5001, 9999999, " Sangat Berat", prosesHitunganTblDyDkg("SB")));
    }
    
    private Double prosesHitunganTblDyDkg(String kode) {
        ArrayList<ItemHitungan> a = hitDyDkg.getListItemHitungan();
        Double b = 0.0;
        for (int i=3;i<5;i++) {b=b+a.get(i).getHrgMaterial();}
        for (int i=8;i<27;i++) {b=b+a.get(i).getHrgMaterial();}
        for (int i=29;i<34;i++) {b=b+a.get(i).getHrgMaterial();}
        for (int i=38;i<45;i++) {b=b+a.get(i).getHrgMaterial();}
        
        switch (kode) {
            case "R":
                b=b+a.get(2).getHrgSatuan()+(a.get(6).getHrgSatuan()*0.125)+(a.get(7).getHrgSatuan()*0.15)
                        +(a.get(28).getHrgSatuan()*60)+(a.get(35).getHrgSatuan()*5)
                        +(a.get(36).getHrgSatuan()*0.514)+(a.get(37).getHrgSatuan()*0.28);
                break;
            case "M":
                b=b+a.get(2).getHrgSatuan()+(a.get(6).getHrgSatuan()*0.925)+(a.get(7).getHrgSatuan()*0.85)
                        +(a.get(28).getHrgSatuan()*150)+(a.get(35).getHrgSatuan()*10)
                        +(a.get(36).getHrgSatuan()*1.014)+(a.get(37).getHrgSatuan()*0.88);
                break;
            case "B":
                b=b+a.get(2).getHrgSatuan()+(a.get(6).getHrgSatuan()*1.825)+(a.get(7).getHrgSatuan()*1.45)
                        +(a.get(28).getHrgSatuan()*189)+(a.get(35).getHrgSatuan()*14)
                        +(a.get(36).getHrgSatuan()*1.714)+(a.get(37).getHrgSatuan()*1.58);
                break;
            case "SB":
                b=b+a.get(2).getHrgSatuan()+(a.get(6).getHrgSatuan()*3.725)+(a.get(7).getHrgSatuan()*3.25)
                        +(a.get(28).getHrgSatuan()*215)+(a.get(35).getHrgSatuan()*25)
                        +(a.get(36).getHrgSatuan()*2.814)+(a.get(37).getHrgSatuan()*2.68);
                break;
        }
        b=b*hitDyDkg.getSlabBeton().getQuantity();
        b=b*1.12;

        return b;
    }
    
    private void hitungDyDkg() {
        hitDyDkg = new HitunganDayaDukung(thnPenilaian);
        hitDyDkg.setListItemHitungan(isiListIHDyDkg());
        
        ItemHitungan a = new ItemHitungan("KU");
        a.setNamaItem("Slab beton (10 cm)");
        a.setSatuan("m3");
        a.setQuantity(0.1);
        ArrayList<ItemHitungan> b = hitDyDkg.getListItemHitungan();
        a.setHrgMaterial(b.get(2).getJmlHitungan()+b.get(6).getJmlHitungan()+b.get(7).getJmlHitungan()
            +b.get(13).getJmlHitungan()+b.get(14).getJmlHitungan()+b.get(15).getJmlHitungan()
            +b.get(21).getJmlHitungan()+b.get(22).getJmlHitungan()+b.get(28).getJmlHitungan()
            +b.get(29).getJmlHitungan()+b.get(35).getJmlHitungan()+b.get(36).getJmlHitungan()
            +b.get(37).getJmlHitungan()+b.get(38).getJmlHitungan()+b.get(39).getJmlHitungan()
            +b.get(40).getJmlHitungan());
        a.setHrgUpah(b.get(4).getJmlHitungan()+b.get(8).getJmlHitungan()+b.get(9).getJmlHitungan()
            +b.get(10).getJmlHitungan()+b.get(11).getJmlHitungan()+b.get(16).getJmlHitungan()
            +b.get(17).getJmlHitungan()+b.get(18).getJmlHitungan()+b.get(19).getJmlHitungan()
            +b.get(23).getJmlHitungan()+b.get(24).getJmlHitungan()+b.get(25).getJmlHitungan()
            +b.get(26).getJmlHitungan()+b.get(30).getJmlHitungan()+b.get(31).getJmlHitungan()
            +b.get(32).getJmlHitungan()+b.get(33).getJmlHitungan()+b.get(41).getJmlHitungan()
            +b.get(42).getJmlHitungan()+b.get(43).getJmlHitungan()+b.get(44).getJmlHitungan());
        hitDyDkg.setSlabBeton(a);
        
    }
    
    
    private void simpankeDb() {
        //hapus dulu semua 
        DBFetching.setComandToDB("delete from rslt_jpb38 where thn_penilaian='"+thnPenilaian+"'");
        
        //selanjutnya insert
        for (int i=0;i<tblJpb3.size();i++) {
            String strQuery = "insert into rslt_jpb38(thn_penilaian,jns_jpb,satuan,lbr_btg_min,"
                    +"lbr_btg_max,ting_kol_min,ting_kol_max,satuan_rph,nilai) values('"
                    +thnPenilaian+"','JPB3','m',"
                    +tblJpb3.get(i).getLbrBtgMin()+","+tblJpb3.get(i).getLbrBtgMax()+","
                    +tblJpb3.get(i).getTingKolMin()+","+tblJpb3.get(i).getTingKolMax()+",'Rp/m2',"
                    +tblJpb3.get(i).getNilai()+")";
            DBFetching.setComandToDB(strQuery);
        }
        for (int i=0;i<tblJpb8.size();i++) {
            String strQuery = "insert into rslt_jpb38(thn_penilaian,jns_jpb,satuan,lbr_btg_min,"
                    +"lbr_btg_max,ting_kol_min,ting_kol_max,satuan_rph,nilai) values('"
                    +thnPenilaian+"','JPB8','m',"
                    +tblJpb8.get(i).getLbrBtgMin()+","+tblJpb8.get(i).getLbrBtgMax()+","
                    +tblJpb8.get(i).getTingKolMin()+","+tblJpb8.get(i).getTingKolMax()+",'Rp/m2',"
                    +tblJpb8.get(i).getNilai()+")";
            DBFetching.setComandToDB(strQuery);
        }
        //hapus dulu semua 
        DBFetching.setComandToDB("delete from rslt_dy_dkg where thn_dy_dkg='"+thnPenilaian+"'");
    
        //selanjutnya insert
        for (int i=0;i<tblDyDkg.size();i++) {
            String strQuery = "insert into rslt_dy_dkg(thn_dy_dkg,dy_dkg_min,dy_dkg_max,type_kons,biaya) values('"
                    +thnPenilaian+"',"+tblDyDkg.get(i).getDayaDukungMin()+","+tblDyDkg.get(i).getDayaDukungMax()
                    +",'"+tblDyDkg.get(i).getTipeKons()+"',"+tblDyDkg.get(i).getBiaya()+")";
            DBFetching.setComandToDB(strQuery);
        }

        DBFetching.setComandToDB("delete from rslt_mezzanine where thn_penilaian='"+thnPenilaian+"'");
        DBFetching.setComandToDB("insert into rslt_mezzanine(thn_penilaian,kd_jpb,satuan,nilai) values('"+thnPenilaian
                +"','JPB 8','Rp/m2',"+hitMezz.getMezzanine()+")");
        
    }
    
    private void bentukTblJpb38() {
        tblJpb8 = new ArrayList<ItemTabelJpb38>();
        
        tblJpb8.add(new ItemTabelJpb38("m", 0, 9, 0, 4, "Rp/m2", lT.get(1).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 10, 13, 0, 4, "Rp/m2", lT.get(2).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 14, 17, 0, 4, "Rp/m2", lT.get(3).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 18, 21, 0, 4, "Rp/m2", lT.get(4).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 22, 25, 0, 4, "Rp/m2", lT.get(5).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 26, 29, 0, 4, "Rp/m2", lT.get(6).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 30, 33, 0, 4, "Rp/m2", lT.get(7).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 34, 37, 0, 4, "Rp/m2", lT.get(8).getCol1()));
        tblJpb8.add(new ItemTabelJpb38("m", 38, 999, 0, 4, "Rp/m2", lT.get(9).getCol1()));

        tblJpb8.add(new ItemTabelJpb38("m", 0, 9, 5, 7, "Rp/m2", lT.get(1).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 10, 13, 5, 7, "Rp/m2", lT.get(2).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 14, 17, 5, 7, "Rp/m2", lT.get(3).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 18, 21, 5, 7, "Rp/m2", lT.get(4).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 22, 25, 5, 7, "Rp/m2", lT.get(5).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 26, 29, 5, 7, "Rp/m2", lT.get(6).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 30, 33, 5, 7, "Rp/m2", lT.get(7).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 34, 37, 5, 7, "Rp/m2", lT.get(8).getCol2()));
        tblJpb8.add(new ItemTabelJpb38("m", 38, 999, 5, 7, "Rp/m2", lT.get(9).getCol2()));

        tblJpb8.add(new ItemTabelJpb38("m", 0, 9, 8, 10, "Rp/m2", lT.get(1).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 10, 13, 8, 10, "Rp/m2", lT.get(2).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 14, 17, 8, 10, "Rp/m2", lT.get(3).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 18, 21, 8, 10, "Rp/m2", lT.get(4).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 22, 25, 8, 10, "Rp/m2", lT.get(5).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 26, 29, 8, 10, "Rp/m2", lT.get(6).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 30, 33, 8, 10, "Rp/m2", lT.get(7).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 34, 37, 8, 10, "Rp/m2", lT.get(8).getCol3()));
        tblJpb8.add(new ItemTabelJpb38("m", 38, 999, 8, 10, "Rp/m2", lT.get(9).getCol3()));

        tblJpb8.add(new ItemTabelJpb38("m", 0, 9, 11, 99, "Rp/m2", lT.get(1).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 10, 13, 11, 99, "Rp/m2", lT.get(2).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 14, 17, 11, 99, "Rp/m2", lT.get(3).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 18, 21, 11, 99, "Rp/m2", lT.get(4).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 22, 25, 11, 99, "Rp/m2", lT.get(5).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 26, 29, 11, 99, "Rp/m2", lT.get(6).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 30, 33, 11, 99, "Rp/m2", lT.get(7).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 34, 37, 11, 99, "Rp/m2", lT.get(8).getCol4()));
        tblJpb8.add(new ItemTabelJpb38("m", 38, 999, 11, 99, "Rp/m2", lT.get(9).getCol4()));
        
        tblJpb3 = new ArrayList<ItemTabelJpb38>();
        
        for (int i=0;i<tblJpb8.size();i++) {
            tblJpb3.add(new ItemTabelJpb38(tblJpb8.get(i).getSatuan(), tblJpb8.get(i).getLbrBtgMin(),
                    tblJpb8.get(i).getLbrBtgMax(), tblJpb8.get(i).getTingKolMin(), tblJpb8.get(i).getTingKolMax(),
                    tblJpb8.get(i).getSatNilai(), tblJpb8.get(i).getNilai()*1.3));
        }
    }
    
    private void bentukTblTemp() {
        lT = new ArrayList<tmpTabel>();
        //isi tabel temporer
        lT.add(new tmpTabel(0.0, 4.0, 6.0, 9.0, 11.0));
        lT.add(new tmpTabel(15.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(16.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(17.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(19.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(22.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(27.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(31.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(35.0, 0.0, 0.0, 0.0, 0.0));
        lT.add(new tmpTabel(38.0, 0.0, 0.0, 0.0, 0.0));
        
        lT.get(5).setCol4(hit38.getJmlDbkb());
        lT.get(5).setCol3(rumusRec5(lT.get(0).getCol4()));
        lT.get(5).setCol2(rumusRec5(lT.get(0).getCol2()));
        lT.get(5).setCol1(rumusRec5(lT.get(0).getCol1()));
        
        for (int i=1;i<lT.size();i++) {
            if (i!=5) {lT.get(i).setCol4(rumusCol4(lT.get(i).getCol0())); }
        }
        
        for(int i=4;i>0;i--) {
            lT.get(i).setCol3((lT.get(i).getCol4()/lT.get(i+1).getCol4())*lT.get(i+1).getCol3());
            lT.get(i).setCol2((lT.get(i).getCol4()/lT.get(i+1).getCol4())*lT.get(i+1).getCol2());
            lT.get(i).setCol1((lT.get(i).getCol4()/lT.get(i+1).getCol4())*lT.get(i+1).getCol1());
        }
        
        for (int i=6;i<10;i++) {
            lT.get(i).setCol3((lT.get(i).getCol4()/lT.get(i-1).getCol4())*lT.get(i-1).getCol3());
            lT.get(i).setCol2((lT.get(i).getCol4()/lT.get(i-1).getCol4())*lT.get(i-1).getCol2());
            lT.get(i).setCol1((lT.get(i).getCol4()/lT.get(i-1).getCol4())*lT.get(i-1).getCol1());
        }

    }
    
    private Double rumusRec5(Double a) {
        return ((hit38.getTotC()+hit38.getTotE()+((a/lT.get(0).getCol3())*hit38.getTotD()))*1.012)/hit38.getLsLantai()*1.12;
    }
    
    private Double rumusCol4(Double a) {
        return ((((hit38.getTotA())+((a/lT.get(5).getCol0())*hit38.getTotB()))*1.012)*1.12)/(hit38.getPanjang()*(a/lT.get(5).getCol0())*hit38.getLebar());
    }
    
    private void hitungJpb38() {
        hit38 = new HitunganJpb38(thnPenilaian);
        //isi list
        hit38.setListPekerjaanTanah(isiList("TANAH"));
        hit38.setListPekerjaanPondasi(isiList("PONDASI"));
        hit38.setListStrukturKolom(isiList("KOLOM"));
        hit38.setStrukturBata(isiItemHitungan("HSAT", "D000001", 1050.5,"KU"));
        hit38.setStrukturRingbalk(isiItemHitungan("HSAT", "B000005", 1.91,"KU"));
        hit38.setListAtap(isiList("ATAP"));
        hit38.setStrukturSlabBeton(isiItemHitungan("HSAT", "B000007", 129.2,"KU"));
    
    }
    
    private ArrayList<ItemHitungan> isiList(String kode) {
        ArrayList<ItemHitungan> listIH = new ArrayList<>();
        switch (kode) {
            case "TANAH":
                listIH.add(isiItemHitungan("HSKU","B020000",100.037,"KU"));
                listIH.add(isiItemHitungan("HSAT","B000012",66.6913,"KU"));
                listIH.add(isiItemHitungan("HSKU","B040200",30.6,"KU"));
                listIH.add(isiItemHitungan("HSAT","B000011",30.0111,"KU"));
                break;
            case "PONDASI":
                listIH.add(isiItemHitungan("HSKU","B040300",76.5,"KU"));
                listIH.add(isiItemHitungan("HSAT","B000004",21.488,"KU"));
                listIH.add(isiItemHitungan("HSAT","B000005",25.38,"KU"));
                listIH.add(isiItemHitungan("HSKU","B040800",626.8,"KU"));
                break;
            case "KOLOM":
                listIH.add(isiItemHitungan("HSAT","B000008",7.14,"KU"));
                listIH.add(isiItemHitungan("MATERIAL","M05001",16085.886,"KU"));
                break;
            case "ATAP":
                listIH.add(isiItemHitungan("MATERIAL","M05001",12300.971,"KU"));
                listIH.add(isiItemHitungan("MATERIAL","M05002",611.0,"KU"));
                listIH.add(isiItemHitungan("MATERIAL","M05009",1861.2,"KU"));
                break;
        }
        
        return listIH;
    }
    
    //ini dipake utk Daya DUkung
    private ArrayList<ItemHitungan> isiListIHDyDkg() {
        ArrayList<ItemHitungan> listIH = new ArrayList<ItemHitungan>();
        try {
            ResultSet rs = DBFetching.getResultSet("select * from pros_hsku where substring(kd_hsku,1,3)='B07' and tahun='"+thnPenilaian+"'");
            while (rs.next()) {
                ItemHitungan iH = new ItemHitungan("DY");
                iH.setKdItem(rs.getString("kd_hsku"));
                iH.setNamaItem(rs.getString("nm_hsku"));
                iH.setSatuan(rs.getString("sat_hsku"));
                iH.setQuantity(Double.parseDouble(rs.getString("vol_hsku")));
                iH.setKdMaterial(rs.getString("kd_dhkm"));
                //disini terpaksa kacau, karena yg disimpan hanya hrgmaterial dan dsimpan di hrgsatuan
                iH.setHrgMaterial(Double.parseDouble(rs.getString("hrg_sat")));
                iH.setHrgSatuan(iH.getHrgMaterial()/iH.getQuantity());
                listIH.add(iH);
            }
        } catch (Exception e) {}
                
        return listIH;
    }
    
    private ItemHitungan isiItemHitungan(Double quantity, Double hrgMaterial, Double hrgUpah, String kdProses) {
        ItemHitungan iH = new ItemHitungan(kdProses);
        iH.setQuantity(quantity);
        iH.setHrgMaterial(hrgMaterial);
        iH.setHrgUpah(hrgUpah);
        return iH;
    }
    
    //ini dipake utk Komponen Utama
    private ItemHitungan isiItemHitungan(String nmTabel, String cari, Double qty, String kdProses) {
        ItemHitungan iH = new ItemHitungan(kdProses);
        try {
            ResultSet rs;
            switch (nmTabel) {
                case "HSKU":
                    rs = DBFetching.getResultSet("select * from pros_hsku where kd_hsku='"+cari+"' and tahun='"+thnPenilaian+"'");
                    while (rs.next()) {
                        iH.setKdItem(rs.getString("kd_hsku"));
                        iH.setNamaItem(rs.getString("nm_hsku"));
                        iH.setSatuan(rs.getString("sat_hsku"));
                        iH.setQuantity(qty);
                        iH.setKdMaterial(rs.getString("kd_dhkm"));
                        iH.setHrgSatuan(Double.parseDouble(rs.getString("hrg_sat")));
                        iH.setHrgMaterial(Double.parseDouble(rs.getString("hrg_komp")));
                        iH.setHrgUpah(Double.parseDouble(rs.getString("hrg_upah")));
                    }
                    break;
                case "HSAT":
                    rs = DBFetching.getResultSet("select * from pros_hsat where kd_hsat='"+cari+"' and tahun='"+thnPenilaian+"'");
                    while (rs.next()) {
                        iH.setKdItem(rs.getString("kd_hsat"));
                        iH.setNamaItem(rs.getString("nm_hsat"));
                        iH.setSatuan(rs.getString("sat_hsat"));
                        iH.setQuantity(qty);
                        iH.setKdMaterial(rs.getString("kd_strfin"));
                        iH.setHrgMaterial(Double.parseDouble(rs.getString("hrg_mat")));
                        iH.setHrgUpah(Double.parseDouble(rs.getString("hrg_upah")));
                    }
                    break;
                case "MATERIAL":
                    rs = DBFetching.getResultSet("select * from ref_dhkmf where kd_dhkm='"+cari+"' and thn_dhkm='"+thnPenilaian+"'");
                    while (rs.next()) {
                        iH.setKdItem(rs.getString("kd_dhkm"));
                        iH.setNamaItem(rs.getString("nm_dhkm"));
                        iH.setSatuan(rs.getString("sat_dhkm"));
                        iH.setQuantity(qty);
                        iH.setKdMaterial(rs.getString("kd_dhkm"));
                        iH.setHrgUpah(Double.parseDouble(rs.getString("hrg_dhkm")));
                        iH.setHrgMaterial(iH.getHrgUpah()*0.1);
                    }
                    break;
            }
        } catch (Exception e) {}
        return iH;
    }


    private class tmpTabel {
        private Double col0;
        private Double col1;
        private Double col2;
        private Double col3;
        private Double col4;
        
        public tmpTabel(Double col0, Double col1, Double col2, Double col3, Double col4) {
            this.col0 = col0;
            this.col1 = col1;
            this.col2 = col2;
            this.col3 = col3;
            this.col4 = col4;
        }
        /**
         * @return the col0
         */
        public Double getCol0() {
            return col0;
        }

        /**
         * @param col0 the col0 to set
         */
        public void setCol0(Double col0) {
            this.col0 = col0;
        }

        /**
         * @return the col1
         */
        public Double getCol1() {
            return col1;
        }

        /**
         * @param col1 the col1 to set
         */
        public void setCol1(Double col1) {
            this.col1 = col1;
        }

        /**
         * @return the col2
         */
        public Double getCol2() {
            return col2;
        }

        /**
         * @param col2 the col2 to set
         */
        public void setCol2(Double col2) {
            this.col2 = col2;
        }

        /**
         * @return the col3
         */
        public Double getCol3() {
            return col3;
        }

        /**
         * @param col3 the col3 to set
         */
        public void setCol3(Double col3) {
            this.col3 = col3;
        }

        /**
         * @return the col4
         */
        public Double getCol4() {
            return col4;
        }

        /**
         * @param col4 the col4 to set
         */
        public void setCol4(Double col4) {
            this.col4 = col4;
        }
        
        
    }
}
