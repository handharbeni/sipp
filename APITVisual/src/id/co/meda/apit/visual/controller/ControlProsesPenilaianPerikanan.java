/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.BuatModelPendapatanPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.BuatModelPendataan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.HasilPenilaianPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.DataPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.NilaiBangunanIkan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.NilaiTanahIkan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopBumi;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.NilaiPendapatanIkan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ProsesPenilaianPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ToolsPenilaianIkan;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.visual.report.TampilkanReport;
import id.co.meda.apit.visual.report.TampilkanReportIkanBangunan;
import id.co.meda.apit.visual.report.TampilkanReportIkanPendapatan;
import id.co.meda.apit.visual.report.TampilkanReportIkanRingkas;
import id.co.meda.apit.visual.report.TampilkanReportIkanTanah;
import id.co.meda.apit.visual.report.TampilkanReportPenilBngIkan;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlProsesPenilaianPerikanan {
    private ArrayList <NilaiTanahIkan> bumiArr = new ArrayList <NilaiTanahIkan>();
    private NilaiBangunanIkan bangunanIkan= new NilaiBangunanIkan();
    private ArrayList <LspopNonStandar> lspopNonStdArr = new ArrayList <LspopNonStandar>();
    private ArrayList <NilaiBangunan> nilaiBngArr = new ArrayList <NilaiBangunan>();
    private ArrayList <NilaiPendapatanIkan> nilaiIkanArr = new ArrayList<NilaiPendapatanIkan>();
    
    private DataPerikanan pendataan = new DataPerikanan(); 
    private ProsesPenilaianPerikanan ikan = new ProsesPenilaianPerikanan();
    private String nop;
    
    private double njopTanah;
    private double njopBangunan;
    private double njopPerikanan;
    
    //untuk ambil nilai NJOP dari table
    public void prosesNjop(String nop,String tahun)
    {
        ikan.ambilNjop(nop, tahun);
        setNjopTanah(ikan.getNjopTanah());
        setNjopBangunan(ikan.getNjopBangunan());
        setNjopPerikanan(ikan.getNjopPerikanan());
    }
    
    //digunakan untuk mengquery objek-objek yang dibutuhkan
    public void buatModel(String nop,String tahun)
    {
        //untuk data
        
        pendataan = ToolsPenilaianIkan.getPendataan(nop);
        
        
        //untuk penilaian bumi
       bumiArr = ToolsPenilaianIkan.getArrNilaiTanahIkan(nop, tahun, pendataan);
        
        //untuk penilaian bangunan
        lspopNonStdArr.clear();
        ToolsPenilaian.ambilLspopFromDbPerNop(nop, lspopNonStdArr);
        bangunanIkan = ToolsPenilaianIkan.getNilaiBangunanIkan(nop, tahun, nilaiBngArr);
        
        //untuk buat model nilai pendapatan ikan
        this.nilaiIkanArr.clear();
        this.nilaiIkanArr.add(ToolsPenilaianIkan.getNilaiPendapatanIkan(nop, tahun, "01"));//untuk budidaya
        this.nilaiIkanArr.add(ToolsPenilaianIkan.getNilaiPendapatanIkan(nop, tahun, "02"));//untuk penangkapan
    }
   
   public DefaultTableModel getModelTableTanah(String nop,String tahun)
   {
       
       DefaultTableModel model = null;
       
       Vector<String> header  = new Vector<String>();
       header.add(0,"Peruntukan Objek");
       header.add(1,"Luas");
       header.add(2,"NIR");
       header.add(3,"Kelas");
       header.add(4,"Nilai Per M2");
       header.add(5,"Nilai Keseluruhan");
       header.add(6,"");
       
       
       Vector<Vector> data = new Vector();
    
       if(nop.equalsIgnoreCase("") || tahun.equalsIgnoreCase(""))
       {
           model = new DefaultTableModel(null,header);
       }else
       {
        int sizeArray = pendataan.getSpopIkan().getSpopBumi().size();

        for(int i = 0; i < sizeArray;i++)
        {
                 ModelSpopBumi tempSpop = pendataan.getSpopIkan().getSpopBumi().get(i);    

                 Vector vec = new Vector();
                 vec.add(tempSpop.getPeruntukan());
                 vec.add(tempSpop.getLuas());
                 vec.add(bumiArr.get(i).getNir());
                 vec.add(bumiArr.get(i).getKelasTanah());
                 vec.add(bumiArr.get(i).getNilaiPerm2());
                 vec.add(bumiArr.get(i).getNilaiKeseluruhan());
                 vec.add(tempSpop.getKode());
                 data.add(vec);
        }
        model = new DefaultTableModel(data,header){                

            @Override
                public Class<?> getColumnClass(int index)
                {
                 switch(index)
                 {
                     case 3: return String.class;
                     case 0: return String.class;    
                     default: return Double.class;  

                 }
                }

                @Override
                public boolean isCellEditable(int row,int column)
                {
                    switch(column)
                    {
                     case 2: return true;
                     default: return false;
                    }
                }
            };
       }
       
       return model;
   }
   
   /*
   * Method yang dibuat untuk mengembalikan vector data table tanah
   */
  
   public DefaultTableModel getModelTableBangunan(String nop,String tahun)
   {
       DefaultTableModel model = null;
       
       Vector <String> header  = new Vector<String>();
       header.add("Jenis Bangunan");
       header.add("Luas");
       header.add("Nilai Bangunan");
       
       
       Vector<Vector> data = new Vector<Vector>();
       
       for(int i = 0; i < lspopNonStdArr.size();i++)
       {
           LspopNonStandar tempLspop = lspopNonStdArr.get(i);
           
           
           Vector vec = new Vector();
           //isian lspop non std (Jns Bangunan dan luas)
           vec.add(tempLspop.getJpb());
           if(bangunanIkan.getNilaiBangunanLspop().size() > 0)
           {
           vec.add(bangunanIkan.getNilaiBangunanLspop().get(i).getLuasBng());
           vec.add(bangunanIkan.getNilaiBangunanLspop().get(i).getNilaiBangunan());
           }
           /*
           //isian dari nilai Bangunan Ikan
           if( bangunanIkan.size() > 0 && i < bangunanIkan.size())
           {
               double tempNilai = bangunanIkan.get(i).getNilaiBangunanLspop().getNilaiBangunan();
              vec.add(tempNilai);
           /*
              vec.add(bangunanIkanArr.get(i).getKelasBangunan());
               vec.add(bangunanIkanArr.get(i).getNjopPerM2());
               vec.add(bangunanIkanArr.get(i).getNilaiKeseluruhan());
           
            }else
           {
               vec.add(0);
               vec.add("-");
               vec.add(0);
               vec.add(0);
           }
           */
           
           data.add(vec);
           
       }
      
       model =  model = new DefaultTableModel(data,header){                
               
           @Override
               public Class<?> getColumnClass(int index)
               {
                switch(index)
                {
                    case 3: return String.class;
                    case 0: return String.class;    
                    default: return Double.class;  
                        
                }
               }
               
           };
       
       return model;
   }
   
   
    public DefaultTableModel getModelTablePerikanan(String nop,String tahun)
   {
       DefaultTableModel model = null;
       
       Vector <String> header  = new Vector<String>();
       header.add("Jenis Usaha");
       header.add("Hasil Produksi");
       header.add("Harga Pasar /ton");
       header.add("Biaya Operasional");
       header.add("Hasil Bersih");
       header.add("Nilai Keseluruhan");
       
       Vector <Vector> data = new Vector<Vector>();
       
       for(int i = 0; i < nilaiIkanArr.size(); i++)
       {
           Vector vec = new Vector();
           
           vec.add(nilaiIkanArr.get(i).getJenis());
           vec.add(nilaiIkanArr.get(i).getHasilProduksi());
           vec.add(nilaiIkanArr.get(i).getHargaPasar());
           vec.add(nilaiIkanArr.get(i).getBiayaOperasional());
           vec.add(nilaiIkanArr.get(i).getHasilBersih());
           vec.add(nilaiIkanArr.get(i).getNilaiKeseluruhan());
           data.add(vec);
       }
           
       model = new DefaultTableModel(data,header){                

            @Override
                public Class<?> getColumnClass(int index)
                {
                 switch(index)
                 {
                    case 0: return String.class;    
                     default: return Double.class;  

                 }
                }

                @Override
                public boolean isCellEditable(int row,int column)
                {
                    switch(column)
                    {
                     case 3: return true;
                     default: return false;
                    }
                }
                
                
            };
       
       return model;
   }
  
   
    public void penilaianTanah(String nop,String tahun,String kdPeruntukan,double luas,double nir)
    {
        //nilai dan refresh table untuk penilaian bumi
        for(int i = 0; i < bumiArr.size();i++)
        {
            if(bumiArr.get(i).getNop().equalsIgnoreCase(nop) && bumiArr.get(i).getTahun().equalsIgnoreCase(tahun) && 
                    bumiArr.get(i).getKode_peruntukan().equalsIgnoreCase(kdPeruntukan))
            {
                ikan.prosesNilaiTanah(nop, tahun, kdPeruntukan, luas, nir,bumiArr.get(i));
                ikan.prosesNilaiNJOP(nop,tahun);
                
            }
            
        }
        
    }
    
    public void penilaianBangunan(String nop,String tahun)
    {
        this.bangunanIkan = ikan.prosesPenilaianBangunan(nop,tahun,bangunanIkan);
        
    }
    
    public void penilaianPendapatanIkan(String jenis,double biayaOperasional)
    {
        if(jenis.equalsIgnoreCase("pembudidayaan"))
        {
            nilaiIkanArr.get(0).setBiayaOperasional(biayaOperasional);
            ikan.prosesNilaiPendapatanIkan(nilaiIkanArr.get(0));
        }else
        {
            nilaiIkanArr.get(1).setBiayaOperasional(biayaOperasional);
            ikan.prosesNilaiPendapatanIkan(nilaiIkanArr.get(1));
        }
        
        
    }
    
    
    public void cetakReportTanah(String tahun)
    {
         HasilPenilaianPerikanan penilaianIkan = new HasilPenilaianPerikanan();
         penilaianIkan.setBangunanIkan(bangunanIkan);
         penilaianIkan.setArrPendapatanIkan(nilaiIkanArr);
         penilaianIkan.setArrTanahIkan(bumiArr);
         penilaianIkan.setNjopBangunan(njopBangunan);
         penilaianIkan.setNjopPerikanan(njopPerikanan);
         penilaianIkan.setNjopTanah(njopTanah);
         penilaianIkan.setNop(nop);
         penilaianIkan.setTahun(tahun);
         
         TampilkanReportIkanTanah report = new TampilkanReportIkanTanah(penilaianIkan,this.pendataan);
         report.tampilkanReportTanah();
         
    }
    
     public void cetakReportPendapatan(String tahun)
    {
         HasilPenilaianPerikanan penilaianIkan = new HasilPenilaianPerikanan();
         penilaianIkan.setBangunanIkan(bangunanIkan);
         penilaianIkan.setArrPendapatanIkan(nilaiIkanArr);
         penilaianIkan.setArrTanahIkan(bumiArr);
         penilaianIkan.setNjopBangunan(njopBangunan);
         penilaianIkan.setNjopPerikanan(njopPerikanan);
         penilaianIkan.setNjopTanah(njopTanah);
         penilaianIkan.setNop(nop);
         penilaianIkan.setTahun(tahun);
         
         TampilkanReportIkanPendapatan report = new TampilkanReportIkanPendapatan(penilaianIkan,this.pendataan);
         report.tampilkanReportPendapatan();
         
    }
     
      public void cetakReportRingkasan(String tahun)
    {
         HasilPenilaianPerikanan penilaianIkan = new HasilPenilaianPerikanan();
         penilaianIkan.setBangunanIkan(bangunanIkan);
         penilaianIkan.setArrPendapatanIkan(nilaiIkanArr);
         penilaianIkan.setArrTanahIkan(bumiArr);
         penilaianIkan.setNjopBangunan(njopBangunan);
         penilaianIkan.setNjopPerikanan(njopPerikanan);
         penilaianIkan.setNjopTanah(njopTanah);
         penilaianIkan.setNop(nop);
         penilaianIkan.setTahun(tahun);
         
         TampilkanReportIkanRingkas report = new TampilkanReportIkanRingkas(penilaianIkan,this.pendataan);
         report.tampilkanReportRingkasan();
         
    }
      
    public void cetakReportBangunanNilai(String tahun)
    {
         HasilPenilaianPerikanan penilaianIkan = new HasilPenilaianPerikanan();
         penilaianIkan.setBangunanIkan(bangunanIkan);
         penilaianIkan.setArrPendapatanIkan(nilaiIkanArr);
         penilaianIkan.setArrTanahIkan(bumiArr);
         penilaianIkan.setNjopBangunan(njopBangunan);
         penilaianIkan.setNjopPerikanan(njopPerikanan);
         penilaianIkan.setNjopTanah(njopTanah);
         penilaianIkan.setNop(nop);
         penilaianIkan.setTahun(tahun);
         
         
        TampilkanReportPenilBngIkan reportBangunan = new TampilkanReportPenilBngIkan(pendataan.getSpopIkan().getSpop(),
                penilaianIkan.getBangunanIkan().getNilaiBangunanLspop());
        reportBangunan.tampilReport();
    }
    
    public void cetakReportBangunanNjop(String tahun)
    {
         HasilPenilaianPerikanan penilaianIkan = new HasilPenilaianPerikanan();
         penilaianIkan.setBangunanIkan(bangunanIkan);
         penilaianIkan.setArrPendapatanIkan(nilaiIkanArr);
         penilaianIkan.setArrTanahIkan(bumiArr);
         penilaianIkan.setNjopBangunan(njopBangunan);
         penilaianIkan.setNjopPerikanan(njopPerikanan);
         penilaianIkan.setNjopTanah(njopTanah);
         penilaianIkan.setNop(nop);
         penilaianIkan.setTahun(tahun);
         
        
        TampilkanReportIkanBangunan report = new TampilkanReportIkanBangunan(penilaianIkan,this.pendataan);
        report.tampilkanReportBangunan();
    }
      
    
    
   
    public void isiCombo(JComboBox cbAll) {
        cbAll.removeAllItems();
        cbAll.addItem("Pilih tahun..");
        ResultSet rs = DBFetching.getResultSet("select distinct thn_dhkm from ref_dhkmf order by thn_dhkm desc");
        try {
            while (rs.next()) {
                cbAll.addItem(rs.getString(1));
            }
        } catch (Exception e) {}
    }
    
    
    public double getTotalNJop()
    {
     return getNjopTanah() + getNjopBangunan() + getNjopPerikanan();
    }

    /**
     * @return the njopTanah
     */
    public double getNjopTanah() {
        njopTanah = ToolsPenilaianIkan.getTotalNjopTanah(bumiArr);
        return njopTanah;
    }

    /**
     * @return the njopBumi
     */
    public double getNjopPerikanan() {
        njopPerikanan = ToolsPenilaianIkan.getTotalNjopPendapatan(nilaiIkanArr);
        return njopPerikanan;
    }

    /**
     * @return the njopBangunan
     */
    public double getNjopBangunan() {
        njopBangunan = bangunanIkan.getNjopPerM2();
        return njopBangunan;
    }

    /**
     * @param njopTanah the njopTanah to set
     */
    public void setNjopTanah(double njopTanah) {
        njopTanah = ToolsPenilaianIkan.getTotalNjopTanah(bumiArr)
;        this.njopTanah = njopTanah;
    }

    /**
     * @param njopBangunan the njopBangunan to set
     */
    public void setNjopBangunan(double njopBangunan) {
        this.njopBangunan = njopBangunan;
    }

    /**
     * @param njopPerikanan the njopPerikanan to set
     */
    public void setNjopPerikanan(double njopPerikanan) {
        this.njopPerikanan = njopPerikanan;
    }

    /**
     * @return the pendataan
     */
    public DataPerikanan getPendataan() {
        return pendataan;
    }
    
    public double getTotalLuasBangunan()
    {
        return bangunanIkan.getLuasTotal();
    }
    
    public double getTotalNilai()
    {
        return bangunanIkan.getNilaiTotal();
    }
    
    public String getKelas()
    {
        return bangunanIkan.getKelasBangunan();
    }
    
    public double getNilaiPerM2()
    {
        return bangunanIkan.getNilaiPerM2();
    }
    
    public double getNjopPerM2()
    {
        return bangunanIkan.getNjopPerM2();
    }
    
    public double getNilaiKeseluruhan()
    {
        return bangunanIkan.getNilaiKeseluruhan();
    }
    
}
