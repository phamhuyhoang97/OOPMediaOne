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
public class Book {

    private 
        String idBook;
        String bookName;
        String bookAuthor;
        double bookCost;
        double bookPrice;
        int bookAmount;
        String bookPublic;
    
    public ResultSet getDataBook() {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from book;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findBookById(Book book) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from book where idBook = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            prepareStatement.setString(1, book.getIdBook());
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findBookByName(Book book) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from book where bookName = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            prepareStatement.setString(1, book.getBookName());
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findBookByAuthor(Book book) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from book where bookAuthor = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            prepareStatement.setString(1, book.getBookAuthor());
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet findBookByPublic(Book book) {
        ResultSet rs = null;
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "select * from book where bookPublic = ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            prepareStatement.setString(1, book.getBookPublic());
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }
    public void addBook(Book book) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "insert into book values (? , ?, ? , ? , ? , ? , ?) ";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, book.getIdBook());
            prepareStatement.setString(2, book.getBookName());
            prepareStatement.setString(3, String.valueOf(book.getBookAmount()));
            prepareStatement.setString(4, String.valueOf(book.getBookPrice()));
            prepareStatement.setString(5, String.valueOf(book.getBookCost()));
            prepareStatement.setString(6, book.getBookAuthor());
            prepareStatement.setString(7, book.getBookPublic());
            ResultSet resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "update book set bookName = ? , bookAmount = ? , bookPrice = ? , bookCost = ? , bookAuthor = ? , bookPublic = ?  where idBook = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, book.getBookName());
            prepareStatement.setString(2, String.valueOf(book.getBookAmount()));
            prepareStatement.setString(3, String.valueOf(book.getBookPrice()));
            prepareStatement.setString(4, String.valueOf(book.getBookCost()));
            prepareStatement.setString(5, book.getBookAuthor());
            prepareStatement.setString(6, book.getBookPublic());
            prepareStatement.setString(7, book.getIdBook());
            ResultSet resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(Book book) {
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        try {
            String sql = "delete from book where idBook=?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, book.getIdBook());
            ResultSet resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookCost() {
        return bookCost;
    }

    public void setBookCost(double bookCost) {
        this.bookCost = bookCost;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    public String getBookPublic() {
        return bookPublic;
    }

    public void setBookPublic(String bookPublic) {
        this.bookPublic = bookPublic;
    }
    
   

}
