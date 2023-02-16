/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class TestSec {
    public static void main(String[]args) {
        try {
          String asli = "admin";
          System.out.println(asli);
          String encrypted = SecEncryptDecrypt.EncryptText(asli);
          System.out.println(encrypted);
          String decrypted = SecEncryptDecrypt.DecryptText(encrypted);
          System.out.println(decrypted);
        } catch (Exception e) {
            
        }
    }
}
