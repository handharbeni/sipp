/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini berfungsi untuk memfasilitasi transaksi antara program java dengan database
 * koneksi database menggunakan class DBConnection
 * @author I Putu Medagia A
 */
public class DBFetching {
    
    //Menginisiasikan variable dengan referensi koneksi ke database
    private static final Connection connectDB = DBConnection.getConnect(); 
    
    public static void setAutoCommit(boolean commit)
    {
        try {
            connectDB.setAutoCommit(commit);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void RollBackDB()
    {
        try {
            connectDB.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void Simpan()
    {
        try {
            connectDB.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    /**
    * Method ini untuk berfungsi mendapatkan referensi dari Objek Table dari sebuah Database 
    * @param sql adalah parameter untuk query yang didefinisikan
    * @return ResultSet yang berupa referensi sebuah objek table dari skema database
    */
    
    public static ResultSet getResultSet(String sql)
    {
        ResultSet result = null;
        try{
            
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result == null)
            {
                throw new Exception();
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C111", JOptionPane.ERROR_MESSAGE);
        }
        
       return result;
        
    }
    
    /**
     * Mendapatkan data tipe String dalam satu kolom table database dalam bentuk ArrayList
     * @param sql adalah parameter untuk query yang didefinisikan
     * @param column adalah nomor colum pada table
     * @return data dalam bentuk ArrayList tipe String
     */
    public static ArrayList<String> getArrayListStringResult(String sql,int column)
    {
        ArrayList<String> resArray = new ArrayList<String>();
        
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql);
             
            ResultSet result = prepare.executeQuery();
            if(result == null)
            {
                throw new Exception();
            }
            while(result.next())
            {
                resArray.add(result.getString(column));
            } 
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C112", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
           
        return resArray;
    }
    
     /**
     * Mendapatkan data tipe String dalam satu kolom table database dalam bentuk ArrayList
     * @param sql adalah parameter untuk query yang didefinisikan
     * @param column adalah nomor colum pada table
     * @return data dalam bentuk ArrayList tipe Objek
     */
    public static ArrayList<String> getArrayListResult(String sql,int column)
    {
        ArrayList resArray = new ArrayList();
        
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql);
             
            ResultSet result = prepare.executeQuery();
            if(result == null)
            {
                throw new Exception();
            }
            while(result.next())
            {
            resArray.add(result.getString(column));
            } 
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C112", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
           
        return resArray;
    }
    
    
     /**
     * Mendapatkan data tipe Integer dalam satu kolom table database dalam bentuk ArrayList
     * @param sql adalah parameter untuk query yang didefinisikan
     * @param column adalah nomor colum pada table
     * @return data dalam bentuk ArrayList tipe Integer
     */
    public static ArrayList<Integer> getArrayListIntegerResult(String sql,int column)
    {
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            
            ArrayList<Integer> resArray = new ArrayList<Integer>();
            
            if(result == null){throw new Exception();}
            
            while(result.next())
            {
            resArray.add(Integer.parseInt(result.getString(column)));
          
            }
            return resArray;
            
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C113", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        return null;
    }
    
     /**
     * Mendapatkan data tipe Double dalam satu kolom table database dalam bentuk ArrayList
     * @param sql adalah parameter untuk query yang didefinisikan
     * @param column adalah nomor colum pada table
     * @return data dalam bentuk ArrayList tipe Double
     */
    public static ArrayList<Double> getArrayListDoubleResult(String sql,int column)
    {
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            
            if(result == null){throw new Exception();}
            
            ArrayList<Double> resArray = new ArrayList<Double>();
            
            while(result.next())
            {
            resArray.add(Double.parseDouble(result.getString(column)));
          
            }
            return resArray;
            
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C114", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
     public static Stack getStackResult(String sql,int column)
    {
        Stack resStack = new Stack();
        
        try{
            PreparedStatement prepare = connectDB.prepareStatement(sql);
             
            ResultSet result = prepare.executeQuery();
            if(result == null)
            {
                throw new Exception();
            }
            while(result.next())
            {
            resStack.push(result.getObject(column));
            } 
            
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C115", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
           
        return resStack;
    }
    
    
     /**
     * Mendapatkan data tipe double bentuk single data dari database
     * @param sql adalah parameter untuk query yang didefinisikan
     * @return single data tipe double
     */
    public static double getDoubleResult(String sql)
    {
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
             double resultValue = 0.0;
            
             if(result == null){throw new Exception();}
            
            while(result.next()){
                String temp = result.getString(1);
                
                if(temp == null || temp.equalsIgnoreCase(""))
                {
                    resultValue = 0.0;
                }else{
                resultValue = Double.parseDouble(result.getString(1));
                }   
            }
            
            return resultValue;
        
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C116", JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
           System.exit(1);
        }
        
        return 0.0;
    }
    
    /**
     * Mendapatkan data tipe Integer bentuk single data dari database
     * @param sql adalah parameter untuk query yang didefinisikan
     * @return single data tipe double
     */
    public static int getIntegerResult(String sql)
    {
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
             int resultValue = 0;
            
             if(result == null){throw new Exception();}
            
            while(result.next()){
                String temp = result.getString(1);
                
                if(temp == null || temp.equalsIgnoreCase(""))
                {
                    resultValue = 0;
                }else{
                resultValue = Integer.parseInt(result.getString(1));
                }   
            }
            
            return resultValue;
        
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C117", JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
        }
        
        return 0;
    }
    
    /**
     * Mendapatkan data tipe String bentuk single data dari database
     * @param sql adalah parameter untuk query yang didefinisikan
     * @param column untuk mendefinisikan data berada di kolom tertentu 
     * @return single data tipe String
     */
    public static String getStringResult(String sql,int column) {
        String resultValue = "";
        try {
           PreparedStatement prepare = connectDB.prepareStatement(sql);
           ResultSet result = prepare.executeQuery();
            
           if(result == null){throw new Exception();}
            
            while(result.next()){
                resultValue = result.getString(column);
            }
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(new JFrame(),"Data yang diminta tidak valid/kosong",
                    "Error C118", JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
        }
        return resultValue;
    }
    
    /**
     * method untuk mengirimkan perintah tertentu ke database(INSERT,DELETE,UPDATE,dll)
     * @param sql untuk mendefinisikan input query dari user 
     */
    public static void setComandToDB(String sql)
    {
        try {
            PreparedStatement prepare = connectDB.prepareStatement(sql);
            prepare.executeUpdate(sql);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(new JFrame(),"Perintah ke database tidak valid/tidak dikenal",
                    "Error C119", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                System.exit(1);
        }
 
    }
    
    /**
     *  menutup koneksi database
     */
    public static void setCloseCon()
    {
        try {
            connectDB.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(),"Gagal Menutup Koneksi",
                    "Error C1110", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //cek koneksi, kalo koneksi ada baru aplikasi jalan
    public static boolean cekKoneksi() {
        return (connectDB != null);
    }
    
    public static boolean cekMelaib() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dateSkrg = new Date();
        Date dateAwal = new Date();
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DATE, 10);
        cal1.set(Calendar.MONTH, 11);
        cal1.set(Calendar.YEAR, 3014);
        cal1.set(Calendar.HOUR_OF_DAY, 23);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        
        dateAwal = cal1.getTime();
        
        Date dateTewas = new Date();
//        dateTewas.setTime();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 15);
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.YEAR, 3016);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        
        dateTewas = cal.getTime();
        
        return true;//(dateAwal.getTime()<dateSkrg.getTime()) && (dateSkrg.getTime()<dateTewas.getTime());
    }
}
