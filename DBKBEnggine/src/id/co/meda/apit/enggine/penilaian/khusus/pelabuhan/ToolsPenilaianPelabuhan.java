/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.pelabuhan;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ToolsPenilaianPelabuhan {
    
    public static boolean simpanCRNPelabuhan(ArrayList<ItemAnalisisHargaSatuan> arrCrn, String nop, String tahun)
    {
    
     DBFetching.setAutoCommit(false);
     try{   
            String sql = "DELETE FROM `crn_pelabuhan` "
                    + "WHERE `nop`='"+nop+"' and`tahun`='"+tahun+"'";
            DBFetching.setComandToDB(sql);
            
            for(int i = 0; i < arrCrn.size(); i++)
            {
                
               sql = "INSERT INTO `crn_pelabuhan` "
                       + "(`nop`, `tahun`, `id`, `jenis_pekerjaan`, "
                       + "`satuan`, `volume`, `hrg_bahan`, `hrg_upah`, `hrg_jumlah`, `hrg_total`)"
                       + " VALUES "
                       + "('"+nop+"',"
                       + " '"+tahun+"',"
                       + " '"+arrCrn.get(i).getId()+"',"
                       + " '"+arrCrn.get(i).getJenisPekerjaan()+"',"
                       + " '"+arrCrn.get(i).getSatuan()+"',"
                       + " '"+arrCrn.get(i).getVolume()+"',"
                       + " '"+arrCrn.get(i).getHrg_bahan()+"',"
                       + " '"+arrCrn.get(i).getHrg_upah()+"',"
                       + " '"+arrCrn.get(i).getHrg_jumlah()+"',"
                       + " '"+arrCrn.get(i).getHrg_total()+"');";
            
               DBFetching.setComandToDB(sql);
           }

        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            return false;
        }
    
        DBFetching.Simpan();
        return true;
    }
    
    
    public static AnalisisHargaSatuanCRN getAnalisisHSKU(String nop, String tahun)
    {
        AnalisisHargaSatuanCRN crn = new AnalisisHargaSatuanCRN();
        crn.setNop(nop);
        crn.setTahun(tahun);
       
        ArrayList<ItemAnalisisHargaSatuan> arrPersiapan = new ArrayList<ItemAnalisisHargaSatuan>();
        ArrayList<ItemAnalisisHargaSatuan> arrKonstruksi = new ArrayList<ItemAnalisisHargaSatuan>();
        ArrayList<ItemAnalisisHargaSatuan> arrFinishing = new ArrayList<ItemAnalisisHargaSatuan>();
        ArrayList<ItemAnalisisHargaSatuan> arrAksesoris = new ArrayList<ItemAnalisisHargaSatuan>();
        
        try{
            
            //isi Persiapan
            String sql = "SELECT * FROMcrn_pelabuhan where "
                    + "nop = '"+nop+"' and tahun = '"+tahun+"' "
                    + "and id like '%C1%'";
            ResultSet set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ItemAnalisisHargaSatuan temp = new ItemAnalisisHargaSatuan();
                temp.setId(set.getString(3));
                temp.setJenisPekerjaan(set.getString(4));
                temp.setSatuan(set.getString(5));
                temp.setVolume(set.getDouble(6));
                temp.setHrg_bahan(set.getDouble(7));
                temp.setHrg_upah(set.getDouble(8));
                temp.setHrg_jumlah(set.getDouble(9));
                temp.setHrg_total(set.getDouble(10));
                
                arrPersiapan.add(temp);
            }
            
            //isi Konstruksi
            sql = "SELECT * FROMcrn_pelabuhan where "
                    + "nop = '"+nop+"' and tahun = '"+tahun+"' "
                    + "and id like '%C2%'";
            set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ItemAnalisisHargaSatuan temp = new ItemAnalisisHargaSatuan();
                temp.setId(set.getString(3));
                temp.setJenisPekerjaan(set.getString(4));
                temp.setSatuan(set.getString(5));
                temp.setVolume(set.getDouble(6));
                temp.setHrg_bahan(set.getDouble(7));
                temp.setHrg_upah(set.getDouble(8));
                temp.setHrg_jumlah(set.getDouble(9));
                temp.setHrg_total(set.getDouble(10));
                
                arrKonstruksi.add(temp);
            }
            
            //isi Finishing
            sql = "SELECT * FROMcrn_pelabuhan where "
                    + "nop = '"+nop+"' and tahun = '"+tahun+"' "
                    + "and id like '%C3%'";
            set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ItemAnalisisHargaSatuan temp = new ItemAnalisisHargaSatuan();
                temp.setId(set.getString(3));
                temp.setJenisPekerjaan(set.getString(4));
                temp.setSatuan(set.getString(5));
                temp.setVolume(set.getDouble(6));
                temp.setHrg_bahan(set.getDouble(7));
                temp.setHrg_upah(set.getDouble(8));
                temp.setHrg_jumlah(set.getDouble(9));
                temp.setHrg_total(set.getDouble(10));
                
                arrFinishing.add(temp);
            }
            
            //isi Aksesoris
            sql = "SELECT * FROMcrn_pelabuhan where "
                    + "nop = '"+nop+"' and tahun = '"+tahun+"' "
                    + "and id like '%C4%'";
            set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ItemAnalisisHargaSatuan temp = new ItemAnalisisHargaSatuan();
                temp.setId(set.getString(3));
                temp.setJenisPekerjaan(set.getString(4));
                temp.setSatuan(set.getString(5));
                temp.setVolume(set.getDouble(6));
                temp.setHrg_bahan(set.getDouble(7));
                temp.setHrg_upah(set.getDouble(8));
                temp.setHrg_jumlah(set.getDouble(9));
                temp.setHrg_total(set.getDouble(10));
                
                arrAksesoris.add(temp);
            }
            
            crn.setArrPersiapan(arrPersiapan);
            crn.setArrKonstruksiUtama(arrKonstruksi);
            crn.setArrFinishing(arrFinishing);
            crn.setArrAsesoris(arrAksesoris);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return crn;
        
    }
    
    
    public static SpopPelabuhan getSpopPelabuhan(String nop)
    {
        SpopPelabuhan spop = new SpopPelabuhan();
        
        try{
            ResultSet set = DBFetching.getResultSet("SELECT * FROM "
                    + "spop_pelabuhan where nop = '"+nop+"'");
            while(set.next())
            {
                spop.setNop(nop);
                spop.setJenisPelabuhan(set.getString(2));
                spop.setNamaPelabuhan(set.getString(3));
                spop.setAlamatPelabuhan(set.getString(4));
            }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return spop;
    }
    
    public static boolean simpanSpopPelabuhan(SpopPelabuhan spop)
    {
        DBFetching.setAutoCommit(false);
        try{
            String sql = "DELETE FROM `spop_pelabuhan` WHERE "
                    + "`nop`='"+spop.getNop()+"'";
            
            DBFetching.setComandToDB(sql);
            
            sql = "DELETE FROM `spop` WHERE `nop`='"+spop.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            sql ="DELETE FROM `cek_op_khusus` WHERE `nop`='"+spop.getNop()+"'";
            DBFetching.setComandToDB(sql);
            
            
            sql = "INSERT INTO `cek_op_khusus` "
                    + "(`nop`, `jenis_op`) VALUES "
                    + "('"+spop.getNop()+"', 'Pelabuhan');";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into spop values('"+spop.getNop()+
                    "','"+spop.getNamaPelabuhan()+"','"+
                    "','','"+
                    "','','"+
                    "','"+spop.getNamaPelabuhan()+"','"+
                    "','','"+
                    "','','"+
                    "','','"+
                    "',0,'"+
                    "','',0)";
            DBFetching.setComandToDB(sql);
            
            
            sql = "INSERT INTO `spop_pelabuhan`"
                    + " (`nop`, `jenis_pelabuhan`, `nama_pelabuhan`, `alamat_pelabuhan`) "
                    + "VALUES "
                    + "('"+spop.getNop()+"', "
                    + "'"+spop.getJenisPelabuhan()+"', "
                    +"'"+spop.getNamaPelabuhan()+"', "
                    + "'"+spop.getAlamatPelabuhan()+"');";
            DBFetching.setComandToDB(sql);
            
            DBFetching.Simpan();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
            
        
        return false;
    }

    public static AnalisisHargaSatuanCRN getAnalisisHargaSatuan(String nop, String tahun)
    {
        AnalisisHargaSatuanCRN crn = new AnalisisHargaSatuanCRN();
        
        try{
            
            String sql = "SELECT count(*) FROMcrn_pelabuhan WHERE NOP = '"+nop+"'"
                    + " AND tahun = '"+tahun+"'";
            int cek = DBFetching.getIntegerResult(sql);
            
            if(cek > 0)
            {
                sql = "";
            }else
            {
            
            }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        return crn;
    }
    
    
}
