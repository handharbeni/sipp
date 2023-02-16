/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.bandara;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author I Putu Medagia A
 */
public class ToolsPenilaianBandara {
   
    
    public static void deleteLspopBandara(String nop, int id)
    {
        String sql = "DELETE FROM `lspop_bandara` WHERE "
                + "`id`='"+id+"' and`nop`='"+nop+"'";
        
        DBFetching.setComandToDB(sql);
    }
    
    public static LkokTanahBandara getModelLkokTanah(String nop)
    {
        LkokTanahBandara lkokTanah = null;
        
        try{
            lkokTanah = new LkokTanahBandara();
        
            //ambil dari db
            String sql = "SELECT * FROM lkok_tanah_bandara where nop = '"+nop+"'";
            ResultSet set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                lkokTanah.setNop(set.getString(1));
                lkokTanah.setNamaBandara(set.getString(2));
                lkokTanah.setAlamat(set.getString(3));
                lkokTanah.setLuasKomersial(Double.parseDouble(set.getString(4)));
                lkokTanah.setLuasNonKomersial(Double.parseDouble(set.getString(5)));
                lkokTanah.setLuasCadangan(Double.parseDouble(set.getString(6)));
                lkokTanah.setLuasArealLain(Double.parseDouble(set.getString(7)));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return lkokTanah;
    }
    
    public static boolean isiDbLkokTanah(LkokTanahBandara lkokTanah)
    {
        try{
            DBFetching.setAutoCommit(false);
            //delete first
            String sql = "DELETE FROM `lkok_tanah_bandara` WHERE `nop`='"+lkokTanah.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            //delete spop
            sql = "DELETE FROM `spop` WHERE `nop`='"+lkokTanah.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            //delete opkhusus
            sql = "DELETE FROM `cek_op_khusus` WHERE `nop`='"+lkokTanah.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            //insert to db
            sql = "INSERT INTO `lkok_tanah_bandara` "
                    + "(`nop`, `nama_bandara`, `alamat`, `ls_tanah_komersil`, "
                    + "`ls_tanah_nonkomersil`, `ls_tanah_cadangan`, `ls_tanah_lainnya`) "
                    + "VALUES ('"+lkokTanah.getNop()+"', "
                    + "'"+lkokTanah.getNamaBandara()+"', "
                    + "'"+lkokTanah.getAlamat()+"', "
                    + "'"+lkokTanah.getLuasKomersial()+"', "
                    + "'"+lkokTanah.getLuasNonKomersial()+"', "
                    + "'"+lkokTanah.getLuasCadangan()+"', "
                    + "'"+lkokTanah.getLuasArealLain()+"');";
            DBFetching.setComandToDB(sql);
            
            //insert ke table spop
            sql = "INSERT INTO `spop` (`nop`, `jalan_op`, `nama_wp`) "
                    + "VALUES ('"+lkokTanah.getNop()+"', "
                    + "'"+lkokTanah.getAlamat()+"', '"+lkokTanah.getNamaBandara()+"')";
            DBFetching.setComandToDB(sql);
            
            //insert to cekopkhusus
            sql = "INSERT INTO `cek_op_khusus` (`nop`, `jenis_op`) "
                    + "VALUES ('"+lkokTanah.getNop()+"', 'Bandara')";
            DBFetching.setComandToDB(sql);
            
             
                
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            return false;
        }
        
        DBFetching.Simpan();
        return true;
    }
    
    public static boolean isiDbLkokBangunan(LkokBangunanUmumBandara lkokBng)
    {
        try{
            
            DBFetching.setAutoCommit(false);
            //hapus lkok_umum
            String sql = "DELETE FROM `lkok_bangunan_umum_bandara` "
                    + "WHERE `nop`='"+lkokBng.getNop()+"';";
            DBFetching.setComandToDB(sql);
            
            //hapus lkok_khusus
            sql ="DELETE FROM `lkok_bangunan_khusus_bandara` "
                    + "WHERE `nop`='"+lkokBng.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            //insert lkok_bng_umum
            sql="INSERT INTO `lkok_bangunan_umum_bandara` "
                    + "(`nop`, `jpb_runway`, `jpb_taxiway`, `jpb_apron`, "
                    + "`jpb_inspeksi_lbh4`, `jpb_inspeksi_krg4`, `konstruksi`, "
                    + "`kondisi_umum`, `tahun_dibangun`, `tahun_renovasi`) VALUES "
                    + "('"+lkokBng.getNop()+"', "
                    + "'"+lkokBng.getJPB_runway()+"', "
                    + "'"+lkokBng.getJPB_taxiway()+"', "
                    + "'"+lkokBng.getJPB_apron()+"', "
                    + "'"+lkokBng.getJPB_inpeksiLbh4()+"', "
                    + "'"+lkokBng.getJPB_inpeksiKrg4()+"', "
                    + "'"+lkokBng.getKonstruksi()+"', "
                    + "'"+lkokBng.getKondUmum()+"', "
                    + "'"+lkokBng.getThnDibangun()+"', "
                    + "'"+lkokBng.getThnRenovasi()+"');";
            DBFetching.setComandToDB(sql);
            
            
            ArrayList <LkokBangunanKhususBandara> arrTemp = lkokBng.getArrLkokBng();
            
            for(int i = 0; i < arrTemp.size();i++)
            {
                LkokBangunanKhususBandara tempLkok = arrTemp.get(i);
                //insert lkok_bng_khusus
                sql="INSERT INTO `lkok_bangunan_khusus_bandara` "
                        + "(`nop`, `id_jpb_bandara`, `jpb_bandara`, `panjang`, `lebar`, `luas`, "
                        + "`perkerasan_kaku`, `perkerasan_lentur`) "
                        + "VALUES ('"+tempLkok.getNop()+"', "
                        + "'"+tempLkok.getIdJpb()+"', "
                        + "'"+tempLkok.getJpbBandara()+"', "
                        + ""+tempLkok.getPanjang()+", "
                        + ""+tempLkok.getLebar()+", "
                        + ""+tempLkok.getLuas()+", "
                        + ""+tempLkok.getPerkerasanKaku()+", "
                        + ""+tempLkok.getPerkerasanLentur()+");";
                DBFetching.setComandToDB(sql);
            }
            
            DBFetching.Simpan();
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            return false;
        }
    }
    
    public static LkokBangunanUmumBandara getModelLkokBangunan(String nop)
    {
        LkokBangunanUmumBandara lkokBng = null;
        try{
            
            lkokBng = new LkokBangunanUmumBandara();
            
            String sql = "SELECT * FROM lkok_bangunan_umum_bandara where nop ='"+nop+"'";
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                lkokBng.setNop(result.getString(1));
                lkokBng.setJPB_runway(result.getString(2));
                lkokBng.setJPB_taxiway(result.getString(3));
                lkokBng.setJPB_apron(result.getString(4));
                lkokBng.setJPB_inpeksiLbh4(result.getString(5));
                lkokBng.setJPB_inpeksiKrg4(result.getString(6));
                lkokBng.setKonstruksi(result.getString(7));
                lkokBng.setKondUmum(result.getString(8));
                lkokBng.setThnDibangun(result.getString(9));
                lkokBng.setThnRenovasi(result.getString(10));
            }
            
            ArrayList <LkokBangunanKhususBandara> tempArray = new ArrayList<LkokBangunanKhususBandara>(); 
            
            sql = "SELECT * FROM lkok_bangunan_khusus_bandara where nop ='"+nop+"'";
            result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                LkokBangunanKhususBandara lkokKhusus = new LkokBangunanKhususBandara();
                lkokKhusus.setNop(result.getString(1));
                lkokKhusus.setIdJpb(result.getString(2));
                lkokKhusus.setJpbBandara(result.getString(3));
                lkokKhusus.setPanjang(Double.parseDouble(result.getString(4)));
                lkokKhusus.setLebar(Double.parseDouble(result.getString(5)));
                lkokKhusus.setLuas(Double.parseDouble(result.getString(6)));
                lkokKhusus.setPerkerasanKaku(Double.parseDouble(result.getString(7)));
                lkokKhusus.setPerkerasanLentur(Double.parseDouble(result.getString(8)));
                
                tempArray.add(lkokKhusus);
                
            }
            
            lkokBng.setArrLkokBng(tempArray);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return lkokBng;
    }
    
