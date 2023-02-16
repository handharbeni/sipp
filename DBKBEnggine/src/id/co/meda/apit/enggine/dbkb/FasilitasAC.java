/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk menghitung harga dari Fasilitas AC dengan pk 2
 * @author I Putu Medagia A
 */
public class FasilitasAC {

private String tahunDBKB;   
private final double LUAS_LANTAI_ACSENTRAL = 32362;
private final int JUMLAH_LANTAI_ACSENTRAL = 5;
private final double LUAS_TANAH_ACSENTRAL = 10386;
private double konversiACSentral = 0;

public FasilitasAC(String tahunDBKB)    
{
    this.tahunDBKB = tahunDBKB;
    DBFetching.setAutoCommit(false);
}    

/**
 * method ini digunakan untuk memproses harga dari fasilitas AC 
 */
public void prosesACSplit()
{
     Queue <Double> ACsplit = new LinkedList<Double>();
     Queue <Double> ACwindow = new LinkedList<Double>();
     Queue <Double> ACfloor = new LinkedList<Double>();
     Queue <Double> ACpk = new LinkedList<Double>();
    
     Queue <Double> AktualACsplit = new LinkedList<Double>();
     Queue <Double> AktualACwindow = new LinkedList<Double>();
     Queue <Double> AktualACfloor = new LinkedList<Double>();
   
   //Mengambil data dari database pros_ACSplit  
   try {
        double refSplit = DBFetching.getDoubleResult("select hrg_split from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"' ");
        double refWindow = DBFetching.getDoubleResult("select hrg_window from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"'");
        double reffloor = DBFetching.getDoubleResult("select hrg_floor from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"'");
        double refSplit2 = DBFetching.getDoubleResult("select ak_split from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"'");
        double refWindow2 = DBFetching.getDoubleResult("select ak_window from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"'");
        double reffloor2 = DBFetching.getDoubleResult("select ak_floor from pros_acsplit where pk = '2' "
                    + "and Tahun = '"+tahunDBKB+"'");
            
        ResultSet result = DBFetching.getResultSet("select * from pros_acsplit");
            
        while(result.next())
        {
          ACpk.add(result.getDouble(1));
          ACsplit.add((result.getDouble(3)/refSplit)*100);
          ACwindow.add((result.getDouble(2)/refWindow)*100);
          ACfloor.add((result.getDouble(4)/reffloor)*100);                           
                
          AktualACsplit.add(((result.getDouble(6)/100)*refSplit2));
          AktualACwindow.add(((result.getDouble(5)/100)*refWindow2));
          AktualACfloor.add(((result.getDouble(7)/100)*reffloor2));
        }
            
       }catch(Exception e)
       {
           e.printStackTrace();
           DBFetching.RollBackDB();
           JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data pda proses perhitungan Fasilitas AC Split",
                   "Error 221",JOptionPane.ERROR_MESSAGE);
       }
   
       try{
            while(ACsplit.size() > 0)
            {
                DBFetching.setComandToDB("UPDATE "
                        + "`pros_acsplit` "
                        + "SET "
                        + "`kompHrg_window`='"+ACwindow.remove()+"', "
                        + "`kompHrg_split`='"+ACsplit.remove()+"', "
                        + "`kompHrg_floor`='"+ACfloor.remove()+"', "
                        + "ak_split = '"+ AktualACsplit.remove()+"', "
                        + "ak_window = '"+AktualACwindow.remove()+"', "
                        + "ak_floor = '"+AktualACfloor.remove()+"'  "
                        + "WHERE "
                        + "`pk`='"+ACpk.remove()+"' and Tahun = '"+tahunDBKB+"'");
            
               
            }
            
        } catch (Exception ex) {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengupdate dan menghitung harga proses perhitungan Fasilitas AC Split",
                   "Error 222",JOptionPane.ERROR_MESSAGE);
        }
}

public void prosesACSentral()
{
    
    try{
        String sql = "update pros_facsentral set model_jmlhharga = (model_harga*model_jumlah) "
                + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);

        double sumJmlhHargaModel =  DBFetching.getDoubleResult("select sum(model_jmlhharga) "
                                         + "from pros_facsentral where tahun = '"+tahunDBKB+"'");
       

        sql = "update pros_facsentral set model_bobot = ((model_jmlhharga/"+sumJmlhHargaModel+")/100) "
                + "where tahun = '"+tahunDBKB+"' and id_other not like '%NO%'";
        DBFetching.setComandToDB(sql);

        sql = "update pros_facsentral,ref_dhkmf set aktual_harga = hrg_dhkm where kd_dhkm = id_other "
               +" and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'"
               +" and pros_facsentral.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);

        sql = "update pros_facsentral set aktual_jmlhharga = (aktual_harga*model_jumlah) "
                + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
         double sumJmlhBobotModel =  DBFetching.getDoubleResult("select sum(model_bobot) "
                                         + "from pros_facsentral where tahun = '"+tahunDBKB+"'");
         
        double sumJmlhHargaAktual = DBFetching.getDoubleResult("select sum(aktual_jmlhharga) "
                                         + "from pros_facsentral where tahun = '"+tahunDBKB+"'");
        
        
         System.out.println("select sum(model_bobot) "
                                         + "from pros_facsentral where tahun = '"+tahunDBKB+"'");
        
        
         double sumJmlhHargaLain = (sumJmlhHargaAktual/sumJmlhBobotModel)-sumJmlhHargaAktual;
         double subTotal = sumJmlhHargaAktual+sumJmlhHargaLain;
       
         
         double ppn = 0.1*subTotal;
         double fee = 0.3*subTotal;
         double total = subTotal+ ppn+fee;
        
         this.konversiACSentral = total/this.LUAS_LANTAI_ACSENTRAL;
         
         
        
        
    }catch(Exception e)
    {
        DBFetching.RollBackDB();
        e.printStackTrace();
        System.exit(1);
    }
    
}


public void prosesBandingAC()
{
  try{  
  double baseBiaya = DBFetching.getDoubleResult("select komp_biaya from pros_facbanding where "
                                                + " id_AcBanding = 'JPB400' and "
                                                + " tahun = '"+tahunDBKB+"'");
  
  String sql = "update pros_facbanding set komp_bobot = (komp_biaya/"+baseBiaya+")/100 where tahun = '"+tahunDBKB+"'";
  DBFetching.setComandToDB(sql);
  
  sql = "update pros_facbanding set aktual = (komp_bobot*"+konversiACSentral+") where tahun ='"+tahunDBKB+"'";
  System.out.println(sql);
  DBFetching.setComandToDB(sql);
  
  }catch(Exception e)
  {
      e.printStackTrace();
      DBFetching.RollBackDB();
      System.exit(1);
  }
  
}

public void prosesResultAc()
{
    try{
        String sql = "select ak_split from pros_acsplit where ak_split not like '0' and tahun = '"+tahunDBKB+"'";
        Stack<Double> stackAcSplit = DBFetching.getStackResult(sql,1);
        
        sql = "select ak_window from pros_acsplit where ak_window not like '0' and tahun = '"+tahunDBKB+"'";
        Stack<Double> stackAcWindow = DBFetching.getStackResult(sql,1);
        
        sql = "select ak_floor from pros_acsplit where ak_floor not like '0' and tahun = '"+tahunDBKB+"'";
        Stack<Double> stackAcFloor = DBFetching.getStackResult(sql,1);
        
        sql = "select aktual from pros_facbanding where id_acbanding not like '%BLN000%' "
               + " and tahun = '"+tahunDBKB+"'"; 
        Stack<Double> stackAcBanding = DBFetching.getStackResult(sql,1);

        Stack idAcSplit = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FCA%'"
                                                            + " and id not like '%FCA000%'"
                                                            + " and tahun = '"+tahunDBKB+"'",1);
        Stack idAcWindow = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FCB%'"
                                                            + " and id not like '%FCB000%'"
                                                            + " and tahun = '"+tahunDBKB+"'",1);
        Stack idAcFloor = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FCC%'"
                                                            + " and id not like '%FCC000%'"
                                                            + " and tahun = '"+tahunDBKB+"'",1);
        
        Stack idAcBanding = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FCL%'"
                                                            + " and id not like '%FCL000%'"
                                                            + " and tahun = '"+tahunDBKB+"'",1);
        
            
        //AC split,window,floor
        while(!stackAcSplit.isEmpty())
        {
            sql = "update rslt_fasilitas set Harga = "+stackAcSplit.pop()+" where id = '"+idAcSplit.pop()+"'"
                    + " and tahun = '"+tahunDBKB+"'";
            
            DBFetching.setComandToDB(sql);
        }
        
