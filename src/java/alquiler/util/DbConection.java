/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author THEBEST
 */
public class DbConection {

  private static DbConection instance;
    public DbConection() {
    }
     public static DbConection getInstance(){
        if (instance == null){
            instance = new DbConection();
        }
        return instance;
    }   
       public Connection getConnection(){
        Connection cn = null;
        try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");            
            //Conexion a la BD
            String url = "jdbc:mysql://localhost:3306/biciweb";            
            cn = DriverManager.getConnection(url, "root","root");            
                        
        }catch(ClassNotFoundException ex1){
            System.err.println("ERROR: " + ex1.getMessage());
        }catch(SQLException ex2){
            System.err.println("CODIGO: " + ex2.getErrorCode());
            System.err.println("ERROR: " + ex2.getMessage());
        }        
        return cn;
    }  
       
          public void close(Connection cn){
        try{
            if(cn != null)
                cn.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }    
    public void close(Statement stm){
        try{
            if(stm != null)
                stm.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public void close(ResultSet rs){
        try{
            if(rs != null)
                rs.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
     
    
    
}
