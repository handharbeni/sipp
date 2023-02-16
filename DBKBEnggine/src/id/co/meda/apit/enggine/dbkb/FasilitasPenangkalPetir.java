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
public class FasilitasPenangkalPetir {

private String tahunDBKB;
private final double LUAS_LANTAI_TOTAL = 106884;
private final double TINGGI_LANTAI = 32;
private final double LUAS_PERLANTAI = 3340;

public FasilitasPenangkalPetir(String tahunDBKB)
{
    this.tahunDBKB = tahunDBKB;
}

public void prosesPerhitungan()
{
    try{
        String sql = "update pros_penangkal_petir set model_jumlah_harga = model_harga*model_jumlah "
                + "where tahun = '"+this.tahunDBKB+"'";
        DBFetching.setComandToDB(sql);

        double totalJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_penangkal_petir where tahun = '"+tahunDBKB+"'");

        sql = "update pros_penangkal_petir set model_bobot = model_jumlah_harga/"+totalJumlahHarga+" "
               + " where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
        DBFetching.setComandToDB(sql);

        double totalBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_penangkal_petir where tahun = '"+tahunDBKB+"'");

         sql = "update pros_penangkal_petir,ref_dhkmf set aktual_harga = hrg_dhkm "
                    + "where tahun = '"+tahunDBKB+"' and thn_dhkm = '"+tahunDBKB+"'"
                    + "and id_other = kd_dhkm";    
        DBFetching.setComandToDB(sql);

        sql = "update pros_penangkal_petir set aktual_jumlah_harga = aktual_harga*model_jumlah"
                       + " where tahun = '"+tahunDBKB+"' and id_other not like '%NON%'";
        DBFetching.setComandToDB(sql);

        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_penangkal_petir where tahun = '"+tahunDBKB+"'");
           
        double jumlahLain = (totalAktualHarga/totalBobot)-totalAktualHarga;  
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = subTotal*0.1;
        double fee = subTotal*0.3;
        double totalHitung = subTotal+ppn+fee;
        double konversi = totalHitung/this.TINGGI_LANTAI; 
        
        sql = "update rslt_fasilitas set harga = "+konversi+" "
                        + "where id = 'PNR001' and tahun = '"+this.tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
    }catch(Exception e){
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
