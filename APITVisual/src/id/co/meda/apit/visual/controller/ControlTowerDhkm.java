/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.tower.ItemCrnTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.ItemDhkmTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.RsltCrnTower;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlTowerDhkm {

    public void ambilDataCrn(String thn, ArrayList<RsltCrnTower> listCrn) {
        ResultSet rs = DBFetching.getResultSet("select * from rslt_crn_tower where thn_crn='"+thn+"'");
        
        try {
            while (rs.next()) {
                listCrn.add(new RsltCrnTower(rs.getString("thn_crn"),rs.getString("kd_crn"),rs.getString("tipe"),
                            Integer.parseInt(rs.getString("tinggi_min")),Integer.parseInt(rs.getString("tinggi_max")),
                            Integer.parseInt(rs.getString("jml_kaki")),rs.getString("konstruksi"),
                            rs.getString("pemasangan"),Double.parseDouble(rs.getString("nilai_crn"))));
            }
        } catch (Exception e) {}
    }
    
    public void ambilDataTabel(JTable tbl, ArrayList<ItemDhkmTower> listItem) {
        for (int i=0;i<tbl.getRowCount();i++) {
            listItem.get(i).setHarga((Double) tbl.getValueAt(i, 3));
        }
    }
    
    public Integer cekTabel(String thn) {
        return DBFetching.getIntegerResult("select count(*) jml from ref_dhkm_tower where thn_dhkm='"+thn+"'");
        
    }
    
    public String copyTabel(String thnAwal, String thnAkhir) {
        try {
            DBFetching.setComandToDB("delete from ref_dhkm_tower where thn_dhkm='"+thnAkhir+"'");
            DBFetching.setComandToDB("insert into ref_dhkm_tower " + 
                    "select kd_dhkm,'"+thnAkhir+"',nm_dhkm,sat_dhkm,harga from ref_dhkm_tower where thn_dhkm='"+thnAwal+"'");

            DBFetching.setComandToDB("delete from rslt_crn_tower where thn_crn='"+thnAkhir+"'");
            DBFetching.setComandToDB("insert into rslt_crn_tower " + 
                    "select '"+thnAkhir+"',kd_crn,tipe,tinggi_min,tinggi_max,jml_kaki,konstruksi,pemasangan,nilai_crn " +
                    "from rslt_crn_tower where thn_crn='"+thnAwal+"'");
            return "ok";
        } catch (Exception e) {
            return "gagal";
        }
    }
    
    public String SimpanDb(ArrayList<ItemDhkmTower> list) {
        try {
            DBFetching.setComandToDB("delete from ref_dhkm_tower where thn_dhkm='"+list.get(0).getThnDhkm()+"'");
            for (int i=0;i<list.size();i++) {
                DBFetching.setComandToDB("insert into ref_dhkm_tower values('"+list.get(i).getKdDhkm()
                +"','"+list.get(i).getThnDhkm()+"','"+list.get(i).getNmDhkm()+"','"+list.get(i).getSatDhkm()
                +"',"+list.get(i).getHarga()+")");
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    public void ambilIsiTabel(String thn, ArrayList<ItemDhkmTower> listItem) {
        ResultSet rs = DBFetching.getResultSet("select * from ref_dhkm_tower where thn_dhkm='"+thn+"'");
        
        try {
            while (rs.next()) {
                ItemDhkmTower item = new ItemDhkmTower();
                item.setThnDhkm(rs.getString("thn_dhkm"));
                item.setKdDhkm(rs.getString("kd_dhkm"));
                item.setNmDhkm(rs.getString("nm_dhkm"));
                item.setSatDhkm(rs.getString("sat_dhkm"));
                item.setHarga(Double.parseDouble(rs.getString("harga")));
                listItem.add(item);
            }
        } catch (Exception e) {}
    }
    
    public void isiCbThn(JComboBox cb) {
        cb.removeAllItems();
        cb.addItem("-- Pilih Tahun --");
        ResultSet rs = DBFetching.getResultSet("select distinct thn_dhkm from ref_dhkm_tower");
        try {
            while (rs.next()) {
                cb.addItem(rs.getString("thn_dhkm"));
            }
        } catch (Exception e) {}
    }
    
    private Vector<String> vectorHeader(Integer kode) {
        Vector<String> header = new Vector<>();
        switch (kode) {
            case 1:
                header.add(0,"Tahun");
                header.add(1,"Nama Material");
                header.add(2,"Satuan");
                header.add(3,"Harga");
                break;
            case 2:
                header.add(0,"Tahun");
                header.add(1,"Tipe");
                header.add(2,"Tinggi");
                header.add(3,"Jml Kaki");
                header.add(4,"Konstruksi");
                header.add(5,"Pemasangan");
                header.add(6,"Nilai");
                break;
        }
        return header;
    }

    public DefaultTableModel getTableModel(Integer kode) {
        Vector<Vector> data = new Vector<Vector>();
        return prosesTableModel(data, vectorHeader(kode));
    }

    public DefaultTableModel getTableModel(ArrayList<ItemDhkmTower> list) {
        Vector<Vector> data = new Vector<Vector>();
        for (int i=0;i<list.size();i++) {
            Vector vecData = new Vector();
            vecData.add(list.get(i).getThnDhkm());
            vecData.add(list.get(i).getNmDhkm());
            vecData.add(list.get(i).getSatDhkm());
            vecData.add(list.get(i).getHarga());
            data.add(vecData);
        }
        return prosesTableModel(data, vectorHeader(1));
    }

    public DefaultTableModel getTableModelCrn(ArrayList<RsltCrnTower> list) {
        Vector<Vector> data = new Vector<Vector>();
        for (int i=0;i<list.size();i++) {
            Vector vecData = new Vector();
            vecData.add(list.get(i).getThnCrn());
            vecData.add(list.get(i).getTipe());
            vecData.add(list.get(i).getTinggiMin()+" - "+list.get(i).getTinggiMax()+" m");
            vecData.add(list.get(i).getJmlKaki());
            vecData.add(list.get(i).getKonstruksi());
            vecData.add(list.get(i).getPemasangan());
            vecData.add(list.get(i).getNilaiCrn());
            data.add(vecData);
        }
        return prosesTableModel(data, vectorHeader(2));
    }

    private DefaultTableModel prosesTableModel(Vector<Vector> data, Vector<String> header) {
        DefaultTableModel modelTable = new DefaultTableModel(data,header) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        }; 
        return modelTable;
    }
    
    
}
