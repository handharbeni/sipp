/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelIkan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelPendapatanPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ProsesDataPendapatanPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ToolsPenilaianIkan;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlFrmEditPendapatanIkan {
    
    private ProsesDataPendapatanPerikanan ikan = new ProsesDataPendapatanPerikanan();
    private ModelPendapatanPerikanan modelPendapatan = new ModelPendapatanPerikanan(); 
    
    public boolean cekNop(String nop)
    {
        boolean cek = ikan.cekNop(nop);
        return cek;
    }
    
    public ModelPendapatanPerikanan getModelPendapatan(String nop)
    {
        return ToolsPenilaianIkan.getModelPendapatan(nop);
    }
    
    //untuk membuat table pendapatan
    // @param isPenangkapan : 'true' untuk PenangkapanIkan, 'false' untuk Pembudidayaan
    public DefaultTableModel getModelTable(String nop, boolean isPenangkapan)
    {
        Vector<String> header = new Vector<String>();
        header.add(0,"Nama Ikan");
        header.add(1,"Berat Ikan");
        header.add(2,"Harga Per Ton");
        header.add(3,"Keterangan");
        header.add(4,"");
        header.add(5,"");
        
        Vector<Vector> data = new Vector<Vector>();
        
        if(modelPendapatan.getPembudidayaIkan() != null || modelPendapatan.getPenangkapanIkan() != null)
        {
            modelPendapatan.getPembudidayaIkan().clear();
            modelPendapatan.getPenangkapanIkan().clear();
        }
        
        modelPendapatan = ToolsPenilaianIkan.getPendataan(nop).getPendapatan();
        
        try{
        
           if(isPenangkapan)
           {
            
               for(int i = 0; i < modelPendapatan.getPenangkapanIkan().size();i++)
               {
                   ModelIkan tempIkan = modelPendapatan.getPenangkapanIkan().get(i);
                   Vector vecData = new Vector();
                   vecData.add(tempIkan.getNamaIkan());
                   vecData.add(tempIkan.getBerat());
                   vecData.add(tempIkan.getHargaPerTon());
                   vecData.add(tempIkan.getKeterangan());
                   data.add(vecData);
               }
               
               
           }else
           {
               for(int i = 0; i < modelPendapatan.getPembudidayaIkan().size();i++)
               {
                   ModelIkan tempIkan = modelPendapatan.getPembudidayaIkan().get(i);
                   Vector vecData = new Vector();
                   vecData.add(tempIkan.getNamaIkan());
                   vecData.add(tempIkan.getBerat());
                   vecData.add(tempIkan.getHargaPerTon());
                   vecData.add(tempIkan.getKeterangan());
                   data.add(vecData);
               }
           }
           
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
         DefaultTableModel tableModel = new DefaultTableModel(data,header){
                            
               @Override
               public Class<?> getColumnClass(int index)
               {
                switch(index)
                {
                    case 0: return String.class; 
                    case 3:return String.class;
                    default: return Double.class;   
                }
               }
               
               
               @Override
               public boolean isCellEditable(int row,int column)
               {
                   
                   switch(column)
                {
                    case 4: return true; 
                    case 5: return true; 
                    default: return false;   
                }
               }
           };
             
                
               
        return tableModel;
    
    }
    
    public void delete(String nop, String namaIkan, String jenisUsaha)
    {
     int opt = JOptionPane.showConfirmDialog(new JFrame(), "Anda yakin ingin menghapus data ini?", "konfirmasi penghapusan", JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, null);
    
     if(opt == JOptionPane.OK_OPTION)
     {
         boolean bol = ikan.delete(nop, namaIkan, jenisUsaha);
         if(bol)
         {
             JOptionPane.showMessageDialog(new JFrame(), "Proses penghapusan berhasil", "informasi penghapusan", JOptionPane.INFORMATION_MESSAGE, null);
         }else
         {
             JOptionPane.showMessageDialog(new JFrame(), "Proses penghapusan gagal", "informasi penghapusan", JOptionPane.ERROR_MESSAGE, null);
         
         }
     }
     
     
    }
    
     
    
     
    
}
