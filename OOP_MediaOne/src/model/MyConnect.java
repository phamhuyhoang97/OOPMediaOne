/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Khoa Nguyen
 */
public class MyConnect {
    
    private static MyConnect myConnect;
    private static final String className = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    
    private Connection connection;
    
    
    private MyConnect() throws SQLException {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, "");
//            System.out.println("Connect success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (SQLException e) {
            System.out.println("Error connection!");
        }
    }

    public static MyConnect getInstance() throws SQLException{
        if(myConnect == null){
            System.out.println("Khoi tao ket noi");
            myConnect = new MyConnect();
        }
        else if(myConnect.getConnection().isClosed()){
            
        }
        return myConnect;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    // connect to database
    
    
    public void freeConnect(){
        try{
            connection.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
