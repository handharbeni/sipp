/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb2;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import javax.swing.JProgressBar;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesTable10jpb2 {
    
    private String tahunDBKB;
    private double jumlah;
    private double ppnFee;
    private double imb;
    private double jumlahStlhPpn;
    private double dbkb;  
    private JProgressBar progressBar; 
    
    private final double LUAS =  6923.64;
   
    
    
    
    
    public ProsesTable10jpb2(String tahunDBKB,JProgressBar progressBar)
    {
         this.tahunDBKB = tahunDBKB;
         DBFetching.setAutoCommit(false);
         this.progressBar = progressBar;
    }
    
    
    
    /**
     * Method ini digunakan untuk proses penghitungan harga-harga Preliminaries
     */
    public void prosesPreliminaries()
    {
        try{
            
            DBFetching.setComandToDB("update pros_jpb2_lt10,pros_hsat "
                    + "set material_jpb2lt10 = hrg_mat + tambahMat_jpb2lt10,upah_jpb2lt10 = hrg_upah * faktor_jpb2lt10 " +
                    "where kd_hsat = kd_other and tahun_jpb2lt10 = '"+this.tahunDBKB+"' and tahun = "
                    + "tahun_jpb2lt10;");
            
            DBFetching.setComandToDB("update pros_jpb2_lt10 "
                    + "set jumlah_jpb2lt10 = (material_jpb2lt10 + upah_jpb2lt10)* qt_jpb2lt10 " +
                    "where tahun_jpb2lt10 = '"+this.tahunDBKB+"'");
            
            double jmlhMaterial = DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where "
                                                                + "kd_jpb2lt10 like '%B%'"
                                                                 + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            
            
            double jumlahPre = DBFetching.getDoubleResult("select "+jmlhMaterial+"*qt_jpb2lt10 from pros_jpb2_lt10 where "
                                                                + "kd_jpb2lt10 = 'A00000'"
                                                                 + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");       
            DBFetching.setComandToDB("update pros_jpb2_lt10 set material_jpb2lt10 = "+jmlhMaterial+", jumlah_jpb2lt10 = "+jumlahPre+""
                                    + "where kd_jpb2lt10 = 'A00000'"
                                    + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
        
            DBFetching.Simpan();
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(50);
       progressBar.setString(50+"%");
    }
    
    /**
     * method ini digunakan untuk memproses harga-harga pada struktur
     */
    public void prosesStruktur()
    {
        Stack stKdJpb2 = new Stack();
        Stack stKdOther = new Stack();
        String sql = "";
        
        
            sql = "select kd_jpb2lt10,kd_other from pros_jpb2_lt10 where stat_jpb2lt10 = 'HSAT'"
                        + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";
            stKdJpb2 = DBFetching.getStackResult(sql,1);
            stKdOther = DBFetching.getStackResult(sql,2);
            double tempValueMatKdOther;
            double tempValueUpahKdOther;
            double qt;
            double tempValueTotal;
        
            while(!stKdJpb2.isEmpty())
            {
                String tempKdJpb = (String)stKdJpb2.pop();
                String tempKdOther = (String)stKdOther.pop();

                
                // proses harga material
                tempValueMatKdOther = DBFetching.getDoubleResult("select hrg_mat from pros_hsat where kd_hsat ='"
                                                                    +tempKdOther+"'"
                                                                    + " and tahun = '"+tahunDBKB+"'");

                sql = "update pros_jpb2_lt10 set material_jpb2lt10 = "+tempValueMatKdOther+"+ tambahMat_jpb2lt10 "
                        + "where kd_jpb2lt10 = '"+tempKdJpb+"'"
                        + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";

                DBFetching.setComandToDB(sql);
            
       progressBar.setValue(52);
       progressBar.setString(52+"%");    
            
            //proses harga upah
        try{
            tempValueUpahKdOther = DBFetching.getDoubleResult("select hrg_upah from pros_hsat where kd_hsat ='"
                                                                 +tempKdOther+"'"
                                                                 + " and tahun = '"+tahunDBKB+"'");


             sql = "update pros_jpb2_lt10 set upah_jpb2lt10 = "+tempValueUpahKdOther+"*faktor_jpb2lt10 "
                     + "where kd_jpb2lt10 = '"+tempKdJpb+"'"
                     + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";

             DBFetching.setComandToDB(sql);

             //proses harga jumlah
             qt = DBFetching.getDoubleResult("select qt_jpb2lt10 from pros_jpb2_lt10 where kd_jpb2lt10 = '"+tempKdJpb+"'"
                                             + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");

             tempValueMatKdOther = DBFetching.getDoubleResult("select material_jpb2lt10 from pros_jpb2_lt10 "
                                                                 + "where kd_jpb2lt10 = '"+tempKdJpb+"'"
                                                                 + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");

             tempValueTotal = (tempValueMatKdOther + tempValueUpahKdOther);

             sql ="update pros_jpb2_lt10 set jumlah_jpb2lt10 = "+tempValueTotal+" where kd_jpb2lt10 = '"+tempKdJpb+"'"
                  + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";

             DBFetching.setComandToDB(sql);
            }catch(Exception e)
            {
                e.printStackTrace();
                DBFetching.RollBackDB();
            }
            }
            
            progressBar.setValue(53);
            progressBar.setString(53+"%");
            
            //proses penghitungan stat NON
            try{
            tempValueMatKdOther = DBFetching.getDoubleResult("select material_jpb2lt10 from pros_jpb2_lt10 where stat_jpb2lt10 = 'NON'"
                                                            + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            tempValueUpahKdOther = DBFetching.getDoubleResult("select upah_jpb2lt10 from pros_jpb2_lt10 where stat_jpb2lt10 = 'NON'"
                                                            + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            qt = DBFetching.getDoubleResult("select qt_jpb2lt10 from pros_jpb2_lt10 where kd_jpb2lt10 = 'NON'"
                                            + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            
            tempValueTotal =(tempValueMatKdOther+tempValueUpahKdOther)*qt;
            
            sql ="update pros_jpb2_lt10 set jumlah_jpb2lt10 = "+tempValueTotal+" where stat_jpb2lt10 = 'NON'"
                    + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";
            
            DBFetching.setComandToDB(sql);
             
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
            
       progressBar.setValue(54);
       progressBar.setString(54+"%");
       try{
            //proses penghitungan stat NON
            tempValueMatKdOther = DBFetching.getDoubleResult("select material_jpb2lt10 from pros_jpb2_lt10 where stat_jpb2lt10 = 'NON'"
                                                            + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            tempValueUpahKdOther = DBFetching.getDoubleResult("select upah_jpb2lt10 from pros_jpb2_lt10 where stat_jpb2lt10 = 'NON'"
                                                              + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
            qt = DBFetching.getDoubleResult("select qt_jpb2lt10 from pros_jpb2_lt10 where stat_jpb2lt10 = 'NON'"
                                            + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");

            tempValueTotal =(tempValueMatKdOther+tempValueUpahKdOther)*qt;

            sql ="update pros_jpb2_lt10 set jumlah_jpb2lt10 = "+tempValueTotal+" where stat_jpb2lt10 = 'NON'"
                    + " and tahun_jpb2lt10 = '"+tahunDBKB+"'";

            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
       
       progressBar.setValue(56);
       progressBar.setString(56+"%");
        
    }
        

    
    public void prosesRekapitulasi()
    {
        double tempSTR = 0;
        
        try{
        ArrayList<Double> arrTotalJumlah = new ArrayList<Double>();
        
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B1%'"
                                                       + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B2%'"
                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B3%'"
               + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B4%'"
                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B5%'"
                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B6%'"
               + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B7%'"
               + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B8%'"
                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%B9%'"
                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        arrTotalJumlah.add(DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%BA%'"
               + " and tahun_jpb2lt10 = '"+tahunDBKB+"'"));
        
        
        double tempJumlah = 0;
        double qtRekap = DBFetching.getDoubleResult("select qt_jpb2lt10 from pros_jpb2_lt10 where kd_jpb2lt10 like '%A00000%'"
                                                    + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
        double tempPre = 0;
        double tempTot = 0;
        double size = DBFetching.getDoubleResult("select count(kd_jpb2lt10) from pros_jpb2_lt10 where "
                                                 + " tahun_jpb2lt10 = '"+tahunDBKB+"'");
        
        for(int i = 0; i < size ; i++)
        {
            if(i < 10)
            {
                tempJumlah += arrTotalJumlah.get(i);
                
                tempPre = tempJumlah*qtRekap;
                tempTot = (tempJumlah+tempPre)+(tempJumlah+tempPre)/5;
                
                DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set "
                                        + "str_cum = "+tempJumlah+","
                                        + "persen = "+qtRekap+","
                                        + "pre  = "+tempPre+","
                                        + "tot = "+tempTot+""
                                        + " where jumlah_lantai = "+(i+1)+""
                                        + " and tahun = '"+tahunDBKB+"'");
            }else{
            
                double tempJumlah2 = DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10 where kd_jpb2lt10 like '%BA%'"
                                                                + " and tahun_jpb2lt10 = '"+tahunDBKB+"'");
                tempJumlah += tempJumlah2;
                tempPre = tempJumlah*qtRekap;
                tempTot = (tempJumlah+tempPre)+(tempJumlah+tempPre)/5;
                
                DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set "
                                        + "str_cum = "+tempJumlah+","
                                        + "persen = "+qtRekap+","
                                        + "pre  = "+tempPre+","
                                        + "tot = "+tempTot+""
                                        + " where jumlah_lantai = "+(i+1)+""
                                        + " and tahun = '"+tahunDBKB+"'");
            }
            
           
        }
        
        
        
        DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set area = "+getLUAS()+"where jumlah_lantai = 10"
                                + " and tahun = '"+tahunDBKB+"'");
        
       progressBar.setValue(57);
       progressBar.setString(57+"%");
        
        for(int i = 9 ;i > 0; i--)
        {
               
              double tempArea = (i*(DBFetching.getDoubleResult("select area from pros_rekap_jpb2lt10 where "
                                            + "jumlah_lantai = "+(i+1)+""
                                            + " and tahun = '"+tahunDBKB+"'")))/(i+1);
              
               DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set area = "+tempArea+" where "
                                        + "jumlah_lantai = "+i+""
                                        + " and tahun = '"+tahunDBKB+"'");
        }
        
        for(int i = 11 ;i < 15; i++)
        {
               
              double tempArea = (i*(DBFetching.getDoubleResult("select area from pros_rekap_jpb2lt10 where "
                                            + "jumlah_lantai = "+(i-1)+""
                                            +" and tahun = '"+tahunDBKB+"'")))/(i-1);
              
              DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set area = "+tempArea+"where "
                                        + "jumlah_lantai = "+i+""
                                        +" and tahun = '"+tahunDBKB+"'");
        }
        
        size = DBFetching.getDoubleResult("SELECT count(jumlah_lantai) "
                + "FROM pros_rekap_jpb2lt10 where tahun = '"+tahunDBKB+"'");
        
        for(int i = 0; i < size; i++)
        {
            DBFetching.setComandToDB("update pros_rekap_jpb2lt10 set dbkb = (tot/area) where jumlah_lantai = "+i+""
                                    +" and tahun = '"+tahunDBKB+"'");
            
            double temp = DBFetching.getDoubleResult("select dbkb from pros_rekap_jpb2lt10 where "
                                    + "jumlah_lantai = "+i+""
                                    +" and tahun = '"+tahunDBKB+"'");
           
             DBFetching.setComandToDB("UPDATE `pros_dbkb_jpb2` SET `dbkb_kumulatif`='"+temp+"' "
                     + "WHERE `jumlah_lantai`='"+i+"' and`tahun`='"+tahunDBKB+"';");
        }
        
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(60);
       progressBar.setString(60+"%");
    
    }
    
    
    
    
    
    /**
     * @return the tahunDBKB
     */
    public String getTahunDBKB() {
        return tahunDBKB;
    }

   

    /**
     * @return the jumlah
     */
    public double getJumlah() {

        this.jumlah = DBFetching.getDoubleResult("select sum(jumlah_jpb2lt10) from pros_jpb2_lt10"
                                                 +" and tahun_jpb2lt10 = '"+tahunDBKB+"'");
        return jumlah;
    }

    /**
     * @return the ppnFee
     */
    public double getPpnFee() {
        
        this.ppnFee = (getJumlah()*20)/100;
        return ppnFee;
    }
    
      /**
     * @return the imb
     */
    public double getImb() {
        
        this.imb= (getJumlah()*2)/100;
        return imb;
    }
    

    /**
     * @return the jumlahStlhPpn
     */
    public double getJumlahStlhPpn() {
        
        this.jumlahStlhPpn = getJumlah() + getPpnFee() + getImb();
        return jumlahStlhPpn;
    }

    /**
     * @return the dbkb
     */
    public double getDbkb() {
        
        this.dbkb = getJumlahStlhPpn()/this.LUAS;
        return dbkb;
    }

    /**
     * @return the LUAS
     */
    public double getLUAS() {
        return LUAS;
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }

  
    
    
}
