/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesDataSpopPerikanan {
    
    /*
    * kdSimpan : 0 untuk Simpan, 1 untuk update
    */
    public static boolean simpanSpopBumiPerikanan(ModelSpopPerikanan spopIkan,int kdSimpan) {
        String strQuery = "";
        String strQueryCek = "";
        DBFetching.setAutoCommit(false);
        //Proses SPOP
        Spop spop = spopIkan.getSpop();
        try{
            if (kdSimpan == 0) {
                
            strQuery = "insert into spop values('"+spop.getNop()+
                    "','"+spop.getJalanOp()+"','"+spop.getNoJalanOp()+
                    "','"+spop.getKelurahanOp()+"','"+spop.getRwRtOp()+
                    "','"+spop.getStatusWp()+"','"+spop.getPekerjaanWp()+
                    "','"+spop.getNamaWp()+"','"+spop.getNpwp()+
                    "','"+spop.getJalanWp()+"','"+spop.getNoJalanWp()+
                    "','"+spop.getKelurahanWp()+"','"+spop.getRwRtWp()+
                    "','"+spop.getKabupaten()+"','"+spop.getNomorKtp()+
                    "',"+spop.getLuasTanah().toString()+",'0',"+
                    "'"+spop.getJenisTanah()+"','0')";
            DBFetching.setComandToDB("DELETE FROM `cek_op_khusus` WHERE `nop`='"+spop.getNop()+"'");
            strQueryCek = "INSERT INTO `cek_op_khusus` (`nop`, `jenis_op`) "
                          + "VALUES ('"+spop.getNop()+"', 'Ikan')";
            } else {
            strQuery = "update spop set jalan_op='"+spop.getJalanOp()+
                    "', no_jalan_op='"+spop.getNoJalanOp()+"', kelurahan_op='"+spop.getKelurahanOp()+
                    "', rw_rt_op='"+spop.getRwRtOp()+"', status_wp='"+spop.getStatusWp()+
                    "', pekerjaan_wp='"+spop.getPekerjaanWp()+"', nama_wp='"+spop.getNamaWp()+
                    "', npwp='"+spop.getNpwp()+"', jalan_wp='"+spop.getJalanWp()+
                    "', no_jalan_wp='"+spop.getNoJalanWp()+"', kelurahan_wp='"+spop.getKelurahanWp()+
                    "', rw_rt_wp='"+spop.getRwRtWp()+"', kabupaten='"+spop.getKabupaten()+
                    "', nomor_ktp='"+spop.getNomorKtp()+"', luas_tanah="+spop.getLuasTanah().toString()+
                    ", znt='0', jns_tanah='"+spop.getJenisTanah()+
                    "', jml_bng='0' where nop='"+spop.getNop()+"'";
            
            DBFetching.setComandToDB("DELETE FROM `cek_op_khusus` WHERE `nop`='"+spop.getNop()+"'");
            strQueryCek = "INSERT INTO `cek_op_khusus` (`nop`, `jenis_op`) "
                          + "VALUES ('"+spop.getNop()+"', 'Ikan')";
            
           DBFetching.setComandToDB(strQueryCek);
            DBFetching.setComandToDB(strQuery);
            }
            
            
            
            //ProsesSpopTambahan
            ModelSpopTambahan spopTambah = spopIkan.getSpopTambahan();
            
                if (kdSimpan == 0) {
                strQuery = "INSERT INTO `spop_tambahan_perikanan` "
                    + "(`nop`, `no_suratizin_perikanan`, `kontraktor`, `budidaya_ikan`, `penangkapan_ikan`) "
                    + "VALUES "
                    + "('"+spop.getNop()+"'," 
                    + "'"+spopTambah.getNoIzinPerikanan()+"', "
                    + "'"+spopTambah.getKontraktor()+"', "
                    + "'"+spopTambah.getBudidayaIkan()+"', "
                    + "'"+spopTambah.getPenangkapanIkan()+"')";
                DBFetching.setComandToDB(strQuery);
            } else {
                strQuery = "UPDATE `spop_tambahan_perikanan` "
                        + "SET `nop`='"+spop.getNop()+"', "
                        + "`no_suratizin_perikanan`='"+spopTambah.getNoIzinPerikanan()+"', `"
                        + "kontraktor`='"+spopTambah.getKontraktor()+"', "
                        + "`budidaya_ikan`='"+spopTambah.getBudidayaIkan()+"', "
                        + "`penangkapan_ikan`='"+spopTambah.getPenangkapanIkan()+"' "
                        + "WHERE `nop`='"+spopTambah.getNop()+"';";
                DBFetching.setComandToDB(strQuery);
            }
                
                
            //ProsesPeruntukanBUmi
            ArrayList<ModelSpopBumi> arrBumi = spopIkan.getSpopBumi();
            
            for(int i = 0; i < arrBumi.size();i++)
            {
              ModelSpopBumi bumi = arrBumi.get(i);
              
              if(kdSimpan == 0)
             {
                 
                 strQuery = "INSERT INTO `spop_bumi_perikanan` (`nop`, `kode_peruntukan`, `peruntukan`, `luas`, `keterangan`) "
                         + "VALUES ('"+spop.getNop()+"', "
                         + "'"+bumi.getKode()+"', "
                         + "'"+bumi.getPeruntukan()+"', "
                         + "'"+bumi.getLuas()+"', "
                         + "'');";
                 DBFetching.setComandToDB(strQuery);
             }else
             {
                 strQuery = "UPDATE `spop_bumi_perikanan` "
                         + "SET `nop`='"+spop.getNop()+"', "
                         + "`kode_peruntukan`='"+bumi.getKode()+"', "
                         + "`peruntukan`='"+bumi.getPeruntukan()+"', "
                         + "`luas`='"+bumi.getLuas()+"', "
                         + "`keterangan`='"+bumi.getKeterangan()+"' "
                         + "WHERE `nop`='"+spop.getNop()+"' and`kode_peruntukan`='"+bumi.getKode()+"'";
                 DBFetching.setComandToDB(strQuery);
              }
              
             
            }
           
            DBFetching.Simpan();
            
            return true;
            
        }catch(Exception e)
        {
        DBFetching.RollBackDB();
        e.printStackTrace();
        
        
        }
        return false;
        
        
        
    }
    
    
    public static ModelSpopPerikanan getSpopPerikanan(String nop)
    {
        ModelSpopPerikanan spopIkan = new ModelSpopPerikanan();
        Spop spop = new Spop();
        ModelSpopTambahan spopTambah = new ModelSpopTambahan();
        ArrayList<ModelSpopBumi> arrBumi = new ArrayList<ModelSpopBumi>();
        
        //ambil model spop
        ToolsPenilaian.ambilSpopFromDb(nop, spop);
        
        //ambil model spopTambahan
        String sql = "SELECT * FROMspop_tambahan_perikanan where nop = '"+nop+"'";
        ResultSet set = DBFetching.getResultSet(sql);
        try {
            while(set.next())
            {
                spopTambah.setNop(set.getString(1));
                spopTambah.setNoIzinPerikanan(set.getString(2));
                spopTambah.setKontraktor(set.getString(3));
                spopTambah.setBudidayaIkan(set.getString(4));
                spopTambah.setPenangkapanIkan(set.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        //ambil model spopBumi
        sql = "SELECT * FROMspop_bumi_perikanan where nop = '"+nop+"'";
        set = DBFetching.getResultSet(sql);
        
        try {
            while(set.next())
            {
                ModelSpopBumi bumi = new ModelSpopBumi();
                bumi.setNop(set.getString(1));
                bumi.setKode(set.getString(2));
                bumi.setPeruntukan(set.getString(3));
                bumi.setLuas(set.getDouble(4));
                bumi.setKeterangan(set.getString(5));
                arrBumi.add(bumi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        spopIkan.setSpop(spop);
        spopIkan.setSpopTambahan(spopTambah);
        spopIkan.setSpopBumi(arrBumi);
        
        return spopIkan;
    
    }

    public static boolean cekKetersediaanData(String nop) {
        int jmlRec = DBFetching.getIntegerResult("select count(*) jml from spop where nop='" + nop +"'");
        return jmlRec>0;
    }
}

