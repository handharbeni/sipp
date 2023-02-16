/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.enggine.penilaian.khusus.tower.ItemDhkmTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.ProsesHitungAhsTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.ProsesHitungCrnTower;
import id.co.meda.apit.enggine.penilaian.khusus.tower.RsltCrnTower;
import id.co.meda.apit.visual.controller.ControlTowerDhkm;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class FrmTowerDhkm extends javax.swing.JDialog {

    /**
     * Creates new form FrmTowerDhkm
     */
    public FrmTowerDhkm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
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

        TabPage = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txTahun = new javax.swing.JTextField();
        cbPilih = new javax.swing.JCheckBox();
        lbKe = new javax.swing.JLabel();
        lbFrom = new javax.swing.JLabel();
        btProses = new javax.swing.JButton();
        cbPilihTahunCopy = new javax.swing.JComboBox();
        cbPilihTahun = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDhkm = new javax.swing.JTable();
        btSimpan = new javax.swing.JButton();
        lbStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbPilihTahunCrn = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListCrn = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Komponen Material Tower");

        txTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTahunActionPerformed(evt);
            }
        });
        txTahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTahunKeyPressed(evt);
            }
        });

        cbPilih.setText("Copy dari Tahun Sebelumnya");
        cbPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihActionPerformed(evt);
            }
        });

        lbKe.setText("ke Tahun");

        lbFrom.setText("Dari Tahun");

        btProses.setText("Proses");
        btProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProsesActionPerformed(evt);
            }
        });

        cbPilihTahunCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihTahunCopyActionPerformed(evt);
            }
        });

        cbPilihTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihTahunActionPerformed(evt);
            }
        });

        tableDhkm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDhkm);

        btSimpan.setText("Simpan & Hitung CRN");
        btSimpan.setToolTipText("");
        btSimpan.setEnabled(false);
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        lbStatus.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbPilih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPilihTahunCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lbKe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btProses))
                    .addComponent(cbPilihTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbKe)
                    .addComponent(cbPilih)
                    .addComponent(lbFrom)
                    .addComponent(txTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProses)
                    .addComponent(cbPilihTahunCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(cbPilihTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan)
                    .addComponent(lbStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPage.addTab("Edit Komponen Material", jPanel1);

        cbPilihTahunCrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihTahunCrnActionPerformed(evt);
            }
        });

        tableListCrn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableListCrn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cbPilihTahunCrn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbPilihTahunCrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        TabPage.addTab("Lihat CRN (Cost Reproduction New)", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TabPage, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TabPage, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPilihTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihTahunActionPerformed
        // TODO add your handling code here:
        if (cbPilihTahun.getItemCount()>0) {
            tahun = cbPilihTahun.getSelectedItem().toString();
        }
        
        if (!tahun.equals("-- Pilih Tahun --")) { 
            listItemDhkm = new ArrayList<>();
            ctrl.ambilIsiTabel(tahun, listItemDhkm);
            bentukTbl(listItemDhkm);
            btSimpan.setEnabled(true);
        } else {
            bentukTbl(1);
            btSimpan.setEnabled(false);
        }
    }//GEN-LAST:event_cbPilihTahunActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        Task task = new Task(1);
        task.execute();
    }//GEN-LAST:event_btSimpanActionPerformed

    private void cbPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihActionPerformed
        // TODO add your handling code here:
        if (cbPilih.isSelected()) {
            lbFrom.setVisible(true);
            cbPilihTahunCopy.setVisible(true);
            lbKe.setVisible(true);
            txTahun.setVisible(true);
            btProses.setVisible(true);
        } else {
            lbFrom.setVisible(false);
            cbPilihTahunCopy.setVisible(false);
            lbKe.setVisible(false);
            txTahun.setVisible(false);
            btProses.setVisible(false);
        }
    }//GEN-LAST:event_cbPilihActionPerformed

    private void cbPilihTahunCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihTahunCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPilihTahunCopyActionPerformed

    private void txTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTahunActionPerformed

    private void txTahunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTahunKeyPressed
        // TODO add your handling code here:
        if (txTahun.getText().length()>4) {
            JOptionPane.showMessageDialog(this, "Tahun tidak boleh lebih dari 4 digit ...");
            txTahun.setText("");
        }
    }//GEN-LAST:event_txTahunKeyPressed

    private void btProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProsesActionPerformed
        // TODO add your handling code here:
        Integer thnAwal = (!cbPilihTahunCopy.getSelectedItem().toString().equals("-- Pilih Tahun --"))?
                Integer.parseInt(cbPilihTahunCopy.getSelectedItem().toString()):0;
        Integer thnAkhir = (!txTahun.getText().equals(""))?
                Integer.parseInt(txTahun.getText()):0;
        
        if ((thnAwal>0 && thnAkhir>0) && (thnAkhir>thnAwal)) {
            if (ctrl.cekTabel(thnAkhir.toString())>0) {
                int reply = JOptionPane.showConfirmDialog(this, "Data untuk tahun : " + thnAkhir
                    + " sudah ada, apakah akan ditimpa ?","Konfirmasi Copy", JOptionPane.YES_NO_OPTION);
                if (reply==JOptionPane.YES_OPTION) {
                    Task task = new Task(2,thnAwal.toString(),thnAkhir.toString());
                    task.execute();
                } 
            } else {
                Task task = new Task(2,thnAwal.toString(),thnAkhir.toString());
                task.execute();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Harap tahun dipilih atau diisi dengan benar !!!");
        }
    }//GEN-LAST:event_btProsesActionPerformed

    private void cbPilihTahunCrnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihTahunCrnActionPerformed
        // TODO add your handling code here:
        String thnCrn = "";
        if (cbPilihTahunCrn.getItemCount()>0) {
            thnCrn = cbPilihTahunCrn.getSelectedItem().toString();
        }
        
        if(!thnCrn.equals("-- Pilih Tahun --")) {
            listItemCrn = new ArrayList<>();
            ctrl.ambilDataCrn(thnCrn, listItemCrn);
            bentukTblCrn(listItemCrn);
        } else {
            bentukTbl(2);
        }
        
        

    }//GEN-LAST:event_cbPilihTahunCrnActionPerformed
    
    private void inisiasiAwal() {
        ctrl.isiCbThn(cbPilihTahun);
       
        //set selected year-----------------///
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String year = cal.get(Calendar.YEAR)+"";
        
        cbPilihTahun.setSelectedItem(year);
        //---------------------------------///
        
        ctrl.isiCbThn(cbPilihTahunCopy);
        cbPilihTahunCopy.setSelectedItem(year);
        
        ctrl.isiCbThn(cbPilihTahunCrn);
        cbPilihTahunCrn.setSelectedItem(year);
        
        bentukTbl(1);
        bentukTbl(2);
        btSimpan.setEnabled(false);
        listItemDhkm = new ArrayList<>();
        //utk copy
        cbPilih.setSelected(false);
        lbFrom.setVisible(false);
        cbPilihTahunCopy.setVisible(false);
        lbKe.setVisible(false);
        txTahun.setVisible(false);
        btProses.setVisible(false);
        ToolsFrm.setTextFilterNumber(txTahun, "\\D++");
        
        
    }
    
    private void bentukTbl(Integer kode) {
        if (kode==1) {
            tableDhkm.setModel(ctrl.getTableModel(kode));
            settingKolomTable(kode);
        } else if (kode==2) {
            tableListCrn.setModel(ctrl.getTableModel(kode));
            settingKolomTable(kode);
        }
    }
    
    private void bentukTbl(ArrayList<ItemDhkmTower> list) {
        tableDhkm.setModel(ctrl.getTableModel(list));
        settingKolomTable(1);
    }

    private void bentukTblCrn(ArrayList<RsltCrnTower> list) {
        tableListCrn.setModel(ctrl.getTableModelCrn(list));
        settingKolomTable(2);
    }
    
    private void settingKolomTable(Integer kode) {
        if (kode==1) {
            tableDhkm.getColumnModel().getColumn(0).setPreferredWidth(2);  
            tableDhkm.getColumnModel().getColumn(1).setPreferredWidth(300);          
            tableDhkm.getColumnModel().getColumn(2).setPreferredWidth(5);          
            tableDhkm.getColumnModel().getColumn(3).setPreferredWidth(50);  
        } else if (kode==2) {
            tableListCrn.getColumnModel().getColumn(0).setPreferredWidth(2);  
            tableListCrn.getColumnModel().getColumn(1).setPreferredWidth(5);          
            tableListCrn.getColumnModel().getColumn(2).setPreferredWidth(40);          
            tableListCrn.getColumnModel().getColumn(3).setPreferredWidth(2);  
            tableListCrn.getColumnModel().getColumn(4).setPreferredWidth(50);  
            tableListCrn.getColumnModel().getColumn(5).setPreferredWidth(100);  
            tableListCrn.getColumnModel().getColumn(6).setPreferredWidth(80);  
        }
    }

    private void simpanData() {
        lbStatus.setText("Simpan Dhkm....");
        ctrl.ambilDataTabel(tableDhkm, listItemDhkm);
        String stat = ctrl.SimpanDb(listItemDhkm);
        if (stat.equals("ok")) {
            //hitungan CRN ------------
            lbStatus.setText("Hitung Ahs....");
            ProsesHitungAhsTower hitAhs = new ProsesHitungAhsTower(tahun);
            hitAhs.hitungAhs();
            lbStatus.setText("Hitung Crn....");
            ProsesHitungCrnTower hitCrn = new ProsesHitungCrnTower(tahun, hitAhs.getHat());
            hitCrn.hitungCrn();
            //System.out.println(hitCrn.getHctGf111to120().getCrn());
            lbStatus.setText("Simpan Crn....");
            hitCrn.simpanCrn();
            //-----------
        } else {
            JOptionPane.showMessageDialog(this, "Gagal Simpan !!!");
        }
    }
    
    class Task extends SwingWorker<Void,Void>
    {
        private final int kode;
        private String thnAwal;
        private String thnAkhir;
        
        public Task(int kode) {
            this.kode=kode;
        }
        public Task(int kode,String thnAwal, String thnAkhir) {
            this.kode=kode;
            this.thnAwal=thnAwal;
            this.thnAkhir=thnAkhir;
        }
        @Override
        protected Void doInBackground() throws Exception {
            lbStatus.setText("Mohon tunggu ....");
            switch (kode) {
                case 1:
                  simpanData(); break;
                case 2:
                  ctrl.copyTabel(thnAwal, thnAkhir);

            }
            return null;
        }
        
        @Override
        protected void done() {
            lbStatus.setText("-");
            JOptionPane.showMessageDialog(new JFrame(), "Proses selesai ...");
            inisiasiAwal();
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPage;
    private javax.swing.JButton btProses;
    private javax.swing.JButton btSimpan;
    private javax.swing.JCheckBox cbPilih;
    private javax.swing.JComboBox cbPilihTahun;
    private javax.swing.JComboBox cbPilihTahunCopy;
    private javax.swing.JComboBox cbPilihTahunCrn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbFrom;
    private javax.swing.JLabel lbKe;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTable tableDhkm;
    private javax.swing.JTable tableListCrn;
    private javax.swing.JTextField txTahun;
    // End of variables declaration//GEN-END:variables
    
    private final ControlTowerDhkm ctrl = new ControlTowerDhkm();
    private ArrayList<ItemDhkmTower> listItemDhkm;
    private ArrayList<RsltCrnTower> listItemCrn;
    private String tahun;
    
}
