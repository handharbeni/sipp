/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author I Putu Medagia A
 */
public class ToolsPenilaianIkan {
    
    private static String kelasBangunan;
    private static double njopPerM2Bangunan;
    
    public static ArrayList <NilaiTanahIkan> getArrNilaiTanahIkan(String nop,String tahun,DataPerikanan data)
    {
        ArrayList <NilaiTanahIkan> temp = new ArrayList <NilaiTanahIkan>();
         String sql = "SELECT * FROMspop_bumi_nilaiikan where nop = '"+nop+"' and tahun = '"+tahun+"'";
        
        ResultSet set = DBFetching.getResultSet(sql);
        
        try {
            for(int i = 0; i < data.getSpopIkan().getSpopBumi().size();i++)
            {
                NilaiTanahIkan tempModel = new NilaiTanahIkan();
                tempModel.setNop(nop);
                tempModel.setKode_peruntukan(data.getSpopIkan().getSpopBumi().get(i).getKode());
                tempModel.setNir(0);
                tempModel.setKelasTanah("-");
                tempModel.setNilaiPerm2(0);
                tempModel.setTahun(tahun);
                tempModel.setNilaiKeseluruhan(0);
                temp.add(tempModel);
            }
            
            int ii = 0;
            while(set.next())
            {
                temp.get(ii).setNir(set.getDouble(4));
                temp.get(ii).setKelasTanah(set.getString(5));
                temp.get(ii).setNilaiPerm2(set.getDouble(6));
                temp.get(ii).setNilaiKeseluruhan(set.getDouble(7));
                ii++;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }
    
    public static NilaiBangunanIkan getNilaiBangunanIkan(String nop,String tahun,ArrayList<NilaiBangunan> nilBangunanLspop)
    {
        NilaiBangunanIkan temp = new NilaiBangunanIkan();
        nilBangunanLspop = ToolsPenilaian.ambilNilBngFromDB(tahun, nop);
        
        String sql = "select * from lspop_ikan_nilai where nop = '"+nop+"' and tahun = '"+tahun+"'";
        
        ResultSet set = DBFetching.getResultSet(sql);
        
        try {
            temp.setNilaiBangunanLspop(nilBangunanLspop);
            temp.setKelasBangunan("-");
            temp.setNjopPerM2(0);
            temp.setNilaiKeseluruhan(0);
            temp.setLuasTotal(0);
            temp.setNilaiTotal(0);
            /*
            for(int i = 0; i < nilBangunanLspop.size();i++)
            {
                NilaiBangunanIkan nilIkan = new NilaiBangunanIkan();
                nilIkan.setNilaiBangunanLspop(nilBangunanLspop.get(i));
                nilIkan.setKelasBangunan("-");
                nilIkan.setNjopPerM2(0);
                nilIkan.setNilaiKeseluruhan(0);
                temp.add(nilIkan);
            }*/
            
            while(set.next()){
                temp.setLuasTotal(set.getDouble(3));
                temp.setNilaiTotal(set.getDouble(4));
                temp.setNilaiPerM2(set.getDouble(5));
                temp.setKelasBangunan(set.getString(6));
                temp.setNjopPerM2(set.getDouble(7));
                temp.setNilaiKeseluruhan(set.getDouble(8));
                
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    
    }
    
    /*
     * Model ini hanya menyimpan Data-data ikan tidak untuk penilaian
    */
    public static ModelPendapatanPerikanan getModelPendapatan(String nop)
    {
        ArrayList<ModelIkan> penangkapan = new ArrayList<ModelIkan>();
        ArrayList<ModelIkan> pembudidayaan = new ArrayList<ModelIkan>();
        
        ModelPendapatanPerikanan modelPendapatanIkan = new ModelPendapatanPerikanan();
        
        try{
            //ambil usaha penangkapan
            String sql = "select nama_ikan, berat, harga_per_ton,keterangan from "
                        + "pros_datapendapatan_perikanan where nop = '"+nop+"' and jenis_usaha = 'Penangkapan Ikan'";
            ResultSet set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ModelIkan ikan = new ModelIkan();
                ikan.setNamaIkan(set.getString(1));
                ikan.setBerat(set.getDouble(2));
                ikan.setHargaPerTon(set.getDouble(3));
                ikan.setKeterangan(set.getString(4));
                penangkapan.add(ikan);
            }
            
            //ambil usaha pembudidayaan
            sql = "select nama_ikan, berat, harga_per_ton,keterangan from "
                        + "pros_datapendapatan_perikanan where nop = '"+nop+"' and jenis_usaha = 'Pembudidayaan Ikan'";
            set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                ModelIkan ikan = new ModelIkan();
                ikan.setNamaIkan(set.getString(1));
                ikan.setBerat(set.getDouble(2));
                ikan.setHargaPerTon(set.getDouble(3));
                ikan.setKeterangan(set.getString(4));
                pembudidayaan.add(ikan);
            }
            
            modelPendapatanIkan.setPembudidayaIkan(pembudidayaan);
            modelPendapatanIkan.setPenangkapanIkan(penangkapan);
            modelPendapatanIkan.setNop(nop);
            
            return modelPendapatanIkan;
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    
    }
    
     public static ModelIkan getModelIkan(String nop,String jenisUsaha, String namaIkan)
    {
        ModelIkan ikan = new ModelIkan();
        String sql = "select nama_ikan, berat,jenis_usaha, harga_per_ton,keterangan from "
                        + "pros_datapendapatan_perikanan where nop = '"+nop+"' and jenis_usaha = '"+jenisUsaha+"' and nama_ikan = '"+namaIkan+"'";
            ResultSet set = DBFetching.getResultSet(sql);
        try {
            while(set.next())
            {
                
                ikan.setNamaIkan(set.getString(1));
                ikan.setBerat(set.getDouble(2));
                ikan.setJenisUsaha(set.getString(3));
                ikan.setHargaPerTon(set.getDouble(4));
                ikan.setKeterangan(set.getString(5));
                
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ikan;
    }
    
     /*
      * Model ini untuk memindahkan dari data Ikan ke bentuk ikan yang dinilai 
     * kd --> 01 untuk pembudidayaan dan 02 untuk penangkapan
     */
     public static NilaiPendapatanIkan getNilaiPendapatanIkan(String nop, String tahun,String kd)
     {
         
          NilaiPendapatanIkan pendapatanIkan = new NilaiPendapatanIkan();
          ModelPendapatanPerikanan tempModel = getModelPendapatan(nop);
          
          double tempHasilProduksi = 0;
          double tempHargaProduksi = 0;
          
          if(kd.equalsIgnoreCase("01")){
              
                for(int i = 0; i < tempModel.getPenangkapanIkan().size();i++)
                {
                    tempHasilProduksi += tempModel.getPenangkapanIkan().get(i).getBerat();
                    tempHargaProduksi += tempModel.getPenangkapanIkan().get(i).getHargaPerTon();
                }
          }else
          {
                for(int i = 0; i < tempModel.getPembudidayaIkan().size();i++)
                {
                    tempHasilProduksi += tempModel.getPembudidayaIkan().get(i).getBerat();
                    tempHargaProduksi += tempModel.getPembudidayaIkan().get(i).getHargaPerTon();
                }
          }
          String sql = "SELECT biaya_operasional FROM pendapatan_ikan_nilai where nop = '"+nop+"' and \n" +
                       "tahun = '"+tahun+"' and jenis = '"+kd+"'";
          double biayaOperasional = DBFetching.getDoubleResult(sql);
          
          
          pendapatanIkan.setNop(nop);
          pendapatanIkan.setTahun(tahun);
          pendapatanIkan.setJenis(kd);
          pendapatanIkan.setHargaPasar(tempHargaProduksi);
          pendapatanIkan.setHasilProduksi(tempHasilProduksi);
          pendapatanIkan.setBiayaOperasional(biayaOperasional);
          
          return pendapatanIkan;
          
     }
     
    public static DataPerikanan getPendataan(String nop)
   {
      return BuatModelPendataan.getPendataan(nop);
   }
    
    
    private static void cariKelasBangunan(double TotalNilaiBangunan, String tahun)
    {
        String sql = "select KD_KELAS_BANGUNAN,NILAI_PER_M2_BANGUNAN from kelas_bangunan where \n" +
                     "('"+tahun+"' between THN_AWAL_KELAS_BNGN\n" +
                     "and THN_AKHIR_KELAS_BNGN) and "+TotalNilaiBangunan+"/1000 \n" +
                     "between NILAI_MIN_BANGUNAN\n" +
                     " and NILAI_MAX_BANGUNAN and KD_KELAS_BANGUNAN NOT LIKE 'XXX';";
        
        kelasBangunan = DBFetching.getStringResult(sql, 1);
        njopPerM2Bangunan = Double.parseDouble(DBFetching.getStringResult(sql, 2));
    }

    
    public static double getTotalNjopBangunan(ArrayList<NilaiBangunanIkan> bngIkanArr)
    {
        double tempNjopTot = 0;
        
        for(int i = 0; i < bngIkanArr.size(); i++)
        {
            tempNjopTot += bngIkanArr.get(i).getNilaiKeseluruhan();
        }
        
        return tempNjopTot;
    }
    
    public static double getTotalNjopTanah(ArrayList<NilaiTanahIkan> tanahIkanArr)
    {
        double tempNjopTot = 0;
        
        for(int i = 0; i < tanahIkanArr.size();i++)
        {
            tempNjopTot += tanahIkanArr.get(i).getNilaiKeseluruhan();
        }
        
        return tempNjopTot;
    }
    
    public static double getTotalNjopPendapatan(ArrayList<NilaiPendapatanIkan> pendapatan)
    {
        double tempNjopTot = 0;
        
        for(int i = 0; i < pendapatan.size();i++)
        {
            tempNjopTot += pendapatan.get(i).getNilaiKeseluruhan();
        }
        
        return tempNjopTot;
    }
        
    
    
    /**
     * @return the kelasBangunan
     */
    public static String getKelasBangunan(double nilaiBangunan, String tahun) {
        cariKelasBangunan(nilaiBangunan, tahun);
        return kelasBangunan;
    }

    /**
     * @return the njopPerM2
     */
    public static double getNjopPerM2(double nilaiBangunan, String tahun) {
        cariKelasBangunan(nilaiBangunan, tahun);
        return njopPerM2Bangunan;
    }
    
}
