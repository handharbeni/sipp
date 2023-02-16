/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.khusus.tower.NilaiTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.Tower;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlPenilaianTower {
    public void isiCbTahun(JComboBox cbThn) {
        ResultSet rs = DBFetching.getResultSet("SELECT distinct thn_crn FROM rslt_crn_tower order by thn_crn desc");
        try {
            while (rs.next()) {
                cbThn.addItem(rs.getString(1));
            }
        } catch (Exception e) {}
    }

    public void cariNop(String nop, Spop spop) {
        ToolsPenilaian.ambilSpopFromDb(nop, spop);
    }

    public boolean cekHslPenilaian(String nop, String thn) {
        Integer jml = DBFetching.getIntegerResult(
          "select count(*) jml from rslt_penilaian_tower where thn_penilaian='"+thn+"' and nop='"+nop+"'");
        return (jml>0);
    }
    
    public boolean cekBngDiLspop(String nop) {
        Integer jmlBng = DBFetching.getIntegerResult(
          "select count(*) jml from lspop_tower where nop='"+nop+"'");
        return (jmlBng>0);
    }

    public DefaultTableModel getTableModel() {
        Vector<Vector> data = new Vector<Vector>();
        return prosesTableModel(data, vectorHeader());
    }
    
    public DefaultTableModel getTableModel(String nop) {
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(nop, data);
        return prosesTableModel(data, vectorHeader());
    }

    private Vector<String> vectorHeader() {
        Vector<String> header = new Vector<String>();
        header.add(0,"Bng Ke");
        header.add(1,"Tipe");
        header.add(2,"Tinggi (m)");
        return header;
    }

    private void isiVectorData(String nop, Vector<Vector> data) {
        //ResultSet rs = DBFetching.getResultSet("select bngKe, tipe, tinggi from lspop_tower where nop='"+nop+"'");
        ResultSet rs = ambilTower(nop);
        try {
          while (rs.next()) {
              Vector vecData = new Vector();
              vecData.add(rs.getString("bngKe"));
              vecData.add(rs.getString("tipe"));
              vecData.add(rs.getString("tinggi"));
              data.add(vecData);
          }   
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public ArrayList<Tower> isiListTower(String nop) {
        ArrayList<Tower> listTower = new ArrayList<>();
        ResultSet rs = ambilTower(nop);
        try {
            while (rs.next()) {
                Tower tower = new Tower();
                tower.setNop(nop);
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
        return listTower;
    }
    
    public ArrayList<NilaiTower> isiListNilaiTower(String nop, String thnPenilaian) {
        ArrayList<NilaiTower> listNilaiTower = new ArrayList<>();
        ResultSet rs = DBFetching.getResultSet("select * from rslt_penilaian_tower where thn_penilaian='"
            +thnPenilaian+"' and nop='"+nop+"'");
        try {
            while (rs.next()) {
                NilaiTower nilTower = new NilaiTower();
                nilTower.setThnPenilaian(thnPenilaian);
                nilTower.setNop(nop);
                nilTower.setBngKe(rs.getString("bng_ke"));
                nilTower.setNilaiTowerSblmSusut(Double.parseDouble(rs.getString("nilai_tower_sblm_susut")));
                nilTower.setPersenPenyusutan(Double.parseDouble(rs.getString("persen_penyusutan")));
                
                listNilaiTower.add(nilTower);
            }
        } catch (Exception e) {}
        return listNilaiTower;
    }
    
    private ResultSet ambilTower(String nop) {
        return DBFetching.getResultSet("select * from lspop_tower where nop='"+nop+"'");
    }
    
    private DefaultTableModel prosesTableModel(Vector<Vector> data, Vector<String> header) {
        DefaultTableModel modelTable = new DefaultTableModel(data,header) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        }; 
       // DefaultTableModel modelTable = new DefaultTableModel(data,header);
        return modelTable;
    }
    
}
