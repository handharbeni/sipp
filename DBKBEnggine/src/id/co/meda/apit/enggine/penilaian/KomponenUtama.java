/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.model.ItemPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class KomponenUtama {
   public static void hitung(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listKompUtama) {
        //catatan: utk basement masih menggunakan hitungan lantai JPB masing2, harusnya berdasarkan tabel basement
        String kdJpb = lspop.getJpb().substring(0, 2);
        switch (kdJpb) {
            case "01":
                isiItemPenilaianJpb1("Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                    lspop.getKonstruksi(), thnPenilaian, listKompUtama);
                break;
            case "02":
                isiItemPenilaianTblBareng("jpb_2dan9","Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                        thnPenilaian, listKompUtama);
                if (lspop.getJmlLtBase()>0) {
                    isiItemPenilaianBsm("Selain Mal","Basement", "m2", lspop.getJmlLtBase(), lspop.getLsBase(), 
                            thnPenilaian, listKompUtama);
                }
                break;
            case "03":
                isiItemPenilaianJpb38("KU","JPB3",lspop.getJpb38LebarBentang(),lspop.getJpb38TinggiKolom(),
                        lspop.getJpb38LantaiDyDkg().intValue(),"Struktur Utama","m2",lspop.getJpb38LsMezzanin(),
                        lspop.getLsBngUtama()+lspop.getLsBngLain(), thnPenilaian, listKompUtama);
                isiItemPenilaianJpb38("DY","JPB3",lspop.getJpb38LebarBentang(),lspop.getJpb38TinggiKolom(),
                        lspop.getJpb38LantaiDyDkg().intValue(),"Daya Dukung","m2",lspop.getJpb38LsMezzanin(),
                        lspop.getLsBngUtama()+lspop.getLsBngLain(), thnPenilaian, listKompUtama);
                break;
            case "04":
                isiItemPenilaianTblBareng("jpb_4","Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                        thnPenilaian, listKompUtama);
                if (lspop.getJmlLtBase()>0) {
                    isiItemPenilaianBsm("Mal","Basement", "m2", lspop.getJmlLtBase(), lspop.getLsBase(), 
                            thnPenilaian, listKompUtama);
                }
                break;
            case "07":
                isiItemPenilaianTblBareng("jpb_7","Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                        thnPenilaian, listKompUtama);
                if (lspop.getJmlLtBase()>0) {
                    isiItemPenilaianBsm("Selain Mal","Basement", "m2", lspop.getJmlLtBase(), lspop.getLsBase(), 
                            thnPenilaian, listKompUtama);
                }
                break;
            case "08":
                isiItemPenilaianJpb38("KU","JPB8",lspop.getJpb38LebarBentang(),lspop.getJpb38TinggiKolom(),
                        lspop.getJpb38LantaiDyDkg().intValue(),"Struktur Utama","m2",lspop.getJpb38LsMezzanin(),
                        lspop.getLsBngUtama()+lspop.getLsBngLain(), thnPenilaian, listKompUtama);
                isiItemPenilaianJpb38("DY","JPB8",lspop.getJpb38LebarBentang(),lspop.getJpb38TinggiKolom(),
                        lspop.getJpb38LantaiDyDkg().intValue(),"Daya Dukung","m2",lspop.getJpb38LsMezzanin(),
                        lspop.getLsBngUtama()+lspop.getLsBngLain(), thnPenilaian, listKompUtama);
                if (lspop.getJpb38LsMezzanin()>0) {
                    isiItemPenilaianJpb38("MZ","JPB8",lspop.getJpb38LebarBentang(),lspop.getJpb38TinggiKolom(),
                            lspop.getJpb38LantaiDyDkg().intValue(),"Mezzanin","m2",lspop.getJpb38LsMezzanin(),
                            lspop.getLsBngUtama()+lspop.getLsBngLain(), thnPenilaian, listKompUtama);
                }
                break;
            case "12":
                isiItemPenilaianTblBareng("jpb_12","Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                        thnPenilaian, listKompUtama);
                if (lspop.getJmlLtBase()>0) {
                    isiItemPenilaianBsm("Selain Mal","Basement", "m2", lspop.getJmlLtBase(), lspop.getLsBase(), 
                            thnPenilaian, listKompUtama);
                }
                break;
            case "13":
                isiItemPenilaianTblBareng("jpb_13","Struktur Utama", "m2", lspop.getJmlLtBng(), lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                        thnPenilaian, listKompUtama);
                if (lspop.getJmlLtBase()>0) {
                    isiItemPenilaianBsm("Selain Mal","Basement", "m2", lspop.getJmlLtBase(), lspop.getLsBase(), 
                            thnPenilaian, listKompUtama);
                }
                break;
            default:
                ItemPenilaian ku = new ItemPenilaian();
                ku.setNamaItem("Struktur Utama"); ku.setLuasItem(0.0); ku.setSatuanItem("m2");
                ku.setNilaiKomponen(0.0); 
                listKompUtama.add(ku);
        }
    }

   private static void isiItemPenilaianTblBareng(String kdJpb,String nmItem, String satItem, Integer jmlLt, Double lsBng, String thn, ArrayList<ItemPenilaian> listKu) {
       Double nilaiNya = 0.0;
       try {
            nilaiNya = DBFetching.getDoubleResult("select "+kdJpb+" from rslt_ku_lbh_4lt where jumlah_lantai="
                        +jmlLt+" and thn_dbkb='"+thn+"'");
       } catch (Exception e) {
           nilaiNya = 0.0;
       }
       ToolsPenilaian.isiItemPenilaian(nmItem, lsBng, satItem, "", nilaiNya, new ItemPenilaian(), listKu);
   }
   
    private static void isiItemPenilaianJpb1(String nmItem, String satItem, Integer jmlLt, Double lsBng, String kons, String thn, ArrayList<ItemPenilaian> listKu) {
       Double nilaiNya = 0.0;
       try {
            String nmKons = "";
            switch (kons.trim()) {
                case "Baja": nmKons="baja"; break;
                case "Batu Bata": nmKons="bata"; break;
                case "Beton": nmKons="beton"; break;
                case "Kayu": nmKons="kayu"; break;
            }
            if (jmlLt==1) {
                nilaiNya = DBFetching.getDoubleResult("select "+nmKons+" from rslt_jpb1_lt1 where thn_dbkb='"+thn
                             +"' and "+lsBng+" between ls_min and ls_max");
            } else if (jmlLt>1) {
                if (nmKons.equals("bata")) {
                    nilaiNya = 0.0;
                } else {
                    nilaiNya = DBFetching.getDoubleResult("select "+nmKons+" from rslt_jpb1_lt2 where thn_dbkb='"+thn
                             +"' and "+lsBng+" between ls_min and ls_max");
                }
            }
       } catch (Exception e) {
           nilaiNya = 0.0;
       }
       ToolsPenilaian.isiItemPenilaian(nmItem, lsBng, satItem, "", nilaiNya, new ItemPenilaian(), listKu);
    }
   
   private static void isiItemPenilaianBsm(String statBng, String nmItem, String satItem, Integer jmlLt, Double lsBng, String thn, ArrayList<ItemPenilaian> listKu) {
       Double nilaiNya = 0.0;
       try {
            nilaiNya = DBFetching.getDoubleResult("select nilai from rslt_ku_bsm where jenis='" + statBng
                    + "' and jumlah_lantai="+jmlLt+" and tahun='"+thn+"'");
       } catch (Exception e) {
           nilaiNya = 0.0;
       }
       ToolsPenilaian.isiItemPenilaian(nmItem, lsBng, satItem, "", nilaiNya, new ItemPenilaian(), listKu);
   }

   private static void isiItemPenilaianJpb38(String kdKomp, String kdJpb, Integer lbrBtg, Integer tingKol, Integer dyDkg,
           String nmItem, String satItem, Double lsMezz, Double lsBng, String thn, ArrayList<ItemPenilaian> listKu) {
       Double nilaiNya = 0.0;
       try {
           switch (kdKomp) {
               case "KU" :
                    nilaiNya = DBFetching.getDoubleResult("select nilai from rslt_jpb38 where thn_penilaian='"
                        +thn+"' and jns_jpb='"+kdJpb+"' and "+lbrBtg+" between lbr_btg_min and lbr_btg_max " 
                        +" and "+tingKol+" between ting_kol_min and ting_kol_max");
                    break;
               case "DY" :
                    nilaiNya = DBFetching.getDoubleResult("select biaya from rslt_dy_dkg where thn_dy_dkg='"
                        +thn+"' and "+dyDkg+" between dy_dkg_min and dy_dkg_max");
                    break;
               case "MZ" :
                    nilaiNya = DBFetching.getDoubleResult("select nilai from rslt_mezzanine where thn_penilaian='"
                        +thn+"'");
                    break;
           }
       } catch (Exception e) {
           nilaiNya = 0.0;
       }
       Double lsDipakai = (kdKomp.equals("MZ"))?lsMezz:lsBng;
       ToolsPenilaian.isiItemPenilaian(nmItem, lsDipakai, satItem, "", nilaiNya, new ItemPenilaian(), listKu);
   }
}
