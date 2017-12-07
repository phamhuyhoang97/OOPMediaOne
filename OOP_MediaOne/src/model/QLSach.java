/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import frame.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Sach;

/**
 *
 * @author Khoa Nguyen
 */
public class QLSach {
    MyConnect myConnect = new MyConnect();

    public ResultSet getDataSach() {
        ResultSet rs = null;
        String sqlCommand = "select * from sach";
        Statement st;
        try {
            st = myConnect.connect().createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timID(String idSach) {
        ResultSet rs = null;
        String sqlCommand = "select * from sach where idSach = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, idSach);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTen(String tenSach) {
        ResultSet rs = null;
        String sqlCommand = "select * from sach where tenSach = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, tenSach);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTacGia(String tacGia) {
        ResultSet rs = null;
        String sqlCommand = "select * from sach where tacGia = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, tacGia);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timNhaXuatBan(String nhaXuatBan) {
        ResultSet rs = null;
        String sqlCommand = "select * from sach where nhaXuatBan = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, nhaXuatBan);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public void themSach(Sach s) {
        String sqlCommand = "insert into sach value(?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace three "?" by id, Name and point of Studnet s
            pst.setString(1, s.getIdSach());
            pst.setString(2, s.getTenSach());
            pst.setString(3, s.getTacGia());
            pst.setString(4, s.getNhaXuatBan());
            pst.setInt(5, s.getSoLuong());
            pst.setDouble(6, s.getGiaMua());
            pst.setDouble(7, s.getGiaBan());
            if (pst.executeUpdate() > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert error \n");
            }
        } catch (SQLException e) {
            System.out.println("insert error \n" + e.toString());
        }
    }

    public void suaSach(String idSach, Sach s) {
        String sqlCommand = "update sach set tenSach = ?, tacGia = ?, nhaXuatBan = ?, soLuong = ?, "
                + "giaMua = ?, giaBan =?"
                + " where idSach = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, s.getTenSach());
            pst.setString(2, s.getTacGia());
            pst.setString(3, s.getNhaXuatBan());
            pst.setInt(4, s.getSoLuong());
            pst.setDouble(5, s.getGiaMua());
            pst.setDouble(6, s.getGiaBan());
            pst.setString(7, idSach);
            if (pst.executeUpdate() > 0) {
                System.out.println("update success");
            } else {
                System.out.println("update error \n");
            }
        } catch (SQLException e) {
            System.out.println("update error \n" + e.toString());
        }
   }
    
    public void xoaSach(String idSach) {
        String sqlCommand = "delete from sach where idSach = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, idSach);
            if (pst.executeUpdate() > 0) {
                System.out.println("delete success");
            } else {
                System.out.println("delete error \n");
            }
        } catch (SQLException e) {
            System.out.println("delete error \n" + e.toString());
        }
    }
}
