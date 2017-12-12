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
import java.sql.Statement;
import sun.applet.Main;


/**
 *
 * @author phamm
 */
public class OtherCost {
    private
            int idCost;
            String costDate;
            String costName;
            double costMoney;
            int costType;
            
    public ResultSet view() throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select costDate, costName, costMoney from other_cost";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getDataOtherCost() throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from other_cost;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
     public ResultSet findCostByDate(String begin, String end) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from other_cost where costDate between ? and ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, begin);
            prepareStatement.setString(1, end);
            rs = prepareStatement.executeQuery();
            
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }
     public ResultSet findCostByName(OtherCost otherCost) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from other_cost where costName = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, otherCost.getCostName());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }
     public void addCost(OtherCost otherCost) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        AutoId id = new AutoId();
        try {
            String sql = "insert into other_cost values (? , ?, ? , ? , ?) ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, id.autoId("other_cost", "OC"));
            prepareStatement.setString(2, otherCost.getCostDate());
            prepareStatement.setString(3, otherCost.getCostName());
            prepareStatement.setString(4, String.valueOf(otherCost.getCostMoney()));
            prepareStatement.setString(5, String.valueOf(otherCost.getCostType()));
            
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateCost(OtherCost otherCost) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "update other_cost set costDate = ? , costName = ? , costMoney = ? , costType = ? where idCost = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, otherCost.getCostDate());
            prepareStatement.setString(2, otherCost.getCostName());
            prepareStatement.setString(3, String.valueOf(otherCost.getCostMoney()));
            prepareStatement.setString(4, String.valueOf(otherCost.getCostType()));
            prepareStatement.setString(5, String.valueOf(otherCost.getIdCost()));
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCost(OtherCost otherCost) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "delete from other_cost where idCost=?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, String.valueOf(otherCost.getIdCost()));
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getIdCost() {
        return idCost;
    }

    public void setIdCost(int idCost) {
        this.idCost = idCost;
    }

    public String getCostDate() {
        return costDate;
    }

    public void setCostDate(String costDate) {
        this.costDate = costDate;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(double costMoney) {
        this.costMoney = costMoney;
    }

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }
    
}
