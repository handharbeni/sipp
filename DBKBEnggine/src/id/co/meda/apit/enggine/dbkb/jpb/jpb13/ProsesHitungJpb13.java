/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb13;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.model.ModelStat;
import java.util.HashMap;

/**
 *
 * @author meda
 */
public class ProsesHitungJpb13 {
    private  BuatModelJpb13 model;
    private  String tahunDBKB;
    
    public ProsesHitungJpb13(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
    }
    
   
    
    public  void prosesKeTableKu()
    {
        model = new BuatModelJpb13(tahunDBKB);
    
        HashMap<String,ModelStat> hashStat = model.getStat();
        
        for(int i = 1 ; i< hashStat.size()+1;i++)
        {
            double nilaiDBKB = hashStat.get(i+"").getCum();
            String sql = "UPDATE rslt_ku_lbh_4lt SET jpb_13 = "+nilaiDBKB+" WHERE jumlah_lantai = '"+i+"' and thn_dbkb ='"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }
    }
    
}
