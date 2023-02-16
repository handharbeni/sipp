/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.perikanan;

import id.co.meda.apit.database.connection.DBFetching;
import id.co.meda.apit.enggine.penilaian.PenilaianBangunan;
import id.co.meda.apit.enggine.penilaian.model.NilaiBangunan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author I Putu Medagia A
 */
public class NilaiBangunanIkan {
    
    private ArrayList<NilaiBangunan> nilaiBangunanLspop;
    private double luasTotal;
    private double nilaiTotal;    
    private double nilaiPerM2;
    private String kelasBangunan;
    private double njopPerM2;
    private double nilaiKeseluruhan;

    /**
     * @return the nilaiBangunanLspop
     */
    public ArrayList<NilaiBangunan> getNilaiBangunanLspop() {
        return nilaiBangunanLspop;
    }

    /**
     * @param nilaiBangunanLspop the nilaiBangunanLspop to set
     */
    public void setNilaiBangunanLspop(ArrayList<NilaiBangunan> nilaiBangunanLspop) {
        this.nilaiBangunanLspop = nilaiBangunanLspop;
    }

    /**
     * @return the nilaiPerM2
     */
    public double getNilaiPerM2() {
        return nilaiPerM2;
    }

    /**
     * @param nilaiPerM2 the nilaiPerM2 to set
     */
    public void setNilaiPerM2(double nilaiPerM2) {
        this.nilaiPerM2 = nilaiPerM2;
    }

    /**
     * @return the kelasBangunan
     */
    public String getKelasBangunan() {
        return kelasBangunan;
    }

    /**
     * @param kelasBangunan the kelasBangunan to set
     */
    public void setKelasBangunan(String kelasBangunan) {
        this.kelasBangunan = kelasBangunan;
    }

    /**
     * @return the njopPerM2
     */
    public double getNjopPerM2() {
        return njopPerM2;
    }

    /**
     * @param njopPerM2 the njopPerM2 to set
     */
    public void setNjopPerM2(double njopPerM2) {
        this.njopPerM2 = njopPerM2;
    }

    /**
     * @return the nilaiKeseluruhan
     */
    public double getNilaiKeseluruhan() {
        return nilaiKeseluruhan;
    }

    /**
     * @param nilaiKeseluruhan the nilaiKeseluruhan to set
     */
    public void setNilaiKeseluruhan(double nilaiKeseluruhan) {
        this.nilaiKeseluruhan = nilaiKeseluruhan;
    }

    /**
     * @return the luasTotal
     */
    public double getLuasTotal() {
        return luasTotal;
    }

    /**
     * @param luasTotal the luasTotal to set
     */
    public void setLuasTotal(double luasTotal) {
        this.luasTotal = luasTotal;
    }

    /**
     * @return the nilaiTotal
     */
    public double getNilaiTotal() {
        return nilaiTotal;
    }

    /**
     * @param nilaiTotal the nilaiTotal to set
     */
    public void setNilaiTotal(double nilaiTotal) {
        this.nilaiTotal = nilaiTotal;
    }

  


}