/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Music;

/**
 *
 * @author Khoa Nguyen
 */
public class ManageMusic {
    public void loadDataMusic(DefaultTableModel model) throws SQLException {
        // create table model
        //jt_hienthisach.setModel(new DefaultTableModel());
        //DefaultTableModel model = new DefaultTableModel();
        Music music = new Music();

        // get data from database
        ResultSet rs = music.getDataMusic();
        try {
            // load column name
            ResultSetMetaData rsMD = rs.getMetaData();
            int colNumber = rsMD.getColumnCount();
            String[] arr = new String[colNumber];
            for (int i = 0; i < colNumber; i++) {
                arr[i] = rsMD.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(arr);

            // load data from database to table
            while (rs.next()) {
                for (int i = 0; i < colNumber; i++) {
                    arr[i] = rs.getString(i + 1);
                }
                model.addRow(arr);
            }

        } catch (SQLException e) {
        }
    }
    
    public void searchMusic(DefaultTableModel model, String itemText, String text) throws SQLException{
        ResultSet rs = null;
        Music music = new Music();
                
        if (itemText.equals("Tên Nhạc")) {
            music.setMusicName(text);
            rs = music.findMusicByName(music);
        }
        else if (itemText.equals("Ca Sĩ")) {
            music.setMusicSinger(text);
            rs = music.findMusicBySinger(music);
        }
        else if (itemText.equals("Thể Loại")) {
            music.setMusicCategory(text);
            rs = music.findMusicByCategory(music);
        }

        try {
            ResultSetMetaData rsMD = rs.getMetaData();
            int colNumber = rsMD.getColumnCount();
            String[] arr = new String[colNumber];
            for (int i = 0; i < colNumber; i++) {
                arr[i] = rsMD.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(arr);

            while (rs.next()) {
                for (int i = 0; i < colNumber; i++) {
                    arr[i] = rs.getString(i + 1);
                }
                model.addRow(arr);
            }

        } catch (SQLException e) {
        }
    }
    
    public void deleteMusic(String idMusic) throws SQLException{
        Music music = new Music();
        music.setIdMusic(idMusic);
        music.deleteMusic(music);
        JOptionPane.showMessageDialog(null, "Đã xóa sách xong");
    }
    
    public void addMusic(String musicName, int musicAmount, double musicPrice, double musicCost, String musicSinger, String musicCategory) throws SQLException{
        Music music = new Music();
        music.setMusicAmount(musicAmount);
        music.setMusicCategory(musicCategory);
        music.setMusicCost(musicCost);
        music.setMusicName(musicName);
        music.setMusicPrice(musicPrice);
        music.setMusicSinger(musicSinger);
        music.addMusic(music);
        JOptionPane.showMessageDialog(null, "Đã thêm sách xong");
    }
    
    public void updateMusic(String idMusic, String musicName, int musicAmount, double musicPrice, double musicCost, String musicSinger, String musicCategory) throws SQLException{
        Music music = new Music();
        music.setIdMusic(idMusic);
        music.setMusicAmount(musicAmount);
        music.setMusicCategory(musicCategory);
        music.setMusicCost(musicCost);
        music.setMusicName(musicName);
        music.setMusicPrice(musicPrice);
        music.setMusicSinger(musicSinger);
        music.updateMusic(music);
        JOptionPane.showMessageDialog(null, "Đã sửa sách xong");
    }
}
