/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.database.connection.DBFetching;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class FrmMelAib {
    public static void main(String args[]) {
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        jalanang();
    } 
    
    private static void jalanang() {
        if (DBFetching.cekMelaib()) {
            if (DBFetching.cekKoneksi()) {
                //FrmUtama frmUtama = new FrmUtama();
                //frmUtama.setVisible(true);
                
                FrmLogin frm = new FrmLogin(new JFrame(), true);
                frm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), 
                  "Aplikasi ditutup !!, basisdata belum siap. Bisa terjadi karena : "+
                  "\n 1. Service basisdata belum dihidupkan \n 2. Setting aplikasi ke basisdata belum dilakukan "+
                   "\n Silahkan hubungi Administrator aplikasi...");
                System.exit(1);
            }
        } else {
        } 
    }
}
