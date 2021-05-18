package com.model.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    private java.sql.Connection conn;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String pass = "123456";
    private final String db = "undoredo";
    private final String url = "jdbc:mysql://localhost/"+db+"";
    
    public DBManager(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // Connect?
            if(conn != null)
                System.out.println("Conexión establecida exitosamente");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Conexión Fallida:\n\n"+ex);
        }
    }
    
    public java.sql.Connection getConnection(){
        return conn;
    }
    
    public void CloseAll(PreparedStatement PS, ResultSet RS) {
        try {
            PS.close();
            RS.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
