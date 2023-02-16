/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.bsm;

import id.co.meda.apit.enggine.dbkb.model.bsm.ModelKuBsmTable2;
import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.bsm.ItemBsm;
import id.co.meda.apit.enggine.dbkb.model.bsm.ModelKuBsmTable1;
import id.co.meda.apit.enggine.dbkb.model.bsm.ModelTableBsm1;
import id.co.meda.apit.enggine.dbkb.model.bsm.ModelTableBsm2;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author meda
 */
public class BuatModelJpbBsm {
    
    private String tahunDBKB;
    private ModelTableBsm1 modelTable1;
    private ModelTableBsm2 modelTable2;
    
    private ModelKuBsmTable1 kuTable1;
    private ModelKuBsmTable2 kuTable2;
    private HashMap<String,ModelKuBsmTable1> dataKuTable1;
    private HashMap<String,ModelKuBsmTable2> dataKuTable2;
    
    public BuatModelJpbBsm(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        buatModelTable1();
        buatModelKuTable1();
        buatModelTable2();
        buatModelKuTable2();
        
    }
    
    private ModelTableBsm1 buatModelTable1()
    {
        
        HashMap<String,ItemBsm> preliminaries = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> siteWork = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> basementTwo = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> basementOne = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> semiBasement = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> roof = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> raillingRamp = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> stp = new HashMap<String,ItemBsm>();
        HashMap<String,ItemBsm> reservoir = new HashMap<String,ItemBsm>();
        
        try{
        //KSTR
        String sql = "update pros_jpb_bsm as j,pros_hsku as h set material = hrg_komp where jenis_other = 'KSTR'"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm as j,pros_hsku as h set upah = hrg_upah where jenis_other = 'KSTR'"
                + " and id_other_upah = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        //KSTR/100    
        sql = "update pros_jpb_bsm as j,pros_hsku as h set material = hrg_komp/100 where jenis_other = 'KSTR/100'"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm as j,pros_hsku as h set upah = hrg_upah/100 where jenis_other = 'KSTR/100'"
                + " and id_other_upah = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //JPB13
        sql = "update pros_jpb_bsm as j,pros_jpb13 as h set j.material = h.material where jenis_other = 'JPB13' "
                + " and j.id_other_material = h.id and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm as j,pros_jpb13 as h set j.upah = h.upah where jenis_other = 'JPB13'"
                + " and j.id_other_upah = h.id and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //JPB4
        sql = "update pros_jpb_bsm as j,pros_jpb4 as h set j.material = h.material where j.jenis_other = 'JPB4' "
                + " and j.id_other_material = h.id and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm as j,pros_jpb4 as h set j.upah = h.upah where j.jenis_other = 'JPB4'"
                + " and j.id_other_upah = h.id and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //Material
        sql = "update pros_jpb_bsm as j,ref_dhkmf as h set material = hrg_dhkm where jenis_other = 'MATERIAL' and id_other_material = kd_dhkm"
                + " and j.tahun = '"+tahunDBKB+"' and h.thn_dhkm = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //HSAT
        sql = "update pros_jpb_bsm as j,pros_hsat as h set material = hrg_mat where jenis_other = 'HSAT' "
                + " and id_other_material = kd_hsat and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb_bsm as j,pros_hsat as h set upah = hrg_upah where jenis_other = 'HSAT' and id_other_upah = kd_hsat"
                + " and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //Upah Non
         sql = "update pros_jpb_bsm as j set upah = material*volume where id_other_upah = 'NON' "
                + " and j.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //-------------preliminaries----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'A%'";
        ResultSet result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            preliminaries.put(result.getString(1), bsm);
            
        }
        
        //-------------sitework----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'B%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
           siteWork.put(result.getString(1), bsm);
        }
        
        
        sql = "select id from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like '%B5%' and id not like '%B5000%'";
        ArrayList<String> id = DBFetching.getArrayListStringResult(sql, 1);
        
        double tempSumMat = 0; 
        double tempSumUp = preliminaries.get("A0006").getUpah()+preliminaries.get("A0007").getUpah()+
                            preliminaries.get("A0008").getUpah()+preliminaries.get("A0009").getUpah(); 
        
        for(int i = 0; i < id.size(); i++)
        {
            tempSumMat += siteWork.get(id.get(i)).getUpah();
        }
        
