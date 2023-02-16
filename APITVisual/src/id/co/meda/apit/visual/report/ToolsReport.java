/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.report;

import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.io.InputStream;
import java.util.Collection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author I Made Sugiada
 */
public class ToolsReport {
    public JasperPrint bentukReport(Collection coll, String tempUrl) {
        JasperDesign jasperDesign;
        JasperPrint jasperPrint;
        JasperReport jasperReport;
        
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(tempUrl);
            jasperDesign = JRXmlLoader.load(resourceAsStream);
            //compile the jasperDesign
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //fill the ready report with data and parameter
            jasperPrint = JasperFillManager.fillReport(jasperReport, null,
                    new JRBeanCollectionDataSource(coll));
            return jasperPrint;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public LaporanPenilaianDataMaterialPembuka bentukDataMaterial(LspopNonStandar lspop)
    {
        LaporanPenilaianDataMaterialPembuka datMaterial = new LaporanPenilaianDataMaterialPembuka();
        
        datMaterial.setBngKe(lspop.getBngKe());
        
        //matDindingDalam
        datMaterial.setMatDindingDalam(lspop.getDinDalamStr());
        
        //matDindingLuar
        if(lspop.getDinLuarBetonJmlLt() > 0)
        {
            datMaterial.setMatDindingLuar("Beton");
        }else if(lspop.getDinLuarCelconJmlLt()>0)
        {
            datMaterial.setMatDindingLuar("Pasangan Celon");
        }else if(lspop.getDinLuarKacaJmlLt()>0)
        {
            datMaterial.setMatDindingLuar("Kaca");
        }else if(lspop.getDinLuarKayuJmlLt()>0)
        {
            datMaterial.setMatDindingLuar("Kayu");
        }else if(lspop.getDinLuarPasBatuJmlLt()>0)
        {
            datMaterial.setMatDindingLuar("Pasangan 1/2 Batu Bata");
        }else if(lspop.getDinLuarSengJmlLt()>0)
        {
            datMaterial.setMatDindingLuar("Seng");
        }
        
        //Pelapis Dinding Dalam
        if(lspop.getPelDalamCatStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Cat");
        }else if(lspop.getPelDalamGranitImporStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Granit Impor");
        }else if(lspop.getPelDalamGranitLokalStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Granit Lokal");
        }else if(lspop.getPelDalamKacaImporStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Kaca Impor");
        }else if(lspop.getPelDalamKacaLokalStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Kaca Lokal");
        }else if(lspop.getPelDalamKeramikStdStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Keramik");
        }else if(lspop.getPelDalamMarmerImporStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Marmer Import");
        }else if(lspop.getPelDalamMarmerLokalStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Marmer Lokal");
        }else if(lspop.getPelDalamWallpaperStrJmlLt()>0)
        {
            datMaterial.setPelDindingDalam("Wallpaper");
        }    
        
        //Pelapis Dinding Luar
        if(lspop.getPelLuarCatJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Cat");
        }else if(lspop.getPelLuarGranitImporJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Granit Impor");
        }else if(lspop.getPelLuarGranitLokalJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Granit Lokal");
        }else if(lspop.getPelLuarKacaImporJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Kaca Impor");
        }else if(lspop.getPelLuarKacaLokalJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Kaca Lokal");
        }else if(lspop.getPelLuarKeramikStdJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Keramik");
        }else if(lspop.getPelLuarMarmerImporJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Marmer Impor");
        }else if(lspop.getPelLuarMarmerLokalJmlLt()>0)
        {
            datMaterial.setPelDindingLuar("Marmer Lokal");
        } 
        
        //Langit-langit
        if(lspop.getLangitAkustikStrJmlLt()>0)
        {
            datMaterial.setLangitLangit("Akustik");
        }else if(lspop.getLangitEternitStrJmlLt()>0)
        {
            datMaterial.setLangitLangit("Eternit");
        }else if(lspop.getLangitGipsumStrJmlLt()>0)
        {
            datMaterial.setLangitLangit("Gipsum");
        }else if(lspop.getLangitTriplekStrJmlLt()>0)
        {
            datMaterial.setLangitLangit("Triplek");
        }
        
        //Atap
        datMaterial.setAtap(lspop.getAtap());
        
        //Penutup Lantai
        if(lspop.getLantaiGranitImporStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Granit Impor");
        }else if(lspop.getLantaiGranitLokalStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Granit Lokal");
        }else if(lspop.getLantaiKarpetImporStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Karpet Impor");
        }else if(lspop.getLantaiKarpetLokalStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Karpet Lokal");
        }else if(lspop.getLantaiKayuStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Kayu");
        }else if(lspop.getLantaiKeramikStdStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Keramik");
        }else if(lspop.getLantaiMarmerImporStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Marmer Impor");
        }else if(lspop.getLantaiMarmerLokalStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Marmer Lokal");
        }else if(lspop.getLantaiSemenStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Semen");
        }else if(lspop.getLantaiTerasoStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Teraso");
        }else if(lspop.getLantaiUbinStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Ubin");
            
        }else if(lspop.getLantaiVinilStrJmlLt()>0)
        {
            datMaterial.setPenutupLantai("Vinil");
        }
        return datMaterial;
    }
}
