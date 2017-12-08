/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Khoa Nguyen
 */
public class MyConnect {
    
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String user = "root";
    
    private Connection connection;

    // connect to database
    public Connection connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, "");
            System.out.println("Connect success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (SQLException e) {
            System.out.println("Error connection!");
        }
        return connection;
    }
}
