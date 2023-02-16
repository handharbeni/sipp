/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.PenilaianBangunan;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesPenilaianPerikanan {
    
    private double njopTanah;
    private double njopBangunan;
    private double njopPerikanan;
    
    private ArrayList <NilaiTanahIkan> arrModelTanah; 
    private NilaiBangunanIkan ModelBangunan;
    
    
    
    
    public void ambilNjop(String nop, String tahun)
    {
        this.njopBangunan = DBFetching.getDoubleResult("select njop_bangunan from penilaian_perikanan where nop = '"+nop+"' and tahun = '"+tahun+"'");
        this.njopTanah = DBFetching.getDoubleResult("select njop_tanah from penilaian_perikanan where nop = '"+nop+"' and tahun = '"+tahun+"'");
        this.njopPerikanan = DBFetching.getDoubleResult("select njop_perikanan from penilaian_perikanan where nop = '"+nop+"' and tahun = '"+tahun+"'");
    }
    
    public void prosesNilaiTanah(String nop,String tahun,String kdPeruntukan,double luas,double nir,NilaiTanahIkan tanah)
    {
        DBFetching.setAutoCommit(false);
        try{
        
        //hapus yang sudah ada
        String sql = "DELETE FROM `spop_bumi_nilaiikan` WHERE `nop`='"+nop+"' and`tahun`='"+tahun+"' "
                + "and`kode_peruntukan`='"+kdPeruntukan+"'";    
        DBFetching.setComandToDB(sql);
        
        //cari kelas tanah dan nilainya
        String kelasTanah = "";
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
            kelasTanah = set.getString(1);
            nilaiTanah = set.getDouble(6)*1000;
        }
        
        
        //insert ke table Spop_Bumi_nilaiIkan
       
        double nilaiKeseluruhan = nilaiTanah*luas;
        sql = "INSERT INTO `spop_bumi_nilaiikan` "
                + "(`nop`, `tahun`, `kode_peruntukan`, `nir`, `kelas_tanah`, `nilai_perm2`, `nilai_keseluruhan`) "
                + "VALUES ("
                + "'"+nop+"', "
                + "'"+tahun+"', "
                + "'"+kdPeruntukan+"', "
                + "'"+nir+"', "
                + "'"+kelasTanah+"', "
                + "'"+nilaiTanah+"', "
                + "'"+nilaiKeseluruhan+"')";
        DBFetching.setComandToDB(sql);
        
        //update nilai terbaru
        tanah.setNir(nir);
        tanah.setKelasTanah(kelasTanah);
        tanah.setNilaiPerm2(nilaiTanah);
        tanah.setNilaiKeseluruhan(nilaiKeseluruhan);
        
        
        //ambil Nilai Sum Keseluruhan
        double tempSum = DBFetching.getDoubleResult("select sum(nilai_keseluruhan) from spop_bumi_nilaiikan "
                + "where nop = '"+nop+"' and tahun = '"+tahun+"'");
        
        njopTanah = tempSum;
        
        DBFetching.Simpan();
        
        }catch(Exception e)
        {
         e.printStackTrace();
        }
    }
    
    
     public NilaiBangunanIkan prosesPenilaianBangunan(String nop, String tahun,NilaiBangunanIkan bangunanIkan)
    {
        NilaiBangunanIkan tempOld = bangunanIkan; //ini digunakan agar jika error data lama tidak hilang
           
        try
        {
            
            //hapus dulu data lama 
            DBFetching.setComandToDB("DELETE FROM `lspop_ikan_nilai` WHERE `nop`='"+nop+"' and`tahun`='"+tahun+"'");
            
            
            //menilai bangunan dengan lspop-non-standar
            PenilaianBangunan nilaiBangunan = new PenilaianBangunan(nop,tahun);
            nilaiBangunan.mulaiPenilaian();
            
            
            ArrayList<NilaiBangunan> tempNilaiBngBaru = ToolsPenilaian.ambilNilBngFromDB(tahun, nop);
            bangunanIkan = ToolsPenilaianIkan.getNilaiBangunanIkan(nop, tahun, tempNilaiBngBaru);
            
                
            bangunanIkan.setNilaiBangunanLspop(tempNilaiBngBaru);
            double tempTotalNil = 0;
            double tempTotalLuas = 0;
            for(int i = 0; i < bangunanIkan.getNilaiBangunanLspop().size();i++)
            {
                 tempTotalNil += bangunanIkan.getNilaiBangunanLspop().get(i).getNilaiBangunan();
                 tempTotalLuas += bangunanIkan.getNilaiBangunanLspop().get(i).getLuasBng();
            }
            bangunanIkan.setLuasTotal(tempTotalLuas);
            bangunanIkan.setNilaiTotal(tempTotalNil);
            double tempNilaiPerM2 = tempTotalNil/tempTotalLuas;
            bangunanIkan.setNilaiPerM2(tempNilaiPerM2);
            bangunanIkan.setKelasBangunan(ToolsPenilaianIkan.getKelasBangunan(tempNilaiPerM2, tahun));
            bangunanIkan.setNjopPerM2(1000*ToolsPenilaianIkan.getNjopPerM2(tempNilaiPerM2, tahun));
            bangunanIkan.setNilaiKeseluruhan(bangunanIkan.getNjopPerM2()*bangunanIkan.getLuasTotal());
            
            
            /*
                double tempNilaiM2 = tempNilaiBngBaru.get(i).getNilaiBangunan()/tempNilaiBngBaru.get(i).getLuasBng();
                bangunanIkanArr.get(i).setNilaiPerM2(tempNilaiM2);
                bangunanIkanArr.get(i).setKelasBangunan(ToolsPenilaianIkan.getKelasBangunan(tempNilaiM2, tahun));
                bangunanIkanArr.get(i).setNjopPerM2(1000*ToolsPenilaianIkan.getNjopPerM2(tempNilaiM2, tahun));
                double tempNilaiPerM2 = bangunanIkanArr.get(i).getNjopPerM2();
                double tempLuas = bangunanIkanArr.get(i).getNilaiBangunanLspop().getLuasBng();
                bangunanIkanArr.get(i).setNilaiKeseluruhan(tempNilaiPerM2*tempLuas);
            */    
                //masukkan ke database
                String sql = "INSERT INTO `lspop_ikan_nilai` "
                        + "(`nop`, `tahun`, `luas_total`, `nilai_total`, "
                        + "`nilai_perm2`, `kelas`, `njop_per_m2`, `nilai_keseluruhan`) "
                        + "VALUES ('"+nop+"', "
                        + "'"+tahun+"', "
                        + "'"+tempTotalLuas+"', "
                        + "'"+tempTotalNil+"', "
                        + "'"+tempNilaiPerM2+"', "
                        + "'"+bangunanIkan.getKelasBangunan()+"', "
                        + "'"+bangunanIkan.getNjopPerM2()+"', "
                        + "'"+bangunanIkan.getNilaiKeseluruhan()+"');";
                
                DBFetching.setComandToDB(sql);
            
            
            
           
           
           return bangunanIkan;
        }catch(Exception e)
        {
            e.printStackTrace();
            return tempOld;  
        }
        
        
        
    }

     public void prosesNilaiPendapatanIkan(NilaiPendapatanIkan pendapatan)
     {
         DBFetching.setAutoCommit(false);
         try{
             
         //hapus dahulu yang lama
         String sql = "DELETE FROM `pendapatan_ikan_nilai` WHERE `nop`='"+pendapatan.getNop()+"' "
                 + "and`tahun`='"+pendapatan.getTahun()+"' and`jenis`='"+pendapatan.getKodeJenis()+"'";
         DBFetching.setComandToDB(sql);
         
         
         //insert hasil perhitungan
         sql = "INSERT INTO `pendapatan_ikan_nilai` "
                 + "(`nop`, `tahun`, `jenis`, `hasil_produksi`, `harga_pasar_perton`, `biaya_operasional`, `nilai_keseluruhan`) VALUES "
                 + "('"+pendapatan.getNop()+"', "
                  + "'"+pendapatan.getTahun()+"', '"+pendapatan.getKodeJenis()+"', "
                 + "'"+pendapatan.getHasilProduksi()+"', '"+pendapatan.getHargaPasar()+"', "
                 + "'"+pendapatan.getBiayaOperasional()+"', '"+pendapatan.getNilaiKeseluruhan()+"')";
          DBFetching.setComandToDB(sql);
         
          DBFetching.Simpan();
          
         }catch(Exception e)
         {
             DBFetching.RollBackDB();
             e.printStackTrace();
         }
     }
     
     
     public void prosesNilaiNJOP(String nop,String tahun)
     {
         DBFetching.setAutoCommit(false);
         
         try{
         
            String sql = "DELETE FROM `penilaian_perikanan` WHERE `nop`='"+nop+"' and`tahun`='"+tahun+"'";
            DBFetching.setComandToDB(sql);


            sql = "INSERT INTO `penilaian_perikanan` (`nop`, `njop_tanah`, `njop_bangunan`, `njop_perikanan`, `tahun`) "
                    + "VALUES ('"+nop+"', '"+njopTanah+"', '"+njopBangunan+"', '"+njopPerikanan+"', '"+tahun+"')";
            DBFetching.setComandToDB(sql);
            
            DBFetching.Simpan();
            
         }catch(Exception e)
         {
             DBFetching.RollBackDB();
             e.printStackTrace();
         }
     }
     
    /**
     * @return the njopTanah
     */
    public double getNjopTanah() {
       
        return njopTanah;
    }

    /**
     * @return the njopBangunan
     */
    public double getNjopBangunan() {
        return njopBangunan;
    }

    /**
     * @return the njopPerikanan
     */
    public double getNjopPerikanan() {
        return njopPerikanan;
    }
    
    
}
