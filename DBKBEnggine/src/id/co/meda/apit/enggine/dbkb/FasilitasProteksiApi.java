/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;

/**
 *
 * @author I Putu Medagia A
 */
public class FasilitasProteksiApi {
    
    private String tahunDBKB;
    private final double LUAS_LANTAI_TOTAL = 106884;
    private final double TINGGI_LANTAI = 29;
    private final double LUAS_PERLANTAI = 3686;
    
    public FasilitasProteksiApi(String tahunDBKB)
    {
        DBFetching.setAutoCommit(false);
        this.tahunDBKB = tahunDBKB;
    }
    
    public void prosesHydrant()
    {
        try{
        String sql = "update pros_proteksi_api set model_harga_tetap = (model_harga*model_jumlah_tetap) "
                + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set model_harga_berubah_hydrant = (model_harga*model_jumlah_berubah_perlt)"
               + " where tahun = '"+tahunDBKB+"' and id in('PAH007','PAH009','PAH012')";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set model_harga_berubah_sprinkle = (model_harga*model_jumlah_berubah_perlt)"
               + " where tahun = '"+tahunDBKB+"' and id in('PAH008','PAH010','PAH012')";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set model_jumlah_harga = "
               + "(model_harga_tetap+model_harga_berubah_hydrant+model_harga_berubah_sprinkle)"
               + " where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double totalJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_proteksi_api "
                + "where tahun = '"+tahunDBKB+"'");
        
        sql = "update pros_proteksi_api set model_bobot = (model_jumlah_harga/"+totalJumlahHarga+") where id not in"
              + "('PAH001','PAH003','PAH005','PAH012') and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api,ref_dhkmf set aktual_harga = hrg_dhkm where id = kd_dhkm and "
              + " thn_dhkm = '"+tahunDBKB+"' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set aktual_jmlhharga_tetap = (aktual_harga*model_jumlah_tetap) "
              + "where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set aktual_jmlhharga_berubah_hydrant = (aktual_harga*model_jumlah_berubah_perlt)"
               + " where tahun = '"+tahunDBKB+"' and id in('PAH007','PAH009','PAH012')";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api set aktual_jmlhharga_berubah_sprinkle = (aktual_harga*model_jumlah_berubah_perlt)"
               + " where tahun = '"+tahunDBKB+"' and id in('PAH008','PAH010','PAH012')";
        DBFetching.setComandToDB(sql);
        
        
        double jumlahModelHargaTetap = DBFetching.getDoubleResult("select sum(model_harga_tetap) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahModelHargaHydrant = DBFetching.getDoubleResult("select sum(model_harga_berubah_hydrant) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahModelHargaSprinkle = DBFetching.getDoubleResult("select sum(model_harga_berubah_sprinkle) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahModelJumlahHarga = DBFetching.getDoubleResult("select sum(model_jumlah_harga) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahModelBobot = DBFetching.getDoubleResult("select sum(model_bobot) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahAktualHargaTetap = DBFetching.getDoubleResult("select sum(aktual_jmlhharga_tetap) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahAktualHargaHydrant = DBFetching.getDoubleResult("select sum(aktual_jmlhharga_berubah_hydrant) "
                                        + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        double jumlahAktualHargaSprinkle = DBFetching.getDoubleResult("select sum(aktual_jmlhharga_berubah_sprinkle) "
                                           + "from pros_proteksi_api where tahun = '"+tahunDBKB+"'");
        
        //------------hitungan dan update----------------//
        
        double jumlahKomp = jumlahAktualHargaTetap+jumlahAktualHargaHydrant+jumlahAktualHargaSprinkle;
        double jumlahLain = (jumlahKomp/jumlahModelBobot) - jumlahKomp;
        double jumlahSubTotal = jumlahKomp+jumlahLain;
        double jumlahPpn = jumlahSubTotal*0.1;
        double jumlahFee = jumlahSubTotal*0.3;
        double jumlahTotal = jumlahSubTotal+jumlahPpn+jumlahFee;
        
        double perbHydrant = jumlahModelHargaHydrant/(jumlahModelHargaHydrant+jumlahModelHargaSprinkle);
        double perbSprinkle = jumlahModelHargaSprinkle/(jumlahModelHargaHydrant+jumlahModelHargaSprinkle);
        
        double perbHargaHydrant = jumlahTotal*perbHydrant;
        double perbHargaSprinkle = jumlahTotal*perbSprinkle;
        
        double konversiHydrant = perbHargaHydrant/this.LUAS_LANTAI_TOTAL;
        double konversiSprinkle = perbHargaSprinkle/this.LUAS_LANTAI_TOTAL;
        
        sql = "update rslt_fasilitas set harga = "+konversiHydrant+" where id = 'FAP001' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update rslt_fasilitas set harga = "+konversiSprinkle+" where id = 'FAP002' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            System.exit(1);
        }    
    }
    
    public void prosesAlarmInterkom()
    {
        try{
            
        String sql = "update pros_proteksi_api_lain,ref_dhkmf set aktual_harga = hrg_dhkm where id = kd_dhkm and "
              + " thn_dhkm = '"+tahunDBKB+"' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set model_jumlah_berubah_total = (model_jumlah_berubah_perlt*"+this.TINGGI_LANTAI+")"
              + " where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set model_total_jumlah = (model_jumlah_berubah_total+model_jumlah_tetap)"
              +" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set model_harga_tetap = (model_harga*model_jumlah_tetap)"
              +" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set model_harga_berubah_perlt = (model_harga*model_jumlah_berubah_perlt)"
              +" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set model_jumlah_harga = (model_harga_tetap+model_harga_berubah_total)"
              +" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        double sumJumlahHargaAlarm = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_proteksi_api_lain"
                                                                +" where tahun = '"+tahunDBKB+"' and "
                                                                +" id like '%PAA%'");
        
        double sumJumlahHargaInterkom = DBFetching.getDoubleResult("select sum(model_jumlah_harga) from pros_proteksi_api_lain"
                                                                +" where tahun = '"+tahunDBKB+"' and "
                                                                +" id like '%PAI%'");            
        
        System.out.println("alarm = "+sumJumlahHargaAlarm);
        System.out.println("Interkom = "+sumJumlahHargaInterkom);
        
        //---------update bobot Alarm---//
        sql = "update pros_proteksi_api_lain set model_bobot = (model_jumlah_harga/"+sumJumlahHargaAlarm+")"
              +" where tahun = '"+tahunDBKB+"' and id in('PAA002','PAA004','PAA005','PAA007','PAA010')";
        DBFetching.setComandToDB(sql);
        
        //---------update bobot Interkom---//
        sql = "update pros_proteksi_api_lain set model_bobot = (model_jumlah_harga/"+sumJumlahHargaInterkom+")"
              +" where tahun = '"+tahunDBKB+"' and id in('PAI001','PAI002','PAI004')";
        DBFetching.setComandToDB(sql);
        
        sql = "update pros_proteksi_api_lain set aktual_jumlah_harga = (aktual_harga*model_total_jumlah)"
              +" where tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        //proses alarm
        double jumlahBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_proteksi_api_lain "
                                                            + "where tahun = '"+tahunDBKB+"'"
                                                            + " and id like '%PAA%'");
        double totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_proteksi_api_lain "
                                                            + "where tahun = '"+tahunDBKB+"'"
                                                            + " and id like '%PAA%'");    
        double jumlahLain = (totalAktualHarga/jumlahBobot)-totalAktualHarga;
        double subTotal = totalAktualHarga+jumlahLain;
        double ppn = 0.1*subTotal;
        double total = subTotal+ppn;
        double konversi = total/this.LUAS_LANTAI_TOTAL; 
        
        //update fasilitas alarm
        sql = "update rslt_fasilitas set harga = "+konversi+"where id = 'FAP003' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        //proses interkom
        jumlahBobot = DBFetching.getDoubleResult("select sum(model_bobot) from pros_proteksi_api_lain "
                                                            + "where tahun = '"+tahunDBKB+"'"
                                                            + " and id like '%PAI%'");    
        totalAktualHarga = DBFetching.getDoubleResult("select sum(aktual_jumlah_harga) from pros_proteksi_api_lain "
                                                            + "where tahun = '"+tahunDBKB+"'"
                                                            + " and id like '%PAI%'");
        jumlahLain = (totalAktualHarga/jumlahBobot)-totalAktualHarga;
        subTotal = totalAktualHarga+jumlahLain;
        ppn = 0.1*subTotal;
        total = subTotal+ppn;
        konversi = total/this.TINGGI_LANTAI; 
        
        //update fasilitas interkom
        sql = "update rslt_fasilitas set harga = "+konversi+"where id = 'FAP004' and tahun = '"+tahunDBKB+"'";
        DBFetching.setComandToDB(sql);
        
        
        
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            System.exit(1);
        }
    }
   
    public void done()
    {
        DBFetching.Simpan();
    }
}
