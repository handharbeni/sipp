/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb7;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author meda
 */
public class ProsesJpb7 {
    
      private String tahunDBKB;
      private double PPN_PERSEN = 0.2;
       private double LUAS_BANGUNAN = 7872;
    private double nilaiDBKB;
    private double nilaiSanitary;
      
      public ProsesJpb7(String tahunDBKB)
      {
          this.tahunDBKB = tahunDBKB;
          DBFetching.setAutoCommit(false);
      }
      
   /**
     * Proses Pengisian Table Komponen 
     **/
    public void prosesTable()
    {
        try{
            //HSAT
            String sql = "update pros_jpb7,pros_hsat set upah = hrg_upah*faktor_upah,material = hrg_mat+faktor_material where kd_hsat = id_other and jenis_other = 'HSAT' "
                    + "and pros_jpb7.tahun = '"+tahunDBKB+"' and pros_hsat.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //STR
            sql = "update pros_jpb7,pros_hsku set upah = hrg_upah*faktor_upah, material = hrg_komp+faktor_material where kd_hsku = id_other and jenis_other = 'KSTR' "
                    + "and pros_jpb7.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //MTR
            sql = "update pros_jpb7,ref_dhkmf set upah = material*quantity,material = hrg_dhkm+faktor_material where kd_dhkm = id_other and jenis_other = 'MTR' "
                    + "and pros_jpb7.tahun = '"+tahunDBKB+"' and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //JPB2
            sql = "update pros_jpb7,pros_jpb2_lt32 set upah = upah_jpb2lt32*faktor_upah, material = material_jpb2lt32 +faktor_material where kd_jpb2lt32 = id_other and jenis_other = 'JPB2' "
                    + "and pros_jpb7.tahun = '"+tahunDBKB+"' and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //proses sub structur B2005 dan B1003
            
            Double tempUpah = DBFetching.getDoubleResult("select sum(upah) from pros_jpb7 where id in('B1003','B1004')");
            
            sql = "update pros_jpb7 set upah = "+tempUpah+" where pros_jpb7.tahun = '"+tahunDBKB+"' and id = 'B1002'";
            DBFetching.setComandToDB(sql);
            
            tempUpah = DBFetching.getDoubleResult("select sum(upah) from pros_jpb7 where id in('B2001','B2002','B2003','B2004')");
            Double tempMaterial = DBFetching.getDoubleResult("select sum(material) from pros_jpb7 where id in('B2001','B2002','B2003','B2004')");
            
            sql = "update pros_jpb7 set upah = "+tempUpah+",material = "+tempMaterial+" where pros_jpb7.tahun = '"+tahunDBKB+"' and id in('B2005','B2006','B2007' "
                    + "'B2008', 'B2009', 'B2010','B2011','B2012','B2014','B2015')";
            DBFetching.setComandToDB(sql);
            
            
            //update jumlah
            sql = "update pros_jpb7 set jumlah = (upah+material)*quantity where pros_jpb7.tahun = '"+tahunDBKB+"' and id not in('B1003','B1004','B1006',"
                    + "'B1007','B1008','B1009')";
            DBFetching.setComandToDB(sql);
            
            //update preliminaries
            
            sql = "select sum(jumlah) from pros_jpb7 where id not like '%A%' and pros_jpb7.tahun = '"+tahunDBKB+"'";
            tempMaterial = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_jpb7 set material = "+tempMaterial+" where pros_jpb7.tahun = '"+tahunDBKB+"' and id like '%A0000%'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_jpb7 set jumlah = material*quantity where pros_jpb7.tahun = '"+tahunDBKB+"' and id like '%A0000%'";
            DBFetching.setComandToDB(sql);
            
            
             //proses Hitung DBKB
            double jumlah = DBFetching.getDoubleResult("select sum(jumlah) from pros_jpb7 where tahun = '"+tahunDBKB+"'");
            double ppnFee = jumlah*this.PPN_PERSEN;
            double imb = jumlah*0.02;
            double jumlahSubSuperStruktur = jumlah+ppnFee+imb;
            nilaiDBKB = jumlahSubSuperStruktur/this.LUAS_BANGUNAN;
            nilaiSanitary = nilaiDBKB*0.1234;
 
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesKuJpb7()
    {
        try{
            
             //proses lt 1-10
            String sql = "SELECT substring(id,1,3),sum(jumlah) "
                    + "FROM pros_jpb7 where tahun = '"+tahunDBKB+"'"
                    + "group by substring(id,1,3)";
            ResultSet result = DBFetching.getResultSet(sql);
            
            HashMap<String,Double> map = new HashMap <String,Double>();
            
            while (result.next())
            {
                map.put(result.getString(1), Double.parseDouble(result.getString(2)));
            }
           
            double cumLt = 0;
            
            for(int i = 0; i < 10; i++)
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
                sql = "update pros_ku_jpb7 set str_cum = "+cumLt+" where jumlah_lt = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            
            cumLt = 0.0;
            
             for(double i = 10; i < 14 ;i++)
            {  
                double tempPre1 = DBFetching.getDoubleResult("select str_cum from pros_ku_jpb7 where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select str_cum from pros_ku_jpb7 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
            
                sql = "update pros_ku_jpb7 set str_cum = "+tempHasil+" where jumlah_lt = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            
             
            //proses Persen
             sql = "update pros_ku_jpb7 set persen = 0.01151 where jumlah_lt = 10 and tahun = '"+tahunDBKB+"'";
             
             //proses kurang 10
              for(double i = 9; i > 0 ;i--)
              {
                double tempPre3 = DBFetching.getDoubleResult("select persen from pros_ku_jpb7 where jumlah_lt = "+(i+1)+" and tahun = '"+tahunDBKB+"'");
                
                double tempHasil = (i/(i+1))*tempPre3;
            
                sql = "update pros_ku_jpb7 set persen = "+tempHasil+" where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
                
              }
              
              //proses lebih 10
              for(double i = 11; i < 15 ;i++)
              {
                double tempPre1 = DBFetching.getDoubleResult("select persen from pros_ku_jpb7 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select persen from pros_ku_jpb7 where jumlah_lt = "+(i-2)+" and tahun = '"+tahunDBKB+"'");  
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
              
                sql = "update pros_ku_jpb7 set persen = "+tempHasil+" where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
              }
              
            //proses Sub
              sql = "select sum(jumlah) from pros_jpb7 where id like '%B%' and tahun = '"+tahunDBKB+"'";
              double temp1 = DBFetching.getDoubleResult(sql);
              sql = "select sum(jumlah) from pros_jpb7 where id like '%C%' and tahun = '"+tahunDBKB+"'";
              double temp2 = DBFetching.getDoubleResult(sql);
              
              double temp3 = temp1/temp2;
             
              sql = "update pros_ku_jpb7 set sub = "+temp1+" where jumlah_lt = 10 and tahun = '"+tahunDBKB+"'";
              DBFetching.setComandToDB(sql);
              
              //proses kurang dari 10
              for(int i = 1; i < 10; i++)
              {
                  sql = "update pros_ku_jpb7 set sub = str_cum*"+temp3+" where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'";
                  DBFetching.setComandToDB(sql);
              }
              
              //proses lebih 10
              for(double i = 11; i < 15 ;i++)
              {
                double tempPre1 = DBFetching.getDoubleResult("select sub from pros_ku_jpb7 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select sub from pros_ku_jpb7 where jumlah_lt = "+(i-2)+" and tahun = '"+tahunDBKB+"'");  
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
                
                sql = "update pros_ku_jpb7 set sub = "+tempHasil+" where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
              }
              
            //proses PreCast
              sql = "update pros_ku_jpb7 set precast = (sub+str_cum)*persen where tahun = '"+tahunDBKB+"'";
              DBFetching.setComandToDB(sql);
              
            //proses Tot
              sql = "update pros_ku_jpb7 set tot = (sub+precast+str_cum)+"+this.PPN_PERSEN+"*(sub+precast+str_cum) where tahun = '"+tahunDBKB+"'";
              DBFetching.setComandToDB(sql);
              
            //proses Area
              for(double i = 11; i < 15 ;i++)
              {
                double tempPre1 = DBFetching.getDoubleResult("select area from pros_ku_jpb7 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select area from pros_ku_jpb7 where jumlah_lt = "+(i-2)+" and tahun = '"+tahunDBKB+"'");  
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
                
                sql = "update pros_ku_jpb7 set area = "+tempHasil+" where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
              }
              
              
            //proses DBKB
              sql = "update pros_ku_jpb7 set dbkb = tot/area where tahun = '"+tahunDBKB+"' and area > 0";
              DBFetching.setComandToDB(sql);
              
              
               sql = "update pros_ku_jpb7,pros_dbkb_jpb2 set dbkb = dbkb_kumulatif "
                     + "where jumlah_lantai > 14 "
                     + "and jumlah_lantai = jumlah_lt "
                     + "and pros_ku_jpb7.tahun = '"+tahunDBKB+"'"
                     + "and pros_dbkb_jpb2.tahun = '"+tahunDBKB+"'";
               DBFetching.setComandToDB(sql);
              
              
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
    }
    
    public void prosesDbkbJpb7()
    {
        try{
        
            for(int i = 1; i < 11; i++)
            {
                String sql = "update pros_dbkb_jpb7 set dbkb_perlantai = "+nilaiDBKB/10+" where pros_dbkb_jpb7.tahun = '"+tahunDBKB+"' "
                        + "and jumlah_lt = "+i+"";
                DBFetching.setComandToDB(sql);
            }
            
            String sql = "update pros_ku_jpb7,pros_dbkb_jpb7 set dbkb_kumulatif = dbkb "
                        + "where pros_ku_jpb7.jumlah_lt = pros_dbkb_jpb7.jumlah_lt "
                        + "and pros_ku_jpb7.tahun = '"+tahunDBKB+"'"
                        + "and pros_dbkb_jpb7.tahun = '"+tahunDBKB+"'";
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