       siteWork.get("B5000").setMaterial(tempSumMat);
       siteWork.get("B5000").setUpah(tempSumUp);
       
       double tempSumMat2 = siteWork.get("B6001").getUpah() 
               +siteWork.get("B6002").getUpah()
               +siteWork.get("B6003").getUpah()
               +siteWork.get("B6004").getUpah();
       double tempSumUp2 = siteWork.get("B6005").getUpah() 
               +siteWork.get("B6006").getUpah()
               +siteWork.get("B6007").getUpah();
        
       siteWork.get("B6000").setMaterial(tempSumMat2);
       siteWork.get("B6000").setUpah(tempSumUp2);
       
       
       tempSumMat2 = preliminaries.get("A0001").getUpah()+preliminaries.get("A0002").getUpah()+
                preliminaries.get("A0003").getUpah()+preliminaries.get("A0004").getUpah()
               +preliminaries.get("A0005").getUpah();
       
       
       siteWork.get("B7000").setMaterial(tempSumMat2);
       
               
         
        //-------------BasementTwo----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'C%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
           basementTwo.put(result.getString(1), bsm);
        }
        basementTwo.get("C1000").setMaterial(tempSumMat);
        
        double sumBasementMat = basementTwo.get("C2001").getUpah()
                +basementTwo.get("C2002").getUpah()
                +basementTwo.get("C2003").getUpah()
                +basementTwo.get("C2004").getUpah()
                +basementTwo.get("C2005").getUpah();
        
        basementTwo.get("C2006").setMaterial(sumBasementMat);
        basementTwo.get("C2007").setMaterial(sumBasementMat);
        basementTwo.get("C2008").setMaterial(sumBasementMat);
        
        
        //-------------BasementOne----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'D%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
           basementOne.put(result.getString(1), bsm);
        }
        
        basementOne.get("D1001").setMaterial(sumBasementMat);
        basementOne.get("D1002").setMaterial(sumBasementMat);
        basementOne.get("D1003").setMaterial(sumBasementMat);
        
        
         //-------------SemiBasemen----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'E%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            semiBasement.put(result.getString(1), bsm);
        }
        
        semiBasement.get("E1001").setMaterial(sumBasementMat);
        semiBasement.get("E1002").setMaterial(sumBasementMat);
        semiBasement.get("E1003").setMaterial(sumBasementMat);
        
        
        //-------------Roof----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'F%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            roof.put(result.getString(1), bsm);
        }
        
        //-------------RaillingRamp----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'G%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            raillingRamp.put(result.getString(1), bsm);
        }
        
        //G1000
        double tempMat = raillingRamp.get("G1001").getUpah()+
                raillingRamp.get("G1002").getUpah()+
                raillingRamp.get("G1003").getUpah()+
                raillingRamp.get("G1004").getUpah()+
                raillingRamp.get("G1005").getUpah();
        double tempUp = raillingRamp.get("G1010").getUpah()+
                raillingRamp.get("G1011").getUpah();
        raillingRamp.get("G1000").setMaterial(tempUp+tempMat);
        
        
        tempMat = raillingRamp.get("G1006").getUpah()+
                raillingRamp.get("G1007").getUpah()+
                raillingRamp.get("G1008").getUpah()+
                raillingRamp.get("G1009").getUpah();
        
        tempUp = raillingRamp.get("G1012").getUpah()+
                raillingRamp.get("G1013").getUpah()+raillingRamp.get("G1014").getUpah()
                +raillingRamp.get("G1015").getUpah();
        raillingRamp.get("G1000").setUpah(tempUp+tempMat);
        
        //G2000
        tempMat = raillingRamp.get("G2001").getUpah()+
                raillingRamp.get("G2002").getUpah()+
                raillingRamp.get("G2003").getUpah()+
                raillingRamp.get("G2004").getUpah()+
                raillingRamp.get("G2005").getUpah();
        tempUp = raillingRamp.get("G2006").getUpah()+
                raillingRamp.get("G2007").getUpah();
        raillingRamp.get("G2000").setMaterial(tempUp+tempMat);
         
        
        tempMat = raillingRamp.get("G1006").getUpah()+
                raillingRamp.get("G1007").getUpah()+
                raillingRamp.get("G1008").getUpah()+
                raillingRamp.get("G1009").getUpah();
        tempUp = raillingRamp.get("G2008").getUpah()+
                raillingRamp.get("G2009").getUpah()+
                raillingRamp.get("G2010").getUpah()+
                raillingRamp.get("G2011").getUpah();
        raillingRamp.get("G2000").setUpah(tempUp+tempMat);
        
        //G3000
        tempMat = raillingRamp.get("G3001").getUpah()+
                raillingRamp.get("G3002").getUpah()+
                raillingRamp.get("G3003").getUpah();
        tempUp = raillingRamp.get("G3004").getUpah()+
                raillingRamp.get("G3005").getUpah()+
                raillingRamp.get("G3006").getUpah()+
                raillingRamp.get("G3007").getUpah();
        raillingRamp.get("G3000").setMaterial(tempMat);
        raillingRamp.get("G3000").setUpah(tempUp);
        
        //G4000
        tempMat = raillingRamp.get("G4001").getUpah()+
                raillingRamp.get("G4002").getUpah()+
                raillingRamp.get("G4003").getUpah();
        
        tempUp = raillingRamp.get("G4004").getUpah()+
                raillingRamp.get("G4005").getUpah()+
                raillingRamp.get("G4006").getUpah()+
                raillingRamp.get("G4007").getUpah();
        
        raillingRamp.get("G4000").setMaterial(tempMat);
        raillingRamp.get("G4000").setUpah(tempUp);
        
        //G5000
        tempMat = raillingRamp.get("G5001").getUpah()+
                raillingRamp.get("G5002").getUpah()+
                raillingRamp.get("G5003").getUpah();
        
        tempUp = raillingRamp.get("G5004").getUpah()+
                raillingRamp.get("G5005").getUpah()+
                raillingRamp.get("G5006").getUpah()+
                raillingRamp.get("G5007").getUpah()+
                raillingRamp.get("G5003").getUpah();
        
        raillingRamp.get("G5000").setMaterial(tempMat);
        raillingRamp.get("G5000").setUpah(tempUp);
        
      
        //-------------STP----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'H%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            stp.put(result.getString(1), bsm);
        }
        
        stp.get("H8001").setMaterial(sumBasementMat);
        
        //-------------reservoir----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,faktor,tahun from pros_jpb_bsm where tahun = '"+this.tahunDBKB+"' and id like 'I%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(Double.parseDouble(result.getString(6)));
            
            reservoir.put(result.getString(1), bsm);
        }
        
        //buat model table 1
        this.modelTable1 = new ModelTableBsm1 (this.tahunDBKB);
            getModelTable1().setBasementOne(basementOne);
            getModelTable1().setBasementTwo(basementTwo);
            getModelTable1().setPreliminaries(preliminaries);
            getModelTable1().setRaillingRamp(raillingRamp);
            getModelTable1().setReservoir(reservoir);
            getModelTable1().setRoof(roof);
            getModelTable1().setSemiBasement(semiBasement);
            getModelTable1().setSiteWork(siteWork);
            getModelTable1().setStp(stp);
            getModelTable1().setLuasBangunan(7264);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return getModelTable1();
    
            
    }
    
    private void buatModelKuTable1()
    {
        dataKuTable1 = new HashMap<String,ModelKuBsmTable1>();
        double dbkbPerLantai = getModelTable1().getNilaiDBKB(0.02, 0.2)/4;
        for(int i = 1; i < 8;i++)
        {
            kuTable1 = new ModelKuBsmTable1(this.tahunDBKB);
            getKuTable1().setLantai(i);
            getKuTable1().setDbkbPerLantai(dbkbPerLantai);
            getDataKuTable1().put(i+"", getKuTable1());
        }
        
        //STR
        double tempStr = getModelTable1().getSumCostBasementTwo();
        getDataKuTable1().get("1").setStr(tempStr);
        tempStr += getModelTable1().getSumCostBasementOne();
        getDataKuTable1().get("2").setStr(tempStr);
        tempStr += getModelTable1().getSumCostSemiBasement();
        getDataKuTable1().get("3").setStr(tempStr);
        
        tempStr = getDataKuTable1().get("1").getStr();
        
        for(int i = 4; i < 8;i++)
        {
            double temp = getDataKuTable1().get((i-1)+"").getStr();
            getDataKuTable1().get(i+"").setStr(temp+tempStr);
        }
        
        //Pre dan Area
        double primaryPre = getModelTable1().getPreliminaries().get("A0000").getVolume();
        double primaryArea = getModelTable1().getLuasBangunan();
        
        getDataKuTable1().get("3").setPre(primaryPre);
        getDataKuTable1().get("3").setArea(primaryArea);
        
        for(int i = 2; i > 0;i--)
        {
            double temp1 = getDataKuTable1().get(i+"").getStr();
            double temp2 = getDataKuTable1().get((i+1)+"").getStr();
            double temp3 = getDataKuTable1().get((i+1)+"").getPre();
            
            getDataKuTable1().get(i+"").setPre((temp1/temp2)*temp3);
        
            temp3 = getDataKuTable1().get((i+1)+"").getArea();
            
            getDataKuTable1().get(i+"").setArea((temp1/temp2)*temp3);
        }
        
            double temp1 = getDataKuTable1().get("3").getStr();
            double temp2 = getDataKuTable1().get("2").getStr();
            double temp3 = getDataKuTable1().get("3").getPre();
            
            getDataKuTable1().get(4+"").setPre((temp1/temp2)*temp3);
            
            temp3 = getDataKuTable1().get("3").getArea();
            getDataKuTable1().get(4+"").setArea((temp1/temp2)*temp3);
            
            
            primaryPre = getDataKuTable1().get("1").getPre();
            primaryArea = getDataKuTable1().get("1").getArea();
            
            
            
        for(int i = 5 ; i < 8; i++)
        {
            temp1 = getDataKuTable1().get((i-1)+"").getPre();
            getDataKuTable1().get(i+"").setPre((temp1+primaryPre));
            
            temp1 = getDataKuTable1().get((i-1)+"").getArea();
            getDataKuTable1().get(i+"").setArea((temp1+primaryArea));
        }
        
        //Site and Rail
        double primarySite = getModelTable1().getSumCostSiteWork()/getModelTable1().getPreliminaries().get("A0000").getUpah();
        double primaryRail = getModelTable1().getSumCostRaillingRamp();
        getDataKuTable1().get("3").setSite(primarySite);
        getDataKuTable1().get("3").setRail(primaryRail);
       
        
        for(int i = 2; i > 0;i--)
        {
            temp1 = getDataKuTable1().get(i+"").getStr();
            temp2 = getDataKuTable1().get((i+1)+"").getStr();
            temp3 = getDataKuTable1().get((i+1)+"").getSite();
            
            getDataKuTable1().get(i+"").setSite((temp1/temp2)*temp3);
            
            temp3 = getDataKuTable1().get((i+1)+"").getRail();
            
            getDataKuTable1().get(i+"").setRail((temp1/temp2)*temp3);
        }
        
        for(int i = 4; i < 8;i++)
        {
            temp1 = getDataKuTable1().get((i-1)+"").getStr();
            temp2 = getDataKuTable1().get((i-2)+"").getStr();
            temp3 = getDataKuTable1().get((i-1)+"").getSite();
            
            getDataKuTable1().get(i+"").setSite((temp1/temp2)*temp3);
            
            temp1 = getDataKuTable1().get((i-1)+"").getRail();
            temp2 = getDataKuTable1().get((i-2)+"").getRail();
            temp3 = getDataKuTable1().get((i-1)+"").getRail();
            
            getDataKuTable1().get(i+"").setRail((temp1/temp2)*temp3);
        }
        /*
       for(ModelKuBsmTable1 model : dataKuTable1.values() )
       {
           System.out.println(model.getDbkbdanDbkbKum(0.2));
       }*/
        
        
        
        
    }
    
    private void buatModelTable2()
    {
    HashMap<String,ItemBsm> preliminaries = new HashMap<String,ItemBsm>();
    HashMap<String,ItemBsm> earthWork = new HashMap<String,ItemBsm>();
    HashMap<String,ItemBsm> underSubstructureWorks = new HashMap<String,ItemBsm>();
    HashMap<String,ItemBsm> basementTwo = new HashMap<String,ItemBsm>();
    HashMap<String,ItemBsm> basementOne = new HashMap<String,ItemBsm>();
    HashMap<String,ItemBsm> semiBasement = new HashMap<String,ItemBsm>();
        try
        {
            
        //KSTR
        String sql = "update pros_jpb_bsm_2 as j,pros_hsku as h set material = hrg_komp where jenis_other = 'KSTR'"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm_2 as j,pros_hsku as h set upah = hrg_upah where jenis_other = 'KSTR'"
                + " and id_other_upah = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        //KSTR/100    
        sql = "update pros_jpb_bsm_2 as j,pros_hsku as h set material = hrg_komp/100 where jenis_other = 'KSTR/100'"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm_2 as j,pros_hsku as h set upah = hrg_upah/100 where jenis_other = 'KSTR/100'"
                + " and id_other_upah = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //Material
        sql = "update pros_jpb_bsm_2 as j,ref_dhkmf as h set material = hrg_dhkm where jenis_other = 'MATERIAL' and id_other_material = kd_dhkm"
                + " and j.tahun = '"+tahunDBKB+"' and h.thn_dhkm = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //JPB2
        sql = "update pros_jpb_bsm_2 as j,pros_jpb2_lt10 as h set j.material = h.material_jpb2lt10 where j.jenis_other = 'JPB2' "
                + " and j.id_other_material = h.kd_jpb2lt10 and j.tahun = '"+tahunDBKB+"' and h.tahun_jpb2lt10 = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);    
        
        sql = "update pros_jpb_bsm_2 as j,pros_jpb2_lt10 as h set j.upah = h.upah_jpb2lt10 where j.jenis_other = 'JPB2'"
                + " and j.id_other_upah = h.kd_jpb2lt10 and j.tahun = '"+tahunDBKB+"' and h.tahun_jpb2lt10 = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //HSAT
        sql = "update pros_jpb_bsm_2 as j,pros_hsat as h set material = hrg_mat where jenis_other = 'HSAT' "
                + " and id_other_material = kd_hsat and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb_bsm_2 as j,pros_hsat as h set upah = hrg_upah where jenis_other = 'HSAT' and id_other_upah = kd_hsat"
                + " and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
    
        
        //-------------preliminaries----------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'A%'";
        ResultSet result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            preliminaries.put(result.getString(1), bsm);
            
        }
        
        //------------Earth Work-------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'B%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            earthWork.put(result.getString(1), bsm);
            
        }
        
        //------------UnderSubstructureWork-------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'C%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            underSubstructureWorks.put(result.getString(1), bsm);
        }
       
        //------------BasemennTwo-------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'D1%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            basementTwo.put(result.getString(1), bsm);
        }
        
        //------------BasemennOne-------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'D2%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            basementOne.put(result.getString(1), bsm);
        }
        
        //------------SemiBasemen-------------------//
        sql = "select id,jenis_pekerjaan,volume,material,upah,tahun from pros_jpb_bsm_2 where tahun = '"+this.tahunDBKB+"' and id like 'D3%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemBsm bsm = new ItemBsm(this.tahunDBKB);
            bsm.setId(result.getString(1));
            bsm.setJenisPekerjaan(result.getString(2));
            bsm.setVolume(Double.parseDouble(result.getString(3)));
            bsm.setMaterial(Double.parseDouble(result.getString(4)));
            bsm.setUpah(Double.parseDouble(result.getString(5)));
            bsm.setFaktor(1);
            
            semiBasement.put(result.getString(1), bsm);
        }
        
        modelTable2 = new ModelTableBsm2(this.tahunDBKB);
            getModelTable2().setPreliminaries(preliminaries);
            getModelTable2().setEarthWork(earthWork);
            getModelTable2().setBasementOne(basementOne);
            getModelTable2().setBasementTwo(basementTwo);
            getModelTable2().setSemiBasement(semiBasement);
            getModelTable2().setUnderSubstructureWorks(underSubstructureWorks);
        
            getModelTable2().getPreliminaries().get("A0000").setMaterial(getModelTable2().getSumCostBasementTwo()+getModelTable2().getSumCostBasementOne()+
            getModelTable2().getSumCostSemiBasement());
        
            getModelTable2().setLuasBangunan(11781);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void buatModelKuTable2()
    {
        dataKuTable2 = new HashMap<String,ModelKuBsmTable2>(); 
        for(int i = 1; i < 8;i++)
        {
            kuTable2 = new ModelKuBsmTable2(this.tahunDBKB);
            getKuTable2().setLantai(i);
            getDataKuTable2().put(i+"", getKuTable2());
        }
        //proses STR
        double tempStr = getModelTable2().getSumCostBasementTwo();
        getDataKuTable2().get("1").setStr(tempStr);
        tempStr += getModelTable2().getSumCostBasementOne();
        getDataKuTable2().get("2").setStr(tempStr);
        tempStr += getModelTable2().getSumCostSemiBasement();
        getDataKuTable2().get("3").setStr(tempStr);
        
        tempStr = getDataKuTable2().get("1").getStr();
        
        for(int i = 4; i < 8;i++)
        {
            double temp = getDataKuTable2().get((i-1)+"").getStr();
            getDataKuTable2().get(i+"").setStr(temp+tempStr);
        }
        
        //PRE,AREA,MIS
        double primaryPre = getModelTable2().getPreliminaries().get("A0000").getVolume();
        double primaryArea = getModelTable2().getLuasBangunan();
        double primaryMis = getModelTable2().getSumCostEarthWork()+getModelTable2().getSumCostUnderSubstructureWorks();
        
        getDataKuTable2().get("3").setPre(primaryPre);
        getDataKuTable2().get("3").setArea(primaryArea);
        getDataKuTable2().get("3").setMis(primaryMis);
        
        for(int i = 2; i > 0;i--)
        {
            double temp1 = getDataKuTable2().get(i+"").getStr();
            double temp2 = getDataKuTable2().get((i+1)+"").getStr();
            double temp3 = getDataKuTable2().get((i+1)+"").getPre();
            
            getDataKuTable2().get(i+"").setPre((temp1/temp2)*temp3);
        
            temp3 = getDataKuTable2().get((i+1)+"").getArea();
            
            getDataKuTable2().get(i+"").setArea((temp1/temp2)*temp3);
            
            temp3 = getDataKuTable2().get((i+1)+"").getMis();
            
            getDataKuTable2().get(i+"").setMis((temp1/temp2)*temp3);
        }
        
            double temp1 = getDataKuTable2().get("3").getStr();
            double temp2 = getDataKuTable2().get("2").getStr();
            double temp3 = getDataKuTable2().get("3").getPre();
            
            getDataKuTable2().get(4+"").setPre((temp1/temp2)*temp3);
            
            temp3 = getDataKuTable2().get("3").getArea();
            getDataKuTable2().get(4+"").setArea((temp1/temp2)*temp3);
            
            temp3 = getDataKuTable2().get("3").getMis();
            getDataKuTable2().get(4+"").setMis((temp1/temp2)*temp3);
            
            
            primaryPre = getDataKuTable2().get("1").getPre();
            primaryArea = getDataKuTable2().get("1").getArea();
            primaryMis = getDataKuTable2().get("1").getMis(); 
            
            
        for(int i = 4 ; i < 8; i++)
        {
            temp1 = getDataKuTable2().get((i-1)+"").getPre();
            getDataKuTable2().get(i+"").setPre((temp1+primaryPre));
            
            temp1 = getDataKuTable2().get((i-1)+"").getArea();
            getDataKuTable2().get(i+"").setArea((temp1+primaryArea));
            
            temp1 = getDataKuTable2().get((i-1)+"").getMis();
            getDataKuTable2().get(i+"").setMis((temp1+primaryMis));
            
        }
       
        /*
        for(ModelKuBsmTable2 values : dataKuTable2.values())
        {
           System.out.println(values.getDbkb());
        }*/
        
    }

    /**
     * @return the modelTable1
     */
    public ModelTableBsm1 getModelTable1() {
        return modelTable1;
    }

    /**
     * @return the modelTable2
     */
    public ModelTableBsm2 getModelTable2() {
        return modelTable2;
    }

    /**
     * @return the kuTable1
     */
    public ModelKuBsmTable1 getKuTable1() {
        return kuTable1;
    }

    /**
     * @return the kuTable2
     */
    public ModelKuBsmTable2 getKuTable2() {
        return kuTable2;
    }

    /**
     * @return the dataKuTable1
     */
    public HashMap<String,ModelKuBsmTable1> getDataKuTable1() {
        return dataKuTable1;
    }

    /**
     * @return the dataKuTable2
     */
    public HashMap<String,ModelKuBsmTable2> getDataKuTable2() {
        return dataKuTable2;
    }
    
    
}
