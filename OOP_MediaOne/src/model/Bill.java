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
public class Bill {
    private String idBill;
    private String billDate;
    private int billType;
    private double billTotal;

    // Them 1 bill
    public void addBill(Bill bill) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        Employee employ = null;
        AutoId id = new AutoId();
        try {
            String sql = "insert into bill values (?, current_date(),? ,?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, id.autoId("bill", "BI"));
            prepareStatement.setString(2, String.valueOf(bill.getBillType()));
            prepareStatement.setString(3, String.valueOf(bill.getBillTotal()));
            
            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Delete 1 bill
    public void deleteBill(Bill bill) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();

        try {
            String sql = "delete from bill where idBill = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, bill.getIdBill());

            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updatePriceBill(Bill bill, String idBill, double price) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "update bill set billTotal = ? Where idBill = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setDouble(1, price);
            prepareStatement.setString(2, idBill);
            
            
            int resultSet = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Update 1 bill (tinh lai total)
    public void updateBill(Bill bill) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "update bill set billDate = ?, billTotal = ? Where idBill = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, bill.getBillDate());
            prepareStatement.setString(2, String.valueOf(bill.getBillTotal()));
            
            prepareStatement.setString(3, bill.getIdBill());
            
            int resultSet = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet searchBillById(Bill bill) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select idBill, billDate, billTotal from bill where idBill = ? and billType = 1";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, bill.getIdBill());
            
            System.out.println(prepareStatement);
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchBillByDate(Bill bill) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select idBill, billDate, billTotal from bill where billDate = ? and billType = 1";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, bill.getBillDate());
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }
    
}
