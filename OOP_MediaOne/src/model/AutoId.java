/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ha
 */
public class AutoId {
    private String id;
    
    public String autoId(String tableName, String charId) {
        int count = 0;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select count(1) from " + tableName  ;
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            
            if (rs.next()) {                
                count = rs.getInt(1)+1;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return charId + count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static void main(String[] args) {
        AutoId id = new AutoId();
        System.out.println(id.autoId("employee", "EM"));
    }
}
