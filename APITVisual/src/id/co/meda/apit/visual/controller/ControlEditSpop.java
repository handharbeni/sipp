/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlEditSpop {
    
    public DefaultTableModel getTableModel(boolean statPenilKhusus, String nmPenilaian) {
        Vector<String> header = new Vector<String>();
        header.add(0,"NOP");
        header.add(1,"Nama WP");
        header.add(2,"");
        
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(data,statPenilKhusus, nmPenilaian);
        
        DefaultTableModel modelTable = new DefaultTableModel(data,header) ;
        /*
        {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };*/

        return modelTable;
    }

    private void isiVectorData(Vector<Vector> data, boolean statPenilKhusus, String nmPenilaian) {
        String strQuery = "";
        if (statPenilKhusus) {
            strQuery="select * from spop where nop in (select nop from cek_op_khusus where jenis_op='"+nmPenilaian+"')";
        } else {
            strQuery="select * from spop where nop not in (select nop from cek_op_khusus)";
        }
        ResultSet rs = DBFetching.getResultSet(strQuery);
        try {
          while (rs.next()) {
              Vector vecData = new Vector();
              vecData.add(rs.getString("nop"));
              vecData.add(rs.getString("nama_wp"));
              data.add(vecData);
          }   
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
