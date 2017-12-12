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
public class BillMusic {
    private String idBill;
    private String idMusic;
    private int billAmount;
    
    // Them 1 book vao hoa don
    public void addMusicToBill(BillMusic billmusic) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "insert into bill_music values (?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billmusic.getIdBill());
            prepareStatement.setString(2, billmusic.getIdMusic());
            prepareStatement.setString(3, String.valueOf(billmusic.getBillAmount()));
            
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //lay don gia cua san pham
    public double priceMusic(BillMusic  billmusic) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        double price = 0;
        try {
            String sql = "select musicPrice from bill_music natural join music where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billmusic.getIdBill());
            rs = prepareStatement.executeQuery();
            rs.next();
            price = Double.parseDouble(rs.getString("musicPrice"));
            System.out.println(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
    
    //Delte book khoi bill
    public void deleteMusicToBill(BillMusic billmusic) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();

        try {
            String sql = "delete from bill_music where idBill = ? and idMusic = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billmusic.getIdBill());
            prepareStatement.setString(2, billmusic.getIdMusic());
           
            int rs = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Update book khoi bill
    public void updateMusicToBill(BillMusic billmusic) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
       
        try {
            String sql = "update bill_music set billAmount = ? Where idBill = ? and idMusic = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, String.valueOf(billmusic.getBillAmount()));
            prepareStatement.setString(2, billmusic.getIdBill());
            prepareStatement.setString(2, billmusic.getIdMusic());
                                
            int rs = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Find all book of bill 
    public ResultSet findMusicOfBill(BillMusic billmusic) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select idBill, musicName, billAmount from bill_music natural join music where idBill = ? ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, billmusic.getIdBill());
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

    public String getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(String idMusic) {
        this.idMusic = idMusic;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
    
}
