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
public class FasilitasVideoInterkom {

private String tahunDBKB;
private final double LUAS_LANTAI_TOTAL = 106884;
private final double LUAS_LANTAI_VIDEO = 21377;
private final double TINGGI_LANTAI = 29;
private final double LUAS_PERLANTAI = 3685.66;


public FasilitasVideoInterkom(String tahunDBKB)
{
    DBFetching.setAutoCommit(false);
    this.tahunDBKB = tahunDBKB;
}

public void prosesPerhitungan()
{
    try{
        
    String sql = "update pros_video_interkom set model_jumlah_berubah_total = model_jumlah_berubah_perlt*"+this.TINGGI_LANTAI+" "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    sql = "update pros_video_interkom set model_total_jumlah = model_jumlah_tetap+model_jumlah_berubah_total "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    sql = "update pros_video_interkom set model_harga_tetap = model_jumlah_tetap*model_harga "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    sql = "update pros_video_interkom set model_harga_berubah_perlt = model_jumlah_berubah_perlt*model_harga "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    sql = "update pros_video_interkom set model_harga_berubah_total = model_jumlah_berubah_total*model_harga "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    double totalModelJumlah = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_video_interkom where tahun = '"+tahunDBKB+"'");
    
    sql = "update pros_video_interkom set model_bobot = model_jumlah_harga/"+totalModelJumlah+ ""
                 + "where tahun = "+tahunDBKB+" and id_other not like '%NON%'";
    DBFetching.setComandToDB(sql);
    
    double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_video_interkom where tahun = '"+tahunDBKB+"'");
    
    sql = "update pros_video_interkom,ref_dhkmf set aktual_harga = hrg_dhkm "
                + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                + "and id_other = kd_dhkm";     
    DBFetching.setComandToDB(sql);
    
    sql = "update pros_video_interkom set aktual_jumlah_harga = aktual_harga*model_total_jumlah "
                 + "where tahun = "+tahunDBKB+"";
    DBFetching.setComandToDB(sql);
    
    double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_video_interkom where tahun = '"+tahunDBKB+"'");
           
    double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
    double subTotal = totalAktualHarga+jumlahLain;
    double ppn = subTotal*0.1;
    double fee = subTotal*0.3;
    double totalHitung = subTotal+ppn+fee;
    double konversi = totalHitung/this.LUAS_LANTAI_VIDEO; 
    
    sql = "update rslt_fasilitas set harga = "+konversi+" where id = 'FVD001' and tahun = '"+tahunDBKB+"'";
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
