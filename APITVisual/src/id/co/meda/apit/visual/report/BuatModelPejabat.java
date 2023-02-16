/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.jabatan.ModelJabatan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class BuatModelPejabat {

    public static ArrayList<ModelJabatan> buatModelJabatan()
    {
        ArrayList<ModelJabatan> arrJabatan = new ArrayList<ModelJabatan>();
        try{
            String sql = "SELECT * FROM pejabat";
            
            ResultSet set = DBFetching.getResultSet(sql);
            while(set.next())
            {
                System.out.println(set.getString(1)+" "+set.getString(2)+" "+set.getString(3));
                ModelJabatan model = new ModelJabatan();
                model.setNip("NIP. "+set.getString(1));
                model.setJabatan(set.getString(2));
                model.setNama(set.getString(3));
                arrJabatan.add(model);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arrJabatan;
    }
}
