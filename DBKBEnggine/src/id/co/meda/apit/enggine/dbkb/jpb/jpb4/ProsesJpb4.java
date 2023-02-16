/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb4;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author meda
 */
public class ProsesJpb4 {
    
    private double nilaiDBKB;
    private double nilaiSanitary;
    private String tahunDBKB;
    private final double LUAS_BANGUNAN = 23561;
    private final double PPN_PERSEN = 0.2;
    
    
    
    
    /**
     * Constructor 
     * @param tahunDBKB 
     */
    public ProsesJpb4(String tahunDBKB)
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
            sql = "update pros_jpb4,pros_hsat set upah = hrg_upah*faktor,material = hrg_mat where kd_hsat = id_other and jenis_other = 'HSAT' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and pros_hsat.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //STR
            sql = "update pros_jpb4,pros_hsku set upah = hrg_upah*faktor, material = hrg_komp where kd_hsku = id_other and jenis_other = 'STR' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //MTR
            sql = "update pros_jpb4,ref_dhkmf set upah = 0*faktor, material = hrg_dhkm where kd_dhkm = id_other and jenis_other = 'MTR' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //JPB2
            sql = "update pros_jpb4,pros_jpb2_lt32 set upah = upah_jpb2lt32*faktor, material = material_jpb2lt32 where kd_jpb2lt32 = id_other and jenis_other = 'JPB2' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //JPBper100
            sql = "update pros_jpb4,pros_jpb2_lt32 set upah = (upah_jpb2lt32/100)*faktor, material = (material_jpb2lt32/100) where kd_jpb2lt32 = id_other and jenis_other = 'JPB2/100' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and tahun_jpb2lt32 = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //STRper100
            sql = "update pros_jpb4,pros_hsku set upah = (hrg_upah/100)*faktor, material = (hrg_komp/100) where kd_hsku = id_other and jenis_other = 'STR/100' "
                    + "and pros_jpb4.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //update cost
            sql = "update pros_jpb4 set cost = (upah+material)*quantity where pros_jpb4.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_jpb4 set cost = (upah+material)*quantity/3 where pros_jpb4.tahun = '"+tahunDBKB+"' and id like '%C1%' "
                    + "or id like '%C2%' or id like '%C3%' or id like '%C4%'";
            DBFetching.setComandToDB(sql);
                
            
            //update Preliminaries
            double sumMaterial = DBFetching.getDoubleResult("select sum(cost) from pros_jpb4 where tahun = '"+tahunDBKB+"' and id not like '%A0001%'");
            sql = "update pros_jpb4 set material = "+sumMaterial+" where pros_jpb4.tahun = '"+tahunDBKB+"' and id like '%A0001%'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_jpb4 set cost = material*quantity where pros_jpb4.tahun = '"+tahunDBKB+"' and id like '%A0001%'";
            DBFetching.setComandToDB(sql);
            
            
            
            //proses Hitung DBKB
            double jumlah = DBFetching.getDoubleResult("select sum(cost) from pros_jpb4 where tahun = '"+tahunDBKB+"'");
            double ppnFee = jumlah*this.PPN_PERSEN;
            double imb = jumlah*0.02;
            double jumlahSubSuperStruktur = jumlah+ppnFee+imb;
            nilaiDBKB = jumlahSubSuperStruktur/this.LUAS_BANGUNAN;
            nilaiSanitary = nilaiDBKB*0.9816;
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    
    
