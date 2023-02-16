/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ProsesHitungAhsTower {
    private final String thnPenilaian;
    private HitunganAhsTower hat;
    
    public ProsesHitungAhsTower(String thnPenilaian) {
        this.thnPenilaian=thnPenilaian;
    }
    
    
    public void hitungAhs() {
        hat = new HitunganAhsTower(getThnPenilaian());
        
        ArrayList<ItemAhsTower> listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.0027));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.054));
        getHat().setListPembersihan(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00016", getThnPenilaian(), 0.008));
        listA.add(isiItem("M00015", getThnPenilaian(), 0.025));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.0011));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.0064));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.064));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.02));
        getHat().setListPsgBowplank(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00008", getThnPenilaian(), 0.3));
        listA.add(isiItem("M00008", getThnPenilaian(), 0.33));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.3));
        listA.add(isiItem("M00003", getThnPenilaian(), 3.0));
        getHat().setListTiangPancang(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.08));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.016));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.16));
        listA.add(isiItem("M00003", getThnPenilaian(), 1.44));
        getHat().setListGaliTanah(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.125));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.2));
        getHat().setListPtgTiangPancang(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.083));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.25));
        getHat().setListBuangTanah(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.165));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.495));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.1));
        listA.get(2).setHrgKomp(listA.get(0).getHrgKomp()+listA.get(1).getHrgKomp());
        getHat().setListUrugTnhKembali(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.08));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.016));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.16));
        listA.add(isiItem("M00003", getThnPenilaian(), 1.44));
        getHat().setListPlatGali(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00006", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.01));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.72));
        getHat().setListPlatUrugPasir(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00010", getThnPenilaian(), 0.625));
        listA.add(isiItem("M00006", getThnPenilaian(), 0.05));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.02));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.02));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.2));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.4));
        getHat().setListPlatLantaiKerja(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00013", getThnPenilaian(), 110.0));
        listA.add(isiItem("M00014", getThnPenilaian(), 2.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.015));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.225));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.675));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.675));
        getHat().setListPlatPembesian(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00010", getThnPenilaian(), 8.0));
        listA.add(isiItem("M00007", getThnPenilaian(), 0.814));
        listA.add(isiItem("M00006", getThnPenilaian(), 0.48));
        listA.add(isiItem("M00009", getThnPenilaian(), 4.52));
        listA.add(isiItem("M00011", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.3));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.2));
        listA.add(isiItem("M00004", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00003", getThnPenilaian(), 2.0));
        getHat().setListPlatCorK75(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.08));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.016));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.16));
        listA.add(isiItem("M00003", getThnPenilaian(), 1.44));
        getHat().setListBalokGali(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00006", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.01));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.72));
        getHat().setListBalokUrugPasir(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00010", getThnPenilaian(), 0.625));
        listA.add(isiItem("M00006", getThnPenilaian(), 0.05));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.02));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.02));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.2));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.4));
        getHat().setListBalokLantaiKerja(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00013", getThnPenilaian(), 110.0));
        listA.add(isiItem("M00014", getThnPenilaian(), 2.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.015));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.225));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.675));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.675));
        getHat().setListBalokPembesian(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00010", getThnPenilaian(), 8.0));
        listA.add(isiItem("M00007", getThnPenilaian(), 0.814));
        listA.add(isiItem("M00006", getThnPenilaian(), 0.48));
        listA.add(isiItem("M00009", getThnPenilaian(), 4.52));
        listA.add(isiItem("M00011", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.3));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.2));
        listA.add(isiItem("M00004", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00003", getThnPenilaian(), 2.0));
        getHat().setListBalokPengecoran(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00017", getThnPenilaian(), 0.33));
        listA.add(isiItem("M00016", getThnPenilaian(), 0.4));
        listA.add(isiItem("M00015", getThnPenilaian(), 4.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.1));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.5));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.6));
        listA.add(isiItem("M00003", getThnPenilaian(), 4.0));
        getHat().setListKolomBekisting(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00013", getThnPenilaian(), 110.0));
        listA.add(isiItem("M00014", getThnPenilaian(), 2.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.015));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.225));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.675));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.675));
        getHat().setListKolomPembesian(listA);
        
        listA = new ArrayList<>();
        listA.add(isiItem("M00010", getThnPenilaian(), 8.0));
        listA.add(isiItem("M00007", getThnPenilaian(), 0.814));
        listA.add(isiItem("M00006", getThnPenilaian(), 0.48));
        listA.add(isiItem("M00009", getThnPenilaian(), 4.52));
        listA.add(isiItem("M00011", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00002", getThnPenilaian(), 0.3));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.2));
        listA.add(isiItem("M00004", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00003", getThnPenilaian(), 2.0));
        getHat().setListKolomPengecoran(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00019", getThnPenilaian(), 0.12));
        listA.add(isiItem("M00018", getThnPenilaian(), 0.3504));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.0756));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.0756));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.336));
        getHat().setListCatMeni(listA);

        listA = new ArrayList<>();
        listA.add(isiItem("M00002", getThnPenilaian(), 0.0015));
        listA.add(isiItem("M00001", getThnPenilaian(), 0.0225));
        listA.add(isiItem("M00004", getThnPenilaian(), 0.12));
        listA.add(isiItem("M00003", getThnPenilaian(), 0.1));
        listA.add(isiItem("M00012", getThnPenilaian(), 1.0));
        listA.add(isiItem("M00012", getThnPenilaian(), 0.1));
        getHat().setListPasangTower(listA);
    }
    
    private ItemAhsTower isiItem(String kdDhkm, String thn, Double vol) {
        ItemAhsTower item = new ItemAhsTower();
        
        ResultSet rs = DBFetching.getResultSet("select * from ref_dhkm_tower where kd_dhkm='"
                +kdDhkm+"' and thn_dhkm='"+thn+"'");
        
        try {
            while (rs.next()) {
                item.setJnsPekerjaan(rs.getString("nm_dhkm"));
                item.setSatuan(rs.getString("sat_dhkm"));
                item.setHrgKomp(Double.parseDouble(rs.getString("harga")));
                item.setVolume(vol);
          }
        } catch (Exception e) {}
        
        return item;
    }

    /**
     * @return the thnPenilaian
     */
    public String getThnPenilaian() {
        return thnPenilaian;
    }

    /**
     * @return the hat
     */
    public HitunganAhsTower getHat() {
        return hat;
    }
}
