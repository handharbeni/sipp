/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.database.connection.DBFetching;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PT. Databumi Indonesia
 */
public class Fasilitas extends javax.swing.JDialog {
    
    private Vector <String> header = new Vector();
    private Vector <String> headerPlumbing = new Vector();
    private Vector <String> headerKolRenang = new Vector();
    private Vector <String> headerLapTenis = new Vector();
    
    /**
     * Creates new form Fasilitas
     */
    public Fasilitas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    public void Start() 
    {   
        try{
        cmbBoxTahun.addItem("pilih tahun..");
        ResultSet result = DBFetching.getResultSet("select distinct thn_dhkm from ref_dhkmf");
        while(result.next())
        {
            cmbBoxTahun.addItem(result.getString(1));
        }
        
        //set selected year-----------------///
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String year = cal.get(Calendar.YEAR)+"";
        
        //cmbBoxTahun.setSelectedItem(year);
        //-----------------------------------///
        
        
        headerPlumbing.add("Jumlah Lantai");
        headerPlumbing.add("JPB 2");
        headerPlumbing.add("JPB 4");
        headerPlumbing.add("JPB 5");
        headerPlumbing.add("JPB 7");
        headerPlumbing.add("JPB 12");
        headerPlumbing.add("JPB 13");
        
        headerKolRenang.add("Luas");
        headerKolRenang.add("Plester");
        headerKolRenang.add("Pelapis");
        
        headerLapTenis.add("Jenis Lantai");
        headerLapTenis.add("Satu Ban Dengan Lampu");
        headerLapTenis.add("Satu Ban Tanpa Lampu");
        headerLapTenis.add("> Satu Ban Dengan Lampu");
        headerLapTenis.add("> Satu Ban Tanpa Lampu");
        
        header.add("Jenis Komponen");
        header.add("Harga");
        header.add("Ukuran");
        TableAC.setModel(new DefaultTableModel(null,header));
        TableLIFT.setModel(new DefaultTableModel(null,header));
        TableEscalator.setModel(new DefaultTableModel(null,header));
        TableApi.setModel(new DefaultTableModel(null,header));
        TablePagar.setModel(new DefaultTableModel(null,header));
        TablePABX.setModel(new DefaultTableModel(null,header));
        TableGenset.setModel(new DefaultTableModel(null,header));
        TableArtesis.setModel(new DefaultTableModel(null,header));
        TablePlumbing.setModel(new DefaultTableModel(null,headerPlumbing));
        TableKolamRenang.setModel(new DefaultTableModel(null,headerKolRenang));
        TableLapanganTenis.setModel(new DefaultTableModel(null,headerLapTenis));
        
        }catch(Exception e){
            e.printStackTrace();
        }
         
    
    }
    
  public void loadPlumbing()
  {
       ResultSet set = DBFetching.getResultSet("select * from rslt_fasilitasplumbing");
       try {
           Vector <Vector> data2 = new Vector<Vector>();
           while(set.next())
                        {
                            Vector vec = new Vector();
                            vec.add(set.getString(2));
                            vec.add(set.getDouble(3));
                            vec.add(set.getDouble(4));
                            vec.add(set.getDouble(5));
                            vec.add(set.getDouble(6));
                            vec.add(set.getDouble(7));
                            vec.add(set.getDouble(8));
                            
                            data2.add(vec);
                        }
               TablePlumbing.setModel(new DefaultTableModel(data2,headerPlumbing){
                     
                    @Override
                       public boolean isCellEditable(int row, int Column)
                       {
                           
                             return false;
                       }   
               });
               TablePlumbing.getColumn(headerPlumbing.get(1));
               TablePlumbing.getColumn(headerPlumbing.get(2));
               TablePlumbing.getColumn(headerPlumbing.get(3));
               TablePlumbing.getColumn(headerPlumbing.get(4));
               TablePlumbing.getColumn(headerPlumbing.get(5));
               TablePlumbing.getColumn(headerPlumbing.get(6));
               
       } catch (SQLException ex) {
            ex.printStackTrace();
        } 
  
  }
  
  public void loadKolamRenang()
  {
      
       ResultSet set = DBFetching.getResultSet("select * from rslt_fasilitaskolam");
       try {
           Vector <Vector> data2 = new Vector<Vector>();
           while(set.next())
                        {
                            Vector vec = new Vector();
                            vec.add(set.getString(2));
                            vec.add(set.getDouble(3));
                            vec.add(set.getDouble(4));
                            data2.add(vec);
                        }
               TableKolamRenang.setModel(new DefaultTableModel(data2,headerKolRenang){
                     
                    @Override
                       public boolean isCellEditable(int row, int Column)
                       {
                           
                             return false;
                       }   
               });
               TableKolamRenang.getColumn(headerKolRenang.get(1));
               TableKolamRenang.getColumn(headerKolRenang.get(2));
               
       } catch (SQLException ex) {
            ex.printStackTrace();
        } 
  
  }
  
