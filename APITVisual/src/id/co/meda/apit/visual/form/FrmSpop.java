/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.enggine.penilaian.model.Spop;
import id.co.meda.apit.visual.controller.ControlSpop;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class FrmSpop extends javax.swing.JDialog {

    /**
     * Creates new form FrmSpop utk create nop baru
     */
    public FrmSpop(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.kdEdit = 0;
        this.statPenilKhusus = false;
        this.nmPenilaian = "";
        inisiasiAwal();
    }

    public FrmSpop(java.awt.Frame parent, boolean modal, boolean statPenilKhusus, String nmPenilaian) {
        super(parent, modal);
        initComponents();
        this.kdEdit = 0;
        this.statPenilKhusus = statPenilKhusus;
        this.nmPenilaian = nmPenilaian;
        inisiasiAwal();
    }

    /**
     * Creates new form FrmSpop khusus untuk update atau delete nop
     */
    public FrmSpop(java.awt.Frame parent, boolean modal, Integer kdEdit, String nop) {
        super(parent, modal);
        initComponents();
        this.kdEdit = kdEdit;
        this.statPenilKhusus = false;
        this.nmPenilaian = "";
        this.nop = nop;
        inisiasiAwal();
    }

    public FrmSpop(java.awt.Frame parent, boolean modal, Integer kdEdit, String nop, boolean statPenilKhusus, String nmPenilaian) {
        super(parent, modal);
        initComponents();
        this.kdEdit = kdEdit;
        this.statPenilKhusus = statPenilKhusus;
        this.nmPenilaian = nmPenilaian;
        this.nop = nop;
        inisiasiAwal();
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
        pnlSpop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNmJlnOp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoJlnOp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKelurahanOp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbPekerjaan = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtNmSp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNpwp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNmJlnWp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtKelurahanWp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNoJlnWp = new javax.swing.JTextField();
        txtRwRtWp = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtKabupatenWp = new javax.swing.JTextField();
        txtNoKtp = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtZnt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbJnsTnh = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtLsTnh = new javax.swing.JTextField();
        txtJmlBng = new javax.swing.JTextField();
        txtRwRtOp = new javax.swing.JFormattedTextField();
        btSimpan = new javax.swing.JButton();
        txtNop = new javax.swing.JFormattedTextField();
        lbStatus = new javax.swing.JLabel();
        cetakBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SPOP");
        setPreferredSize(new java.awt.Dimension(850, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("NOP");

        pnlSpop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data Letak Objek Pajak");
        jLabel2.setOpaque(true);

        jLabel3.setText("Nama Jalan");

        jLabel4.setText("Blok/Kav/Nomor");

        jLabel5.setText("Kelurahan");

        jLabel6.setText("RW/RT");

        jLabel8.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pemilik", "Penyewa", "Pengelola", "Pemakai", "Sengketa" }));

        jLabel9.setText("Pekerjaan");

        cbPekerjaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PNS", "ABRI", "Pensiunan", "Badan", "Lainnya" }));

        jLabel10.setText("Nama Subjek Pajak");

        jLabel11.setText("NPWP");

        jLabel12.setText("Nama Jalan");

        jLabel13.setText("Kelurahan");

        jLabel14.setText("Blok/Kav/Nomor");

        try {
            txtRwRtWp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###/###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setText("RW/RT");

        jLabel16.setText("Kabupaten/Kotamadya");

        jLabel17.setText("Nomor KTP");

        jLabel18.setText("Luas Tanah");

        jLabel19.setText("Zona Nilai Tanah");

        jLabel20.setText("Jenis Tanah");

        cbJnsTnh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanah+Bangunan", "Kavling Siap Bangun", "Tanah Kosong", "Fasilitas Umum" }));

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Data Subjek Pajak");
        jLabel7.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(102, 102, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Data Tanah");
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(102, 102, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Data Tanah");
        jLabel22.setOpaque(true);

        jLabel23.setText("Jumlah Bangunan");

        try {
            txtRwRtOp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###/###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnlSpopLayout = new javax.swing.GroupLayout(pnlSpop);
        pnlSpop.setLayout(pnlSpopLayout);
        pnlSpopLayout.setHorizontalGroup(
            pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSpopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSpopLayout.createSequentialGroup()
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addGap(22, 22, 22)
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNmJlnOp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKelurahanOp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmSp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKelurahanWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKabupatenWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLsTnh, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbJnsTnh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(84, 84, 84)
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRwRtWp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtZnt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRwRtOp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNoJlnOp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))
                    .addGroup(pnlSpopLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(49, 49, 49)
                        .addComponent(txtJmlBng, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlSpopLayout.setVerticalGroup(
            pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSpopLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtNmJlnOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNoJlnOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtKelurahanOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtRwRtOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(txtNmSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSpopLayout.createSequentialGroup()
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtNoJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRwRtWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)))
                    .addGroup(pnlSpopLayout.createSequentialGroup()
                        .addComponent(txtNmJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKelurahanWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtKabupatenWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(9, 9, 9)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(txtZnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLsTnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJnsTnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnlSpopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtJmlBng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btSimpan.setMnemonic('S');
        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        try {
            txtNop.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.###.###.###-####.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNopActionPerformed(evt);
            }
        });
        txtNop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNopKeyPressed(evt);
            }
        });

        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        cetakBtn.setText("Cetak Spop");
        cetakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cetakBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSimpan))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlSpop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(42, 42, 42)
                            .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatus))
                .addGap(18, 18, 18)
                .addComponent(pnlSpop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan)
                    .addComponent(cetakBtn))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(809, 694));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(this, "Perubahan data akan disimpan ?", 
                       "Konfirmasi Simpan", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            simpanData();
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void txtNopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tmpNop = txtNop.getText().replace(".", "").replace("-", "");

            if (ctrlSpop.cekNop(tmpNop)) {
                int reply = JOptionPane.showConfirmDialog(this, "NOP : " + txtNop.getText()
                    + " sudah ada, apakah akan dilakukan pemutakhiran data ?",
                    "Konfirmasi NOP", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    this.nop = tmpNop;
                    this.kdEdit = 1;
                    lbStatus.setText("Pemutakhiran Data");
                    isiElemenForm();
                    elementEnabled(true);
                    txtNop.setEnabled(false);
                    txtNmJlnOp.requestFocus();
                } else {
                    txtNop.setText("");
                }
            } else {
                elementEnabled(true);
                txtNmJlnOp.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNopKeyPressed

    private void txtNopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNopActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        /*
        FrmEditSpop editSpop = new FrmEditSpop(new JFrame(), true);
        editSpop.setVisible(true);
        */
    }//GEN-LAST:event_formWindowClosed

    private void cetakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBtnActionPerformed
            // TODO add your handling code here:
        ctrlSpop.cetakSpop(spop,nop);
    }//GEN-LAST:event_cetakBtnActionPerformed

   private void inisiasiAwal() {
       ToolsFrm.setTextFilterUpperCase(txtNmJlnOp);
       ToolsFrm.setTextFilterUpperCase(txtKabupatenWp);
       ToolsFrm.setTextFilterUpperCase(txtKelurahanOp);
       ToolsFrm.setTextFilterUpperCase(txtKelurahanWp);
       ToolsFrm.setTextFilterUpperCase(txtNmJlnWp);
       ToolsFrm.setTextFilterUpperCase(txtNmSp);
       ToolsFrm.setTextFilterUpperCase(txtNoJlnOp);
       ToolsFrm.setTextFilterUpperCase(txtZnt);
       
       ToolsFrm.setTextFilterNumber(txtNpwp,"\\D++");
       ToolsFrm.setTextFilterNumber(txtNoKtp,"\\D++");
       ToolsFrm.setTextFilterNumber(txtLsTnh,"[^0-9.]");
       ToolsFrm.setTextFilterNumber(txtJmlBng,"\\D++");

       if (kdEdit == 0) {
           lbStatus.setText("Perekaman Data Baru");
           elementEnabled(false);
       } else {
           lbStatus.setText("Pemutakhiran Data");
           txtNop.setEnabled(false);
           txtNmJlnOp.requestFocus();
           isiElemenForm();
           elementEnabled(true);
       }
   }

   private void elementEnabled(boolean kdEnabled) {
           txtNmJlnOp.setEnabled(kdEnabled);
           txtNoJlnOp.setEnabled(kdEnabled);
           txtKelurahanOp.setEnabled(kdEnabled);
           txtRwRtOp.setEnabled(kdEnabled);
           cbStatus.setEnabled(kdEnabled);
           cbPekerjaan.setEnabled(kdEnabled);
           txtNmSp.setEnabled(kdEnabled);
           txtNpwp.setEnabled(kdEnabled);
           txtNmJlnWp.setEnabled(kdEnabled);
           txtNoJlnWp.setEnabled(kdEnabled);
           txtKelurahanWp.setEnabled(kdEnabled);
           txtRwRtWp.setEnabled(kdEnabled);
           txtKabupatenWp.setEnabled(kdEnabled);
           txtNoKtp.setEnabled(kdEnabled);
           txtLsTnh.setEnabled(kdEnabled);
           txtZnt.setEnabled(kdEnabled);
           cbJnsTnh.setEnabled(kdEnabled);
           txtJmlBng.setEnabled(kdEnabled);
           btSimpan.setEnabled(kdEnabled);
           this.cetakBtn.setEnabled(kdEnabled);
   }
   
   private void isiElemenForm() {
       spop = new Spop();
       ctrlSpop.isiSpop(nop, spop);
       
       txtNop.setText(spop.getNop());
       txtNmJlnOp.setText(spop.getJalanOp());
       txtNoJlnOp.setText(spop.getNoJalanOp());
       txtKelurahanOp.setText(spop.getKelurahanOp());
       txtRwRtOp.setText(spop.getRwRtOp());
       cbStatus.setSelectedItem(spop.getStatusWp());
       cbPekerjaan.setSelectedItem(spop.getPekerjaanWp());
       txtNmSp.setText(spop.getNamaWp());
       txtNpwp.setText(spop.getNpwp());
       txtNmJlnWp.setText(spop.getJalanWp());
       txtNoJlnWp.setText(spop.getNoJalanWp());
       txtKelurahanWp.setText(spop.getKelurahanWp());
       txtRwRtWp.setText(spop.getRwRtWp());
       txtKabupatenWp.setText(spop.getKabupaten());
       txtNoKtp.setText(spop.getNomorKtp());
       txtLsTnh.setText(spop.getLuasTanah().toString());
       txtZnt.setText(spop.getZnt());
       cbJnsTnh.setSelectedItem(spop.getJenisTanah());
       txtJmlBng.setText(spop.getJumlahBangunan().toString());
   }

   private void kosongkanElemenForm() {
       
       txtNop.setText("");
       txtNmJlnOp.setText("");
       txtNoJlnOp.setText("");
       txtKelurahanOp.setText("");
       txtRwRtOp.setText("");
       cbStatus.setSelectedItem("");
       cbPekerjaan.setSelectedItem("");
       txtNmSp.setText("");
       txtNpwp.setText("");
       txtNmJlnWp.setText("");
       txtNoJlnWp.setText("");
       txtKelurahanWp.setText("");
       txtRwRtWp.setText("");
       txtKabupatenWp.setText("");
       txtNoKtp.setText("");
       txtLsTnh.setText("0");
       txtZnt.setText("");
       cbJnsTnh.setSelectedItem("");
       txtJmlBng.setText("0");
   }
   
   private void simpanData() {
       spop = new Spop();
       
       if (txtLsTnh.getText().length() == 0) {
           txtLsTnh.setText("0");
       }
       if (txtJmlBng.getText().length() == 0) {
           txtJmlBng.setText("0");
       }
       
       spop.setNop(txtNop.getText().replace(".", "").replace("-",""));
       spop.setJalanOp(txtNmJlnOp.getText());
       spop.setNoJalanOp(txtNoJlnOp.getText());
       spop.setKelurahanOp(txtKelurahanOp.getText());
       spop.setRwRtOp(txtRwRtOp.getText().replace("/", ""));
       spop.setStatusWp(cbStatus.getSelectedItem().toString());
       spop.setPekerjaanWp(cbPekerjaan.getSelectedItem().toString());
       spop.setNamaWp(txtNmSp.getText());
       spop.setNpwp(txtNpwp.getText());
       spop.setJalanWp(txtNmJlnWp.getText());
       spop.setNoJalanWp(txtNoJlnWp.getText());
       spop.setKelurahanWp(txtKelurahanWp.getText());
       spop.setRwRtWp(txtRwRtWp.getText().replace("/", ""));
       spop.setKabupaten(txtKabupatenWp.getText());
       spop.setNomorKtp(txtNoKtp.getText());
       spop.setLuasTanah(Double.parseDouble(txtLsTnh.getText().replace(",", ".")));
       spop.setZnt(txtZnt.getText());
       spop.setJenisTanah(cbJnsTnh.getSelectedItem().toString());
       spop.setJumlahBangunan(Integer.parseInt(txtJmlBng.getText().replace(",",".")));
       
       
       String kdSimpan = ctrlSpop.simpanSpop(kdEdit, spop);
       
       if (kdSimpan.equals("OK")) {
           if (statPenilKhusus) {
               ctrlSpop.simpanStatPenilKhusus(spop.getNop(), nmPenilaian);
           }
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
           /*kosongkanElemenForm();
           elementEnabled(false);
           kdEdit = 0;
           lbStatus.setText("Perekaman Data Baru");
           txtNop.setEnabled(true);
           txtNop.requestFocus();*/
           this.setVisible(false);
           
           FrmEditSpop editSpop;
           if (statPenilKhusus) {
               editSpop = new FrmEditSpop(new JFrame(), true,statPenilKhusus, nmPenilaian);
           } else {
               editSpop = new FrmEditSpop(new JFrame(), true);
           }
           editSpop.setVisible(true);
       } else {
           JOptionPane.showMessageDialog(this, kdSimpan);
       }
   }
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSimpan;
    private javax.swing.JComboBox cbJnsTnh;
    private javax.swing.JComboBox cbPekerjaan;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JButton cetakBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnlSpop;
    private javax.swing.JTextField txtJmlBng;
    private javax.swing.JTextField txtKabupatenWp;
    private javax.swing.JTextField txtKelurahanOp;
    private javax.swing.JTextField txtKelurahanWp;
    private javax.swing.JTextField txtLsTnh;
    private javax.swing.JTextField txtNmJlnOp;
    private javax.swing.JTextField txtNmJlnWp;
    private javax.swing.JTextField txtNmSp;
    private javax.swing.JTextField txtNoJlnOp;
    private javax.swing.JTextField txtNoJlnWp;
    private javax.swing.JTextField txtNoKtp;
    private javax.swing.JFormattedTextField txtNop;
    private javax.swing.JTextField txtNpwp;
    private javax.swing.JFormattedTextField txtRwRtOp;
    private javax.swing.JFormattedTextField txtRwRtWp;
    private javax.swing.JTextField txtZnt;
    // End of variables declaration//GEN-END:variables

    private boolean statPenilKhusus; // nilai false umum, true khusus
    private String nmPenilaian; // namanya apa
    private Integer kdEdit; //nilai : 0 = insert; 1=update; 2=delete
    private String nop; //digunakan utk inisiasi nop (khususnya utk update atau delete)
    final ControlSpop ctrlSpop = new ControlSpop();
    private Spop spop;
}
