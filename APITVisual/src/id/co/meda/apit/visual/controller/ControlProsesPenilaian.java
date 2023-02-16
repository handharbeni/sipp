/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlProsesPenilaian {

    public void isiCombo(JComboBox cbAll) {
        ResultSet rs = DBFetching.getResultSet("select distinct thn_dhkm from ref_dhkmf order by thn_dhkm desc");
        try {
            while (rs.next()) {
                cbAll.addItem(rs.getString(1));
            }
        } catch (Exception e) {}
    }
    
    public boolean cekBngDiLspop(String nop) {
        Integer jmlBng = DBFetching.getIntegerResult(
          "select count(*) jml from lspop_non_standar where nop='"+nop+"'");
        return (jmlBng>0)?true:false;
    }

    public boolean cekHslPenilaian(String nop, String thn) {
        Integer jml = DBFetching.getIntegerResult(
          "select count(*) jml from rslt_penilaian where thn_penilaian='"+thn+"' and nop='"+nop+"'");
        return (jml>0);
    }
    
    public void cariNop(String nop, Spop spop) {
        ResultSet rs = DBFetching.getResultSet("select * from spop where nop='"
                +nop+"' and nop not in (select nop from cek_op_khusus)");
        try {
            while (rs.next()) {
                spop.setNop(rs.getString("nop"));
                spop.setNamaWp(rs.getString("nama_wp"));
                spop.setJumlahBangunan(rs.getInt("jml_bng"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        header.add(1,"Jenis Penggunaan Bangunan");
        header.add(2,"Luas (m2)");
        return header;
    }

    
    private void isiVectorData(String nop, Vector<Vector> data) {
        ResultSet rs = DBFetching.getResultSet("select bngke,concat(concat(a.jpb,' - '),nama) as kd_jpb, lsbngutama from lspop_non_standar a, ref_jpb b\n" +
                            "where a.jpb=b.no_jpb and a.nop='"+nop+"'");
        try {
          while (rs.next()) {
              Vector vecData = new Vector();
              vecData.add(rs.getString("bngke"));
              vecData.add(rs.getString("kd_jpb"));
              vecData.add(rs.getString("lsbngutama"));
              data.add(vecData);
          }   
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        
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
