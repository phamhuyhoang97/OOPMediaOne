/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ha
 */
public class Bill {
    private String idBill;
    private String billDate;
    private int billType;
    private double billTotal;
    private double idEmployee;

    // Them 1 bill
    public void addBill(Bill bill) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        Employee employ = null;
        AutoId id = new AutoId();
        try {
            String sql = "insert into bill values (?, ?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, id.autoId("bill", "BI"));
            prepareStatement.setString(2, bill.getBillDate());
            prepareStatement.setString(3, String.valueOf(bill.getBillType()));
            prepareStatement.setString(4, String.valueOf(bill.getBillTotal()));
            prepareStatement.setString(5, String.valueOf(bill.getIdEmployee()));
                        
            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Delete 1 bill
    public void deleteBill(Bill bill) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();

        try {
            String sql = "delete from bill where idBill = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, bill.getIdBill());

            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Update 1 bill (tinh lai total)
    public void updateBill(Bill bill) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
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
    
    public double getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(double idEmployee) {
        this.idEmployee = idEmployee;
    }
    
}
