/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;


import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopBumi;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopTambahan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import id.co.meda.apit.visual.controller.ControlSpopBumiPerikanan;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FrmSpopBumiPerikanan extends javax.swing.JDialog {

    private boolean isEdit;
    private ControlSpopBumiPerikanan control = new ControlSpopBumiPerikanan();
    /**
     * Creates new form FrmSpopBumiPerikanan2
     */
    public FrmSpopBumiPerikanan(java.awt.Frame parent, boolean modal, boolean isEdit) {
        super(parent, modal);
        initComponents();
        this.isEdit = isEdit;
        this.filterField();
        if(isEdit)
        {
            this.labelInfo.setText("Pemuktahiran Data");
        }else
        {
            this.enableAllField(false);
            this.labelInfo.setText("Penambahan Data Baru");
        }
    }
    
    public void filterField(){
        ToolsFrm.setTextFilterNumber(this.obyekAreaField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanDermagaField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanGudangField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanJalanField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanKamarDinginField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanKantorField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanLaboratoriumField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanLainnyaField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanPerumahanField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanTangkiField,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.peruntukanRumahMesinField,"[^0-9.]");
    }
    
    public void editMode(String nop)
    {
        this.labelInfo.setText("Pemuktahiran Data");
        this.fillData(nop);
        this.isEdit = true;
        this.enableAllField(true);
    }
    
    
    public void fillData(String nop)
    {
        ModelSpopPerikanan spopIkan = control.getModelSpopPerikanan(nop);
       
        
       Spop spop = spopIkan.getSpop();
       this.nopField.setText(spop.getNop());
       this.obyekLokasiField.setText(spop.getJalanOp());
       this.subyekNamaField.setText(spop.getNamaWp());
       this.subyekNpwpField.setText(spop.getNpwp());
       txtNmJlnWp.setText(spop.getJalanWp());
       txtNoJlnWp.setText(spop.getNoJalanWp());
       txtKelurahanWp.setText(spop.getKelurahanWp());
       txtRwRtWp.setText(spop.getRwRtWp());
       txtKabupatenWp.setText(spop.getKabupaten());
       this.obyekAreaField.setText(spop.getLuasTanah().toString());
       this.obyekKelurahanField.setText(spop.getKelurahanOp());
       
       ModelSpopTambahan spopTambah = spopIkan.getSpopTambahan();
       this.subyekKontraktorField.setText(spopTambah.getKontraktor());
       this.obyekIzinField.setText(spopTambah.getNoIzinPerikanan());
       this.obyekPenangkapanIkan.setText(spopTambah.getPenangkapanIkan());
       this.obyekPembudidayaanIkan.setText(spopTambah.getBudidayaIkan());
       
       ArrayList<ModelSpopBumi> arrBumi = spopIkan.getSpopBumi();
       
       for(int i = 0; i < arrBumi.size();i++)
       {
           ModelSpopBumi bumi = arrBumi.get(i);
           String kode = bumi.getKode();
           
           if(kode.equalsIgnoreCase("01"))
             {
                 this.peruntukanKantorField.setText(bumi.getLuas()+"");
             }
           else if(kode.equalsIgnoreCase("02"))
           {
                   this.peruntukanGudangField.setText(bumi.getLuas()+"");
               
           }else if(kode.equalsIgnoreCase("03"))
           {
                  this.peruntukanPerumahanField.setText(bumi.getLuas()+"");
            
           }else if(kode.equalsIgnoreCase("04")){
                  this.peruntukanLaboratoriumField.setText(bumi.getLuas()+"");    
            
           }else if(kode.equalsIgnoreCase("05")){
                  this.peruntukanRumahMesinField.setText(bumi.getLuas()+"");    
            
           }else if(kode.equalsIgnoreCase("06")){
                  this.peruntukanJalanField.setText(bumi.getLuas()+"");
            
           }else if(kode.equalsIgnoreCase("07")){
                  this.peruntukanTangkiField.setText(bumi.getLuas()+"");    
            
           }else if(kode.equalsIgnoreCase("08")){
                    this.peruntukanKamarDinginField.setText(bumi.getLuas()+"");    
            
           }else if(kode.equalsIgnoreCase("09")){
                   this.peruntukanDermagaField.setText(bumi.getLuas()+"");    
               
           
           
           }else if(kode.equalsIgnoreCase("10")){
                   this.peruntukanLainnyaField.setText(bumi.getLuas()+"");    
                  
                   
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

        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subyekNamaField = new javax.swing.JTextField();
        subyekKontraktorField = new javax.swing.JTextField();
        subyekNpwpField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        obyekIzinField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        obyekAreaField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        peruntukanKantorField = new javax.swing.JTextField();
        peruntukanGudangField = new javax.swing.JTextField();
        peruntukanPerumahanField = new javax.swing.JTextField();
        peruntukanLaboratoriumField = new javax.swing.JTextField();
        peruntukanJalanField = new javax.swing.JTextField();
        peruntukanTangkiField = new javax.swing.JTextField();
        peruntukanKamarDinginField = new javax.swing.JTextField();
        peruntukanDermagaField = new javax.swing.JTextField();
        peruntukanLainnyaField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNmJlnWp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtKelurahanWp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNoJlnWp = new javax.swing.JTextField();
        txtRwRtWp = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtKabupatenWp = new javax.swing.JTextField();
        obyekLokasiField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        obyekPenangkapanIkan = new javax.swing.JTextField();
        obyekPembudidayaanIkan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        peruntukanRumahMesinField = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        obyekKelurahanField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        simpanBtn = new javax.swing.JButton();
        nopField = new javax.swing.JFormattedTextField();

        jLabel18.setBackground(new java.awt.Color(0, 255, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Data Obyek");
        jLabel18.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SPOP Perikanan");

        jLabel1.setText("NOP");

        labelInfo.setText("------");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 750));

        jLabel19.setBackground(new java.awt.Color(0, 255, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Data Subyek");
        jLabel19.setOpaque(true);

        jLabel3.setText("Nama Perusahaan");

        jLabel4.setText("Kontraktor (PSC/KK)");

        jLabel6.setText("NPWP");

        subyekNpwpField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subyekNpwpFieldActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(0, 255, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Data Obyek");
        jLabel20.setOpaque(true);

        jLabel7.setText("No.Surat Izin Usaha Perikanan");

        jLabel8.setText("Lokasi Obyek");

        jLabel16.setText("Luas Area");

        obyekAreaField.setText("0.0");

        jLabel17.setText("Ha");

        jLabel21.setBackground(new java.awt.Color(0, 255, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Peruntukan Obyek Bumi");
        jLabel21.setOpaque(true);

        jLabel23.setText("Kantor");

        jLabel24.setText("Gudang");

        jLabel25.setText("Perumahan");

        jLabel26.setText("Laboratorium");

        jLabel27.setText("Jalan Lingkungan");

        jLabel28.setText("Tangki/Silo");

        jLabel29.setText("Kamar Pendingin");

        jLabel30.setText("Dermaga");

        jLabel31.setText("Lainnya");

        peruntukanKantorField.setText("0.0");

        peruntukanGudangField.setText("0.0");

        peruntukanPerumahanField.setText("0.0");

        peruntukanLaboratoriumField.setText("0.0");

        peruntukanJalanField.setText("0.0");
        peruntukanJalanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peruntukanJalanFieldActionPerformed(evt);
            }
        });

        peruntukanTangkiField.setText("0.0");

        peruntukanKamarDinginField.setText("0.0");

        peruntukanDermagaField.setText("0.0");

        peruntukanLainnyaField.setText("0.0");
        peruntukanLainnyaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peruntukanLainnyaFieldActionPerformed(evt);
            }
        });

        jLabel32.setText("m2");

        jLabel33.setText("m2");

        jLabel34.setText("m2");

        jLabel35.setText("m2");

        jLabel36.setText("m2");

        jLabel37.setText("m2");

        jLabel38.setText("m2");

        jLabel39.setText("m2");

        jLabel40.setText("m2");

        jLabel22.setText("I. Tanah Emplasement");

        jLabel13.setText("Nama Jalan");

        jLabel14.setText("Kelurahan");

        jLabel15.setText("Blok/Kav/Nomor");

        try {
            txtRwRtWp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###/###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel43.setText("RW/RT");

        jLabel44.setText("Kabupaten/Kotamadya");

        jLabel2.setText("Penangkapan Ikan");

        jLabel5.setText("Budidaya Ikan");

        jLabel9.setText("Rumah Mesin");

        peruntukanRumahMesinField.setText("0.0");

        jLabel42.setText("m2");

        jLabel10.setText("Kelurahan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(42, 42, 42)
                                .addComponent(subyekNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(subyekKontraktorField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(80, 80, 80)
                                .addComponent(txtNmJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel15)
                                .addGap(6, 6, 6)
                                .addComponent(txtNoJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(90, 90, 90)
                                .addComponent(txtKelurahanWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel43)
                                .addGap(55, 55, 55)
                                .addComponent(txtRwRtWp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(22, 22, 22)
                                .addComponent(txtKabupatenWp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(111, 111, 111)
                                .addComponent(subyekNpwpField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(obyekIzinField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(100, 100, 100)
                                    .addComponent(obyekLokasiField)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(peruntukanLaboratoriumField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel39))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(peruntukanRumahMesinField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel42)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(peruntukanPerumahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel38)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel29))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(peruntukanGudangField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel37)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(peruntukanKantorField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel36)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(peruntukanJalanField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(peruntukanTangkiField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(peruntukanLainnyaField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel40))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(peruntukanDermagaField, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                            .addComponent(peruntukanKamarDinginField))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel34))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel35))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(118, 118, 118)
                                .addComponent(obyekAreaField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel17))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(obyekKelurahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(obyekPenangkapanIkan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(obyekPembudidayaanIkan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel19)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(subyekNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(subyekKontraktorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtNmJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15))
                    .addComponent(txtNoJlnWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtKelurahanWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtRwRtWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel44))
                    .addComponent(txtKabupatenWp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addComponent(subyekNpwpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel20)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(obyekIzinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(obyekLokasiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obyekKelurahanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obyekAreaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(obyekPenangkapanIkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(obyekPembudidayaanIkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peruntukanKantorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peruntukanJalanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel36)
                            .addComponent(jLabel27)
                            .addComponent(jLabel32))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peruntukanGudangField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peruntukanTangkiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel37)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peruntukanPerumahanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peruntukanKamarDinginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel38)
                            .addComponent(jLabel29)
                            .addComponent(jLabel34))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peruntukanLaboratoriumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(peruntukanDermagaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel39)
                            .addComponent(jLabel30))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(peruntukanLainnyaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(peruntukanRumahMesinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel31)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        simpanBtn.setText("Simpan");
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        try {
            nopField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.###.###.###-####.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nopField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopFieldActionPerformed(evt);
            }
        });
        nopField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nopFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nopField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelInfo)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelInfo)
                    .addComponent(nopField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simpanBtn)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nopFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nopFieldActionPerformed

    private void nopFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nopFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean cek = control.cekNop(nopField.getText().replace(".", "").replace("-", ""));
            
            if(cek)
            {
                 int reply = JOptionPane.showConfirmDialog(this, "NOP : " + nopField.getText()
                    + " sudah ada, apakah akan dilakukan pemutakhiran data ?",
                    "Konfirmasi NOP", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    this.isEdit = true;
                this.enableAllField(true);
                this.editMode(nopField.getText().replace(".", "").replace("-", ""));
                
                } else {
                    nopField.setText("");
                }
                
            }else
            {
                this.enableAllField(true);
                this.isEdit = false;
            }
                   
       }
        
    }//GEN-LAST:event_nopFieldKeyPressed

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
       int reply = JOptionPane.showConfirmDialog(this, "Perubahan data akan disimpan ?", 
                       "Konfirmasi Simpan", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
           this.simpan();
         }
           this.dispose();
     
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void peruntukanLainnyaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peruntukanLainnyaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peruntukanLainnyaFieldActionPerformed

    private void peruntukanJalanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peruntukanJalanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peruntukanJalanFieldActionPerformed

    private void subyekNpwpFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subyekNpwpFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subyekNpwpFieldActionPerformed

    public void enableAllField(boolean status)
    {
     obyekAreaField.setEnabled(status);
     obyekIzinField.setEnabled(status);
     peruntukanDermagaField.setEnabled(status);
     peruntukanGudangField.setEnabled(status);
     peruntukanJalanField.setEnabled(status);
     peruntukanKamarDinginField.setEnabled(status);
     peruntukanKantorField.setEnabled(status);
     peruntukanLaboratoriumField.setEnabled(status);
     peruntukanLainnyaField.setEnabled(status);
     peruntukanPerumahanField.setEnabled(status);
     peruntukanTangkiField.setEnabled(status);
     simpanBtn.setEnabled(status);
     subyekKontraktorField.setEnabled(status);
     subyekNamaField.setEnabled(status);
     subyekNpwpField.setEnabled(status);
     this.txtKabupatenWp.setEnabled(status);
     this.txtKelurahanWp.setEnabled(status);
     this.txtNmJlnWp.setEnabled(status);
     this.txtNoJlnWp.setEnabled(status);
     this.txtRwRtWp.setEnabled(status);
     this.obyekLokasiField.setEnabled(status);
     this.obyekPenangkapanIkan.setEnabled(status);
     this.obyekPembudidayaanIkan.setEnabled(status);
     this.peruntukanRumahMesinField.setEnabled(status);
     
    }
    
    public void simpan(){
      try{  
        ModelSpopPerikanan modelSpop = new ModelSpopPerikanan();
        String nop = nopField.getText().replace(".", "").replace("-", "");
        Spop spop = new Spop();
        spop.setNop(nop);
        spop.setNamaWp(this.subyekNamaField.getText());
        spop.setJalanOp(this.obyekLokasiField.getText());
        spop.setLuasTanah(Double.parseDouble(this.obyekAreaField.getText()));
        spop.setNpwp(this.subyekNpwpField.getText());
        spop.setJalanWp(this.txtNmJlnWp.getText());
        spop.setKelurahanWp(this.txtKelurahanWp.getText());
        spop.setKabupaten(this.txtKabupatenWp.getText());
        spop.setRwRtWp(this.txtRwRtWp.getText());
        spop.setNoJalanWp(this.txtNoJlnWp.getText());
        spop.setKelurahanOp(this.obyekKelurahanField.getText());
        
        ModelSpopTambahan spopTambahan = new ModelSpopTambahan();
        spopTambahan.setNop(nop);
        spopTambahan.setKontraktor(this.subyekKontraktorField.getText());
        spopTambahan.setPenangkapanIkan(this.obyekPenangkapanIkan.getText());
        spopTambahan.setBudidayaIkan(this.obyekPembudidayaanIkan.getText());
        spopTambahan.setNoIzinPerikanan(this.obyekIzinField.getText());
        
        ArrayList<ModelSpopBumi> arrBumi = new ArrayList<ModelSpopBumi>();
        
        for(int i = 1; i < 11;i++)
        {
            ModelSpopBumi model = new ModelSpopBumi();
            if(i == 1)
            {   
                
                double luas = 0;
                if(!this.peruntukanKantorField.getText().equalsIgnoreCase("") || this.peruntukanKantorField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanKantorField.getText());
                }
                
                model.setKode("01");
                model.setPeruntukan("Kantor");
                model.setLuas(luas);
            }else if(i == 2){
                
                 double luas = 0;
                if(!this.peruntukanGudangField.getText().equalsIgnoreCase("") || this.peruntukanGudangField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanGudangField.getText());
                }
                    model.setKode("02");
                model.setPeruntukan("Gudang");
                model.setLuas(luas);
            }else if(i == 3){
                 double luas = 0;
                if(!this.peruntukanPerumahanField.getText().equalsIgnoreCase("") || this.peruntukanPerumahanField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanPerumahanField.getText());
                }
                model.setKode("03");
                model.setPeruntukan("Perumahan");
                model.setLuas(luas);
            
            }else if(i == 4){
             
                double luas = 0;
                if(!this.peruntukanLaboratoriumField.getText().equalsIgnoreCase("") || this.peruntukanLaboratoriumField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanLaboratoriumField.getText());
                }
            
                
                model.setKode("04");
                model.setPeruntukan("Laboratorium");
                model.setLuas(luas);
            }else if(i == 5){
                
                double luas = 0;
                if(!this.peruntukanRumahMesinField.getText().equalsIgnoreCase("") || this.peruntukanRumahMesinField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanRumahMesinField.getText());
                }
                    model.setKode("05");
                model.setPeruntukan("Rumah Mesin");
                model.setLuas(luas);
            }else if(i == 6){
                double luas = 0;
                if(!this.peruntukanJalanField.getText().equalsIgnoreCase("") || this.peruntukanJalanField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanJalanField.getText());
                }
                    model.setKode("06");
                model.setPeruntukan("Jalan Lingkungan Diperkeras");
                model.setLuas(luas);
            }else if(i == 7){
                double luas = 0;
                if(!this.peruntukanTangkiField.getText().equalsIgnoreCase("") || this.peruntukanTangkiField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanTangkiField.getText());
                }
                model.setKode("07");
                model.setPeruntukan("Tangki/Silo");
                model.setLuas(luas);
            }else if(i == 8){
                double luas = 0;
                if(!this.peruntukanKamarDinginField.getText().equalsIgnoreCase("") || this.peruntukanKamarDinginField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanKamarDinginField.getText());
                }
                
                model.setKode("08");
                model.setPeruntukan("Kamar Pendingin");
                model.setLuas(luas);
            }else if(i == 9){
                double luas = 0;
                if(!this.peruntukanDermagaField.getText().equalsIgnoreCase("") || this.peruntukanDermagaField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanDermagaField.getText());
                }
                
                model.setKode("09");
                model.setPeruntukan("Dermaga");
                model.setLuas(luas);
            }else if(i == 10){
                double luas = 0;
                if(!this.peruntukanLainnyaField.getText().equalsIgnoreCase("") || this.peruntukanLainnyaField.getText() == null)
                {
                    luas = Double.parseDouble(this.peruntukanLainnyaField.getText());
                }
                
                model.setKode("10");
                model.setPeruntukan("Lainnya");
                model.setLuas(luas);
            }
            arrBumi.add(model);
          }
        
        modelSpop.setSpop(spop);
        modelSpop.setSpopTambahan(spopTambahan);
        modelSpop.setSpopBumi(arrBumi);
        
        if(isEdit)
        {
            control.simpanDataSpop(modelSpop, 1);
        }else
        {
            control.simpanDataSpop(modelSpop, 0);
        }
        
      }catch(Exception e){
          e.printStackTrace();
          JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan input. Harap isi data dengan benar", "Error Input SPO", JOptionPane.ERROR_MESSAGE, null);
      }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JFormattedTextField nopField;
    private javax.swing.JTextField obyekAreaField;
    private javax.swing.JTextField obyekIzinField;
    private javax.swing.JTextField obyekKelurahanField;
    private javax.swing.JTextField obyekLokasiField;
    private javax.swing.JTextField obyekPembudidayaanIkan;
    private javax.swing.JTextField obyekPenangkapanIkan;
    private javax.swing.JTextField peruntukanDermagaField;
    private javax.swing.JTextField peruntukanGudangField;
    private javax.swing.JTextField peruntukanJalanField;
    private javax.swing.JTextField peruntukanKamarDinginField;
    private javax.swing.JTextField peruntukanKantorField;
    private javax.swing.JTextField peruntukanLaboratoriumField;
    private javax.swing.JTextField peruntukanLainnyaField;
    private javax.swing.JTextField peruntukanPerumahanField;
    private javax.swing.JTextField peruntukanRumahMesinField;
    private javax.swing.JTextField peruntukanTangkiField;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JTextField subyekKontraktorField;
    private javax.swing.JTextField subyekNamaField;
    private javax.swing.JTextField subyekNpwpField;
    private javax.swing.JTextField txtKabupatenWp;
    private javax.swing.JTextField txtKelurahanWp;
    private javax.swing.JTextField txtNmJlnWp;
    private javax.swing.JTextField txtNoJlnWp;
    private javax.swing.JFormattedTextField txtRwRtWp;
    // End of variables declaration//GEN-END:variables
}
