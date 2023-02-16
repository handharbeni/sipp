/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ToolsFrm {
    public static void setTextFilterNumber(JTextField txtField, final String regexnya) {
        PlainDocument a = new PlainDocument();
        a.setDocumentFilter(new DocumentFilter() {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int off, String str, AttributeSet attr) 
            throws BadLocationException 
        {
            fb.insertString(off, str.replaceAll(regexnya, ""), attr);  // remove non-digits
        } 
        @Override
        public void replace(DocumentFilter.FilterBypass fb, int off, int len, String str, AttributeSet attr) 
            throws BadLocationException 
        {
            fb.replace(off, len, str.replaceAll(regexnya, ""), attr);  // remove non-digits
        }
        });
        txtField.setDocument(a);
    }

    public static void setTextFilterUpperCase(JTextField txtField)
    {
        PlainDocument a = new PlainDocument();
        a.setDocumentFilter(new DocumentFilter(){
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int off, String str, AttributeSet attr) 
            throws BadLocationException 
        {
            fb.insertString(off, str.toUpperCase(), attr);  // remove non-digits
        } 
        @Override
        public void replace(DocumentFilter.FilterBypass fb, int off, int len, String str, AttributeSet attr) 
            throws BadLocationException 
        {
            fb.replace(off, len, str.toUpperCase(), attr);  // remove non-digits
        }
        });
        txtField.setDocument(a);
    }

}
