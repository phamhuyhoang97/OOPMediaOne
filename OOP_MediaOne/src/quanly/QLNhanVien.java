/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly;

import model.NhanVien;
import com.mysql.jdbc.Connection;
import frame.Home;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoang
 */
public class QLNhanVien {
        private final String className = "com.mysql.jdbc.Driver";
        private final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        private final String user = "root";
        private final String pass = "hoamgtb101";
 
        private static String table = "nhan_vien";//ten bang trong mysql
 
        private java.sql.Connection connection;
        
        // connect to database
        public void connect() {
                try {
                        Class.forName(className);
                        connection = DriverManager.getConnection(url, user, pass);
                        System.out.println("Connect success!");
                } catch (ClassNotFoundException e) {
                        System.out.println("Class not found!");
                } catch (SQLException e) {
                        System.out.println("Error connection!");
                }
        }
        
        //thuc hien truy xuat trong database
        public ResultSet view(){
            ResultSet result = null;
            String sql = "SELECT * FROM "+table;
            try {
                Statement statement = (Statement)connection.createStatement();
                return statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
        
        
        public void themNhanVien(NhanVien nv){
        	String sqlCommand = "insert into "+table+" value(?,?,?,?,?,?,?,?)";
        	PreparedStatement pst = null;
        	try {
				pst = connection.prepareStatement( sqlCommand);
				pst.setString(1, nv.getId());
				pst.setString(2, nv.getTenNhanVien());
                                pst.setString(3, nv.getSDT());
                                pst.setString(4, nv.getEmail());
                                pst.setString(5, nv.getDiaChi());
                                pst.setDouble(6, nv.getLuongCoBan());
                                pst.setDouble(7, nv.getHeSoLuong());
                                pst.setDouble(8, nv.getLuongNhanVien());
				if(pst.executeUpdate()>0){
					System.out.println("Insert success!");
				}
				else{
					System.out.println("Insert error!");
				}
			} catch (SQLException e) {
				System.out.println("Insert error "+ e.toString());
			}
        }
        
        public void suaNhanVien(NhanVien nv){
            String sqlCommand = "update "+table+" set  tenNhanVien = ?, sDT = ?, email = ?, "
                + "diaChi = ?, luongCoBan = ?, heSoLuong = ?, luongNhanVien = ?"
                + " where id = ?";
            PreparedStatement pst;
            try {
                pst = connection.prepareStatement(sqlCommand);
                pst.setString(8, nv.getId());
                pst.setString(1, nv.getTenNhanVien());
                pst.setString(2, nv.getSDT());
                pst.setString(3, nv.getEmail());
                pst.setString(4, nv.getDiaChi());
                pst.setDouble(5, nv.getLuongCoBan());
                pst.setDouble(6, nv.getHeSoLuong());
                pst.setDouble(7, nv.getLuongNhanVien());
                if (pst.executeUpdate() > 0) {
                    System.out.println("update success");
                } else {
                    System.out.println("update error \n");
                }
            } catch (SQLException e) {
                System.out.println("update error \n" + e.toString());
            }
        }
        
        public void xoaNhanVien(NhanVien nv){
            String sqlCommand = "delete from "+table+" where id like "+"?";
            PreparedStatement pst = null;
            try{
                pst = connection.prepareStatement(sqlCommand);
                pst.setString(1, nv.getId());
                if(pst.executeUpdate()>0){
                    System.out.println("Delete success!");
		}
                else{
                    System.out.println("Delete error!");
		}
            }catch(SQLException e){
                System.out.println("Delete error "+ e.toString());
            }
        }
        
        public ResultSet timID(NhanVien nv) {
        ResultSet rs = null;
        String sqlCommand = "select * from "+table+" where id = ?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, nv.getId());
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("search error \n" + e.toString());
        }
        return rs;
    }

    public ResultSet timTen(NhanVien nv) {
        ResultSet rs = null;
        String sqlCommand = "select * from "+table+" where tenNhanVien = ?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sqlCommand);
            // replace "?" by id
            pst.setString(1, nv.getTenNhanVien());
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("search error \n" + e.toString());
        }
        return rs;
    }
        
//        public static void main(String[] args) {
//            QLNhanVien myConnect = new QLNhanVien();
//            myConnect.connect();
//            System.out.println("2");
//            NhanVien nv = new NhanVien();
//            
            
            
//            myConnect.themNhanVien(new NhanVien("NV001", "Pham Huy Hoang", "0123456789",
//                    "h@gmail.com", "123456789", "HaNoi", 10000.0));
//    }

    
    }
        
