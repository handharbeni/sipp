/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.AnalisisHargaSatuanCRN;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.ItemAnalisisHargaSatuan;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.SpopPelabuhan;
import id.co.meda.apit.enggine.penilaian.khusus.pelabuhan.ToolsPenilaianPelabuhan;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlFrmPenilaianPelabuhan {
    
    public boolean cekNop(String nop)
    {
        String sql = "SELECT Count(*) FROM spop_pelabuhan where nop = '"+nop+"'";
        if(DBFetching.getIntegerResult(sql)>0){
            return true;
        }
        
        return false;
    }
    
    public String getPenilTerakhir()
    {
        String sql = "SELECT distinct MAX(tahun) FROM crn_pelabuhan order by tahun DESC ;";
        return DBFetching.getStringResult(sql, 1);
    }
    
    public SpopPelabuhan getSpop(String nop)
    {
        return ToolsPenilaianPelabuhan.getSpopPelabuhan(nop);
    }
    
    public boolean cekTahunPenilaian(String nop, String tahun)
    {
        String sql = "SELECT count(*) FROM crn_pelabuhan "
                        + "where nop = '"+nop+"' and tahun = '"+tahun+"'";
           if(DBFetching.getIntegerResult(sql)>0){
            return true;
        }
        
        return false;
    }
    
    
    public boolean simpanCrn(ArrayList<ItemAnalisisHargaSatuan> arrCrn, String nop, String tahun)
    {
        return ToolsPenilaianPelabuhan.simpanCRNPelabuhan(arrCrn, nop, tahun);
    }
    
    public DefaultTableModel getModelTableCRN(String nop, String tahun)
    {
        Vector <String> header = new Vector <String>(); 
        
        header.add(0,"ID");
        header.add(1,"Jenis Pekerjaan");
        header.add(2,"Satuan");
        header.add(3,"Volume");
        header.add(4,"Harga Bahan");
        header.add(5,"Harga Upah");
        header.add(6,"jumlah");
        header.add(7,"Harga Total");
        
        Vector <Vector> data = new Vector <Vector>();
        
        DefaultTableModel tableModel = new DefaultTableModel(null,header);
        
        String sql = "select count(*) from crn_pelabuhan "
                + "where nop = '"+nop+"' and tahun = '"+tahun+"'";
        
        if(DBFetching.getIntegerResult(sql) > 0)
        {
            
            AnalisisHargaSatuanCRN crn = ToolsPenilaianPelabuhan.getAnalisisHSKU(nop, tahun);
            
            ArrayList<ItemAnalisisHargaSatuan> arrPersiapan = crn.getArrPersiapan();
            ArrayList<ItemAnalisisHargaSatuan> arrKonstruksi = crn.getArrKonstruksiUtama();
            ArrayList<ItemAnalisisHargaSatuan> arrFinishing = crn.getArrFinishing();
            ArrayList<ItemAnalisisHargaSatuan> arrAksesoris = crn.getArrAsesoris();
            
            //isi persiapan
            for(int i = 0; i < arrPersiapan.size(); i++)
            {
                ItemAnalisisHargaSatuan temp = arrPersiapan.get(i);
                Vector vec = new Vector();
                vec.add(temp.getId());
                vec.add(temp.getJenisPekerjaan());
                vec.add(temp.getSatuan());
                if(i > 0)
                {
                    vec.add(temp.getVolume());
                    vec.add(temp.getHrg_bahan());
                    vec.add(temp.getHrg_upah());
                    vec.add(temp.getHrg_jumlah());
                    vec.add(temp.getHrg_total());
                }else
                {
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                
                }
                data.add(vec);
            }
            
            //isi konstruksi
            for(int i = 0; i < arrKonstruksi.size(); i++)
            {
                  ItemAnalisisHargaSatuan temp = arrKonstruksi.get(i);
                Vector vec = new Vector();
                vec.add(temp.getId());
                vec.add(temp.getJenisPekerjaan());
                vec.add(temp.getSatuan());
                if(i > 0)
                {
                    vec.add(temp.getVolume());
                    vec.add(temp.getHrg_bahan());
                    vec.add(temp.getHrg_upah());
                    vec.add(temp.getHrg_jumlah());
                    vec.add(temp.getHrg_total());
                }else
                {
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                }
                data.add(vec);
            }
            
            //isi finishing
            for(int i = 0; i < arrFinishing.size(); i++)
            {
                  ItemAnalisisHargaSatuan temp = arrFinishing.get(i);
                Vector vec = new Vector();
                vec.add(temp.getId());
                vec.add(temp.getJenisPekerjaan());
                vec.add(temp.getSatuan());
                
                if(i > 0)
                {
                    vec.add(temp.getVolume());
                    vec.add(temp.getHrg_bahan());
                    vec.add(temp.getHrg_upah());
                    vec.add(temp.getHrg_jumlah());
                    vec.add(temp.getHrg_total());
                }else
                {
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                }
                data.add(vec);
            }
            
            //isi aksesoris
            for(int i = 0; i < arrAksesoris.size(); i++)
            {
                  ItemAnalisisHargaSatuan temp = arrAksesoris.get(i);
                Vector vec = new Vector();
                vec.add(temp.getId());
                vec.add(temp.getJenisPekerjaan());
                vec.add(temp.getSatuan());
                
                if(i > 0)
                {
                    vec.add(temp.getVolume());
                    vec.add(temp.getHrg_bahan());
                    vec.add(temp.getHrg_upah());
                    vec.add(temp.getHrg_jumlah());
                    vec.add(temp.getHrg_total());
                }else
                {
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                    vec.add(null);
                }
                data.add(vec);
            }
           
        }else
        {
            
            //isi persiapan
            String idPersiapan = "C100";
            String [] jnsPersiapan = new String[]
                                    {"PERSIAPAN","Pengukuran","Mobilisasi peralatan"};
            String [] satuanPersiapan = new String[]
                                    {"","m","m"};
            
            for(int i = 0; i < jnsPersiapan.length; i++)
            {
                
                Vector temp = new Vector();
                temp.add(idPersiapan+i);
                temp.add(jnsPersiapan[i]);
                temp.add(satuanPersiapan[i]);
                if(i > 0)
                {
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                }
                data.add(temp);
            }
            
            //isi konstruksi
            String idKonstruksi = "C200";
            String [] jnsKonstruksi = new String[]
                                    {"KONSTRUKSI UTAMA",
                                    "Pemancangan",
                                    "Pemotongan Tiang",
                                    "Bekisting",
                                    "Pembesian","Pengecoran","Floorhand"};

            String [] satuanKonstruksi = new String[]
                                    {"","m","bh","m2","m3","m3","m2"};
            
            for(int i = 0; i < jnsKonstruksi.length; i++)
            {
                String tempId = idKonstruksi + i;
                
                Vector temp = new Vector();
                temp.add(tempId);
                temp.add(jnsKonstruksi[i]);
                temp.add(satuanKonstruksi[i]);
                if(i > 0)
                {
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                }
                data.add(temp);
            }
            
            //isi finishing
            String idFinishing = "C300";
            String [] jnsFinishing = new String[]
                                    {"FINISHING",
                                    "Lapisan Penetrasi",
                                    "Lapisan Aspal"};

            String [] satuanFinishing = new String[]
                                    {"","m2","m2"};
            
            for(int i = 0; i < jnsFinishing.length; i++)
            {
                String tempId = idFinishing + i;
                
                Vector temp = new Vector();
                temp.add(tempId);
                temp.add(jnsFinishing[i]);
                temp.add(satuanFinishing[i]);
                if(i > 0)
                {
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                }
                data.add(temp);
            }
            
            //isi aksesoris
            String idAksesoris = "C400";
            String [] jnsAksesoris = new String[]
                                    {"AKSESORIS",
                                    "Bolard",
                                    "Fender"};

            String [] satuanAksesoris = new String[]
                                    {"","unit","unit"};
            
            for(int i = 0; i < jnsAksesoris.length; i++)
            {
                String tempId = idAksesoris + i;
                
                Vector temp = new Vector();
                temp.add(tempId);
                temp.add(jnsAksesoris[i]);
                temp.add(satuanAksesoris[i]);
                if(i > 0)
                {
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                temp.add(0.0);
                }
                data.add(temp);
            }
            
          
        }
        
          tableModel = new DefaultTableModel(data,header){  
             
            @Override
                public Class<?> getColumnClass(int index)
                {
                 switch(index)
                 {
                     case 1: return String.class;
                     case 0: return String.class; 
                     case 2: return String.class; 
                     default: return Double.class;  

                 }
                }

                @Override
                public boolean isCellEditable(int row,int column)
                {
                    if(column == 0 || column == 1 || column == 2 || column == 6 || column == 7
                            || row == 0 || row == 3
                            || row == 10 || row == 13)
                    {
                     
                        return false;
                    }
                    
                    return true;
                }
            };
        
        
        return tableModel;
    }
    
}
