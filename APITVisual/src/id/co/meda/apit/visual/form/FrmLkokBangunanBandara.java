/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokBangunanKhususBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokBangunanUmumBandara;
import id.co.meda.apit.visual.controller.ControlLkokBngBandara;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FrmLkokBangunanBandara extends javax.swing.JDialog {

    private ControlLkokBngBandara control = new ControlLkokBngBandara();
    /**
     * Creates new form FrmLkokBangunanKhusus
     */
    public FrmLkokBangunanBandara(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inisiasiAwal();
    }
    
    public FrmLkokBangunanBandara(java.awt.Frame parent, boolean modal, boolean kdEdit, String nop) {
        super(parent, modal);
        initComponents();
        inisiasiAwal();
    }
    
    public void formattedTextField()
    {
        ToolsFrm.setTextFilterNumber(this.txtThnDibangun,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.txtThnRenovasi,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.APRON_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.APRON_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.APRON_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.APRON_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.APRON_txtPanjang,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.AKSES_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.AKSES_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.AKSES_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.AKSES_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.AKSES_txtPanjang,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.HELIPAD_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.HELIPAD_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.HELIPAD_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.HELIPAD_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.HELIPAD_txtPanjang,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.INSPEKSI_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.INSPEKSI_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.INSPEKSI_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.INSPEKSI_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.INSPEKSI_txtPanjang,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.RUNWAY_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.RUNWAY_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.RUNWAY_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.RUNWAY_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.RUNWAY_txtPanjang,"[^0-9.]");
        
        ToolsFrm.setTextFilterNumber(this.TAXIWAY_txtKaku,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.TAXIWAY_txtLebar,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.TAXIWAY_txtLentur,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.TAXIWAY_txtLuas,"[^0-9.]");
        ToolsFrm.setTextFilterNumber(this.TAXIWAY_txtPanjang,"[^0-9.]");
        
    }
    
    private void simpan()
    {
        String tmpNop = txtNop.getText().replace(".", "").replace("-", "");
        
        //buat lkok khusus
        ArrayList<LkokBangunanKhususBandara> arrTemp = new ArrayList<LkokBangunanKhususBandara>();
        
        //id 01
        LkokBangunanKhususBandara lkok01 = new LkokBangunanKhususBandara();
        lkok01.setNop(tmpNop);
        lkok01.setIdJpb("01");
        lkok01.setJpbBandara("Runway");
        lkok01.setPanjang(Double.parseDouble((this.RUNWAY_txtPanjang.getText().equals(""))? "0" : this.RUNWAY_txtPanjang.getText()));
        lkok01.setLebar(Double.parseDouble((this.RUNWAY_txtLebar.getText().equals(""))? "0":this.RUNWAY_txtLebar.getText() ));
        lkok01.setLuas(Double.parseDouble((this.RUNWAY_txtLuas.getText().equals("")?"0":this.RUNWAY_txtLuas.getText())));
        lkok01.setPerkerasanKaku(Double.parseDouble( (this.RUNWAY_txtKaku.getText().equals("")?"0":this.RUNWAY_txtKaku.getText())));
        lkok01.setPerkerasanLentur(Double.parseDouble((this.RUNWAY_txtLentur.getText().equals("")?"0":this.RUNWAY_txtLentur.getText())));
        
        //id 02
        LkokBangunanKhususBandara lkok02 = new LkokBangunanKhususBandara();
        lkok02.setNop(tmpNop);
        lkok02.setIdJpb("02");
        lkok02.setJpbBandara("Apron");
        lkok02.setPanjang(Double.parseDouble((this.APRON_txtPanjang.getText().equals(""))? "0" : this.APRON_txtPanjang.getText()));
        lkok02.setLebar(Double.parseDouble((this.APRON_txtLebar.getText().equals(""))? "0":this.APRON_txtLebar.getText() ));
        lkok02.setLuas(Double.parseDouble((this.APRON_txtLuas.getText().equals("")?"0":this.APRON_txtLuas.getText())));
        lkok02.setPerkerasanKaku(Double.parseDouble( (this.APRON_txtKaku.getText().equals("")?"0":this.APRON_txtKaku.getText())));
        lkok02.setPerkerasanLentur(Double.parseDouble((this.APRON_txtLentur.getText().equals("")?"0":this.APRON_txtLentur.getText())));
        
        //id 03
        LkokBangunanKhususBandara lkok03 = new LkokBangunanKhususBandara();
        lkok03.setNop(tmpNop);
        lkok03.setIdJpb("03");
        lkok03.setJpbBandara("Taxiway");
        lkok03.setPanjang(Double.parseDouble((this.TAXIWAY_txtPanjang.getText().equals(""))? "0" : this.TAXIWAY_txtPanjang.getText()));
        lkok03.setLebar(Double.parseDouble((this.TAXIWAY_txtLebar.getText().equals(""))? "0":this.TAXIWAY_txtLebar.getText() ));
        lkok03.setLuas(Double.parseDouble((this.TAXIWAY_txtLuas.getText().equals("")?"0":this.TAXIWAY_txtLuas.getText())));
        lkok03.setPerkerasanKaku(Double.parseDouble( (this.TAXIWAY_txtKaku.getText().equals("")?"0":this.TAXIWAY_txtKaku.getText())));
        lkok03.setPerkerasanLentur(Double.parseDouble((this.TAXIWAY_txtLentur.getText().equals("")?"0":this.TAXIWAY_txtLentur.getText())));
        
        //id 04
        LkokBangunanKhususBandara lkok04 = new LkokBangunanKhususBandara();
        lkok04.setNop(tmpNop);
        lkok04.setIdJpb("04");
        lkok04.setJpbBandara("Inspeksi");
        lkok04.setPanjang(Double.parseDouble((this.INSPEKSI_txtPanjang.getText().equals(""))? "0" : this.INSPEKSI_txtPanjang.getText()));
        lkok04.setLebar(Double.parseDouble((this.INSPEKSI_txtLebar.getText().equals(""))? "0":this.INSPEKSI_txtLebar.getText() ));
        lkok04.setLuas(Double.parseDouble((this.INSPEKSI_txtLuas.getText().equals("")?"0":this.INSPEKSI_txtLuas.getText())));
        lkok04.setPerkerasanKaku(Double.parseDouble( (this.INSPEKSI_txtKaku.getText().equals("")?"0":this.INSPEKSI_txtKaku.getText())));
        lkok04.setPerkerasanLentur(Double.parseDouble((this.INSPEKSI_txtLentur.getText().equals("")?"0":this.INSPEKSI_txtLentur.getText())));
        
        //id 05
        LkokBangunanKhususBandara lkok05 = new LkokBangunanKhususBandara();
        lkok05.setNop(tmpNop);
        lkok05.setIdJpb("05");
        lkok05.setJpbBandara("Akses");
        lkok05.setPanjang(Double.parseDouble((this.AKSES_txtPanjang.getText().equals(""))? "0" : this.AKSES_txtPanjang.getText()));
        lkok05.setLebar(Double.parseDouble((this.AKSES_txtLebar.getText().equals(""))? "0":this.AKSES_txtLebar.getText() ));
        lkok05.setLuas(Double.parseDouble((this.AKSES_txtLuas.getText().equals("")?"0":this.AKSES_txtLuas.getText())));
        lkok05.setPerkerasanKaku(Double.parseDouble( (this.AKSES_txtKaku.getText().equals("")?"0":this.AKSES_txtKaku.getText())));
        lkok05.setPerkerasanLentur(Double.parseDouble((this.AKSES_txtLentur.getText().equals("")?"0":this.AKSES_txtLentur.getText())));
        
        //id 06
        LkokBangunanKhususBandara lkok06 = new LkokBangunanKhususBandara();
        lkok06.setNop(tmpNop);
        lkok06.setIdJpb("06");
        lkok06.setJpbBandara("Helipad");
        lkok06.setPanjang(Double.parseDouble((this.HELIPAD_txtPanjang.getText().equals(""))? "0" : this.HELIPAD_txtPanjang.getText()));
        lkok06.setLebar(Double.parseDouble((this.HELIPAD_txtLebar.getText().equals(""))? "0":this.HELIPAD_txtLebar.getText() ));
        lkok06.setLuas(Double.parseDouble((this.HELIPAD_txtLuas.getText().equals("")?"0":this.HELIPAD_txtLuas.getText())));
        lkok06.setPerkerasanKaku(Double.parseDouble( (this.HELIPAD_txtKaku.getText().equals("")?"0":this.HELIPAD_txtKaku.getText())));
        lkok06.setPerkerasanLentur(Double.parseDouble((this.HELIPAD_txtLentur.getText().equals("")?"0":this.HELIPAD_txtLentur.getText())));
        
        arrTemp.add(lkok01);
        arrTemp.add(lkok02);
        arrTemp.add(lkok03);
        arrTemp.add(lkok04);
        arrTemp.add(lkok05);
        arrTemp.add(lkok06);
        
        String jpbRunway = "no";
        if(this.cekRunway.isSelected())
        {
            jpbRunway = "yes";
        }
        
        String jpbApron = "no";
        if(this.cekApron.isSelected())
        {
            jpbApron = "yes";
        }
        
        String jpbTaxiway = "no";
        if(this.cekTaxiway.isSelected())
        {
            jpbTaxiway = "yes";
        }
        
        String jpbInspeksiLbh4 = "no";
        if(this.cekInspeksiLbh4.isSelected())
        {
            jpbInspeksiLbh4 = "yes";
        }
        
        String jpbInspeksiKrg4 = "no";
        if(this.cekInspeksiKrg4.isSelected())
        {
            jpbInspeksiKrg4 = "yes";
        }
        
        String konstruksi = "";
        
        if(this.radioKaku.isSelected())
        {
            konstruksi = "kaku";
        }else if(this.radioLentur.isSelected())
        {
            konstruksi = "lentur";
        }else if(this.radioKomposit.isSelected())
        {
            konstruksi = "komposit";
        }else if(this.radioLain.isSelected())
        {
            konstruksi = this.txtKonstruksi.getText();
        }
        
        String kondUmum = "";
        
        if(this.radioSangatBaik.isSelected())
        {
            kondUmum = "Sangat Baik";
        }else if(this.radioBaik.isSelected())
        {
            kondUmum = "Baik";
        }

        String thnDibangun = this.txtThnDibangun.getText();
        String thnRenovasi = this.txtThnRenovasi.getText();
        
        
        boolean temp = control.simpan(tmpNop, jpbRunway, jpbApron, jpbTaxiway, jpbInspeksiLbh4, 
                jpbInspeksiKrg4, konstruksi, kondUmum, thnDibangun, thnRenovasi, arrTemp);
        
        if(temp)
        {
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan", "Penyimpanan Data", JOptionPane.INFORMATION_MESSAGE);
            this.txtNop.setEnabled(false);
            this.labelStat.setText("Pemuktahiran Data");
        }else
        {
            JOptionPane.showMessageDialog(rootPane, 
                    "Data gagal disimpan", "Penyimpanan Data", JOptionPane.ERROR_MESSAGE);
       
        }
    
                
    }
    
    
    private void inisiasiAwal()
    {
        this.txtKonstruksi.setEnabled(false);
        ButtonGroup btnKonstruksi = new ButtonGroup();
        btnKonstruksi.add(this.radioLentur);
        btnKonstruksi.add(this.radioKaku);
        btnKonstruksi.add(this.radioKomposit);
        btnKonstruksi.add(this.radioLain);
        
        ButtonGroup btnKondUmum = new ButtonGroup();
        btnKondUmum.add(this.radioSangatBaik);
        btnKondUmum.add(this.radioBaik);
    
        this.radioKaku.setSelected(true);
        this.radioSangatBaik.setSelected(true);
        
        enableElement(false);
        
        this.formattedTextField();
    }
    
    private void enableElement(boolean cek)
    {
        this.cekApron.setEnabled(cek);
        this.cekInspeksiKrg4.setEnabled(cek);
        this.cekInspeksiLbh4.setEnabled(cek);
        this.cekRunway.setEnabled(cek);
        this.cekTaxiway.setEnabled(cek);
        this.radioBaik.setEnabled(cek);
        this.radioKaku.setEnabled(cek);
        this.radioKomposit.setEnabled(cek);
        this.radioLain.setEnabled(cek);
        this.radioLentur.setEnabled(cek);
        this.radioSangatBaik.setEnabled(cek);
        this.txtThnDibangun.setEnabled(cek);
        this.txtThnRenovasi.setEnabled(cek);
        
        
        enableKhususElement("",false);
        this.AKSES_txtKaku.setEnabled(cek);
        this.AKSES_txtLebar.setEnabled(cek);
        this.AKSES_txtLentur.setEnabled(cek);
        this.AKSES_txtLuas.setEnabled(cek);
        this.AKSES_txtPanjang.setEnabled(cek); 
        
        this.HELIPAD_txtKaku.setEnabled(cek);
        this.HELIPAD_txtLebar.setEnabled(cek);
        this.HELIPAD_txtLentur.setEnabled(cek);
        this.HELIPAD_txtLuas.setEnabled(cek);
        this.HELIPAD_txtPanjang.setEnabled(cek); 
        
    }
    
    private void enableKhususElement(String cek,boolean temp)
    {
        switch(cek){
            
            case "Runway": 
                      this.RUNWAY_txtKaku.setEnabled(temp);
                      this.RUNWAY_txtLebar.setEnabled(temp);
                      this.RUNWAY_txtLentur.setEnabled(temp);
                      this.RUNWAY_txtLuas.setEnabled(temp);
                      this.RUNWAY_txtPanjang.setEnabled(temp);
                      break;
            case "Apron" :    
                      this.APRON_txtKaku.setEnabled(temp);
                      this.APRON_txtLebar.setEnabled(temp);
                      this.APRON_txtLentur.setEnabled(temp);
                      this.APRON_txtLuas.setEnabled(temp);
                      this.APRON_txtPanjang.setEnabled(temp);
                      break;
            case "Taxiway" :    
                      this.TAXIWAY_txtKaku.setEnabled(temp);
                      this.TAXIWAY_txtLebar.setEnabled(temp);
                      this.TAXIWAY_txtLentur.setEnabled(temp);
                      this.TAXIWAY_txtLuas.setEnabled(temp);
                      this.TAXIWAY_txtPanjang.setEnabled(temp);   
                      break;
                
            case "Inspeksi" :
                      this.INSPEKSI_txtKaku.setEnabled(temp);
                      this.INSPEKSI_txtLebar.setEnabled(temp);
                      this.INSPEKSI_txtLentur.setEnabled(temp);
                      this.INSPEKSI_txtLuas.setEnabled(temp);
                      this.INSPEKSI_txtPanjang.setEnabled(temp);  
                      break;
            default:
                      this.RUNWAY_txtKaku.setEnabled(temp);
                      this.RUNWAY_txtLebar.setEnabled(temp);
                      this.RUNWAY_txtLentur.setEnabled(temp);
                      this.RUNWAY_txtLuas.setEnabled(temp);
                      this.RUNWAY_txtPanjang.setEnabled(temp);
                      this.APRON_txtKaku.setEnabled(temp);
                      this.APRON_txtLebar.setEnabled(temp);
                      this.APRON_txtLentur.setEnabled(temp);
                      this.APRON_txtLuas.setEnabled(temp);
                      this.APRON_txtPanjang.setEnabled(temp);
                      this.TAXIWAY_txtKaku.setEnabled(temp);
                      this.TAXIWAY_txtLebar.setEnabled(temp);
                      this.TAXIWAY_txtLentur.setEnabled(temp);
                      this.TAXIWAY_txtLuas.setEnabled(temp);
                      this.TAXIWAY_txtPanjang.setEnabled(temp);  
                      this.INSPEKSI_txtKaku.setEnabled(temp);
                      this.INSPEKSI_txtLebar.setEnabled(temp);
                      this.INSPEKSI_txtLentur.setEnabled(temp);
                      this.INSPEKSI_txtLuas.setEnabled(temp);
                      this.INSPEKSI_txtPanjang.setEnabled(temp); 
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

        jCheckBox3 = new javax.swing.JCheckBox();
        jRadioButton6 = new javax.swing.JRadioButton();
        txtNop = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        labelStat = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cekRunway = new javax.swing.JCheckBox();
        cekTaxiway = new javax.swing.JCheckBox();
        cekApron = new javax.swing.JCheckBox();
        cekInspeksiLbh4 = new javax.swing.JCheckBox();
        cekInspeksiKrg4 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        radioKaku = new javax.swing.JRadioButton();
        radioLentur = new javax.swing.JRadioButton();
        radioKomposit = new javax.swing.JRadioButton();
        radioLain = new javax.swing.JRadioButton();
        txtKonstruksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        radioSangatBaik = new javax.swing.JRadioButton();
        radioBaik = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtThnDibangun = new javax.swing.JTextField();
        txtThnRenovasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        RUNWAY_txtPanjang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RUNWAY_txtLebar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RUNWAY_txtLuas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        RUNWAY_txtKaku = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        RUNWAY_txtLentur = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel22 = new javax.swing.JLabel();
        APRON_txtPanjang = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        APRON_txtLebar = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        APRON_txtLuas = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        APRON_txtKaku = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        APRON_txtLentur = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel34 = new javax.swing.JLabel();
        TAXIWAY_txtPanjang = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TAXIWAY_txtLebar = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        TAXIWAY_txtLuas = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        TAXIWAY_txtKaku = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        TAXIWAY_txtLentur = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel46 = new javax.swing.JLabel();
        INSPEKSI_txtPanjang = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        INSPEKSI_txtLebar = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        INSPEKSI_txtLuas = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        INSPEKSI_txtKaku = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        INSPEKSI_txtLentur = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel58 = new javax.swing.JLabel();
        AKSES_txtPanjang = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        AKSES_txtLebar = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        AKSES_txtLuas = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        AKSES_txtKaku = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        AKSES_txtLentur = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jLabel70 = new javax.swing.JLabel();
        HELIPAD_txtPanjang = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        HELIPAD_txtLebar = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        HELIPAD_txtLuas = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        HELIPAD_txtKaku = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        HELIPAD_txtLentur = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();

        jCheckBox3.setText("Taxiway");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Sangat Baik");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LKOK Bangunan Bandara");

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

        jLabel1.setText("NOP");

        labelStat.setForeground(new java.awt.Color(0, 0, 255));
        labelStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStat.setText("Perekaman Data Baru");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setBackground(new java.awt.Color(0, 0, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Data Umum Bangunan");
        jLabel16.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(0, 0, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Data Khusus Bangunan");
        jLabel18.setOpaque(true);

        jLabel2.setText("Jenis Penggunaan Bangunan");

        cekRunway.setText("Runway");
        cekRunway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekRunwayActionPerformed(evt);
            }
        });

        cekTaxiway.setText("Taxiway");
        cekTaxiway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekTaxiwayActionPerformed(evt);
            }
        });

        cekApron.setText("Apron");
        cekApron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekApronActionPerformed(evt);
            }
        });

        cekInspeksiLbh4.setText("Jalan inspeksi lebar >= 4 Meter");
        cekInspeksiLbh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekInspeksiLbh4ActionPerformed(evt);
            }
        });

        cekInspeksiKrg4.setText("Jalan inspeksi lebar < 4 Meter");
        cekInspeksiKrg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekInspeksiKrg4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Konstruksi");

        radioKaku.setText("Kaku");
        radioKaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKakuActionPerformed(evt);
            }
        });

        radioLentur.setText("Lentur");
        radioLentur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLenturActionPerformed(evt);
            }
        });

        radioKomposit.setText("Komposit");
        radioKomposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKompositActionPerformed(evt);
            }
        });

        radioLain.setText("Lainnya");
        radioLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLainActionPerformed(evt);
            }
        });

        jLabel4.setText("Kondisi Umum");

        radioSangatBaik.setText("Sangat Baik");

        radioBaik.setText("Baik");

        jLabel5.setText("Tahun Dibangun");

        jLabel6.setText("Tahun Renovasi");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Runway"));

        jLabel7.setText("Panjang");

        RUNWAY_txtPanjang.setText("0");

        jLabel8.setText("m");

        jLabel9.setText("Lebar");

        RUNWAY_txtLebar.setText("0");

        jLabel10.setText("m");

        jLabel11.setText("Luas");

        RUNWAY_txtLuas.setText("0");

        jLabel12.setText("M2");

        jLabel13.setText("Perkerasan Kaku");

        jLabel14.setText("Perkerasan Lentur");

        jLabel15.setText("Luas");

        RUNWAY_txtKaku.setText("0");

        jLabel19.setText("M2");

        RUNWAY_txtLentur.setText("0");

        jLabel20.setText("Luas");

        jLabel21.setText("M2");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNWAY_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNWAY_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNWAY_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNWAY_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RUNWAY_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(RUNWAY_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(RUNWAY_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(RUNWAY_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(RUNWAY_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20)
                    .addComponent(RUNWAY_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(RUNWAY_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(RUNWAY_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(RUNWAY_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(RUNWAY_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(RUNWAY_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Apron"));

        jLabel22.setText("Panjang");

        APRON_txtPanjang.setText("0");

        jLabel23.setText("m");

        jLabel24.setText("Lebar");

        APRON_txtLebar.setText("0");

        jLabel25.setText("m");

        jLabel26.setText("Luas");

        APRON_txtLuas.setText("0");

        jLabel27.setText("M2");

        jLabel28.setText("Perkerasan Kaku");

        jLabel29.setText("Perkerasan Lentur");

        jLabel30.setText("Luas");

        APRON_txtKaku.setText("0");

        jLabel31.setText("M2");

        APRON_txtLentur.setText("0");

        jLabel32.setText("Luas");

        jLabel33.setText("M2");

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(APRON_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(APRON_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(APRON_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(APRON_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(APRON_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(APRON_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(APRON_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(APRON_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(APRON_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32)
                    .addComponent(APRON_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(APRON_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(APRON_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(APRON_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(APRON_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(APRON_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Taxiway"));

        jLabel34.setText("Panjang");

        TAXIWAY_txtPanjang.setText("0");

        jLabel35.setText("m");

        jLabel36.setText("Lebar");

        TAXIWAY_txtLebar.setText("0");

        jLabel37.setText("m");

        jLabel38.setText("Luas");

        TAXIWAY_txtLuas.setText("0");

        jLabel39.setText("M2");

        jLabel40.setText("Perkerasan Kaku");

        jLabel41.setText("Perkerasan Lentur");

        jLabel42.setText("Luas");

        TAXIWAY_txtKaku.setText("0");

        jLabel43.setText("M2");

        TAXIWAY_txtLentur.setText("0");

        jLabel44.setText("Luas");

        jLabel45.setText("M2");

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAXIWAY_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAXIWAY_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37))
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAXIWAY_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAXIWAY_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAXIWAY_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(TAXIWAY_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(TAXIWAY_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(TAXIWAY_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(TAXIWAY_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel44)
                    .addComponent(TAXIWAY_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(TAXIWAY_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel35, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(TAXIWAY_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel37, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(TAXIWAY_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel39, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel40, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel41, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel42, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(TAXIWAY_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel43, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(TAXIWAY_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel44, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel45, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Jalan Inspeksi"));

        jLabel46.setText("Panjang");

        INSPEKSI_txtPanjang.setText("0");

        jLabel47.setText("m");

        jLabel48.setText("Lebar");

        INSPEKSI_txtLebar.setText("0");

        jLabel49.setText("m");

        jLabel50.setText("Luas");

        INSPEKSI_txtLuas.setText("0");

        jLabel51.setText("M2");

        jLabel52.setText("Perkerasan Kaku");

        jLabel53.setText("Perkerasan Lentur");

        jLabel54.setText("Luas");

        INSPEKSI_txtKaku.setText("0");

        jLabel55.setText("M2");

        INSPEKSI_txtLentur.setText("0");

        jLabel56.setText("Luas");

        jLabel57.setText("M2");

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSPEKSI_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSPEKSI_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49))
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSPEKSI_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSPEKSI_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55))
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INSPEKSI_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(INSPEKSI_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(INSPEKSI_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(INSPEKSI_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel52)
                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(INSPEKSI_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel56)
                    .addComponent(INSPEKSI_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane5.setLayer(jLabel46, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(INSPEKSI_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(INSPEKSI_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(INSPEKSI_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel53, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel54, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(INSPEKSI_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel55, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(INSPEKSI_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel56, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel57, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createTitledBorder("Jalan Akses"));

        jLabel58.setText("Panjang");

        AKSES_txtPanjang.setText("0");

        jLabel59.setText("m");

        jLabel60.setText("Lebar");

        AKSES_txtLebar.setText("0");

        jLabel61.setText("m");

        jLabel62.setText("Luas");

        AKSES_txtLuas.setText("0");

        jLabel63.setText("M2");

        jLabel64.setText("Perkerasan Kaku");

        jLabel65.setText("Perkerasan Lentur");

        jLabel66.setText("Luas");

        AKSES_txtKaku.setText("0");

        jLabel67.setText("M2");

        AKSES_txtLentur.setText("0");

        jLabel68.setText("Luas");

        jLabel69.setText("M2");

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AKSES_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AKSES_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61))
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AKSES_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69))
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AKSES_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67))
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AKSES_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel63)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(AKSES_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(AKSES_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(AKSES_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel66)
                        .addComponent(AKSES_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel67)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jLabel68)
                    .addComponent(AKSES_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane6.setLayer(jLabel58, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AKSES_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel59, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel60, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AKSES_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel61, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel62, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AKSES_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel63, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel64, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel65, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel66, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AKSES_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel67, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AKSES_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel68, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel69, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane7.setBorder(javax.swing.BorderFactory.createTitledBorder("Helipad"));

        jLabel70.setText("Panjang");

        HELIPAD_txtPanjang.setText("0");

        jLabel71.setText("m");

        jLabel72.setText("Lebar");

        HELIPAD_txtLebar.setText("0");

        jLabel73.setText("m");

        jLabel74.setText("Luas");

        HELIPAD_txtLuas.setText("0");

        jLabel75.setText("M2");

        jLabel76.setText("Perkerasan Kaku");

        jLabel77.setText("Perkerasan Lentur");

        jLabel78.setText("Luas");

        HELIPAD_txtKaku.setText("0");

        jLabel79.setText("M2");

        HELIPAD_txtLentur.setText("0");

        jLabel80.setText("Luas");

        jLabel81.setText("M2");

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HELIPAD_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HELIPAD_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73))
                    .addComponent(jLabel76)
                    .addComponent(jLabel77))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HELIPAD_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel81))
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HELIPAD_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel79))
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HELIPAD_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(HELIPAD_txtPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel72)
                    .addComponent(HELIPAD_txtLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jLabel74)
                    .addComponent(HELIPAD_txtLuas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel76)
                    .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel78)
                        .addComponent(HELIPAD_txtKaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel79)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel80)
                    .addComponent(HELIPAD_txtLentur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane7.setLayer(jLabel70, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(HELIPAD_txtPanjang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel71, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel72, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(HELIPAD_txtLebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel73, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel74, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(HELIPAD_txtLuas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel75, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel76, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel77, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel78, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(HELIPAD_txtKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel79, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(HELIPAD_txtLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel80, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel81, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLayeredPane4)
            .addComponent(jLayeredPane5)
            .addComponent(jLayeredPane6)
            .addComponent(jLayeredPane7)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(radioKaku)
                        .addGap(18, 18, 18)
                        .addComponent(radioLentur)
                        .addGap(18, 18, 18)
                        .addComponent(radioKomposit)
                        .addGap(22, 22, 22)
                        .addComponent(radioLain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKonstruksi))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(radioSangatBaik)
                                .addGap(18, 18, 18)
                                .addComponent(radioBaik))
                            .addComponent(txtThnDibangun, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cekInspeksiKrg4)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(cekRunway)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cekTaxiway)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cekApron)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cekInspeksiLbh4))
                            .addComponent(txtThnRenovasi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekRunway)
                    .addComponent(cekTaxiway)
                    .addComponent(cekApron)
                    .addComponent(jLabel2)
                    .addComponent(cekInspeksiLbh4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cekInspeksiKrg4)
                .addGap(7, 7, 7)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radioKaku)
                    .addComponent(radioLentur)
                    .addComponent(radioKomposit)
                    .addComponent(radioLain)
                    .addComponent(txtKonstruksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioSangatBaik)
                    .addComponent(radioBaik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThnDibangun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtThnRenovasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cekRunway, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cekTaxiway, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cekApron, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cekInspeksiLbh4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cekInspeksiKrg4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioKaku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioLentur, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioKomposit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioLain, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtKonstruksi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioSangatBaik, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radioBaik, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtThnDibangun, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtThnRenovasi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStat)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpan)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNopActionPerformed

    private void txtNopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tmpNop = txtNop.getText().replace(".", "").replace("-", "");
            if(control.cekNOPTanah(tmpNop))
            {    
                    if (control.cekNOP(tmpNop)) {
                        int reply = JOptionPane.showConfirmDialog(this, "NOP : " + txtNop.getText()
                            + " sudah memiliki LKOK Bangunan, apakah akan dilakukan pemutakhiran data ?",
                            "Konfirmasi NOP", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {

                           LkokBangunanUmumBandara lkokBng = control.getLkokBng(tmpNop);
                           isiEdit(lkokBng);
                           this.enableElement(true);
                           this.txtNop.setEnabled(false);
                           this.labelStat.setText("Pemuktahiran Data");

                        } else {
                            txtNop.setText("");
                            this.labelStat.setText("Perekaman Data Baru");
                        }
                    } else {

                     JOptionPane.showMessageDialog(this, "NOP : " + txtNop.getText()
                            + " Belum memiliki LKOK Bangunan, Silakan mengisi data "
                             + "LKOK Bangunan terlebih dahulu",
                             "Konfirmasi NOP", JOptionPane.INFORMATION_MESSAGE);
                             this.labelStat.setText("Perekaman Data Baru");
                     this.enableElement(true);
                     txtNop.requestFocus();
                    }
            }else
            {
                     JOptionPane.showMessageDialog(this, "NOP : " + txtNop.getText()
                            + " Belum terdaftar. Silakan isi LKOK Tanah terlebih dahulu",
                            "Konfirmasi NOP", JOptionPane.INFORMATION_MESSAGE);
                             this.labelStat.setText("Perekaman Data Baru");
                     
                     this.enableElement(false);
                     txtNop.setText("");
                     txtNop.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNopKeyPressed

    private void isiEdit(LkokBangunanUmumBandara lkokBng)
    {
        this.txtNop.setText(lkokBng.getNop());
        this.txtThnDibangun.setText(lkokBng.getThnDibangun());
        this.txtThnRenovasi.setText(lkokBng.getThnRenovasi());
        this.enableElement(true);
        //isi Jenis Penggunaan Bangunan
        if(lkokBng.getJPB_runway().equalsIgnoreCase("yes"))
        {
            this.cekRunway.setSelected(true);
            this.enableKhususElement("Runway", true);
            
        }else if(lkokBng.getJPB_taxiway().equalsIgnoreCase("yes"))
        {
            this.cekTaxiway.setSelected(true);
            this.enableKhususElement("Taxiway", true);
            
        }else if(lkokBng.getJPB_apron().equalsIgnoreCase("yes"))
        {
            this.cekApron.setSelected(true);
            this.enableKhususElement("Apron", true);
            
        }else if(lkokBng.getJPB_inpeksiLbh4().equalsIgnoreCase("yes"))
        {
            this.cekInspeksiLbh4.setSelected(true);
            this.enableKhususElement("Inspeksi", true);
            
        }else if(lkokBng.getJPB_inpeksiKrg4().equalsIgnoreCase("yes"))
        {
            this.cekInspeksiKrg4.setSelected(true);
            this.enableKhususElement("Inspeksi", true);
        }
        
        //isi Konstruksi
        if(lkokBng.getKonstruksi().equalsIgnoreCase("Kaku"))
        {
            this.radioKaku.setSelected(true);
            
        }else if(lkokBng.getKonstruksi().equalsIgnoreCase("Lentur"))
        {
            this.radioLentur.setSelected(true);
            
        }else if(lkokBng.getKonstruksi().equalsIgnoreCase("Komposit"))
        {
            this.radioKomposit.setSelected(true);
        }else
        {
            this.radioLain.setSelected(true);
            this.txtKonstruksi.setText(lkokBng.getKonstruksi());
        }
        
        if(lkokBng.getKondUmum().equalsIgnoreCase("Sangat Baik"))
        {
            this.radioSangatBaik.setSelected(true);
        }else if(lkokBng.getKondUmum().equalsIgnoreCase("Baik"))
        {
            this.radioBaik.setSelected(true);
        }
        
        
        ArrayList <LkokBangunanKhususBandara> arrTemp = lkokBng.getArrLkokBng();
        
        for(int i = 0; i < arrTemp.size(); i++)
        {
            LkokBangunanKhususBandara lkok = arrTemp.get(i);
            
            if(lkok.getIdJpb().equalsIgnoreCase("01"))
            {
                this.RUNWAY_txtPanjang.setText(lkok.getPanjang()+"");
                this.RUNWAY_txtLebar.setText(lkok.getLebar()+"");
                this.RUNWAY_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.RUNWAY_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.RUNWAY_txtLuas.setText(lkok.getLuas()+"");
                
            }else if(lkok.getIdJpb().equalsIgnoreCase("02"))
            {
                this.APRON_txtPanjang.setText(lkok.getPanjang()+"");
                this.APRON_txtLebar.setText(lkok.getLebar()+"");
                this.APRON_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.APRON_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.APRON_txtLuas.setText(lkok.getLuas()+"");
                
            }else if(lkok.getIdJpb().equalsIgnoreCase("03"))
            {
                this.TAXIWAY_txtPanjang.setText(lkok.getPanjang()+"");
                this.TAXIWAY_txtLebar.setText(lkok.getLebar()+"");
                this.TAXIWAY_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.TAXIWAY_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.TAXIWAY_txtLuas.setText(lkok.getLuas()+"");
                
            }else if(lkok.getIdJpb().equalsIgnoreCase("04"))
            {
                this.INSPEKSI_txtPanjang.setText(lkok.getPanjang()+"");
                this.INSPEKSI_txtLebar.setText(lkok.getLebar()+"");
                this.INSPEKSI_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.INSPEKSI_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.INSPEKSI_txtLuas.setText(lkok.getLuas()+"");
                
            }else if(lkok.getIdJpb().equalsIgnoreCase("05"))
            {
                this.AKSES_txtPanjang.setText(lkok.getPanjang()+"");
                this.AKSES_txtLebar.setText(lkok.getLebar()+"");
                this.AKSES_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.AKSES_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.AKSES_txtLuas.setText(lkok.getLuas()+"");
                
            }else if(lkok.getIdJpb().equalsIgnoreCase("06"))
            {
                this.HELIPAD_txtPanjang.setText(lkok.getPanjang()+"");
                this.HELIPAD_txtLebar.setText(lkok.getLebar()+"");
                this.HELIPAD_txtLentur.setText(lkok.getPerkerasanLentur()+"");
                this.HELIPAD_txtKaku.setText(lkok.getPerkerasanKaku()+"");
                this.HELIPAD_txtLuas.setText(lkok.getLuas()+"");
                
            } 
            
        }
        
        
    
    
    }
    
    private void cekRunwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekRunwayActionPerformed
        // TODO add your handling code here:
        if(cekRunway.isSelected())
        {
            this.enableKhususElement("Runway", true);
            
        }else
        {
            this.enableKhususElement("Runway", false);
        }
    }//GEN-LAST:event_cekRunwayActionPerformed

    private void cekTaxiwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekTaxiwayActionPerformed
        // TODO add your handling code here:
        if(cekTaxiway.isSelected())
        {
            this.enableKhususElement("Taxiway", true);
            
        }else
        {
            this.enableKhususElement("Taxiway", false);
        }
    }//GEN-LAST:event_cekTaxiwayActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void cekApronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekApronActionPerformed
        // TODO add your handling code here:
        if(cekApron.isSelected())
        {
            this.enableKhususElement("Apron", true);
            
        }else
        {
            this.enableKhususElement("Apron", false);
        }
    }//GEN-LAST:event_cekApronActionPerformed

    private void cekInspeksiLbh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekInspeksiLbh4ActionPerformed
        // TODO add your handling code here:
        if(this.cekInspeksiLbh4.isSelected())
        {
            this.enableKhususElement("Inspeksi", true);
            
        }else
        {
            this.enableKhususElement("Inspeksi", false);
        }
    }//GEN-LAST:event_cekInspeksiLbh4ActionPerformed

    private void cekInspeksiKrg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekInspeksiKrg4ActionPerformed
        // TODO add your handling code here:
         if(this.cekInspeksiKrg4.isSelected())
        {
            this.enableKhususElement("Inspeksi", true);
            
        }else
        {
            this.enableKhususElement("Inspeksi", false);
        }
    }//GEN-LAST:event_cekInspeksiKrg4ActionPerformed

    private void radioLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLainActionPerformed
        // TODO add your handling code here:
        
       if(this.radioLain.isSelected())
       {
           this.txtKonstruksi.setEnabled(true);
           this.txtKonstruksi.requestFocus();
       }
    }//GEN-LAST:event_radioLainActionPerformed

    private void radioKompositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKompositActionPerformed
        // TODO add your handling code here:
       if(this.radioKomposit.isSelected())
       {
           this.txtKonstruksi.setEnabled(false);
       }
    }//GEN-LAST:event_radioKompositActionPerformed

    private void radioLenturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLenturActionPerformed
        // TODO add your handling code here:
         if(this.radioLentur.isSelected())
       {
           this.txtKonstruksi.setEnabled(false);
       }
    }//GEN-LAST:event_radioLenturActionPerformed

    private void radioKakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKakuActionPerformed
        // TODO add your handling code here:
        if(this.radioKaku.isSelected())
       {
           this.txtKonstruksi.setEnabled(false);
       }
    }//GEN-LAST:event_radioKakuActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AKSES_txtKaku;
    private javax.swing.JTextField AKSES_txtLebar;
    private javax.swing.JTextField AKSES_txtLentur;
    private javax.swing.JTextField AKSES_txtLuas;
    private javax.swing.JTextField AKSES_txtPanjang;
    private javax.swing.JTextField APRON_txtKaku;
    private javax.swing.JTextField APRON_txtLebar;
    private javax.swing.JTextField APRON_txtLentur;
    private javax.swing.JTextField APRON_txtLuas;
    private javax.swing.JTextField APRON_txtPanjang;
    private javax.swing.JTextField HELIPAD_txtKaku;
    private javax.swing.JTextField HELIPAD_txtLebar;
    private javax.swing.JTextField HELIPAD_txtLentur;
    private javax.swing.JTextField HELIPAD_txtLuas;
    private javax.swing.JTextField HELIPAD_txtPanjang;
    private javax.swing.JTextField INSPEKSI_txtKaku;
    private javax.swing.JTextField INSPEKSI_txtLebar;
    private javax.swing.JTextField INSPEKSI_txtLentur;
    private javax.swing.JTextField INSPEKSI_txtLuas;
    private javax.swing.JTextField INSPEKSI_txtPanjang;
    private javax.swing.JTextField RUNWAY_txtKaku;
    private javax.swing.JTextField RUNWAY_txtLebar;
    private javax.swing.JTextField RUNWAY_txtLentur;
    private javax.swing.JTextField RUNWAY_txtLuas;
    private javax.swing.JTextField RUNWAY_txtPanjang;
    private javax.swing.JTextField TAXIWAY_txtKaku;
    private javax.swing.JTextField TAXIWAY_txtLebar;
    private javax.swing.JTextField TAXIWAY_txtLentur;
    private javax.swing.JTextField TAXIWAY_txtLuas;
    private javax.swing.JTextField TAXIWAY_txtPanjang;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JCheckBox cekApron;
    private javax.swing.JCheckBox cekInspeksiKrg4;
    private javax.swing.JCheckBox cekInspeksiLbh4;
    private javax.swing.JCheckBox cekRunway;
    private javax.swing.JCheckBox cekTaxiway;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelStat;
    private javax.swing.JRadioButton radioBaik;
    private javax.swing.JRadioButton radioKaku;
    private javax.swing.JRadioButton radioKomposit;
    private javax.swing.JRadioButton radioLain;
    private javax.swing.JRadioButton radioLentur;
    private javax.swing.JRadioButton radioSangatBaik;
    private javax.swing.JTextField txtKonstruksi;
    private javax.swing.JFormattedTextField txtNop;
    private javax.swing.JTextField txtThnDibangun;
    private javax.swing.JTextField txtThnRenovasi;
    // End of variables declaration//GEN-END:variables
}
