/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class DBConnectionOracle {
    Connection conn = null;
    private final String CONNSTR;
    private final String USER;
    private final String PWD;
    
    public DBConnectionOracle(String connstr, String user, String pwd) {
        this.CONNSTR=connstr;
        this.USER=user;
        this.PWD=pwd;
    }
    
    public Connection getConnect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn =  DriverManager.getConnection(CONNSTR,USER,PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
