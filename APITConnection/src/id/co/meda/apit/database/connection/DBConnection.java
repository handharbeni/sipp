/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk koneksi antara program APIT dengan lokal Database
 * @author I Putu Medagia A
 */
public class DBConnection {
    
    private static Connection con = null; 
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static String CONSTR = "jdbc:mysql://66.96.229.251:3306/db_sipp";
    private static String USER = "root";
    private static String PASSWORD = "x3200server";//P4suk4nBer4niM4ti";
    
    private static Konfigurasi konfigurasi;
   
        /**
     * untuk mendapatkan referensi koneksi sebuah local database
     * @return referensi koneksi ke database
     */
    public static Connection getConnect() 
    {        
        if (con == null)
        {
            try
            {

                ambilKonf();

                //Menginisiasi variable con dengan referensi koneksi ke database
                Class.forName(DBDRIVER).newInstance();

                if ((konfigurasi!=null)&&(!konfigurasi.getDbAppConnStr().equals("-"))) {
                    CONSTR = konfigurasi.getDbAppConnStr();
                    USER = konfigurasi.getDbAppUser();
                    PASSWORD = konfigurasi.getDbAppPwd();
                }

                con = DriverManager.getConnection(CONSTR,USER, PASSWORD);

            }catch(Exception e)
            {
              JOptionPane.showMessageDialog(new JFrame(),"Koneksi ke Database Error",
                      "Error C101",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
            }
        }
        
        return con;
    }
    
    /**
     * untuk mendapatkan referensi koneksi sebuah local database
     * @return referensi koneksi ke database
     */
    public static Connection getConnect(String connstr, String user, String pwd) 
    {
        DBConnection.CONSTR = connstr;
        DBConnection.USER = user;
        DBConnection.PASSWORD = pwd;
        
        if (con == null)
        {
            try
            {

                ambilKonf();

                //Menginisiasi variable con dengan referensi koneksi ke database
                Class.forName(DBDRIVER).newInstance();

                if ((konfigurasi!=null)&&(!konfigurasi.getDbAppConnStr().equals("-"))) {
                    CONSTR = konfigurasi.getDbAppConnStr();
                    USER = konfigurasi.getDbAppUser();
                    PASSWORD = konfigurasi.getDbAppPwd();
                }

                con = DriverManager.getConnection(CONSTR,USER, PASSWORD);

            }catch(Exception e)
            {
              JOptionPane.showMessageDialog(new JFrame(),"Koneksi ke Database Error",
                      "Error C101",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
            }
        }
        
        return con;
    }
    
    private static void ambilKonf() {
            if (ToolsKonfigurasi.cekFileKonf()) {
                konfigurasi = new Konfigurasi();
                konfigurasi = ToolsKonfigurasi.bacaKonf();
            } 

            
    }
    
}
