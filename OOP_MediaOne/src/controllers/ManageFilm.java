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
import model.Film;

/**
 *
 * @author Khoa Nguyen
 */
public class ManageFilm {
    public void loadDataFilm(DefaultTableModel model) throws SQLException {
        // create table model
        //jt_hienthisach.setModel(new DefaultTableModel());
        //DefaultTableModel model = new DefaultTableModel();
        Film film = new Film();

        // get data from database
        ResultSet rs = film.getDataFilm();
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
    
    public void searchFilm(DefaultTableModel model, String itemText, String text) throws SQLException{
        ResultSet rs = null;
        Film film = new Film();
                
        if (itemText.equals("Tên Phim")) {
            film.setFilmName(text);
            rs = film.findFilmByName(film);
        }
        else if (itemText.equals("Diễn Viên")) {
            film.setFilmActor(text);
            rs = film.findFilmByActor(film);
        }
        else if (itemText.equals("Đạo Diễn")) {
            film.setFilmDirector(text);
            rs = film.findFilmByDirector(film);
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
    
    public void deleteFilm(String idFilm) throws SQLException{
        Film film = new Film();
        film.setIdFilm(idFilm);
        film.deleteFilm(film);
        JOptionPane.showMessageDialog(null, "Đã xóa sách xong");
    }
    
    public void addFilm(String filmName, int filmAmount, double filmPrice, double filmCost, String filmActor, String filmDirector) throws SQLException{
        Film film = new Film();
        film.setFilmActor(filmActor);
        film.setFilmAmount(filmAmount);
        film.setFilmCost(filmCost);
        film.setFilmDirector(filmDirector);
        film.setFilmName(filmName);
        film.setFilmPrice(filmPrice);
        film.addFilm(film);
        JOptionPane.showMessageDialog(null, "Đã thêm sách xong");
    }
    
    public void updateFilm(String idFilm, String filmName, int filmAmount, double filmPrice, double filmCost, String filmActor, String filmDirector) throws SQLException{
        Film film = new Film();
        film.setIdFilm(idFilm);
        film.setFilmActor(filmActor);
        film.setFilmAmount(filmAmount);
        film.setFilmCost(filmCost);
        film.setFilmDirector(filmDirector);
        film.setFilmName(filmName);
        film.setFilmPrice(filmPrice);
        film.updateFilm(film);
        JOptionPane.showMessageDialog(null, "Đã sửa sách xong");
    }
}
