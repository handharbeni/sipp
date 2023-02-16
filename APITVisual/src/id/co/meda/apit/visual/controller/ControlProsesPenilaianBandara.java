/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.DataBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.LkokTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianBngKhususBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianBngPTBandaraDBKB;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianLspopBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.PenilaianTanahBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ProsesPenilaianBandara;
import id.co.meda.apit.enggine.penilaian.khusus.bandara.ToolsPenilaianBandara;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelSpopBumi;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.visual.report.TampilkanReportBandara;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlProsesPenilaianBandara {
    
    private DataBandara dataBandara;
    private double totalNjopTanah;
    private double totalNjopTanahPerM;
    private double totalNjopBngKhusus;
    private double totalNjopBngKhususPerM;
    private double totalNjopBngPTDbkb;
    private double totalNjopBngLspop;
    private ArrayList<PenilaianBngPTBandaraDBKB> tempBngBandara;
    
    private String namaBandara;        
            
    public boolean cekNOP(String nop)
    {
            String sql = "select count(*) from lkok_tanah_bandara where nop='"+nop+"'";
            int jmlh = DBFetching.getIntegerResult(sql);
            
            if(jmlh > 0)
            {
                dataBandara = ToolsPenilaianBandara.getModelDataBandara(nop);
                namaBandara = dataBandara.getTanahBandara().getNamaBandara();
                return jmlh > 0;
            }else
            {
               return jmlh > 0;
            }
    }
    
      public void isiCbTahun(JComboBox cbAll) {
        cbAll.removeAllItems();
        cbAll.addItem("Pilih tahun..");
        ResultSet rs = DBFetching.getResultSet("select distinct thn_dhkm from ref_dhkmf order by thn_dhkm desc");
        try {
            while (rs.next()) {
                cbAll.addItem(rs.getString(1));
            }
        } catch (Exception e) {}
    }
    
    
    public DefaultTableModel getModelTanah(String nop,String tahun)
    {
        DefaultTableModel model = null;
        
        Vector <String> header = new Vector <String>(); 
        header.add(0,"Jenis Penggunaan Tanah");
        header.add(1,"Luas");
        header.add(2,"NIR");
        header.add(3,"Nilai/M2");
        header.add(4,"Nilai Total");
        
        Vector <Vector> data = new Vector<Vector>();
        if(nop.equalsIgnoreCase("") || tahun.equalsIgnoreCase(""))
       {
           model = new DefaultTableModel(null,header);
       }else
       {
           ArrayList<PenilaianTanahBandara> arrPenilTanah = 
                   ToolsPenilaianBandara.getPenilTanahBandara(nop, tahun);
           
           for(int i = 0; i < arrPenilTanah.size();i++)
           {
               
               Vector vec = new Vector();
               vec.add(arrPenilTanah.get(i).getJnsPenggunaanTanah());
               vec.add(arrPenilTanah.get(i).getLuas());
               
               vec.add(arrPenilTanah.get(i).getNir());
               vec.add(arrPenilTanah.get(i).getNilPerM());
               vec.add(arrPenilTanah.get(i).getNilTotal());
               data.add(vec);
           }
           
        
        model = new DefaultTableModel(data,header){                

            @Override
                public Class<?> getColumnClass(int index)
                {
                    switch(index)
                    {
                        case 0 : return String.class;
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
    
     public DefaultTableModel getModelBngKhusus(String nop,String tahun)
    {
        DefaultTableModel model = null;
        
        Vector <String> header = new Vector <String>(); 
        header.add(0,"Jenis Penggunaan Bangunan");
        header.add(1,"Luas");
        header.add(2,"Nilai/M2");
        header.add(3,"Nilai Total");
        
        Vector <Vector> data = new Vector<Vector>();
        if(nop.equalsIgnoreCase("") || tahun.equalsIgnoreCase(""))
       {
           model = new DefaultTableModel(null,header);
       }else
       {
           ArrayList<PenilaianBngKhususBandara> arrBngKhusus = 
                   ToolsPenilaianBandara.getPenilBngKhususBandara(nop, tahun);
           
           for(int i = 0; i < arrBngKhusus.size();i++)
           {
               
               Vector vec = new Vector();
               vec.add(arrBngKhusus.get(i).getJpb());
               vec.add(arrBngKhusus.get(i).getLuas());
               vec.add(arrBngKhusus.get(i).getNilPerM2());
               vec.add(arrBngKhusus.get(i).getNilTotal());
               data.add(vec);
           }
           
        
        model = new DefaultTableModel(data,header){                

            @Override
                public Class<?> getColumnClass(int index)
                {
                    switch(index)
                    {
                        case 0 : return String.class;
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
     
     public DefaultTableModel getModelPTDBKB(String nop, String tahun)
     {
       DefaultTableModel model = null;
             

       Vector <String> header  = new Vector<String>();
       header.add("Jenis Bangunan");
       header.add("Luas");
       header.add("Nilai Bangunan /M2");
       header.add("NJOP Bangunan /M2");
       header.add("Nilai Keseluruhan");
       
       Vector<Vector> data = new Vector<Vector>();
       
        if(nop.equalsIgnoreCase("") || tahun.equalsIgnoreCase(""))
       {
           model = new DefaultTableModel(null,header);
       }else{
          
            ArrayList <LspopNonStandar> lspopNonStdArr = new ArrayList <LspopNonStandar>();
             ArrayList <NilaiBangunan> nilaiBngArr = new ArrayList <NilaiBangunan>();
             
             ToolsPenilaian.ambilLspopFromDbPerNop(nop, lspopNonStdArr);
             nilaiBngArr = ToolsPenilaian.ambilNilBngFromDB(tahun, nop);
             
             this.tempBngBandara =  
                     ToolsPenilaianBandara.getPenilBngPTDBKBBandara(nop, tahun);
            
            
        for(int i = 0; i < tempBngBandara.size();i++)
        {
            Vector vec = new Vector();
            vec.add(tempBngBandara.get(i).getJpb());
            vec.add(tempBngBandara.get(i).getLuas());

            double nilBngPerM = tempBngBandara.get(i).getNilai_bangunan()/tempBngBandara.get(i).getLuas();

            vec.add(nilBngPerM);
            vec.add(tempBngBandara.get(i).getNilai_njop());

            double nilTotal = tempBngBandara.get(i).getNilai_njop()*tempBngBandara.get(i).getLuas();
            vec.add(nilTotal);
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
                     default: return false;
                    }
                }

            };
        }    
       return model;
   
    }
    
     public DefaultTableModel getModelLspopBandara(String nop,String tahun)
     {
       DefaultTableModel model = null;
       
       Vector <String> header  = new Vector<String>();
       header.add("no_bng");
       header.add("Jenis Penggunaan Bangunan");
       header.add("luas");
       header.add("Nilai Per M2");
       header.add("Nilai Total");
       
       Vector<Vector> data = new Vector<Vector>();
       
       if(nop.equalsIgnoreCase("") && tahun.equalsIgnoreCase(""))
       {
           model = new DefaultTableModel(null,header);
       }else{
           
           ArrayList<PenilaianLspopBandara> arrPenil = ToolsPenilaianBandara.getPenilLspopBandara(nop,tahun);
           
           for(int i = 0; i < arrPenil.size(); i++)
           {
               Vector vec = new Vector();
               vec.add(arrPenil.get(i).getLspop().getNoBng()+"");
               vec.add(arrPenil.get(i).getLspop().getJpb());
               vec.add(arrPenil.get(i).getLspop().getLuas());
               vec.add(arrPenil.get(i).getNilaiPerM());
               vec.add(arrPenil.get(i).getNilaiTotal());
               
               data.add(vec);
           }
           
           model = new DefaultTableModel(data,header){                

            @Override
                public Class<?> getColumnClass(int index)
                {
                 switch(index)
                 {
                     case 1: return String.class;    
                     default: return Double.class;  

                 }
                }
                
                 @Override
                public boolean isCellEditable(int row,int column)
                {
                    switch(column)
                    {
                        case 3 : return true;   
                     default: return false;
                    }
                }

            };
       
       }
       
       return model;
     }
     
     
     
    public void nilaiTanah(String nop, String tahun, double nir,double luas,String jp_tanah)
    {
        ProsesPenilaianBandara.prosesNjopTanah(nop, tahun, nir, luas, jp_tanah);
    }
    
    public void nilaiBngKhusus(String nop, String tahun, double nilPerM2, double luas, String jpb)
    {
        ProsesPenilaianBandara.prosesNjopBngKhusus(nop, tahun, nilPerM2, luas, jpb);
    }
    
    public void nilaiBngPTDbkb(String nop, String tahun)
    {
        
        for(int i = 0 ; i < tempBngBandara.size();i++)
        {
            PenilaianBngPTBandaraDBKB tempBng = tempBngBandara.get(i);
            
            ProsesPenilaianBandara.prosesNjopBngPTDbkb(nop, tahun, 
                    tempBng.getJpb(), tempBng.getLuas());
        }
    }
    
    public void nilaiLspopBandara(String nop, String tahun, int no_bng, double nilPerM, double luas)
    {
         ProsesPenilaianBandara.prosesNjopLspop(nop, tahun, no_bng, nilPerM, luas);
    }

    private void prosesNjopTanah(String nop,String tahun)
    {
        totalNjopTanah = 0;
        totalNjopTanahPerM = 0;
        ArrayList<PenilaianTanahBandara> arrTanah = ToolsPenilaianBandara.getPenilTanahBandara(nop, tahun);
        double tempLuas = 0;
        
        for(int i = 0; i < arrTanah.size(); i++)
        {
            totalNjopTanah += arrTanah.get(i).getNilTotal();
            tempLuas += arrTanah.get(i).getLuas();
        }
        
        totalNjopTanahPerM = totalNjopTanah/tempLuas;
    }
    
    private void prosesNjopBngKhusus(String nop,String tahun)
    {
        totalNjopBngKhusus = 0;
        totalNjopBngKhususPerM = 0;
        ArrayList<PenilaianBngKhususBandara> arrBng = ToolsPenilaianBandara.getPenilBngKhususBandara(nop, tahun);
        double tempLuas = 0;
        
        for(int i = 0; i < arrBng.size(); i++)
        {
            totalNjopBngKhusus += arrBng.get(i).getNilTotal();
            tempLuas += arrBng.get(i).getLuas();
        }
        
        totalNjopBngKhususPerM = totalNjopBngKhusus/tempLuas;
        
    }
    
    private void prosesNjopBngDbkb(String nop, String tahun)
    {
        ArrayList<PenilaianBngPTBandaraDBKB> penilBng = new ArrayList<PenilaianBngPTBandaraDBKB>();
        penilBng = ToolsPenilaianBandara.getPenilBngPTDBKBBandara(nop, tahun);
        
        this.totalNjopBngPTDbkb = 0;
       
        for(int i = 0; i < penilBng.size(); i++)
        {
            this.totalNjopBngPTDbkb += (penilBng.get(i).getNilai_njop()*tempBngBandara.get(i).getLuas());
        }
    }
    
    private void prosesNjopLspop(String nop, String tahun)
    {
        ArrayList<PenilaianLspopBandara> arrLspop = ToolsPenilaianBandara.getPenilLspopBandara(nop,tahun);
        
        this.totalNjopBngLspop = 0;
        
        for(int i = 0; i < arrLspop.size();i++)
        {
            this.totalNjopBngLspop += arrLspop.get(i).getNilaiTotal();
        }
    }
    
    public double getTotalNjopLspop(String nop, String tahun)
    {
        prosesNjopLspop(nop,tahun);
        return totalNjopBngLspop;
    }
    
    /**
     * @return the totalNjopTanah
     */
    public double getTotalNjopTanah(String nop, String tahun) {
        prosesNjopTanah(nop,tahun);
        return totalNjopTanah;
    }

    /**
     * @return the totalNjopTanahPerM
     */
    public double getTotalNjopTanahPerM() {
        return totalNjopTanahPerM;
    }

    /**
     * @return the namaBandara
     */
    public String getNamaBandara() {
        return namaBandara;
    }

    /**
     * @return the totalNjopBngKhusus
     */
    public double getTotalNjopBngKhusus(String nop, String tahun) {
        prosesNjopBngKhusus(nop,tahun);
        return totalNjopBngKhusus;
    }

   
    /**
     * @return the totalNjopBngKhususPerM
     */
    public double getTotalNjopBngKhususPerM() {
        return totalNjopBngKhususPerM;
    }

    /**
     * @return the totalNjopBngPTDbkb
     */
    public double getTotalNjopBngPTDbkb(String nop,String tahun) {
        prosesNjopBngDbkb(nop,tahun);
        return totalNjopBngPTDbkb;
    }

 
    public void tampilReport(String nop, String tahun,String njopTanah, String njopBngKhusus, String njopBngPTDbkb, String njopBngLspop, String njopBandara)
    {
        TampilkanReportBandara reportBandara = new TampilkanReportBandara(nop,tahun);
        reportBandara.isiRingkasan(njopTanah, njopBngKhusus, njopBngPTDbkb, njopTanah, njopBandara);
        reportBandara.tampilkanReportBandara();
    }
    
}
