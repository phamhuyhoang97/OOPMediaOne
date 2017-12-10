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
public class Film {
     private 
        String idFilm;
        String filmName;
        String filmActor;
        double filmCost;
        double filmPrice;
        int filmAmount;
        String filmDirector;

    public ResultSet getDataFilm() {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from film;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findFilmById(Film film) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from film where idFilm = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, film.getIdFilm());
            
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findFilmByName(Film film) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from film where filmName = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, film.getFilmName());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findFilmByDirector(Film film) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from film where filmDirector = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, film.getFilmDirector());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findFilmByActor(Film film) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from film where filmActor = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, film.getFilmActor());
            rs = prepareStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }
    public void addFilm(Film film) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        AutoId id = new AutoId();
        try {
            String sql = "insert into film values (? , ?, ? , ? , ? , ? , ?) ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, id.autoId("film", "FI"));
            prepareStatement.setString(2, film.getFilmName());
            prepareStatement.setString(3, String.valueOf(film.getFilmAmount()));
            prepareStatement.setString(4, String.valueOf(film.getFilmPrice()));
            prepareStatement.setString(5, String.valueOf(film.getFilmCost()));
            prepareStatement.setString(6, film.getFilmActor());
            prepareStatement.setString(7, film.getFilmDirector());
            
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFilm(Film film) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "update film set filmName = ? , filmAmount = ? , filmPrice = ? , filmCost = ? , filmActor = ? , bookDirector = ?  ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, film.getFilmName());
            prepareStatement.setString(2, String.valueOf(film.getFilmAmount()));
            prepareStatement.setString(3, String.valueOf(film.getFilmPrice()));
            prepareStatement.setString(4, String.valueOf(film.getFilmCost()));
            prepareStatement.setString(5, film.getFilmActor());
            prepareStatement.setString(6, film.getFilmDirector());
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteFilm(Film film) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "delete from film where idFilm=?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, film.getIdFilm());
            int resultSet = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmActor() {
        return filmActor;
    }

    public void setFilmActor(String filmActor) {
        this.filmActor = filmActor;
    }

    public double getFilmCost() {
        return filmCost;
    }

    public void setFilmCost(double filmCost) {
        this.filmCost = filmCost;
    }

    public double getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(double filmPrice) {
        this.filmPrice = filmPrice;
    }

    public int getFilmAmount() {
        return filmAmount;
    }

    public void setFilmAmount(int filmAmount) {
        this.filmAmount = filmAmount;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }
    
    
    
   
   

    
}
