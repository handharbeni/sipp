package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini untuk memproses Harga Satuan Komponen Material
 * @author I Putu Medagia A
 */
public class HSKM {
     private String tahunDBKB;
    
     /**
      * Constructor class HSKM
      * @param tahunDBKB untuk inisiasi tahun perhitungan DBKB 
      */
     public HSKM(String tahunDBKB)
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
        
        //Mengambil data dari table pros_hskm untuk digunakan dalam proses penghitungan
        try{
            ResultSet result = DBFetching.getResultSet("select * from pros_hskm "
                    + "where convert(right(kd_hskm,2),signed) > 0 and tahun = '"+tahunDBKB+"'");

            while(result.next())
            {
                vol.add(Double.parseDouble(result.getString("vol_hskm")));
                kd.add(result.getString("kd_hskm"));
                kdDhkm.add(result.getString("kd_dhkm"));
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKM", 
                    "Error D241", JOptionPane.ERROR_MESSAGE);
        }
        
        //proses penghitungan harga satuan menggunakan data yang telah diambil sebelumnya
        try{
            for(int i = 0; i < kd.size(); i++)
            {
                String sql = "select hrg_dhkm from ref_dhkmf where kd_dhkm = '" + kdDhkm.get(i)
                        + "' and thn_dhkm like '%" +tahunDBKB+ "%'";
                double temp = DBFetching.getDoubleResult(sql);
                temp *= vol.get(i);

                DBFetching.setComandToDB("update pros_hskm set hrg_sat ="+ temp 
                        +"  where kd_hskm ='" 
                       + kd.get(i)+"' and tahun = '"+tahunDBKB+"'");    
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
             JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga satuan pada penghitungan HSKM", 
                    "Error D242", JOptionPane.ERROR_MESSAGE);
        }
       
    }
     
     /**
      * method untuk menghitung harga komponen
      * @param codeHuruf untuk input key/kode dari table pros_hskm hurufnya saja
      * @param code untuk input key/kode dari table pros_hskm
      * @param column untuk input nomor kolom dari tabel pros_hskm
      */
     public void prosesHargaKomp(String code_huruf,String code, String column)
    {
       String sql =  "select hrg_sat from pros_hskm where kd_hskm like '%"
                +code+"%' and kd_dhkm not like '%M01%' and tahun = '"+tahunDBKB+"'";
       ArrayList<Double> hrgKomp = new ArrayList<Double>();
       
       System.out.println("select hrg_sat from pros_hskm where kd_hskm like '%"
                +code+"%' and kd_dhkm not like '%M01%' and tahun = '"+tahunDBKB+"'");
       
       //mengambil data pada kolom harga_sat dari tabel pros_hskm 
       try{
            ResultSet result = DBFetching.getResultSet(sql);

            while(result.next())
            {
                hrgKomp.add(Double.parseDouble(result.getString(column)));
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKM", 
                    "Error D243", JOptionPane.ERROR_MESSAGE);
        }
        
        //proses menghitung dan update kolom hrg_komp pada table pros_hskm
        try{
            double sum = 0;
            for (int i = 0; i<hrgKomp.size(); i++)
            {
                sum += hrgKomp.get(i);

            }

            DBFetching.setComandToDB("update pros_hskm set hrg_komp ="+sum+"where kd_hskm "
                    + "like '%" +code+"00%'and kd_hskm like '%"+code_huruf+"%' and tahun = '"+tahunDBKB+"'");
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga komponen pada perhitungan HSKM", 
                    "Error D244", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    /**
     * method untuk menghitung harga upah
     * @param codeHuruf untuk input key/kode dari table pros_hskm hurufnya saja
     * @param code untuk input key/kode dari table pros_hskm
     * @param column untuk input nomor kolom dari tabel pros_hskm
     */
    public void prosesHargaUpah(String code_huruf,String code, String column)
    {
       
       String sql =  "select hrg_sat from pros_hskm where kd_hskm like '%"
               +code+"%' and kd_dhkm like '%M01%' and tahun = '"+tahunDBKB+"'"; 
       ArrayList<Double> hrgKomp = new ArrayList<Double>();
       
       //mengambil data pada kolom harga_sat dari tabel pros_hskm    
        try{
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next())
            {
                hrgKomp.add(Double.parseDouble(result.getString(column)));
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKM", 
                    "Error D245", JOptionPane.ERROR_MESSAGE);
        }
        
        //proses menghitung dan update kolom harga_upah pada table pros_hskm
        try{
            double sum = 0;
            for (int i = 0; i<hrgKomp.size(); i++)
            {
                sum += hrgKomp.get(i);
            }
            DBFetching.setComandToDB("update pros_hskm set hrg_upah ="+sum+"where kd_hskm like '%"
                    +code+"00%'and kd_hskm like '%"+code_huruf+"%' and tahun = '"+tahunDBKB+"'");
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga upah pada perhitungan HSKM", 
                    "Error D246", JOptionPane.ERROR_MESSAGE);
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
        String sql = "select hrg_komp from pros_hskm where kd_hskm like '%"+code+"%' and tahun = '"+tahunDBKB+"'";
        
        //mengambil data dari kolom hargaKomp 
        try{
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next()){

            hrgKomp = Double.parseDouble(result.getString(1));
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal mengambil data dari database pada perhitungan HSKM",
                    "Error D247",JOptionPane.ERROR_MESSAGE);
        }
        
        String sql2 = "select hrg_upah from pros_hskm where kd_hskm "
                + "like '%"+code+"%' and tahun = '"+tahunDBKB+"'";
        
        //mengambil data dari kolom hrg_upah untuk dihitung dan di update pada kolom hrg_total
        try{
            ResultSet result2 = DBFetching.getResultSet(sql2);
            while(result2.next()){
                hrgUpah = Double.parseDouble(result2.getString(1)); //mengambil data dari kolom hrg_upah
            }
            Double total = hrgKomp + hrgUpah;

            DBFetching.setComandToDB("update pros_hskm set hrg_tot = "+total+" , tahun = "+tahunDBKB+" where kd_hskm like '%"+code+"%' "
                    + "and tahun = '"+tahunDBKB+"'");
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga total pada perhitungan HSKM",
                    "Error D248",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Class ini digunakan untuk memproses perhitungan Material Lain 
     * @param name adalah nama kolom
     * @param key nama material yang diproses
     */
    public void prosesMaterialLainHskm(String name,String key)
    {
        String sql = "select kd_hskm ,kd_dhkm from pros_hskm "
                + "where "+name+" like '%"+key+"%' and kd_hskm > 'G000000' and tahun = '"+tahunDBKB+"'"; System.out.println(sql);
        Double total;
        Double vol;
        Double totFin;
        
        //Memproses harga satuan dari Material Lain
        try{
            ArrayList <String> kdMaterialLain = DBFetching.getArrayListStringResult(sql,1); //mengambil data key dari material Lain
            ArrayList <String> kdDhkmMatLain = DBFetching.getArrayListStringResult(sql,2); //mengambil key dhkm untuk material lain

            for(int i = 0; i < kdMaterialLain.size();i++)
            {

                if( kdMaterialLain.get(i).equals("G070002") || kdMaterialLain.get(i).equals("G080002") ||
                        kdMaterialLain.get(i).equals("G100004"))
                {

                    total = DBFetching.getDoubleResult("select sum(hrg_dhkm) "
                            + " from ref_dhkmf where kd_dhkm in (select" 
                            + " distinct pros_hskm.kd_dhkm from pros_hskm,ref_dhkmf where" 
                            + " kd_hskm < '"+kdMaterialLain.get(i)+"' "
                            + "and kd_hskm > '"+kdMaterialLain.get(i).substring(0,3)+"0000' " 
                            + " and pros_hskm.kd_dhkm = ref_dhkmf.kd_dhkm and tahun = '"+tahunDBKB+"')" 
                            + " and thn_dhkm = '"+tahunDBKB+"'");
                    /*
                    total = DBFetching.getDoubleResult("select sum(hrg_dhkm) from "
                        +"pros_hskm,ref_dhkmf where kd_hskm < '"+kdMaterialLain.get(i)+"' and kd_hskm > '"+
                        kdMaterialLain.get(i).substring(0,3)+"0000' and pros_hskm.kd_dhkm = ref_dhkmf.kd_dhkm and tahun = '"+tahunDBKB+"'");
                    */
                        
                       vol = DBFetching.getDoubleResult("select vol_hskm from pros_hskm where kd_hskm = '"+kdMaterialLain.get(i)+"' and tahun = '"+tahunDBKB+"'");
                       totFin = vol*total;
                       //System.out.println("totalFIN : "+kdMaterialLain.get(i)+" : "+total);
                       DBFetching.setComandToDB("update pros_hskm set hrg_sat = "+totFin+" where kd_hskm = '"+kdMaterialLain.get(i)+"' and tahun = '"+tahunDBKB+"'");

                }else{
                
               total = DBFetching.getDoubleResult("select sum(hrg_sat) from pros_hskm where "+
                       "kd_hskm < '"+kdMaterialLain.get(i)+"' and "
                       + "kd_hskm > '"+kdMaterialLain.get(i).substring(0,3)+"0000' and tahun = '"+tahunDBKB+"'");
                /*
                total = DBFetching.getDoubleResult("select sum(hrg_sat) from "
                        +"pros_hskm,ref_dhkmf where kd_hskm < '"+kdMaterialLain.get(i)+"' and kd_hskm > '"+
                        kdMaterialLain.get(i).substring(0,3)+"0000' and pros_hskm.kd_dhkm = ref_dhkmf.kd_dhkm and tahun = '"+tahunDBKB+"'");
                */
               /*
                System.out.println("select sum(hrg_sat) from "
                        +"pros_hskm,ref_dhkmf where kd_hskm < '"+kdMaterialLain.get(i)+"' and kd_hskm > '"+
                        kdMaterialLain.get(i).substring(0,3)+"0000' and pros_hskm.kd_dhkm = ref_dhkmf.kd_dhkm and tahun = '"+tahunDBKB+"'");
                */
                vol = DBFetching.getDoubleResult("select vol_hskm from pros_hskm where kd_hskm = '"+kdMaterialLain.get(i)+"' and tahun = '"+tahunDBKB+"'");
                totFin = vol*total;
                System.out.println("totalFIN : "+kdMaterialLain.get(i)+" : "+total);
                DBFetching.setComandToDB("update pros_hskm set hrg_sat = "+totFin+" where kd_hskm = '"+kdMaterialLain.get(i)+"' and tahun = '"+tahunDBKB+"'");
                }
            }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga satuan material lain pada perhitungan HSKM",
                    "Error D249", JOptionPane.ERROR_MESSAGE);
        }
        
        //proses menghitung harga komponen,harga upah dan harga total material lain
        try{
            String sql2 = "select kd_hskm from pros_hskm where kd_hskm > 'G000000' and kd_hskm like '%0000%' and kd_hskm not like '%G10%' and tahun = '"+tahunDBKB+"'";
            ArrayList <String> kd = DBFetching.getArrayListStringResult(sql2,1);
            kd.add("G100004");

            for(int i = 0; i < kd.size();i++){

              if(kd.get(i).equals("G100004"))
              {
                double komp = DBFetching.getDoubleResult("select sum(hrg_sat) from pros_hskm where kd_dhkm not like '%M01%' and kd_hskm like '%"+kd.get(i).substring(0,3)+"%' and tahun = '"+tahunDBKB+"'" );
                double upah = DBFetching.getDoubleResult("select sum(hrg_sat) from pros_hskm where kd_dhkm like '%M01%' and kd_hskm like '%"+kd.get(i).substring(0,3)+"%' and tahun = '"+tahunDBKB+"'");
                double Hrgtotal = komp+upah;
                DBFetching.setComandToDB("update pros_hskm set hrg_komp = "+komp+",hrg_tot = "+Hrgtotal+" where kd_hskm = 'G100000' and tahun = '"+tahunDBKB+"'");
                DBFetching.setComandToDB("update pros_hskm set hrg_upah = "+upah+" where kd_hskm = 'G100000' and tahun = '"+tahunDBKB+"'");    
              }else{
                double komp = DBFetching.getDoubleResult("select sum(hrg_sat) from pros_hskm where kd_dhkm not like '%M01%' and kd_hskm like '%"+kd.get(i).substring(0,3)+"%' and tahun = '"+tahunDBKB+"'");
                double upah = DBFetching.getDoubleResult("select sum(hrg_sat) from pros_hskm where kd_dhkm like '%M01%' and kd_hskm like '%"+kd.get(i).substring(0,3)+"%' and tahun = '"+tahunDBKB+"'");
                double Hrgtotal = komp+upah;
                DBFetching.setComandToDB("update pros_hskm set hrg_komp = "+komp+",hrg_tot = "+Hrgtotal+" where kd_hskm like '%"+kd.get(i)+"%' and tahun = '"+tahunDBKB+"'");
                DBFetching.setComandToDB("update pros_hskm set hrg_upah = "+upah+" where kd_hskm like '%"+kd.get(i)+"%' and tahun = '"+tahunDBKB+"'");    
              }
           }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga total material lain pada perhitungan HSKM",
                    "Error D2410", JOptionPane.ERROR_MESSAGE);
        
        }
    }
   
  /**
   * untuk memproses perhitungan harga_total beberapa data yang spesifik 
   * data dengan key B040000,F010000
   * @param code untuk input key/kode dari table pros_hsku 
   */   
  public void prosesHrgTotalSpecialCase (String code)
  {
       
      ArrayList<Double> hrgKomp = new ArrayList<Double>();
      ArrayList<Double> hrgUpah = new ArrayList<Double>();
      //Mengambil data dari table pros_hsku
      try{
          String subcode = code.substring(0,3);
          ResultSet result = DBFetching.getResultSet("select hrg_komp,hrg_upah from pros_hskm where kd_hskm like '%"+subcode+"%' and tahun = '"+tahunDBKB+"'");
             
          while(result.next()){
                hrgKomp.add(Double.parseDouble(result.getString("hrg_komp")));
                hrgUpah.add(Double.parseDouble(result.getString("hrg_upah")));
                }
                
                double sumKomp = 0;
                double sumUpah = 0;
        for (int i = 0; i<hrgKomp.size(); i++)
        {
           
            sumKomp += hrgKomp.get(i);
            sumUpah += hrgUpah.get(i);
         
        }
       
        Double sumTot = sumKomp + sumUpah;
        DBFetching.setComandToDB("update pros_hskm set hrg_tot ="+sumTot
                                +"where kd_hskm like'%"+code+"%'  and tahun = '"+tahunDBKB+"'");
      }catch(Exception e)
      {
          DBFetching.RollBackDB();
          JOptionPane.showMessageDialog(new JFrame(),"gagal melakukan proses perhitungan pada data dengan key "+code+" perhitungan HSKM",
                  "Error D2411", JOptionPane.ERROR_MESSAGE);
      }
  }
  
  public void done()
  {
      DBFetching.Simpan();
  }

}
