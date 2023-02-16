/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;


import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ProsesDataSpopPerikanan;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlSpopBumiPerikanan {
 
    public void simpanDataSpop(ModelSpopPerikanan spopIkan,int kdSimpan)
    {
        
        boolean cek = ProsesDataSpopPerikanan.simpanSpopBumiPerikanan(spopIkan,kdSimpan);
        if(cek)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Data berhasil disimpan", "Proses Penyimpanan", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menyimpan data baru", "Proses Penyimpanan", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
    private void updateDataPeruntukanBumi(ModelBumiPerikanan spopBumi)
    {
        boolean cek = ProsesDataBumiPerikanan.updateSpopBumiPerikanan(spopBumi);
        if(cek)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Perubahan data berhasil disimpan", "Proses Penyimpanan", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Gagal menyimpan perubahan data", "Proses Penyimpanan", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    public ModelSpopPerikanan getModelSpopPerikanan(String nop)
    {
        return ProsesDataSpopPerikanan.getSpopPerikanan(nop);
    }
    
    public boolean cekNop(String nop)
    {
        return ProsesDataSpopPerikanan.cekKetersediaanData(nop);
    }
}
