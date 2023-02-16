/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini untuk memproses perhitungan Harga Satuan Komponen Utama (HSKU)
 * @author I Putu Medagia A
 */
public class HSKU {
    
    private String tahunDBKB;
    
    /**
     * Constructor class HSKU
     * @param tahunDBKB untuk menginisiasi tahun perhitungan yang digunakan
     */
    public HSKU(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }

    
    /**
     * method untuk  menghitung harga satuan
     */
    public void prosesHargaSatuan() 
    {  
        ArrayList<Double> vol = new ArrayList<Double>();
        ArrayList<String> kd = new ArrayList<String>();
        ArrayList<String> kdDhkm = new ArrayList<String>();
        
        //Mengambil data dari table pros_hsku untuk digunakan dalam proses penghitungan
        try{
            ResultSet result = DBFetching.getResultSet("select * from pros_hsku "
                    + "where convert(right(kd_hsku,2),signed) > 0 and tahun = '"+tahunDBKB+"'");
            while(result.next())
            {
                vol.add(Double.parseDouble(result.getString("vol_hsku"))); //mengambil data dari kolom vol_hsku
                kd.add(result.getString("kd_hsku")); //mengambil data dari kolom kd_hsku
                kdDhkm.add(result.getString("kd_dhkm"));//mengambil data dari kolom kd_dhkm
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKU", 
                    "Error D251", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
        }
        
        //proses penghitungan menggunakan data yang telah diambil sebelumnya
        try{
            for(int i = 0; i < kd.size(); i++)
            {
                String sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = '" + kdDhkm.get(i)
                        + "' and thn_dhkm like '%" +tahunDBKB+ "%'";
                double temp = DBFetching.getDoubleResult(sql);
                temp *= vol.get(i); 
                
                //proses update harga satuan database table pros_hsku
                DBFetching.setComandToDB("update pros_hsku set hrg_sat ="+ temp 
                        +" where kd_hsku ='" 
                       + kd.get(i)+"'  and tahun = '"+tahunDBKB+"'");  
                
                if(kd.get(i).equalsIgnoreCase("A020003") || kd.get(i).equalsIgnoreCase("B120003"))
                {
                    sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = '" + kdDhkm.get(i-1)
                        + "' and thn_dhkm like '%" +tahunDBKB+ "%'";
                   double temp1 = DBFetching.getDoubleResult(sql);
                   sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = '" + kdDhkm.get(i-2)
                        + "' and thn_dhkm like '%" +tahunDBKB+ "%'";
                    double temp2 = DBFetching.getDoubleResult(sql);
                    temp = (temp1+temp2)*vol.get(i); 
                
                    //proses update harga satuan database table pros_hsku
                    DBFetching.setComandToDB("update pros_hsku set hrg_sat ="+ temp 
                        +" where kd_hsku ='" 
                       + kd.get(i)+"'  and tahun = '"+tahunDBKB+"'");
                }
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga satuan pada penghitungan HSKU", 
                    "Error D252", JOptionPane.ERROR_MESSAGE);
            DBFetching.RollBackDB();
        }
        
        String sql = "select substr(kd_hsku,1,5) as kd_hsku, sum(hrg_sat) as hrg_sat from pros_hsku where substr(kd_hsku,1,5) in \n"+
        "(SELECT distinct substr(kd_hsku,1,5) FROM pros_hsku where convert(substr(kd_hsku,4,2),signed) > 0) "
                + "and convert(right(kd_hsku,2),signed) > 0 and tahun = '"+tahunDBKB+"' group by substr(kd_hsku,1,5)";
        
        ArrayList <String>idPerGroup = DBFetching.getArrayListStringResult(sql,1);
        ArrayList <Double>hrgTotPerGroup = DBFetching.getArrayListDoubleResult(sql,2);
        
        sql =   "select sum(hrg_sat) as hrg_upah from pros_hsku where substr(kd_hsku,1,5) in"
                +"(SELECT distinct substr(kd_hsku,1,5) FROM pros_hsku where convert(substr(kd_hsku,4,2),signed) > 0)" 
                +"and convert(right(kd_hsku,2),signed) > 0 and kd_dhkm like '%M01%' and tahun = '"+tahunDBKB+"' group by substr(kd_hsku,1,5)";
        
        ArrayList<Double> upahGroup = DBFetching.getArrayListDoubleResult(sql,1);
        
        for(int i = 0; i < idPerGroup.size();i++)
        {
            double hargaKomp = hrgTotPerGroup.get(i) - upahGroup.get(i);
            double hargaUpah =+  upahGroup.get(i);
            double hargaTotal = hrgTotPerGroup.get(i);
            String kd_hsku = idPerGroup.get(i);
            
            sql = "update pros_hsku set "
                  + "hrg_komp = "+hargaKomp+","
                  + "hrg_upah = "+hargaUpah+","
                  + "hrg_tot = "+hargaTotal+""
                  + " where kd_hsku like '%"+kd_hsku+"00%' and tahun = "+this.tahunDBKB;
            
            
            DBFetching.setComandToDB(sql);
            
            
        }
        
    }
    
    /**
     * method untuk menghitung harga komponen
     * @param codeHuruf untuk input key/kode dari table pros_hsku hurufnya saja
     * @param code untuk input key/kode dari table pros_hsku
     * @param column untuk input nomor kolom dari tabel pros_hsku
     */
    public void prosesHargaKomp(String codeHuruf,String code, String column)
    {
       ArrayList<Double> hargaKomp = new ArrayList<Double>();
       
       //mengambil data pada kolom harga_sat dari tabel pros_hsku 
       try{
            String sql =  "select hrg_sat from pros_hsku where kd_hsku like '%"
                    +code+"%' and kd_dhkm not like '%M01%' and tahun = '"+tahunDBKB+"'";
            
             
            
            ResultSet result = DBFetching.getResultSet(sql);

            while(result.next())
            {
                hargaKomp.add(Double.parseDouble(result.getString(column)));
            }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKU", 
                    "Error D253", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
       }
       
       //proses menghitung dan update kolom hargaKomp pada table pros_hsku
       try{
            double sum = 0;
            for (int i = 0; i<hargaKomp.size(); i++)
            {
                sum += hargaKomp.get(i);
            }

            DBFetching.setComandToDB("update pros_hsku set hrg_komp ="+sum+"where kd_hsku "
                    + "like '%" +code+"00%'and kd_hsku like '%"+codeHuruf+"%' and tahun = '"+tahunDBKB+"'" );
            
            
           
            
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga komponen pada perhitungan HSKU", 
                    "Error D254", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
       }
    }
    
    /**
     * method untuk menghitung harga upah
     * @param codeHuruf untuk input key/kode dari table pros_hsku hurufnya saja
     * @param code untuk input key/kode dari table pros_hsku
     * @param column untuk input nomor kolom dari tabel pros_hsku
     */
    public void prosesHargaUpah(String codeHuruf,String code, String column)
    {
       ArrayList<Double> hrgKomp = new ArrayList<Double>();
       
       //mengambil data dari kolom hrg_sat pada tabel pros_hsku
       try{ 
            String sql =  "select hrg_sat from pros_hsku where kd_hsku like '%"
                    +code+"%' and kd_dhkm like '%M01%' and tahun = '"+tahunDBKB+"'"; 

            ResultSet result = DBFetching.getResultSet(sql);

             while(result.next())
             {
                 hrgKomp.add(Double.parseDouble(result.getString(column)));
             }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKU", 
                    "Error D255", JOptionPane.ERROR_MESSAGE);
           DBFetching.RollBackDB();
           System.exit(1);
       }
       
       //proses menghitung dan update kolom hrg_upah pada table pros_hsku
       try{
            double sum = 0;
            for (int i = 0; i<hrgKomp.size(); i++)
            {
                sum += hrgKomp.get(i);

            }
            DBFetching.setComandToDB("update pros_hsku set hrg_upah ="+sum+"where kd_hsku like '%"
                    +code+"00%'and kd_hsku like '%"+codeHuruf+"%' and tahun = '"+tahunDBKB+"'");
            
            
       }catch(Exception e)
       {
           DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga upah pada perhitungan HSKU", 
                    "Error D256", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
       }
    }   
    
