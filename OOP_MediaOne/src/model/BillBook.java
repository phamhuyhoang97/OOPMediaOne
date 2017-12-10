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
public class BillBook {
    private String idBill;
    private String idBook;
    private int billAmount;
    
    // Them 1 book vao hoa don
    public void addBookToBill(BillBook billbook){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        AutoId id = new AutoId();
        try {
            String sql = "insert into bill_book values (?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
            prepareStatement.setString(2, billbook.getIdBook());
            prepareStatement.setString(3, String.valueOf(billbook.getBillAmount()));
            
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Delte book khoi bill
    public void deleteBookToBill(BillBook billbook) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();

        try {
            String sql = "delete from bill_book where idBill = ? and idBook = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
            prepareStatement.setString(2, billbook.getIdBook());
           
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Update book khoi bill
    public void updateBookToBill(BillBook billbook) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "update bill_book set billAmount = ? Where idBill = ? and idBook = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, String.valueOf(billbook.getBillAmount()));
            prepareStatement.setString(2, billbook.getIdBill());
            prepareStatement.setString(2, billbook.getIdBook());
                                
            int rs = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Find all book of bill 
    public ResultSet findBookOfBill(BillBook billbook) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        ResultSet rs = null;
        try {
            String sql = "select * from bill_book where idBill = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
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

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
    
    
    
}