    /**
     * method untuk menghitung nilai Komponen Utama
     */
    public void hitungKuJpb4()
    {
        try{
            String sql = "select sum(cost) from pros_jpb4 where id like '%C1%' and tahun = '"+tahunDBKB+"' group by substr(id,2,2)";

            ArrayList<Double> arrCostKu = DBFetching.getArrayListDoubleResult(sql,1);

            double tempLt2= DBFetching.getDoubleResult("SELECT sum(cost) FROM pros_jpb4 "
                    + "where id not like '%C3%' and id not like '%C4%' "
                    + "and id not like '%C5%' and id not like '%C6%' "
                    + "and id not like '%A%' and id not like '%B%' and tahun = '"+tahunDBKB+"'");
            
            double tempLt3 = DBFetching.getDoubleResult("SELECT sum(cost) FROM pros_jpb4 "
                    + "where id not like '%C6%' and id not like '%C5%' and id not like '%C4%' "
                    + "and id not like '%A%' and id not like '%B%' and tahun = '"+tahunDBKB+"'");
            
            double tempLt4 = DBFetching.getDoubleResult("SELECT sum(cost) FROM pros_jpb4 "
                    + "where id not like '%C6%' and id not like '%C5%' "
                    + "and id not like '%A%' and id not like '%B%' and tahun = '"+tahunDBKB+"'");

            double tempLt5 = DBFetching.getDoubleResult("SELECT sum(cost) FROM pros_jpb4 "
                    + "where id not like '%C6%' and id not like '%A%' and id not like '%B%' and tahun = '"+tahunDBKB+"'");
            double tempLt6 = DBFetching.getDoubleResult("SELECT sum(cost) FROM pros_jpb4 "
                    + "where id not like '%A%' and id not like '%B%' and tahun = '"+tahunDBKB+"'");

            arrCostKu.add(tempLt2);
            arrCostKu.add(tempLt3);
            arrCostKu.add(tempLt4);

            arrCostKu.add(tempLt5);
            arrCostKu.add(tempLt6);


            Stack<Double> stCostKu = new Stack<Double>();

            stCostKu.add(arrCostKu.get(arrCostKu.size()-1));
            stCostKu.add(arrCostKu.get(arrCostKu.size()-2));

            int count = DBFetching.getIntegerResult("select count(jumlah_lt) from pros_ku_jpb4 where tahun = '"+tahunDBKB+"'");

            
            for(int i = 0; i < arrCostKu.size();i++)
            {
                sql = "update pros_ku_jpb4 set STR_CUM = '"+arrCostKu.get(i)+"' where jumlah_lt = '"+(i+1)+"' and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
                
               
            }


            for(int i = 6; i < count;i++)
            {

                double temp1 = stCostKu.pop();
                double temp2 = stCostKu.pop();

                double result = (temp2/temp1)*temp2;
                stCostKu.add(result);
                stCostKu.add(temp2);

                sql = "update pros_ku_jpb4 set STR_CUM = '"+result+"' where jumlah_lt = '"+(i+1)+"' and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);

            }
            
            count = DBFetching.getIntegerResult("select count(jumlah_lt) from pros_ku_jpb4 where tahun = '"+tahunDBKB+"'");
           
            
            //Hitung STR_CUM
            
            for(double i = 6.0; i > 1.0 ;i--)
            {  
                double tempPre = DBFetching.getDoubleResult("select persen from pros_ku_jpb4 where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempHasil = ((i-1)/i)*tempPre;
            
                sql = "update pros_ku_jpb4 set persen = "+tempHasil+" where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            for(double i = 6.0; i < count ;i++)
            {  
                double tempPre1 = DBFetching.getDoubleResult("select persen from pros_ku_jpb4 where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select persen from pros_ku_jpb4 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
            
                sql = "update pros_ku_jpb4 set persen = "+tempHasil+" where jumlah_lt = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            
            
            //Hitung area
             for(double i = 6.0; i > 1.0 ;i--)
            {  
                double tempPre = DBFetching.getDoubleResult("select area from pros_ku_jpb4 where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempHasil = ((i-1)/i)*tempPre;
            
                sql = "update pros_ku_jpb4 set area = "+tempHasil+" where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            for(double i = 6.0; i < count ;i++)
            {  
                double tempPre1 = DBFetching.getDoubleResult("select area from pros_ku_jpb4 where jumlah_lt = "+i+" and tahun = '"+tahunDBKB+"'");
                double tempPre2 = DBFetching.getDoubleResult("select area from pros_ku_jpb4 where jumlah_lt = "+(i-1)+" and tahun = '"+tahunDBKB+"'");
                
                double tempHasil = (tempPre1/tempPre2)*tempPre1;
            
                sql = "update pros_ku_jpb4 set area = "+tempHasil+" where jumlah_lt = "+(i+1)+" and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
            }
            
            //Hitung Sub
            double tempSumSubStruktur = DBFetching.getDoubleResult("select sum(cost) from pros_jpb4 where id like '%B%' and tahun = '"+tahunDBKB+"'");
            double tempSumSuperStruktur = DBFetching.getDoubleResult("select sum(cost) from pros_jpb4 where id like '%C%' and tahun = '"+tahunDBKB+"'");
            
            double tempHasilBagi= tempSumSubStruktur/tempSumSuperStruktur;
            
            sql = "update pros_ku_jpb4 set sub = STR_CUM*"+tempHasilBagi+" where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //Hitung pre
            sql = "update pros_ku_jpb4 set pre = (sub+STR_CUM)*persen where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //Hitung tot
            sql = "update pros_ku_jpb4 set tot = (sub+pre+STR_CUM)+((sub+pre+STR_CUM)*"+this.PPN_PERSEN+") where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //Hitung dbkb
            sql = "update pros_ku_jpb4 set dbkb = (tot/area) where tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
            // update DBKB_Kumulatif
        sql = "update pros_dbkb_jpb4 as dbkb,rslt_ku_lbh_4lt as ku set "
                + "ku.jpb_4 = dbkb.dbkb_kumulatif where ku.jumlah_lantai <= 6 "
                + "and ku.jumlah_lantai = dbkb.lt_kumulatif and ku.thn_dbkb = '"+tahunDBKB+"' and dbkb.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
            
        
            DBFetching.Simpan();
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
        
    }
    
    /**
     * Method untuk hitung DBKB
     */
    public void hitungDbkbJpb4()
    {
        // update DBKB_Per_lantai
        String sql = "update pros_dbkb_jpb4 set dbkb_perlantai = "+this.nilaiDBKB/6+" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        // update DBKB_Kumulatif
        sql = "update pros_dbkb_jpb4 as dbkb,pros_ku_jpb4 as ku set "
                + "dbkb.dbkb_kumulatif = ku.dbkb where ku.jumlah_lt <= 6 "
                + "and ku.jumlah_lt = dbkb.lt_kumulatif and ku.tahun = '"+tahunDBKB+"' and dbkb.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        DBFetching.Simpan();
        
        
        
    }
    
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
    
    
    
}
