/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb.jpb1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import id.co.meda.apit.database.connection.DBFetching;
import javax.swing.JProgressBar;

/**
 *
 * @author I Putu Medagia A
 */

public class JPB1 {
    private String thnDBKB;
    private final Double lsBngModel = 37.0;
    private Double nilTot;
    private Double nilPPNFee;
    private Double nilIMB;
    private Double nilTotAfterPPN;
    private Double nilSatuan;

    private final Double lsBngModelLt2to4 = 1312.0;
    private Double preliminaries;
    private Double nilTotLt2to4;
    private Double nilTotLt2to4NonPrel;
    private Double nilPPNFeeLt2to4;
    private Double nilIMBLt2to4;
    private Double nilTotAfterPPNLt2to4;
    private Double nilSatuanLt2to4;
    private Double nilPre3;
    private Double nilPre2,nilPre4;
    private Double nilSub2, nilSub3, nilSub4;
    private Double nilStr2, nilStr3, nilStr4;
    private Double nilTot2, nilTot3, nilTot4;
    private Double nilArea2, nilArea3, nilArea4;
    private Double nilDBKB2, nilDBKB3, nilDBKB4;
    private ArrayList <String> prosJpb1Lt1strfin,prosJpb1Lt1kdJpb,
                prosJpb1Lt1QtJpb,prosJpb1Lt1stat,prosJpb1Lt1hrgTot;
    
    JProgressBar progressBar;

    public JPB1(String tahunDBKB,JProgressBar progressBar) {
        thnDBKB = tahunDBKB;
        this.progressBar = progressBar;
        DBFetching.setAutoCommit(false);
    }
    
    public void hitungJPB1Lt1(){
        
        String sql = "";
        try{
            sql = "SELECT*FROM pros_jpb1_lt1 where convert(substr(kd_jpb1lt1,2,2),signed) > 0 and convert(right(kd_jpb1lt1,2),signed) > 0 "
                            + " and tahun_jpb1lt1 = '"+thnDBKB+"'";

            prosJpb1Lt1strfin = DBFetching.getArrayListStringResult(sql,7);
            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);
            prosJpb1Lt1QtJpb = DBFetching.getArrayListStringResult(sql,4);


            for(int i = 0; i < prosJpb1Lt1strfin.size(); i++)
            {
                 Double hrgDhkm1 = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf where kd_dhkm='"
                        + prosJpb1Lt1strfin.get(i).trim() +"' and thn_dhkm='"+thnDBKB+"'");
                 
                 DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_tot="+(hrgDhkm1*Double.parseDouble(prosJpb1Lt1QtJpb.get(i)))
                        +" where kd_jpb1lt1='" + prosJpb1Lt1kdJpb.get(i) + "'"
                          + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            }




            DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=(462.5*vol_jpb1lt1) where kd_jpb1lt1='A000001'"
                                      + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=(5000*vol_jpb1lt1) where kd_jpb1lt1='A000002'"
                                      + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=(2500*vol_jpb1lt1) where kd_jpb1lt1='A000003'"
                                      + " and tahun_jpb1lt1 = '"+thnDBKB+"'");

            //List<ProsJpb1Lt1> prosJpb1Lt1d = urDB.queryNativePakeKelas(ProsJpb1Lt1.class, "SELECT * FROM pros_jpb1_lt1 where kd_jpb1lt1 in ('B000001','B000002','B000003','B000004','B000005','B000006')");
            sql = "SELECT * FROM pros_jpb1_lt1 where kd_jpb1lt1 in ('B000001','B000002','B000003','B000004','B000005','B000006')"
                     + " and tahun_jpb1lt1 = '"+thnDBKB+"'";
            prosJpb1Lt1strfin = DBFetching.getArrayListStringResult(sql,7);
            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);
            prosJpb1Lt1stat = DBFetching.getArrayListStringResult(sql,6);

            for (int i = 0; i < prosJpb1Lt1kdJpb.size(); i++ ) {
                Double hrgTot = 0.0;

                if (prosJpb1Lt1stat.get(i).trim().equals("SAT")) {
                    hrgTot = DBFetching.getDoubleResult("select hrg_sat from pros_hsat where kd_hsat='"+prosJpb1Lt1strfin.get(i).trim()+"'"
                                                         + " and tahun = '"+thnDBKB+"'");
                }

                if (prosJpb1Lt1stat.get(i).trim().equals("STR")) {
                    hrgTot = DBFetching.getDoubleResult("select hrg_tot from pros_hsku where kd_hsku='"+prosJpb1Lt1strfin.get(i).trim()+"'"
                                                         + " and tahun = '"+thnDBKB+"'");
                }
                if (prosJpb1Lt1kdJpb.get(i).trim().equals("B000003")) {
                    hrgTot = DBFetching.getDoubleResult("select sum(hrg_sat) hrg_sat from pros_hsku where kd_hsku in ('B120001','B120002')"
                                                         + " and tahun = '"+thnDBKB+"'");
                }

                DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot="+hrgTot+"*vol_jpb1lt1 where kd_jpb1lt1='"
                        +prosJpb1Lt1kdJpb.get(i)+"'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
              }

        


           sql = "select substr(kd_jpb1lt1,1,3) kd_jpb1lt1, sum(hrg_tot) hrg_tot from pros_jpb1_lt1\n" +
            "where kd_jpb1lt1 in (select kd_jpb1lt1 from pros_jpb1_lt1 \n" +
            "where convert(substr(kd_jpb1lt1,2,2),signed) > 0 and convert(right(kd_jpb1lt1,2),signed)>0 and substr(kd_jpb1lt1,1,1)='B')\n" +
            "group by substr(kd_jpb1lt1,1,3)"
                   + " and tahun_jpb1lt1 = '"+thnDBKB+"'";



            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);
            prosJpb1Lt1hrgTot = DBFetching.getArrayListStringResult(sql,2);
            
            
            for (int i = 0; i < prosJpb1Lt1kdJpb.size(); i++)
            {
                DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+prosJpb1Lt1hrgTot.get(i)
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i)+"0000'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
                /*
                 System.out.println("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+prosJpb1Lt1hrgTot.get(i)
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i)+"0000'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
                */
            }
            
            
            /*untuk B*/
            sql = "select substr(kd_jpb1lt1,1,3) kd_jpb1lt1, "
                    + "sum(hrg_tot) hrg_tot from pros_jpb1_lt1 where kd_jpb1lt1 like '%B01%' and "
                    + "tahun_jpb1lt1 = '"+thnDBKB+"';";



            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);
            prosJpb1Lt1hrgTot = DBFetching.getArrayListStringResult(sql,2);
            
            
            for (int i = 0; i < prosJpb1Lt1kdJpb.size(); i++)
            {
                DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+prosJpb1Lt1hrgTot.get(i)
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i)+"0000'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
                
                System.out.println("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+prosJpb1Lt1hrgTot.get(i)
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i)+"0000'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
            
        progressBar.setValue(42);
        progressBar.setString(42+"%");
       /* untuk kasus C */
        
        try{
            sql = "select kd_jpb1lt1 from pros_jpb1_lt1 where kd_jpb1lt1 like '%C%'"
                    + " and tahun_jpb1lt1 = '"+thnDBKB+"'";
            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);

            for (int i = 0; i < prosJpb1Lt1kdJpb.size(); i++)
            {

                String a = DBFetching.getStringResult("select distinct sum(hrg_tot) hrg_tot from pros_jpb1_lt1 where kd_jpb1lt1 like '%C%' and \n" +
                                "kd_jpb1lt1 like '%"+prosJpb1Lt1kdJpb.get(i).substring(0,5)+"%' "
                                + " and tahun_jpb1lt1 = '"+thnDBKB+"'",1);

                DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+a
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i).substring(0,5)+"00'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            }

            sql = "select substr(kd_jpb1lt1,1,5) kd_jpb1lt1, sum(hrg_tot) hrg_tot from pros_jpb1_lt1 where convert(substr(kd_jpb1lt1,4,2),signed)>0 \n" +
            "and convert(right(kd_jpb1lt1,2),signed)>0 group by substr(kd_jpb1lt1,1,5)"
                   + " and tahun_jpb1lt1 = '"+thnDBKB+"'";

            prosJpb1Lt1kdJpb = DBFetching.getArrayListStringResult(sql,1);
            prosJpb1Lt1hrgTot = DBFetching.getArrayListStringResult(sql,2);

            for (int i = 0; i < prosJpb1Lt1kdJpb.size(); i++)
            {
                DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+prosJpb1Lt1hrgTot.get(i)
                        +" where kd_jpb1lt1='"+prosJpb1Lt1kdJpb.get(i)+"'"
                        + " and tahun_jpb1lt1 = '"+thnDBKB+"'");
            }



            String kdStrfin = DBFetching.getStringResult("select kd_strfin from pros_jpb1_lt1 where kd_jpb1lt1='C030000'"
                                                         + " and tahun_jpb1lt1 = '"+thnDBKB+"'",1);

            Double hrgTot = DBFetching.getDoubleResult("select hrg_tot from pros_hsku where kd_hsku='"+ kdStrfin +"'"
                                                        + " and tahun = '"+thnDBKB+"'");

            DBFetching.setComandToDB("update pros_jpb1_lt1 set hrg_grtot=vol_jpb1lt1*"+hrgTot+" where kd_jpb1lt1='C030000'"
                                     + " and tahun_jpb1lt1 = '"+thnDBKB+"'");

            nilTot = DBFetching.getDoubleResult("select sum(hrg_grtot) from pros_jpb1_lt1"
                                                + " where tahun_jpb1lt1 = '"+thnDBKB+"'");
            
            
            
            nilPPNFee = 0.2*nilTot;  nilIMB = 0.02*nilTot; nilTotAfterPPN = nilTot+nilPPNFee+nilIMB;
            nilSatuan = nilTotAfterPPN/lsBngModel; 
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(44);
        progressBar.setString(44+"%");
        
    }
    
    public void hitungTabelJPB1Lt1() {
       
        try{
            Double jmlRec = DBFetching.getDoubleResult("select count(*) from rslt_jpb1_lt1 where thn_dbkb = '"+thnDBKB+"'");
            
            
            if (jmlRec > 0) {
               DBFetching.setComandToDB("delete from rslt_jpb1_lt1 where thn_dbkb ='" + thnDBKB + "'");
            }
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(1,'"+thnDBKB+"','1','69',"
                    +nilSatuan+","+(nilSatuan*1.13)+","+(nilSatuan*1.1)+","+(nilSatuan*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(2,'"+thnDBKB+"','70','99',"
                    +(nilSatuan*1.3)+","+(nilSatuan*1.3*1.13)+","+(nilSatuan*1.3*1.1)+","+(nilSatuan*1.3*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(3,'"+thnDBKB+"','100','149',"
                    +(nilSatuan*1.34)+","+(nilSatuan*1.34*1.13)+","+(nilSatuan*1.34*1.1)+","+(nilSatuan*1.34*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(4,'"+thnDBKB+"','150','224',"
                    +(nilSatuan*1.56)+","+(nilSatuan*1.56*1.13)+","+(nilSatuan*1.56*1.1)+","+(nilSatuan*1.56*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(5,'"+thnDBKB+"','225','299',"
                    +(nilSatuan*1.8)+","+(nilSatuan*1.8*1.13)+","+(nilSatuan*1.8*1.1)+","+(nilSatuan*1.8*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(6,'"+thnDBKB+"','300','449',"
                    +(nilSatuan*1.93)+","+(nilSatuan*1.93*1.13)+","+(nilSatuan*1.93*1.1)+","+(nilSatuan*1.93*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(7,'"+thnDBKB+"','450','549',"
                    +(nilSatuan*2.05)+","+(nilSatuan*2.05*1.13)+","+(nilSatuan*2.05*1.1)+","+(nilSatuan*2.05*0.948)+")");
            DBFetching.setComandToDB("insert into rslt_jpb1_lt1 values(8,'"+thnDBKB+"','550','99999',"
                    +(nilSatuan*2.11)+","+(nilSatuan*2.11*1.13)+","+(nilSatuan*2.11*1.1)+","+(nilSatuan*2.11*0.948)+")");

            DBFetching.setComandToDB("update rslt_jpb1_lt1 set beton=round(beton),kayu=round(kayu), baja=round(baja), bata=round(bata) "
                                     + " where thn_dbkb ='" + thnDBKB + "'");
       }catch(Exception e)
       {
            e.printStackTrace();
            DBFetching.RollBackDB();
       }
        progressBar.setValue(45);
        progressBar.setString(45+"%");
    }
    
    public void hitungJPB1Lt2to4()
    {
         String sql = "";
        try{
            ArrayList <String> sat_kd,sat_kdstrfin,sat_vol;

            sql = "select kd_jpb1lt2to4,kd_strfin,vol_jpb1lt2to4 from pros_jpb1_lt2to4 where stat_jpb1lt2to4 = 'SAT'"
                           + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'";   
            sat_kd = DBFetching.getArrayListStringResult(sql,1);
            sat_kdstrfin = DBFetching.getArrayListStringResult(sql,2);
            sat_vol = DBFetching.getArrayListStringResult(sql,3);

            String total = "0";

            for(int i = 0; i < sat_kdstrfin.size(); i++)
            {  

               total = DBFetching.getStringResult ("select hrg_sat from pros_hsat where kd_hsat='"+sat_kdstrfin.get(i).trim()+"'"
                                                    + " and tahun = '"+thnDBKB+"'" ,1);
               
               Double a =Double.parseDouble(total)*Double.parseDouble(sat_vol.get(i));
              DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_tot= "+a+" where kd_jpb1lt2to4 ='"+sat_kd.get(i)+"'"
                                       + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
            }

             ArrayList <String> str_kd,str_kdstrfin,str_vol;

            sql = "select kd_jpb1lt2to4,kd_strfin,vol_jpb1lt2to4 from pros_jpb1_lt2to4 where stat_jpb1lt2to4 = 'STR'"
                    + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'";   
            
            str_kd = DBFetching.getArrayListStringResult(sql,1);
            str_kdstrfin = DBFetching.getArrayListStringResult(sql,2);
            str_vol = DBFetching.getArrayListStringResult(sql,3);

            total = "0";

            for(int i = 0; i < str_kdstrfin.size(); i++)
            {  

               total = DBFetching.getStringResult ("select hrg_tot from pros_hsku where kd_hsku='"+str_kdstrfin.get(i).trim()+"'"
                                                   + " and tahun = '"+thnDBKB+"'",1);
               
               Double a = Double.parseDouble(total)*Double.parseDouble(str_vol.get(i));
               
               
               DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_tot= "+a+" where kd_jpb1lt2to4 ='"+str_kd.get(i)+"'"
                                       + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
            }
       Double nilA = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4 where substr(kd_jpb1lt2to4,1,1)='A' "
                   + "and convert(right(kd_jpb1lt2to4,2),signed)>0"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_grtot="+nilA+" where kd_jpb1lt2to4='A000000'"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           nilA = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4 where substr(kd_jpb1lt2to4,1,3)='B01' "
                   + "and convert(right(kd_jpb1lt2to4,2),signed)>0"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_grtot="+nilA+" where kd_jpb1lt2to4='B010000'"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           nilA = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4 where substr(kd_jpb1lt2to4,1,3)='B02' "
                   + "and convert(right(kd_jpb1lt2to4,2),signed)>0"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_grtot="+nilA+" where kd_jpb1lt2to4='B020000'"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           nilA = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4 where substr(kd_jpb1lt2to4,1,3)='B03' "
                   + "and convert(right(kd_jpb1lt2to4,2),signed)>0"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_grtot="+nilA+" where kd_jpb1lt2to4='B030000'"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           nilA = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4 where substr(kd_jpb1lt2to4,1,3)='B04' "
                   + "and convert(right(kd_jpb1lt2to4,2),signed)>0"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
           DBFetching.setComandToDB("update pros_jpb1_lt2to4 set hrg_grtot="+nilA+" where kd_jpb1lt2to4='B040000'"
                   + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
        
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(46);
        progressBar.setString(46+"%");
       
       try{
                double nilTotLt2to4NonPrel = DBFetching.getDoubleResult("select sum(hrg_tot) from pros_jpb1_lt2to4"
                                                                         + " where tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                double preliminaries = nilTotLt2to4NonPrel*0.0075;
                double nilTotLt2to4 = nilTotLt2to4NonPrel+preliminaries;
                double  nilPPNFeeLt2to4 = 0.2*nilTotLt2to4;
                double nilIMBLt2to4 = 0.02*nilTotLt2to4;
                double nilTotAfterPPNLt2to4 = nilTotLt2to4+nilPPNFeeLt2to4+nilIMBLt2to4;
                double nilSatuanLt2to4 = nilTotAfterPPNLt2to4/lsBngModelLt2to4;
                
                //System.out.println("nil: "+nilTotLt2to4NonPrel+"  "+preliminaries);

                 nilPre2 = DBFetching.getDoubleResult("select sum(hrg_grtot)*0.0075 from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('A000000','B010000','B020000') "
                                                     + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                 nilPre3 = DBFetching.getDoubleResult("select sum(hrg_grtot)*0.0075 from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('A000000','B010000','B020000','B030000')"
                                                     + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                 nilPre4 = DBFetching.getDoubleResult("select sum(hrg_grtot)*0.0075 from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('A000000','B010000','B020000','B030000','B040000')"
                                                     + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");

                 double nilaiSub3 = DBFetching.getDoubleResult("select hrg_grtot from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('A000000')"
                                                                + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");

                 double nilaiSTR1 = DBFetching.getDoubleResult("select sum(hrg_grtot) from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('B010000','B020000')"
                                                                 + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                 double nilaiSTR2 = DBFetching.getDoubleResult("select sum(hrg_grtot) from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('B010000','B020000','B030000')"
                                                                 + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                 double nilaiSTR3 = DBFetching.getDoubleResult("select sum(hrg_grtot) from pros_jpb1_lt2to4 where kd_jpb1lt2to4 in ('B010000','B020000','B030000','B040000')"
                                                                 + " and tahun_jpb1lt2to4 = '"+thnDBKB+"'");
                 double divider = nilaiSub3/nilaiSTR3;

                double nilaiSub2 = (nilaiSTR2*nilaiSub3)/nilaiSTR3;

                 double nilaiSub1 = (nilaiSTR1*nilaiSub3)/nilaiSTR3;

                 double hrgtot1 = (nilaiSub1+nilaiSTR1+nilPre2)*1.22;
                 double hrgtot2 = (nilaiSub2+nilaiSTR2+nilPre3)*1.22;
                 double hrgtot3 = (nilaiSub3+nilaiSTR3+nilPre4)*1.22;



                 double luas3 = 1312;
                 double luas2 = luas3 - 303;
                 double luas1 = luas2 - 303;

                 double dbkb3 = hrgtot3/luas3;
                 double dbkb2 = hrgtot2/luas2;
                 double dbkb1 = hrgtot1/luas1;


          sql = "select id_jpb1lt2,faktor from rslt_jpb1_lt2 where ls_min != 650 "
                  + " and thn_dbkb = '"+thnDBKB+"'";
          ArrayList <Double> faktor_rslt = DBFetching.getArrayListDoubleResult(sql,2);
          ArrayList <String> idjpb = DBFetching.getArrayListStringResult(sql,1);

           int size = faktor_rslt.size()-2;


          DBFetching.setComandToDB("update rslt_jpb1_lt2 set beton ="+dbkb2+"where ls_max > 650 and thn_dbkb = "+thnDBKB+"");
          DBFetching.setComandToDB("update rslt_jpb1_lt2 set beton ="+dbkb1+"where ls_max < 650 and ls_max > 450 and thn_dbkb = "+thnDBKB+"");
          DBFetching.setComandToDB("update rslt_jpb1_lt2 set kayu = beton*1.8, baja = beton*1.31 where ls_max > 450 and thn_dbkb = "+thnDBKB+"");       

          for (int i = size; i >= 0; i--)
             {

                 double temp = faktor_rslt.get(i)/faktor_rslt.get(i+1);
                 double hrg = DBFetching.getIntegerResult("select beton from rslt_jpb1_lt2 where id_jpb1lt2 ="
                         +idjpb.get(i+1)+""
                          + " and thn_dbkb ='" + thnDBKB + "'");
                 double fin =  temp*hrg;
                 DBFetching.setComandToDB("update rslt_jpb1_lt2 set beton = "+fin+",kayu = beton*1.8, baja = beton*1.31 where id_jpb1lt2 = "+idjpb.get(i)+" and thn_dbkb = "+thnDBKB+"");

             }
     }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
       progressBar.setValue(48);
       progressBar.setString(48+"%");
 
 }
    

public void done()
{
    DBFetching.Simpan();
}







}
