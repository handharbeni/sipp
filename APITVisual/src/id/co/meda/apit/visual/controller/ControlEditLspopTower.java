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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlEditLspopTower {
    public void cariNop(String nop, Spop spop) {
        ResultSet rs = DBFetching.getResultSet("select * from spop where nop='"
                +nop+"' and nop in (select nop from cek_op_khusus where jenis_op = 'Tower')");
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

    public DefaultTableModel getTableModel(Integer kode) {
        Vector<Vector> data = new Vector<Vector>();
        return prosesTableModel(data, vectorHeader(kode));
    }

    public DefaultTableModel getTableModel(String nop, Integer kode) {
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(nop, data, kode);
        return prosesTableModel(data, vectorHeader(kode));
    }
    
    private Vector<String> vectorHeader(Integer kode) {
        Vector<String> header = new Vector<String>();
        if (kode==1) {
            header.add(0,"Bng Ke");
            header.add(1,"Tipe");
            header.add(2,"Tinggi");
            header.add(3,"");
        } else if (kode==2) {
            
        }
        return header;
    }
    
    private void isiVectorData(String nop, Vector<Vector> data, Integer kode) {
        String sql="";
        if (kode==1) {
            sql="select bngKe,tipe,tinggi from lspop_tower where nop='"+nop+"'";
        }
        ResultSet rs = DBFetching.getResultSet(sql);
        try {
            while (rs.next()) {
                Vector vecData = new Vector();
                vecData.add(rs.getString("bngKe"));
                vecData.add(rs.getString("tipe"));
                vecData.add(rs.getString("tinggi") + " m");
                data.add(vecData);
            }
        } catch (Exception e) {}
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
