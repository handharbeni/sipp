/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;
import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesDataPendapatanPerikanan {
    
  
    public boolean cekNop(String nop)
    {
        int jmlRec = DBFetching.getIntegerResult("select count(*) jml from spop where nop='" + nop +"'");
        return jmlRec>0;
    }
    
  
    
   
    
    
    
    
    /*
    * Method untuk add jenis ikan
    */
    public boolean addIkan(ModelIkan ikan,String nop)
    {
        try{
        DBFetching.setAutoCommit(false);
       String sql = "INSERT INTO `pros_datapendapatan_perikanan` "
               + "(`nop`, `jenis_usaha`, `nama_ikan`, `berat`, `harga_per_ton`, `keterangan`) "
               + "VALUES "
               + "('"+nop+"', "
               + "'"+ikan.getJenisUsaha()+"', "
               + "'"+ikan.getNamaIkan()+"', "
               + "'"+ikan.getBerat()+"', "
               + "'"+ikan.getHargaPerTon()+"', "
               + "'"+ikan.getKeterangan()+"')";
         DBFetching.setComandToDB(sql);
         DBFetching.Simpan();
         
         return true;
         
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
        }
        
       return false;
    }
    
    public boolean updateIkan(ModelIkan ikan,String nop,String namaIkanLama)
    {
        try{
        DBFetching.setAutoCommit(false);
       String sql = "UPDATE `pros_datapendapatan_perikanan` "
               + "SET "
               + "`jenis_usaha`='"+ikan.getJenisUsaha()+"', "
               + "`nama_ikan`='"+ikan.getNamaIkan()+"', "
               + "`berat`='"+ikan.getBerat()+"', "
               + "`harga_per_ton`='"+ikan.getHargaPerTon()+"', "
               + "`keterangan`='d' WHERE "
               + "`nop`='"+nop+"' "
               + "and "
               + "`nama_ikan`='"+namaIkanLama+"' and"
               + " `jenis_usaha`='"+ikan.getJenisUsaha()+"'";
         DBFetching.setComandToDB(sql);
         DBFetching.Simpan();
         
         return true;
         
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
        }
        
       return false;
    }
    
   
    public boolean delete(String nop,String namaIkan, String jenisUsaha)
    {
        DBFetching.setAutoCommit(false);
        try{
        String sql = "DELETE FROM `pros_datapendapatan_perikanan` "
                + "WHERE `nop`='"+nop+"' "
                + "and`nama_ikan`='"+namaIkan+"' "
                + "and "
                + "`jenis_usaha`='"+jenisUsaha+"'";
        DBFetching.setComandToDB(sql);
        DBFetching.Simpan();
        return true;
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
        }
        
        return false;
    }
   
    
}
