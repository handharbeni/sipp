/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author meda
 */
public class FasilitasPlumbing {
    
private final double LUAS_LANTAI_TOTAL = 106884.0;
private final double TINGGI_LANTAI = 29.0;
private final double LUAS_PERLANTAI = 3686.0;
private double konversi = 0;
private String tahunDBKB;

public FasilitasPlumbing(String tahunDBKB)
{
    this.tahunDBKB = tahunDBKB;
    DBFetching.setAutoCommit(false);
}

public void prosesPerhitungan()
{
    try{
        
        String sql = "update pros_plumbing_perhitungan set model_total_jumlah = model_jumlah_tetap + model_jumlah_berubah_total where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_plumbing_perhitungan set model_harga_tetap = model_jumlah_tetap*model_harga where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_plumbing_perhitungan set model_harga_berubah_total = model_jumlah_berubah_total*model_harga where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_plumbing_perhitungan set model_jumlah_harga = model_harga_berubah_total + model_harga_tetap where "
                + "tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalModelJumlah = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_plumbing_perhitungan "
                + "where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_plumbing_perhitungan set model_bobot = model_jumlah_harga/"+totalModelJumlah+ ""
                 + "where tahun = "+tahunDBKB+" and id_other not like '%NON%'";
        DBFetching.setComandToDB(sql);
    
        double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_plumbing_perhitungan where tahun = '"+tahunDBKB+"'");
    
        sql = "update pros_plumbing_perhitungan,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";     
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_plumbing_perhitungan set aktual_jumlah_harga = aktual_harga*model_total_jumlah "
                 + "where tahun = "+tahunDBKB+"";
        DBFetching.setComandToDB(sql);
    
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_plumbing_perhitungan where tahun = '"+tahunDBKB+"'");
           
        double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        double totalHitung = subTotal+ppn+fee;
        konversi = totalHitung/this.LUAS_LANTAI_TOTAL; 
         
    }catch(Exception e)
    {
        e.printStackTrace();
        DBFetching.RollBackDB();
        System.exit(1);
    }
}

public void prosesKoefisien()
{
    try{
        
        String sql = "update pros_plumbing_koefisien,ref_faktormaterial set asli = faktor where jumlah_lantai = jml_lt "
                + "and pros_plumbing_koefisien.tahun = '"+tahunDBKB+"' "
                + "and ref_faktormaterial.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double acuanKoef = DBFetching.getDoubleResult("select asli from pros_plumbing_koefisien where jumlah_lantai = 29 and tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_plumbing_koefisien set modifikasi = asli/"+acuanKoef+" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
    }catch(Exception e)
    {
        e.printStackTrace();
        DBFetching.RollBackDB();
        System.exit(1);
    }
}

public void prosesResultPlumbing()
{
    try{
        
        String sql = "update pros_plumbing_koefisien,rslt_fasilitasplumbing set JPB2 = modifikasi*"+konversi+" where "
                + " pros_plumbing_koefisien.jumlah_lantai = rslt_fasilitasplumbing.jumlah_lantai "
                + "and pros_plumbing_koefisien.tahun = '"+tahunDBKB+"' "
                + "and rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double tempJpb4 = DBFetching.getDoubleResult("select koef from pros_plumbing_koefisien where jumlah_lantai = 2 and tahun = '"+tahunDBKB+"'");
        double tempJpb5 = DBFetching.getDoubleResult("select koef from pros_plumbing_koefisien where jumlah_lantai = 3 and tahun = '"+tahunDBKB+"'");
        double tempJpb7 = DBFetching.getDoubleResult("select koef from pros_plumbing_koefisien where jumlah_lantai = 4 and tahun = '"+tahunDBKB+"'");
        double tempJpb12 = DBFetching.getDoubleResult("select koef from pros_plumbing_koefisien where jumlah_lantai = 5 and tahun = '"+tahunDBKB+"'");
        double tempJpb13 = DBFetching.getDoubleResult("select koef from pros_plumbing_koefisien where jumlah_lantai = 6 and tahun = '"+tahunDBKB+"'");
        
        sql = "update rslt_fasilitasplumbing set JPB4 = JPB2*"+tempJpb4+" where "
                + " rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update rslt_fasilitasplumbing set JPB5 = JPB2*"+tempJpb5+" where "
                + " rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update rslt_fasilitasplumbing set JPB7 = JPB2*"+tempJpb7+" where "
                + " rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update rslt_fasilitasplumbing set JPB12 = JPB2*"+tempJpb12+" where "
                + " rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update rslt_fasilitasplumbing set JPB13 = JPB2*"+tempJpb13+" where "
                + " rslt_fasilitasplumbing.tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        
        
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
