/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.jalantol;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author I Putu Medagia A
 */
public class ToolsPenilaianJatol {

    public static TanahJatol getModelTanahJatol(String nop, String tahun)
    {
        String sql = "SELECT * FROMtanah_jatol from tahun = '"+tahun+"' and nop = '"+nop+"'";
        ResultSet set = DBFetching.getResultSet(sql);
        try {
            
            TanahJatol modelTanahJatol = new TanahJatol();
            boolean cek = false;
            while(set.next())
            {
                if(set.getString(1).equalsIgnoreCase(nop) && set.getString(5).equalsIgnoreCase(tahun))
                {
                    modelTanahJatol.setNop(set.getString(1));
                    modelTanahJatol.setNamaJatol(set.getString(2));
                    modelTanahJatol.setPanjangJatol(Double.parseDouble(set.getString(3)));
                    modelTanahJatol.setLebarJatol(Double.parseDouble(set.getString(4)));
                    modelTanahJatol.setTahun(set.getString(5));
                    cek = true;
                    break;
                }
            }
            
            if(cek)
            {
                sql = "SELECT * FROMtanah_detail_jatol from tahun = '"+tahun+"' and nop = '"+nop+"'";
                set = DBFetching.getResultSet(sql);
                
                ArrayList <DetailTanahJatol> arrDetailTanah = new ArrayList <DetailTanahJatol>();
                
                while(set.next())
                {
                    if(set.getString(1).equalsIgnoreCase(nop) && set.getString(2).equalsIgnoreCase(tahun))
                    {
                        DetailTanahJatol detail = new DetailTanahJatol();
                        
                        detail.setZona(set.getString(3));
                        detail.setLuas(Double.parseDouble(set.getString(4)));
                        detail.setNjopPerM(Double.parseDouble(set.getString(5)));
                        detail.setTotalNjop(Double.parseDouble(set.getString(6)));
                        arrDetailTanah.add(detail);
                       
                        break;
                    }
                }
                
                modelTanahJatol.setArrDetailTanah(arrDetailTanah);
            }
              
            
            return modelTanahJatol;
            
        } catch (SQLException ex) {
            Logger.getLogger(ToolsPenilaianJatol.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
