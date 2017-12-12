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
public class Music {
     private 
        String idMusic;
        String musicName;
        int musicAmount;
        double musicCost;
        double musicPrice;
        String musicSinger;
        String musicCategory;

    public ResultSet getDataMusic() throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from music ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findMusicById(Music music) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from music where idMusic = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, music.getIdMusic());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findMusicByName(Music music) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from music where musicName = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, music.getMusicName());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findMusicByCategory(Music music) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from music where musicCategory = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, music.getMusicCategory());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findMusicBySinger(Music music) throws SQLException {
        ResultSet rs = null;
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "select * from music where musicSinger = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            prepareStatement.setString(1, music.getMusicSinger());
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }
    public void addMusic(Music music) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        AutoId id = new AutoId();
        try {
            String sql = "insert into music values (? , ?, ? , ? , ? , ? , ?) ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, id.autoId("music", "MU"));
            prepareStatement.setString(2, music.getMusicName());
            prepareStatement.setString(3, String.valueOf(music.getMusicAmount()));
            prepareStatement.setString(4, String.valueOf(music.getMusicPrice()));
            prepareStatement.setString(5, String.valueOf(music.getMusicCost()));
            prepareStatement.setString(6, music.getMusicSinger());
            prepareStatement.setString(7, music.getMusicCategory());
            
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMusic(Music music) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "update music set musicName = ? , musicAmount = ? , musicPrice = ? , musicCost = ? , musicSinger = ? , bookCategory = ?  ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, music.getMusicName());
            prepareStatement.setString(2, String.valueOf(music.getMusicAmount()));
            prepareStatement.setString(3, String.valueOf(music.getMusicPrice()));
            prepareStatement.setString(4, String.valueOf(music.getMusicCost()));
            prepareStatement.setString(5, music.getMusicSinger());
            prepareStatement.setString(6, music.getMusicCategory());
                        
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMusic(Music music) throws SQLException {
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "delete from music where idMusic=?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, music.getIdMusic());
            
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(String idMusic) {
        this.idMusic = idMusic;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public double getMusicCost() {
        return musicCost;
    }

    public void setMusicCost(double musicCost) {
        this.musicCost = musicCost;
    }

    public double getMusicPrice() {
        return musicPrice;
    }

    public void setMusicPrice(double musicPrice) {
        this.musicPrice = musicPrice;
    }

    public int getMusicAmount() {
        return musicAmount;
    }

    public void setMusicAmount(int musicAmount) {
        this.musicAmount = musicAmount;
    }

    public String getMusicCategory() {
        return musicCategory;
    }

    public void setMusicCategory(String musicCategory) {
        this.musicCategory = musicCategory;
    }
    
    
    
   
   

    
}
