/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.enggine.penilaian.khusus.tower;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class TestTower {
    public static void main(String[]args) {
        PenilaianTower penil = new PenilaianTower("317301000100100010", "2003");
        penil.mulaiPenilaian();
        
    }
}
