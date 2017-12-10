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
import model.Book;

/**
 *
 * @author Khoa Nguyen
 */
public class ManageBook {
    
    public void loadDataBook(DefaultTableModel model) {
        // create table model
        //jt_hienthisach.setModel(new DefaultTableModel());
        //DefaultTableModel model = new DefaultTableModel();
        Book book = new Book();

        // get data from database
        ResultSet rs = book.getDataBook();
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
        //jt_hienthisach.setModel(model);
    }
    
    public void searchBook(DefaultTableModel model, String itemText, String text){
        ResultSet rs = null;
        Book book = new Book();
                
        if (itemText.equals("Tên Sách")) {
            book.setBookName(text);
            rs = book.findBookByName(book);
        }
        else if (itemText.equals("Tác Giả")) {
            book.setBookAuthor(text);
            rs = book.findBookByAuthor(book);
        }
        else if (itemText.equals("Nhà Xuất Bản")) {
            book.setBookPublic(text);
            rs = book.findBookByPublic(book);
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
        //jt_hienthisach.setModel(model);
    }
    
    public void deleteBook(String idBook){
        Book book = new Book();
        book.setIdBook(idBook);
        book.deleteBook(book);
        JOptionPane.showMessageDialog(null, "Đã xóa sách xong");
    }
    
    public void addBook(String bookName, int bookAmount, double bookPrice, double bookCost, String bookAuthor, String bookPublic){
        Book book = new Book();
        book.setBookAmount(bookAmount);
        book.setBookAuthor(bookAuthor);
        book.setBookCost(bookCost);
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookPublic(bookPublic);
        book.addBook(book);
        JOptionPane.showMessageDialog(null, "Đã thêm sách xong");
    }
    
    public void updateBook(String idBook, String bookName, int bookAmount, double bookPrice, double bookCost, String bookAuthor, String bookPublic){
        Book book = new Book();
        book.setIdBook(idBook);
        book.setBookAmount(bookAmount);
        book.setBookAuthor(bookAuthor);
        book.setBookCost(bookCost);
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookPublic(bookPublic);
        book.updateBook(book);
        JOptionPane.showMessageDialog(null, "Đã sửa sách xong");
    }
}
