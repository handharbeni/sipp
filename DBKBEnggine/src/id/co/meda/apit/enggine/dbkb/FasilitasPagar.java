/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.Stack;

/**
 *
 * @author I Putu Medagia A
 */
public class FasilitasPagar {
    String tahunDBKB;
    
    
    public FasilitasPagar(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesKomponenHarga()
    {
        try{
            
    //---------------------proses harga model dan jumlah harga model Batako dan Bata-------------------------------//
            String sql = "update pros_pagar_kompharga set model_harga = (2/3)*33000 where "
                    + " id = 'PBA002'"
                    + " and id = 'PBO002'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
            //update jumlah harga model
            String sqlUpJmlhHrg = "update pros_pagar_kompharga set model_jmlhHarga = model_harga*model_jumlah where "
                                  + " tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sqlUpJmlhHrg);
            
            
            //variable untuk menyimpan hasil penjumlahan
            String sqlSumPBO = "select sum(model_jmlhharga) from pros_pagar_kompharga "
                                + "where id in ('PBO001','PBO002') and tahun = '"+tahunDBKB+"'"; 
            String sqlSumPBA = "select sum(model_jmlhharga) from pros_pagar_kompharga "
                                + "where id in ('PBA001','PBA002') and tahun = '"+tahunDBKB+"'";   
            
            double tempSumPBO = DBFetching.getDoubleResult(sqlSumPBO);
            double tempSumPBA = DBFetching.getDoubleResult(sqlSumPBA);
            
            sql = "update pros_pagar_kompharga set model_harga = "+tempSumPBO+"*0.5 where id = 'PBO003'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_pagar_kompharga set model_harga = "+tempSumPBA+"*0.5 where id = 'PBA003'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //update jumlah harga model
            DBFetching.setComandToDB(sqlUpJmlhHrg);
            
            
            sqlSumPBO = "select sum(model_jmlhharga) from pros_pagar_kompharga "
                                + "where id in ('PBO001','PBO002','PBO003') and tahun = '"+tahunDBKB+"'"; 
            sqlSumPBA = "select sum(model_jmlhharga) from pros_pagar_kompharga "
                                + "where id in ('PBA001','PBA002','PBA003') and tahun = '"+tahunDBKB+"'";  
            
            tempSumPBO = DBFetching.getDoubleResult(sqlSumPBO);
            tempSumPBA = DBFetching.getDoubleResult(sqlSumPBA);
            
           
            
            sql = "update pros_pagar_kompharga set model_harga = "+tempSumPBO+"*0.3 where id = 'PBO004'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_pagar_kompharga set model_harga = "+tempSumPBA+"*0.3 where id = 'PBA004'"
                    + " and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //update jumlah harga model
            DBFetching.setComandToDB(sqlUpJmlhHrg);
            
      //-----------------Proses Bobot bata dan batako--------------------------------------//
            //variabael acuan harga model
            double tempAcuanBata = DBFetching.getDoubleResult("select model_harga from pros_pagar_kompharga "
                                                              + "where id = 'PBA001' "
                                                              + "and tahun = '"+tahunDBKB+"'");
            double tempAcuanBatako = DBFetching.getDoubleResult("select model_harga from pros_pagar_kompharga "
                                                              + "where id = 'PBO001' "
                                                              + "and tahun = '"+tahunDBKB+"'");
            
            sql = "update pros_pagar_kompharga set model_bobot = (model_harga)/"+tempAcuanBata+" "
                   + "where id like '%PBA%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_pagar_kompharga set model_bobot = (model_harga)/"+tempAcuanBatako+" "
                   + "where id like '%PBO%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
       //---------------------------------------Proses Harga Aktual---------------------------------//
             //variabael acuan harga aktual
            tempAcuanBatako =  DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf "
                                                              + "where kd_dhkm = 'F05001' "
                                                              + "and thn_dhkm = '"+tahunDBKB+"'");
            tempAcuanBata =  DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf "
                                                              + "where kd_dhkm = 'M02002' "
                                                              + "and thn_dhkm = '"+tahunDBKB+"'");
            sql = "update pros_pagar_kompharga set aktual_harga = (model_bobot)*"+tempAcuanBata+" "
                   + "where id like '%PBA%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_pagar_kompharga set aktual_harga = (model_bobot)*"+tempAcuanBatako+" "
                   + "where id like '%PBO%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
      //---------------------------------------Proses jumlah Harga Aktual---------------------------------//
            
             sql = "update pros_pagar_kompharga set aktual_jmlhharga = (aktual_harga*aktual_jumlah) "
                   + "where id like '%PBO%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
    }
    
    
    public void prosesVariasiTinggi()
    {
        try{
             //proses bata
            double tempBahan = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBA001' and tahun = '"+tahunDBKB+"'");
            double modelBeton = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBA002' and tahun = '"+tahunDBKB+"'");
            double material = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBA003' and tahun = '"+tahunDBKB+"'");
            double upah = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBA004' and tahun = '"+tahunDBKB+"'");
            
            String sql = "update pros_pagar_variasitinggi set "
                    + "harga_bataorbatako = (jumlah_bataorbatako*"+tempBahan+"), "
                    + "harga_kolombeton = (jumlah_kolombeton*"+modelBeton+"), "
                    + "harga_material = (jumlah_material*"+material+"), "
                    + "harga_upah = (jumlah_upah*"+upah+") "
                    + "where tahun = '"+tahunDBKB+"' and id like '%PBA%'";
            DBFetching.setComandToDB(sql);
            
            //proses batako
            tempBahan = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBO001' and tahun = '"+tahunDBKB+"'");
            modelBeton = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBO002' and tahun = '"+tahunDBKB+"'");
            material = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBO003' and tahun = '"+tahunDBKB+"'");
            upah = DBFetching.getDoubleResult("select model_jmlhharga from pros_pagar_kompharga "
                                                          + "where id = 'PBO004' and tahun = '"+tahunDBKB+"'");
            
            sql = "update pros_pagar_variasitinggi set "
                    + "harga_bataorbatako = (jumlah_bataorbatako*"+tempBahan+"), "
                    + "harga_kolombeton = (jumlah_kolombeton*"+modelBeton+"), "
                    + "harga_material = (jumlah_material*"+material+"), "
                    + "harga_upah = (jumlah_upah*"+upah+") "
                    + "where tahun = '"+tahunDBKB+"' and id like '%PBO%'";
            DBFetching.setComandToDB(sql);
            
            //proses semua harga
            
            sql = "update pros_pagar_variasitinggi set "
                  + "harga = "
                  + "(harga_bataorbatako+harga_kolombeton+harga_material+harga_upah)"
                  + "+(0.3*(harga_bataorbatako+harga_kolombeton+harga_material+harga_upah))"
                  + " where tahun = '"+tahunDBKB+"'";
           
             DBFetching.setComandToDB(sql);
            
            //proses semua bobot
            double tempHargaAcuanBata = DBFetching.getDoubleResult("select harga from pros_pagar_variasitinggi "
                                                                   +"where id = 'PBA001' and tahun = '"+tahunDBKB+"'");
            double tempHargaAcuanBatako = DBFetching.getDoubleResult("select harga from pros_pagar_variasitinggi "
                                                                   +"where id = 'PBO001' and tahun = '"+tahunDBKB+"'");
             
            sql = "update pros_pagar_variasitinggi set bobot = (harga/"+tempHargaAcuanBata+") where id like '%PBA%' "
                  + "and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_pagar_variasitinggi set bobot = (harga/"+tempHargaAcuanBatako+") where id like '%PBO%' "
                  + "and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            //proses aktual bata
           tempHargaAcuanBata = DBFetching.getDoubleResult("select sum(aktual_jmlhharga)*1.1 from pros_pagar_kompharga "
                                + "where id like '%PBA%' and tahun = '"+tahunDBKB+"'");
           
           sql = "update pros_pagar_variasitinggi set aktual = "+tempHargaAcuanBata+ "where id ='PBA001' "
                  + "and tahun = '"+tahunDBKB+"'";
           DBFetching.setComandToDB(sql);
           
           sql = "update pros_pagar_variasitinggi set aktual = (bobot*"+tempHargaAcuanBata+") where "
                  + "id in('PBA002','PBA003','PBA004','PBA005') "
                  + "and tahun = '"+tahunDBKB+"'";
           DBFetching.setComandToDB(sql);
           
            //proses aktual batako
            tempHargaAcuanBatako = DBFetching.getDoubleResult("select sum(aktual_jmlhharga)*1.1 from pros_pagar_kompharga "
                                + "where id like '%PBO%' and tahun = '"+tahunDBKB+"'");
          
           sql = "update pros_pagar_variasitinggi set aktual = "+tempHargaAcuanBatako+ "where id ='PBO001' "
                  + "and tahun = '"+tahunDBKB+"'";
           DBFetching.setComandToDB(sql);
           
           sql = "update pros_pagar_variasitinggi set aktual = (bobot*"+tempHargaAcuanBatako+") where "
                  + "id in('PBO002','PBO003','PBO004','PBO005') "
                  + "and tahun = '"+tahunDBKB+"'";
           DBFetching.setComandToDB(sql);
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
    }
    
    
    public void prosesPagarLain()
    {
        try{
    //-----------------------------Proses Bobot dan Kosong----------------------//
    
        //proses beton pracetak
        String sql = "select model_harga from pros_pagar_lain where id = 'PBN001' and tahun = '"+tahunDBKB+"'";    
        double tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set bobot = (model_harga/"+tempHarga+") where "
                + "id like '%PBN%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F05002' and thn_dhkm = '"+tahunDBKB+"'";    
        tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set aktual_harga = (bobot*"+tempHarga+") where "
                + "id like '%PBN%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //proses besi
        sql = "select model_harga from pros_pagar_lain where id = 'PBS001' and tahun = '"+tahunDBKB+"'";    
        tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set bobot = (model_harga/"+tempHarga+") where "
                + "id like '%PBS%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F05003' and thn_dhkm = '"+tahunDBKB+"'";    
        tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set aktual_harga = (bobot*"+tempHarga+") where "
                + "id like '%PBS%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //proses brc
        sql = "select model_harga from pros_pagar_lain where id = 'PBR001' and tahun = '"+tahunDBKB+"'";    
        tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set bobot = (model_harga/"+tempHarga+") where "
                + "id like '%PBR%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F05004' and thn_dhkm = '"+tahunDBKB+"'";    
        tempHarga = DBFetching.getDoubleResult(sql);
        
        sql = "update pros_pagar_lain set aktual_harga = (bobot*"+tempHarga+") where "
                + "id like '%PBR%' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //---------------------------proses harga ppnfee---------------------------//
        sql = "update pros_pagar_lain set aktual_hargappnfee = (aktual_harga*1.1)+(aktual_harga*0.3) where "
                + " tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
          
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    
    public void prosesResult()
    {
        try{
            //proses batako
            String sql = "select aktual from pros_pagar_variasitinggi where id like '%PBO%' and tahun = '"+tahunDBKB+"'";
            Stack stAktual = DBFetching.getStackResult(sql, 1);
            
            sql = "select id from rslt_fasilitas where id like '%FPA%' "
                    + "and tahun = '"+tahunDBKB+"' "
                    + "and id not like '%FPA000%'";
            Stack stId = DBFetching.getStackResult(sql, 1);
            
            while(!stId.isEmpty())
            {
                sql = "update rslt_fasilitas set "
                     + "harga = '"+stAktual.pop()+"'"
                     + "where id = '"+stId.pop()+"' and tahun = '"+tahunDBKB+"'";
            
                DBFetching.setComandToDB(sql);
            }
            
            //proses bata
            sql = "select aktual from pros_pagar_variasitinggi where id like '%PBA%' and tahun = '"+tahunDBKB+"'";
            stAktual = DBFetching.getStackResult(sql, 1);
            
            sql = "select id from rslt_fasilitas where id like '%FPB%' "
                    + "and tahun = '"+tahunDBKB+"' "
                    + "and id not like '%FPB000%'";
            stId = DBFetching.getStackResult(sql, 1);
            
            while(!stId.isEmpty())
            {
                sql = "update rslt_fasilitas set "
                     + "harga = '"+stAktual.pop()+"'"
                     + "where id = '"+stId.pop()+"' and tahun = '"+tahunDBKB+"'";
            
                DBFetching.setComandToDB(sql);
            }
            
            
            //proses beton pracetak
            sql = "select aktual_hargappnfee from pros_pagar_lain where id like '%PBN%' and tahun = '"+tahunDBKB+"'";
            stAktual = DBFetching.getStackResult(sql, 1);
            
            sql = "select id from rslt_fasilitas where id like '%FPC%' "
                    + "and tahun = '"+tahunDBKB+"' "
                    + "and id not like '%FPC000%'";
            stId = DBFetching.getStackResult(sql, 1);
            
            while(!stId.isEmpty())
            {
                sql = "update rslt_fasilitas set "
                     + "harga = '"+stAktual.pop()+"'"
                     + "where id = '"+stId.pop()+"' and tahun = '"+tahunDBKB+"'";
            
                DBFetching.setComandToDB(sql);
            }
            
            
            //proses besi
            sql = "select aktual_hargappnfee from pros_pagar_lain where id like '%PBS%' and tahun = '"+tahunDBKB+"'";
            stAktual = DBFetching.getStackResult(sql, 1);
            
            sql = "select id from rslt_fasilitas where id like '%FPD%' "
                    + "and tahun = '"+tahunDBKB+"' "
                    + "and id not like '%FPD000%'";
            stId = DBFetching.getStackResult(sql, 1);
            
            while(!stId.isEmpty())
            {
                sql = "update rslt_fasilitas set "
                     + "harga = '"+stAktual.pop()+"'"
                     + "where id = '"+stId.pop()+"' and tahun = '"+tahunDBKB+"'";
            
                DBFetching.setComandToDB(sql);
            }
            
            //proses brc
            sql = "select aktual_hargappnfee from pros_pagar_lain where id like '%PBR%' and tahun = '"+tahunDBKB+"'";
            stAktual = DBFetching.getStackResult(sql, 1);
            
            sql = "select id from rslt_fasilitas where id like '%FPE%' "
                    + "and tahun = '"+tahunDBKB+"' "
                    + "and id not like '%FPE000%'";
            stId = DBFetching.getStackResult(sql, 1);
            
            while(!stId.isEmpty())
            {
                sql = "update rslt_fasilitas set "
                     + "harga = '"+stAktual.pop()+"'"
                     + "where id = '"+stId.pop()+"' and tahun = '"+tahunDBKB+"'";
            
                DBFetching.setComandToDB(sql);
            }
            
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
