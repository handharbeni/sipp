/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelPendapatanPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelIkan;

import id.co.meda.apit.visual.controller.ControlFrmPendapatanIkan;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FrmPendapatanPerikanan extends javax.swing.JDialog {

    private boolean isEditMode;
    private ModelIkan ikan;
    private boolean isPenangkapan;
    private String nop; 
    private String namaIkanLama;
    private ControlFrmPendapatanIkan control = new ControlFrmPendapatanIkan();
    
    /**
     * Creates new form FrmPendapatanPerikanan
     * @param isPenangkapan : true untuk penangkapan, false untuk pembudidayaan
     * @param isEditMode : true jika untuk edit, false jika ingin menambah data
     */
    public FrmPendapatanPerikanan(java.awt.Frame parent, boolean modal, boolean isEditMode,boolean isPenangkapan,String nop) {
        super(parent, modal);
        initComponents();
        ikan = new ModelIkan();
        this.isPenangkapan = isPenangkapan;
        this.nop = nop;
        this.isEditMode = isEditMode;
        formatField();
    }
    
    //Constructor untuk EditMode
     public FrmPendapatanPerikanan(java.awt.Frame parent, boolean modal, boolean isEditMode,boolean isPenangkapan,String nop,String namaIkan) {
        super(parent, modal);
        initComponents();
        ikan = new ModelIkan();
        this.namaIkanLama = namaIkan;
        this.isPenangkapan = isPenangkapan;
        this.nop = nop;
        this.isEditMode = isEditMode;
        formatField();
        
        ///isi jika dalam editMode
        if(isPenangkapan)
        fillField(nop,"Penangkapan Ikan",namaIkanLama);
        else
        fillField(nop,"Pembudidayaan Ikan",namaIkanLama);
       
    }
     
    private void formatField()
    {
       ToolsFrm.setTextFilterNumber(this.beratField,"\\D++");
       ToolsFrm.setTextFilterNumber(this.hargaField,"\\D++");
    }
    
   private void fillField(String nop,String jenisUsaha, String namaIkanLama)
   {
       ModelIkan ikan = control.getModelIkanSatuan(nop, jenisUsaha, namaIkanLama);
       
       this.namaField.setText(ikan.getNamaIkan());
       this.beratField.setText(ikan.getBerat()+"");
       this.hargaField.setText(ikan.getHargaPerTon()+"");
       this.keteranganField.setText(ikan.getKeterangan());
   }
     
     
    private void simpanDataIkan()
    {
        ikan.setNamaIkan(this.namaField.getText());
        ikan.setBerat(Double.parseDouble(this.beratField.getText()));
        ikan.setHargaPerTon(Double.parseDouble(this.hargaField.getText()));
            if(isPenangkapan)
            {
                ikan.setJenisUsaha("Penangkapan Ikan");
            }else
            {
                ikan.setJenisUsaha("Pembudidayaan Ikan");
            }
         ikan.setKeterangan(this.keteranganField.getText());
         if(!isEditMode)
         {
            if(control.addIkan(ikan,nop))
            {
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan", "Informasi penyimpanan", JOptionPane.INFORMATION_MESSAGE, null);
                this.namaField.setText("");
                this.beratField.setText("");
                this.hargaField.setText("");
                this.keteranganField.setText("");
            }else
            {
                JOptionPane.showMessageDialog(this, "Gagal menambah data", "Error", JOptionPane.ERROR_MESSAGE, null);
                this.namaField.setText("");
                this.beratField.setText("");
                this.hargaField.setText("");
                this.keteranganField.setText("");
            }
         }else
         {
         
         if(control.updateIkan(ikan,nop,namaIkanLama))
            {
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan", "Informasi penyimpanan", JOptionPane.INFORMATION_MESSAGE, null);
                this.namaField.setText("");
                this.beratField.setText("");
                this.hargaField.setText("");
                this.keteranganField.setText("");
            }else
            {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data", "Error", JOptionPane.ERROR_MESSAGE, null);
                this.namaField.setText("");
                this.beratField.setText("");
                this.hargaField.setText("");
                this.keteranganField.setText("");
            }
         
         }
         
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        beratField = new javax.swing.JTextField();
        hargaField = new javax.swing.JTextField();
        simpanBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        keteranganField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pendapatan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nama Ikan");

        jLabel2.setText("Berat");

        jLabel3.setText("Harga Per Ton");

        simpanBtn.setText("Simpan");
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Keterangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(simpanBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keteranganField)
                            .addComponent(namaField)
                            .addComponent(beratField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(hargaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(beratField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(keteranganField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanBtn)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formWindowClosing

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
       
            simpanDataIkan();
        
        
    }//GEN-LAST:event_simpanBtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beratField;
    private javax.swing.JTextField hargaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField keteranganField;
    private javax.swing.JTextField namaField;
    private javax.swing.JButton simpanBtn;
    // End of variables declaration//GEN-END:variables
}
