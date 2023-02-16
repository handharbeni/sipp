/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class BuatModelPendapatanPerikanan {
    
    private static ModelPendapatanPerikanan ikan = new ModelPendapatanPerikanan();
    private static ArrayList<ModelIkan> arrPenangkapan = new ArrayList<ModelIkan>();
    private static ArrayList<ModelIkan> arrPembudidayaan = new ArrayList<ModelIkan>();
    
    
    private static void buatModel(String nop)
    {
        try{
            
            DBFetching.setAutoCommit(false);
            
            String sql = "SELECT * FROM pros_datapendapatan_perikanan where nop = '"+nop+"'";
            
            ResultSet set = DBFetching.getResultSet(sql);
            
            while(set.next())
            {
                if(set.getString(2).equalsIgnoreCase("penangkapan ikan"))
                {
                    ModelIkan ikan = new ModelIkan();
                    ikan.setJenisUsaha(set.getString(2));
                    ikan.setNamaIkan(set.getString(3));
                    ikan.setBerat(set.getDouble(4));
                    ikan.setHargaPerTon(set.getDouble(5));
                    ikan.setKeterangan(set.getString(5));
                    arrPenangkapan.add(ikan);
                }else
                {
                    ModelIkan ikan = new ModelIkan();
                    ikan.setJenisUsaha(set.getString(2));
                    ikan.setNamaIkan(set.getString(3));
                    ikan.setBerat(set.getDouble(4));
                    ikan.setHargaPerTon(set.getDouble(5));
                    ikan.setKeterangan(set.getString(5));
                    arrPembudidayaan.add(ikan);
                }
                
            }
            
            ikan.setNop(nop);
            ikan.setPembudidayaIkan(arrPembudidayaan);
            ikan.setPenangkapanIkan(arrPenangkapan);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        
        }
    }
    
    
    public static ModelPendapatanPerikanan getModelPendapatanIkan(String nop)
    {
        buatModel(nop);
        return ikan;
        
    }
    
    
}
