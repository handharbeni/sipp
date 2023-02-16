/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlPengguna {

    public String simpanPengguna(Integer kdEdit, Pengguna pengguna) {
        String hasil="";
        
        if (pengguna.getPwd()==null) {
            pengguna.setPwd(SecEncryptDecrypt.EncryptText(pengguna.getNmUser()));
        }
        
        try {
            switch (kdEdit) {
                case 0:
                    DBFetching.setComandToDB("insert into pengguna(nm_user,password,nip,nm_lengkap,kd_role) " +
                            "values ('"+pengguna.getNmUser()+"','"+pengguna.getPwd()+"','"+pengguna.getNip() +
                            "','"+pengguna.getNmLengkap()+"','"+pengguna.getKdRole()+"')");
                    break;
                case 1:
                    DBFetching.setComandToDB("update pengguna set nm_user='"+pengguna.getNmUser()+"', password='" +
                            pengguna.getPwd()+"', nip='"+pengguna.getNip()+"', nm_lengkap='"+pengguna.getNmLengkap() +
                            "', kd_role='"+pengguna.getKdRole()+"' where id_pengguna="+pengguna.getIdUser());
                    break;
            }
            hasil = "ok";
        } catch (Exception e) {
            hasil = e.getMessage();
        }
        
        return hasil;
    }
    
    public Pengguna ambilPengguna(String idPengguna) {
        Pengguna pengguna = new Pengguna();
        
        ResultSet rs = DBFetching.getResultSet("select * from pengguna where id_pengguna="+idPengguna);
        try {
            while (rs.next()) {
                pengguna.setIdUser(Integer.parseInt(rs.getString("id_pengguna")));
                pengguna.setNmUser(rs.getString("nm_user"));
                pengguna.setPwd(rs.getString("password"));
                pengguna.setNip(rs.getString("nip"));
                pengguna.setNmLengkap(rs.getString("nm_lengkap"));
                pengguna.setKdRole(rs.getString("kd_role"));
            }
        } catch (Exception e) {}
        
        return pengguna;
    }

    public void ambilWenang(JComboBox cb) {
        ResultSet rs = DBFetching.getResultSet("select * from role_pengguna");

        try {
            while (rs.next()) {
                cb.addItem(rs.getString("kd_role") + " - " + rs.getString("nm_role"));
            }
        } catch (Exception e) {}
        
    }
    
    public boolean cekUser(String user, String pwd, Pengguna pengguna) {
        
        String pwdEncrypt = SecEncryptDecrypt.EncryptText(pwd);
        
        
        
        ResultSet rs = DBFetching.getResultSet("select * from pengguna where nm_user='"
        + user + "' and password = '" + pwdEncrypt + "'");
        
        /*
        ResultSet rs = DBFetching.getResultSet("select * from pengguna where nm_user='"
        + user + "'");
        */
        Integer jmlRec = 0;
        
        try {
            while (rs.next()) {
                pengguna.setIdUser(Integer.parseInt(rs.getString("id_pengguna")));
                pengguna.setNip(rs.getString("nip"));
                pengguna.setNmLengkap(rs.getString("nm_lengkap"));
                pengguna.setNmUser(rs.getString("nm_user"));
                pengguna.setKdRole(rs.getString("kd_role"));
                pengguna.setPwd(rs.getString("password"));
            }
            rs.last();
            jmlRec = rs.getRow();
            rs.beforeFirst();
        } catch (Exception e) {}
        
        
        return (jmlRec>0);
    }
    
    public String ambilNmRole(String kdRole) {
        return DBFetching.getStringResult("select nm_role from role_pengguna where kd_role='"+kdRole+"'", 1);
    }
    
    public String updatePengguna(Pengguna pengguna) {
        try {
            DBFetching.setComandToDB("update pengguna set nm_user='"+pengguna.getNmUser()
                    +"', password='"+pengguna.getPwd()+"', nip='"+pengguna.getNip()
                    +"', nm_lengkap='"+pengguna.getNmLengkap()+"' where id_pengguna="+pengguna.getIdUser());
            return "ok";
        } catch (Exception e) {
            return "Terjadi kesalahan saat update data pengguna : " + e.getMessage();
        }
    }
    
    
    public String deletePengguna(String id)
    {
        
        try{
            DBFetching.setAutoCommit(false);
            
            DBFetching.setComandToDB("DELETE FROM `pengguna` "
                    + "WHERE `id_pengguna`='"+id+"';");
            return "ok";
            
        }catch(Exception e)
        {
            DBFetching.RollBackDB();
            DBFetching.setAutoCommit(true);
            return "Terjadi kesalahan saat delete data pengguna : " + e.getMessage();
        }
    }
    
    public DefaultTableModel getTableModel() {
        Vector<String> header = new Vector<String>();
        header.add(0,"Id");
        header.add(1,"NIP");
        header.add(2,"Nama Lengkap");
        header.add(3,"Nama Pengguna");
        header.add(4,"Wewenang");
        header.add(5,"");
        header.add(6,"");
        
        
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(data);
        
        DefaultTableModel modelTable = new DefaultTableModel(data,header) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        return modelTable;
    }
    
    private void isiVectorData(Vector<Vector> data) {
        ResultSet rs = DBFetching.getResultSet("select * from pengguna");
        try {
          while (rs.next()) {
              Vector vecData = new Vector();
              vecData.add(rs.getString("id_pengguna"));
              vecData.add(rs.getString("nip"));
              vecData.add(rs.getString("nm_lengkap"));
              vecData.add(rs.getString("nm_user"));
              vecData.add(ambilNmRole(rs.getString("kd_role")));
              data.add(vecData);
          }   
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
