/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.dbkb.jpb;

import id.co.meda.apit.database.connection.DBFetching;
import java.util.Stack;
import javax.swing.JProgressBar;

/**
 * Class ini untuk menghitung formulasi data
 * @author I Putu Medagia A
 */
public class fordatJpb2 implements fordatInterface {
    
    private String tahunDBKB;
    private JProgressBar progressBar;
    
    public fordatJpb2(String tahunDBKB,JProgressBar progressBar)
    {
        this.progressBar = progressBar;
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
    
    /*
     * Method untuk mengisi kolom Y dan Pol pada table pros_fordat
     */
    @Override
    public void isiYdanPol() {
        try{
            String sql = "select dbkb_kumulatif from pros_dbkb_jpb2 where tahun = '"+tahunDBKB+"'";
            Stack <Double> stY = DBFetching.getStackResult(sql,1);

            int stackSize = stY.size();
            while(!stY.isEmpty())
            {
                double temp = (double)stY.pop();
                sql = "update pros_fordat set y = "+temp+", pol = "+temp+" where jumlah_lantai = "+stackSize+""
                        + " and id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";

                DBFetching.setComandToDB(sql);


                stackSize--;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(86);
       progressBar.setString(86+"%");
    }
    
    /*
     * Method untuk mengisi kolom U pada table pros_fordat
     */
    @Override
    public void isiU() {
        try{
            String sql = "select sum(jumlah_lantai) from pros_fordat  where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            double sumDbkb = DBFetching.getDoubleResult(sql)/32;



            sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            Stack <Double> stJmlhLantai = DBFetching.getStackResult(sql,1);

            int stackSize = stJmlhLantai.size();
            while(!stJmlhLantai.isEmpty())
            {
                double temp = Double.parseDouble(stJmlhLantai.pop()+"") - sumDbkb;
                sql = "update pros_fordat set u = "+temp+" where jumlah_lantai = "+stackSize+""
                        + " and id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";

                DBFetching.setComandToDB(sql);
                stackSize--;

            }

            //forcase
           sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2f'"
                   + " and tahun = '"+tahunDBKB+"'";
           stJmlhLantai = DBFetching.getStackResult(sql,1);

           while(!stJmlhLantai.isEmpty())
            {
                double lantai = Double.parseDouble(stJmlhLantai.pop()+"");
                double temp = lantai - sumDbkb;
                sql = "update pros_fordat set u = "+temp+" where jumlah_lantai = "+lantai+""
                        + " and id_fordat = 'jpb2f'"
                        + " and tahun = '"+tahunDBKB+"'";

                DBFetching.setComandToDB(sql);
                stackSize--;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(87);
       progressBar.setString(87+"%");
    }
    
    /*
     * Method untuk mengisi LogY pada table pros_fordat
     */
    @Override
    public void isiLogY() {
        try{
            String sql = "select y from pros_fordat  where id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";
            Stack <Double> stY = DBFetching.getStackResult(sql,1);

            int stackSize = stY.size();
            while(!stY.isEmpty())
            {
                double temp = Math.log10(Double.parseDouble(stY.pop()+""));
                
                sql = "update pros_fordat set log_y = "+temp+" where jumlah_lantai = "+stackSize+""
                        + " and id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";
               
                DBFetching.setComandToDB(sql);
                stackSize--;

            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(88);
       progressBar.setString(88+"%");
    }

    /*
     * Method untuk mengisi ULogY pada table pros_fordat
     */
    @Override
    public void isiULogY() {
        try{
            String sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2'"
                         + " and tahun = '"+tahunDBKB+"'";
           Stack <Integer> stJmlhLantai = DBFetching.getStackResult(sql,1);


           while(!stJmlhLantai.isEmpty())
           {
               int temp = stJmlhLantai.pop();
               sql = "update pros_fordat set u_log_y = (u * log_y) where jumlah_lantai = "+temp+" and"
                       + " id_fordat = 'jpb2'"
                       + " and tahun = '"+tahunDBKB+"'";

               DBFetching.setComandToDB(sql);

           }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(89);
       progressBar.setString(89+"%");
    
    }
    
    /*
     * Method untuk mengisi U2 pada table pros_fordat
     */
    @Override
    public void isiU2() {
        try{
            String sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2'"
                         + " and tahun = '"+tahunDBKB+"'";
            Stack <Integer> stJmlhLantai = DBFetching.getStackResult(sql,1);

            while(!stJmlhLantai.isEmpty())
            {
               int temp = stJmlhLantai.pop();
                 sql = "update pros_fordat set u2 = (u * u) where jumlah_lantai = "+temp+""
                         + " and id_fordat = 'jpb2'"
                         + " and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);

            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(90);
       progressBar.setString(90+"%");
    }
    
    /*
     * Method untuk mengisi LogY2 pada table pros_fordat
     */
    @Override
    public void isiLogY2() {
        try{
            String sql = "select sum(log_y) from pros_fordat where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            double sumLogY = DBFetching.getDoubleResult(sql);

            sql = "select sum(u_log_y) from pros_fordat where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'"; 
            double sumULogY = DBFetching.getDoubleResult(sql);

            sql = "select sum(u2) from pros_fordat where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            double sumU2 = DBFetching.getDoubleResult(sql);
            
            System.out.println("sumLogY : "+sumLogY);
            System.out.println("sumU2 : "+sumU2);
            System.out.println("sumULogY : "+sumULogY);
            
            double logA = sumLogY/32;

            double logB = sumULogY/sumU2;
            
            
            sql = "select u from pros_fordat where id_fordat = 'jpb2'"
                    + " and tahun = '"+tahunDBKB+"'";
            Stack stU = DBFetching.getStackResult(sql,1);
            int stackSize = stU.size();

            while(!stU.isEmpty())
            {
                double temp = (double) stU.pop();
                DBFetching.setComandToDB("update pros_fordat set log_y2 = "+(logA + (logB*temp))+""
                                        + " where jumlah_lantai = "+stackSize +" and id_fordat = 'jpb2'"
                                        + " and tahun = '"+tahunDBKB+"'");
                stackSize--;
            }


             //forcase
           sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2f'"
                   + " and tahun = '"+tahunDBKB+"'";
           Stack stJmlhLantai = DBFetching.getStackResult(sql,1);

            sql = "select u from pros_fordat where id_fordat = 'jpb2f'"
                    + " and tahun = '"+tahunDBKB+"'";
            stU = DBFetching.getStackResult(sql,1);

            while(!stU.isEmpty())
            {
                double temp = (double) stU.pop();
                DBFetching.setComandToDB("update pros_fordat set log_y2 = "+(logA + (logB*temp))+""
                                        + " where jumlah_lantai = "+(int)stJmlhLantai.pop()+" and id_fordat = 'jpb2f'"
                                        + " and tahun = '"+tahunDBKB+"'");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        progressBar.setValue(91);
       progressBar.setString(91+"%");
        
    }
    
    /*
     * Method untuk mengisi Y2 dan Exp pada table pros_fordat
     */
    @Override
    public void isiY2danExp() {
        
        try{
            String sql = "select log_y2 from pros_fordat  where id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";
            Stack <Double> stLogY2 = DBFetching.getStackResult(sql,1);

            int stackSize = stLogY2.size();
            while(!stLogY2.isEmpty())
            {

                double temp = stLogY2.pop();
                
                System.out.println("temp : "+temp);
                System.out.println("Math : "+Math.pow(10,temp));
                
                sql = "update pros_fordat set y2 = "+(Math.pow(10,temp))+", exp ="+(Math.pow(10,temp))+""
                      + " where jumlah_lantai = "+stackSize+" and id_fordat = 'jpb2'"
                      + " and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);

                stackSize--;
            } 

            //forcase
            sql = "select jumlah_lantai from pros_fordat  where id_fordat = 'jpb2f'"
                   + " and tahun = '"+tahunDBKB+"'";
            Stack stJmlhLantai = DBFetching.getStackResult(sql,1);

            sql = "select log_y2 from pros_fordat  where id_fordat = 'jpb2f'"
                  + " and tahun = '"+tahunDBKB+"'";
            stLogY2 = DBFetching.getStackResult(sql,1);

            while(!stLogY2.isEmpty())
            {
                double temp = stLogY2.pop();

                sql = "update pros_fordat set y2 = "+(Math.pow(10,temp))+", exp ="+(Math.pow(10,temp))+""
                      + " where jumlah_lantai = "+(int)stJmlhLantai.pop()+" and id_fordat = 'jpb2f'"
                      + " and tahun = '"+tahunDBKB+"'";
                DBFetching.setComandToDB(sql);

            } 
        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(92);
       progressBar.setString(92+"%");
       
    }
    
    /*
     * Method untuk mengisi Diff pada table pros_fordat
     */
    @Override
    public void isiDiff() {
        try{
            String sql = "select exp from pros_fordat  where id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";
            Stack stPol = DBFetching.getStackResult(sql,1);
            stPol.push(0.0);
            int stackSize = stPol.size();

            while(stackSize != 1)
            {
                double tempA = (double)stPol.pop();
                double tempB = (double)stPol.pop();


                sql = "update pros_fordat set diff = "+(tempA-tempB)+" where jumlah_lantai = "+stackSize+" and id_fordat = 'jpb2'"
                        + " and tahun = '"+tahunDBKB+"'";

                DBFetching.setComandToDB(sql);
                stPol.push(tempB);
                stackSize--;
            }

        }catch(Exception e)
        {
            e.printStackTrace();
            DBFetching.RollBackDB();
        }
        
        progressBar.setValue(93);
       progressBar.setString(93+"%");
    }

    public void done()
    {
        DBFetching.Simpan();
    }
   
    
}
