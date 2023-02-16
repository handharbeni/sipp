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
public class KomponenMaterial {
    public static void hitungDindingDalam(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listMatDinDal) {
        if (lspop.getDinDalamStr().trim().length()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINDAL", lspop.getDinDalamStr(), 
                    lspop.getJmlLtBng(), thnPenilaian, "Struktur Utama", lspop.getLsBngUtama()+lspop.getLsBngLain(), 
                    listMatDinDal);
        }
        if (lspop.getDinDalamBsm().trim().length()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINDAL", lspop.getDinDalamBsm(), 
                    lspop.getJmlLtBase(), thnPenilaian, "Basement", lspop.getLsBase(), listMatDinDal);
            
        }
    }
    
    public static void hitungDindingLuar(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listMatDinLuar) {
        if (lspop.getDinLuarKacaJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Kaca", 
                    lspop.getDinLuarKacaJmlLt(), thnPenilaian, "Kaca", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarKacaJmlLt(), 
                    listMatDinLuar);            
        }
        if (lspop.getDinLuarSengJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Seng", 
                    lspop.getDinLuarSengJmlLt(), thnPenilaian, "Seng", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarSengJmlLt(), 
                    listMatDinLuar);            
        }
        if (lspop.getDinLuarBetonJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Beton", 
                    lspop.getDinLuarBetonJmlLt(), thnPenilaian, "Beton", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarBetonJmlLt(), 
                    listMatDinLuar);            
        }
        if (lspop.getDinLuarPasBatuJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Batu", 
                    lspop.getDinLuarPasBatuJmlLt(), thnPenilaian, "Batu", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarPasBatuJmlLt(), 
                    listMatDinLuar);            
        }
        if (lspop.getDinLuarCelconJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Celcon", 
                    lspop.getDinLuarCelconJmlLt(), thnPenilaian, "Celcon", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarCelconJmlLt(), 
                    listMatDinLuar);            
        }
        if (lspop.getDinLuarKayuJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("MATDINLUAR", "Kayu", 
                    lspop.getDinLuarKayuJmlLt(), thnPenilaian, "Kayu", lspop.getLsBngPerLantaiUtama()*lspop.getDinLuarKayuJmlLt(), 
                    listMatDinLuar);            
        }
    }

    public static void hitungPelDindingDalam(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listPelDinDal) {
        if (lspop.getPelDalamKacaImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Kaca Impor", 
                    lspop.getPelDalamKacaImporStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamKacaImporStrJmlLt().toString()+" Lantai Utama: Kaca Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamKacaImporStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamKacaImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Kaca Impor", 
                    lspop.getPelDalamKacaImporBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamKacaImporBsmJmlLt().toString()+" Lantai Basement: Kaca Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamKacaImporBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamKacaLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Kaca Lokal", 
                    lspop.getPelDalamKacaLokalStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamKacaLokalStrJmlLt().toString()+" Lantai Utama: Kaca Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamKacaLokalStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamKacaLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Kaca Lokal", 
                    lspop.getPelDalamKacaLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamKacaLokalBsmJmlLt().toString()+" Lantai Basement: Kaca Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamKacaLokalBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamMarmerImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Marmer Impor", 
                    lspop.getPelDalamMarmerImporStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamMarmerImporStrJmlLt().toString()+" Lantai Utama: Marmer Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamMarmerImporStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamMarmerImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Marmer Impor", 
                    lspop.getPelDalamMarmerImporBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamMarmerImporBsmJmlLt().toString()+" Lantai Basement: Marmer Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamMarmerImporBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamMarmerLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Marmer Lokal", 
                    lspop.getPelDalamMarmerLokalStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamMarmerLokalStrJmlLt().toString()+" Lantai Utama: Marmer Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamMarmerLokalStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamMarmerLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Marmer Lokal", 
                    lspop.getPelDalamMarmerLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamMarmerLokalBsmJmlLt().toString()+" Lantai Basement: Marmer Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamMarmerLokalBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamCatStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Cat", 
                    lspop.getPelDalamCatStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamCatStrJmlLt().toString()+" Lantai Utama: Cat", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamCatStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamCatBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Cat", 
                    lspop.getPelDalamCatBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamCatBsmJmlLt().toString()+" Lantai Basement: Cat", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamCatBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamWallpaperStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Wallpaper", 
                    lspop.getPelDalamWallpaperStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamWallpaperStrJmlLt().toString()+" Lantai Utama: Wallpaper", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamWallpaperStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamWallpaperBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Wallpaper", 
                    lspop.getPelDalamWallpaperBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamWallpaperBsmJmlLt().toString()+" Lantai Basement: Wallpaper", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamWallpaperBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamGranitImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Granit Impor", 
                    lspop.getPelDalamGranitImporStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamGranitImporStrJmlLt().toString()+" Lantai Utama: Granit Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamGranitImporStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamGranitImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Granit Impor", 
                    lspop.getPelDalamGranitImporBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamGranitImporBsmJmlLt().toString()+" Lantai Basement: Granit Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamGranitImporBsmJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamGranitLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Granit Lokal", 
                    lspop.getPelDalamGranitLokalStrJmlLt(), thnPenilaian, 
                    lspop.getPelDalamGranitLokalStrJmlLt().toString()+" Lantai Utama: Granit Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamGranitLokalStrJmlLt(), listPelDinDal);            
        }
        if (lspop.getPelDalamGranitLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINDAL", "Granit Lokal", 
                    lspop.getPelDalamGranitLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getPelDalamGranitLokalBsmJmlLt().toString()+" Lantai Basement: Granit Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelDalamGranitLokalBsmJmlLt(), listPelDinDal);            
        }
        
    }
    
    public static void hitungPelDindingLuar(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listPelDinLuar) {
        if (lspop.getPelLuarGranitImporJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Granit Impor", 
                    lspop.getPelLuarGranitImporJmlLt(), thnPenilaian, 
                    lspop.getPelLuarGranitImporJmlLt().toString()+" Lantai : Granit Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarGranitImporJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarMarmerImporJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Marmer Impor", 
                    lspop.getPelLuarMarmerImporJmlLt(), thnPenilaian, 
                    lspop.getPelLuarMarmerImporJmlLt().toString()+" Lantai : Marmer Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarMarmerImporJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarKacaImporJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Kaca Impor", 
                    lspop.getPelLuarKacaImporJmlLt(), thnPenilaian, 
                    lspop.getPelLuarKacaImporJmlLt().toString()+" Lantai : Kaca Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarKacaImporJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarGranitLokalJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Granit Lokal", 
                    lspop.getPelLuarGranitLokalJmlLt(), thnPenilaian, 
                    lspop.getPelLuarGranitLokalJmlLt().toString()+" Lantai : Granit Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarGranitLokalJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarMarmerLokalJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Marmer Lokal", 
                    lspop.getPelLuarMarmerLokalJmlLt(), thnPenilaian, 
                    lspop.getPelLuarMarmerLokalJmlLt().toString()+" Lantai : Marmer Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarMarmerLokalJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarKacaLokalJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Kaca Lokal", 
                    lspop.getPelLuarKacaLokalJmlLt(), thnPenilaian, 
                    lspop.getPelLuarKacaLokalJmlLt().toString()+" Lantai : Kaca Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarKacaLokalJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarKeramikStdJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Keramik Standar", 
                    lspop.getPelLuarKeramikStdJmlLt(), thnPenilaian, 
                    lspop.getPelLuarKeramikStdJmlLt().toString()+" Lantai : Keramik Standar", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarKeramikStdJmlLt(),listPelDinLuar);            
        }
        if (lspop.getPelLuarCatJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("PELDINLUAR", "Cat", 
                    lspop.getPelLuarCatJmlLt(), thnPenilaian, 
                    lspop.getPelLuarCatJmlLt().toString()+" Lantai : Cat", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getPelLuarCatJmlLt(),listPelDinLuar);            
        }
    }
    
    public static void hitungKompLangit(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listKompLangit) {
        if (lspop.getLangitGipsumStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Gypsum", 
                    lspop.getLangitGipsumStrJmlLt(), thnPenilaian, 
                    lspop.getLangitGipsumStrJmlLt().toString()+" Lantai Utama: Gypsum", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitGipsumStrJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitGipsumBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Gypsum", 
                    lspop.getLangitGipsumBsmJmlLt(), thnPenilaian, 
                    lspop.getLangitGipsumBsmJmlLt().toString()+" Lantai Basement: Gypsum", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitGipsumBsmJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitAkustikStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Akustik", 
                    lspop.getLangitAkustikStrJmlLt(), thnPenilaian, 
                    lspop.getLangitAkustikStrJmlLt().toString()+" Lantai Utama: Akustik", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitAkustikStrJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitAkustikBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Akustik", 
                    lspop.getLangitAkustikBsmJmlLt(), thnPenilaian, 
                    lspop.getLangitAkustikBsmJmlLt().toString()+" Lantai Basement: Akustik", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitAkustikBsmJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitTriplekStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Triplek", 
                    lspop.getLangitTriplekStrJmlLt(), thnPenilaian, 
                    lspop.getLangitTriplekStrJmlLt().toString()+" Lantai Utama: Triplek", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitTriplekStrJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitTriplekBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Triplek", 
                    lspop.getLangitTriplekBsmJmlLt(), thnPenilaian, 
                    lspop.getLangitTriplekBsmJmlLt().toString()+" Lantai Basement: Triplek", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitTriplekBsmJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitEternitStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Eternit", 
                    lspop.getLangitEternitStrJmlLt(), thnPenilaian, 
                    lspop.getLangitEternitStrJmlLt().toString()+" Lantai Utama: Eternit", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitEternitStrJmlLt(), listKompLangit);            
        }
        if (lspop.getLangitEternitBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANGIT", "Eternit", 
                    lspop.getLangitEternitBsmJmlLt(), thnPenilaian, 
                    lspop.getLangitEternitBsmJmlLt().toString()+" Lantai Basement: Eternit", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLangitEternitBsmJmlLt(), listKompLangit);            
        }
    }
    
    public static void hitungKompAtap(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listKompAtap) {
        if (lspop.getAtap().trim().length()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPATAP", lspop.getAtap(), 
                    lspop.getJmlLtBng(), thnPenilaian, lspop.getAtap(), lspop.getLsBngPerLantaiUtama(), 
                    listKompAtap);
        }
    }
    
    public static void hitungKompLantai(LspopNonStandar lspop, String thnPenilaian, ArrayList<ItemPenilaian> listKompLantai) {
        if (lspop.getLantaiGranitImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Granit Impor", 
                    lspop.getLantaiGranitImporStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiGranitImporStrJmlLt().toString()+" Lantai Utama: Granit Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiGranitImporStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiGranitImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Granit Impor", 
                    lspop.getLantaiGranitImporBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiGranitImporBsmJmlLt().toString()+" Lantai Basement: Granit Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiGranitImporBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiMarmerImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Marmer Impor", 
                    lspop.getLantaiMarmerImporStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiMarmerImporStrJmlLt().toString()+" Lantai Utama: Marmer Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiMarmerImporStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiMarmerImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Marmer Impor", 
                    lspop.getLantaiMarmerImporBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiMarmerImporBsmJmlLt().toString()+" Lantai Basement: Marmer Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiMarmerImporBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiMarmerLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Marmer Lokal", 
                    lspop.getLantaiMarmerLokalStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiMarmerLokalStrJmlLt().toString()+" Lantai Utama: Marmer Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiMarmerLokalStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiMarmerLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Marmer Lokal", 
                    lspop.getLantaiMarmerLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiMarmerLokalBsmJmlLt().toString()+" Lantai Basement: Marmer Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiMarmerLokalBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiGranitLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Granit Lokal", 
                    lspop.getLantaiGranitLokalStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiGranitLokalStrJmlLt().toString()+" Lantai Utama: Granit Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiGranitLokalStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiGranitLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Granit Lokal", 
                    lspop.getLantaiGranitLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiGranitLokalBsmJmlLt().toString()+" Lantai Basement: Granit Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiGranitLokalBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKarpetImporStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Karpet Impor", 
                    lspop.getLantaiKarpetImporStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiKarpetImporStrJmlLt().toString()+" Lantai Utama: Karpet Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKarpetImporStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKarpetImporBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Karpet Impor", 
                    lspop.getLantaiKarpetImporBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiKarpetImporBsmJmlLt().toString()+" Lantai Basement: Karpet Impor", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKarpetImporBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKeramikStdStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Keramik Standar", 
                    lspop.getLantaiKeramikStdStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiKeramikStdStrJmlLt().toString()+" Lantai Utama: Keramik Standar", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKeramikStdStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKeramikStdBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Keramik Standar", 
                    lspop.getLantaiKeramikStdBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiKeramikStdBsmJmlLt().toString()+" Lantai Basement: Keramik Standar", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKeramikStdBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiVinilStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Vinil", 
                    lspop.getLantaiVinilStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiVinilStrJmlLt().toString()+" Lantai Utama: Vinil", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiVinilStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiVinilBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Vinil", 
                    lspop.getLantaiVinilBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiVinilBsmJmlLt().toString()+" Lantai Basement: Vinil", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiVinilBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKarpetLokalStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Karpet Lokal", 
                    lspop.getLantaiKarpetLokalStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiKarpetLokalStrJmlLt().toString()+" Lantai Utama: Karpet Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKarpetLokalStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKarpetLokalBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Karpet Lokal", 
                    lspop.getLantaiKarpetLokalBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiKarpetLokalBsmJmlLt().toString()+" Lantai Basement: Karpet Lokal", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKarpetLokalBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKayuStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Lantai Kayu", 
                    lspop.getLantaiKayuStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiKayuStrJmlLt().toString()+" Lantai Utama: Lantai Kayu", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKayuStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiKayuBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Lantai Kayu", 
                    lspop.getLantaiKayuBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiKayuBsmJmlLt().toString()+" Lantai Basement: Lantai Kayu", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiKayuBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiUbinStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Ubin Abu-abu", 
                    lspop.getLantaiUbinStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiUbinStrJmlLt().toString()+" Lantai Utama: Ubin Abu-abu", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiUbinStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiUbinBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Ubin Abu-abu", 
                    lspop.getLantaiUbinBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiUbinBsmJmlLt().toString()+" Lantai Basement: Ubin Abu-abu", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiUbinBsmJmlLt(), listKompLantai);            
        }
       if (lspop.getLantaiTerasoStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Teraso", 
                    lspop.getLantaiTerasoStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiTerasoStrJmlLt().toString()+" Lantai Utama: Teraso", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiTerasoStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiTerasoBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Teraso", 
                    lspop.getLantaiTerasoBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiTerasoBsmJmlLt().toString()+" Lantai Basement: Teraso", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiTerasoBsmJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiSemenStrJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Semen", 
                    lspop.getLantaiSemenStrJmlLt(), thnPenilaian, 
                    lspop.getLantaiSemenStrJmlLt().toString()+" Lantai Utama: Semen", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiSemenStrJmlLt(), listKompLantai);            
        }
        if (lspop.getLantaiSemenBsmJmlLt()>0) {
            ambilNilaiDbMasukkanKeItemPenilaian("KOMPLANTAI", "Semen", 
                    lspop.getLantaiSemenBsmJmlLt(), thnPenilaian, 
                    lspop.getLantaiSemenBsmJmlLt().toString()+" Lantai Basement: Semen", 
                    lspop.getLsBngPerLantaiUtama()*lspop.getLantaiSemenBsmJmlLt(), listKompLantai);            
        }
        
    }
    
    private static void ambilNilaiDbMasukkanKeItemPenilaian(String kdAmbilField, String nmKomp, 
            Integer jmlLt, String thn, String nmItem, Double lsBng, ArrayList<ItemPenilaian> listItemPenil) {
            String nmField = ambilNmField(kdAmbilField,nmKomp);
            Double nilaiNya = DBFetching.getDoubleResult("select " 
              +nmField + " from rslt_material where jmlh_lt="+jmlLt.toString()
              +" and thn_rslt='"+thn+"'");
            ItemPenilaian itemPenil = new ItemPenilaian();
            ToolsPenilaian.isiItemPenilaian(nmItem, lsBng, 
                    "m2", nmField, nilaiNya, itemPenil, listItemPenil);
        
    } 
    
    private static String ambilNmField(String kdAmbilField, String nmKomp) {
        String nmField="";
        switch (kdAmbilField) {
            case "MATDINDAL" :
                switch (nmKomp) {
                    case "Gypsum Import": nmField="AA1"; break;
                    case "Gypsum Lokal": nmField="BA1"; break;
                    case "Pas ddg 1/2 batu": nmField="DA2"; break;
                    case "Triplex": nmField="DA1"; break;
                    case "Plywood": nmField="CA1"; break;
                    default: nmField="";    
                }
                break;
            case "MATDINLUAR" :
                switch (nmKomp) {
                    case "Kaca": nmField="BB1"; break;
                    case "Seng": nmField="DB2"; break;
                    case "Beton": nmField="AB1"; break;
                    case "Batu": nmField="DB1"; break;
                    case "Celcon": nmField="CB1"; break;
                    case "Kayu": nmField="CB2"; break;
                    default: nmField="";    
                }
                break;
            case "PELDINDAL" :
                switch (nmKomp) {
                    case "Kaca Impor": nmField="AC1"; break;
                    case "Kaca Lokal": nmField="CC1"; break;
                    case "Marmer Impor": nmField="CC3"; break;
                    case "Marmer Lokal": nmField="DC2"; break;
                    case "Cat": nmField="DC4"; break;
                    case "Wallpaper": nmField="BC1"; break;
                    case "Granit Impor": nmField="CC2"; break;
                    case "Granit Lokal": nmField="DC1"; break;
                    case "Keramik": nmField="DC3"; break;
                    default: nmField="";    
                }
                break;
            case "PELDINLUAR" :
                switch (nmKomp) {
                    case "Granit Impor": nmField="AD1"; break;
                    case "Marmer Impor": nmField="AD2"; break;
                    case "Kaca Impor": nmField="BD1"; break;
                    case "Granit Lokal": nmField="CD1"; break;
                    case "Marmer Lokal": nmField="CD2"; break;
                    case "Kaca Lokal": nmField="CD3"; break;
                    case "Keramik Standar": nmField="DD1"; break;
                    case "Cat": nmField="DD2"; break;
                    default: nmField="";    
                }
                break;
            case "KOMPLANGIT" :
                switch (nmKomp) {
                    case "Gypsum": nmField="AE1"; break;
                    case "Akustik": nmField="BE1"; break;
                    case "Triplek": nmField="CE1"; break;
                    case "Eternit": nmField="DE1"; break;
                    default: nmField="";    
                }
                break;
            case "KOMPATAP" :
                switch (nmKomp) {
                    case "Pelat Beton": nmField="AF1"; break;
                    case "Genteng Pres Btn": nmField="CF1"; break;
                    case "Seng Gelombang": nmField="DF4"; break;
                    case "Genteng Tanah Liat": nmField="DF3"; break;
                    case "Gtg Keramik": nmField="BF1"; break;
                    case "Asbes Gelombang": nmField="DF1"; break;
                    case "Genteng Sirap": nmField="DF2"; break;
                    case "Spandek": nmField="DF4"; break; //ini catatan : belum ada di DBKB nilainya
                    default: nmField="";    
                }
                break;
            case "KOMPLANTAI" :
                switch (nmKomp) {
                    case "Granit Impor": nmField="AG1"; break;
                    case "Marmer Impor": nmField="AG2"; break;
                    case "Marmer Lokal": nmField="BG1"; break;
                    case "Granit Lokal": nmField="BG2"; break;
                    case "Karpet Impor": nmField="CG1"; break;
                    case "Keramik Standar": nmField="DG1"; break;
                    case "Vinil": nmField="DG2"; break;
                    case "Karpet Lokal": nmField="DG3"; break;
                    case "Lantai Kayu": nmField="DG4"; break;
                    case "Ubin Abu-abu": nmField="DG5"; break;
                    case "Teraso": nmField="DG6"; break;
                    case "Semen": nmField="DG7"; break;
                    default: nmField="";    
                }
                break;
        }
        return nmField;
    }
}
