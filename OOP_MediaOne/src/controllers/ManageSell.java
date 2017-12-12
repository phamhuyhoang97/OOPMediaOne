/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.AutoId;
import model.Bill;
import model.BillBook;
import model.BillFilm;
import model.BillMusic;
import model.Book;
import model.Film;
import model.Music;

/**
 *
 * @author hoang
 */
public class ManageSell {
    public double addBookToBill(String bookName, int amount, String idBill, double price) throws SQLException{
        //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        
        // Tim idBook theo bookName 
        Book bk = new Book();
        bk.setBookName(bookName);
        ResultSet rs = bk.findBookByName(bk);
        rs.next();
        System.out.println("IdBook: "+rs.getString("idBook"));
        bk.setIdBook(rs.getString("idBook"));
        
        // Tao book ket noi vao bill
        BillBook bb = new BillBook();
        bb.setIdBook(bk.getIdBook());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.addBookToBill(bb);
        price = price + bb.priceBook(bb)*amount;
        bill.updatePriceBill(bill, idBill, price);
        return price;
    }
    
    public double deleteBookToBill(String bookName, int amount, String idBill, double price) throws SQLException{
        //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        
        // Tim idBook theo bookName 
        Book bk = new Book();
        bk.setBookName(bookName);
        ResultSet rs = bk.findBookByName(bk);
        rs.next();
        System.out.println("IdBook: "+rs.getString("idBook"));
        bk.setIdBook(rs.getString("idBook"));
        
        // Tao book ket noi vao bill
        BillBook bb = new BillBook();
        bb.setIdBook(bk.getIdBook());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.deleteBookToBill(bb);
        price = price - bb.priceBook(bb)*amount;
        
        return price;
    }
    
    public double addMusicToBill(String musicName, int amount, String idBill, double price) throws SQLException{
        
        //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        // Tim idmusic theo musicName 
        Music bk = new Music();
        bk.setMusicName(musicName);
        ResultSet rs = bk.findMusicByName(bk);
        rs.next();
        System.out.println("IdMusic: "+rs.getString("idMusic"));
        bk.setIdMusic(rs.getString("idMusic"));
        
        // Tao music ket noi vao bill
        BillMusic bb = new BillMusic();
        bb.setIdMusic(bk.getIdMusic());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.addMusicToBill(bb);
        price = price + bb.priceMusic(bb)*amount;
        
        return price;
    }
    
    public double deleteMusicToBill(String musicName, int amount, String idBill, double price) throws SQLException{
        //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        
        // Tim idMusic theo musicName 
        Music bk = new Music();
        bk.setMusicName(musicName);
        ResultSet rs = bk.findMusicByName(bk);
        rs.next();
        System.out.println("IdMusic: "+rs.getString("idMusic"));
        bk.setIdMusic(rs.getString("idMusic"));
        
        // Tao music ket noi vao bill
        BillMusic bb = new BillMusic();
        bb.setIdMusic(bk.getIdMusic());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.deleteMusicToBill(bb);
        price = price - bb.priceMusic(bb)*amount;
        
        return price;
    }
    public double addFilmToBill(String filmName, int amount, String idBill, double price) throws SQLException{
       //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        
        // Tim idFilm theo filmName 
        Film bk = new Film();
        bk.setFilmName(filmName);
        ResultSet rs = bk.findFilmByName(bk);
        rs.next();
        System.out.println("IdFilm: "+rs.getString("idFilm"));
        bk.setIdFilm(rs.getString("idFilm"));
        
        // Tao film ket noi vao bill
        BillFilm bb = new BillFilm();
        bb.setIdFilm(bk.getIdFilm());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.addFilmToBill(bb);
        price = price + bb.priceFilm(bb)*amount;
        
        return price;
    }
    
    public double deleteFilmToBill(String filmName, int amount, String idBill, double price) throws SQLException{
     
        //Tao bill moi
        Bill bill  = new Bill();
        bill.setBillType(1);
        bill.setBillTotal(price);
        bill.addBill(bill);
        // Tim idFilm theo filmName 
        Film bk = new Film();
        bk.setFilmName(filmName);
        ResultSet rs = bk.findFilmByName(bk);
        rs.next();
        System.out.println("IdFilm: "+rs.getString("idFilm"));
        bk.setIdFilm(rs.getString("idFilm"));
        
        // Tao book ket noi vao bill
        BillFilm bb = new BillFilm();
        bb.setIdFilm(bk.getIdFilm());
        bb.setIdBill(idBill);
        bb.setBillAmount(amount);
        
        System.out.println("Amount: "+ bb.getBillAmount());
        bb.deleteFilmToBill(bb);
        price = price - bb.priceFilm(bb)*amount;
        
        return price;
    }
    
    public void searchBillDetails(DefaultTableModel model, String itemText, String idBill, String Name, int amount) throws SQLException{
        ResultSet rs = null;
        BillBook bb = new BillBook();
        BillMusic bm = new BillMusic();
        BillFilm bf = new BillFilm();
        
        if (itemText.equals("Sách")) {
            // Tim idBook theo bookName 
            Book bk = new Book();
            bk.setBookName(Name);
            rs = bk.findBookByName(bk);
            rs.next();
            System.out.println("IdBook: "+rs.getString("idBook"));
            bk.setIdBook(rs.getString("idBook"));

            // Tao book ket noi vao bill
            bb.setIdBook(bk.getIdBook());
            bb.setIdBill(idBill);
            bb.setBillAmount(amount);
            rs = bb.findBookOfBill(bb);
            System.out.println(bb.getBillAmount() + "   " + bb.getIdBill() + "  "+ bb.getIdBook());
        } else if(itemText.equals("Đĩa Nhạc")) {
            // Tim idBook theo bookName 
            Music mu = new Music();
            mu.setMusicName(Name);
            rs = mu.findMusicByName(mu);
            rs.next();
            System.out.println("IdBook: "+rs.getString("idMusic"));
            mu.setIdMusic(rs.getString("idMusic"));

            // Tao book ket noi vao bill
            bm.setIdMusic(mu.getIdMusic());
            bm.setIdBill(idBill);
            bm.setBillAmount(amount);
            rs = bm.findMusicOfBill(bm);
            System.out.println(bb.getBillAmount() + "   " + bb.getIdBill() + "  "+ bb.getIdBook());
        }
        else
        {
            // Tim idBook theo bookName 
            Film mu = new Film();
            mu.setFilmName(Name);
            rs = mu.findFilmByName(mu);
            rs.next();
            System.out.println("IdBook: "+rs.getString("idFilm"));
            mu.setIdFilm(rs.getString("idFilm"));

            // Tao book ket noi vao bill
            bf.setIdFilm(mu.getIdFilm());
            bf.setIdBill(idBill);
            bf.setBillAmount(amount);
            rs = bf.findFilmOfBill(bf);
            System.out.println(bb.getBillAmount() + "   " + bb.getIdBill() + "  "+ bb.getIdBook());
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
        String []colsName = {"ID Hóa Đơn", "Tên Sản Phẩm", "Số Lượng"};
        model.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        
    }
    
    
    
}
