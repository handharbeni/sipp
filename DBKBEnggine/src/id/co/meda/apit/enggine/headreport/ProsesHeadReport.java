/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.headreport;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesHeadReport {
    
    private static ModelHeadReport model;
    
    private static void buatModelHead()
    {
        
        model = new ModelHeadReport();
        
         try
        {
            String sql = "SELECT * FROM head_report";
            
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next())
            {
                model.setNamaPemDaerah(result.getString(1));
                model.setDinasDaerah(result.getString(2));
                model.setAlamatDinas(result.getString(3));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private static boolean simpan(ModelHeadReport model)
    {
         DBFetching.setAutoCommit(false);
        try{
            DBFetching.setComandToDB("TRUNCATE `head_report`");
            
             String sql = "INSERT INTO `head_report` "
                     + "(`nama_pem_daerah`, `dinas_daerah`, `alamat_dinas`) "
                     + "VALUES ('"+model.getNamaPemDaerah()+"', "
                     + "'"+model.getDinasDaerah()+"', "
                     + "'"+model.getAlamatDinas()+"')";
             DBFetching.setComandToDB(sql);
            
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            return false;
        }
        DBFetching.Simpan();
        return true;
    }
    
     public static boolean simpanHeadReport(ModelHeadReport model)
    {
        return simpan(model);
    }
    
    public static ModelHeadReport getModelHead()
    {
        buatModelHead();
        return model;
    }
    
    
}
