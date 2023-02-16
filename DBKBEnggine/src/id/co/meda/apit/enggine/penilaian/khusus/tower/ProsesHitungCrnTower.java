/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ProsesHitungCrnTower {
    private final String thnPenilaian;
    private HitunganCrnTower hctSstLt10;
    private HitunganCrnTower hctSst11to20;
    private HitunganCrnTower hctSst21to30;
    private HitunganCrnTower hctSst31to40;
    private HitunganCrnTower hctSst41to50;
    private HitunganCrnTower hctSst51to60;
    private HitunganCrnTower hctSst61to70;
    private HitunganCrnTower hctSst71to80;
    private HitunganCrnTower hctSst81to90;
    //belum bener hitungannya
    private HitunganCrnTower hctSst91to100;
    private HitunganCrnTower hctGf101to110;
    private HitunganCrnTower hctGf111to120;
    private final HitunganAhsTower hat;
    
    public ProsesHitungCrnTower(String thn, HitunganAhsTower hat) {
        this.thnPenilaian=thn;
        this.hat=hat;
    }
    
    public void simpanCrn() {
        DBFetching.setComandToDB("delete from rslt_crn_tower where thn_crn='"+thnPenilaian+"'");
        prosesSimpan(hctSstLt10, "SST1", "SST");
        prosesSimpan(hctSst11to20,"SST2","SST");
        prosesSimpan(hctSst21to30,"SST3","SST");
        prosesSimpan(hctSst31to40,"SST4","SST");
        prosesSimpan(hctSst41to50,"SST5","SST");
        prosesSimpan(hctSst51to60,"SST6","SST");
        prosesSimpan(hctSst61to70,"SST7","SST");
        prosesSimpan(hctSst71to80,"SST8","SST");
        prosesSimpan(hctSst81to90,"SST9","SST");
        prosesSimpan(hctSst91to100,"SST10","SST");
        prosesSimpan(hctGf101to110,"GF1","Greenfield");
        prosesSimpan(hctGf111to120,"GF2","Greenfield");
    }

    private void prosesSimpan(HitunganCrnTower ht, String kd, String nm) {
        DBFetching.setComandToDB("insert into rslt_crn_tower values('"+thnPenilaian+"','"+kd+"','"
                +nm+"',"+ht.getTinggiMin()+","+ht.getTinggiMax()+","+ht.getJmlKaki()
                +",'"+ht.getKonstruksi()+"','"+ht.getPemasangan()
                +"',"+ht.getCrn().toString()+")");
    }
            
    public void hitungCrn() {
        hctSstLt10 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSstLt10(), "hctSstLt10", "SST", 0, 10, 4, "baja", "di atas tanah");
        hctSst11to20 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst11to20(), "hctSst11to20", "SST", 11, 20, 4, "baja", "di atas tanah");
        hctSst21to30 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst21to30(), "hctSst21to30", "SST", 21, 30, 4, "baja", "di atas tanah");
        hctSst31to40 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst31to40(), "hctSst31to40", "SST", 31, 40, 4, "baja", "di atas tanah");
        hctSst41to50 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst41to50(), "hctSst41to50", "SST", 41, 50, 4, "baja", "di atas tanah");
        hctSst51to60 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst51to60(), "hctSst51to60", "SST", 51, 60, 4, "baja", "di atas tanah");
        hctSst61to70 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst61to70(), "hctSst61to70", "SST", 61, 70, 4, "baja", "di atas tanah");
        hctSst71to80 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst71to80(), "hctSst71to80", "SST", 71, 80, 4, "baja", "di atas tanah");
        hctSst81to90 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst81to90(), "hctSst81to90", "SST", 81, 90, 4, "baja", "di atas tanah");
        hctSst91to100 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctSst91to100(), "hctSst91to100", "SST", 91, 100, 4, "baja", "di atas tanah");
        hctGf101to110 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctGf101to110(), "hctGf101to110", "GF", 101, 110, 4, "baja", "di atas tanah");
        hctGf111to120 = new HitunganCrnTower(thnPenilaian);
        hitCrnAll(getHctGf111to120(), "hctGf111to120", "GF", 111, 120, 4, "baja", "di atas tanah");
    }
    
    private void hitCrnAll(HitunganCrnTower hct, String nmCrn, String tipe, 
                Integer tingMin, Integer tingMax, Integer jmlKaki,String kons, String pasang) {
        hct.setTipe(tipe);
        hct.setTinggiMin(tingMin);
        hct.setTinggiMax(tingMax);
        hct.setJmlKaki(jmlKaki);
        hct.setKonstruksi(kons);
        hct.setPemasangan(pasang);
        
        switch (nmCrn) {
            case "hctSstLt10" :
                prosesAnalisis(hctSstLt10, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 84.24, 3.37, 0.37, 2.02, 0.46, 1589.81, 25.41);
                break;
            case "hctSst11to20" :
                prosesAnalisis(hctSst11to20, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 84.24, 3.37, 0.37, 2.02, 0.46, 2793.12, 45.74);
                break;
            case "hctSst21to30" :
                prosesAnalisis(hctSst21to30, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 140.4, 5.62, 0.62, 3.37, 0.77, 4446.76, 184.53);
                break;
            case "hctSst31to40" :
                prosesAnalisis(hctSst31to40, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 226.2, 9.05, 1.0, 5.43, 1.24, 5566.63, 224.21);
                break;
            case "hctSst41to50" :
                prosesAnalisis(hctSst41to50, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 269.1, 10.77, 1.19, 6.46, 1.48, 8280.92, 388.65);
                break;
            case "hctSst51to60" :
                prosesAnalisis(hctSst51to60, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 312.0, 12.48, 1.37, 7.49, 1.72, 10995.2, 553.08);
                break;
            case "hctSst61to70" :
                prosesAnalisis(hctSst61to70, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 356.0, 14.24, 1.57, 8.55, 1.95, 13789.35, 629.97);
                break;
            case "hctSst71to80" :
                prosesAnalisis(hctSst71to80, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 400.0, 16.0, 1.76, 9.6, 2.19, 16583.5, 706.86);
                break;
            case "hctSst81to90" :
                prosesAnalisis(hctSst81to90, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 400.0, 16.0, 1.76, 9.6, 2.19, 22129.82, 765.63);
                break;
                //masih belum bener hitungannya
            case "hctSst91to100" :
                prosesAnalisis(hctSst91to100, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 400.0, 16.0, 1.76, 9.6, 2.19, 22129.82, 765.63);
                break;
            case "hctGf101to110" :
                prosesAnalisis(hctGf101to110, hat, 133.4, 38.2, 30.85, 16.0, 43.11, 420.0, 16.0, 1.85, 10.8, 2.3, 97134.0, 3885.0);
                break;
            case "hctGf111to120" :
                prosesAnalisis(hctGf111to120, hat, 144.0, 40.0, 50.0, 15.0, 35.0, 440.0, 16.0, 1.94, 10.56, 2.41, 118102.0, 4724.0);
                break;
        }
    }

    private void prosesAnalisis(HitunganCrnTower hct, HitunganAhsTower hat, Double vSiBrsh, Double vSiBplnk,
            Double vTGali, Double vTBuang, Double vTUrug, Double vDsPcng, Double vDsPtg, Double vBtKlm, 
            Double vBtFoot, Double vBtTie, Double vStTwr, Double vStCat) {
        
        ArrayList<ItemCrnTower> list = new ArrayList<>();
        list.add(isiItem("Persiapan - Pembersihan", "m2", vSiBrsh, hat.getTotListPembersihan()));
        list.add(isiItem("Persiapan - Pemasangan bouplank", "m", vSiBplnk, hat.getTotListPsgBowplank()));
        list.add(isiItem("Pek Tanah - Penggalian", "m3", vTGali, hat.getTotListGaliTanah()));
        list.add(isiItem("Pek Tanah - Pembuangan", "m3", vTBuang, hat.getTotListBuangTanah()));
        list.add(isiItem("Pek Tanah - Urugan", "m3", vTUrug, hat.getTotListUrugTnhKembali()));
        list.add(isiItem("Pondasi - Pemancangan", "m", vDsPcng, hat.getTotListTiangPancang()));
        list.add(isiItem("Pondasi - Pemotongan Tiang", "m", vDsPtg, hat.getTotListPtgTiangPancang()));
        list.add(isiItem("Beton - Kolom", "m3", vBtKlm, hat.getTotListKolomBekisting()+hat.getTotListKolomPembesian()+hat.getTotListKolomPengecoran()));
        list.add(isiItem("Beton - Foot Plat", "m3", vBtFoot, 
                hat.getTotListBalokGali()+hat.getTotListBalokLantaiKerja()+hat.getTotListBalokPembesian()
                +hat.getTotListBalokPengecoran()+hat.getTotListBalokUrugPasir()));
        list.add(isiItem("Beton - Tie Beam", "m3", vBtTie, 
                hat.getTotListBalokGali()+hat.getTotListBalokLantaiKerja()+hat.getTotListBalokPembesian()
                +hat.getTotListBalokPengecoran()+hat.getTotListBalokUrugPasir()));        
        list.add(isiItem("Super Str - Tower", "kg", vStTwr, hat.getTotListPasangTower()));
        list.add(isiItem("Super Str - Pengecatan", "m2", vStCat, hat.getTotListCatMeni()));

        hct.setListAnalisis(list);
    }
    
    private ItemCrnTower isiItem(String jnsPek, String satuan, Double vol, Double hrg) {
        ItemCrnTower item = new ItemCrnTower();
        item.setJnsPekerjaan(jnsPek);
        item.setSatuan(satuan);
        item.setVolume(vol);
        item.setHrgSatuan(hrg);
        return item;
    }
    
    /**
     * @return the thnPenilaian
     */
    public String getThnPenilaian() {
        return thnPenilaian;
    }

    /**
     * @return the hct
     */
    public HitunganCrnTower getHctSstLt10() {
        return hctSstLt10;
    }

    /**
     * @return the hat
     */
    public HitunganAhsTower getHat() {
        return hat;
    }

    /**
     * @return the hctSst11to20
     */
    public HitunganCrnTower getHctSst11to20() {
        return hctSst11to20;
    }

    /**
     * @return the hctSst21to30
     */
    public HitunganCrnTower getHctSst21to30() {
        return hctSst21to30;
    }

    /**
     * @return the hctSst31to40
     */
    public HitunganCrnTower getHctSst31to40() {
        return hctSst31to40;
    }

    /**
     * @return the hctSst41to50
     */
    public HitunganCrnTower getHctSst41to50() {
        return hctSst41to50;
    }

    /**
     * @return the hctSst51to60
     */
    public HitunganCrnTower getHctSst51to60() {
        return hctSst51to60;
    }

    /**
     * @return the hctSst61to70
     */
    public HitunganCrnTower getHctSst61to70() {
        return hctSst61to70;
    }

    /**
     * @return the hctSst71to80
     */
    public HitunganCrnTower getHctSst71to80() {
        return hctSst71to80;
    }

    /**
     * @return the hctSst81to90
     */
    public HitunganCrnTower getHctSst81to90() {
        return hctSst81to90;
    }

    /**
     * @return the hctSst91to100
     */
    public HitunganCrnTower getHctSst91to100() {
        return hctSst91to100;
    }

    /**
     * @return the hctGf101to110
     */
    public HitunganCrnTower getHctGf101to110() {
        return hctGf101to110;
    }

    /**
     * @return the hctGf111to120
     */
    public HitunganCrnTower getHctGf111to120() {
        return hctGf111to120;
    }
            
}