    public static ArrayList<LspopBandara> getModelLspopBandara(String nop)
    {
        ArrayList<LspopBandara> arrLspopBandara = new ArrayList<LspopBandara>();
        try{
    
            String sql = "select count(*) FROM lspop_bandara where nop = '"+nop+"'";
            int count = DBFetching.getIntegerResult(sql);
            
            if(count > 0)
            {
                sql = "select * FROM lspop_bandara where nop = '"+nop+"'";
                ResultSet res = DBFetching.getResultSet(sql);
                
                while(res.next())
                {
                    LspopBandara temp = new LspopBandara();
                    temp.setNoBng(Integer.parseInt(res.getString(1)));
                    temp.setNop(res.getString(2));
                    temp.setJpb(res.getString(3));
                    temp.setLuas(Double.parseDouble(res.getString(4)));

                    arrLspopBandara.add(temp);
                }
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arrLspopBandara;
    }
    
      public static LspopBandara getModelLspopBandaraPerId(String nop,int id)
    {
       LspopBandara temp = new LspopBandara();
        try{
            
            String sql = "select * FROM lspop_bandara where nop = '"+nop+"' "
                    + "and no_bng = "+id+"";
            ResultSet res = DBFetching.getResultSet(sql);
            
            while(res.next())
            {
                
                temp.setNoBng(Integer.parseInt(res.getString(1)));
                temp.setNop(res.getString(2));
                temp.setJpb(res.getString(3));
                temp.setLuas(Double.parseDouble(res.getString(4)));
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return temp;
    }
    
    public static boolean isiLspopBandara(LspopBandara temp)
    {
        DBFetching.setAutoCommit(false);
        try{
                String sql = "DELETE FROM `lspop_bandara` "
                        + "WHERE `nop`='"+temp.getNop()+"' "
                        + "and`no_bng`= "+temp.getNoBng()+"";
            
                DBFetching.setComandToDB(sql);
                
                
                sql = "INSERT INTO `lspop_bandara` (`nop`,no_bng, `jpb`, `luas`) "
                        + "VALUES ("
                        + "'"+temp.getNop()+"', "
                        + "'"+temp.getNoBng()+"', "
                        + "'"+temp.getJpb()+"', "
                        + ""+temp.getLuas()+");";
                
                DBFetching.setComandToDB(sql);
            
                
            DBFetching.Simpan();
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            return false;
        }
            
    }
    
    
    public static ArrayList<PenilaianLspopBandara> getPenilLspopBandara(String nop,String tahun)
    {
        ArrayList<PenilaianLspopBandara> arrPenil = new ArrayList<PenilaianLspopBandara>();
        ArrayList<LspopBandara> arrLspop = getModelLspopBandara(nop);
        
        for(int i = 0; i < arrLspop.size();i++)
        {
            PenilaianLspopBandara penil = new PenilaianLspopBandara();
            penil.setLspop(arrLspop.get(i));
            penil.setNilaiPerM(0);
            penil.setNilaiTotal(0);
            
            arrPenil.add(penil);
        }
        
        try{
             String sql = "SELECT * FROM rslt_nilai_lspop_bandara where nop ='"+nop+"' and tahun = '"+tahun+"'";
             ResultSet res = DBFetching.getResultSet(sql);
             
             while(res.next())
             {
                 for(int i = 0; i < arrPenil.size();i++)
                 {
                     if(res.getString(2).equalsIgnoreCase(arrPenil.get(i).getLspop().getNoBng()+""))
                     {
                         arrPenil.get(i).setNilaiPerM(Double.parseDouble(res.getString(4)));
                         arrPenil.get(i).setNilaiTotal(Double.parseDouble(res.getString(5)));
                     }
                 }
             }
             
             
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arrPenil;
    }
    
    
    public static ArrayList<PenilaianTanahBandara> getPenilTanahBandara(String nop,String tahun)
    {
        
        ArrayList<PenilaianTanahBandara> arrTanah = new ArrayList<PenilaianTanahBandara>();
        
        try{
            
            
             ArrayList<String>arrJpb = new ArrayList<String>();
                arrJpb.add("Komersial");
                arrJpb.add("Non-Komersial");
                arrJpb.add("Cadangan");
                arrJpb.add("Areal Lainnya");
                
                
                for(int i = 0; i < arrJpb.size();i++)
                {
                    LkokTanahBandara lkokTanah = getModelDataBandara(nop).getTanahBandara();
                    double luas = 0;
                    
                    if(arrJpb.get(i).equalsIgnoreCase("Komersial"))
                    {
                        luas = lkokTanah.getLuasKomersial();
                    
                    }else if(arrJpb.get(i).equalsIgnoreCase("Non-Komersial")){
                        
                        luas = lkokTanah.getLuasNonKomersial();
                                
                    }else if(arrJpb.get(i).equalsIgnoreCase("Cadangan")){
                        
                        luas = lkokTanah.getLuasCadangan();
                    
                    }else if(arrJpb.get(i).equalsIgnoreCase("Areal Lainnya")){
                        
                        luas = lkokTanah.getLuasArealLain();
                    }
                        
                    
                    
                    PenilaianTanahBandara modelTanah = new PenilaianTanahBandara();
                    modelTanah.setJnsPenggunaanTanah(arrJpb.get(i));
                    modelTanah.setLuas(luas);
                    modelTanah.setNir(0);
                    modelTanah.setNilPerM(0);
                    modelTanah.setNilTotal(0);
                    
                    arrTanah.add(modelTanah);
                
            }
            
            
                    String sql = "SELECT * FROM rslt_nilai_tanah_bandara "
                                    + "where nop = '"+nop+"' and tahun = '"+tahun+"'";
                    ResultSet res = DBFetching.getResultSet(sql);
                    
                    while(res.next())
                    {
                        String jpbTanah = res.getString(3);
                        for(int i = 0; i < arrTanah.size();i++)
                        {
                            if(jpbTanah.equalsIgnoreCase(arrTanah.get(i).getJnsPenggunaanTanah()))
                            {    
                                arrTanah.get(i).setNir(Double.parseDouble(res.getString(5)));
                        
                                arrTanah.get(i).setNilPerM(Double.parseDouble(res.getString(6)));
                                arrTanah.get(i).setNilTotal(Double.parseDouble(res.getString(7)));
                            }
                         }
                    }
            
                
               
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arrTanah;
    }
    
    public static ArrayList<PenilaianBngKhususBandara> getPenilBngKhususBandara(String nop, String tahun)
    {
             ArrayList<PenilaianBngKhususBandara> arrBng = new ArrayList<PenilaianBngKhususBandara>();
        
        try{
                
                ArrayList<LkokBangunanKhususBandara> arrLkokBng = getModelDataBandara(nop).getBngUmumBandara().getArrLkokBng(); 
                
                for(int i = 0; i < arrLkokBng.size();i++)
                {
                    LkokBangunanKhususBandara lkokBng = arrLkokBng.get(i);
                    double luas = lkokBng.getLuas();
                    
                    
                    PenilaianBngKhususBandara modelBng = new PenilaianBngKhususBandara();
                    modelBng.setJpb(arrLkokBng.get(i).getJpbBandara());
                    modelBng.setLuas(luas);
                    modelBng.setNilPerM2(0);
                    modelBng.setNilTotal(0);
                    arrBng.add(modelBng);
                
            }
            
            
                    String sql = "SELECT * FROM rslt_nilai_bngkhusus_bandara "
                                    + "where nop = '"+nop+"' and tahun = '"+tahun+"'";
                    ResultSet res = DBFetching.getResultSet(sql);
                    
                    while(res.next())
                    {
                        String jpbTanah = res.getString(3);
                        for(int i = 0; i < arrBng.size();i++)
                        {
                            if(jpbTanah.equalsIgnoreCase(arrBng.get(i).getJpb()))
                            {    
                                arrBng.get(i).setNilPerM2(Double.parseDouble(res.getString(5)));
                                arrBng.get(i).setNilTotal(Double.parseDouble(res.getString(6)));
                            }
                         }
                    }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arrBng;
   
    }
    
    public static ArrayList<PenilaianBngPTBandaraDBKB> getPenilBngPTDBKBBandara(String nop, String tahun)
    {
        ArrayList<PenilaianBngPTBandaraDBKB> penilBngArr = new ArrayList<PenilaianBngPTBandaraDBKB>();
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
            PenilaianBngPTBandaraDBKB tempBng = new PenilaianBngPTBandaraDBKB();
            tempBng.setJpb(lspopNonStdArr.get(i).getJpb());
            
            tempBng.setLuas(lspopNonStdArr.get(i).getLsBngUtama());
            if(mapNilaiBngArr.size()>0)
            {
                tempBng.setNilai_bangunan(mapNilaiBngArr.get(lspopNonStdArr.get(i).getJpb()).getNilaiBngStlhSusut());
            }else
            {
                tempBng.setNilai_bangunan(0);
            }
            
            tempBng.setNir(0);
            tempBng.setNilai_njop(0);
            penilBngArr.add(tempBng);
        }
        
            //jadikan hashmap nilaiBngBandara
             HashMap <String,PenilaianBngPTBandaraDBKB> mapNilaiBngBandara = new HashMap <String,PenilaianBngPTBandaraDBKB>();
             
             for(int i = 0; i < penilBngArr.size();i++)
             {
                 mapNilaiBngBandara.put(penilBngArr.get(i).getJpb(), penilBngArr.get(i));
             }
        
        try{
            String sql = "SELECT * FROM rslt_nilai_bngpt_dbkb_bandara"
                    + " where nop = '"+nop+"' and tahun = '"+tahun+"'";
            ResultSet res = DBFetching.getResultSet(sql);
            
            while(res.next())
            {
                PenilaianBngPTBandaraDBKB nilaiBng = mapNilaiBngBandara.get(res.getString(3));
                nilaiBng.setLuas(Double.parseDouble(res.getString(4)));
                nilaiBng.setNilai_bangunan(Double.parseDouble(res.getString(5)));
                nilaiBng.setNilai_njop(Double.parseDouble(res.getString(6)));
                mapNilaiBngBandara.remove(res.getString(3));
                mapNilaiBngBandara.put(res.getString(3), nilaiBng);
            }
            
            //update array
            for(int i = 0; i < penilBngArr.size();i++)
            {
                penilBngArr.set(i, mapNilaiBngBandara.get(penilBngArr.get(i).getJpb()));
            }
            
             
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return penilBngArr;
        
    }
    
    public static DataBandara getModelDataBandara(String nop)
    {
        DataBandara data  = new DataBandara();
        
        data.setBngUmumBandara(getModelLkokBangunan(nop));
        data.setTanahBandara(getModelLkokTanah(nop));
        
        return data;
    }
    
    
    
}
