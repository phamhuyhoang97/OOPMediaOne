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
public class BillBook {
    private String idBill;
    private String idBook;
    private int billAmount;
    
    // Them 1 book vao hoa don
    public void addBookToBill(BillBook billbook){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "insert into bill_book values (?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
            prepareStatement.setString(2, billbook.getIdBook());
            prepareStatement.setString(3, String.valueOf(billbook.getBillAmount()));
            
            System.out.println(prepareStatement);
            int rs = prepareStatement.executeUpdate();
            
            Book book = new Book();
            book.updateBookAmountById(billbook.getIdBook(), billbook.getBillAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //lay don gia cua san pham
    public double priceBook(BillBook billbook){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        ResultSet rs = null;
        double price = 0;
        try {
            String sql = "select bookPrice from bill_book natural join book where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
            rs = prepareStatement.executeQuery();
            rs.next();
            price = Double.parseDouble(rs.getString("bookPrice"));
            System.out.println(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
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
            Book book = new Book();
            book.updateBookAmountById(billbook.getIdBook(), -billbook.getBillAmount());
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
            String sql = "select idBill, bookName, billAmount from bill_book natural join book where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billbook.getIdBill());
            System.out.println(prepareStatement);
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
