/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.Stack;

/**
 *
 * @author meda
 */
public class FasilitasListrik {
    
private String tahunDBKB;
private final double KAPASITAS_LISTRIK_TERPASANG = 1425;
private final double LUAS_LANTAI_TOTAL = 106884;
private final double TINGGI_LANTAI = 29;
private double konversi;

public FasilitasListrik(String tahunDBKB)
{
    DBFetching.setAutoCommit(false);
    this.tahunDBKB = tahunDBKB;
}

public void prosesKomponenListrik()
{
    try{
       
        String sql = "update pros_komponen_listrik set model_jumlah_harga = model_harga*model_jumlah "
                     + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalModelHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_komponen_listrik "
                                                            + "where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_komponen_listrik set model_bobot = model_jumlah_harga/"+totalModelHarga+" "
                     + "where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
        DBFetching.setComandToDB(sql);
        
        double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_komponen_listrik "
                                                            + "where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_komponen_listrik,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";    
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_komponen_listrik set aktual_jumlah_harga = model_jumlah*aktual_harga "
                     + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_komponen_listrik where tahun = '"+tahunDBKB+"'");
           
        double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        double totalHitung = subTotal+ppn+fee;
        this.konversi = totalHitung/this.KAPASITAS_LISTRIK_TERPASANG; 
        
    }catch(Exception e)
    {
        e.printStackTrace();
        DBFetching.RollBackDB();
        System.exit(1);
    }
}

public void prosePerbandinganHarga()
{
    try{
        
        double tempKomposisiBiaya = DBFetching.getDoubleResult("select komposisi_biaya from pros_perbandingan_listrik where id = 1 and tahun = '"+tahunDBKB+"'");
        
        String sql = "update pros_perbandingan_listrik set komposisi_koefisien = komposisi_biaya/"+tempKomposisiBiaya+" where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_perbandingan_listrik set aktual = komposisi_koefisien*"+this.konversi+" where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        Stack stIdListrik = DBFetching.getStackResult("select id from rslt_fasilitas where id like '%FK%' "
                    + "and tahun = '"+this.tahunDBKB+"'", 1);

        Stack stHrgListrik = DBFetching.getStackResult("select aktual from pros_perbandingan_listrik where "
                    + "tahun = '"+this.tahunDBKB+"'", 1);

        while(!stIdListrik.isEmpty())
        {
             sql = "update rslt_fasilitas set harga = "+(Double)stHrgListrik.pop()+" "
                        + "where id = '"+stIdListrik.pop()+"' and tahun = '"+this.tahunDBKB+"'";
                DBFetching.setComandToDB(sql);
        }
        
        
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
