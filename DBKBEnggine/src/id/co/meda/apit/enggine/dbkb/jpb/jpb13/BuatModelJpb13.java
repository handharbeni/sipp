/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb13;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.ModelStat;
import id.co.meda.apit.enggine.dbkb.model.jpb13.ItemHitungan;
import id.co.meda.apit.enggine.dbkb.model.jpb13.ModelKUJpb13;
import id.co.meda.apit.enggine.dbkb.model.jpb13.ModelKUJpb13Table1;
import id.co.meda.apit.enggine.dbkb.model.jpb13.ModelTableJpb13;
import id.co.meda.apit.enggine.dbkb.model.modelFordat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author meda
 */
public class BuatModelJpb13 {
   
    private ModelTableJpb13 table1;
    private ModelTableJpb13 table2;
    private HashMap<String,ModelKUJpb13> modelKuTable2; 
    private HashMap<String,ModelKUJpb13Table1> modelKuTable1; 
    private HashMap<String,modelFordat> fordat;
    private HashMap<String,ModelStat> stat;
    
    private String tahunDBKB;
    
    public BuatModelJpb13(String tahun)
    {
        this.tahunDBKB = tahun;
        buatModelItemTable1();
        buatModelItemTable2();
        this.buatModelKUtable2();
        this.buatModelKUtable1();
        this.buatModelFordat();
        this.buatModelStatistik();
    }
    
    
    private void buatModelItemTable1()
    {
        HashMap<String,ItemHitungan> subStruktur = new HashMap<String,ItemHitungan>();
        HashMap<String,ItemHitungan> superStruktur = new HashMap<String,ItemHitungan>();
        HashMap<String,ItemHitungan> preliminaries = new HashMap<String,ItemHitungan>();
        try{
        String sql = "update pros_jpb13 as j,pros_hsku as h set material = hrg_komp, upah = hrg_upah*faktor where jenis_idother = 'KSTR2' and id_other_upah = kd_hsku"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb13 as j,pros_hsku as h set material = hrg_komp/100, upah = hrg_upah*faktor where jenis_idother = 'KSTR' and id_other_upah = kd_hsku"
                + " and id_other_material = kd_hsku and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb13 as j,ref_dhkmf as h set material = hrg_dhkm where jenis_idother = 'MATERIAL' and id_other_material = kd_dhkm"
                + " and j.tahun = '"+tahunDBKB+"' and h.thn_dhkm = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb13 as j,pros_jpb2_lt10 as h set upah = upah_jpb2lt10*faktor where jenis_idother = 'JPB2' and id_other_upah = kd_jpb2lt10"
                + " and j.tahun = '"+tahunDBKB+"' and h.tahun_jpb2lt10 = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_jpb13 as j,pros_hsat as h set material = hrg_mat, upah = hrg_upah*faktor where jenis_idother = 'HSAT' and id_other_upah = kd_hsat"
                + " and id_other_material = kd_hsat and j.tahun = '"+tahunDBKB+"' and h.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //---------------------------buat model subStruktur-------------------------------------------------------------------------//
        sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'B%'";
        ResultSet result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString(1));
            item.setDescription(result.getString(2));
            item.setUnit(result.getString(3));
            item.setQuantity(result.getDouble(4));
            item.setMaterial(result.getDouble(5));
            item.setUpah(result.getDouble(6));
            item.setTahun(tahunDBKB);
            
            subStruktur.put(item.getId(),item);
        }
        
         //proses material B1001
        double material = 0;
        String idKhusus = "B100";
        
        for(int i = 1; i <= 5;i++)
        {
            idKhusus += i+"";
            ItemHitungan item = subStruktur.get(idKhusus);
            double upahItem = item.getMaterial()*item.getQuantity();
            item.setUpah(upahItem);
            material += item.getUpah();
            idKhusus = "B100";
            
        }
        
        subStruktur.get("B1001").setMaterial(material);
        
        //proses material B4000
        material = 0;
        double upah = 0;
        idKhusus = "B400";
        
