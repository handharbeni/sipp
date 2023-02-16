/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.database.connection.DBFetchingOracle;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlImportSismiop {
    private final Connection conn;
    private final DBFetchingOracle dbf;
    ControlSpop ctrlSpop = new ControlSpop();
    ControlLspopNonStd ctrlLspop = new ControlLspopNonStd();
    
    public ControlImportSismiop(Connection conn) {
        this.conn=conn;
        this.dbf = new DBFetchingOracle(conn);
    }
    
    public String ambilDataLspop(String nop, ArrayList<LspopNonStandar> listLspop) {
        String strQuery = "select no_bng,kd_jpb,thn_dibangun_bng,thn_renovasi_bng,luas_bng,jml_lantai_bng, "
                + "decode(kondisi_bng,'1','Sangat Baik','2','Baik','3','Sedang','Jelek') kondisi from dat_op_bangunan "
                + "where kd_propinsi='"+nop.substring(0,2)+"' and kd_dati2='"
                +nop.substring(2,4)+"' and kd_kecamatan='"+nop.substring(4,7)+"' and kd_kelurahan='"
                +nop.substring(7,10)+"' and kd_blok='"+nop.substring(10,13)
                +"' and no_urut='"+nop.substring(13,17)+"' and kd_jns_op='"+nop.substring(17,18)+"'";
        
        ResultSet rs = dbf.getResultSet(strQuery);
        
        try {
            while (rs.next()) {
                LspopNonStandar lspop = new LspopNonStandar();
                lspop.setNop(nop);
                lspop.setBngKe(rs.getString("no_bng"));
                lspop.setJpb(rs.getString("kd_jpb"));
                lspop.setThnBangun(rs.getString("thn_dibangun_bng"));
                lspop.setThnRenov(rs.getString("thn_renovasi_bng"));
                lspop.setLsBngUtama(Double.parseDouble(rs.getString("luas_bng")));
                lspop.setJmlLtBng(Integer.parseInt(rs.getString("jml_lantai_bng")));
                lspop.setKondisi(rs.getString("kondisi"));
                
                listLspop.add(lspop);
            }
            return "ok";
        } catch(Exception e) {
            return e.getMessage();
        }
        
    }
    
    public String ambilDataSpop(String nop, Spop spop) {
        
        String strQuery = "select jalan_op, blok_kav_no_op, rt_op||'/'||rt_op rtrwop, nm_kelurahan, "
            +"decode(kd_status_wp,'1','Pemilik','2','Penyewa','3','Pengelola','4','Pemakai','5','Sengketa','') status_wp, "
            +"decode(status_pekerjaan_wp,'1','PNS','2','ABRI','3','Pensiunan','4','Badan','Lainnya') stat_pek_wp, "
            +"nm_wp,npwp,jalan_wp,blok_kav_no_wp,kelurahan_wp,rt_wp||'/'||rt_wp rtrwwp, kota_wp,c.subjek_pajak_id, total_luas_bumi, kd_znt, "
            +"decode(jns_bumi,'1','Tanah+Bangunan','2','Kavling Siap Bangun','3','Tanah Kosong','4','Fasilitas Umum','') jns_bumi "
            +"from dat_objek_pajak a, ref_kelurahan b, dat_subjek_pajak c,dat_op_bumi d " 
            +"where a.kd_propinsi=b.kd_propinsi and a.kd_dati2=b.kd_dati2 and a.kd_kecamatan=b.kd_kecamatan and a.kd_kelurahan=b.kd_kelurahan "
            +"and a.subjek_pajak_id=c.subjek_pajak_id and a.kd_propinsi=d.kd_propinsi and a.kd_dati2=d.kd_dati2 "
            +"and a.kd_kecamatan=d.kd_kecamatan and a.kd_kelurahan=d.kd_kelurahan and a.kd_blok=d.kd_blok and a.no_urut=d.no_urut and a.kd_jns_op=d.kd_jns_op "
            +"and a.kd_propinsi='"+nop.substring(0,2)+"' and a.kd_dati2='"+nop.substring(2,4)+"' and a.kd_kecamatan='"
            +nop.substring(4,7)+"' and a.kd_kelurahan='"+nop.substring(7,10)+"' and a.kd_blok='"+nop.substring(10,13)
            +"' and a.no_urut='"+nop.substring(13,17)+"' and a.kd_jns_op='"+nop.substring(17,18)+"'";

        ResultSet rs = dbf.getResultSet(strQuery);
        try {
            while (rs.next()) {
                spop.setNop(nop);
                spop.setJalanOp(rs.getString("jalan_op"));
                spop.setNoJalanOp(rs.getString("blok_kav_no_op"));
                spop.setRwRtOp(rs.getString("rtrwop"));
                spop.setKelurahanOp(rs.getString("nm_kelurahan"));
                spop.setStatusWp(rs.getString("status_wp"));
                spop.setPekerjaanWp(rs.getString("stat_pek_wp"));
                spop.setNamaWp(rs.getString("nm_wp"));
                spop.setNpwp(rs.getString("npwp"));
                spop.setJalanWp(rs.getString("jalan_wp"));
                spop.setNoJalanWp(rs.getString("blok_kav_no_wp"));
                spop.setKelurahanWp(rs.getString("kelurahan_wp"));
                spop.setRwRtWp(rs.getString("rtrwwp"));
                spop.setKabupaten(rs.getString("kota_wp"));
                spop.setNomorKtp(rs.getString("subjek_pajak_id"));
                spop.setLuasTanah(Double.parseDouble(rs.getString("total_luas_bumi")));
                spop.setZnt(rs.getString("kd_znt"));
                spop.setNamaWp(rs.getString("nm_wp"));
                spop.setJenisTanah(rs.getString("jns_bumi"));
           }
            return "ok";
        } catch(Exception e) {
            return e.getMessage();
        }
        
    }
    
    private Vector<String> vectorHeader() {
        Vector<String> header = new Vector<String>();
        header.add(0,"Bng Ke");
        header.add(1,"Jenis Penggunaan Bangunan");
        header.add(2,"Luas (m2)");
        return header;
    }
    
    public DefaultTableModel getTableModel() {
        Vector<Vector> data = new Vector<Vector>();
        return prosesTableModel(data, vectorHeader());
    }

    public DefaultTableModel getTableModel(ArrayList<LspopNonStandar> listLspop) {
        Vector<Vector> data = new Vector<Vector>();
        for (int i=0;i<listLspop.size();i++) {
            Vector vecData = new Vector();
            vecData.add(listLspop.get(i).getBngKe());
            vecData.add(listLspop.get(i).getJpb()+"-"+ambilNmJpb(listLspop.get(i).getJpb()));
            vecData.add(listLspop.get(i).getLsBngUtama());
            data.add(vecData);
        }
        return prosesTableModel(data, vectorHeader());
    }

    private DefaultTableModel prosesTableModel(Vector<Vector> data, Vector<String> header) {
        DefaultTableModel modelTable = new DefaultTableModel(data,header) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        }; 
       // DefaultTableModel modelTable = new DefaultTableModel(data,header);
        return modelTable;
    }

    public String ambilNmJpb(String kdJpb) {
        String hasil="";
        ResultSet rs = dbf.getResultSet("select * from ref_jpb where kd_jpb='"+kdJpb+"'");
        
        try {
            while (rs.next()) {
                hasil = rs.getString("nm_jpb");
            }
        } catch (Exception e) {}
        
        return hasil;
    }
        
    public String simpanDb(Spop spop, ArrayList<LspopNonStandar> listLspop) {
        String hasil="";
        try {
            DBFetching.setComandToDB("delete from spop where nop='"+spop.getNop()+"'");
            DBFetching.setComandToDB("delete from lspop_non_standar where nop='"+spop.getNop()+"'");
            
            String hasilSpop = ctrlSpop.simpanSpop(0, spop);
            
            for (int i=0;i<listLspop.size();i++) {
                String hasilLspop = ctrlLspop.simpanLspop(0, listLspop.get(i));
            }
            
            hasil = "ok";
        } catch (Exception e) {
            hasil = e.getMessage();
        }
        return hasil;
    }
}
