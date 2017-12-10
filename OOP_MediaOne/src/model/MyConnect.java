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
    
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String pass = "20152018";
    private final String user = "root";
    
    private static Connection connection;

    // connect to database
    public Connection connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (SQLException e) {
            System.out.println("Error connection!");
        }
        return connection;
    }
    
    public void freeConnect(){
        try{
            connection.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