        for(int i = 1; i <= 6;i++)
        {
            idKhusus += i+"";
            ItemHitungan item = subStruktur.get(idKhusus);
            double upahItem = item.getMaterial()*item.getQuantity();
            item.setUpah(upahItem);
            idKhusus = "B400";
            
        }
        material = subStruktur.get("B4001").getUpah() + subStruktur.get("B4002").getUpah();
        upah = subStruktur.get("B4003").getMaterial() + subStruktur.get("B4004").getMaterial()  + 
               subStruktur.get("B4005").getMaterial() + subStruktur.get("B4006").getMaterial();
        
        subStruktur.get("B4000").setMaterial(material);
        subStruktur.get("B4000").setUpah(upah);
       
        //proses material B1500
        material = 0;
        idKhusus = "B150";
        
        for(int i = 1; i <= 5;i++)
        {
            idKhusus += i+"";
            ItemHitungan item = subStruktur.get(idKhusus);
            double upahItem = item.getMaterial()*item.getQuantity();
            item.setUpah(upahItem);
            material += item.getUpah();
            idKhusus = "B150";
        }
        subStruktur.get("B1500").setMaterial(material);
        
        //---------------------------buat model SuperStruktur-------------------------------------------------------------------------//
        sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString("id"));
            item.setDescription(result.getString("deskripsi"));
            item.setUnit(result.getString("unit"));
            item.setQuantity(result.getDouble("quantity"));
            item.setMaterial(result.getDouble("material"));
            item.setUpah(result.getDouble("upah"));
            item.setTahun(tahunDBKB);
            
           
            
            superStruktur.put(item.getId(),item);
        }
        
        //proses id_other SUM
        ArrayList<String> arrId = new ArrayList<String>();
        sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C%' and jenis_idother = 'SUM'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            arrId.add(result.getString(1));
        }
        
        for(int i = 0; i < arrId.size(); i++)
        {
            superStruktur.get(arrId.get(i)).setMaterial(subStruktur.get("B1001").getMaterial());
        }
    
        //---------------------------buat model Preliminaries-------------------------------------------------------------------------//
        double sumSub = 0;
        double sumSuper = 0;
        double sumAll = 0;
        
        sumSub = subStruktur.get("B1000").getCost()+
                subStruktur.get("B2000").getCost()+
                subStruktur.get("B3000").getCost()+
                subStruktur.get("B4000").getCost()+
                subStruktur.get("B5000").getCost()+
                subStruktur.get("B6000").getCost()+
                subStruktur.get("B7000").getCost()+
                subStruktur.get("B8000").getCost()+subStruktur.get("B9000").getCost()+subStruktur.get("B1100").getCost()+
                subStruktur.get("B1200").getCost()+subStruktur.get("B1300").getCost()+subStruktur.get("B1400").getCost()+
                subStruktur.get("B1500").getCost()+subStruktur.get("B1600").getCost()+subStruktur.get("B1700").getCost()+
                subStruktur.get("B1800").getCost()+subStruktur.get("B1900").getCost()+subStruktur.get("B2100").getCost();
        /*
        System.out.println(subStruktur.get("B1000").getCost()+" \n"+
                subStruktur.get("B2000").getCost()+" \n"+
                subStruktur.get("B3000").getCost()+" \n"+
                subStruktur.get("B4000").getMaterial()+" "+subStruktur.get("B4000").getUpah()+" "+subStruktur.get("B4000").getId()+" "+subStruktur.get("B4000").getCost()+" \n"+
                subStruktur.get("B5000").getCost()+" \n"+
                subStruktur.get("B6000").getCost()+" \n"+
                subStruktur.get("B7000").getCost()+" \n"+
                subStruktur.get("B8000").getCost()+" \n"+subStruktur.get("B9000").getCost()+" \n"+subStruktur.get("B1100").getCost()+" \n"+
                subStruktur.get("B1200").getCost()+" \n"+subStruktur.get("B1300").getCost()+" \n"+subStruktur.get("B1400").getCost()+" \n"+
                subStruktur.get("B1500").getCost()+" \n"+subStruktur.get("B1600").getCost()+" \n"+subStruktur.get("B1700").getCost()+" \n"+
                subStruktur.get("B1800").getCost()+" \n"+subStruktur.get("B1900").getCost()+" \n"+subStruktur.get("B2100").getCost());
        */
                
       
       sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C%'"; 
       arrId = DBFetching.getArrayListStringResult(sql,1);
      
       for(int i = 0; i < arrId.size(); i++)
       {
           ItemHitungan item = superStruktur.get(arrId.get(i));
           sumSuper += item.getCost();
        //   System.out.println(item.getId()+" "+item.getMaterial()+" "+item.getUpah()+" "+item.getQuantity()+" "+item.getCost());
       }
       
       sumAll = sumSuper + sumSub;
     //  System.out.println(sumSuper+" "+sumSub);
       
      // System.out.println(sumAll);
        
        //proses preliminaries
       sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'A%'";
       result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString("id"));
            item.setDescription(result.getString("deskripsi"));
            item.setUnit(result.getString("unit"));
            item.setQuantity(result.getDouble("quantity"));
            item.setMaterial(sumAll);
            item.setUpah(item.getMaterial()*item.getQuantity());
            item.setTahun(tahunDBKB);
            
            preliminaries.put(item.getId(),item);
        }
        
        //buat model 
        table1 = new ModelTableJpb13(this.tahunDBKB);
            getTable1().setSuperStruktur(superStruktur);
            getTable1().setSubStruktur(subStruktur);
            getTable1().setPreliminaries(preliminaries);
        double jumlah = sumAll+preliminaries.get("A0000").getUpah();
        double ppnFee = jumlah * 0.2;
        double imb = jumlah * 0.02;
        double jumlahSubSupStruktur = jumlah+ppnFee+imb;
        double luas = 22013;
        double nilaiDBKB = jumlahSubSupStruktur/luas;
        double sanitary = nilaiDBKB*0.1168;
        
            getTable1().setJumlah(jumlah);
            getTable1().setPpnfee(ppnFee);
            getTable1().setImb(imb);
            getTable1().setJmlhPekSubSuperStruktur(jumlahSubSupStruktur);
            getTable1().setLuasBangunan(luas);
            getTable1().setNilaiDBKB(nilaiDBKB);
            getTable1().setNilaiSanitary(sanitary);
      
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void buatModelItemTable2()
    {
        HashMap<String,ItemHitungan> subStruktur = new HashMap<String,ItemHitungan>();
        HashMap<String,ItemHitungan> superStruktur = new HashMap<String,ItemHitungan>();
        HashMap<String,ItemHitungan> preliminaries = new HashMap<String,ItemHitungan>();
        
        double subCostStruktur = 0;
        double superCostStruktur = 0;
        
        try{
            String sql = "update pros_jpb13_2 as jpb13,pros_jpb12 as jpb12 set jpb13.material = jpb12.material, jpb13.upah = jpb12.upah * faktor where "
                + "jenis_idother = 'JPB12' and id_other_upah = jpb12.id and id_other_material = jpb12.id"
                + " and jpb13.tahun = '"+tahunDBKB+"' and jpb12.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
        //------------------------------------------proses sub struktur---------------------------------------------------------------//
        sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'B%'";
        ResultSet result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString(1));
            item.setDescription(result.getString(2));
            item.setUnit(result.getString(3));
            item.setQuantity(result.getDouble(4));
            item.setMaterial(result.getDouble(5));
            item.setUpah(result.getDouble(6));
            item.setTahun(tahunDBKB);
            
            subCostStruktur += item.getCost();
            
            subStruktur.put(item.getId(),item);
        }
        
        //------------------------------------------proses super struktur---------------------------------------------------------------//
        sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'C%'";
        result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString(1));
            item.setDescription(result.getString(2));
            item.setUnit(result.getString(3));
            item.setQuantity(result.getDouble(4));
            item.setMaterial(result.getDouble(5));
            item.setUpah(result.getDouble(6));
            item.setTahun(tahunDBKB);
            
            superCostStruktur += item.getCost();
            
            superStruktur.put(item.getId(),item);
        }
       
        
       //---------------------------Proses Preliminaries----------------------------------//
        
       double sumSuper = 0;
       double sumSub = 0;
       double sumAll = 0;
       double sumPreliminaries = 0;
       sql = "select id from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'C%'"; 
       ArrayList<String> arrId = DBFetching.getArrayListStringResult(sql,1);
       
       for(int i =0; i < arrId.size(); i++)
       {
           
           if(arrId.get(i).equals("C180000"))
           {
               break;
           }
           ItemHitungan item = superStruktur.get(arrId.get(i));
           sumPreliminaries += item.getCost();
        
       }
       
       
        //proses preliminaries
       
      
       sql = "select id,deskripsi,unit,quantity,material,upah,tahun from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'A%'";
       result = DBFetching.getResultSet(sql);
        while(result.next())
        {
            ItemHitungan item = new ItemHitungan();
            item.setId(result.getString("id"));
            item.setDescription(result.getString("deskripsi"));
            item.setUnit(result.getString("unit"));
            item.setQuantity(result.getDouble("quantity"));
            item.setMaterial(sumPreliminaries);
            item.setUpah(item.getMaterial()*item.getQuantity());
            item.setTahun(tahunDBKB);
            
            preliminaries.put(item.getId(),item);
        }
      
        
        
         //buat model 
       sql = "select id from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'C%'"; 
       arrId = DBFetching.getArrayListStringResult(sql,1);
       
       for(int i =0; i < arrId.size(); i++)
       {
           
           ItemHitungan item = superStruktur.get(arrId.get(i));
           sumSuper += item.getCost();
        
       }
        
       sql = "select id from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'B%'"; 
       arrId = DBFetching.getArrayListStringResult(sql,1);
       
       for(int i =0; i < arrId.size(); i++)
       {
           ItemHitungan item = subStruktur.get(arrId.get(i));
              sumSub += item.getCost();
        
       }
         sumAll = sumSuper + sumSub;
     
        
        
        
        table2 = new ModelTableJpb13(this.tahunDBKB);
            getTable2().setSuperStruktur(superStruktur);
            getTable2().setSubStruktur(subStruktur);
            getTable2().setPreliminaries(preliminaries);
        double jumlah = sumAll+preliminaries.get("A0000").getUpah();
        double ppnFee = jumlah * 0.2;
        double imb = jumlah * 0.02;
        double jumlahSubSupStruktur = jumlah+ppnFee+imb;
        double luas = 20487;
        double nilaiDBKB = jumlahSubSupStruktur/luas;
        
            getTable2().setJumlah(jumlah);
            getTable2().setPpnfee(ppnFee);
            getTable2().setImb(imb);
            getTable2().setJmlhPekSubSuperStruktur(jumlahSubSupStruktur);
            getTable2().setLuasBangunan(luas);
            getTable2().setNilaiDBKB(nilaiDBKB);
            getTable2().setNilaiSanitary(0);
            
            getTable2().setTotalCostSubStruktur(subCostStruktur);
            getTable2().setTotalCostSuperStruktur(superCostStruktur);
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    private void buatModelKUtable2()
    { 
       String sql = "select id from pros_jpb13_2 where tahun = '"+this.tahunDBKB+"' and id like 'C%'"; 
      
       ArrayList<String> arrId = DBFetching.getArrayListStringResult(sql,1);
       
       sql = "select distinct sum(cost) from pros_jpb13_2  where id like '%C%' and  id not like '%C000%' and tahun = '"+this.tahunDBKB+"'" +
             " group by substring(id,1,3) ";
       
       ArrayList<Double> sumCost = DBFetching.getArrayListDoubleResult(sql,1);
       
        modelKuTable2 = new HashMap<String,ModelKUJpb13>(); 
       
           
       double temp = 0;
       
       //proses STR
       for(int i = 0; i < 17; i++)
       {
           
           temp += sumCost.get(i);
           
           ModelKUJpb13 model = new ModelKUJpb13(tahunDBKB);
           model.setJumlahLantai(i+1);
           model.setStr(temp);
           
           modelKuTable2.put((i+1)+"",model);
       }
       
       //proses PRE
       double quantity = table2.getPreliminaries().get("A0000").getQuantity();
       modelKuTable2.get("17").setPre(quantity);
       
       double SubPrimary = table2.getTotalCostSubStruktur()/table2.getPreliminaries().get("A0000").getMaterial();
       modelKuTable2.get("17").setSub(SubPrimary);
       
       modelKuTable2.get("17").setRoof(0);
       modelKuTable2.get("17").setStair(0);
       modelKuTable2.get("17").setArea(20487);
       
       
       
       
       
       for(int i = 16; i > 0;i--)
       {
           double str1 = modelKuTable2.get(i+"").getStr();
           double str2 = modelKuTable2.get((i+1)+"").getStr();
           double pre1 = modelKuTable2.get((i+1)+"").getPre();
           double pre = (str1/str2)*pre1;
           
           double sub1 = modelKuTable2.get((i+1)+"").getSub();
           double sub = (str1/str2)*sub1;
           
           double roof1 = modelKuTable2.get((i+1)+"").getRoof();
           double roof = (str1/str2)*roof1;
           
           double stair1 = modelKuTable2.get((i+1)+"").getStair();
           double stair = (str1/str2)*stair1;
           
           double area1 = modelKuTable2.get((i+1)+"").getArea();
           double area = (str1/str2)*area1;
           
           
           modelKuTable2.get(i+"").setPre(pre);
           modelKuTable2.get(i+"").setSub(sub);
           modelKuTable2.get(i+"").setArea(area);
           modelKuTable2.get(i+"").setStair(stair);
           modelKuTable2.get(i+"").setRoof(roof);
       }
       
       //proses PreCast
       sql = "select cost from pros_jpb13_2  where id like '%C21%' and  id not like '%C210000%' and tahun = '"+this.tahunDBKB+"'";
       
       sumCost = DBFetching.getArrayListDoubleResult(sql,1);
       
       double tempSum = 0;
       for(int i = 0; i < sumCost.size(); i++)
       {
           tempSum += sumCost.get(i);
           modelKuTable2.get((i+3)+"").setPrecast(tempSum);
       }
       
       modelKuTable2.get("17").setPrecast(tempSum);
       
    }
    
    private void buatModelKUtable1()
    {
        //proses DBKB/Lantai dan Stair
        String sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C%'"; 
      
        ArrayList<String> arrId = DBFetching.getArrayListStringResult(sql,1);
       
        sql = "select distinct sum(cost) from pros_jpb13  where id like '%C%' and  id not like '%C000%' and tahun = '"+this.tahunDBKB+"'" +
             " group by substring(id,1,3) ";
         ArrayList<Double> sumCost = DBFetching.getArrayListDoubleResult(sql,1);
        
         modelKuTable1 = new HashMap<String,ModelKUJpb13Table1>(); 
       
         double dbkbPerLantai = table1.getNilaiDBKB()/30;
           
       double temp = 0;
       
       //proses STR
       for(int i = 0; i < 30; i++)
       {
           
           temp += sumCost.get(i);
           
           ModelKUJpb13Table1 model = new ModelKUJpb13Table1(tahunDBKB);
           model.setJumlahLantai(i+1);
           model.setStr(temp);
           model.setDbkbPerLantai(dbkbPerLantai);
           
          modelKuTable1.put((i+1)+"",model);
       }
       
       //proses PRE,SUB,ROOF,AREA
       
        sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'B%'"; 
        arrId = DBFetching.getArrayListStringResult(sql,1);
        
        double tempSub = table1.getSubStruktur().get("B1000").getCost()+
                table1.getSubStruktur().get("B2000").getCost()+
                table1.getSubStruktur().get("B3000").getCost()+
                table1.getSubStruktur().get("B4000").getCost()+
                table1.getSubStruktur().get("B5000").getCost()+
                table1.getSubStruktur().get("B6000").getCost()+
                table1.getSubStruktur().get("B7000").getCost()+
                table1.getSubStruktur().get("B8000").getCost()+
                table1.getSubStruktur().get("B9000").getCost()+table1.getSubStruktur().get("B1100").getCost()+
                table1.getSubStruktur().get("B1200").getCost()+table1.getSubStruktur().get("B1300").getCost()+table1.getSubStruktur().get("B1400").getCost()+
                table1.getSubStruktur().get("B1500").getCost()+table1.getSubStruktur().get("B1600").getCost()+table1.getSubStruktur().get("B1700").getCost()+
                table1.getSubStruktur().get("B1800").getCost()+table1.getSubStruktur().get("B1900").getCost()+table1.getSubStruktur().get("B2100").getCost();
        
        
        
        sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C31%' or id like 'C32%'"; 
        arrId = DBFetching.getArrayListStringResult(sql,1);
        
        double tempRoof = 0;
        for(int i = 0; i < arrId.size(); i++)
        {
            tempRoof += table1.getSuperStruktur().get(arrId.get(i)).getCost();
        }
        
        
        sql = "select id from pros_jpb13 where tahun = '"+this.tahunDBKB+"' and id like 'C33%'"; 
        arrId = DBFetching.getArrayListStringResult(sql,1);
        
        double tempStair = 0;
        for(int i = 0; i < arrId.size(); i++)
        {
            tempStair += table1.getSuperStruktur().get(arrId.get(i)).getCost();
        }
       
       double quantity = table1.getPreliminaries().get("A0000").getUpah()/temp;
       modelKuTable1.get("30").setPre(quantity);
       
       
       
       double SubPrimary = tempSub/temp;
       
       
       modelKuTable1.get("30").setSub(SubPrimary);
       
       modelKuTable1.get("30").setRoof(tempRoof);
       modelKuTable1.get("30").setStair(tempStair);
       modelKuTable1.get("30").setArea(22013);
       
       
       
       
       
       for(int i = 29; i > 0;i--)
       {
           double str1 = modelKuTable1.get(i+"").getStr();
           double str2 = modelKuTable1.get((i+1)+"").getStr();
           double pre1 = modelKuTable1.get((i+1)+"").getPre();
           double pre = (str1/str2)*pre1;
           
           double sub1 = modelKuTable1.get((i+1)+"").getSub();
           double sub = (str1/str2)*sub1;
           
           double roof1 = modelKuTable1.get((i+1)+"").getRoof();
           double roof = (str1/str2)*roof1;
           
           double stair1 = modelKuTable1.get((i+1)+"").getStair();
           double stair = (str1/str2)*stair1;
           
           double area1 = modelKuTable1.get((i+1)+"").getArea();
           double area = (str1/str2)*area1;
         
           
           modelKuTable1.get(i+"").setPre(pre);
           modelKuTable1.get(i+"").setSub(sub);
           modelKuTable1.get(i+"").setArea(area);
           modelKuTable1.get(i+"").setStair(stair);
           modelKuTable1.get(i+"").setRoof(roof);
       }
       
        //proses PreCast
       sql = "select cost from pros_jpb13  where id like '%C34%' and  id not like '%C340000%' and tahun = '"+this.tahunDBKB+"'";
       
       sumCost = DBFetching.getArrayListDoubleResult(sql,1);
       
       double tempSum = 0;
       for(int i = 0; i < sumCost.size(); i++)
       {
           tempSum += sumCost.get(i);
           modelKuTable1.get((i+3)+"").setPrecast(tempSum);
       }
       modelKuTable1.get("28").setPrecast(tempSum);
       modelKuTable1.get("29").setPrecast(tempSum);
       modelKuTable1.get("30").setPrecast(tempSum);
       
       
       //proses DBKB Kum
       for(int i = 0; i < 30; i++)
       {
           if(i < 16)
           {
             double tempTotal = modelKuTable2.get((i+1)+"").getTotBagiArea(0.2);
             modelKuTable1.get((i+1)+"").setDbkbKumulatif(tempTotal);
             
           }else if((i+1) == 17)
           {
              double tempTotal = modelKuTable2.get((i+1)+"").getTotBagiAreaSpesial(0.2);
             modelKuTable1.get((i+1)+"").setDbkbKumulatif(tempTotal);
             
               
           }else
           {
             double tempTotal = modelKuTable1.get((i+1)+"").getTotBagiAreaTable1(0.2);
             modelKuTable1.get((i+1)+"").setDbkbKumulatif(tempTotal);
           }
       }
       
       for(int i = 0; i < 30; i++)
       {
           System.out.println(modelKuTable1.get((i+1)+"").getTotBagiAreaTable1(0.2));
       }
       
       
        
    }
    
    
    private void buatModelFordat()
    {
        
        double sumLogY = 0;
        double sumULogY = 0;
        double sumU2 = 0;
        
        fordat = new HashMap<String,modelFordat>();
        for(int i = 1; i < 31; i++)
        {
            double dbkbKumulatif = this.modelKuTable1.get(i+"").getDbkbKumulatif();
            
            modelFordat model = new modelFordat(this.tahunDBKB);
            model.setJumlahLantai(i);
            model.setY(dbkbKumulatif);
            if(i < 14)
            {
                model.setPol(dbkbKumulatif);
            }else
            {
                double pol = 0.8969*Math.pow(i,5)-77.159*Math.pow(i,4) + 2308.4*Math.pow(i,3)-27510*Math.pow(i,2)+ 123976*i+495298;     
                model.setPol(pol);
            }
            
            getFordat().put(i+"",model);
            sumLogY += model.getLogY();
            sumULogY += model.getuLogY(15.5);
            sumU2 += model.getU2(15.5);
            
        }
        
        double logA = sumLogY/30;
        double logB = sumULogY/sumU2;
       
        for(int i = 1; i < 31;i++)
        {
            double exp = getFordat().get(i+"").getY2(logA, logB, 15.5);
            getFordat().get(i+"").setExp(exp);
        }
       
         for(int i = 1; i < 30;i++)
        {
            double exp1 = getFordat().get(i+"").getExp();
            double exp2 = getFordat().get((i+1)+"").getExp();
            
            getFordat().get((i+1)+"").setDiff(exp2-exp1);
        }
         
         
          for(int i = 0; i < 30;i++)
        {
            double Y = getFordat().get((i+1)+"").getY();
            double U = getFordat().get((i+1)+"").getU(15.5);
            double logY = getFordat().get((i+1)+"").getLogY();
            
         //   System.out.println(Y+" "+U+" "+logY);
            
        }
         
        int u = 16;
        for(int i = 31; i < 51; i++)
        {
           modelFordat model = new modelFordat(this.tahunDBKB);
           model.setJumlahLantai(i);
           double exp = model.getY2(logA, logB, 15.5);
           model.setExp(exp);
           
            getFordat().put(i+"",model);
        }
    }
    
    private void buatModelStatistik()
    {
        stat = new HashMap<String,ModelStat>();
        for(int i = 1; i < getFordat().size()+1; i++)
        {
            double exp = getFordat().get(i+"").getExp();
            ModelStat model = new ModelStat(this.tahunDBKB);
            model.setJumlahLantai(i);
            model.setCum(exp);
            getStat().put(i+"",model);
        }
        
        //fill AVG1
        for(int i = 1; i < getStat().size()+1;i++)
        {
            
            double avg = 0;
            
            if(i < 6)
            {
                
                avg = getStat().get("3").getCum();
                getStat().get(i+"").setAvg1(avg);
                
            }else if(i < 13)
            {
                avg = getStat().get("9").getCum();
                getStat().get(i+"").setAvg1(avg);
                
            }else if(i < 21)
            {
                avg = (getStat().get("16").getCum()+getStat().get("17").getCum())/2;
                getStat().get(i+"").setAvg1(avg);
                
            }else if(i < 25)
            {
                 avg = (getStat().get("22").getCum()+getStat().get("23").getCum())/2;
                getStat().get(i+"").setAvg1(avg);
            }else if(i < 31)
            {
                 avg = (getStat().get("27").getCum()+getStat().get("28").getCum())/2;
                getStat().get(i+"").setAvg1(avg);
            }
            else{
                break;
            }
        }
    }

    /**
     * @return the table1
     */
    public ModelTableJpb13 getTable1() {
        return table1;
    }

    /**
     * @return the table2
     */
    public ModelTableJpb13 getTable2() {
        return table2;
    }

    /**
     * @return the fordat
     */
    public HashMap<String,modelFordat> getFordat() {
        return fordat;
    }

    /**
     * @return the stat
     */
    public HashMap<String,ModelStat> getStat() {
        return stat;
    }
    
    
    
}
