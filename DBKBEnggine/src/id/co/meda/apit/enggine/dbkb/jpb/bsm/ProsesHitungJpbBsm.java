/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.bsm;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.bsm.ModelKuBsmTable1;
import id.co.meda.apit.enggine.dbkb.model.bsm.ModelKuBsmTable2;
import java.util.HashMap;

/**
 *
 * @author meda
 */
public class ProsesHitungJpbBsm {
    private BuatModelJpbBsm model;
    private String tahunDBKB;
    
    public ProsesHitungJpbBsm(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesPindahKeKu()
    {
        model = new BuatModelJpbBsm(this.tahunDBKB);
        try{
            HashMap<String,ModelKuBsmTable1> modelKuTable1 = model.getDataKuTable1();
            HashMap<String,ModelKuBsmTable2> modelKuTable2 = model.getDataKuTable2();
            
            for(ModelKuBsmTable2 value : modelKuTable2.values())
            {
                String sql = "UPDATE rslt_ku_bsm SET  nilai = "+value.getDbkb()+" WHERE  "
                        + "jumlah_lantai = "+value.getLantai()+" and tahun = '"+this.tahunDBKB+"' "
                        + "and jenis ='Mal'";
                DBFetching.setComandToDB(sql);
            }
            
            for(ModelKuBsmTable1 value : modelKuTable1.values())
            {
                String sql = "UPDATE rslt_ku_bsm SET  nilai = "+value.getDbkbdanDbkbKum(0.2)+" WHERE  "
                        + "jumlah_lantai = "+value.getLantai()+" and tahun = '"+this.tahunDBKB+"' "
                        + "and jenis ='Selain Mal'";
                DBFetching.setComandToDB(sql);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
