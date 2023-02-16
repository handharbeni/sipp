/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.enggine.penilaian.ToolsPenilaian;
import id.co.meda.apit.enggine.penilaian.model.LspopNonStandar;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class BuatModelPendataan {
    
    private static ModelSpopPerikanan buatModelSpop(String nop)
    {
        return ProsesDataSpopPerikanan.getSpopPerikanan(nop);
    }
    
    private static ModelPendapatanPerikanan buatModelPendapatan(String nop)
    {
        return BuatModelPendapatanPerikanan.getModelPendapatanIkan(nop);
    }
    
    private static ArrayList<LspopNonStandar> getArrLspop(String nop)
    {
        ArrayList<LspopNonStandar> lspops = new ArrayList<LspopNonStandar>();
        ToolsPenilaian.ambilLspopFromDbPerNop(nop, lspops);
        return lspops;
    }
    
    public static DataPerikanan getPendataan(String nop)
    {
        DataPerikanan model = new DataPerikanan();
        model.setSpop(buatModelSpop(nop));
        model.setPendapatan(buatModelPendapatan(nop));
        model.setLspop(getArrLspop(nop));
        
        return model;
    }
    
    
}
