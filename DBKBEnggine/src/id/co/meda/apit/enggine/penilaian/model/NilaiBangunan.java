/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.model;

import id.co.meda.apit.enggine.penilaian.model.ItemPenilaian;
import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class NilaiBangunan {
    private String ThnPenilaian;
    private String Nop;
    private String BngKe;
    private String jpb;
    private Double LuasBng;
    private Double LuasBase;
    private Integer JmlLtBng;
    private Integer JmlLtBase;
    private ArrayList<ItemPenilaian> KompUtama;
    private ArrayList<ItemPenilaian> MatDinDal;
    private ArrayList<ItemPenilaian> MatDinLuar;
    private ArrayList<ItemPenilaian> PelDinDal;
    private ArrayList<ItemPenilaian> PelDinLuar;
    private ArrayList<ItemPenilaian> KompLangit; 
    private ArrayList<ItemPenilaian> KompAtap;
    private ArrayList<ItemPenilaian> KompLantai;
    private FasilitasBangunan KompFasilitas;
    private Double PersenPenyusutan;
    private ArrayList<ItemPenilaian> FasilitasTdkSusut;

    
    public Double getLsBngPerLantaiUtama() {
        return (getLuasBng()/getJmlLtBng().doubleValue());
    }

    public Double getLsBngPerLantaiBase() {
        return (getLuasBase()/getJmlLtBase().doubleValue());
    }
    
    public Double getTotalKompUtama() {
        return getNilaiTotalPerKomponen(getKompUtama());
    }

    public Double getTotalMatDinDal() {
        return getNilaiTotalPerKomponen(getMatDinDal());
    }

    public Double getTotalMatDinLuar() {
        return getNilaiTotalPerKomponen(getMatDinLuar());
    }

    public Double getTotalPelDinDal() {
        return getNilaiTotalPerKomponen(getPelDinDal());
    }

    public Double getTotalPelDinLuar() {
        return getNilaiTotalPerKomponen(getPelDinLuar());
    }

    public Double getTotalKompLangit() {
        return getNilaiTotalPerKomponen(getKompLangit());
    }

    public Double getTotalKompAtap() {
        return getNilaiTotalPerKomponen(getKompAtap());
    }

    public Double getTotalKompLantai() {
        return getNilaiTotalPerKomponen(getKompLantai());
    }

    public Double getTotalFasilitasTdkSusut() {
        return getNilaiTotalPerKomponen(getFasilitasTdkSusut());
    }

    private Double getNilaiTotalPerKomponen(ArrayList<ItemPenilaian> namaKomponen) {
        Double nilTotal = 0.0;
        try {
            for (int i = 0; i < namaKomponen.size(); i++) {
                    nilTotal = nilTotal+namaKomponen.get(i).getTotalNilaiItem();
            }
            return nilTotal;
        } catch (Exception e) {
            return nilTotal;
        }
    }
    
    public Double getTotalKompMaterial() {
        return   getTotalMatDinDal()+getTotalMatDinLuar()
                +getTotalPelDinDal()+getTotalPelDinLuar()+getTotalKompAtap()
                +getTotalKompLangit()+getTotalKompLantai();
    }

    /**
     * @return the NilaiBngSblmSusut
     */
    public Double getNilaiBngSblmSusut() {
        return getTotalKompUtama()+getTotalKompMaterial()+KompFasilitas.getNilaiFasilitas();
    }
    
    /**
     * @return the NilaiPenyusutan
     */
    public Double getNilaiPenyusutan() {
        return getPersenPenyusutan()*getNilaiBngSblmSusut();
    }

    /**
     * @return the NilaiBngStlhSusut
     */
    public Double getNilaiBngStlhSusut() {
        return getNilaiBngSblmSusut()-getNilaiPenyusutan();
    }

    /**
     * @return the NilaiBangunan
     */
    public Double getNilaiBangunan() {
        return getNilaiBngStlhSusut()+getTotalFasilitasTdkSusut();
    }


    /**
     * @return the Nop
     */
    public String getNop() {
        return Nop;
    }

    /**
     * @param Nop the Nop to set
     */
    public void setNop(String Nop) {
        this.Nop = Nop;
    }

    /**
     * @return the BngKe
     */
    public String getBngKe() {
        return BngKe;
    }

    /**
     * @param BngKe the BngKe to set
     */
    public void setBngKe(String BngKe) {
        this.BngKe = BngKe;
    }

    /**
     * @return the LuasBng
     */
    public Double getLuasBng() {
        return LuasBng;
    }

    /**
     * @param LuasBng the LuasBng to set
     */
    public void setLuasBng(Double LuasBng) {
        this.LuasBng = LuasBng;
    }

    /**
     * @return the LuasBase
     */
    public Double getLuasBase() {
        return LuasBase;
    }

    /**
     * @param LuasBase the LuasBase to set
     */
    public void setLuasBase(Double LuasBase) {
        this.LuasBase = LuasBase;
    }

    /**
     * @return the JmlLtBng
     */
    public Integer getJmlLtBng() {
        return JmlLtBng;
    }

    /**
     * @param JmlLtBng the JmlLtBng to set
     */
    public void setJmlLtBng(Integer JmlLtBng) {
        this.JmlLtBng = JmlLtBng;
    }

    /**
     * @return the JmlLtBase
     */
    public Integer getJmlLtBase() {
        return JmlLtBase;
    }

    /**
     * @param JmlLtBase the JmlLtBase to set
     */
    public void setJmlLtBase(Integer JmlLtBase) {
        this.JmlLtBase = JmlLtBase;
    }

    /**
     * @return the KompUtama
     */
    public ArrayList<ItemPenilaian> getKompUtama() {
        return KompUtama;
    }

    /**
     * @param KompUtama the KompUtama to set
     */
    public void setKompUtama(ArrayList<ItemPenilaian> KompUtama) {
        this.KompUtama = KompUtama;
    }

    /**
     * @return the MatDinDal
     */
    public ArrayList<ItemPenilaian> getMatDinDal() {
        return MatDinDal;
    }

    /**
     * @param MatDinDal the MatDinDal to set
     */
    public void setMatDinDal(ArrayList<ItemPenilaian> MatDinDal) {
        this.MatDinDal = MatDinDal;
    }

    /**
     * @return the MatDinLuar
     */
    public ArrayList<ItemPenilaian> getMatDinLuar() {
        return MatDinLuar;
    }

    /**
     * @param MatDinLuar the MatDinLuar to set
     */
    public void setMatDinLuar(ArrayList<ItemPenilaian> MatDinLuar) {
        this.MatDinLuar = MatDinLuar;
    }

    /**
     * @return the PelDinDal
     */
    public ArrayList<ItemPenilaian> getPelDinDal() {
        return PelDinDal;
    }

    /**
     * @param PelDinDal the PelDinDal to set
     */
    public void setPelDinDal(ArrayList<ItemPenilaian> PelDinDal) {
        this.PelDinDal = PelDinDal;
    }

    /**
     * @return the PelDinLuar
     */
    public ArrayList<ItemPenilaian> getPelDinLuar() {
        return PelDinLuar;
    }

    /**
     * @param PelDinLuar the PelDinLuar to set
     */
    public void setPelDinLuar(ArrayList<ItemPenilaian> PelDinLuar) {
        this.PelDinLuar = PelDinLuar;
    }

    /**
     * @return the KompLangit
     */
    public ArrayList<ItemPenilaian> getKompLangit() {
        return KompLangit;
    }

    /**
     * @param KompLangit the KompLangit to set
     */
    public void setKompLangit(ArrayList<ItemPenilaian> KompLangit) {
        this.KompLangit = KompLangit;
    }

    /**
     * @return the KompAtap
     */
    public ArrayList<ItemPenilaian> getKompAtap() {
        return KompAtap;
    }

    /**
     * @param KompAtap the KompAtap to set
     */
    public void setKompAtap(ArrayList<ItemPenilaian> KompAtap) {
        this.KompAtap = KompAtap;
    }

    /**
     * @return the KompLantai
     */
    public ArrayList<ItemPenilaian> getKompLantai() {
        return KompLantai;
    }

    /**
     * @param KompLantai the KompLantai to set
     */
    public void setKompLantai(ArrayList<ItemPenilaian> KompLantai) {
        this.KompLantai = KompLantai;
    }

    /**
     * @return the PersenPenyusutan
     */
    public Double getPersenPenyusutan() {
        return PersenPenyusutan;
    }

    /**
     * @param PersenPenyusutan the PersenPenyusutan to set
     */
    public void setPersenPenyusutan(Double PersenPenyusutan) {
        this.PersenPenyusutan = PersenPenyusutan;
    }

    /**
     * @return the FasilitasTdkSusut
     */
    public ArrayList<ItemPenilaian> getFasilitasTdkSusut() {
        return FasilitasTdkSusut;
    }

    /**
     * @param FasilitasTdkSusut the FasilitasTdkSusut to set
     */
    public void setFasilitasTdkSusut(ArrayList<ItemPenilaian> FasilitasTdkSusut) {
        this.FasilitasTdkSusut = FasilitasTdkSusut;
    }

    /**
     * @return the ThnPenilaian
     */
    public String getThnPenilaian() {
        return ThnPenilaian;
    }

    /**
     * @param ThnPenilaian the ThnPenilaian to set
     */
    public void setThnPenilaian(String ThnPenilaian) {
        this.ThnPenilaian = ThnPenilaian;
    }

    /**
     * @return the jpb
     */
    public String getJpb() {
        return jpb;
    }

    /**
     * @param jpb the jpb to set
     */
    public void setJpb(String jpb) {
        this.jpb = jpb;
    }

    /**
     * @return the KompFasilitas
     */
    public FasilitasBangunan getKompFasilitas() {
        return KompFasilitas;
    }

    /**
     * @param KompFasilitas the KompFasilitas to set
     */
    public void setKompFasilitas(FasilitasBangunan KompFasilitas) {
        this.KompFasilitas = KompFasilitas;
    }


}
