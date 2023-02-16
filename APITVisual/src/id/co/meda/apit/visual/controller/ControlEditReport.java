/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.enggine.headreport.ModelHeadReport;
import id.co.meda.apit.enggine.headreport.ProsesHeadReport;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import id.co.meda.apit.enggine.jabatan.ProsesJabatan;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlEditReport {
    
    public ArrayList <ModelJabatan> getArrModelJabatan()
    {
        return ProsesJabatan.getArrModelJabatan();
    }
    
    public ModelHeadReport getModelHead()
    {
        return ProsesHeadReport.getModelHead();
    }
    
    public void simpan(ArrayList<ModelJabatan> arrModel,ModelHeadReport head)
    {
        if(ProsesJabatan.simpanJabatan(arrModel) && ProsesHeadReport.simpanHeadReport(head))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Data berhasil disimpan", "Informasi Penyimpanan", JOptionPane.INFORMATION_MESSAGE, null);
                  
        }else
        {
           JOptionPane.showMessageDialog(new JFrame(), "Data gagal disimpan", "Informasi Penyimpanan", JOptionPane.ERROR_MESSAGE, null);
        
        }
    }
    
}
