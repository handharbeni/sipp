/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb2;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 * Class ini untuk memproses perhitungan ProsesTable32jpb2
 * @author I Putu Medagia A
 */
public class ProsesTable32jpb2 {
    private String tahunDBKB;
    private double jumlah;
    private double ppn;
    private double imb;
    private double jmlhSubSuperStruktur;
    private final double LUASTOWER = 26979;
    private double dbkbTotal; //nilai Rp/m2
    private double sanitary; //nilai Rp/m2
    private JProgressBar progressBar;
    
    /**
     * Konstruktor class JPB2 
     * @param tahunDBKB 
     */
    public ProsesTable32jpb2(String tahunDBKB,JProgressBar progressBar)
    {
        this.jumlah = -1;
        this.ppn = -1;
        this.imb = -1;
        this.jmlhSubSuperStruktur = -1;
        
        this.sanitary = -1;
        this.dbkbTotal = -1;
        this.tahunDBKB = tahunDBKB;
        
        this.progressBar = progressBar;
        DBFetching.setAutoCommit(false);
    }
    
    
    
    /**
     * method ini digunakan untuk memproses SubStruktur
     */
    public void prosesSubStruktur()
    {
        String sql = "";
        double hrgMaterialTotal = 0.0; //Variable untuk menampunt Total digunakan dama MATERIAL-S
        ArrayList<String> kdHsat = new ArrayList<String>();
        ArrayList<String> kdJpb2 = new ArrayList<String>();
        ArrayList<String> kdKstr  = new ArrayList<String>();
        ArrayList<String> kdMaterial  = new ArrayList<String>();
        
        //filling data upah dan material NON
        try{
        
            
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%NON%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select material_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                   +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            
            double hrgUpah = DBFetching.getDoubleResult("select upah_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                   +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgMaterial + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
        }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J201", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
         progressBar.setValue(62);
       progressBar.setString(62+"%");
        
        
        //filling data upah dan material MATERIAL
        try{
        
        System.out.println("Proses STAT MATERIAL");    
            
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%MATERIAL%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdMaterial = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%MATERIAL%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf "
                    + "where kd_dhkm = '"+ kdMaterial.get(i).trim() +"'"
                    +" and thn_dhkm = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                   +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            
            double hrgUpah =  hrgMaterial * quantitas;
                    
           
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+""
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            
            hrgMaterialTotal += hrgUpah;
            DBFetching.setComandToDB(sql);
        }
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J202", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        
        }
        
         progressBar.setValue(64);
       progressBar.setString(64+"%");
        
        //insert hrgMaterialTotal into specific row
        
        Stack stKdRow = new Stack();
        stKdRow.add("B11005");
        stKdRow.add("B11006");
        stKdRow.add("B11007");
        stKdRow.add("C14001");
        stKdRow.add("C14002");
        stKdRow.add("C14003");
        stKdRow.add("C14004");
        stKdRow.add("C14005");
        stKdRow.add("C14006");
        stKdRow.add("C14007");
        stKdRow.add("C23001");
        stKdRow.add("C23002");
        stKdRow.add("C23003");
        stKdRow.add("C35001");
        stKdRow.add("C35002");
        stKdRow.add("C35003");
        stKdRow.add("C35004");
        stKdRow.add("C35005");
        
        sql = "Select sum(upah_jpb2lt32) from pros_jpb2_lt32 \n" +
              "where kd_jpb2lt32 in ('B11001','B11002','B11003','B11004')\n" +
              "and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        double temp = DBFetching.getDoubleResult(sql);
        
        while(!stKdRow.isEmpty())
        {
            sql = "update pros_jpb2_lt32 set upah_jpb2lt32 = "+temp+" where \n" +
                  "kd_jpb2lt32 = '"+stKdRow.pop()+"'"
                  +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            
            DBFetching.setComandToDB(sql);
        }
        
        
        //filling data material dan upah MATERIAL-S
        try{
        
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%MATERIAL-S%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgUpah = DBFetching.getDoubleResult("select upah_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            
            double hrgBiaya =  hrgUpah * quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+""
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }
        
        
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J203", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
        
         progressBar.setValue(65);
       progressBar.setString(65+"%");
        
        
        //filling data upah dan material HSAT
        try{
            
        System.out.println("Proses STAT HSAT");    
            
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%HSAT%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        
        kdHsat = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%HSAT%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select hrg_mat from pros_hsat "
                    + "where kd_hsat = '"+ kdHsat.get(i).trim() +"'"
                    +" and tahun = '"+tahunDBKB+"'");
            double hrgUpah = DBFetching.getDoubleResult("select hrg_upah from pros_hsat "
                    + "where kd_hsat = '"+ kdHsat.get(i).trim() +"'"
                    +" and tahun = '"+tahunDBKB+"'");
           
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgMaterial + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
        }
            
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J204", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
        
         progressBar.setValue(66);
       progressBar.setString(66+"%");
        //filling data upah dan material K-STR
        try{
            
        System.out.println("Proses STAT KSTR");    
            
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdKstr = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgKomponen = DBFetching.getDoubleResult("select hrg_komp from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                    +" and tahun = '"+tahunDBKB+"'");
            double hrgUpah = DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                    +" and tahun = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgKomponen + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgKomponen+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                    +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
            
        }
             progressBar.setValue(67);
       progressBar.setString(67+"%");
        //proses untuk stat_jpb2lt32 KSTR/10
        
        System.out.println("Proses STAT KSTR/10");
        
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/10%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdKstr = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/10%' and kd_jpb2lt32 like '%B%'"
                +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
        arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgKomponen = (DBFetching.getDoubleResult("select hrg_komp from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/10;
            double hrgUpah = (DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/10;
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgKomponen + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+Math.round(hrgKomponen)+","
                    + "upah_jpb2lt32 = "+Math.round(hrgUpah)+","
                    + "biaya_jpb2lt32 = "+Math.round(hrgBiaya)+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
         }
       progressBar.setValue(68);
       progressBar.setString(68+"%");
         //proses untuk stat_jpb2lt32 KSTR/100
         
         System.out.println("Proses STAT KSTR/100");
         
         sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/100%' and kd_jpb2lt32 like '%B%'"
                  +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
         kdKstr = DBFetching.getArrayListStringResult(sql,1);
         sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/100%' and kd_jpb2lt32 like '%B%'"
                  +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
         kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
         arrSize = kdJpb2.size();
        
         for(int i = 0; i < arrSize; i++)
         {
            double hrgKomponen = (DBFetching.getDoubleResult("select hrg_komp from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/100;
            double hrgUpah = (DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/100;
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgKomponen + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+Math.round(hrgKomponen)+","
                    + "upah_jpb2lt32 = "+Math.round(hrgUpah)+","
                    + "biaya_jpb2lt32 = "+Math.round(hrgBiaya)+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
         }
            
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J205", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        
        }
         progressBar.setValue(69);
       progressBar.setString(69+"%");
    }
    
    
    /**
     * method ini digunakan untuk memproses SuperStruktur
     */
    public void prosesSuperStruktur()
    {
       
        String sql = "";
        double hrgMaterialTotal = 0.0; //Variable untuk menampung Total Upah Material
        ArrayList<String> kdJpb2 = new ArrayList<String>();
        ArrayList<String> kdKstr  = new ArrayList<String>();
        ArrayList<String> kdMaterial  = new ArrayList<String>();
         
        
        
        //filling data stat MATERIAL
        try{
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%MATERIAL%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdMaterial = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%MATERIAL%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf "
                    + "where kd_dhkm = '"+ kdMaterial.get(i).trim() +"'"
                     +" and thn_dhkm = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            
            double hrgUpah =  hrgMaterial * quantitas;
                    
           
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+""
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            
            hrgMaterialTotal += hrgUpah;
            DBFetching.setComandToDB(sql);
        }
            
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J206", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
       progressBar.setValue(70);
       progressBar.setString(70+"%");
        
       
        
        //Filling data stat KSTR
        try
        {
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdKstr = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgKomponen = DBFetching.getDoubleResult("select hrg_komp from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'");
            double hrgUpah = DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgKomponen + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgKomponen+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }
        
        progressBar.setValue(72);
       progressBar.setString(72+"%");
        //Filling data stat KSTR/100
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/100%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdKstr = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR/100%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
        arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgKomponen = (DBFetching.getDoubleResult("select hrg_komp from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/100;
            double hrgUpah = (DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'"))/100;
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgKomponen + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+Math.round(hrgKomponen)+","
                    + "upah_jpb2lt32 = "+Math.round(hrgUpah)+","
                    + "biaya_jpb2lt32 = "+Math.round(hrgBiaya)+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
        }
        
        progressBar.setValue(74);
       progressBar.setString(74+"%");
        
        //Filling data stat KSTR-UPAH
        sql = "SELECT kd_other FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR-UPAH%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdKstr = DBFetching.getArrayListStringResult(sql,1);
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%KSTR-UPAH%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);    
        
        arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select material_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double hrgUpah = DBFetching.getDoubleResult("select hrg_upah from pros_hsku "
                    + "where kd_hsku = '"+ kdKstr.get(i).trim() +"'"
                     +" and tahun = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgMaterial + hrgUpah)*quantitas;
            
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+kdJpb2.get(i).trim()+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            
            DBFetching.setComandToDB(sql);
        }
        
         //insert hrgMaterialTotal into specific row
        
        Stack stKdRow = new Stack();
        stKdRow.add("C12007");
        stKdRow.add("C12008");
        stKdRow.add("C12009");
        stKdRow.add("C12010");
        stKdRow.add("C12011");
        stKdRow.add("C12012");
        stKdRow.add("C12013");
        stKdRow.add("C12014");
        stKdRow.add("C21001");
        stKdRow.add("C21002");
        stKdRow.add("C21003");
        stKdRow.add("C21004");
        stKdRow.add("C32001");
        stKdRow.add("C32002");
        stKdRow.add("C32003");
        
        sql = "Select sum(upah_jpb2lt32) from pros_jpb2_lt32 \n" +
              "where kd_jpb2lt32 in ('C12001','C12002','C12003','C12004','C12005')\n" +
              "and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        
        hrgMaterialTotal = DBFetching.getDoubleResult(sql);
        //System.out.println("tes" + sql);
        while(!stKdRow.isEmpty())
        {
            
            String kdRow = (String) stKdRow.pop();
            sql = "update pros_jpb2_lt32 set material_jpb2lt32 = "
                    +hrgMaterialTotal+" where kd_jpb2lt32 = '"+kdRow+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"; 
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_jpb2_lt32 set "
                    + "biaya_jpb2lt32 = (material_jpb2lt32 + upah_jpb2lt32) * qt_jpb2lt32"
                    + "  where kd_jpb2lt32 = '"+kdRow+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"; 
            DBFetching.setComandToDB(sql);
        
        
        }
        
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J207", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(75);
       progressBar.setString(75+"%");
        
        
        
        
        //filling data stat NON
        try{
        sql = "SELECT kd_jpb2lt32 FROM pros_jpb2_lt32 WHERE stat_jpb2lt32 like '%NON%' and kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        kdJpb2 = DBFetching.getArrayListStringResult(sql,1);
        
        int arrSize = kdJpb2.size();
        
        for(int i = 0; i < arrSize; i++)
        {
            double hrgMaterial = DBFetching.getDoubleResult("select material_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double hrgUpah = DBFetching.getDoubleResult("select upah_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double quantitas = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'"); 
            double hrgBiaya = (hrgMaterial + hrgUpah)*quantitas;
            
            sql = "update pros_jpb2_lt32 "
                    + "set material_jpb2lt32 = "+hrgMaterial+","
                    + "upah_jpb2lt32 = "+hrgUpah+","
                    + "biaya_jpb2lt32 = "+hrgBiaya+" where kd_jpb2lt32 = '"+ kdJpb2.get(i).trim() +"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
                    
            DBFetching.setComandToDB(sql);
        }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal mengisi kolom upah dan material JPB2",
                    "Error J208", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(76);
       progressBar.setString(76+"%");
    }
    
    /**
     *  method ini digunakan untuk memproses Preliminaries 
     */
    public void prosesPreliminaries()
    {
        try{
            
        //proses menghitung material dan biaya Preliminaires
        String sql = "select biaya_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 not like '%A0%'"
                      +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";    
        double biayaPre = 0.0;
        double materialPre = 0.0;
        double persenPre = 0.0;
        double qtPre = DBFetching.getDoubleResult("select qt_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 like '%A0%'"
                                                  +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        Stack stBiaya = DBFetching.getStackResult(sql,1);
        
        while(!stBiaya.isEmpty())
        {
            materialPre += Double.parseDouble(stBiaya.pop()+"");
        }
        
        biayaPre = materialPre * qtPre;
    
        //proses update table
        sql = "update pros_jpb2_lt32 set "
                + " material_jpb2lt32 = "+materialPre
                + ", biaya_jpb2lt32 = "+biayaPre
                + ", total_jpb2lt32 = "+biayaPre
                + " where kd_jpb2lt32 = 'A00000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        
        DBFetching.setComandToDB(sql);
        
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung material dan biaya Preliminaries JPB2",
                    "Error J209", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(77);
       progressBar.setString(77+"%");
    }
    
    
    /**
     * method ini digunakan untuk memproses total_jpb2lt32
     * B00000,C00000,C10000,C11001a,C11007,C12013,C13015,
     * C20000,C30000,C31000
     */
    public void prosesTotal()
    {
        Stack tempStack = new Stack();
        String sql = "";
        double total = 0.0;
        
        //proses total kd B00000
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 like '%B%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'B00000'"
                                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'B00000' JPB2",
                    "Error J210", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C00000
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 like '%C%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C00000'"
                                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C00000' JPB2",
                    "Error J211", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(78);
       progressBar.setString(78+"%");
        
        //proses total kd C10000
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 like '%C1%'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C10000'"
                                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C10000' JPB2",
                    "Error J212", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(79);
       progressBar.setString(79+"%");
        //proses total kd C11001a
        try{
        
        sql = "select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'C10000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        double temp = DBFetching.getDoubleResult(sql);
        total = temp/32;
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C11001a'"
                                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C11001a' JPB2",
                    "Error J213", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C11007
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 in ('C11007','C11008','C11009') "
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C11007'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C11007' JPB2",
                    "Error J214", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C12013
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 in ('C12013','C12014') "
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C12013'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C12013' JPB2",
                    "Error J215", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        progressBar.setValue(80);
       progressBar.setString(80+"%");
        //proses total kd C13015
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 in ('C13015','C13016','C13017','C13018')"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C13015'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C13015' JPB2",
                    "Error J216", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C20000
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 like '%C2%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C20000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C20000' JPB2",
                    "Error J217", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C30000
        try{
        sql = "select sum(biaya_jpb2lt32) from pros_jpb2_lt32 where kd_jpb2lt32 like '%C3%'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        total = DBFetching.getDoubleResult(sql);
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C30000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C30000' JPB2",
                    "Error J218", JOptionPane.ERROR_MESSAGE);
             DBFetching.RollBackDB();
            System.exit(1);
        }
        
        //proses total kd C31000
        try{
        
        sql = "select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'C30000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'";
        double temp = DBFetching.getDoubleResult(sql);
        total = temp/32;
        
        DBFetching.setComandToDB("update pros_jpb2_lt32 set total_jpb2lt32 = "+total+" where kd_jpb2Lt32 = 'C31000'"
                 +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung Total id 'C31000' JPB2",
                    "Error J219", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
            System.exit(1);
        }
        progressBar.setValue(82);
       progressBar.setString(82+"%");
        
    }

    /**
     *  proses kolom persen_jpb2lt32
     * A00000,B00000,C00000,C10000,C20000,C30000
     */
    public void prosesPersen()
    {
        Stack tempStack = new Stack();
        tempStack.push("C30000");
        tempStack.push("C20000");
        tempStack.push("C10000");
        tempStack.push("C00000");
        tempStack.push("B00000");
        tempStack.push("A00000");
        
        
        double tempJumlah = getJumlah();
        double tempTotal = 0.0;
        double persen = 0.0;
        
        while(!tempStack.isEmpty())
        {
            String temp = (String)tempStack.pop();
            try{
            tempTotal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 "
                    + "where kd_jpb2lt32 = '"+temp+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            
            
            persen = tempTotal/tempJumlah;
            
            
            DBFetching.setComandToDB("update pros_jpb2_lt32 set persen_jpb2lt32 = "+persen+" "
                    + "where kd_jpb2lt32 = '"+temp+"'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Gagal menghitung persen dari id '"+temp+"' JPB2",
                    "Error J220", JOptionPane.ERROR_MESSAGE);
                DBFetching.RollBackDB();
                System.exit(1);
            }
          
           progressBar.setValue(84);
       progressBar.setString(84+"%");
            
        }   
    }
    
    
    public void prosesExpectedCost()
    {
        try{
            double nilaiSubAwal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'A00000'"
                                                              +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double nilaiPreAwal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'B00000'"
                                                               +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double nilaiTowerAwal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'C10000'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double nilaiStairAwal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'C30000'"
                     +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double nilaiRoofAwal = DBFetching.getDoubleResult("select total_jpb2lt32 from pros_jpb2_lt32 where kd_jpb2lt32 = 'C20000'"
                      +" and tahun_jpb2lt32 = '"+tahunDBKB+"'");
            double towerFaktor = nilaiTowerAwal/32;
            double stairFaktor = nilaiStairAwal/32;
            double preFaktor = nilaiSubAwal/(nilaiTowerAwal+nilaiStairAwal+nilaiRoofAwal);
            double subFaktor = nilaiPreAwal/(nilaiTowerAwal+nilaiStairAwal+nilaiRoofAwal);


            DBFetching.setComandToDB("update pros_expectedcost_jpb2lt10 set "
                                     + "pre = "+nilaiPreAwal+","
                                     + "sub = "+nilaiSubAwal+","
                                     + "tower = "+nilaiTowerAwal+","
                                     + "stair = "+nilaiStairAwal+""
                                     + "where jumlah_lantai = 32 "
                                     +" and tahun = '"+tahunDBKB+"'");

            DBFetching.setComandToDB("update pros_expectedcost_jpb2lt10 set roof = "+nilaiRoofAwal+""
                                     +" and tahun = '"+tahunDBKB+"'");

            for(int i = 31; i > 14; i--)
            {
                double tempTowerPre = DBFetching.getDoubleResult("select tower from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                                                                 +" and tahun = '"+tahunDBKB+"'");
                double tempStairPre = DBFetching.getDoubleResult("select stair from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                                                                 +" and tahun = '"+tahunDBKB+"'");
                double tempTower = DBFetching.getDoubleResult("select tower from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+(i+1)+""
                                                                 +" and tahun = '"+tahunDBKB+"'");
                double tempStair = DBFetching.getDoubleResult("select stair from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+(i+1)+""
                                                                 +" and tahun = '"+tahunDBKB+"'");

                DBFetching.setComandToDB("update pros_expectedcost_jpb2lt10 set"
                                         + " tower = "+(tempTower-(nilaiTowerAwal/32))+","
                                         + " stair = "+(tempStair-(nilaiStairAwal/32))+","
                                         + " pre = "+(preFaktor*(tempTowerPre+nilaiRoofAwal+tempStairPre))+","
                                         + " sub = "+(subFaktor*(tempTowerPre+nilaiRoofAwal+tempStairPre))+""
                                         + " where jumlah_lantai = "+i+""
                                         +" and tahun = '"+tahunDBKB+"'");
            }

            DBFetching.setComandToDB("update pros_expectedcost_jpb2lt10 set area = "+this.getLuasTower()+" "
                                     + "where tahun = '"+tahunDBKB+"'");

            for(int i = 32; i > 14; i--)
            {
                double tempPre = DBFetching.getDoubleResult("select pre from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                        +" and tahun = '"+tahunDBKB+"'");
                double tempSub = DBFetching.getDoubleResult("select sub from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                        +" and tahun = '"+tahunDBKB+"'");
                double tempTower = DBFetching.getDoubleResult("select tower from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                        +" and tahun = '"+tahunDBKB+"'");
                double tempStair = DBFetching.getDoubleResult("select stair from pros_expectedcost_jpb2lt10 where jumlah_lantai = "+i+""
                        +" and tahun = '"+tahunDBKB+"'");
                double sbtSum = tempPre+tempSub+tempTower+tempStair + nilaiRoofAwal;
                double ppnFee = sbtSum*0.2;
                double sat = sbtSum + ppnFee;
                double dbkb = sat/this.getLuasTower();

                
                
                DBFetching.setComandToDB("update pros_expectedcost_jpb2lt10 set "
                                        + "sbt = "+sbtSum+","
                                        + "ppnfee = "+ppnFee+","
                                        + "sat = "+sat+","
                                        + "dbkb = "+dbkb+" where jumlah_lantai = "+i+""
                                        +" and tahun = '"+tahunDBKB+"'");
                
                DBFetching.setComandToDB("UPDATE `pros_dbkb_jpb2` SET `dbkb_kumulatif`='"+dbkb+"' "
                     + "WHERE `jumlah_lantai`='"+i+"' and`tahun`='"+tahunDBKB+"';");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(85);
       progressBar.setString(85+"%");
        
    }
    
    
    
    
    
    
    
    
    
            
    /**
     * @return the jumlah
     */
    public double getJumlah() {
        
        jumlah = DBFetching.getDoubleResult("select sum(biaya_jpb2lt32) from pros_jpb2_lt32 "
                                            +" where tahun_jpb2lt32 = '"+tahunDBKB+"'");
        return jumlah;
    }

    /**
     * @return the ppn
     */
    public double getPpn() {
        ppn = (getJumlah()*10)/100;
        return ppn;
    }

    /**
     * @return the imb
     */
    public double getImb() {
        imb = (getJumlah()*2)/100;
        return imb;
    }

    /**
     * @return the jmlhSubSuperStruktur
     */
    public double getJmlhSubSuperStruktur() {
        jmlhSubSuperStruktur = getJumlah()+getPpn()+getImb();
        return jmlhSubSuperStruktur;
    }

    /**
     * @return the LUASTOWER
     */
    public double getLuasTower() {
        
        return LUASTOWER;
    }

    /**
     * @return the dbkbTotal
     */
    public double getDbkbTotal() {
        dbkbTotal = getJmlhSubSuperStruktur()/getLuasTower();
        return dbkbTotal;
    }

    /**
     * @return the sanitary
     */
    public double getSanitary() {
        sanitary = (getDbkbTotal()*1.332)/100;
        return sanitary;
    }

    public void done()
    {
        DBFetching.Simpan();
    }        
            
    
    
}


