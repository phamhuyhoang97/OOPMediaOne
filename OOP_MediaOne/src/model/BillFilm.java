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
public class BillFilm {
    
    private String idBill;
    private String idFilm;
    private int billAmount;
    
    // Them 1 book vao hoa don
    public void addFilmToBill(BillFilm billfilm){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "insert into bill_film values (?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billfilm.getIdBill());
            prepareStatement.setString(2, billfilm.getIdFilm());
            prepareStatement.setString(3, String.valueOf(billfilm.getBillAmount()));
            
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //lay don gia cua san pham
    public double priceFilm(BillFilm billfilm){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        ResultSet rs = null;
        double price = 0;
        try {
            String sql = "select filmPrice from bill_film natural join film where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billfilm.getIdBill());
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
    public void deleteFilmToBill(BillFilm billfilm) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();

        try {
            String sql = "delete from bill_film where idBill = ? and idFilm = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billfilm.getIdBill());
            prepareStatement.setString(2, billfilm.getIdFilm());
           
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Update book khoi bill
    public void updateFilmToBill(BillFilm billfilm) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "update bill_film set billAmount = ? Where idBill = ? and idFilm = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, String.valueOf(billfilm.getBillAmount()));
            prepareStatement.setString(2, billfilm.getIdBill());
            prepareStatement.setString(2, billfilm.getIdFilm());
                                
            int rs = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Find all book of bill 
    public ResultSet findFilmOfBill(BillFilm billfilm) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        ResultSet rs = null;
        try {
            String sql = "select idBill, bookFilm, billAmount from bill_film natural join film where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billfilm.getIdBill());
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

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
    
}
