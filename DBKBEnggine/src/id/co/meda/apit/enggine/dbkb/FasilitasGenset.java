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
 * @author I Putu Medagia A
 */
public class FasilitasGenset {
    
    private String tahunDBKB;
    private final double LUAS_TANAH_TOTAL = 106884;
    private final double TINGGI_LANTAI = 29;
    private double totalHitung = 0;
    public FasilitasGenset(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesPerhitungan()
    {
        try{
        String sql = "update pros_genset_hitung,ref_dhkmf set aktual_jumlah_harga = hrg_dhkm "
              + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
              + " and id_other = kd_dhkm";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_genset_hitung set model_jumlah_harga = (model_harga*model_jumlah) where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalModelHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_genset_hitung "
                                + "where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_genset_hitung set model_bobot = (model_jumlah_harga/"+totalModelHarga+") where "
                + "tahun = '"+tahunDBKB+"' and id not in('4','9')";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_genset_hitung set aktual_jumlah_harga = (aktual_harga*model_jumlah) where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_genset_hitung "
                                + "where tahun = '"+tahunDBKB+"'");
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_harga) from pros_genset_hitung "
                                + "where tahun = '"+tahunDBKB+"'");
        
        double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        totalHitung = subTotal+ppn+fee;
        double konversi = totalHitung/100; 
        
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
        
    }
    
    public void prosesPrakiraanKomponen()
    {
        try{
            
        //proses harga id 3
        double kapasitas2 = DBFetching.getDoubleResult("select harga from pros_genset_prakiraan "
                            +"where id = 2 and tahun = '"+tahunDBKB+"'");
        double kapasitas5 = DBFetching.getDoubleResult("select harga from pros_genset_prakiraan "
                            +"where id = 5 and tahun = '"+tahunDBKB+"'");  
        
        double kapasitas3 = kapasitas2 + (kapasitas5-kapasitas2)*((250.0-100.0)/(500.0-100.0));
        
        String sql = "update pros_genset_prakiraan set harga = '"+kapasitas3+"' where id = 3 and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //proses Harga
        sql = "update pros_genset_prakiraan set harga_set = (harga/"+kapasitas2+")*"+this.totalHitung+" "
              + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        //proses rp/kva
        sql = "update pros_genset_prakiraan set rp_kva = (harga_set/bagi_rp_kva) "
              + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        Stack stIdGenset = DBFetching.getStackResult("select id from rslt_fasilitas where tahun = '"+tahunDBKB+"' "
                                                     + "and id like '%FGE%' and id not in ('FGE000')", 1);
        
        Stack stHrgGenset = DBFetching.getStackResult("select rp_kva from pros_genset_prakiraan where tahun = '"+tahunDBKB+"'", 1);
        
        //proses update
        while(!stIdGenset.isEmpty())
        {
            sql = "update rslt_fasilitas set harga = "+(Double)stHrgGenset.pop()+""
                  + " where id = '"+stIdGenset.pop()+"' and tahun = '"+tahunDBKB+"'";
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
