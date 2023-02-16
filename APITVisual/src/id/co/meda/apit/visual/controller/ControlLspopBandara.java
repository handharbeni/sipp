/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LspopBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlLspopBandara {
    
     public boolean cekNOP(String nop)
    {
            String sql = "select count(*) from lkok_tanah_bandara where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            return jmlh > 0;
    }
     
    public boolean cekNoBng(int noBng,String nop)
    {
        String sql = "select count(*) from lspop_bandara"
                + " where nop='"+nop+"' and no_bng = "+noBng+"";
            int jmlh = DBFetching.getIntegerResult(sql);
            
           return jmlh > 0;
    }
     
    public DefaultTableModel getModelBng(String nop)
    {
        Vector header = new Vector();
        header.add("No_bng");
        header.add("Bangunan");
        header.add("Luas (M2)");
        header.add("");
        header.add("");
        DefaultTableModel model = new DefaultTableModel(null,header);
        
        ArrayList<LspopBandara> arrLspopBandara = ToolsPenilaianBandara.getModelLspopBandara(nop);
        Vector<Vector> data = new Vector<Vector>();
        if(arrLspopBandara.size() > 0)
        {
            for(int i = 0; i < arrLspopBandara.size();i++)
            {
                Vector vec = new Vector();
                LspopBandara lspop = arrLspopBandara.get(i);
                vec.add(lspop.getNoBng());
                vec.add(lspop.getJpb());
                vec.add(lspop.getLuas());

                data.add(vec);
            }
            model = new DefaultTableModel(data,header){

                   @Override
                   public Class<?> getColumnClass(int index)
                   {
                    switch(index)
                    {
                        case 2:return Double.class;
                        default: return String.class;   
                    }
                   }


                   @Override
                   public boolean isCellEditable(int row,int column)
                   {

                       switch(column)
                    {
                           case 3:return true;
                           case 4:return true;    
                        default: return false;   
                    }
                   }
               };
        }
             
        return model;
        
    }
     
     public boolean Simpan(LspopBandara temp)
     {
         return ToolsPenilaianBandara.isiLspopBandara(temp);
     }
     
     public void delete(int id, String nop)
     {
         ToolsPenilaianBandara.deleteLspopBandara(nop, id);
     }
}
