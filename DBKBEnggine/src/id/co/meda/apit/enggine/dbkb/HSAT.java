package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk menghitung Harga Satuan
 * @author I Putu Medagia A
 */
public class HSAT {
    
    private String tahunDBKB;
    
    /**
     * Constructor class HSKM
     * @param tahunDBKB untuk inisiasi tahun perhitungan DBKB 
     */
    public HSAT(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
        DBFetching.setAutoCommit(false);
    }
    
    public void store(ArrayList<String>kdStrFin)
    {
        String sql = "select kd_hsku,hrg_komp,hrg_upah,hrg_tot from pros_hsku "
                        + "where kd_hsku like'%0000%' and hrg_tot != 0 and tahun like '%"+tahunDBKB+"%'";
        
        ArrayList<String> arrKd = new ArrayList<String>();
        ArrayList<String> arrMat = new ArrayList<String>();
        ArrayList<String> arrUpah = new ArrayList<String>();
        ArrayList<String> arrTotal = new ArrayList<String>();
        
        //proses menghitung harga Material,Upah,dan harga satuan
        try{
            arrKd = DBFetching.getArrayListStringResult(sql,1);
            arrMat = DBFetching.getArrayListStringResult(sql,2);
            arrUpah = DBFetching.getArrayListStringResult(sql,3);
            arrTotal = DBFetching.getArrayListStringResult(sql,4);

            for(int a = 0; a < kdStrFin.size(); a++)
            {
                for(int b = 0; b < arrKd.size(); b++){
                    if (arrKd.get(b).equals(kdStrFin.get(a)))
                    {
                      DBFetching.setComandToDB("update pros_hsat set hrg_mat = "+ arrMat.get(b) 
                                                   +", hrg_upah = "+ arrUpah.get(b) + ", hrg_sat = hrg_upah + hrg_mat" 
                                                + " where stat_strfin like '%STR%' and kd_strfin like '%" 
                                                    + kdStrFin.get(a)+"%' and tahun = '"+tahunDBKB+"'" );
                    }
                }
             }
            String sql2 = "select kd_hskm,hrg_komp,hrg_upah,hrg_tot from pros_hskm "
                           + "where kd_hskm like'%0000%' and hrg_tot != 0 and tahun like '%"+tahunDBKB+"%'";
            arrKd = DBFetching.getArrayListStringResult(sql2,1);
            arrMat = DBFetching.getArrayListStringResult(sql2,2);
            arrUpah = DBFetching.getArrayListStringResult(sql2,3);
            arrTotal = DBFetching.getArrayListStringResult(sql2,4);

            for(int a = 0; a < kdStrFin.size(); a++)
            {
               for(int b = 0; b < arrKd.size(); b++){
                   if (arrKd.get(b).equals(kdStrFin.get(a)))
                       {
                          DBFetching.setComandToDB("update pros_hsat set hrg_mat = "+ arrMat.get(b) 
                                                  +",hrg_upah = "+ arrUpah.get(b) + ",hrg_sat = "
                                                       + "hrg_mat + hrg_upah " 
                                               +  " where stat_strfin like '%FIN%' and kd_strfin like '%" 
                                                   + kdStrFin.get(a)+"%' and tahun = '"+tahunDBKB+"'" );

                       }
                   }
               }
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            JOptionPane.showMessageDialog(new JFrame(),"gagal melakukan perhitungan HSAT", "Error 231", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void done()
    {
        DBFetching.Simpan();
    }
}

