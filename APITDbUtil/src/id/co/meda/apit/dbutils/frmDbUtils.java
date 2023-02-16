/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.dbutils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class frmDbUtils extends javax.swing.JFrame {

    /**
     * Creates new form frmDbUtils
     */
    public frmDbUtils() {
        initComponents();
        setTextFilter(txtIpAddress, "[^0-9.]");
        isiGrid();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btPilihBackup = new javax.swing.JButton();
        lbStatusBackup = new javax.swing.JLabel();
        btProsesBackup = new javax.swing.JButton();
        lbPathBackup = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btPilihRestore = new javax.swing.JButton();
        lbStatusRestore = new javax.swing.JLabel();
        btProsesRestore = new javax.swing.JButton();
        lbPathRestore = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHost = new javax.swing.JTable();
        txtIpAddress = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrasi Basisdata");

        btPilihBackup.setText("Pilih File");
        btPilihBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPilihBackupActionPerformed(evt);
            }
        });

        lbStatusBackup.setText("-");

        btProsesBackup.setText("Proses");
        btProsesBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProsesBackupActionPerformed(evt);
            }
        });

        lbPathBackup.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStatusBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btProsesBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPilihBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPathBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPilihBackup)
                    .addComponent(lbPathBackup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btProsesBackup)
                .addGap(18, 18, 18)
                .addComponent(lbStatusBackup)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Backup", jPanel1);

        btPilihRestore.setText("Pilih File");
        btPilihRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPilihRestoreActionPerformed(evt);
            }
        });

        lbStatusRestore.setText("-");

        btProsesRestore.setText("Proses");
        btProsesRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProsesRestoreActionPerformed(evt);
            }
        });

        lbPathRestore.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStatusRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btProsesRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPilihRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPathRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPilihRestore)
                    .addComponent(lbPathRestore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btProsesRestore)
                .addGap(18, 18, 18)
                .addComponent(lbStatusRestore)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Restore", jPanel5);

        jLabel1.setText("IP Address");

        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        tblHost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tblHost);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btTambah)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btTambah)
                    .addComponent(txtIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daftar IP Address Client", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPilihBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPilihBackupActionPerformed
        // TODO add your handling code here:
        //jFileChooser1.set
        int nilai = jFileChooser1.showSaveDialog(null);
        if (nilai == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            pathBackup = file.getPath(); 
            lbPathBackup.setText(pathBackup);
        }
    }//GEN-LAST:event_btPilihBackupActionPerformed

    private void elementEnabled(int kode, boolean status) {
        switch (kode) {
            case 0:
                btPilihBackup.setEnabled(status);   btProsesBackup.setEnabled(status);
                break;
            case 1:
                btPilihRestore.setEnabled(status);   btProsesRestore.setEnabled(status);
                break;
        }  
    }
    
    private Vector<String> vectorHeader() {
        Vector<String> header = new Vector<String>();
        header.add(0,"Host");
        return header;
    }
    
    private Vector<Vector> vectorData() {
        return KoneksiDb.ambilVectorData();
    }
    
    private void isiGrid() {
        DefaultTableModel modelTable = new DefaultTableModel(vectorData(),vectorHeader()) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        }; 
        
        tblHost.setModel(modelTable);
        
    }
    
    private void btProsesBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProsesBackupActionPerformed
        // TODO add your handling code here:
        if (pathBackup.trim().length()>0) {
            if (KoneksiDb.cekKoneksi()) {
                Task task = new Task(0);
                task.execute();
            } else {
                FrmUbahPassword frmPwd = new FrmUbahPassword(this, true);
                frmPwd.setVisible(true);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Mohon alamat file backup diisi !!!");
        }
 
    }//GEN-LAST:event_btProsesBackupActionPerformed

    private void btPilihRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPilihRestoreActionPerformed
        int nilai = jFileChooser1.showOpenDialog(null);
        if (nilai == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            pathRestore = file.getPath(); 
            lbPathRestore.setText(pathRestore);
        }
    }//GEN-LAST:event_btPilihRestoreActionPerformed

    private void btProsesRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProsesRestoreActionPerformed
        // TODO add your handling code here:
        if (pathRestore.trim().length()>0) {
            if (KoneksiDb.cekKoneksi()) {
                Task task = new Task(1);
                task.execute();
            } else {
                FrmUbahPassword frmPwd = new FrmUbahPassword(this, true);
                frmPwd.setVisible(true);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Mohon alamat file restore diisi !!!");
        }
        
    }//GEN-LAST:event_btProsesRestoreActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        if (txtIpAddress.getText().trim().length() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Apakah IP Address akan ditambahkan ?", 
                       "Konfirmasi Penambahan IP Address", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                if (KoneksiDb.pendaftaranIpAddress(txtIpAddress.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Proses pendaftaran IP Address berhasil ...");
                    isiGrid();
                } else {
                    JOptionPane.showMessageDialog(this, "Proses pendaftaran IP Address gagal ...");
                };
            }            
        }

    }//GEN-LAST:event_btTambahActionPerformed

    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmDbUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDbUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDbUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDbUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDbUtils().setVisible(true);
            }
        });
    }

    class Task extends SwingWorker<Void, Void> {
        private int kdMethod;
        
        public Task(int kdMethod) {
            this.kdMethod = kdMethod;
        }
        
        @Override
        protected Void doInBackground() {
            switch (kdMethod) {
                case 0: 
                    lbStatusBackup.setText("Mohon tunggu ...");
                    elementEnabled(0, false);
                    pathBackup = pathBackup.replace("\\", "/");
                    cekKeberhasilanProses = BackupRestore.backup("penilaian", "root", KoneksiDb.DEFAULTPASSWORD, pathBackup);
                    break;
                case 1: 
                    lbStatusRestore.setText("Mohon tunggu ...");
                    elementEnabled(1, false);
                    pathRestore = pathRestore.replace("\\", "/");
                    cekKeberhasilanProses = BackupRestore.restore("penilaian","root", KoneksiDb.DEFAULTPASSWORD, pathRestore);
                    break;
            }
            return null;
        
        }
        
        @Override
        protected void done() {
            switch (kdMethod) {
                case 0:
                    elementEnabled(0, true);
                    if (cekKeberhasilanProses) {
                        lbStatusBackup.setText("Proses selesai ...");
                    } else {
                        lbStatusBackup.setText("Proses backup tidak berhasil !!!");
                    }
                    break;
                case 1:    
                    elementEnabled(1, true);
                    if (cekKeberhasilanProses) {
                        lbStatusRestore.setText("Proses selesai ...");
                    } else {
                        lbStatusRestore.setText("Proses restore tidak berhasil !!!");
                    }
                    break;
            }
        }
        
    }
    
    //utk memfilter textfield sesuai kriteria
    private void setTextFilter(JTextField txtField, final String regexnya) {
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPilihBackup;
    private javax.swing.JButton btPilihRestore;
    private javax.swing.JButton btProsesBackup;
    private javax.swing.JButton btProsesRestore;
    private javax.swing.JButton btTambah;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbPathBackup;
    private javax.swing.JLabel lbPathRestore;
    private javax.swing.JLabel lbStatusBackup;
    private javax.swing.JLabel lbStatusRestore;
    private javax.swing.JTable tblHost;
    private javax.swing.JTextField txtIpAddress;
    // End of variables declaration//GEN-END:variables
    
    private boolean cekKeberhasilanProses;
    private String pathBackup = "";
    private String pathRestore = "";
}
