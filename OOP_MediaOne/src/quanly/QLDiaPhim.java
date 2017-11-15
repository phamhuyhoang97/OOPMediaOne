/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly;

import frame.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.DiaPhim;

/**
 *
 * @author Khoa Nguyen
 */
public class QLDiaPhim {
    MyConnect myConnect = new MyConnect();

    public ResultSet getDataDiaPhim() {
        ResultSet rs = null;
        String sqlCommand = "select * from diaphim";
        Statement st;
        try {
            st = myConnect.connect().createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timID(String idDiaPhim) {
        ResultSet rs = null;
        String sqlCommand = "select * from diaphim where idDiaPhim = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, idDiaPhim);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTen(String tenDiaPhim) {
        ResultSet rs = null;
        String sqlCommand = "select * from diaphim where tenDiaPhim = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, tenDiaPhim);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timDienVien(String dienVien) {
        ResultSet rs = null;
        String sqlCommand = "select * from diaphim where dienVien = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, dienVien);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timDaoDien(String daoDien) {
        ResultSet rs = null;
        String sqlCommand = "select * from diaphim where daoDien = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, daoDien);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public void themDiaPhim(DiaPhim dp) {
        String sqlCommand = "insert into diaphim value(?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace three "?" by id, Name and point of Studnet s
            pst.setString(1, dp.getIdDiaPhim());
            pst.setString(2, dp.getTenDiaPhim());
            pst.setString(3, dp.getDienVien());
            pst.setString(4, dp.getDaoDien());
            pst.setInt(5, dp.getSoLuong());
            pst.setDouble(6, dp.getGiaMua());
            pst.setDouble(7, dp.getGiaBan());
            if (pst.executeUpdate() > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert error \n");
            }
        } catch (SQLException e) {
            System.out.println("insert error \n" + e.toString());
        }
    }

    public void suaDiaPhim(String idDiaPhim, DiaPhim dp) {
        String sqlCommand = "update diaphim set tenDiaPhim = ?, dienVien = ?, daoDien = ?, soLuong = ?, "
                + "giaMua = ?, giaBan =?"
                + " where idDiaPhim = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, dp.getTenDiaPhim());
            pst.setString(2, dp.getDienVien());
            pst.setString(3, dp.getDaoDien());
            pst.setInt(4, dp.getSoLuong());
            pst.setDouble(5, dp.getGiaMua());
            pst.setDouble(6, dp.getGiaBan());
            pst.setString(7, idDiaPhim);
            if (pst.executeUpdate() > 0) {
                System.out.println("update success");
            } else {
                System.out.println("update error \n");
            }
        } catch (SQLException e) {
            System.out.println("update error \n" + e.toString());
        }
   }
    
    public void xoaDiaPhim(String idDiaPhim) {
        String sqlCommand = "delete from diaphim where idDiaPhim = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, idDiaPhim);
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
