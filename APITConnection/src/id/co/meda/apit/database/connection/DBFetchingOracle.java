/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class DBFetchingOracle {
    private Connection conn;
    
    public DBFetchingOracle(Connection conn) {
        this.conn=conn;
    }
    
    public ResultSet getResultSet(String sql)
    {
        ResultSet result = null;
        try{
            
            PreparedStatement prepare = conn.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result == null)
            {
                throw new Exception();
            }
        }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
            //        "Error C111", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
       return result;
        
    }
}