        while(!stackAcWindow.isEmpty())
        {
            sql = "update rslt_fasilitas set Harga = "+stackAcWindow.pop()+" where id = '"+idAcWindow.pop()+"'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }

        while(!stackAcFloor.isEmpty())
        {
            sql = "update rslt_fasilitas set Harga = "+stackAcFloor.pop()+" where id = '"+idAcFloor.pop()+"'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }
        
        
        //Proses ACSentral
        while(!stackAcBanding.isEmpty())
        {
            sql = "update rslt_fasilitas set Harga = "+stackAcBanding.pop()+" where id = '"+idAcBanding.pop()+"'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }
        
    }catch(Exception e)
    {
        e.printStackTrace();
        DBFetching.RollBackDB();
        System.exit(1);
    }
   
}






/**
 * method untuk format angka tipe double
 * @param num input angka yang di format
 * @return number yang sudah di format
 */

/*
public double formatNumber(double num)
{
    System.out.println(num);
    try{
        DecimalFormat DecForm = new DecimalFormat("#.##");
        return Double.valueOf(DecForm.format(num));
    }catch(Exception e)
    {
      DBFetching.RollBackDB();  
      JOptionPane.showMessageDialog(new JFrame(),"gagal memformat angka pada proses Fasilitas AC Split",
        "Error 223",JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
    
    return 0.0;
}
*/

public void done()
{
    DBFetching.Simpan();
}

}
