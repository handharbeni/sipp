/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlEditSpopBumiIkan {
    
    public DefaultTableModel getModelTable()
    {
        Vector<String> header = new Vector<String>();
        header.add(0,"NOP");
        header.add(1,"Nama Perusahaan");
        header.add(2,"");
        
        Vector<Vector> data = new Vector<Vector>();
        
        try{
            ResultSet setNop = DBFetching.getResultSet("SELECT * FROM spop");
            while(setNop.next())
            {
                Vector vecData = new Vector();
                vecData.add(setNop.getString(1));
                vecData.add(setNop.getString(8));
                data.add(vecData);
            }
            
        
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         DefaultTableModel tableModel = new DefaultTableModel(data,header){
             
            @Override
                public boolean isCellEditable(int row,int column)
                {
                    if(column == 2)
                    {
                        return true;
                    }
                    return false;
                }
            };
       
         
        return tableModel;
    
    }
   /* 
    public void deleteData(String nop)
    {
        boolean cek = ProsesDataBumiPerikanan.deleteData(nop);
        
        if(cek){
            JOptionPane.showMessageDialog(new JFrame(), "Data berhasil dihapus", "Proses Penghapusan", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghapus data", "Proses Penghapusan", JOptionPane.ERROR_MESSAGE);
        }
    }
    */
   
    
}
