/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class prosesRsltMaterial {
    
    String sql;
    String thnDBKB;
    
     public prosesRsltMaterial(String thnDBKB)
     {
         this.thnDBKB = thnDBKB;
         DBFetching.setAutoCommit(false);
     }
     
     public void prosGolMaterial()
    {
     try{
        sql = "update ref_golmaterial,pros_hsat set harga = hrg_sat "
                + "where kd_hsat = hsat_id1 "
                + "and id_golMaterial !='DA0011' "
                + "and id_golMaterial !='DB0020' "
                + "and ref_golmaterial.tahun = '"+thnDBKB+"' and "
                + "pros_hsat.tahun = '"+thnDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        Double id1 = DBFetching.getDoubleResult("select hrg_sat from pros_hsat where kd_hsat = 'F000001' and tahun = '"+thnDBKB+"'");
        Double id2_1 = DBFetching.getDoubleResult("select hrg_sat from pros_hsat where kd_hsat = 'D000001' and tahun = '"+thnDBKB+"'");
        Double id2_2 = DBFetching.getDoubleResult("select hrg_sat from pros_hsat where kd_hsat = 'E000001' and tahun = '"+thnDBKB+"'");
        
        Double tot1_21 = id1+id2_1;
        Double tot1_22 = id1+id2_2;
        
         DBFetching.setComandToDB("update ref_golmaterial set harga = "
                +tot1_21+" where id_golMaterial ='DA0011' and tahun = '"+thnDBKB+"'");
         DBFetching.setComandToDB("update ref_golmaterial set harga = "
                +tot1_22+" where id_golMaterial ='DB0020' and tahun = '"+thnDBKB+"'");
     }catch(Exception e)
     {
         DBFetching.RollBackDB();
         e.printStackTrace();
         System.exit(1);
     }

 }
    
     public void prosesRsltMaterialA() 
    {
        try{
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AA%'"
                + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AA = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AB%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AB = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AC%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AC = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AD0040%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AD1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AD0041%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AD2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AE%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AE = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AF%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AF = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AG0070%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AG1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%AG0071%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_AG2 = DBFetching.getArrayListDoubleResult(sql,1);
            int id = 1;
            for(int i = 0; i < rslt_AA.size(); i++)
            {

                DBFetching.setComandToDB("update rslt_material set AA1 = "+rslt_AA.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AB1 = "+rslt_AB.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AC1 = "+rslt_AC.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AD1 = "+rslt_AD1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AD2 = "+rslt_AD2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AE1 = "+rslt_AE.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AF1 = "+rslt_AF.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AG1 = "+rslt_AG1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set AG2 = "+rslt_AG2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                id++;
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
         
            e.printStackTrace();
            System.exit(1);
        }
   
    }
    
     public void prosesRsltMaterialB() 
    {
        try{
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BA%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BA = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BB%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BB = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BC%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BC = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BD%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BD = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BE%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BE = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BF%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BF = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BG0070%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BG1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%BG0071%'" + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_BG2 = DBFetching.getArrayListDoubleResult(sql,1);
            int id = 1;
            for(int i = 0; i < rslt_BA.size(); i++)
            {

                DBFetching.setComandToDB("update rslt_material set BA1 = "+rslt_BA.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BB1 = "+rslt_BB.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BC1 = "+rslt_BC.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BD1 = "+rslt_BD.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BE1 = "+rslt_BE.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BF1 = "+rslt_BF.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BG1 = "+rslt_BG1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set BG2 = "+rslt_BG2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                id++;
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
         
            e.printStackTrace();
            System.exit(1);
        }
    }
     
    public void prosesRsltMaterialC()
    {
        try{
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CA%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CA = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CB0020%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CB1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CB0021%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CB2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CC0030%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CC1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CC0031%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CC2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CC0032%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CC3 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CD0040%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CD1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CD0041%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CD2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CD0042%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CD3 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CE%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CE = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CF%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CF = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%CG%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_CG = DBFetching.getArrayListDoubleResult(sql,1);
            
            int id = 1;
            for(int i = 0; i < rslt_CA.size(); i++)
            {

                DBFetching.setComandToDB("update rslt_material set CA1 = "+rslt_CA.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CB1 = "+rslt_CB1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CB2 = "+rslt_CB2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CC1 = "+rslt_CC1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CC2 = "+rslt_CC2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CC3 = "+rslt_CC3.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CD1 = "+rslt_CD1.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CD2 = "+rslt_CD2.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CD3 = "+rslt_CD3.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CE1 = "+rslt_CE.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CF1 = "+rslt_CF.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set CG1 = "+rslt_CG.get(i)+" where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                id++;
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
         
            e.printStackTrace();
            System.exit(1);
        }
    
    
        
    } 
    
    
    public void prosesRsltMaterialD()
    {
        try{
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DA0010%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DA1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DA0011%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DA2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DB0020%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DB1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DB0021%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DB2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DC0030%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DC1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DC0031%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DC2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DC0032%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DC3 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DC0033%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DC4 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DD0040%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DD1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DD0041%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DD2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DE%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DE = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DF0060%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DF1 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DF0061%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DF2 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DF0062%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DF3 = DBFetching.getArrayListDoubleResult(sql,1);
            sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DF0063%'"
                    + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DF4 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0070%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG1 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0071%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG2 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0072%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG3 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0073%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG4 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0074%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG5 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0075%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG6 = DBFetching.getArrayListDoubleResult(sql,1);
             sql = "select (faktor*harga) from ref_faktormaterial,ref_golmaterial where id_golMaterial like '%DG0076%'"
                     + "and ref_faktormaterial.tahun = '"+thnDBKB+"' and "
                    + "ref_golmaterial.tahun = '"+thnDBKB+"'";
            ArrayList <Double> rslt_DG7 = DBFetching.getArrayListDoubleResult(sql,1);
            
            int id = 1;
            for(int i = 0; i < rslt_DA1.size(); i++)
            {

                DBFetching.setComandToDB("update rslt_material set DA1 = "+rslt_DA1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DA2 = "+rslt_DA2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DB1 = "+rslt_DB1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DB2 = "+rslt_DB2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DC1 = "+rslt_DC1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DC2 = "+rslt_DC2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DC3 = "+rslt_DC3.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DC4 = "+rslt_DC4.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DD1 = "+rslt_DD1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DD2 = "+rslt_DD2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DE1 = "+rslt_DE.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DF1 = "+rslt_DF1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DF2 = "+rslt_DF2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DF3 = "+rslt_DF3.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DF4 = "+rslt_DF4.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG1 = "+rslt_DG1.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG2 = "+rslt_DG2.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG3 = "+rslt_DG3.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG4 = "+rslt_DG4.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG5 = "+rslt_DG5.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG6 = "+rslt_DG6.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                DBFetching.setComandToDB("update rslt_material set DG7 = "+rslt_DG7.get(i)+"where jmlh_lt = "+id+" and thn_rslt = '"+thnDBKB+"'");
                id++;
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
         
            e.printStackTrace();
            System.exit(1);
        }
    
    
        
    }
    
    public void done()
    {
       DBFetching.Simpan();
         
    }
    
}
