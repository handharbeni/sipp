/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

import java.util.ArrayList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class HitunganAhsTower {
    private String thnPenilaian;
    private ArrayList<ItemAhsTower> listPembersihan;
    private ArrayList<ItemAhsTower> listPsgBowplank;
    private ArrayList<ItemAhsTower> listTiangPancang;
    private ArrayList<ItemAhsTower> listGaliTanah;
    private ArrayList<ItemAhsTower> listPtgTiangPancang;
    private ArrayList<ItemAhsTower> listBuangTanah;
    private ArrayList<ItemAhsTower> listUrugTnhKembali;
    private ArrayList<ItemAhsTower> listPlatGali;
    private ArrayList<ItemAhsTower> listPlatUrugPasir;
    private ArrayList<ItemAhsTower> listPlatLantaiKerja;
    private ArrayList<ItemAhsTower> listPlatPembesian;
    private ArrayList<ItemAhsTower> listPlatCorK75;
    private ArrayList<ItemAhsTower> listBalokGali;
    private ArrayList<ItemAhsTower> listBalokUrugPasir;
    private ArrayList<ItemAhsTower> listBalokLantaiKerja;
    private ArrayList<ItemAhsTower> listBalokPembesian;
    private ArrayList<ItemAhsTower> listBalokPengecoran;
    private ArrayList<ItemAhsTower> listKolomBekisting;
    private ArrayList<ItemAhsTower> listKolomPembesian;
    private ArrayList<ItemAhsTower> listKolomPengecoran;
    private ArrayList<ItemAhsTower> listCatMeni;
    private ArrayList<ItemAhsTower> listPasangTower;

    public Double getTotListPembersihan() {return getTotalList(listPembersihan); }
    public Double getTotListPsgBowplank() {return getTotalList(listPsgBowplank); }
    public Double getTotListTiangPancang() {return getTotalList(listTiangPancang); }
    public Double getTotListGaliTanah() {return getTotalList(listGaliTanah); }
    public Double getTotListPtgTiangPancang() {return getTotalList(listPtgTiangPancang); }
    public Double getTotListBuangTanah() {return getTotalList(listBuangTanah); }
    public Double getTotListUrugTnhKembali() {return getTotalList(listUrugTnhKembali); }
    public Double getTotListPlatGali() {return getTotalList(listPlatGali); }
    public Double getTotListPlatUrugPasir() {return getTotalList(listPlatUrugPasir); }
    public Double getTotListPlatLantaiKerja() {return getTotalList(listPlatLantaiKerja); }
    public Double getTotListPlatPembesian() {return getTotalList(listPlatPembesian); }
    public Double getTotListPlatCorK75() {return getTotalList(listPlatCorK75); }
    public Double getTotListBalokGali() {return getTotalList(listBalokGali); }
    public Double getTotListBalokUrugPasir() {return getTotalList(listBalokUrugPasir); }
    public Double getTotListBalokLantaiKerja() {return getTotalList(listBalokLantaiKerja); }
    public Double getTotListBalokPembesian() {return getTotalList(listBalokPembesian); }
    public Double getTotListBalokPengecoran() {return getTotalList(listBalokPengecoran); }
    public Double getTotListKolomBekisting() {return getTotalList(listKolomBekisting); }
    public Double getTotListKolomPembesian() {return getTotalList(listKolomPembesian); }
    public Double getTotListKolomPengecoran() {return getTotalList(listKolomPengecoran); }
    public Double getTotListCatMeni() {return getTotalList(listCatMeni); }
    public Double getTotListPasangTower() {return getTotalList(listPasangTower); }
    
    private Double getTotalList(ArrayList<ItemAhsTower> list) {
        Double total =0.0;
        for (int i=0;i<list.size();i++) {
            total = total + list.get(i).getHrgSatuan();
        }
        return total;
    }
    
    public HitunganAhsTower(String thnPenilaian) {
        this.thnPenilaian=thnPenilaian;
    }

    /**
     * @return the thnPenilaian
     */
    public String getThnPenilaian() {
        return thnPenilaian;
    }

    /**
     * @param thnPenilaian the thnPenilaian to set
     */
    public void setThnPenilaian(String thnPenilaian) {
        this.thnPenilaian = thnPenilaian;
    }

    /**
     * @return the listPembersihan
     */
    public ArrayList<ItemAhsTower> getListPembersihan() {
        return listPembersihan;
    }

    /**
     * @param listPembersihan the listPembersihan to set
     */
    public void setListPembersihan(ArrayList<ItemAhsTower> listPembersihan) {
        this.listPembersihan = listPembersihan;
    }

    /**
     * @return the listPsgBowplank
     */
    public ArrayList<ItemAhsTower> getListPsgBowplank() {
        return listPsgBowplank;
    }

    /**
     * @param listPsgBowplank the listPsgBowplank to set
     */
    public void setListPsgBowplank(ArrayList<ItemAhsTower> listPsgBowplank) {
        this.listPsgBowplank = listPsgBowplank;
    }

    /**
     * @return the listTiangPancang
     */
    public ArrayList<ItemAhsTower> getListTiangPancang() {
        return listTiangPancang;
    }

    /**
     * @param listTiangPancang the listTiangPancang to set
     */
    public void setListTiangPancang(ArrayList<ItemAhsTower> listTiangPancang) {
        this.listTiangPancang = listTiangPancang;
    }

    /**
     * @return the listGaliTanah
     */
    public ArrayList<ItemAhsTower> getListGaliTanah() {
        return listGaliTanah;
    }

    /**
     * @param listGaliTanah the listGaliTanah to set
     */
    public void setListGaliTanah(ArrayList<ItemAhsTower> listGaliTanah) {
        this.listGaliTanah = listGaliTanah;
    }

    /**
     * @return the listPtgTiangPancang
     */
    public ArrayList<ItemAhsTower> getListPtgTiangPancang() {
        return listPtgTiangPancang;
    }

    /**
     * @param listPtgTiangPancang the listPtgTiangPancang to set
     */
    public void setListPtgTiangPancang(ArrayList<ItemAhsTower> listPtgTiangPancang) {
        this.listPtgTiangPancang = listPtgTiangPancang;
    }

    /**
     * @return the listBuangTanah
     */
    public ArrayList<ItemAhsTower> getListBuangTanah() {
        return listBuangTanah;
    }

    /**
     * @param listBuangTanah the listBuangTanah to set
     */
    public void setListBuangTanah(ArrayList<ItemAhsTower> listBuangTanah) {
        this.listBuangTanah = listBuangTanah;
    }

    /**
     * @return the listUrugTnhKembali
     */
    public ArrayList<ItemAhsTower> getListUrugTnhKembali() {
        return listUrugTnhKembali;
    }

    /**
     * @param listUrugTnhKembali the listUrugTnhKembali to set
     */
    public void setListUrugTnhKembali(ArrayList<ItemAhsTower> listUrugTnhKembali) {
        this.listUrugTnhKembali = listUrugTnhKembali;
    }

    /**
     * @return the listPlatGali
     */
    public ArrayList<ItemAhsTower> getListPlatGali() {
        return listPlatGali;
    }

    /**
     * @param listPlatGali the listPlatGali to set
     */
    public void setListPlatGali(ArrayList<ItemAhsTower> listPlatGali) {
        this.listPlatGali = listPlatGali;
    }

    /**
     * @return the listPlatUrugPasir
     */
    public ArrayList<ItemAhsTower> getListPlatUrugPasir() {
        return listPlatUrugPasir;
    }

    /**
     * @param listPlatUrugPasir the listPlatUrugPasir to set
     */
    public void setListPlatUrugPasir(ArrayList<ItemAhsTower> listPlatUrugPasir) {
        this.listPlatUrugPasir = listPlatUrugPasir;
    }

    /**
     * @return the listPlatLantaiKerja
     */
    public ArrayList<ItemAhsTower> getListPlatLantaiKerja() {
        return listPlatLantaiKerja;
    }

    /**
     * @param listPlatLantaiKerja the listPlatLantaiKerja to set
     */
    public void setListPlatLantaiKerja(ArrayList<ItemAhsTower> listPlatLantaiKerja) {
        this.listPlatLantaiKerja = listPlatLantaiKerja;
    }

    /**
     * @return the listPlatPembesian
     */
    public ArrayList<ItemAhsTower> getListPlatPembesian() {
        return listPlatPembesian;
    }

    /**
     * @param listPlatPembesian the listPlatPembesian to set
     */
    public void setListPlatPembesian(ArrayList<ItemAhsTower> listPlatPembesian) {
        this.listPlatPembesian = listPlatPembesian;
    }

    /**
     * @return the listPlatCorK75
     */
    public ArrayList<ItemAhsTower> getListPlatCorK75() {
        return listPlatCorK75;
    }

    /**
     * @param listPlatCorK75 the listPlatCorK75 to set
     */
    public void setListPlatCorK75(ArrayList<ItemAhsTower> listPlatCorK75) {
        this.listPlatCorK75 = listPlatCorK75;
    }

    /**
     * @return the listBalokGali
     */
    public ArrayList<ItemAhsTower> getListBalokGali() {
        return listBalokGali;
    }

    /**
     * @param listBalokGali the listBalokGali to set
     */
    public void setListBalokGali(ArrayList<ItemAhsTower> listBalokGali) {
        this.listBalokGali = listBalokGali;
    }

    /**
     * @return the listBalokUrugPasir
     */
    public ArrayList<ItemAhsTower> getListBalokUrugPasir() {
        return listBalokUrugPasir;
    }

    /**
     * @param listBalokUrugPasir the listBalokUrugPasir to set
     */
    public void setListBalokUrugPasir(ArrayList<ItemAhsTower> listBalokUrugPasir) {
        this.listBalokUrugPasir = listBalokUrugPasir;
    }

    /**
     * @return the listBalokLantaiKerja
     */
    public ArrayList<ItemAhsTower> getListBalokLantaiKerja() {
        return listBalokLantaiKerja;
    }

    /**
     * @param listBalokLantaiKerja the listBalokLantaiKerja to set
     */
    public void setListBalokLantaiKerja(ArrayList<ItemAhsTower> listBalokLantaiKerja) {
        this.listBalokLantaiKerja = listBalokLantaiKerja;
    }

    /**
     * @return the listBalokPembesian
     */
    public ArrayList<ItemAhsTower> getListBalokPembesian() {
        return listBalokPembesian;
    }

    /**
     * @param listBalokPembesian the listBalokPembesian to set
     */
    public void setListBalokPembesian(ArrayList<ItemAhsTower> listBalokPembesian) {
        this.listBalokPembesian = listBalokPembesian;
    }

    /**
     * @return the listBalokPengecoran
     */
    public ArrayList<ItemAhsTower> getListBalokPengecoran() {
        return listBalokPengecoran;
    }

    /**
     * @param listBalokPengecoran the listBalokPengecoran to set
     */
    public void setListBalokPengecoran(ArrayList<ItemAhsTower> listBalokPengecoran) {
        this.listBalokPengecoran = listBalokPengecoran;
    }

    /**
     * @return the listKolomBekisting
     */
    public ArrayList<ItemAhsTower> getListKolomBekisting() {
        return listKolomBekisting;
    }

    /**
     * @param listKolomBekisting the listKolomBekisting to set
     */
    public void setListKolomBekisting(ArrayList<ItemAhsTower> listKolomBekisting) {
        this.listKolomBekisting = listKolomBekisting;
    }

    /**
     * @return the listKolomPembesian
     */
    public ArrayList<ItemAhsTower> getListKolomPembesian() {
        return listKolomPembesian;
    }

    /**
     * @param listKolomPembesian the listKolomPembesian to set
     */
    public void setListKolomPembesian(ArrayList<ItemAhsTower> listKolomPembesian) {
        this.listKolomPembesian = listKolomPembesian;
    }

    /**
     * @return the listKolomPengecoran
     */
    public ArrayList<ItemAhsTower> getListKolomPengecoran() {
        return listKolomPengecoran;
    }

    /**
     * @param listKolomPengecoran the listKolomPengecoran to set
     */
    public void setListKolomPengecoran(ArrayList<ItemAhsTower> listKolomPengecoran) {
        this.listKolomPengecoran = listKolomPengecoran;
    }

    /**
     * @return the listCatMeni
     */
    public ArrayList<ItemAhsTower> getListCatMeni() {
        return listCatMeni;
    }

    /**
     * @param listCatMeni the listCatMeni to set
     */
    public void setListCatMeni(ArrayList<ItemAhsTower> listCatMeni) {
        this.listCatMeni = listCatMeni;
    }

    /**
     * @return the listPasangTower
     */
    public ArrayList<ItemAhsTower> getListPasangTower() {
        return listPasangTower;
    }

    /**
     * @param listPasangTower the listPasangTower to set
     */
    public void setListPasangTower(ArrayList<ItemAhsTower> listPasangTower) {
        this.listPasangTower = listPasangTower;
    }
    
}
