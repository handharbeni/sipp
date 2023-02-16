package id.co.meda.apit.enggine.dbkb;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.dbkb.jpb.KuLebih4lt;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JProgressBar;
/**
 *
 * @author I Putu Medagia A
 */
public class DBKBFirstCalculation {
    
private String DBKByear;
private JProgressBar progressBar;

public DBKBFirstCalculation(String DBKByear,JProgressBar progressBar)
{
    this.progressBar = progressBar;
    this.DBKByear = DBKByear;
}


public void HSKUCalculation()
{
    HSKU hsku = new HSKU(DBKByear);
    
    String sql = "select kd_hsku from pros_hsku where hrg_sat = 0 and vol_hsku = 0 and tahun = '"+DBKByear+"'";
    
    ArrayList <String> arr_kdHsku = new ArrayList<String>();
    arr_kdHsku = DBFetching.getArrayListStringResult(sql,1);
    
    
    hsku.prosesHargaSatuan();
    
    ArrayList<String> specialHsku = new ArrayList<String>();
           
    for(int i = 0; i< arr_kdHsku.size(); i++){

    hsku.prosesHargaKomp(arr_kdHsku.get(i).substring(0,1), arr_kdHsku.get(i).substring(0,4), "hrg_sat");
    hsku.prosesHargaUpah(arr_kdHsku.get(i).substring(0,1), arr_kdHsku.get(i).substring(0,4), "hrg_sat");
    hsku.prosesHargaTotal(arr_kdHsku.get(i));
    
    }
    hsku.done();
    
    specialHsku.add("B040000");
   
    specialHsku.add("B050000");
    specialHsku.add("B060000");
    specialHsku.add("B070000");
    specialHsku.add("B080000");
    specialHsku.add("B090000");
    specialHsku.add("B100000");
    specialHsku.add("C010000");
    specialHsku.add("C020000");
    specialHsku.add("C030000");
    specialHsku.add("C040000");
    specialHsku.add("C050000");
          

    for (int a = 0; a < specialHsku.size(); a++)
            hsku.prosesHrgTotalSpecialCase(specialHsku.get(a));
    
    progressBar.setValue(10);
    progressBar.setString(10+"%");
         
    }
    
public void HSKMCalculation()
{
 
    
    HSKM hskm = new HSKM(DBKByear);
    String sql = "select kd_hskm from pros_hskm where hrg_sat = 0 and vol_hskm = 0 and tahun = '"+DBKByear+"'";
             
    ArrayList <String> arr_kdHskm = new ArrayList<String> ();
    arr_kdHskm = DBFetching.getArrayListStringResult(sql,1);
    
    hskm.prosesHargaSatuan();
             
    ArrayList<String> special = new ArrayList<String>();
    
            
    for(int i = 0; i< arr_kdHskm.size() ; i++){

        hskm.prosesHargaKomp(arr_kdHskm.get(i).substring(0,1), arr_kdHskm.get(i).substring(0,5), "hrg_sat");
        hskm.prosesHargaUpah(arr_kdHskm.get(i).substring(0,1), arr_kdHskm.get(i).substring(0,5), "hrg_sat");
        hskm.prosesHargaTotal(arr_kdHskm.get(i));
        
     }
     special.add("B040000");
     special.add("F010000");
          
     for (int a = 0; a < special.size(); a++)
        hskm.prosesHrgTotalSpecialCase (special.get(a));
           
     hskm.prosesMaterialLainHskm("nm_hskm", "Material lain");
     hskm.done();
     
    progressBar.setValue(20);
    progressBar.setString(20+"%");
}

public void HSATCalculation()
{
    HSAT hrg_sat = new HSAT(DBKByear);
    ArrayList<String> data = new ArrayList<String>();
    data = DBFetching.getArrayListStringResult("select distinct kd_strfin from pros_hsat where tahun = '"+DBKByear+"'",1);
    hrg_sat.store(data);
    hrg_sat.done();
    
    progressBar.setValue(30);
    progressBar.setString(30+"%");
}

public void FasilitasCalculation()
{
  Fasilitas fasilitas = new Fasilitas(DBKByear);
  fasilitas.Calculate();
 
  double refACsplit = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F01001'");
  double refACwindow = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F01002'");
  double refACfloor = DBFetching.getDoubleResult("select hrg_dhkm from ref_dhkmf where kd_dhkm = 'F01003'");
        
  DBFetching.setComandToDB("UPDATE `pros_acsplit` SET "
                                + "`ak_split`='"+refACsplit+"', "
                                + "`ak_window`='"+refACwindow+"', "
                                + "`ak_floor`='"+refACfloor+"' "
                                + "WHERE `pk`='2' and Tahun = '"+DBKByear+"'");
  
  FasilitasAC fasilitasAC = new FasilitasAC(DBKByear);
  fasilitasAC.prosesACSplit();
  fasilitasAC.prosesACSentral();
  fasilitasAC.prosesBandingAC();
  fasilitasAC.prosesResultAc();
  fasilitasAC.done();
  
  FasilitasLift fasilitasLift = new FasilitasLift(DBKByear);
  fasilitasLift.prosesPasenggerLift();
  fasilitasLift.prosesServiceLift();
  fasilitasLift.prosesBandingLift();
  fasilitasLift.prosesResultLift();
  fasilitasLift.done();
  
  FasilitasEscalatorGondola fasilitasEscalator = new FasilitasEscalatorGondola(DBKByear);
  fasilitasEscalator.prosesHargaAktual();
  fasilitasEscalator.prosesHargaBanding();
  fasilitasEscalator.prosesHargaAktualPrediksi();
  fasilitasEscalator.prosesResultEscalatorGondola();
  fasilitasEscalator.done();
  
  FasilitasPagar fasilitasPagar = new FasilitasPagar(DBKByear);
  fasilitasPagar.prosesKomponenHarga();
  fasilitasPagar.prosesVariasiTinggi();
  fasilitasPagar.prosesPagarLain();
  fasilitasPagar.prosesResult();
  fasilitasPagar.done();
  
  FasilitasProteksiApi fasilitasProteksiApi = new FasilitasProteksiApi(DBKByear);
  fasilitasProteksiApi.prosesHydrant();
  fasilitasProteksiApi.prosesAlarmInterkom();
  fasilitasProteksiApi.done();
  
  FasilitasGenset fasilitasGenset = new FasilitasGenset(DBKByear);
  fasilitasGenset.prosesPerhitungan();
  fasilitasGenset.prosesPrakiraanKomponen();
  fasilitasGenset.done();
  
  FasilitasPabx fasilitasPabx = new FasilitasPabx(DBKByear); 
  fasilitasPabx.prosesHitungPabx();
  fasilitasPabx.done();
  
  FasilitasSumurArtesis fasilitasSumur = new FasilitasSumurArtesis(DBKByear); 
  fasilitasSumur.prosesPerhitungan();
  fasilitasSumur.done();
  
  FasilitasAirPanas fasilitasAirPanas = new FasilitasAirPanas(DBKByear); 
  fasilitasAirPanas.prosesTableHargaAktual();
  fasilitasAirPanas.prosesKoefisien();
  fasilitasAirPanas.done();
  
  FasilitasListrik fasilitasListrik = new FasilitasListrik(DBKByear);
  fasilitasListrik.prosesKomponenListrik();
  fasilitasListrik.prosePerbandinganHarga();
  fasilitasListrik.done();
  
  FasilitasPenangkalPetir fasilitasPenangkalPetir = new FasilitasPenangkalPetir(DBKByear);
  fasilitasPenangkalPetir.prosesPerhitungan();
  fasilitasPenangkalPetir.done();
  
  FasilitasTataSuara fasilitasTataSuara = new FasilitasTataSuara(DBKByear);
  fasilitasTataSuara.prosesPerhitungan();
  fasilitasTataSuara.done();
  
  FasilitasVideoInterkom fasilitasVideoInterkom = new FasilitasVideoInterkom(DBKByear);
  fasilitasVideoInterkom.prosesPerhitungan();
  fasilitasVideoInterkom.done();
  
  FasilitasTelevisi fasilitasTelevisi = new FasilitasTelevisi(DBKByear);
  fasilitasTelevisi.prosesMatv();
  fasilitasTelevisi.prosesCctv();
  fasilitasTelevisi.done();
  
  FasilitasPlumbing fasilitasPlumbing = new FasilitasPlumbing(DBKByear);
  fasilitasPlumbing.prosesPerhitungan();
  fasilitasPlumbing.prosesKoefisien();
  fasilitasPlumbing.prosesResultPlumbing();
  fasilitasPlumbing.done();
  
  FasilitasPengolahanLimbah fasilitasLimbah = new FasilitasPengolahanLimbah(DBKByear);
  fasilitasLimbah.prosesPerhitungan();
  fasilitasLimbah.prosesJpb();
  fasilitasLimbah.done();
  progressBar.setValue(40);
  progressBar.setString(40+"%");
  
}

public void ProsesRsltMaterial()    
{
    prosesRsltMaterial material = new prosesRsltMaterial(this.DBKByear);
    material.prosGolMaterial();
    material.prosesRsltMaterialA();
    material.prosesRsltMaterialB();
    material.prosesRsltMaterialC();
    material.prosesRsltMaterialD();
    material.done();
}



public static void main(String[]args)
{
    DBKBFirstCalculation calculate = new DBKBFirstCalculation("1999",new JProgressBar());
    
    System.out.println("tes mulai");
      calculate.HSKUCalculation();
      //calculate.HSKMCalculation();
      //calculate.HSATCalculation();
     //calculate.FasilitasCalculation();
    System.out.println("tes selesai");
    
}


}
