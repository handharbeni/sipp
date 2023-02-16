/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.Dhkmf;
import id.co.meda.apit.visual.report.LaporanHargaKomponenMaterial;
import id.co.meda.apit.visual.report.TampilkanReportDhkmf;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Class ini untuk mengontrol sprosedur yang dilakukan
 * pada FrmDhkmf
 * @author PT. Databumi Indonesia
 */
public class ControlDhkmf {
    
    private JDialog tempDialog;
    public ArrayList <Dhkmf> arrDhkmf;
    private String kodeDhkmf;
    private String sql;
    private String thnDbkb;
    
    NumberFormat numFormat = NumberFormat.getInstance();
    /* Contructor Class 
     * @param kodeDhkm membedakan Fasilitas atau Material (F atau M)
     * @thnDbkb membedakan harga pada tahun tertent
     */
    public ControlDhkmf(String kodeDhkmf,String thnDbkb)
    {
       this.thnDbkb = thnDbkb;
        this.kodeDhkmf = kodeDhkmf;
        arrDhkmf = new ArrayList<Dhkmf>();
        sql = "select * from ref_dhkmf where kd_dhkm like '%"+kodeDhkmf+"%' and "
                + "thn_dhkm = '"+thnDbkb+"'";
        try{
        ResultSet result = DBFetching.getResultSet(sql);
        
            //Proses memasukkan data Dhkmf ke array
            while(result.next())
            {
               
                Dhkmf dhkmf = new Dhkmf();
                dhkmf.setKdDhkm(result.getString(1));
                dhkmf.setThnDhkm(result.getString(2));
                dhkmf.setNmDhkm(result.getString(3));
                dhkmf.setSatDhkm(result.getString(4));
                dhkmf.setHrgDhkm(Double.parseDouble(result.getString(5)));
                dhkmf.setHrgDhkmStr(numFormat.format(Double.parseDouble(result.getString(5))));
                arrDhkmf.add(dhkmf);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    /* Contructor Class 
     */
    public ControlDhkmf()
    {
         arrDhkmf = new ArrayList<Dhkmf>();
    }
    
    /*
     * method untuk mengisi Combo Box pilihan Tahun
     */
    public JComboBox getComboBoxItem(JComboBox tempCombo)
    {
        tempCombo.addItem("Pilih Tahun..");
        sql = "select distinct thn_dhkm from ref_dhkmf";
        ResultSet set = DBFetching.getResultSet(sql);
         
        
        try{
           while(set.next())
           {
               tempCombo.addItem(set.getString(1));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return tempCombo;
    }
    
    /* 
     * Method untuk Mengisi Table
     * @return DefaultTableModel  
     */
    public DefaultTableModel getTableModel()
    {
        
        Vector<String> header = new Vector<String>();
        header.add(0,"TahunDhkm");
        header.add(1,"NamaDhkm");
        header.add(2,"SatuanDhkm");
        header.add(3,"HargaDhkm");
        
        Vector<Vector> data = new Vector<Vector>();
      
        for(int i = 0; i < getArrDhkmf().size();i++)
        {
            String thn = (String)getArrDhkmf().get(i).getThnDhkm();
            
           
                Vector vecData = new Vector();
                vecData.add(thn);
                vecData.add(getArrDhkmf().get(i).getNmDhkm());
                vecData.add(getArrDhkmf().get(i).getSatDhkm());
                vecData.add(getArrDhkmf().get(i).getHrgDhkm());
                data.add(vecData);
        }
        
        //proses membuat model tabel
        DefaultTableModel tableDhkmf = new DefaultTableModel(data,header){
         
            @Override
            public boolean isCellEditable(int row, int Column)
            {
                if (Column == 3){return true;}
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int index)
            {
                switch(index)
                {
                    case 3: return Double.class; 
                    default: return String.class;    
                }
            }      
            
        };
        
        
        return tableDhkmf;
        
        
    }
    
    /* 
     * Method untuk mengambil data tabel yang baru
     * @return ArrayList<Dhkmf>
     * @param tableDhkmf untuk mengambil model tabel
     * @param arrDhkmf untuk menyimpan data dari tabel
     */
    public ArrayList<Dhkmf> ambilDataTabel(JTable tableDhkmf,ArrayList<Dhkmf> arrDhkmf)
    {
        int jmlhBaris = tableDhkmf.getRowCount();
        System.out.println(arrDhkmf.size());
        for(int i = 0; i < jmlhBaris; i++)
        {
            arrDhkmf.get(i).setHrgDhkm((Double)tableDhkmf.getValueAt(i,3));
        }
        
        return arrDhkmf;
    }
    
    /* 
     * Method untuk menyimpan data ke Database
     * @param arrDhkmf berisi data tabel yang baru
     */
    public void simpanKeDatabase(ArrayList<Dhkmf> arrDhkmf)
    {
        int opt = JOptionPane.showConfirmDialog(new JFrame(), "Anda yakin ingin menyimpan data ini?",
                "Simpan Data", JOptionPane.YES_NO_OPTION);
        if(opt == 0)
        {
            for(int i = 0; i < arrDhkmf.size();i++)
            {
                    
                String sql = "update ref_dhkmf set hrg_dhkm = "+arrDhkmf.get(i).getHrgDhkm()+" where"
                        + " kd_dhkm = '"+arrDhkmf.get(i).getKdDhkm()+"' and thn_dhkm = '"+arrDhkmf.get(i).getThnDhkm()+"'";
                System.out.println(sql);
                DBFetching.setComandToDB(sql);
            }
            
            JOptionPane.showMessageDialog(new JFrame(), "Data telah tersimpan", "Simpan Data", JOptionPane.INFORMATION_MESSAGE);
        }
     }
    
    public void cetakLaporan(String thnDbkb)
    {
        LaporanHargaKomponenMaterial laporan = new LaporanHargaKomponenMaterial();
        laporan.setArrDhkmf(this.getArrDhkmf());
        laporan.setTahun(thnDbkb);
        
        TampilkanReportDhkmf report = new TampilkanReportDhkmf(laporan);
        report.tampilReport();
    }
    
    /**
     * @return the arrDhkmf
     */
    public ArrayList <Dhkmf> getArrDhkmf() {
        return arrDhkmf;
    }

    /**
     * @param arrDhkmf the arrDhkmf to set
     */
    public void setArrDhkmf(ArrayList <Dhkmf> arrDhkmf) {
        this.arrDhkmf = arrDhkmf;
    }
    
    
}
