/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.controller;

import id.co.meda.apit.database.connection.DBFetching;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class ControlLihatMaterial {
    
    private String tahunDBKB;
    private Vector <String> headerRef = new Vector<String>();
    private Vector <String> headerA = new Vector<String>();
    private Vector <String> headerB = new Vector<String>();
    private Vector <String> headerC = new Vector<String>();
    private Vector <String> headerD = new Vector<String>();
    
    public ControlLihatMaterial(String tahunDBKB)
    {
        this.tahunDBKB = tahunDBKB;
       
    }
     public ControlLihatMaterial()
    {
        this.tahunDBKB = "0";
       
    }
    
    public JComboBox getComboBoxItem(JComboBox tempCombo)
    {
        tempCombo.addItem("Pilih Tahun..");
        String sql = "select distinct thn_dhkm from ref_dhkmf";
        ResultSet set = DBFetching.getResultSet(sql);
        
        try{
           while(set.next())
           {
               tempCombo.addItem(set.getString(1));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return tempCombo;
    }
    
     public DefaultTableModel loadTableRef()
   {
        headerRef.add("Nama");
        headerRef.add("Gol A");
        headerRef.add("Gol B");
        headerRef.add("Gol C");
        headerRef.add("Gol D");
        Vector <Vector> data2 = new Vector();
        try {
            String sql = "SELECT * FROM ref_golmaterial "
                    + "where tahun = '"+tahunDBKB+"'"
                    + "ORDER BY SUBSTRING(id_golMaterial,2,1),"
                    + "SUBSTRING(id_golMaterial,1,1) ";
            ResultSet set = DBFetching.getResultSet(sql);
            
          
            
            while(set.next())
            {
                String id = set.getString("id_golMaterial");
                Vector vec = new Vector();
                vec.add(set.getString("nama"));
                if(id.substring(0,1).equalsIgnoreCase("A"))
                {
                    vec.add(set.getInt("harga"));
                    vec.add(0);
                    vec.add(0);
                    vec.add(0);
                }else if(id.substring(0,1).equalsIgnoreCase("B"))
                {
                    vec.add(0);
                    vec.add(set.getInt("harga"));
                    vec.add(0);
                    vec.add(0);
                }else if(id.substring(0,1).equalsIgnoreCase("C"))
                {
                    vec.add(0);
                    vec.add(0);
                    vec.add(set.getInt("harga"));
                    vec.add(0);
                }else if(id.substring(0,1).equalsIgnoreCase("D"))
                {
                    vec.add(0);
                    vec.add(0);
                    vec.add(0);
                   vec.add(set.getInt("harga"));
                }
                
                data2.add(vec);
         }
        
            return new DefaultTableModel(data2,headerRef){
                @Override
               public Class<?> getColumnClass(int index)
               {
                switch(index)
                {
                    case 0 : return String.class;
                    default: return Double.class; 
                       
                }
                 }
            
            };
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return new DefaultTableModel(data2,headerRef);
       
       
   }
   
    public DefaultTableModel loadTableA()
    {
         DefaultTableModel TableModel; 
           headerA.add(0,"jumlah lt");
        headerA.add(1,"A");
        headerA.add(2,"B");
        headerA.add(3,"C");
        headerA.add(4,"D1");
        headerA.add(5,"D2");
        headerA.add(6,"E");
        headerA.add(7,"F");
        headerA.add(8,"G1");
        headerA.add(9,"G2");
        Vector <Vector> data2 = new Vector<Vector>();
         try
        {
          
          String sql = "select * from rslt_material where thn_rslt ='"
                    +this.tahunDBKB+"'";
            ResultSet result = DBFetching.getResultSet(sql);
            
                while(result.next())
                        {
                            Vector vec = new Vector();
                            vec.add((Integer)result.getObject("jmlh_lt"));
                            vec.add((Double)result.getObject("AA1"));
                            vec.add((Double)result.getObject("AB1"));
                            vec.add((Double)result.getObject("AC1"));
                            vec.add((Double)result.getObject("AD1"));
                            vec.add((Double)result.getObject("AD2"));
                            vec.add((Double)result.getObject("AE1"));
                            vec.add((Double)result.getObject("AF1"));
                            vec.add((Double)result.getObject("AG1"));
                            vec.add((Double)result.getObject("AG2"));
                            
                            data2.add(vec);
                        }
                    
            
                
             return new DefaultTableModel(data2,headerA){
                            
               @Override
               public Class<?> getColumnClass(int index)
               {
                switch(index)
                {
                    default: return Double.class; 
                       
                }
                 }   
                 };
             
                
               
                }catch(Exception e) 
                {
                    e.printStackTrace(); 
                }
                
         return new DefaultTableModel (data2,headerA);
       
    }
    
    
    public DefaultTableModel loadTableB()
    {
         headerB.add(0,"jumlah lt");
         headerB.add(1,"A");
         headerB.add(2,"B");
         headerB.add(3,"C");
         headerB.add(4,"D");
         headerB.add(5,"E");
         headerB.add(6,"F");
         headerB.add(7,"G1");
         headerB.add(7,"G2");
          Vector <Vector> dataB = new Vector<Vector>();
         try
        {
            String sql = "select * from rslt_material where thn_rslt ='"
                    +this.tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next())
                        {
                            Vector vec = new Vector();
                            vec.add((Integer)result.getObject("jmlh_lt"));
                            vec.add((Double)result.getObject("BA1"));
                            vec.add((Double)result.getObject("BB1"));
                            vec.add((Double)result.getObject("BC1"));
                            vec.add((Double)result.getObject("BD1"));
                            vec.add((Double)result.getObject("BE1"));
                            vec.add((Double)result.getObject("BF1"));
                            vec.add((Double)result.getObject("BG1"));
                            vec.add((Double)result.getObject("BG2"));
                            dataB.add(vec);
                        }
                    
            
                
                return new DefaultTableModel(dataB,headerB){
                                 
                   @Override
                    public Class<?> getColumnClass(int index)
                    {
                      switch(index)
                       {
                         default: return Double.class; 
                          
                        }
                         }   
                      };
             
                
               
                }catch(Exception e) 
                {
                    e.printStackTrace(); 
                }
         
          return new DefaultTableModel(dataB,headerB);
       
    }
    
    public DefaultTableModel loadTableC()
    {
         headerC.add(0,"jumlah lt");
         headerC.add(1,"A");
         headerC.add(2,"B1");
         headerC.add(3,"B2");
         headerC.add(4,"C1");
         headerC.add(5,"C2");
         headerC.add(6,"C3");
         headerC.add(7,"D1");
         headerC.add(8,"D2");
         headerC.add(9,"D3");
         headerC.add(10,"E");
         headerC.add(11,"F");
         headerC.add(12,"G");
         Vector <Vector> data2 = new Vector<Vector>();
         
         try
        {
           
            String sql = "select * from rslt_material where thn_rslt ='"
                    +this.tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            while(result.next())
            {
             Vector vec = new Vector();
             vec.add((Integer)result.getObject("jmlh_lt"));
             vec.add((Double)result.getObject("CA1"));
             vec.add((Double)result.getObject("CB1"));
             vec.add((Double)result.getObject("CB2"));
             vec.add((Double)result.getObject("CC1"));
             vec.add((Double)result.getObject("CC2"));
             vec.add((Double)result.getObject("CD1"));
             vec.add((Double)result.getObject("CD2"));
             vec.add((Double)result.getObject("CD3"));
             vec.add((Double)result.getObject("CE1"));
             vec.add((Double)result.getObject("CF1"));
             vec.add((Double)result.getObject("CG1"));
             data2.add(vec);
            }
                    
            
                
            return new DefaultTableModel(data2,headerC){
                                 
                    
                            @Override
                             public Class<?> getColumnClass(int index)
                             {
                             switch(index)
                                {
                                 case 1 : return Integer .class;
                                 default: return Double.class; 
                                   
                                }
                                   }   
                             };
             
                
               
                }catch(Exception e) 
                {
                    e.printStackTrace(); 
                }
         
         return new DefaultTableModel(data2,headerC);
       
    }
   
   public DefaultTableModel loadTableD()
    {
         headerD.add(0,"jumlah lt");
         headerD.add(1,"A1");
         headerD.add(2,"A2");
         headerD.add(3,"B1");
         headerD.add(4,"B2");
         headerD.add(5,"C1");
         headerD.add(6,"C2");
         headerD.add(7,"C3");
         headerD.add(8,"C4");
         headerD.add(9,"D1");
         headerD.add(10,"D2");
         headerD.add(11,"E");
         headerD.add(12,"F1");
         headerD.add(13,"F2");
         headerD.add(14,"F3");
         headerD.add(15,"F4");
         headerD.add(16,"G1");
         headerD.add(17,"G2");
         headerD.add(18,"G3");
         headerD.add(19,"G4");
         headerD.add(20,"G5");
         headerD.add(21,"G6");
         ArrayList arr = new ArrayList();
         Vector <Vector> data2 = new Vector<Vector>();
                    
         try
        {
           String sql = "select * from rslt_material where thn_rslt ='"
                    +this.tahunDBKB+"'";
            
            ResultSet result = DBFetching.getResultSet(sql);
            
                    while(result.next())
                        {
                            Vector vec = new Vector();
                            vec.add((Integer)result.getObject("jmlh_lt"));
                            vec.add((Double)result.getObject("DA1"));
                            vec.add((Double)result.getObject("DA2"));
                            vec.add((Double)result.getObject("DB1"));
                            vec.add((Double)result.getObject("DB2"));
                            vec.add((Double)result.getObject("DC1"));
                            vec.add((Double)result.getObject("DC2"));
                            vec.add((Double)result.getObject("DC3"));
                            vec.add((Double)result.getObject("DC4"));
                            vec.add((Double)result.getObject("DD1"));
                            vec.add((Double)result.getObject("DD2"));
                            vec.add((Double)result.getObject("DE1"));
                            vec.add((Double)result.getObject("DF1"));
                            vec.add((Double)result.getObject("DF2"));
                            vec.add((Double)result.getObject("DF3"));
                            vec.add((Double)result.getObject("DF4"));
                            vec.add((Double)result.getObject("DG1"));
                            vec.add((Double)result.getObject("DG2"));
                            vec.add((Double)result.getObject("DG3"));
                            vec.add((Double)result.getObject("DG4"));
                            vec.add((Double)result.getObject("DG5"));
                            vec.add((Double)result.getObject("DG6"));
                            data2.add(vec);
                        }
                    
            
                
                return new DefaultTableModel(data2,headerD){
                       
                     @Override
                        public boolean isCellEditable(int row, int Column)
                       {
                           if (Column == 3)
                           return true;
                           else return false;
                                                    }
                         
                             public Class<?> getColumnClass(int index)
                             {
                             switch(index)
                                {
                                    default: return Double.class; 
                                  
                                }
                                   }   
                  
                  
             
                     };
              
                                
              
                }catch(Exception e) {
                    e.printStackTrace(); 
                }
         
            return new DefaultTableModel(data2,headerD);    
       
    }
    
}
