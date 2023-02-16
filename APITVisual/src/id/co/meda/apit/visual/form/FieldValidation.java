/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FieldValidation implements DocumentListener {

    private int srcJmlLantai;
    private int jmlLantai;
    private JTextField field;
    private boolean status;
    
    
   
    
    @Override
    public void insertUpdate(DocumentEvent e) {
         if(jmlLantai > srcJmlLantai)
        {
            status = false;
        }
        if(!status)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Kapasitas melebihi jumlah lantai bangunan","Konfirmasi Lantai", JOptionPane.WARNING_MESSAGE, null);
            field.setText("");
            field.setFocusable(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
         if(jmlLantai > srcJmlLantai)
        {
            status = false;
        }
         if(!status)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Kapasitas melebihi jumlah lantai bangunan","Konfirmasi Lantai", JOptionPane.WARNING_MESSAGE, null);
            field.setText("");
            field.setFocusable(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
         if(jmlLantai > srcJmlLantai)
        {
            status = false;
        }
         if(!status)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Kapasitas melebihi jumlah lantai bangunan","Konfirmasi Lantai", JOptionPane.WARNING_MESSAGE, null);
            field.setText("");
            field.setFocusable(true);
        }
    
    }

    /**
     * @param srcJmlLantai the srcJmlLantai to set
     */
    public void setSrcJmlLantai(int srcJmlLantai) {
        this.srcJmlLantai = srcJmlLantai;
    }

    /**
     * @param jmlLantai the jmlLantai to set
     */
    public void setJmlLantai(int jmlLantai) {
        this.jmlLantai = jmlLantai;
    }

    /**
     * @param field the field to set
     */
    public void setField(JTextField field) {
        this.field = field;
    }
    
}
