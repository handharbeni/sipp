/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.bandara;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.PenilaianBangunan;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesPenilaianBandara {
    
    public static void prosesNjopTanah(String nop, String tahun, double nir,double luas,String jp_tanah)
    {
        DBFetching.setAutoCommit(false);
        
        try{
            //delete data lama
            String sql = "DELETE FROM `rslt_nilai_tanah_bandara` "
                    + "WHERE `nop`='"+nop+"' and `tahun`='"+tahun+"' and `jp_tanah`='"+jp_tanah+"';";
            DBFetching.setComandToDB(sql);
            
            
            //cari kelas tanah dan nilainya
        double nilaiTanah = 0;
        sql = "select * from kelas_tanah where \n" +
              "('"+tahun+"' between THN_AWAL_KELAS_TANAH \n" +
              "and THN_AKHIR_KELAS_TANAH) and "+nir+"/1000 \n" +
              "\n" +
              "between NILAI_MIN_TANAH\n" +
              " and NILAI_MAX_TANAH and KD_KELAS_TANAH NOT LIKE 'XXX'";
        
        ResultSet set = DBFetching.getResultSet(sql);
        while(set.next())
        {
            nilaiTanah = set.getDouble(6)*1000;
        }
        
        double nilTotal = luas*nilaiTanah;
        
        sql = "INSERT INTO `rslt_nilai_tanah_bandara` "
                + "(`nop`, `tahun`, `jp_tanah`, `luas`, `nir`, `nilPerM`, `nilTotal`) "
                + "VALUES ('"+nop+"', '"+tahun+"', "
                + "'"+jp_tanah+"', '"+luas+"', "
                + "'"+nir+"', '"+nilaiTanah+"', '"+nilTotal+"');";
        DBFetching.setComandToDB(sql);
        
        DBFetching.Simpan();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
    }
    
    public static void prosesNjopBngKhusus(String nop, String tahun, double nilPerM2, double luas, String jpb)
    {
        DBFetching.setAutoCommit(false);
        
        try{
            //delete data lama
            String sql = "DELETE FROM `rslt_nilai_bngkhusus_bandara` "
                    + "WHERE `nop`='"+nop+"' and `tahun`='"+tahun+"' and `jp_bangunan`='"+jpb+"';";
            DBFetching.setComandToDB(sql);
        
            double nilTotal = luas*nilPerM2;
        
        sql = "INSERT INTO `rslt_nilai_bngkhusus_bandara` "
                + "(`nop`, `tahun`, `jp_bangunan`, `luas`, `nilai_perM`, `nilai_total`) "
                + "VALUES ('"+nop+"', "
                + "'"+tahun+"', "
                + "'"+jpb+"', "
                + "'"+luas+"', "
                + "'"+nilPerM2+"', '"+nilTotal+"');";
        DBFetching.setComandToDB(sql);
        
        DBFetching.Simpan();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
  
    }

    public static void prosesNjopBngPTDbkb(String nop, String tahun, String jpb,double luas)
    {
        
        try{
            
            DBFetching.setAutoCommit(false);
            //delete data lama
            String sql = "DELETE FROM `rslt_nilai_bngpt_dbkb_bandara` "
                    + "WHERE "
                    + "`nop`='"+nop+"' "
                    + "and`tahun`='"+tahun+"' "
                    + "and`jpb`='"+jpb+"'";
            DBFetching.setComandToDB(sql);
            
             //menilai bangunan dengan lspop-non-standar
            PenilaianBangunan nilaiBangunan = new PenilaianBangunan(nop,tahun);
            nilaiBangunan.mulaiPenilaian();
            
            
            
             ArrayList <LspopNonStandar> lspopNonStdArr = new ArrayList <LspopNonStandar>();
             ArrayList <NilaiBangunan> nilaiBngArr = new ArrayList <NilaiBangunan>();
             
             ToolsPenilaian.ambilLspopFromDbPerNop(nop, lspopNonStdArr);
             nilaiBngArr = ToolsPenilaian.ambilNilBngFromDB(tahun, nop);
             
             
            
             //jadikan hashmap nilaiBngArr
             HashMap <String,NilaiBangunan> mapNilaiBngArr = new HashMap <String,NilaiBangunan>();
             
             for(int i = 0; i < nilaiBngArr.size();i++)
             {
                 mapNilaiBngArr.put(nilaiBngArr.get(i).getJpb(), nilaiBngArr.get(i));
             }
                     
             for(int i = 0; i < lspopNonStdArr.size();i++)
             {
                 NilaiBangunan tempNilBng = mapNilaiBngArr.get(lspopNonStdArr.get(i).getJpb());
                 
                    String stempNilBng = new DecimalFormat("#.####").
                            format(tempNilBng.getNilaiBngStlhSusut()/tempNilBng.getLuasBng());
                    double dtempNilBng = Double.parseDouble(stempNilBng);
                   
                 sql = "select KD_KELAS_BANGUNAN,NILAI_PER_M2_BANGUNAN from kelas_bangunan where \n" +
                     "('"+tahun+"' between THN_AWAL_KELAS_BNGN\n" +
                     "and THN_AKHIR_KELAS_BNGN) and "+stempNilBng+"/1000 \n" +
                     "between NILAI_MIN_BANGUNAN\n" +
                     " and NILAI_MAX_BANGUNAN and KD_KELAS_BANGUNAN NOT LIKE 'XXX';";
                 
                 String kelasBangunan = DBFetching.getStringResult(sql, 1);
                 double njopPerM2Bangunan = Double.parseDouble(DBFetching.getStringResult(sql, 2))*1000;
                 
                 double nilTotal = tempNilBng.getLuasBng()*njopPerM2Bangunan;
                //insert data
                sql = "INSERT INTO `rslt_nilai_bngpt_dbkb_bandara` "
                        + "(`nop`, `tahun`, `jpb`, `luas`, `nilai_bangunan`,`nilai_njop`) "
                        + "VALUES "
                        + "('"+nop+"', "
                        + "'"+tahun+"', "
                        + "'"+lspopNonStdArr.get(i).getJpb()+"', "
                        + "'"+tempNilBng.getLuasBng()+"', "
                        + "'"+tempNilBng.getNilaiBngStlhSusut()+"'," 
                        + "'"+nilTotal+"')";
                DBFetching.setComandToDB(sql);
             }
            
             
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
    }
    
    public static void prosesNjopLspop(String nop, String tahun, int no_bng, double nilPerM, double luas)
    {
        DBFetching.setAutoCommit(false);
        try{
           
           String sql = "DELETE FROM `rslt_nilai_lspop_bandara` "
                    + "WHERE `nop`='"+nop+"' and`no_bng`='"+no_bng+"' and`tahun`='"+tahun+"';";
           DBFetching.setComandToDB(sql);
            
           double total = nilPerM*luas;
           
           sql = "INSERT INTO `rslt_nilai_lspop_bandara` "
                    + "(`nop`, `no_bng`, `tahun`, `nilai_per_m`, `total`) "
                    + "VALUES "
                    + "('"+nop+"', '"+no_bng+"', '"+tahun+"', '"+nilPerM+"', '"+total+"');";
           DBFetching.setComandToDB(sql);
           
           DBFetching.Simpan();
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
    }
}
