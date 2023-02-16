/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.visual.resource.StringHelper;
import java.awt.Label;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.lang.Object;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlSalinDbkb {
    
     /*
     * method untuk mengisi Combo Box pilihan Tahun
     */
    public JComboBox getComboBoxItem(JComboBox tempCombo)
    {
        tempCombo.addItem("Pilih Tahun..");
        String sql = "select distinct thn_dhkm from ref_dhkmf order by thn_dhkm DESC";
        ResultSet set = DBFetching.getResultSet(sql);
        
        try{
           while(set.next())
           {
               tempCombo.addItem(set.getString(1));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return tempCombo;
    }
    
    
    public boolean cekSalinTujuan(String tahunTujuan, Label labelPesan, JProgressBar prosesBar)
    {
        labelPesan.setText("cek table");
        
        String sql = "select distinct thn_dhkm from ref_dhkmf where thn_dhkm = '"+tahunTujuan+"'";
        String sqlResult = DBFetching.getStringResult(sql,1);
        
        if(sqlResult == null || sqlResult.equalsIgnoreCase(""))
        {
            prosesBar.setValue(8);
            prosesBar.setString(8+"%");
            
            return true;
        }else
        {
            return false;
        }
    }
    
    public void prosesSalin(String tahunAsal,String tahunTujuan, Label labelPesan, JProgressBar prosesBar)
    {
        String sql = "select * from ref_dhkmf where thn_dhkm = '"+tahunAsal+"'";
        DBFetching.setAutoCommit(false);
        try{
            //Salin tabel ref_dhkmf
            ResultSet result = DBFetching.getResultSet(sql);
            sql = "select count(thn_dhkm) from ref_dhkmf where thn_dhkm = '"+tahunAsal+"'";
            
            while(result.next())
            {
                
                sql = "insert into ref_dhkmf(kd_dhkm,thn_dhkm,nm_dhkm,sat_dhkm,hrg_dhkm) values "
                        + " ('"+StringHelper.escapeSQL(result.getString(1))+"',"
                        + "  '"+tahunTujuan+"',"
                        + "  '"+StringHelper.escapeSQL(result.getString(3))+"',"
                        + "  '"+StringHelper.escapeSQL(result.getString(4))+"',"
                        + "  '"+Double.parseDouble(result.getString(5))+"')";
                
                DBFetching.setComandToDB(sql);
            }
            prosesBar.setValue(12);
            prosesBar.setString(12+"%");
            labelPesan.setText("Salin Tabel 1 dari 25");
            
            
            //-------------Salin Tabel proses HSKU-----------------//
            sql = "insert into pros_hsku(kd_hsku,nm_hsku,sat_hsku,vol_hsku,kd_dhkm,hrg_sat,hrg_komp,hrg_upah,hrg_tot,tahun)"
                   + " select kd_hsku,nm_hsku,sat_hsku,vol_hsku,kd_dhkm,hrg_sat,hrg_komp,hrg_upah,hrg_tot,"
                   + "  '"+tahunTujuan+"' from pros_hsku where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(16);
            prosesBar.setString(16+"%");
            labelPesan.setText("Salin Tabel 2 dari 25");
            
            //-------------Salin Tabel proses HSKM-----------------//
            sql = "insert into pros_hskm(kd_hskm,nm_hskm,sat_hskm,vol_hskm,kd_dhkm,hrg_sat,hrg_komp,hrg_upah,hrg_tot,tahun)"
                   + " select kd_hskm,nm_hskm,sat_hskm,vol_hskm,kd_dhkm,hrg_sat,hrg_komp,hrg_upah,hrg_tot,"
                   + "  '"+tahunTujuan+"' from pros_hskm where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(20);
            prosesBar.setString(20+"%");
            labelPesan.setText("Salin Tabel 3 dari 25");
            
            //-------------Salin Tabel proses HSAT-----------------//
            sql = "insert into pros_hsat(kd_hsat,nm_hsat,gol_hsat,sat_hsat,kd_strfin,stat_strfin,hrg_mat,hrg_upah,hrg_sat,tahun)"
                   + " select kd_hsat,nm_hsat,gol_hsat,sat_hsat,kd_strfin,stat_strfin,hrg_mat,hrg_upah,hrg_sat,"
                   + "  '"+tahunTujuan+"' from pros_hsat where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(24);
            prosesBar.setString(24+"%");
            labelPesan.setText("Salin Tabel 4 dari 16");
            
            //-------------Salin Tabel proses Fasilitas-----------------//
            sql = "insert into pros_fasilitas(id_fasilitas,Nama_Fasilitas,Ukuran,Faktor,Harga1,Harga2,Total,other_id,stat,tahun)"
                   + " select id_fasilitas,Nama_Fasilitas,Ukuran,Faktor,Harga1,Harga2,Total,other_id,stat,"
                   + "  '"+tahunTujuan+"' from pros_fasilitas where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(28);
            prosesBar.setString(28+"%");
            labelPesan.setText("Salin Tabel 5 dari 16");
            
            //-------------Salin Tabel proses FasilitasAC-----------------//
            sql = "insert into pros_acsplit(pk,hrg_window,hrg_split,hrg_floor,kompHrg_window,kompHrg_split,kompHrg_floor,"
                   + "ak_split,ak_window,ak_floor,tahun)"
                   + " select pk,hrg_window,hrg_split,hrg_floor,kompHrg_window,kompHrg_split,kompHrg_floor,"
                   + "ak_split,ak_window,ak_floor,"
                   + "  '"+tahunTujuan+"' from pros_acsplit where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_facsentral(id_komponen,id_other,komponen,model_satuan,model_harga,model_jumlah,model_jmlhharga,model_bobot"
                    + ", aktual_harga,aktual_jmlhharga,aktual_bobot,tahun)"
                   + " select id_komponen,id_other,komponen,model_satuan,model_harga,model_jumlah,model_jmlhharga,model_bobot"
                    + ", aktual_harga,aktual_jmlhharga,aktual_bobot,"
                   + "  '"+tahunTujuan+"' from pros_facsentral where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_facbanding(id_AcBanding,fungsi,komp_biaya,komp_bobot,aktual,tahun)"
                   + " select id_AcBanding,fungsi,komp_biaya,komp_bobot,aktual, "
                   + "  '"+tahunTujuan+"' from pros_facbanding where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            prosesBar.setValue(32);
            prosesBar.setString(32+"%");
            labelPesan.setText("Salin Tabel 6 dari 16");
            
            //-------------Salin Tabel Fasilitas Air Panas-----------------//
            sql = "insert into pros_airpanas(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_airpanas where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_koef_airpanas(id,jpb,koefisien,harga,tahun)"
                   + " select id,jpb,koefisien,harga,"
                   + "  '"+tahunTujuan+"' from pros_koef_airpanas where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //-------------Salin Tabel Fasilitas Escalator Gondola-----------------//
            sql = "insert into pros_escalator_hargaaktual(ID,komponen,model_satuan,model_harga,model_hargappnfee,id_other,tahun)"
                   + " select ID,komponen,model_satuan,model_harga,model_hargappnfee,id_other,"
                   + "  '"+tahunTujuan+"' from pros_escalator_hargaaktual where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_escalator_hargapreaktual(id,komponen,spek,harga,hargappnfee,tahun)"
                   + " select id,komponen,spek,harga,hargappnfee,"
                   + "  '"+tahunTujuan+"' from pros_escalator_hargapreaktual where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_escalator_hargabanding(id,komponen,harga,perb,tahun)"
                   + " select id,komponen,harga,perb,"
                   + "  '"+tahunTujuan+"' from pros_escalator_hargabanding where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //-------------Salin Tabel Fasilitas Genset-----------------//
            sql = "insert into pros_genset_hitung(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_genset_hitung where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_genset_prakiraan(id,Genset,harga,harga_set,rp_kva,bagi_rp_kva,tahun)"
                   + " select id,Genset,harga,harga_set,rp_kva,bagi_rp_kva,"
                   + "  '"+tahunTujuan+"' from pros_genset_prakiraan where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //-------------Salin Tabel Fasilitas Lift-----------------//
            sql = "insert into pros_flift(id_lift,komponen,model_satuan,model_harga,model_jumlah,model_jmlhharga,model_bobot"
                    + ", aktual_harga,aktual_jmlhharga,aktual_bobot,id_other,tahun)"
                   + " select id_lift,komponen,model_satuan,model_harga,model_jumlah,model_jmlhharga,model_bobot"
                    + ", aktual_harga,aktual_jmlhharga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_flift where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            
            sql = "insert into pros_fliftbanding(id_lift,jumlah_lantai,biaya,bobot,harga,tahun)"
                   + " select id_lift,jumlah_lantai,biaya,bobot,harga,"
                   + "  '"+tahunTujuan+"' from pros_fliftbanding where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas Listrik---------------------//
            sql = "insert into pros_komponen_listrik(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_komponen_listrik where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_perbandingan_listrik(id,komponen,komposisi_biaya,komposisi_koefisien,aktual,tahun)"
                   + " select id,komponen,komposisi_biaya,komposisi_koefisien,aktual,"
                   + "  '"+tahunTujuan+"' from pros_perbandingan_listrik where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas PABX---------------------//
             sql = "insert into pros_pabx(id,komponen,model_harga,model_jumlah_tetap,model_jumlah_berubah_perlt,model_jumlah_berubah_total,"
                     + "model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt"
                     + ",model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,aktual_jumlah_harga,"
                     + "aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_harga,model_jumlah_tetap,model_jumlah_berubah_perlt,model_jumlah_berubah_total,"
                     + "model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt"
                     + ",model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,aktual_jumlah_harga,"
                     + "aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_pabx where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas Pagar--------------------//
            sql = "insert into pros_pagar_kompharga(id,komponen,satuan,model_harga,model_jumlah,model_jmlhharga,"
                    + "model_bobot,aktual_harga,aktual_jumlah,aktual_jmlhharga,tahun)"
                   + " select id,komponen,satuan,model_harga,model_jumlah,model_jmlhharga,"
                    + "model_bobot,aktual_harga,aktual_jumlah,aktual_jmlhharga,"
                   + "  '"+tahunTujuan+"' from pros_pagar_kompharga where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_pagar_lain(id,tinggi,model_harga,bobot,aktual_harga,aktual_hargappnfee,tahun)"
                   + " select id,tinggi,model_harga,bobot,aktual_harga,aktual_hargappnfee,"
                   + "  '"+tahunTujuan+"' from pros_pagar_lain where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_pagar_variasitinggi(id,tinggi,jumlah_bataorbatako,jumlah_kolombeton,harga_kolombeton,jumlah_material,"
                    + "harga_material,jumlah_upah,harga_upah,harga,bobot,aktual,tahun)"
                   + " select id,tinggi,jumlah_bataorbatako,jumlah_kolombeton,harga_kolombeton,jumlah_material,"
                    + "harga_material,jumlah_upah,harga_upah,harga,bobot,aktual,"
                   + "  '"+tahunTujuan+"' from pros_pagar_variasitinggi where tahun = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas Penangkal Petir--------------------//
            sql = "insert into pros_penangkal_petir(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_penangkal_petir where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas Limbah--------------------//
             sql = "insert into pros_limbah_harga(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,model_bobot"
                    + ", aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_limbah_harga where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
             sql = "insert into pros_limbah_jpb(id,kriteria,koefisien,harga,tahun)"
                   + " select id,kriteria,koefisien,harga,"
                   + "  '"+tahunTujuan+"' from pros_limbah_jpb where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas Plumbing--------------------//
             sql = "insert into pros_plumbing_perhitungan(id,komponen,model_harga,model_jumlah_tetap,model_jumlah_berubah_perlt,model_jumlah_berubah_total,"
                     + "model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt"
                     + ",model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,aktual_jumlah_harga,"
                     + "aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_harga,model_jumlah_tetap,model_jumlah_berubah_perlt,model_jumlah_berubah_total,"
                     + "model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt"
                     + ",model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,aktual_jumlah_harga,"
                     + "aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_plumbing_perhitungan where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_plumbing_koefisien(jumlah_lantai,modifikasi,asli,kriteria,koef,tahun)"
                   + " select jumlah_lantai,modifikasi,asli,kriteria,koef,"
                   + "  '"+tahunTujuan+"' from pros_plumbing_koefisien where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
           
            //----------------Salin Tabel Fasilitas ProteksiApi--------------------//
            
            sql = "insert into pros_proteksi_api(id,komponen,sat,model_harga,model_jumlah_tetap,"
                    + "model_jumlah_berubah_perlt,model_jumlah_berubah_total"
                    + ",model_totaljumlah,model_harga_tetap,model_harga_berubah_hydrant,"
                    + "model_harga_berubah_sprinkle,model_jumlah_harga,model_bobot,model_keterangan"
                    + ",aktual_harga,aktual_jmlhharga_tetap,aktual_jmlhharga_berubah_hydrant,aktual_jmlhharga_berubah_sprinkle"
                    + ",aktual_bobot,aktual_keterangan,id_other,tahun)"
                    
                   + " select id,komponen,sat,model_harga,model_jumlah_tetap,"
                    + "model_jumlah_berubah_perlt,model_jumlah_berubah_total"
                    + ",model_totaljumlah,model_harga_tetap,model_harga_berubah_hydrant,"
                    + "model_harga_berubah_sprinkle,model_jumlah_harga,model_bobot,model_keterangan"
                    + ",aktual_harga,aktual_jmlhharga_tetap,aktual_jmlhharga_berubah_hydrant,aktual_jmlhharga_berubah_sprinkle"
                    + ",aktual_bobot,aktual_keterangan,id_other,"
                   + "  '"+tahunTujuan+"' from pros_proteksi_api where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "insert into pros_proteksi_api_lain(id,komponen,model_sat,model_harga,model_jumlah_tetap,"
                    + " model_jumlah_berubah_perlt,model_jumlah_berubah_total,model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt,"
                    + "model_harga_berubah_total,model_jumlah_harga,model_bobot,model_keterangan,aktual_harga,"
                    + "aktual_jumlah_harga,aktual_bobot,aktual_keterangan,id_other,tahun)"
                   + " select id,komponen,model_sat,model_harga,model_jumlah_tetap,"
                    + " model_jumlah_berubah_perlt,model_jumlah_berubah_total,model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt,"
                    + "model_harga_berubah_total,model_jumlah_harga,model_bobot,model_keterangan,aktual_harga,"
                    + "aktual_jumlah_harga,aktual_bobot,aktual_keterangan,id_other,"
                   + "  '"+tahunTujuan+"' from pros_proteksi_api_lain where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
             //----------------Salin Tabel Fasilitas sumur artesis--------------------//
             sql = "insert into pros_sumurartesis(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_sumurartesis where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas tata suara--------------------//
            sql = "insert into pros_tata_suara(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,keterangan,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,keterangan,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_tata_suara where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);   
            
            //----------------Salin Tabel Fasilitas TV--------------------//
            sql = "insert into pros_tv(id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah,model_jumlah_harga,"
                     + "model_bobot,aktual_harga,aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_tv where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            //----------------Salin Tabel Fasilitas TVIntercom--------------------//
            sql = "insert into pros_video_interkom(id,komponen,model_satuan,model_harga,model_jumlah_tetap,"
                    + " model_jumlah_berubah_perlt,model_jumlah_berubah_total,model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt,"
                    + "model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,"
                    + "aktual_jumlah_harga,aktual_bobot,id_other,tahun)"
                   + " select id,komponen,model_satuan,model_harga,model_jumlah_tetap,"
                    + " model_jumlah_berubah_perlt,model_jumlah_berubah_total,model_total_jumlah,model_harga_tetap,model_harga_berubah_perlt,"
                    + "model_harga_berubah_total,model_jumlah_harga,model_bobot,aktual_harga,"
                    + "aktual_jumlah_harga,aktual_bobot,id_other,"
                   + "  '"+tahunTujuan+"' from pros_video_interkom where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            
            
            //-------------Salin Tabel hasil Fasilitas-----------------//
            sql = "insert into rslt_fasilitas(ID,JenisKomponen,Harga,Satuan,Tahun)"
                   + " select ID,JenisKomponen,Harga,Satuan,"
                   + "  '"+tahunTujuan+"' from rslt_fasilitas where Tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(36);
            prosesBar.setString(36+"%");
            labelPesan.setText("Salin Tabel 7 dari 16");
            
             //-------------Salin Tabel hasil Fasilitas Kolam-----------------//
            sql = "insert into rslt_fasilitaskolam(ID,luas,plester,pelapis,Tahun)"
                   + " select ID,luas,plester,pelapis,"
                   + "  '"+tahunTujuan+"' from rslt_fasilitaskolam where Tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(40);
            prosesBar.setString(40+"%");
            labelPesan.setText("Salin Tabel 8 dari 16");
            
             //-------------Salin Tabel hasil Fasilitas Lapangan Tenis-----------------//
            sql = "insert into rslt_fasilitaslaptenis(ID,Jenis_Lantai,SatuBan_DgLampu,SatuBan_TnpLampu,LSatuBan_DgLampu,"
                   + "LSatuBan_TnpLampu,Tahun)"
                   + " select ID,Jenis_Lantai,SatuBan_DgLampu,SatuBan_TnpLampu,LSatuBan_DgLampu,"
                   + " LSatuBan_TnpLampu,"
                   + "  '"+tahunTujuan+"' from rslt_fasilitaslaptenis where Tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(44);
            prosesBar.setString(48+"%");
            labelPesan.setText("Salin Tabel 9 dari 16");
            
             //-------------Salin Tabel hasil Fasilitas Plumbing-----------------//
            sql = "insert into rslt_fasilitasplumbing (id,jumlah_lantai,JPB2,JPB4,JPB5,JPB7,JPB12,JPB13,Tahun)"
                   + " select id,jumlah_lantai,JPB2,JPB4,JPB5,JPB7,JPB12,JPB13,"
                   + " '"+tahunTujuan+"' from rslt_fasilitasplumbing where Tahun = '"+tahunAsal+"'";
            System.out.println(sql);
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(48);
            prosesBar.setString(48+"%");
            labelPesan.setText("Salin Tabel 10 dari 25");
            
            //-------------Salin Tabel Proses Jpb1 Lt1 -----------------//
            sql = "insert into pros_jpb1_lt1(kd_jpb1lt1,nm_jpb1lt1,qt_jpb1lt1,sat_jpb1lt1,vol_jpb1lt1,stat_jpb1lt1,"
                   + "kd_strfin,hrg_mat,hrg_sat,hrg_tot,hrg_grtot,tahun_jpb1lt1)"
                   + " select kd_jpb1lt1,nm_jpb1lt1,qt_jpb1lt1,sat_jpb1lt1,vol_jpb1lt1,stat_jpb1lt1,"
                   + "kd_strfin,hrg_mat,hrg_sat,hrg_tot,hrg_grtot,"
                   + "  '"+tahunTujuan+"' from pros_jpb1_lt1 where tahun_jpb1lt1 = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(52);
            prosesBar.setString(52+"%");
            labelPesan.setText("Salin Tabel 11 dari 25");
            
             //-------------Salin Tabel hasil Proses Jpb1 Lt2to4 -----------------//
            sql = "insert into pros_jpb1_lt2to4(kd_jpb1lt2to4,nm_jpb1lt2to4,sat_jpb1lt2to4,vol_jpb1lt2to4,stat_jpb1lt2to4,"
                   + "kd_strfin,hrg_mat,hrg_tot,hrg_grtot,tahun_jpb1lt2to4)"
                   + " select kd_jpb1lt2to4,nm_jpb1lt2to4,sat_jpb1lt2to4,vol_jpb1lt2to4,stat_jpb1lt2to4,"
                   + "kd_strfin,hrg_mat,hrg_tot,hrg_grtot,"
                   + "  '"+tahunTujuan+"' from pros_jpb1_lt2to4 where tahun_jpb1lt2to4 = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(56);
            prosesBar.setString(56+"%");
            labelPesan.setText("Salin Tabel 12 dari 25");
            
            //-------------Salin Tabel hasil JPB1 lt1-----------------//
            sql = "insert into rslt_jpb1_lt1(id_jpb1lt1,thn_dbkb,ls_min,ls_max,beton,kayu,baja,bata)"
                   + " select id_jpb1lt1,"
                   + "  '"+tahunTujuan+"' ,ls_min,ls_max,beton,kayu,baja,bata from rslt_jpb1_lt1 where thn_dbkb = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(60);
            prosesBar.setString(60+"%");
            labelPesan.setText("Salin Tabel 13 dari 25");
            
            //-------------Salin Tabel hasil JPB1 lt2-----------------//
            sql = "insert into rslt_jpb1_lt2(id_jpb1lt2,thn_dbkb,ls_min,ls_max,beton,kayu,baja,faktor)"
                   + " select id_jpb1lt2,"
                   + "  '"+tahunTujuan+"' ,ls_min,ls_max,beton,kayu,baja,faktor from rslt_jpb1_lt2 where thn_dbkb = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(64);
            prosesBar.setString(64+"%");
            labelPesan.setText("Salin Tabel 14 dari 25");
            
            //-------------Salin Tabel proses Expected Cost Jpb2 -----------------//
            sql = "insert into pros_expectedcost_jpb2lt10"
                   + "(jumlah_lantai,pre,sub,tower,stair,roof,sbt,ppnfee,sat,area,dbkb,tahun)"
                   + " select jumlah_lantai,pre,sub,tower,stair,roof,sbt,ppnfee,sat,area,dbkb,"
                   + "  '"+tahunTujuan+"' from pros_expectedcost_jpb2lt10 where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(68);
            prosesBar.setString(68+"%");
            labelPesan.setText("Salin Tabel 15 dari 25");
            
            //-------------Salin Tabel proses Rekap Jpb2 lt10-----------------//
            sql = "insert into pros_rekap_jpb2lt10"
                   + "(jumlah_lantai,str_cum,persen,pre,tot,area,dbkb,tahun)"
                   + " select jumlah_lantai,str_cum,persen,pre,tot,area,dbkb,"
                   + "  '"+tahunTujuan+"' from pros_rekap_jpb2lt10 where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);        
            prosesBar.setValue(72);
            prosesBar.setString(72+"%");
            labelPesan.setText("Salin Tabel 16 dari 25");
            
            //-------------Salin Tabel proses fordat Jpb2-----------------//
            sql = "insert into pros_fordat"
                   + "(id_fordat,jumlah_lantai,y,u,log_y,u_log_y,u2,log_y2,pol,exp,diff,tahun)"
                   + " select id_fordat,jumlah_lantai,y,u,log_y,u_log_y,u2,log_y2,pol,exp,diff,"
                   + "  '"+tahunTujuan+"' from pros_fordat where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);        
            prosesBar.setValue(76);
            prosesBar.setString(76+"%");
            labelPesan.setText("Salin Tabel 17 dari 25");
            
            //-------------Salin Tabel proses dbkb jpb2------------------//
            sql = "insert into pros_dbkb_jpb2"
                   + "(jumlah_lantai,dbkb_perlantai,dbkb_kumulatif,tahun)"
                   + " select jumlah_lantai,dbkb_perlantai,dbkb_kumulatif,"
                   + "  '"+tahunTujuan+"' from pros_dbkb_jpb2 where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);        
            prosesBar.setValue(80);
            prosesBar.setString(80+"%");
            labelPesan.setText("Salin Tabel 18 dari 25");
            
            
            //-------------Salin Tabel proses statistik jpb2------------------//
            sql = "insert into pros_statistik"
                   + "(id_stat,jumlah_lantai,cum,avg1,avg2,smooth,tahun)"
                   + " select id_stat,jumlah_lantai,cum,avg1,avg2,smooth,"
                   + "  '"+tahunTujuan+"' from pros_statistik where tahun = '"+tahunAsal+"'";
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(85);
            prosesBar.setString(85+"%");
            labelPesan.setText("Salin Tabel 25 dari 25");
            
            
            //-------------Salin Tabel Proses Jpb2 Lt10 -----------------//
            sql = "insert into pros_jpb2_lt10(kd_jpb2lt10,nm_jpb2lt10,unit_jpb2lt10,qt_jpb2lt10,material_jpb2lt10,"
                   + "upah_jpb2lt10,jumlah_jpb2lt10,kd_other,stat_jpb2lt10,tambahMat_jpb2lt10,faktor_jpb2lt10"
                   + ",tahun_jpb2lt10)"
                   + " select kd_jpb2lt10,nm_jpb2lt10,unit_jpb2lt10,qt_jpb2lt10,material_jpb2lt10,"
                   + "upah_jpb2lt10,jumlah_jpb2lt10,kd_other,stat_jpb2lt10,tambahMat_jpb2lt10,faktor_jpb2lt10,"
                   + "  '"+tahunTujuan+"' from pros_jpb2_lt10 where tahun_jpb2lt10 = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
             prosesBar.setValue(90);
             prosesBar.setString(90+"%");
             labelPesan.setText("Salin Tabel 20 dari 25");
            
             //-------------Salin Tabel Proses Jpb2 Lt32 -----------------//
             sql = "insert into pros_jpb2_lt32(kd_jpb2lt32,nm_jpb2lt32,sat_jpb2lt32,qt_jpb2lt32,material_jpb2lt32,"
                   + "upah_jpb2lt32,biaya_jpb2lt32,total_jpb2lt32,persen_jpb2lt32,kd_other,stat_jpb2lt32"
                   + ",tahun_jpb2lt32)"
                   + " select kd_jpb2lt32,nm_jpb2lt32,sat_jpb2lt32,qt_jpb2lt32,material_jpb2lt32,"
                   + " upah_jpb2lt32,biaya_jpb2lt32,total_jpb2lt32,persen_jpb2lt32,kd_other,stat_jpb2lt32,"
                   + "  '"+tahunTujuan+"' from pros_jpb2_lt32 where tahun_jpb2lt32 = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
            prosesBar.setValue(95);
            prosesBar.setString(95+"%");
            labelPesan.setText("Salin Tabel 21 dari 25");
            
            
             //-------------Salin Tabel Proses Jpb4 -----------------//
             sql = "insert into pros_dbkb_jpb4(jumlah_lantai,dbkb_perlantai,lt_kumulatif,dbkb_kumulatif,tahun)"
                   + " select jumlah_lantai,dbkb_perlantai,lt_kumulatif,dbkb_kumulatif,"
                   + "  '"+tahunTujuan+"' from pros_dbkb_jpb4 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_jpb4(id,Deskripsi,unit,quantity,material,upah,cost,jenis_other,faktor,id_other,tahun)"
                   + " select id,Deskripsi,unit,quantity,material,upah,cost,jenis_other,faktor,id_other,"
                   + "  '"+tahunTujuan+"' from pros_jpb4 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_ku_jpb4(jumlah_lt,STR_CUM,"
                     + "persen,pre,"
                     + "sub,"
                     + "tot,area,dbkb,tahun)"
                   + " select jumlah_lt,STR_CUM,"
                     + "persen,pre,"
                     + "sub,"
                     + "tot,area,dbkb,"
                   + "  '"+tahunTujuan+"' from pros_ku_jpb4 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             
             //-------------Salin Tabel Proses Jpb12 -----------------//
             sql = "insert into pros_dbkb_jpb12(jumlah_lantai,dbkb_perlantai,dbkb_kumulatif,tahun)"
                   + " select jumlah_lantai,dbkb_perlantai,dbkb_kumulatif,"
                   + "  '"+tahunTujuan+"' from pros_dbkb_jpb12 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_jpb12(id,jenis_pekerjaan,unit,volume,material,upah,cost,jenis_other,faktor_material,faktor_upah,id_other,tahun)"
                   + " select id,jenis_pekerjaan,unit,volume,material,upah,cost,jenis_other,faktor_material,faktor_upah,id_other,"
                   + "  '"+tahunTujuan+"' from pros_jpb12 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_ku_jpb12(jumlah_lantai,str,roof,stair,precast,pre,preharga,sub,subharga,total,area,dbkb,tahun)"
                   + " select jumlah_lantai,str,roof,stair,precast,pre,preharga,sub,subharga,total,area,dbkb,"
                   + "  '"+tahunTujuan+"' from pros_ku_jpb12 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             //-------------Salin Tabel Proses Jpb13 -----------------//
             
             sql = "insert into pros_jpb13(id,deskripsi,unit,quantity,material,upah,cost,jenis_idother,id_other_material,id_other_upah,faktor,tahun)"
                   + " select id,deskripsi,unit,quantity,material,upah,cost,jenis_idother,id_other_material,id_other_upah,faktor,"
                   + "  '"+tahunTujuan+"' from pros_jpb13 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_jpb13_2(id,deskripsi,unit,quantity,material,upah,cost,jenis_idother,id_other_material,id_other_upah,faktor,tahun)"
                   + " select id,deskripsi,unit,quantity,material,upah,cost,jenis_idother,id_other_material,id_other_upah,faktor,"
                   + "  '"+tahunTujuan+"' from pros_jpb13_2 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             
              //-------------Salin Tabel Proses JpbBsm -----------------//
             
             sql = "insert into pros_jpb_bsm(id,jenis_pekerjaan,unit,volume,material,upah,cost,id_other_material,id_other_upah,jenis_other,faktor,tahun)"
                   + " select id,jenis_pekerjaan,unit,volume,material,upah,cost,id_other_material,id_other_upah,jenis_other,faktor,"
                   + "  '"+tahunTujuan+"' from pros_jpb_bsm where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_jpb_bsm_2(id,jenis_pekerjaan,unit,volume,material,upah,cost,id_other_material,id_other_upah,jenis_other,tahun)"
                   + " select id,jenis_pekerjaan,unit,volume,material,upah,cost,id_other_material,id_other_upah,jenis_other,"
                   + "  '"+tahunTujuan+"' from pros_jpb_bsm_2 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             sql = "insert into rslt_ku_bsm(jumlah_lantai,jenis,unit,nilai,tahun)"
                   + " select jumlah_lantai,jenis,unit,nilai,"
                   + "  '"+tahunTujuan+"' from rslt_ku_bsm where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
             
             //-------------Salin Tabel Proses Jpb14 -----------------//
             sql = "insert into pros_jpb14(id,keterangan,sat,vol,hrg1,hrg2,hrg3,hrg4,hrg5,id_other,faktor,tahun)"
                   + " select id,keterangan,sat,vol,hrg1,hrg2,hrg3,hrg4,hrg5,id_other,faktor,"
                   + "  '"+tahunTujuan+"' from pros_jpb14 where tahun = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
             
             sql = "insert into rslt_ku_jpb14(id,jumlah_kanopi,satuan,nilai,tahun)"
                   + " select id,jumlah_kanopi,satuan,nilai,"
                   + "  '"+tahunTujuan+"' from rslt_ku_jpb14 where tahun = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
             
             
             
             //-------------Salin Tabel Proses Jpb7 -----------------//
             sql = "insert into pros_dbkb_jpb7(jumlah_lt,dbkb_perlantai,dbkb_kumulatif,tahun)"
                   + " select jumlah_lt,dbkb_perlantai,dbkb_kumulatif,"
                   + "  '"+tahunTujuan+"' from pros_dbkb_jpb7 where tahun = '"+tahunAsal+"'";
             
             DBFetching.setComandToDB(sql);
       
             
             sql = "insert into pros_jpb7(id,uraian_pekerjaan,unit,quantity,material,upah,jumlah,jenis_other,id_other,faktor_material,faktor_upah,tahun)"
                   + " select id,uraian_pekerjaan,unit,quantity,material,upah,jumlah,jenis_other,id_other,faktor_material,faktor_upah,"
                   + "  '"+tahunTujuan+"' from pros_jpb7 where tahun = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
             
             sql = "insert into pros_ku_jpb7(jumlah_lt,str_cum,persen,pre,precast,sub,tot,area,dbkb,tahun)"
                   + " select jumlah_lt,str_cum,persen,pre,precast,sub,tot,area,dbkb,"
                   + "  '"+tahunTujuan+"' from pros_ku_jpb7 where tahun = '"+tahunAsal+"'";
             DBFetching.setComandToDB(sql);
            
            //-----------Salin Tabel hasil JPB 3 dan 8--------------//
            sql = "insert into rslt_jpb38(jns_jpb,satuan,lbr_btg_min,lbr_btg_max,ting_kol_min,ting_kol_max,satuan_rph,nilai,thn_penilaian)"
                   + " select jns_jpb,satuan,lbr_btg_min,lbr_btg_max,ting_kol_min,ting_kol_max,satuan_rph,nilai,"
                   + "  '"+tahunTujuan+"' from rslt_jpb38 where thn_penilaian = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            
            //-----------Salin Tabel rslt_dy_dkg--------------//
            sql = "insert into rslt_dy_dkg(dy_dkg_min,dy_dkg_max,type_kons,biaya,thn_dy_dkg)"
                   + " select dy_dkg_min,dy_dkg_max,type_kons,biaya,"
                   + "  '"+tahunTujuan+"' from rslt_dy_dkg where thn_dy_dkg = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            
            //-----------Salin Tabel rslt_mezzanine--------------//
            sql = "insert into rslt_mezzanine(kd_jpb,satuan,nilai,thn_penilaian)"
                   + " select kd_jpb,satuan,nilai,"
                   + "  '"+tahunTujuan+"' from rslt_mezzanine where thn_penilaian = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            
            
             
            //-------------Salin Tabel hasil JPB lebih 4 lantai-----------------//
            sql = "insert into rslt_ku_lbh_4lt(jumlah_lantai,jpb_2dan9,jpb_4,jpb_5,jpb_6,jpb_7,jpb_12,jpb_13,jpb_16,thn_dbkb)"
                   + " select jumlah_lantai,jpb_2dan9,jpb_4,jpb_5,jpb_6,jpb_7,jpb_12,jpb_13,jpb_16,"
                   + "  '"+tahunTujuan+"' from rslt_ku_lbh_4lt where thn_dbkb = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(96);
            prosesBar.setString(96+"%");
            labelPesan.setText("Salin Tabel 22 dari 25");
            
            
            
            //---------------Salin Tabel Golongan Material-------------------------//
            sql = "insert into ref_golmaterial(id_golMaterial,nama,harga,hsat_id1,hsat_id2,tahun)"
                   + " select id_golMaterial,nama,harga,hsat_id1,hsat_id2,"
                   + "  '"+tahunTujuan+"' from ref_golmaterial where tahun = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(97);
            prosesBar.setString(97+"%");
            labelPesan.setText("Salin Tabel 23 dari 25");
            
            //--------------Salin Tabel Faktor Material--------------------------//
            sql = "insert into ref_faktormaterial(jml_lt,faktor,tahun)"
                   + " select jml_lt,faktor,"
                   + "  '"+tahunTujuan+"' from ref_faktormaterial where tahun = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(98);
            prosesBar.setString(98+"%");
            labelPesan.setText("Salin Tabel 24 dari 25");
            
            //--------------Salin Tabel Result Material--------------------------//
            sql = "insert into rslt_material(jmlh_lt,thn_rslt,AA1,AB1,AC1,AD1,AD2,AE1,AF1,AG1,AG2,"
                   + "BA1,BB1,BC1,BD1,BE1,BF1,BG1,BG2,"
                   + "CA1,CB1,CB2,CC1,CC2,CC3,CD1,CD2,CD3,CE1,CF1,CG1,"
                   + "DA1,DA2,DB1,DB2,DC1,DC2,DC3,DC4,DD1,DD2,DF1,DF2,DF3,DF4,"
                   + "DG1,DG2,DG3,DG4,DG5,DG6,DG7)"
                   + " select jmlh_lt,"
                   + "  '"+tahunTujuan+"', AA1,AB1,AC1,AD1,AD2,AE1,AF1,AG1,AG2,"
                   + "BA1,BB1,BC1,BD1,BE1,BF1,BG1,BG2,"
                   + "CA1,CB1,CB2,CC1,CC2,CC3,CD1,CD2,CD3,CE1,CF1,CG1,"
                   + "DA1,DA2,DB1,DB2,DC1,DC2,DC3,DC4,DD1,DD2,DF1,DF2,DF3,DF4,"
                   + "DG1,DG2,DG3,DG4,DG5,DG6,DG7"
                   + " from rslt_material where thn_rslt = '"+tahunAsal+"'";
           
            DBFetching.setComandToDB(sql);
            prosesBar.setValue(100);
            prosesBar.setString(100+"%");
            labelPesan.setText("Salin Tabel 25 dari 25");
            
       
            DBFetching.Simpan();
        }catch(Exception e)
        {
            prosesBar.setValue(0);
           DBFetching.RollBackDB();
           e.printStackTrace();
        }
        
        
        
        
    }

    
    
}
