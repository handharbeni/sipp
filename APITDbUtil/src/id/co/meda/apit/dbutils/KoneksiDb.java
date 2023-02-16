/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class KoneksiDb {
    public static final String DEFAULTPASSWORD = "P4suk4nBer4niM4ti";
    
    public static Connection getConnect() {
        return prosesKoneksi(DEFAULTPASSWORD);
    }

    public static Connection getConnect(String password) {
        return prosesKoneksi(password);
    }
    
    private static Connection prosesKoneksi(String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root", password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public static boolean cekKoneksi() {
        return (getConnect()!=null);
    }
    
    public static Vector<Vector> ambilVectorData() {
        Vector<Vector> data = new Vector<Vector>();
        Connection conn = getConnect();
        ResultSet result;
        
        try {
            PreparedStatement prep = conn.prepareStatement("select Host from user");
            result = prep.executeQuery();
            
            while (result.next()) {
                Vector vecData = new Vector();
                vecData.add(result.getString("Host"));
                data.add(vecData);
            }
            
            return data;
        } catch (Exception e) {e.printStackTrace();}
        
        return null;
    }
    
    public static boolean pendaftaranIpAddress(String ipAddress) {
        Connection conn = getConnect();
        try {
            PreparedStatement prep = conn.prepareStatement(
                " GRANT ALL ON *.* to root@'"+ipAddress+"' IDENTIFIED BY '"+KoneksiDb.DEFAULTPASSWORD+"'");
            prep.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return false;
    }
}