  public void loadLapanganTenis()
  {
       ResultSet set = DBFetching.getResultSet("select * from rslt_fasilitaslaptenis");
       try {
           Vector <Vector> data2 = new Vector<Vector>();
           while(set.next())
                        {
                            Vector vec = new Vector();
                            vec.add(set.getString(2));
                            vec.add(set.getDouble(3));
                            vec.add(set.getDouble(4));
                            vec.add(set.getDouble(5));
                            vec.add(set.getDouble(6));
                            data2.add(vec);
                        }
               TableLapanganTenis.setModel(new DefaultTableModel(data2,headerLapTenis){
                     
                    @Override
                       public boolean isCellEditable(int row, int Column)
                       {
                           
                             return false;
                       }   
               });
               TableLapanganTenis.getColumn(headerLapTenis.get(1));
               TableLapanganTenis.getColumn(headerLapTenis.get(2));
               TableLapanganTenis.getColumn(headerLapTenis.get(3));
               TableLapanganTenis.getColumn(headerLapTenis.get(4));
               
       } catch (SQLException ex) {
            ex.printStackTrace();
        } 
  
  }
  
  
  
  
  
  
    
   public void loadTable1(String SQL, JTable table)
   {
    
       ResultSet set = DBFetching.getResultSet(SQL);
        try {
           Vector <Vector> data2 = new Vector<Vector>();
                    
                    while(set.next())
                        {
                            Vector vec = new Vector();
                            vec.add(set.getString(2));
                            vec.add(Math.round(set.getDouble(3)));
                            vec.add(set.getString(4));
                            data2.add(vec);
                        }
               table.setModel(new DefaultTableModel(data2,header){

                   @Override
                    public Class<?> getColumnClass(int index)
                    {
                        switch(index)
                        {
                            default: return String.class;    
                        }
                    }      
                    
               });
//              table.getColumn(header.get(0));
                      
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        cmbBoxTahun = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAC = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableLIFT = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableEscalator = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePagar = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableApi = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableGenset = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablePABX = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableArtesis = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablePlumbing = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        TableAirPanas = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        TableListrik = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        TablePenangkalPetir = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        TablePengolahanLimbah = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        TableTataSuara = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        TableVideoInterkom = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        TableTV = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        TableKolamRenang = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        TablePerkerasan = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        TableLapanganTenis = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        TableReservoir = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Fasilitas DBKB");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        cmbBoxTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxTahunActionPerformed(evt);
            }
        });

        jLabel1.setText("Pilih Tahun");

        TableAC.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableAC);

        tabbedPane.addTab("Air Conditioner", jScrollPane1);

        TableLIFT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TableLIFT);

        tabbedPane.addTab("LIFT", jScrollPane2);

        TableEscalator.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TableEscalator);

        tabbedPane.addTab("Escalator", jScrollPane3);

        TablePagar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TablePagar);

        tabbedPane.addTab("Pagar", jScrollPane4);

        TableApi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TableApi);

        tabbedPane.addTab("Proteksi Api", jScrollPane5);

        TableGenset.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TableGenset);

        tabbedPane.addTab("Genset", jScrollPane6);

        TablePABX.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(TablePABX);

        tabbedPane.addTab("PABX", jScrollPane7);

        TableArtesis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(TableArtesis);

        tabbedPane.addTab("Sumur Artesis", jScrollPane8);

        TablePlumbing.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(TablePlumbing);

        tabbedPane.addTab("Plumbing", jScrollPane9);

        TableAirPanas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(TableAirPanas);

        tabbedPane.addTab("Air Panas", jScrollPane10);

        TableListrik.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(TableListrik);

        tabbedPane.addTab("Listrik", jScrollPane11);

        TablePenangkalPetir.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(TablePenangkalPetir);

        tabbedPane.addTab("Penangkal Petir", jScrollPane12);

        TablePengolahanLimbah.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(TablePengolahanLimbah);

        tabbedPane.addTab("Pengolahan Limbah", jScrollPane13);

        TableTataSuara.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(TableTataSuara);

        tabbedPane.addTab("Tata Suara", jScrollPane14);

        TableVideoInterkom.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(TableVideoInterkom);

        tabbedPane.addTab("Video Interkom", jScrollPane15);

        TableTV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(TableTV);

        tabbedPane.addTab("TV", jScrollPane16);

        TableKolamRenang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(TableKolamRenang);

        tabbedPane.addTab("Kolam Renang", jScrollPane17);

        TablePerkerasan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(TablePerkerasan);

        tabbedPane.addTab("Perkerasan", jScrollPane18);

        TableLapanganTenis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(TableLapanganTenis);

        tabbedPane.addTab("Lapangan Tenis", jScrollPane19);

        TableReservoir.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(TableReservoir);

        tabbedPane.addTab("Reservoir", jScrollPane20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbBoxTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBoxTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBoxTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxTahunActionPerformed
        // TODO add your handling code here:
        if (cmbBoxTahun.getSelectedIndex() > 0)
        {
            String tahun = cmbBoxTahun.getSelectedItem() +"";
            loadTable1("select * from rslt_fasilitas where id like '%FC%' and tahun = '"+tahun+"'",TableAC);
            loadTable1("select * from rslt_fasilitas where id like '%FL%' and tahun = '"+tahun+"'",TableLIFT);
            loadTable1("select * from rslt_fasilitas where id like '%FAP%' and tahun = '"+tahun+"'",TableApi);
            loadTable1("select * from rslt_fasilitas where id like '%FBX%' and tahun = '"+tahun+"'",TablePABX);
            loadTable1("select * from rslt_fasilitas where id like '%FES%' and tahun = '"+tahun+"'",TableEscalator);
            loadTable1("select * from rslt_fasilitas where id like '%FG%' and tahun = '"+tahun+"'",TableGenset);
            loadTable1("select * from rslt_fasilitas where id like '%FK%' and tahun = '"+tahun+"'",TableListrik);
            loadTable1("select * from rslt_fasilitas where id like '%FMR%' and tahun = '"+tahun+"'",TableArtesis);
            loadTable1("select * from rslt_fasilitas where id like '%FP%' and tahun = '"+tahun+"'",TablePagar);
            loadTable1("select * from rslt_fasilitas where id like '%FVE%' and tahun = '"+tahun+"'",TableReservoir);
            loadTable1("select * from rslt_fasilitas where id like '%FR%' and tahun = '"+tahun+"'",TableAirPanas);
            loadTable1("select * from rslt_fasilitas where id like '%FTV%' and tahun = '"+tahun+"'",TableTV);
            loadTable1("select * from rslt_fasilitas where id like '%FR%' and tahun = '"+tahun+"'",TableAirPanas);
            loadTable1("select * from rslt_fasilitas where id like '%FUR%' and tahun = '"+tahun+"'",TableTataSuara);
            loadTable1("select * from rslt_fasilitas where id like '%FVD%' and tahun = '"+tahun+"'",TableVideoInterkom);
            loadTable1("select * from rslt_fasilitas where id like '%PER%' and tahun = '"+tahun+"'",TablePerkerasan);
            loadTable1("select * from rslt_fasilitas where id like '%PNR%' and tahun = '"+tahun+"'",TablePenangkalPetir);
            loadTable1("select * from rslt_fasilitas where id like '%PMH%' and tahun = '"+tahun+"'",TablePengolahanLimbah);
            loadPlumbing();
            loadKolamRenang();
            loadLapanganTenis();

            
            
            /*
            loadTableSwim();
            loadTableTennis();
            loadTableReservoir();
            loadTableSTP();
            loadTablePavement();
            */
         }
    }//GEN-LAST:event_cmbBoxTahunActionPerformed

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
            java.util.logging.Logger.getLogger(Fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fasilitas dialog = new Fasilitas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
               dialog.Start();
                dialog.setVisible(true);
                dialog.setResizable(false);
                dialog.Start();
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAC;
    private javax.swing.JTable TableAirPanas;
    private javax.swing.JTable TableApi;
    private javax.swing.JTable TableArtesis;
    private javax.swing.JTable TableEscalator;
    private javax.swing.JTable TableGenset;
    private javax.swing.JTable TableKolamRenang;
    private javax.swing.JTable TableLIFT;
    private javax.swing.JTable TableLapanganTenis;
    private javax.swing.JTable TableListrik;
    private javax.swing.JTable TablePABX;
    private javax.swing.JTable TablePagar;
    private javax.swing.JTable TablePenangkalPetir;
    private javax.swing.JTable TablePengolahanLimbah;
    private javax.swing.JTable TablePerkerasan;
    private javax.swing.JTable TablePlumbing;
    private javax.swing.JTable TableReservoir;
    private javax.swing.JTable TableTV;
    private javax.swing.JTable TableTataSuara;
    private javax.swing.JTable TableVideoInterkom;
    private javax.swing.JComboBox cmbBoxTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
