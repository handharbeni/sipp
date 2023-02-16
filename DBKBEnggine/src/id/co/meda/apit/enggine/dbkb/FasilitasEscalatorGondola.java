/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author I Putu Medagia A
 */
public class FasilitasEscalatorGondola {
    
    private String tahunDBKB;
    private final double LUAS_LANTAI = 32362;
    private final int JUMLAH_LANTAI = 5;
    private final double LUAS_LAHAN = 10386;
    
    public FasilitasEscalatorGondola(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
     
    public void prosesHargaAktual()
    {
        try{
            
            String sql = "update pros_escalator_hargaaktual,ref_dhkmf set "
                         + "model_harga = hrg_dhkm where pros_escalator_hargaaktual.tahun = '"+tahunDBKB+"'"
                         + " and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'"
                         + " and ref_dhkmf.kd_dhkm = pros_escalator_hargaaktual.id_other";
            DBFetching.setComandToDB(sql);
            
             sql = "update pros_escalator_hargaaktual set "
                         + "model_hargappnfee = (1.1*model_harga)+(0.3*model_harga) where "
                         + "pros_escalator_hargaaktual.tahun = '"+tahunDBKB+"'";
            
             DBFetching.setComandToDB(sql);
            
       
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
    }
    
    public void prosesHargaBanding()
    {
        try{
            
            String sql = "select harga from pros_escalator_hargabanding where id = '2' and tahun = '"+tahunDBKB+"'";
            double hrgBanding = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_escalator_hargabanding set perb = (harga/"+hrgBanding+") "
                  +"where tahun = '"+tahunDBKB+"'"; 
            DBFetching.setComandToDB(sql);
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesHargaAktualPrediksi()
    {
        try{
            String sql = "select model_harga from pros_escalator_hargaaktual where id = '2' and tahun = '"+tahunDBKB+"'";
            double hrgAktualEscalator = DBFetching.getDoubleResult(sql);
            
            sql = "select model_harga from pros_escalator_hargaaktual where id = '3' and tahun = '"+tahunDBKB+"'";
            double hrgAktualGondola = DBFetching.getDoubleResult(sql);
            
            sql = "select perb from pros_escalator_hargabanding where id = '1' and tahun = '"+tahunDBKB+"'";
            double perbEscalator1 = DBFetching.getDoubleResult(sql);
            
            sql = "select perb from pros_escalator_hargabanding where id = '2' and tahun = '"+tahunDBKB+"'";
            double perbEscalator2 = DBFetching.getDoubleResult(sql);
            
            sql = "update pros_escalator_hargapreaktual set harga = "+(hrgAktualEscalator*perbEscalator1)+" "
                  + "where id = '1' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_escalator_hargapreaktual set harga = "+(hrgAktualEscalator*perbEscalator2)+" "
                  + "where id = '2' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_escalator_hargapreaktual set harga = "+hrgAktualGondola+" "
                  + "where id = '3' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update pros_escalator_hargapreaktual set hargappnfee = (1.1*harga)+(0.3*harga) where "
                  + " tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void prosesResultEscalatorGondola()
    {
        try{
            String sql = "select hargappnfee from pros_escalator_hargapreaktual where id = '1' and tahun = '"+tahunDBKB+"'";
            double hargaEscalator1 = DBFetching.getDoubleResult(sql);
            
            sql = "select hargappnfee from pros_escalator_hargapreaktual where id = '2' and tahun = '"+tahunDBKB+"'";
            double hargaEscalator2 = DBFetching.getDoubleResult(sql);
            
            sql = "update rslt_fasilitas set harga = '"+hargaEscalator1+"' where id = 'FES001' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "update rslt_fasilitas set harga = '"+hargaEscalator2+"' where id = 'FES002' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
    
    
    
    
}
