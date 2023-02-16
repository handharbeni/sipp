/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class testConn {
    
        public static void main(String args[]) {
//            Connection connection = DBConnection.getConnect();
//            if (connection != null) {
//                System.out.println("Berhasil");
//            } else {
//                System.out.println("Gagal");
//            }
            
//            Connection connection = DBConnection.getConnect("jdbc:mysql://66.96.229.251:3306/sql_e_parkir_bat", "root", "x3200server");
//            if (connection != null) {
//                System.out.println("Berhasil");
//            } else {
//                System.out.println("Gagal");
//            }

//            DBConnectionOracle dbConn = new DBConnectionOracle("192.168.56.101","1521","DBMADE","PBB","PBB");
//            Connection conn1  = dbConn.getConnect();
//            if (conn1==null) {
//                System.out.println("error");
//            } else {
//                System.out.println("berhasil");
//            }
            
            if (ToolsKonfigurasi.cekFileKonf()) {
                System.out.println("udah ada");
            } else {
                ToolsKonfigurasi.buatFileKonf();
            }
            
            Konfigurasi konf = ToolsKonfigurasi.bacaKonf();
            System.out.println(konf.getDbAppConnStr());
            System.out.println(konf.getDbAppConnStr());
            
    }

    
}
