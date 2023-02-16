/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ModelIkan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ProsesDataPendapatanPerikanan;
import id.co.meda.apit.enggine.penilaian.khusus.perikanan.ToolsPenilaianIkan;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlFrmPendapatanIkan {
    
    private ProsesDataPendapatanPerikanan data = new ProsesDataPendapatanPerikanan();
    
  public boolean addIkan(ModelIkan ikan,String nop)
  {
      return data.addIkan(ikan,nop);
  }
  
  public boolean updateIkan(ModelIkan ikan,String nop, String namaIkanLama)
  {
      return data.updateIkan(ikan,nop,namaIkanLama);
  }
  
  public ModelIkan getModelIkanSatuan(String nop,String jenisUsaha, String namaIkan)
  {
      return ToolsPenilaianIkan.getModelIkan(nop, jenisUsaha, namaIkan);
  }
     
    
}
