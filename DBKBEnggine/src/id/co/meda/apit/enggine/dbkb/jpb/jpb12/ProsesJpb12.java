/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb12;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author meda
 */
public class ProsesJpb12 {
    
    private double nilaiDBKB;
    private double ppnFee;
    private double nilaiSanitary;
    private String tahunDBKB;
    private final double LUAS_BANGUNAN = 35540;
    private final double PPN_PERSEN = 0.2;
    
    public ProsesJpb12(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
    
    /**
     * Proses Pengisian Table Komponen 
     */
    public void prosesTable()
    {
        try{
            String sql = "";
            //HSAT
            sql = "update pros_jpb12,pros_hsat set upah = hrg_upah*faktor_upah,material = hrg_mat*faktor_material where kd_hsat = id_other and jenis_other = 'HSAT' "
                    + "and pros_jpb12.tahun = '"+tahunDBKB+"' and pros_hsat.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //STR
            sql = "update pros_jpb12,pros_hsku set upah = hrg_upah*faktor_upah,material = hrg_komp*faktor_material where kd_hsku = id_other and jenis_other = 'STR' "
                    + "and pros_jpb12.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //JPB2
            sql = "update pros_jpb12,pros_jpb2_lt32 set upah = upah_jpb2lt32*faktor_upah,material = material_jpb2lt32 *faktor_material where kd_jpb2lt32 = id_other and jenis_other = 'JPB2' "
                    + "and pros_jpb12.tahun = '"+tahunDBKB+"' and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
          
            //update cost
            sql = "update pros_jpb12 set cost = (upah+material)*volume where pros_jpb12.tahun = '"+tahunDBKB+"' and id not like '%C18%'";
            DBFetching.setComandToDB(sql);
            
            
                
            
           //update Preliminaries
            
            double sumMaterial = DBFetching.getDoubleResult("select sum(cost) from pros_jpb12 where tahun = '"+tahunDBKB+"' and id not like '%A0001%'");
            
            sql = "update pros_jpb12 set material = "+sumMaterial+" where pros_jpb12.tahun = '"+tahunDBKB+"' and id like '%A0001%'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_jpb12 set cost = material*volume where pros_jpb12.tahun = '"+tahunDBKB+"' and id like '%A0001%'";
            DBFetching.setComandToDB(sql);
            
            
          
            //proses Hitung DBKB
            double jumlah = DBFetching.getDoubleResult("select sum(cost) from pros_jpb12 where tahun = '"+tahunDBKB+"'");
            ppnFee = jumlah*this.PPN_PERSEN;
            double imb = jumlah*0.02;
            double jumlahSubSuperStruktur = jumlah+ppnFee+imb;
            nilaiDBKB = jumlahSubSuperStruktur/this.LUAS_BANGUNAN;
            nilaiSanitary = nilaiDBKB*0.0133;
            
  
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesKuJpb12()
    {
        try{
            
            //proses lt 1-13
            String sql = "SELECT substring(id,1,3),sum(cost) FROM "
                    + "pros_jpb12 where tahun = '"+tahunDBKB+"' "
                    + " group by substring(id,1,3)";
            ResultSet result = DBFetching.getResultSet(sql);
            
            HashMap<String,Double> map = new HashMap <String,Double>();
            
            while (result.next())
            {
                map.put(result.getString(1), Double.parseDouble(result.getString(2)));
            }
           
            double cumLt = 0;
            
            for(int i = 0; i < 13; i++)
            {
                String temp = "";
                if(i < 9)
                {
                    temp = "C"+(i+1)+"0";
                }else
                {
                    temp = "C"+(i+2);
                }
                cumLt += map.get(temp);
                sql = "update pros_ku_jpb12 set str = "+cumLt+" where jumlah_lantai = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            
            cumLt = 0.0;
            
             for(double i = 13; i < 20 ;i++)
            {  
                double tempPre1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where jumlah_lantai = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where jumlah_lantai = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
            
                sql = "update pros_ku_jpb12 set str = "+tempHasil+" where jumlah_lantai = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
             
             
            //proses ROOF and Stair
             double tempStair = map.get("C17");
             double tempRoof = map.get("C15") + map.get("C16");
             sql = "update pros_ku_jpb12 set roof = "+tempRoof+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = 13 ";
             DBFetching.setComandToDB(sql);
             sql = "update pros_ku_jpb12 set stair = "+tempStair+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = 13 ";
             DBFetching.setComandToDB(sql);
             
              for(int i = 13;i > 0;i--)
              {
                  //proses roof
                  double temp1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select roof from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp1/temp2)*temp3;
                  sql = "update pros_ku_jpb12 set roof = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1);
                  DBFetching.setComandToDB(sql);
                  
                  //proses stair
                  temp1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  temp2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  temp3 = DBFetching.getDoubleResult("select stair from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  value = (temp1/temp2)*temp3;
                  sql = "update pros_ku_jpb12 set stair = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1);
                  DBFetching.setComandToDB(sql);
                  
                  
                  
              }
              
              for(int i = 13;i < 20;i++)
              {
                  //proses roof
                  double temp1 = DBFetching.getDoubleResult("select roof from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select roof from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select roof from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp2/temp1)*temp3;
                  sql = "update pros_ku_jpb12 set roof = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i + 1);
                  DBFetching.setComandToDB(sql);
                  
                  //proses stair
                  temp1 = DBFetching.getDoubleResult("select stair from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  temp2 = DBFetching.getDoubleResult("select stair from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  temp3 = DBFetching.getDoubleResult("select stair from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  value = (temp2/temp1)*temp3;
                  sql = "update pros_ku_jpb12 set stair = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i+1);
                  DBFetching.setComandToDB(sql);
                  
                  
               }
              
            //Proses Precast
            sql = "select cost from pros_jpb12 where id like '%C18%' and id not like '%C1800%' and tahun = '"+tahunDBKB+"'";
            ArrayList<Double> arrPreCast = DBFetching.getArrayListDoubleResult(sql,1);
            
            double tempValue = 0;
            for(int i = 2; i < 19;i++)
            {
                int tempArr = i-2;
                if(tempArr < arrPreCast.size())
                {
                    tempValue += arrPreCast.get(tempArr);
                }
                
                sql = "update pros_ku_jpb12 set  precast = "+tempValue+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i+1);
                DBFetching.setComandToDB(sql);
                  
            }
            
            
            //Proses Pre
            sql = "select cost/(select sum(cost) from pros_jpb12 where id like '%C%' and id not like '%C18%' \n" +
                  "and id not like '%C17%'\n" +
                  "and id not like '%C16%'\n" +
                  "and id not like '%C15%' \n"
                + "and tahun = '"+tahunDBKB+"')"+
                  "from pros_jpb12 where id = 'A0001' and tahun = '"+tahunDBKB+"'";
            
            double tempPreCost = DBFetching.getDoubleResult(sql);
                  
            sql = "update pros_ku_jpb12 set pre = "+tempPreCost+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = 13 ";
            DBFetching.setComandToDB(sql);
            
            for(int i = 13;i > 0;i--)
              {
                  //proses pre
                  double temp1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select pre from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp1/temp2)*temp3;
                  
                  sql = "update pros_ku_jpb12 set pre = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1);
                  DBFetching.setComandToDB(sql);
                  
                 
              }
              
              for(int i = 13;i < 20;i++)
              {
                  //proses pre
                  double temp1 = DBFetching.getDoubleResult("select pre from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select pre from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select pre from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp2/temp1)*temp3;
                  sql = "update pros_ku_jpb12 set pre = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i + 1);
                  DBFetching.setComandToDB(sql);
                  
               
               }
              
              
              //proses preHarga
               sql = "update pros_ku_jpb12 set  preharga = str*pre where tahun = '"+tahunDBKB+"'";
               DBFetching.setComandToDB(sql);
               
               
               
               
              //Proses Sub
            sql = "select sum(cost)/(select sum(cost) from pros_jpb12 where id like '%C%' and id not like '%C18%' \n" +
                  "and id not like '%C17%'\n" +
                  "and id not like '%C16%'\n" +
                  "and id not like '%C15%' \n"
                + "and tahun = '"+tahunDBKB+"')"+
                  "from pros_jpb12 where id like '%B%' and tahun = '"+tahunDBKB+"'";
            
            double tempSubPreCost = DBFetching.getDoubleResult(sql);
                  
            sql = "update pros_ku_jpb12 set sub = "+tempSubPreCost+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = 13 ";
            DBFetching.setComandToDB(sql);
            
            for(int i = 13;i > 0;i--)
              {
                  //proses Sub
                  double temp1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select sub from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp1/temp2)*temp3;
                  
                  sql = "update pros_ku_jpb12 set sub = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1);
                  DBFetching.setComandToDB(sql);
                  
                 
              }
              
              for(int i = 13;i < 20;i++)
              {
                  //proses Sub
                  double temp1 = DBFetching.getDoubleResult("select sub from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select sub from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select sub from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp2/temp1)*temp3;
                  sql = "update pros_ku_jpb12 set sub = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i + 1);
                  DBFetching.setComandToDB(sql);
                  
               
               }
              
              //proses subHarga
               sql = "update pros_ku_jpb12 set  subharga = str*sub where tahun = '"+tahunDBKB+"'";
               DBFetching.setComandToDB(sql);
               
               
              //proses Total
               sql = "update pros_ku_jpb12 set total = (subHarga+preHarga+precast+stair+roof+str) + "
                      + "(("+PPN_PERSEN+")*(subHarga+preHarga+precast+stair+roof+str)) where tahun = '"+tahunDBKB+"'";
               
               DBFetching.setComandToDB(sql);
               
               
                //Proses Area
           sql = "update pros_ku_jpb12 set area = "+this.LUAS_BANGUNAN+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = 13 ";
            DBFetching.setComandToDB(sql);
            
            for(int i = 13;i > 0;i--)
              {
                  //proses area
                  double temp1 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select str from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select area from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp1/temp2)*temp3;
                  
                  sql = "update pros_ku_jpb12 set area = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1);
                  DBFetching.setComandToDB(sql);
                  
                 
              }
              
              for(int i = 13;i < 20;i++)
              {
                  //proses area
                  double temp1 = DBFetching.getDoubleResult("select area from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i-1));
                  double temp2 = DBFetching.getDoubleResult("select area from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  double temp3 = DBFetching.getDoubleResult("select area from pros_ku_jpb12 where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i));
                  
                  double value = (temp2/temp1)*temp3;
                  sql = "update pros_ku_jpb12 set area = "+value+" where tahun = '"+tahunDBKB+"' and jumlah_lantai = "+(i + 1);
                  DBFetching.setComandToDB(sql);
              
               }
               
               //proses dbkb
               sql = "update pros_ku_jpb12 set dbkb = total/area where tahun = '"+tahunDBKB+"'";
               DBFetching.setComandToDB(sql);
               
             
               
               
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    
    public void hitungDbkbJpb12()
    {
        // update DBKB_Per_lantai
        String sql = "update pros_dbkb_jpb12 set dbkb_perlantai = "+this.nilaiDBKB/14+" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        // update DBKB_Kumulatif
        sql = "update pros_dbkb_jpb12 as dbkb,pros_ku_jpb12 as ku set "
                + "dbkb.dbkb_kumulatif = ku.dbkb where ku.jumlah_lantai <= 14 "
                + "and ku.jumlah_lantai = dbkb.jumlah_lantai and ku.tahun = '"+tahunDBKB+"' and dbkb.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
   
    
}
