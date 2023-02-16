/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.ItemPenilaian;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import id.co.meda.apit.enggine.penilaian.model.Spop;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ControlLihatPenilaian {
    
    NumberFormat numFormat = NumberFormat.getNumberInstance();
    
    public boolean cekNop(String nop) {
       return (DBFetching.getIntegerResult("select count(*) jml from rslt_penilaian where nop='"+nop+"'")>0)?true:false;
    }
    
    public void isiDataSpop(String nop, Spop spop) {
        ToolsPenilaian.ambilSpopFromDb(nop, spop);
    }
    
    public Integer ambilJmlBng(String nop) {
        return DBFetching.getIntegerResult("select count(*) from lspop_non_standar where nop='"+nop+"'");
    }
    
    public void isiCombo(String sqlQuery, JComboBox cb) {
        cb.removeAllItems();
        ResultSet rs = DBFetching.getResultSet(sqlQuery);
        try {
            while (rs.next()) {
                cb.addItem(rs.getString(1));
            }
        } catch (Exception e) {}
    }
    
    public ArrayList<NilaiBangunan> isiDataPenilaian(String thnPenilaian, String nop) {
        return ToolsPenilaian.ambilNilBngFromDB(thnPenilaian, nop);
    }

    
    public DefaultTableModel getTableModel(String kdTabel, String kdFieldLuas) {
        Vector<Vector> data = new Vector<Vector>();
        return prosesTableModel(data, vectorHeader(kdTabel,kdFieldLuas));
    }
    
    public DefaultTableModel getTableModel(ArrayList<NilaiBangunan> listNilBng) {
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(listNilBng, data);
        return prosesTableModel(data, vectorHeader("SUMMARY",""));
    }

    public DefaultTableModel getTableModel(NilaiBangunan nilBng, String kdTabel, String kdFieldLuas) {
        Vector<Vector> data = new Vector<Vector>();
        isiVectorData(nilBng, kdTabel, data);
        return prosesTableModel(data, vectorHeader(kdTabel,kdFieldLuas));
    }
    
    private Vector<String> vectorHeader(String kdTabel, String kdFieldLuas) {
        Vector<String> header = new Vector<String>();
        if (kdTabel.equals("SUMMARY")) {
            header.add(0,"Bng Ke");
            header.add(1,"Jenis Penggunaan Bangunan");
            header.add(2,"Luas (m2)");
            header.add(3,"Jml Lantai");
            header.add(4,"Nilai Bangunan (Rp)");
        } else {
            header.add(0,"Nama Komponen");
            header.add(1,kdFieldLuas);
            header.add(2,"Satuan");
            header.add(3,"Nilai Komponen (Rp)");
            header.add(4,"Total Nilai (Rp)");
        }
        return header;
    }

    private void isiVectorData(NilaiBangunan nilaiBng, String kdTabel, Vector<Vector> data) {
        switch (kdTabel) {
            case "KOMPUTAMA" : ambilDataListArray(nilaiBng.getKompUtama(), data); break;
            case "MATDINDAL" : ambilDataListArray(nilaiBng.getMatDinDal(), data); break;
            case "MATDINLUAR" : ambilDataListArray(nilaiBng.getMatDinLuar(), data); break;
            case "PELDINDAL" : ambilDataListArray(nilaiBng.getPelDinDal(), data); break;
            case "PELDINLUAR" : ambilDataListArray(nilaiBng.getPelDinLuar(), data); break;
            case "KOMPLANGIT" : ambilDataListArray(nilaiBng.getKompLangit(), data); break;
            case "KOMPATAP" : ambilDataListArray(nilaiBng.getKompAtap(), data); break;
            case "KOMPLANTAI" : ambilDataListArray(nilaiBng.getKompLantai(), data); break;
            case "FASACSENT" : ambilDataListArray(nilaiBng.getKompFasilitas().getAcSentral(), data); break;
            case "FASLIFT" : ambilDataListArray(nilaiBng.getKompFasilitas().getLift(), data); break;
            case "FASESKALATOR" : ambilDataListArray(nilaiBng.getKompFasilitas().getEskalator(), data); break;
            case "FASPAGAR" : ambilDataListArray(nilaiBng.getKompFasilitas().getPagar(), data); break;
            case "FASPROAPI" : ambilDataListArray(nilaiBng.getKompFasilitas().getProteksiApi(), data); break;
            case "FASTELEVISI" : ambilDataListArray(nilaiBng.getKompFasilitas().getTelevisi(), data); break;
            case "FASPERKERASAN" : ambilDataListArray(nilaiBng.getKompFasilitas().getPerkerasan(), data); break;
            case "FASLAPTENIS" : ambilDataListArray(nilaiBng.getKompFasilitas().getLapanganTenis(), data); break;
            case "FASTDKSUSUT" : ambilDataListArray(nilaiBng.getFasilitasTdkSusut(), data); break;
        }
    }
    
    private void ambilDataListArray (ArrayList<ItemPenilaian> listPenil, Vector<Vector> data) {
        for (int i=0;i<listPenil.size();i++) {
            Vector vecData = new Vector();
            vecData.add(listPenil.get(i).getNamaItem());
            vecData.add(numFormat.format(listPenil.get(i).getLuasItem()));
            vecData.add(listPenil.get(i).getSatuanItem());
            vecData.add(numFormat.format(listPenil.get(i).getNilaiKomponen()));
            vecData.add(numFormat.format(listPenil.get(i).getTotalNilaiItem()));
            data.add(vecData);
        }
    }

    private void isiVectorData(ArrayList<NilaiBangunan> listNilaiBng, Vector<Vector> data) {
        for(int i=0;i<listNilaiBng.size();i++) {
            Vector vecData = new Vector();
            vecData.add(listNilaiBng.get(i).getBngKe());
            vecData.add(listNilaiBng.get(i).getJpb());
            vecData.add(numFormat.format(listNilaiBng.get(i).getLuasBng()));
            vecData.add(numFormat.format(listNilaiBng.get(i).getJmlLtBng()));
            vecData.add(numFormat.format(listNilaiBng.get(i).getNilaiBangunan()));
            data.add(vecData);
        }
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

}
