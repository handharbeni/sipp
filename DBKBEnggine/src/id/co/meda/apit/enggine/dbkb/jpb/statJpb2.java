/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JProgressBar;

/**
 * Class ini untuk memperoleh data statistik
 * @author I Putu Medagia A
 */
public class statJpb2 implements statInterface {

    private String tahunDBKB;
    private JProgressBar progressBar;
    
    public statJpb2(String tahunDBKB,JProgressBar progressBar)
    {
        this.progressBar = progressBar;
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
            
    /**
     * Method untuk mengisi kolom Cum pada table pros_statistik
     */
    @Override
    public void isiCum() {
        try{
            String sql = "select exp from pros_fordat where id_fordat like '%jpb2%' "
                        + "and tahun = '"+tahunDBKB+"'";
            
            Stack stDbkbCum = DBFetching.getStackResult(sql,1);
            
            int stackSize = stDbkbCum.size();
            while(!stDbkbCum.isEmpty())
            {
                sql = "update pros_statistik set cum = "+(double)stDbkbCum.pop()+""
                        + " where jumlah_lantai = "+stackSize+" and id_stat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
                stackSize--;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(94);
       progressBar.setString(94+"%");
        
    }
    
    /**
     * Method untuk mengisi kolom avg1 pada table pros_statistik
     */
    
    @Override
    public void isiAvg1() {
        try{
            //id 1-5
            String sql = "select cum from pros_statistik where jumlah_lantai <= 5 and jumlah_lantai >= 1 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            ArrayList<Double> arrCum = DBFetching.getArrayListDoubleResult(sql,1);
            double median = 0.0;

            if(arrCum.size() % 2 == 0)
            {
                median = (arrCum.get((arrCum.size()/2)+1) - arrCum.get((arrCum.size()/2)))/2;
            }else
            {
                median = arrCum.get((arrCum.size()/2));
            }

            sql = "update pros_statistik set avg1 = "+median+" where jumlah_lantai <= 5 and jumlah_lantai >= 1 and id_stat= 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

           //id 6-12
            sql = "select cum from pros_statistik where jumlah_lantai <= 12 and jumlah_lantai >= 6 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            arrCum = DBFetching.getArrayListDoubleResult(sql,1);
            median = 0.0;

            if(arrCum.size() % 2 == 0)
            {
                median = (arrCum.get((arrCum.size()/2)+1) - arrCum.get((arrCum.size()/2)))/2;
            }else
            {
                median = arrCum.get((arrCum.size()/2));
            }

            sql = "update pros_statistik set avg1 = "+median+" where jumlah_lantai <= 12 and jumlah_lantai >= 6 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        
            //id 13-20

            sql = "select cum from pros_statistik where jumlah_lantai <= 20 and jumlah_lantai >= 13 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            arrCum = DBFetching.getArrayListDoubleResult(sql,1);
            median = 0.0;

            if(arrCum.size() % 2 == 0)
            {
                median = ((arrCum.get((arrCum.size()/2)) + arrCum.get((arrCum.size()/2)-1))/2);

            }else
            {
                median = arrCum.get((arrCum.size()/2));
            }

            sql = "update pros_statistik set avg1 = "+median+" where jumlah_lantai <= 20 and jumlah_lantai >= 13 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 21-24
            sql = "select cum from pros_statistik where jumlah_lantai <= 24 and jumlah_lantai >= 21 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            arrCum = DBFetching.getArrayListDoubleResult(sql,1);
            median = 0.0;

            if(arrCum.size() % 2 == 0)
            {
                median = ((arrCum.get((arrCum.size()/2)) + arrCum.get((arrCum.size()/2)-1))/2);
            }else
            {
                median = arrCum.get((arrCum.size()/2));
            }

            sql = "update pros_statistik set avg1 = "+median+" where jumlah_lantai <= 24 and jumlah_lantai >= 21 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 25-32
            sql = "select cum from pros_statistik where jumlah_lantai <= 32 and jumlah_lantai >= 25 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            arrCum = DBFetching.getArrayListDoubleResult(sql,1);
            median = 0.0;

            if(arrCum.size() % 2 == 0)
            {
                median = ((arrCum.get((arrCum.size()/2)) + arrCum.get((arrCum.size()/2)-1))/2);

            }else
            {
                median = arrCum.get((arrCum.size()/2));
            }

            sql = "update pros_statistik set avg1 = "+median+" where jumlah_lantai <= 32 and jumlah_lantai >= 25 and id_stat= 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(95);
       progressBar.setString(95+"%");
        
     }
    
    /**
     * Method untuk mengisi kolom avg2 pada table pros_statistik
     */
    @Override
    public void isiAvg2() {
        try{
            //id 1-5
            String sql = "select sum(avg1) from pros_statistik where jumlah_lantai <= 6 and jumlah_lantai >= 5 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set avg2 = "+tempData+" where jumlah_lantai <= 5 and jumlah_lantai >= 1 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 6-12
            sql = "select sum(avg1) from pros_statistik where jumlah_lantai <= 13 and jumlah_lantai >= 12 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set avg2 = "+tempData+" where jumlah_lantai <= 12 and jumlah_lantai >= 6 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

             //id 13-20
            sql = "select sum(avg1) from pros_statistik where jumlah_lantai <= 21 and jumlah_lantai >= 20 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set avg2 = "+tempData+" where jumlah_lantai <= 20 and jumlah_lantai >= 13 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 21-24
            sql = "select sum(avg1) from pros_statistik where jumlah_lantai <= 25 and jumlah_lantai >= 24 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set avg2 = "+tempData+" where jumlah_lantai <= 24 and jumlah_lantai >= 21 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 25-32
            sql = "select avg1 from pros_statistik where jumlah_lantai = 32 and id_stat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql);

            sql = "update pros_statistik set avg2 = "+tempData+" where jumlah_lantai <= 32 and jumlah_lantai >= 25 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(96);
       progressBar.setString(96+"%");
    }
    
    /**
     * Method untuk mengisi kolom Smooth pada table pros_statistik
     */
    @Override
    public void isiSmooth() {
        try{
            //id 1-5
            String sql = "select sum(avg2) from pros_statistik where jumlah_lantai <= 6 and jumlah_lantai >= 5 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            double tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set smooth = "+tempData+" where jumlah_lantai <= 5 and jumlah_lantai >= 1 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

             //id 6-12
            sql = "select sum(avg2) from pros_statistik where jumlah_lantai <= 13 and jumlah_lantai >= 12 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set smooth = "+tempData+" where jumlah_lantai <= 12 and jumlah_lantai >= 6 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

             //id 13-20
            sql = "select sum(avg2) from pros_statistik where jumlah_lantai <= 21 and jumlah_lantai >= 20 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set smooth = "+tempData+" where jumlah_lantai <= 20 and jumlah_lantai >= 13 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 21-24
            sql = "select sum(avg2) from pros_statistik where jumlah_lantai <= 25 and jumlah_lantai >= 24 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql)/2;

            sql = "update pros_statistik set smooth = "+tempData+" where jumlah_lantai <= 24 and jumlah_lantai >= 21 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            //id 25-32
            sql = "select avg2 from pros_statistik where jumlah_lantai = 32 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            tempData = DBFetching.getDoubleResult(sql);

            sql = "update pros_statistik set smooth = "+tempData+" where jumlah_lantai <= 50 and jumlah_lantai >= 25 and id_stat = 'jpb2'"
                     + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(98);
       progressBar.setString(98+"%");
           
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
    
}
