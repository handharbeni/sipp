/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini untuk menghitung Fasilitas
 * secara umum yang tidak spesifik
 * @author I Putu Medagia A
 */
public class Fasilitas {

private String tahunDBKB;

 private ArrayList <String> otherSTR;
 private ArrayList <String> otherFIN;
 private ArrayList <String> otherMTR;
 private ArrayList <String> otherHSAT;

public Fasilitas(String tahunDBKB)
{
    this.tahunDBKB = tahunDBKB;
    
    String sqlSTR = "select distinct other_id from pros_fasilitas where stat like '%STR%' and tahun = '"+this.tahunDBKB+"'";
    String sqlFIN = "select distinct other_id from pros_fasilitas where stat like '%K-FIN%' and tahun = '"+this.tahunDBKB+"'";
    String sqlMTR = "select distinct other_id from pros_fasilitas where stat like '%MTR%' and tahun = '"+this.tahunDBKB+"'";
    String sqlHSAT = "select distinct other_id from pros_fasilitas where stat like '%HSAT%' and tahun = '"+this.tahunDBKB+"'";
    
    DBFetching.setAutoCommit(false);
    otherSTR = DBFetching.getArrayListStringResult(sqlSTR,1);
    otherFIN = DBFetching.getArrayListStringResult(sqlFIN,1);
    otherMTR = DBFetching.getArrayListStringResult(sqlMTR,1);
    otherHSAT = DBFetching.getArrayListStringResult(sqlHSAT,1);
}

public void prosesHrg1andHrg2()
{
    try{
        
        for(int i = 0; i < otherSTR.size();i++)
        {    
            String sqlProsesSTR = "update pros_fasilitas,pros_hsku SET Harga1 = hrg_komp, Harga2 = hrg_upah"
                        + " where pros_hsku.kd_hsku = '"+otherSTR.get(i)+"' "
                        + " and other_id = '"+otherSTR.get(i)+"'"
                        + "and stat = 'STR'"
                        + "and pros_fasilitas.tahun = '"+tahunDBKB+"' "
                        + "and pros_hsku.tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sqlProsesSTR);
            
    
        }
        
         for(int i = 0; i < otherFIN.size();i++)
        {    
            String sqlProsesSTR = "update pros_fasilitas,pros_hskm SET Harga1 = hrg_komp, Harga2 = hrg_upah"
                        + " where pros_hskm.kd_hskm = '"+otherFIN.get(i)+"' "
                        + " and other_id = '"+otherFIN.get(i)+"'"
                        + "and stat = 'K-FIN'"
                        + "and pros_fasilitas.tahun = '"+tahunDBKB+"' "
                        + "and pros_hskm.tahun = '"+tahunDBKB+"'";
           
           DBFetching.setComandToDB(sqlProsesSTR);
            
    
        }
         
         for(int i = 0; i < otherHSAT.size();i++)
        {    
            String sqlProsesSTR = "update pros_fasilitas,pros_hsat SET Harga1 = hrg_mat, Harga2 = hrg_upah"
                        + " where pros_hsat.kd_hsat = '"+otherHSAT.get(i)+"' "
                        + " and other_id = '"+otherHSAT.get(i)+"'"
                        + "and stat = 'HSAT'"
                        + "and pros_fasilitas.tahun = '"+tahunDBKB+"' "
                        + "and pros_hsat.tahun = '"+tahunDBKB+"'";
            
           
           
           DBFetching.setComandToDB(sqlProsesSTR);
            
    
        }
        
      
        
        String sqlProsesMTR = "update pros_fasilitas,ref_dhkmf SET Harga1 = hrg_dhkm where other_id = kd_dhkm"
                                + " and pros_fasilitas.tahun = '"+tahunDBKB+"' and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sqlProsesMTR);

        String sqlProsesSTR2 = "update pros_fasilitas,pros_hsku SET Harga1 = hrg_komp/100, Harga2 = hrg_upah/100 where other_id = kd_hsku and other_id like '%B040600%'"
                                 + " and pros_fasilitas.tahun = '"+tahunDBKB+"' and pros_hsku.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sqlProsesSTR2);
                
    }catch(Exception e)
    {
        DBFetching.RollBackDB();
        JOptionPane.showMessageDialog(new JFrame(),
                "gagal menghitung harga 1 dan harga 2 Fasilitas","Error 211",JOptionPane.ERROR_MESSAGE);
    }
}
    
public void prosesHrgTot()
{
    try{
    ArrayList<String> kdFasilitas = DBFetching.getArrayListStringResult("select id_fasilitas from pros_fasilitas",1);
    
    for(int i = 0; i < kdFasilitas.size(); i++)
    {
        String sqlProsesHrgTot = "update pros_fasilitas set Total = round((Harga1 + Harga2)*Faktor) where "
                                  + "id_fasilitas = '"+kdFasilitas.get(i)+"' "
                                  + "and tahun = '"+tahunDBKB+"'";
         DBFetching.setComandToDB(sqlProsesHrgTot);
    }
    
    }catch(Exception e)
    {
        DBFetching.RollBackDB();
        JOptionPane.showMessageDialog(new JFrame(),"gagal menghitung harga total Fasilitas","Error 212",JOptionPane.ERROR_MESSAGE);
    }
}

public void Calculate()
{
    this.prosesHrg1andHrg2();
    this.prosesHrgTot();
    DBFetching.Simpan();
}


}