    /**
     * method ini untuk menghitung harga 
     * @param code untuk input key/kode dari table pros_hsku 
     */
    public void prosesHargaTotal(String code)
    {
        double hrgKomp = 0.0;
        double hrgUpah = 0.0;
        String sql = "select hrg_komp from pros_hsku where kd_hsku like '%"+code+"%' and tahun = '"+tahunDBKB+"'";
        String sql2 = "select hrg_upah from pros_hsku where kd_hsku "
                + "like '%"+code+"%' and tahun = '"+tahunDBKB+"'";
        
        //mengambil data dari kolom hargaKomp  
        try{
            ResultSet result = DBFetching.getResultSet(sql);
            
            while(result.next()){
                hrgKomp = Double.parseDouble(result.getString(1));  
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKU",
                    "Error D257",JOptionPane.ERROR_MESSAGE);
        }
        
        //mengambil data dari kolom hrg_upah untuk dihitung dan di update pada kolom hrg_total
        try{
            ResultSet result2 = DBFetching.getResultSet(sql2);
        
            while(result2.next()){

            hrgUpah = Double.parseDouble(result2.getString(1));

            }
            Double total = hrgKomp + hrgUpah;
            DBFetching.setComandToDB("update pros_hsku set hrg_tot = "+total+" where kd_hsku like '%"+code+"%' and  tahun = '"+tahunDBKB+"'");
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga total pada perhitungan HSKU",
                    "Error D258",JOptionPane.ERROR_MESSAGE);
        }
  }
    
   /**
    * untuk memproses perhitungan harga_total beberapa data yang spesifik 
    * data dengan key B040000,B050000,B060000,B070000,B080000,B090000
    * B100000,C010000,C020000,C030000,C040000,C050000
    * @param code untuk input key/kode dari table pros_hsku 
    */ 
   public void prosesHrgTotalSpecialCase (String code)
  {
       
      ArrayList<Double> hrgKomp = new ArrayList<Double>();
      ArrayList<Double> hrgUpah = new ArrayList<Double>();
      
      //Mengambil data dari table pros_hsku
      try{
          String subcode = code.substring(0,3);
          ResultSet result = DBFetching.getResultSet("select hrg_komp,hrg_upah from pros_hsku where kd_hsku like '%"+subcode+"%'"
                  + " and tahun = '"+tahunDBKB+"'");
             
          while(result.next()){
                hrgKomp.add(Double.parseDouble(result.getString("hrg_komp")));
                hrgUpah.add(Double.parseDouble(result.getString("hrg_upah")));
                }
                
                double sumKomp = 0;
                double sumUpah = 0;
                
        //melakukan perhitungan dan update kolom hrg_tot table pros_hsku        
        for (int i = 0; i<hrgKomp.size(); i++)
        {
           
            sumKomp += hrgKomp.get(i);
            sumUpah += hrgUpah.get(i);
         
        }
       
        Double sumTot = sumKomp + sumUpah;
       DBFetching.setComandToDB("update pros_hsku set hrg_tot ="+sumTot
                                +"where kd_hsku like'%"+code+"%' and tahun = '"+tahunDBKB+"'");
       
      
      }catch(Exception e)
      {
          DBFetching.RollBackDB();
          JOptionPane.showMessageDialog(new JFrame(),"gagal melakukan proses perhitungan pada data dengan key "+code+" perhitungan HSKU",
                  "Error D259", JOptionPane.ERROR_MESSAGE);
      }
  }
   
   public void prosesHrgTotalSpecialCase2 (String code)
   {
       
   }
   
   
   public void done()
   {
       DBFetching.Simpan();
   }
    
}
