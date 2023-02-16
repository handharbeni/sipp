/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author meda
 */
public class statJpb4 implements statInterface{

    private String tahunDBKB;
 
    
    public statJpb4(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
    
    @Override
    public void isiCum() {
        try{
            String sql = "select exp from pros_fordat where id_fordat like '%jpb4%' "
                        + "and tahun = '"+tahunDBKB+"'";
            
            Stack stDbkbCum = DBFetching.getStackResult(sql,1);
            
            int stackSize = stDbkbCum.size();
            while(!stDbkbCum.isEmpty())
            {
                sql = "update pros_statistik set cum = "+(double)stDbkbCum.pop()+""
                        + " where jumlah_lantai = "+stackSize+" and id_stat = 'jpb4'"
                        + " and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
                stackSize--;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    
    }

    @Override
    public void isiAvg1() {
        
        try{
            //id 1-2
            String sql = "select cum from pros_statistik where jumlah_lantai = 2 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_statistik set avg1 = "+tempCum+" where jumlah_lantai <= 2 and jumlah_lantai >= 1 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

           //id 3-4
            sql = "select cum from pros_statistik where jumlah_lantai = 4 and id_stat= 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_statistik set avg1 = "+tempCum+" where jumlah_lantai <= 4 and jumlah_lantai >= 3 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        
            //id 5-6

            sql = "select cum from pros_statistik where jumlah_lantai <= 6 and jumlah_lantai >= 5 and id_stat= 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_statistik set avg1 = "+tempCum+" where jumlah_lantai <= 6 and jumlah_lantai >= 5 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }

    @Override
    public void isiAvg2() {
        try{ 
            //id 1-2
            String sql = "select avg1 from pros_statistik where jumlah_lantai = 2 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum1 = DBFetching.getDoubleResult(sql);
            
            sql = "select avg1 from pros_statistik where jumlah_lantai = 3 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum2 = DBFetching.getDoubleResult(sql);
            
            double tempHasilCum = (tempCum1+tempCum2)/2;
            
            sql = "update pros_statistik set avg2 = "+tempHasilCum+" where jumlah_lantai <= 2 and jumlah_lantai >= 1 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
           //id 3-4
            sql = "select avg1 from pros_statistik where jumlah_lantai = 4 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum1 = DBFetching.getDoubleResult(sql);
            
            sql = "select avg1 from pros_statistik where jumlah_lantai = 5 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum2 = DBFetching.getDoubleResult(sql);
            
            tempHasilCum = (tempCum1+tempCum2)/2;
            
            sql = "update pros_statistik set avg2 = "+tempHasilCum+" where jumlah_lantai <= 4 and jumlah_lantai >= 3 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //id 5-6

            sql = "select avg1 from pros_statistik where jumlah_lantai = 6 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum1 = DBFetching.getDoubleResult(sql);
            
            sql = "select cum from pros_statistik where jumlah_lantai = 6 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum2 = DBFetching.getDoubleResult(sql);
            
            tempHasilCum = (tempCum1+tempCum2)/2;
            
            sql = "update pros_statistik set avg2 = "+tempHasilCum+" where jumlah_lantai <= 6 and jumlah_lantai >= 5 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    
    }

    @Override
    public void isiSmooth() {
        try{
            //id 1-2
            String sql = "select avg2 from pros_statistik where jumlah_lantai = 2 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum1 = DBFetching.getDoubleResult(sql);
            
            sql = "select avg2 from pros_statistik where jumlah_lantai = 3 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum2 = DBFetching.getDoubleResult(sql);
            
            double tempHasilCum = (tempCum1+tempCum2)/2;
            
            sql = "update pros_statistik set smooth = "+tempHasilCum+" where jumlah_lantai <= 2 and jumlah_lantai >= 1 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //id 3-4
            sql = "select avg2 from pros_statistik where jumlah_lantai = 4 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum1 = DBFetching.getDoubleResult(sql);
            
            sql = "select avg2 from pros_statistik where jumlah_lantai = 5 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempCum2 = DBFetching.getDoubleResult(sql);
            
            tempHasilCum = (tempCum1+tempCum2)/2;
            
            sql = "update pros_statistik set smooth = "+tempHasilCum+" where jumlah_lantai <= 4 and jumlah_lantai >= 3 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //id 5-6

            sql = "select avg1 from pros_statistik where jumlah_lantai = 6 and id_stat = 'jpb4'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempCum = DBFetching.getDoubleResult(sql);
            
            
            sql = "update pros_statistik set smooth = "+tempCum+" where jumlah_lantai >= 5 and id_stat= 'jpb4'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
}
