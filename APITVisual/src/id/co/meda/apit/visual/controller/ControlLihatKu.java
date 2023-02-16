/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.Jpb1KomponenUtama;
import id.co.meda.apit.enggine.dbkb.model.Jpb38Ku;
import id.co.meda.apit.enggine.dbkb.model.JpbBsmKu;
import id.co.meda.apit.enggine.dbkb.model.JpbDayaDukungKu;
import id.co.meda.apit.enggine.dbkb.model.JpbLbh4ltKu;
import id.co.meda.apit.enggine.dbkb.model.JpbMezzaineKu;
import id.co.meda.apit.enggine.dbkb.model.jpb14Ku;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlLihatKu {
    
    private ArrayList <Jpb1KomponenUtama> KuJpb1lt1;
    private ArrayList <Jpb1KomponenUtama> KuJpb1lt2;
    private ArrayList <JpbLbh4ltKu> KuJpbLbh4lt;
    private ArrayList <jpb14Ku> KuJpb14;
    private ArrayList <JpbBsmKu> KuJpbBsm;
    private ArrayList <Jpb38Ku> KuJpb3;
    private ArrayList <Jpb38Ku> KuJpb8;
    private ArrayList <JpbMezzaineKu> KuJpbMezzaine;
    private ArrayList <JpbDayaDukungKu> KuJpbDaya;
    
    
    public ControlLihatKu()
    {
        KuJpb1lt1 = new ArrayList <Jpb1KomponenUtama>();
        KuJpb1lt2 = new ArrayList <Jpb1KomponenUtama>();
        KuJpbLbh4lt = new ArrayList <JpbLbh4ltKu>();
        KuJpb14 = new ArrayList <jpb14Ku>();
        KuJpbBsm = new ArrayList <JpbBsmKu> ();
        KuJpb3 = new ArrayList <Jpb38Ku> ();
        KuJpb8 = new ArrayList <Jpb38Ku> ();
        KuJpbMezzaine = new ArrayList <JpbMezzaineKu> ();
        KuJpbDaya = new ArrayList <JpbDayaDukungKu> ();
    }
    
    public JComboBox getComboBoxItem(JComboBox tempCombo)
    {
        tempCombo.addItem("Pilih Tahun..");
        String sql = "select distinct thn_dhkm from ref_dhkmf";
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
    
    public DefaultTableModel getTableModelJpb1Lt1(String tahunDBKB)
    {
        try{
            String sql = "select ls_min,ls_max,beton,kayu,baja from rslt_jpb1_lt1 "
                         + "where thn_dbkb = '"+tahunDBKB+"'";
           ResultSet result = DBFetching.getResultSet(sql);
            
            
            while(result.next())
            {
                Jpb1KomponenUtama ku = new Jpb1KomponenUtama();
                ku.setLuasMin(Integer.parseInt(result.getString(1)));
                ku.setLuasMax(Integer.parseInt(result.getString(2)));
                ku.setHrgBeton(Double.parseDouble(result.getString(3)));
                ku.setHrgKayu(Double.parseDouble(result.getString(4)));
                ku.setHrgBaja(Double.parseDouble(result.getString(5)));
                KuJpb1lt1.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Luas Min");
        header.add(1,"Luas Max");
        header.add(2,"Harga Beton");
        header.add(3,"Harga Kayu");
        header.add(4,"Harga Baja");
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpb1lt1.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpb1lt1.get(i).getLuasMin());
                vecData.add(KuJpb1lt1.get(i).getLuasMax());
                vecData.add(KuJpb1lt1.get(i).getHrgBeton());
                vecData.add(KuJpb1lt1.get(i).getHrgKayu());
                vecData.add(KuJpb1lt1.get(i).getHrgBaja());
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header){
            
            @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 0:return Integer.class;
                    case 1:return Integer.class;
                    default: return Double.class;    
                }
            }
        
        };
        return tableKu;
        
    }
    
    public DefaultTableModel getTableModelJpb1Lt2(String tahunDBKB)
    {
        try{
            String sql = "select ls_min,ls_max,faktor,beton,kayu,baja from rslt_jpb1_lt2 "
                         + "where thn_dbkb = '"+tahunDBKB+"'";
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                Jpb1KomponenUtama ku = new Jpb1KomponenUtama();
                ku.setLuasMin(Integer.parseInt(result.getString(1)));
                ku.setLuasMax(Integer.parseInt(result.getString(2)));
                ku.setFaktor(Double.parseDouble(result.getString(3)));
                ku.setHrgBeton(Double.parseDouble(result.getString(4)));
                ku.setHrgKayu(Double.parseDouble(result.getString(5)));
                ku.setHrgBaja(Double.parseDouble(result.getString(6)));
                KuJpb1lt2.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Luas Min");
        header.add(1,"Luas Max");
        header.add(2,"Faktor");
        header.add(3,"Harga Beton");
        header.add(4,"Harga Kayu");
        header.add(5,"Harga Baja");
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpb1lt2.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpb1lt2.get(i).getLuasMin());
                vecData.add(KuJpb1lt2.get(i).getLuasMax());
                vecData.add(KuJpb1lt2.get(i).getFaktor());
                vecData.add(KuJpb1lt2.get(i).getHrgBeton());
                vecData.add(KuJpb1lt2.get(i).getHrgKayu());
                vecData.add(KuJpb1lt2.get(i).getHrgBaja());
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 0:return Integer.class;
                    case 1:return Integer.class;
                    default: return Double.class;    
                }
            }
        
        };
        return tableKu;
        
    }

    public DefaultTableModel getTableModelJpbLbh4lt(String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_ku_lbh_4lt "
                         + "where thn_dbkb = '"+tahunDBKB+"'";
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                JpbLbh4ltKu ku = new JpbLbh4ltKu();
                ku.setJumlahLantai(Integer.parseInt(result.getString(1)));
                ku.setJpb2dan9(Double.parseDouble(result.getString(2)));
                ku.setJpb4(Double.parseDouble(result.getString(3)));
                ku.setJpb5(Double.parseDouble(result.getString(4)));
                ku.setJpb6(Double.parseDouble(result.getString(5)));
                ku.setJpb7(Double.parseDouble(result.getString(6)));
                ku.setJpb12(Double.parseDouble(result.getString(7)));
                ku.setJpb13(Double.parseDouble(result.getString(8)));
                ku.setJpb16(Double.parseDouble(result.getString(9)));
                KuJpbLbh4lt.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Jumlah Lantai");
        header.add(1,"JPB 2 dan 9");
        header.add(2,"JPB 4");
        header.add(3,"JPB 5");
        header.add(4,"JPB 6");
        header.add(5,"JPB 7");
        header.add(6,"JPB 12");
        header.add(7,"JPB 13");
        header.add(8,"JPB 16");
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpbLbh4lt.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpbLbh4lt.get(i).getJumlahLantai());
                vecData.add(KuJpbLbh4lt.get(i).getJpb2dan9());
                vecData.add(KuJpbLbh4lt.get(i).getJpb4());
                vecData.add(KuJpbLbh4lt.get(i).getJpb5());
                vecData.add(KuJpbLbh4lt.get(i).getJpb6());
                vecData.add(KuJpbLbh4lt.get(i).getJpb7());
                vecData.add(KuJpbLbh4lt.get(i).getJpb12());
                vecData.add(KuJpbLbh4lt.get(i).getJpb13());
                vecData.add(KuJpbLbh4lt.get(i).getJpb16());
                
                
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 0:return Integer.class;
                    default: return Double.class;    
                }
            }
        };
        return tableKu;
    }
    
    
    public DefaultTableModel getTableModelJpbBsm(String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_ku_bsm "
                         + "where tahun = '"+tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                JpbBsmKu ku = new JpbBsmKu();
                ku.setJumlah_lantai(Integer.parseInt(result.getString(1)));
                ku.setJenis(result.getString(2));
                ku.setUnit(result.getString(3));
                ku.setNilai(Double.parseDouble(result.getString(4)));
                KuJpbBsm.add(ku);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Jumlah Lantai");
        header.add(1,"Jenis");
        header.add(2,"Satuan");
        header.add(3,"Nilai");
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpbBsm.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpbBsm.get(i).getJumlah_lantai());
                vecData.add(KuJpbBsm.get(i).getJenis());
                vecData.add(KuJpbBsm.get(i).getUnit());
                vecData.add(KuJpbBsm.get(i).getNilai());
                
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 3:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;
    }
    
    
    public DefaultTableModel getTableModelJpb14(String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_ku_jpb14 "
                         + "where tahun = '"+tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                jpb14Ku ku = new jpb14Ku();
                ku.setJumlah_kanopi(result.getString(2));
                ku.setSatuan(result.getString(3));
                ku.setNilai(Double.parseDouble(result.getString(4)));
                KuJpb14.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Jumlah Kanopi");
        header.add(1,"Satuan");
        header.add(2,"Nilai");
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpb14.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpb14.get(i).getJumlah_kanopi());
                vecData.add(KuJpb14.get(i).getSatuan());
                vecData.add(KuJpb14.get(i).getNilai());
                
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 2:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;
        
    }
    
    public DefaultTableModel getTableModelJpb3(String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_jpb38 "
                         + "where thn_penilaian = '"+tahunDBKB+"' and jns_jpb = 'JPB3'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                Jpb38Ku ku = new Jpb38Ku();
                ku.setId(Integer.parseInt(result.getString(1)));
                ku.setThn_penilaian(result.getString(2));
                ku.setJns_jpb(result.getString(3));
                ku.setSatuan(result.getString(4));
                ku.setLbr_btg_min(Integer.parseInt(result.getString(5)));
                ku.setLbr_btg_max(Integer.parseInt(result.getString(6)));
                ku.setTing_kol_min(Integer.parseInt(result.getString(7)));
                ku.setTing_kol_max(Integer.parseInt(result.getString(8)));
                ku.setSatuan_rph(result.getString(9));
                ku.setNilai(Double.parseDouble(result.getString(10)));
                KuJpb3.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Satuan");
        header.add(1,"lebar_bentang_min");
        header.add(2,"lebar_bentang_max");
        header.add(3,"tinggi_kolom_min");
        header.add(4,"tinggi_kolom_max");
        header.add(5,"satuan_rph");
        header.add(6,"nilai");
        
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpb3.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpb3.get(i).getSatuan());
                vecData.add(KuJpb3.get(i).getLbr_btg_min());
                vecData.add(KuJpb3.get(i).getLbr_btg_max());
                vecData.add(KuJpb3.get(i).getTing_kol_min());
                vecData.add(KuJpb3.get(i).getTing_kol_max());
                vecData.add(KuJpb3.get(i).getSatuan_rph());
                vecData.add(KuJpb3.get(i).getNilai());
                
                
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 6:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;
    }
    
    
     public DefaultTableModel getTableModelJpb8 (String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_jpb38 "
                         + "where thn_penilaian = '"+tahunDBKB+"' and jns_jpb = 'JPB8'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                Jpb38Ku ku = new Jpb38Ku();
                ku.setId(Integer.parseInt(result.getString(1)));
                ku.setThn_penilaian(result.getString(2));
                ku.setJns_jpb(result.getString(3));
                ku.setSatuan(result.getString(4));
                ku.setLbr_btg_min(Integer.parseInt(result.getString(5)));
                ku.setLbr_btg_max(Integer.parseInt(result.getString(6)));
                ku.setTing_kol_min(Integer.parseInt(result.getString(7)));
                ku.setTing_kol_max(Integer.parseInt(result.getString(8)));
                ku.setSatuan_rph(result.getString(9));
                ku.setNilai(Double.parseDouble(result.getString(10)));
                KuJpb8.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Satuan");
        header.add(1,"lebar_bentang_min");
        header.add(2,"lebar_bentang_max");
        header.add(3,"tinggi_kolom_min");
        header.add(4,"tinggi_kolom_max");
        header.add(5,"satuan_rph");
        header.add(6,"nilai");
        
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpb8.size();i++)
        {
            
                Vector vecData = new Vector();
                vecData.add(KuJpb8.get(i).getSatuan());
                vecData.add(KuJpb8.get(i).getLbr_btg_min());
                vecData.add(KuJpb8.get(i).getLbr_btg_max());
                vecData.add(KuJpb8.get(i).getTing_kol_min());
                vecData.add(KuJpb8.get(i).getTing_kol_max());
                vecData.add(KuJpb8.get(i).getSatuan_rph());
                vecData.add(KuJpb8.get(i).getNilai());
                
                
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 6:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;
    }
    
     
    public DefaultTableModel getTableModelJpbMezz (String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_mezzanine "
                         + "where thn_penilaian = '"+tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                JpbMezzaineKu ku = new JpbMezzaineKu();
                ku.setId(Integer.parseInt(result.getString(1)));
                ku.setThn_penilaian(result.getString(2));
                ku.setKd_jpb(result.getString(3));
                ku.setSatuan(result.getString(4));
                ku.setNilai(Double.parseDouble(result.getString(5)));
                KuJpbMezzaine.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"Jenis JPB");
        header.add(1,"Satuan");
        header.add(2,"Nilai");
        
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpbMezzaine.size();i++)
        {
             Vector vecData = new Vector();
             vecData.add(KuJpbMezzaine.get(i).getKd_jpb());
             vecData.add(KuJpbMezzaine.get(i).getSatuan());
             vecData.add(KuJpbMezzaine.get(i).getNilai());
             data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 2:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;

        
    }
    
    public DefaultTableModel getTableModelJpbDaya (String tahunDBKB)
    {
        try{
            String sql = "select * from rslt_dy_dkg "
                         + "where thn_dy_dkg = '"+tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next())
            {
                JpbDayaDukungKu ku = new JpbDayaDukungKu();
                ku.setId(Integer.parseInt(result.getString(1)));
                ku.setTahun(result.getString(2));
                ku.setDy_dkg_min(Integer.parseInt(result.getString(3)));
                ku.setDy_dkg_max(Integer.parseInt(result.getString(4)));
                ku.setType_kons(result.getString(5));
                ku.setBiaya(Double.parseDouble(result.getString(6)));
                KuJpbDaya.add(ku);
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        Vector<String> header = new Vector<String>();
        header.add(0,"dy_dkg_min");
        header.add(1,"dy_dkg_max");
        header.add(2,"tipe konstruksi");
        header.add(3,"biaya");
        
       
       
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < KuJpbDaya.size();i++)
        {
             Vector vecData = new Vector();
             vecData.add(KuJpbDaya.get(i).getDy_dkg_min());
             vecData.add(KuJpbDaya.get(i).getDy_dkg_max());
             vecData.add(KuJpbDaya.get(i).getType_kons());
             vecData.add(KuJpbDaya.get(i).getBiaya());
             data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableKu = new DefaultTableModel(data,header)
        {
             @Override
            public Class<?> getColumnClass(int index)
            {
                switch (index)
                {
                    case 3:return Double.class;
                    default: return String.class;    
                }
            }
        };
        return tableKu;

        
    }
    
    
    
}
