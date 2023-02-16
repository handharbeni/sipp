/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import id.co.meda.apit.visual.report.TampilkanReportSpop;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlSpop {

    public void isiSpop(String nop, Spop spop) {
        ToolsPenilaian.ambilSpopFromDb(nop, spop);
    }
 
    public boolean cekNop(String tmpNop) {
        int jmlRec = DBFetching.getIntegerResult("select count(*) jml from spop where nop='" + tmpNop +"'");
        return jmlRec>0;
    }

    public String simpanSpop(int kdSimpan, Spop spop) {
        String strQuery = "";
        
        if (kdSimpan == 0) {
            strQuery = "insert into spop values('"+spop.getNop()+
                    "','"+spop.getJalanOp()+"','"+spop.getNoJalanOp()+
                    "','"+spop.getKelurahanOp()+"','"+spop.getRwRtOp()+
                    "','"+spop.getStatusWp()+"','"+spop.getPekerjaanWp()+
                    "','"+spop.getNamaWp()+"','"+spop.getNpwp()+
                    "','"+spop.getJalanWp()+"','"+spop.getNoJalanWp()+
                    "','"+spop.getKelurahanWp()+"','"+spop.getRwRtWp()+
                    "','"+spop.getKabupaten()+"','"+spop.getNomorKtp()+
                    "',"+spop.getLuasTanah().toString()+",'"+spop.getZnt()+
                    "','"+spop.getJenisTanah()+"',"+spop.getJumlahBangunan().toString()+")";
        } else {
            strQuery = "update spop set jalan_op='"+spop.getJalanOp()+
                    "', no_jalan_op='"+spop.getNoJalanOp()+"', kelurahan_op='"+spop.getKelurahanOp()+
                    "', rw_rt_op='"+spop.getRwRtOp()+"', status_wp='"+spop.getStatusWp()+
                    "', pekerjaan_wp='"+spop.getPekerjaanWp()+"', nama_wp='"+spop.getNamaWp()+
                    "', npwp='"+spop.getNpwp()+"', jalan_wp='"+spop.getJalanWp()+
                    "', no_jalan_wp='"+spop.getNoJalanWp()+"', kelurahan_wp='"+spop.getKelurahanWp()+
                    "', rw_rt_wp='"+spop.getRwRtWp()+"', kabupaten='"+spop.getKabupaten()+
                    "', nomor_ktp='"+spop.getNomorKtp()+"', luas_tanah="+spop.getLuasTanah().toString()+
                    ", znt='"+spop.getZnt()+"', jns_tanah='"+spop.getJenisTanah()+
                    "', jml_bng="+spop.getJumlahBangunan().toString()+" where nop='"+spop.getNop()+"'";
        }
        //System.out.println(strQuery);
        
        try {
            DBFetching.setComandToDB(strQuery);
            return "OK";
        } catch (Exception e) {
            return "Terjadi kesalahan, dgn pesan sbb : " + e.getMessage();
        }
            
    }
    
    public void simpanStatPenilKhusus(String nop, String nmPenilaian) {
        DBFetching.setComandToDB("delete from cek_op_khusus where nop='"+nop+"'");
        DBFetching.setComandToDB("insert into cek_op_khusus values('"+nop+"','"+nmPenilaian+"')");
    }
    
    public void cetakSpop(Spop spop, String nop)
    {
        ToolsPenilaian.ambilSpopFromDb(nop, spop);
        
        ArrayList<Spop> arrSpop = new ArrayList<Spop>();
        arrSpop.add(spop);
        
        TampilkanReportSpop lprn = new TampilkanReportSpop(arrSpop);
        lprn.tampilReport();
    }
}