/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class PenilaianTower {
    private final String nop;
    private final String thnPenilaian;
    private final ArrayList<Tower> listTower = new ArrayList<>();
    private final ArrayList<NilaiTower> listNilaiTower = new ArrayList<>();
    
    public PenilaianTower(String nop, String thnPenilaian) {
        this.nop=nop;
        this.thnPenilaian=thnPenilaian;
    }
    
    public void mulaiPenilaian() {
        ambilListTower();
        for (int i=0;i<listTower.size();i++) {
            NilaiTower nilTower = prosesPenilaian(listTower.get(i));
            listNilaiTower.add(nilTower);
        }
        
        simpanKeDb();
    }
    
    private void simpanKeDb() {
        DBFetching.setComandToDB("delete from rslt_penilaian_tower where thn_penilaian='" 
                +thnPenilaian+"' and nop='"+nop+"'" );
        for (int i=0;i<listNilaiTower.size();i++) {
            prosesSimpan(listNilaiTower.get(i));
        }
    }
    
    private void prosesSimpan(NilaiTower nil) {
        DBFetching.setComandToDB("insert into rslt_penilaian_tower values('" 
            +thnPenilaian+"','"+nop+"','"+nil.getBngKe()+"',"+nil.getNilaiTowerSblmSusut()
            +","+nil.getPersenPenyusutan()+","+nil.getNilaiSusut()+","+nil.getNilaiTower()+")");
    }
    
    private NilaiTower prosesPenilaian(Tower tower) {
        NilaiTower nilTower = new NilaiTower();
        nilTower.setThnPenilaian(thnPenilaian);
        nilTower.setNop(nop);
        nilTower.setBngKe(tower.getNoBng());
        nilTower.setThnBangun(tower.getThnBangun());
        nilTower.setThnRenov(tower.getThnRenov());
        nilTower.setTipe(tower.getTipe());
        nilTower.setTinggi(tower.getTinggi());
        
        Double nilSblSusut = DBFetching.getDoubleResult("select nilai_crn from rslt_crn_tower where "
                + "thn_crn='"+thnPenilaian+"' and tipe='"+tower.getTipe()
                +"' and "+tower.getTinggi()+" between tinggi_min and tinggi_max");
        nilTower.setNilaiTowerSblmSusut(nilSblSusut);
        
        Integer thnBgn = Integer.parseInt((tower.getThnBangun().equals(""))?"0":tower.getThnBangun());
        Integer thnRenov = Integer.parseInt((tower.getThnRenov().equals(""))?"0":tower.getThnRenov());
        
        if ((thnBgn==0) || (thnRenov<thnBgn && thnRenov!=0) ) {
            nilTower.setPersenPenyusutan(0.0);
        } else {
            String kdKondisiBng="";
            switch (tower.getKondisi()) {
                case "Sangat Baik" : kdKondisiBng="1";
                case "Baik" : kdKondisiBng="2";
                case "Sedang" : kdKondisiBng="3";
                case "Jelek" : kdKondisiBng="4";
            }
            nilTower.setPersenPenyusutan(
            ToolsPenilaian.hitungSusut(thnPenilaian, tower.getThnBangun(), tower.getThnRenov(), 
            kdKondisiBng, nilSblSusut, 1.0));
        }

        return nilTower;
    }
    
    private void ambilListTower() {
        try {
            ResultSet rs = DBFetching.getResultSet("select * from lspop_tower where nop='"+nop+"'");
            while (rs.next()) {
                Tower tower = new Tower();
                tower.setNop(rs.getString("nop"));
                tower.setNoBng(rs.getString("bngKe"));
                tower.setThnBangun(rs.getString("thnBgn"));
                tower.setThnRenov(rs.getString("thnRenov"));
                tower.setKondisi(rs.getString("kondisi"));
                tower.setTipe(rs.getString("tipe"));
                tower.setTinggi(Integer.parseInt(rs.getString("tinggi")));
                tower.setJmlKaki(Integer.parseInt(rs.getString("jmlKaki")));
                tower.setKonstruksi(rs.getString("konstruksi"));
                tower.setPemasangan(rs.getString("pemasangan"));
                
                listTower.add(tower);
            }
        } catch (Exception e) {}
    }
}
