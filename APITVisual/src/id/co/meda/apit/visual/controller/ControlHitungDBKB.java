/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.DBKBFirstCalculation;
import id.co.meda.apit.enggine.dbkb.jpb.KuLebih4lt;
import id.co.meda.apit.enggine.dbkb.jpb.bsm.ProsesHitungJpbBsm;
import id.co.meda.apit.enggine.dbkb.jpb.fordatJpb12;
import id.co.meda.apit.enggine.dbkb.jpb.fordatJpb2;
import id.co.meda.apit.enggine.dbkb.jpb.fordatJpb4;
import id.co.meda.apit.enggine.dbkb.jpb.fordatJpb7;
import id.co.meda.apit.enggine.dbkb.jpb.jpb1.JPB1;
import id.co.meda.apit.enggine.dbkb.jpb.jpb12.ProsesJpb12;
import id.co.meda.apit.enggine.dbkb.jpb.jpb14.ProsesJpb14;
import id.co.meda.apit.enggine.dbkb.jpb.jpb2.ProsesTable10jpb2;
import id.co.meda.apit.enggine.dbkb.jpb.jpb2.ProsesTable32jpb2;
import id.co.meda.apit.enggine.dbkb.jpb.jpb3.ProsesJpb38;
import id.co.meda.apit.enggine.dbkb.jpb.jpb4.ProsesJpb4;
import id.co.meda.apit.enggine.dbkb.jpb.jpb7.ProsesJpb7;
import id.co.meda.apit.enggine.dbkb.jpb.statJpb12;
import id.co.meda.apit.enggine.dbkb.jpb.statJpb2;
import id.co.meda.apit.enggine.dbkb.jpb.statJpb4;
import id.co.meda.apit.enggine.dbkb.jpb.statJpb7;
import java.awt.Label;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlHitungDBKB {
    
    private String tahunDBKB;
    private JProgressBar progressBar;
    private Label labelProses;
    
    public ControlHitungDBKB(String tahunDBKB ,JProgressBar progressBar,Label labelProses)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
        this.progressBar = progressBar;
        this.labelProses = labelProses;
    }
    
    public ControlHitungDBKB()
    {
        DBFetching.setAutoCommit(false);
    }
    
    public JComboBox getComboBoxItem(JComboBox tempCombo)
    {
        tempCombo.addItem("Pilih Tahun..");
        String sql = "select distinct thn_dhkm from ref_dhkmf";
        ResultSet set = DBFetching.getResultSet(sql);
        
        try{
           while(set.next())
           {
               tempCombo.addItem(set.getString(1));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return tempCombo;
    }
    
    public void HitunganDBKBPertama()
    {
        try{
        this.labelProses.setText("Menghitung DBKB Awal..");
        DBKBFirstCalculation hitDBKB = new DBKBFirstCalculation(this.tahunDBKB,progressBar);
        this.labelProses.setText("Proses HSKU..");
        hitDBKB.HSKUCalculation();
        this.labelProses.setText("Proses HSKM..");
        hitDBKB.HSKMCalculation();
        this.labelProses.setText("Proses HSAT..");
        hitDBKB.HSATCalculation();
        this.labelProses.setText("Proses Hasil Material..");
        hitDBKB.ProsesRsltMaterial();
        
        this.labelProses.setText("Proses Fasilitas..");
        hitDBKB.FasilitasCalculation();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
    }
    
 
    public void HitunganJPB()
    {
        
        try{
        this.labelProses.setText("Menghitung nilai JPB..");
        
        
        this.labelProses.setText("Proses JPB1..");
        //-----------------Proses Hitung JPB1-----------------------------------//
        JPB1 hitJpb1 = new JPB1(this.tahunDBKB,this.progressBar);
        hitJpb1.hitungJPB1Lt1();
        hitJpb1.hitungTabelJPB1Lt1();
        hitJpb1.hitungJPB1Lt2to4();
        
        
        this.labelProses.setText("Proses JPB2..");
        //-----------------Proses Hitung JPB2-----------------------------------//
        
        this.labelProses.setText("Proses JPB2 10 lantai..");
        //Table 10 lantai
        ProsesTable10jpb2 hitTable10jpb2 = new ProsesTable10jpb2(this.tahunDBKB,this.progressBar);
        hitTable10jpb2.prosesPreliminaries();
        hitTable10jpb2.prosesStruktur();
        hitTable10jpb2.prosesRekapitulasi();
        
        
        this.labelProses.setText("Proses JPB2 32 lantai..");
        //Table 32 lantai
        ProsesTable32jpb2 hitTable32jpb2 = new ProsesTable32jpb2(this.tahunDBKB,this.progressBar);
        hitTable32jpb2.prosesSubStruktur();
        hitTable32jpb2.prosesSuperStruktur();
        hitTable32jpb2.prosesPreliminaries();
        hitTable32jpb2.prosesTotal();
        hitTable32jpb2.prosesPersen();
        hitTable32jpb2.prosesExpectedCost();
        
        this.labelProses.setText("Proses JPB2 formulasi data..");
       //fordat
        fordatJpb2 hitFordatjpb2 = new fordatJpb2(this.tahunDBKB,this.progressBar);
        hitFordatjpb2.isiYdanPol();
        hitFordatjpb2.isiU();
        hitFordatjpb2.isiLogY();
        hitFordatjpb2.isiULogY();
        hitFordatjpb2.isiU2();
        hitFordatjpb2.isiLogY2();
        hitFordatjpb2.isiY2danExp();
        hitFordatjpb2.isiDiff();
        
        this.labelProses.setText("Proses JPB2 statistik..");
        //Statistik
        statJpb2 hitStatjpb2 = new statJpb2(this.tahunDBKB,this.progressBar);
        hitStatjpb2.isiCum();
        hitStatjpb2.isiAvg1();
        hitStatjpb2.isiAvg2();
        hitStatjpb2.isiSmooth();
        
        //proses jpb4
        ProsesJpb4 jpb4 = new ProsesJpb4(this.tahunDBKB);
        jpb4.prosesTable();
        jpb4.hitungDbkbJpb4();
        jpb4.hitungKuJpb4();
        jpb4.done();
        
        //fordat
        fordatJpb4 hitFordatjpb4 = new fordatJpb4(this.tahunDBKB);
        hitFordatjpb4.isiYdanPol();
        hitFordatjpb4.isiU();
        hitFordatjpb4.isiLogY();
        hitFordatjpb4.isiULogY();
        hitFordatjpb4.isiU2();
        hitFordatjpb4.isiLogY2();
        hitFordatjpb4.isiY2danExp();
        hitFordatjpb4.isiDiff();
       
        //Statistik
        statJpb4 hitStatjpb4 = new statJpb4(this.tahunDBKB);
        hitStatjpb4.isiCum();
        hitStatjpb4.isiAvg1();
        hitStatjpb4.isiAvg2();
        hitStatjpb4.isiSmooth();
        
        
        
        ProsesJpb7 jpb7 = new ProsesJpb7(this.tahunDBKB);
        jpb7.prosesTable();
        jpb7.prosesKuJpb7();
        jpb7.prosesDbkbJpb7();
        jpb7.done();
        
        //fordat
        fordatJpb7 hitFordatjpb7 = new fordatJpb7(this.tahunDBKB);
        hitFordatjpb7.isiYdanPol();
        hitFordatjpb7.isiU();
        hitFordatjpb7.isiLogY();
        hitFordatjpb7.isiULogY();
        hitFordatjpb7.isiU2();
        hitFordatjpb7.isiLogY2();
        hitFordatjpb7.isiY2danExp();
        hitFordatjpb7.isiDiff();
       
        //Statistik
        statJpb7 hitStatjpb7 = new statJpb7(this.tahunDBKB);
        hitStatjpb7.isiCum();
        hitStatjpb7.isiAvg1();
        hitStatjpb7.isiAvg2();
        hitStatjpb7.isiSmooth();
        
        ProsesJpb12 jpb12 = new ProsesJpb12(this.tahunDBKB);
        jpb12.prosesTable();
        jpb12.prosesKuJpb12();
        jpb12.hitungDbkbJpb12();
        jpb12.done();
        
        //fordat
        fordatJpb12 hitFordatjpb12 = new fordatJpb12(this.tahunDBKB);
        hitFordatjpb12.isiYdanPol();
        hitFordatjpb12.isiU();
        hitFordatjpb12.isiLogY();
        hitFordatjpb12.isiULogY();
        hitFordatjpb12.isiU2();
        hitFordatjpb12.isiLogY2();
        hitFordatjpb12.isiY2danExp();
        hitFordatjpb12.isiDiff();
       
        //Statistik
        statJpb12 hitStatjpb12 = new statJpb12(this.tahunDBKB);
        hitStatjpb12.isiCum();
        hitStatjpb12.isiAvg1();
        hitStatjpb12.isiAvg2();
        hitStatjpb12.isiSmooth();
        
        
        ProsesJpb14 jpb14 = new ProsesJpb14(this.tahunDBKB);
        jpb14.prosesTable();
        jpb14.done();
        
        
        
        
        ProsesHitungJpbBsm bsm = new ProsesHitungJpbBsm(this.tahunDBKB);
        bsm.prosesPindahKeKu();
        
        //JPB 3/8
        ProsesJpb38 jpb38 = new ProsesJpb38(tahunDBKB);
        jpb38.prosesAll();
      
        this.labelProses.setText("Proses pengisian tabel KU..");
        //Setor Table KU > 4 lantai
        KuLebih4lt hitKuLbh4Lt = new KuLebih4lt(this.tahunDBKB,this.progressBar);
        hitKuLbh4Lt.isiJpb2dan9();
        hitKuLbh4Lt.isiJpb4();
        hitKuLbh4Lt.isiJpb7();
        hitKuLbh4Lt.isiJpb12();
        hitKuLbh4Lt.isiJpb13();
        
         
        hitKuLbh4Lt.done();
        //----------------------------------------------------------------------//
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
    
   
    
    
}
