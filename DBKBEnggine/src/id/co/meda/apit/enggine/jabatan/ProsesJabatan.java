/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.jabatan;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class ProsesJabatan {
    
    private static ArrayList<ModelJabatan> arrModelJabatan;
    
    private static void buatModelArrJabatan()
    {
        arrModelJabatan = new ArrayList<ModelJabatan>();
        try
        {
            String sql = "SELECT * FROM pejabat";
            
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next())
            {
                ModelJabatan tempModel = new ModelJabatan();
                tempModel.setNip(result.getString(1));
                tempModel.setJabatan(result.getString(2));
                tempModel.setNama(result.getString(3));
                
                arrModelJabatan.add(tempModel);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    private static boolean simpanJabatan()
    {
        DBFetching.setAutoCommit(false);
        try{
            DBFetching.setComandToDB("TRUNCATE `pejabat`");
                
            for(int i = 0; i < arrModelJabatan.size();i++)
            {
                String sql = "INSERT INTO `pejabat` "
                        + "(`nip`, `jabatan`, `nama`) "
                        + "VALUES ('"+arrModelJabatan.get(i).getNip()+"', "
                        + "'"+arrModelJabatan.get(i).getJabatan()+"', "
                        + "'"+arrModelJabatan.get(i).getNama()+"')";
                DBFetching.setComandToDB(sql);
            }
            
            
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            return false;
        }
        DBFetching.Simpan();
        return true;
    }
    
    public static boolean simpanJabatan(ArrayList<ModelJabatan> arrJabatan)
    {
        arrModelJabatan = arrJabatan;
        return simpanJabatan();
    }
    
    public static ArrayList<ModelJabatan> getArrModelJabatan()
    {
        buatModelArrJabatan();
        return arrModelJabatan;
    }
    
}
