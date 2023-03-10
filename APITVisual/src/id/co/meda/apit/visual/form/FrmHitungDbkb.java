/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.visual.controller.ControlHitungDBKB;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FrmHitungDbkb extends javax.swing.JDialog {
    
    private String tahunDBKB;
    private ControlHitungDBKB control; 
    /**
     * Creates new form FrmHitungDbkb
     */
    public FrmHitungDbkb(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        label2.setText("");
        this.tahunDBKB = tahunDBKB;
        control = new ControlHitungDBKB();
        jButton1.setEnabled(false);
        this.cmbBoxTahun = control.getComboBoxItem(this.cmbBoxTahun);
        
        //set selected year-----------------///
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String year = cal.get(Calendar.YEAR)+"";
        
        cmbBoxTahun.setSelectedItem(year);
        //-----------------------------------///
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbBoxTahun = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hitung DBKB");

        cmbBoxTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxTahunActionPerformed(evt);
            }
        });

        label1.setText("Tahun");

        jButton1.setText("Proses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label2.setText("label2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBoxTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbBoxTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(549, 163));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       Task task = new Task();
       task.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbBoxTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxTahunActionPerformed
        // TODO add your handling code here:
        if(cmbBoxTahun.getSelectedIndex() == 0)
        {
            jButton1.setEnabled(false);
        }else
        {
               jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_cmbBoxTahunActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbBoxTahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables

    class Task extends SwingWorker<Void,Void>
    {
        
        private ControlHitungDBKB control;

        @Override
        protected Void doInBackground(){
            
            jProgressBar1.setMinimum(0);
            jProgressBar1.setMaximum(100);
            jProgressBar1.setStringPainted(true);
            try{
               
                cmbBoxTahun.setEnabled(false);
                jButton1.setEnabled(false);
               control = new ControlHitungDBKB(cmbBoxTahun.getSelectedItem()+"",jProgressBar1,label2);
               control.HitunganDBKBPertama();
               control.HitunganJPB();
               
               
            }catch(Exception e)
            {
               jProgressBar1.setValue(0);
               jProgressBar1.setString("");
               cmbBoxTahun.setEnabled(true);
                jButton1.setEnabled(true);
            }
        
          return null;
        }
        
        
        @Override
        protected void done()
        {
            label2.setText("Penghitungan selesai");
                cmbBoxTahun.setEnabled(true);
              control.done();
                  JOptionPane.showMessageDialog(new JFrame(), "Proses Penghitungan Telah selesai", "Hitung DBKB",
                       JOptionPane.INFORMATION_MESSAGE);
                  label2.setText("");
                
                jButton1.setEnabled(true);
               jProgressBar1.setValue(0);
               jProgressBar1.setString("");
               
        }
        
    
    }


}
