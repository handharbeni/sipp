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
public class FasilitasLift {
    private final int TINGGI_LANTAI = 32;
    private final int TINGGI_LANTAI_LIFT = 18;
    private final double LUAS_TOTAL = 34225;
    private double konversiPassenger = 0;
    private double konversiService = 0;
    private String tahunDBKB;
    
    public FasilitasLift(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
    
    public void prosesPasenggerLift()
    {
        try{
            String sql = "update pros_flift set model_jmlhharga = (model_harga*model_jumlah) "
                        + "where id_lift like '%PL%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalJumlahPasengger = DBFetching.getDoubleResult("select sum(model_jmlhharga) from pros_flift "
                                                                    + "where id_lift like '%PL%' "
                                                                    + "and tahun = '"+tahunDBKB+"'");

            sql = "update pros_flift set model_bobot = (model_jmlhharga/"+totalJumlahPasengger+")/100 "
                        + "where id_lift like '%PL%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalBobotPassenger = DBFetching.getDoubleResult("select sum(model_bobot) from pros_flift "
                                                                    + "where id_lift like '%PL%' "
                                                                    + "and tahun = '"+tahunDBKB+"'");

             sql = "update pros_flift,ref_dhkmf set aktual_harga = hrg_dhkm where kd_dhkm = id_other "
                   +" and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'"
                   +" and pros_flift.tahun = '"+tahunDBKB+"'"
                   +" and id_lift like '%PL%'";
             DBFetching.setComandToDB(sql);

             sql = "update pros_flift set aktual_jmlhharga = (aktual_harga*model_jumlah) "
                        + "where id_lift like '%PL%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "select sum(aktual_jmlhharga) from pros_flift where"
                   +" pros_flift.tahun = '"+tahunDBKB+"'"
                   +" and id_lift like '%PL%'";
            
            double totalHargaAktual = DBFetching.getDoubleResult(sql);
            double jumlahLain = (totalHargaAktual/totalBobotPassenger) - totalHargaAktual;
            double subTotal = jumlahLain + totalHargaAktual;
            double ppn = subTotal*0.1;
            double fee = subTotal*0.3;
            double total = subTotal+ppn+fee;
            this.konversiPassenger = total;
            
            
            
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void prosesServiceLift()
    {
        try{
            String sql = "update pros_flift set model_jmlhharga = (model_harga*model_jumlah) "
                        + "where id_lift like '%PS%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalJumlahService = DBFetching.getDoubleResult("select sum(model_jmlhharga) from pros_flift "
                                                                    + "where id_lift like '%PS%' "
                                                                    + "and tahun = '"+tahunDBKB+"'");
            sql = "update pros_flift set model_bobot = (model_jmlhharga/"+totalJumlahService+")/100 "
                        + "where id_lift like '%PS%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            double totalBobotService = DBFetching.getDoubleResult("select sum(model_bobot) from pros_flift "
                                                                    + "where id_lift like '%PS%' "
                                                                    + "and tahun = '"+tahunDBKB+"'");

             sql = "update pros_flift,ref_dhkmf set aktual_harga = hrg_dhkm where kd_dhkm = id_other "
                   +" and ref_dhkmf.thn_dhkm = '"+tahunDBKB+"'"
                   +" and pros_flift.tahun = '"+tahunDBKB+"'"
                   +" and id_lift like '%PS%'";
            DBFetching.setComandToDB(sql);

             sql = "update pros_flift set aktual_jmlhharga = (aktual_harga*model_jumlah) "
                        + "where id_lift like '%PS%' and tahun = '"+tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
            
            sql = "select sum(aktual_jmlhharga) from pros_flift "
                   +"where pros_flift.tahun = '"+tahunDBKB+"'"
                   +" and id_lift like '%PS%'";
            
            double totalHargaAktual = DBFetching.getDoubleResult(sql);
            double jumlahLain = (totalHargaAktual/totalBobotService) - totalHargaAktual;
            double subTotal = jumlahLain + totalHargaAktual;
            double ppn = subTotal*0.1;
            double fee = subTotal*0.3;
            double total = subTotal+ppn+fee;
            this.konversiService = total;
            
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            e.printStackTrace();
            System.exit(1);
        }
        
    }
    
    public void prosesBandingLift()
    {
        try{
            double basePassenger = DBFetching.getDoubleResult("select biaya from pros_fliftbanding where id_lift = 'PL003' and "
                                                             + "tahun = '"+this.tahunDBKB+"'");
            double baseService = DBFetching.getDoubleResult("select biaya from pros_fliftbanding where id_lift = 'PS003' and "
                                                             + "tahun = '"+this.tahunDBKB+"'");


            //update passenger
            String sql = "update pros_fliftbanding set bobot = (biaya/"+basePassenger+")/100 "
                         + "where id_lift like '%PL%' and "
                         + "tahun = '"+this.tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            sql = "update pros_fliftbanding set harga = bobot*"+this.konversiPassenger+" "
                         + "where id_lift like '%PL%' and "
                         + "tahun = '"+this.tahunDBKB+"'";
            DBFetching.setComandToDB(sql);


            //update service
            sql = "update pros_fliftbanding set bobot = (biaya/"+baseService+")/100 "
                         + "where id_lift like '%PS%' and "
                         + "tahun = '"+this.tahunDBKB+"'";
            DBFetching.setComandToDB(sql);

            sql = "update pros_fliftbanding set harga = bobot*"+this.konversiService+" "
                         + "where id_lift like '%PS%' and "
                         + "tahun = '"+this.tahunDBKB+"'";
            DBFetching.setComandToDB(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
            System.exit(1);
        }
            
    }
    
    public void prosesResultLift()
    {
        try{
            String sql = "select harga from pros_fliftbanding where tahun = '"+tahunDBKB+"'";
            Stack<Double> stackLift = DBFetching.getStackResult(sql,1);

            sql = "select id from rslt_fasilitas where id like '%FL%' "
                    + "and id not like '%FLS000%' "
                    + "and id not like '%FLP000%' "
                    + "and tahun = '"+tahunDBKB+"'";
            Stack<Double> idStackLift = DBFetching.getStackResult(sql,1);

            //Proses Lift
            while(!stackLift.isEmpty())
            {
                sql = "update rslt_fasilitas set Harga = "+stackLift.pop()+" where id = '"+idStackLift.pop()+"'";
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
