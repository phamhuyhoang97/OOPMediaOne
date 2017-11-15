/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly;

import java.sql.*;
import frame.MyConnect;
import java.sql.PreparedStatement;
import model.DiaNhac;

/**
 *
 * @author Khoa Nguyen
 */
public class QLDiaNhac {

    MyConnect myConnect = new MyConnect();

    public ResultSet getDataDiaNhac() {
        ResultSet rs = null;
        String sqlCommand = "select * from dianhac";
        Statement st;
        try {
            st = myConnect.connect().createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timID(String idDiaNhac) {
        ResultSet rs = null;
        String sqlCommand = "select * from dianhac where idDiaNhac = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, idDiaNhac);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTen(String tenDiaNhac) {
        ResultSet rs = null;
        String sqlCommand = "select * from dianhac where tenDiaNhac = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, tenDiaNhac);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timCaSi(String tenCaSi) {
        ResultSet rs = null;
        String sqlCommand = "select * from dianhac where tenCaSi = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, tenCaSi);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTheLoai(String theLoai) {
        ResultSet rs = null;
        String sqlCommand = "select * from dianhac where theLoai = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, theLoai);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("select error \n" + e.toString());
        }
        return rs;
    }

    public void themDiaNhac(DiaNhac dn) {
        String sqlCommand = "insert into dianhac value(?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            // replace three "?" by id, Name and point of Studnet s
            pst.setString(1, dn.getIdDiaNhac());
            pst.setString(2, dn.getTenDiaNhac());
            pst.setString(3, dn.gettenCaSi());
            pst.setString(4, dn.getTheLoai());
            pst.setInt(5, dn.getSoLuong());
            pst.setDouble(6, dn.getGiaMua());
            pst.setDouble(7, dn.getGiaBan());
            if (pst.executeUpdate() > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert error \n");
            }
        } catch (SQLException e) {
            System.out.println("insert error \n" + e.toString());
        }
    }

    public void suaDiaNhac(String idDiaNhac, DiaNhac dn) {
        String sqlCommand = "update dianhac set tenDiaNhac = ?, tenCaSi = ?, theLoai = ?, soLuong = ?, "
                + "giaMua = ?, giaBan =?"
                + " where idDiaNhac = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, dn.getTenDiaNhac());
            pst.setString(2, dn.gettenCaSi());
            pst.setString(3, dn.getTheLoai());
            pst.setInt(4, dn.getSoLuong());
            pst.setDouble(5, dn.getGiaMua());
            pst.setDouble(6, dn.getGiaBan());
            pst.setString(7, idDiaNhac);
            if (pst.executeUpdate() > 0) {
                System.out.println("update success");
            } else {
                System.out.println("update error \n");
            }
        } catch (SQLException e) {
            System.out.println("update error \n" + e.toString());
        }
   }
    
    public void xoaDiaNhac(String idDiaNhac) {
        String sqlCommand = "delete from dianhac where idDiaNhac = ?";
        PreparedStatement pst;
        try {
            pst = myConnect.connect().prepareStatement(sqlCommand);
            pst.setString(1, idDiaNhac);
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
