/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.MyConnect;
import model.OtherCost;
import model.Revenue;

/**
 *
 * @author hoang
 */
public class ManageCost {
    
    //luu du lieu len  DefaultTableModel de jt_hienthinhanvien doc
    public void updateDataCost(ResultSet rs, DefaultTableModel tableModel){
            try {
                while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                    String rows[] = new String[3];
                    for(int i=0; i<3; i++){
                        rows[i] = rs.getString(i+1);
                        System.out.println(rows[i]);// lấy dữ liệu tại cột số i (ứng với mã hàng)
                    }
                    tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
                    //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    public void showRevenue(DefaultTableModel tableModel) throws SQLException{
        OtherCost cost = new OtherCost();
        String []colsName = {"Thời Gian", "Tên Chi Phí", "Số Tiền"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        tableModel.setRowCount(0);  //de refresh lai bang jtable
        updateDataCost(cost.view(), tableModel);   //truy xuat du lieu len bang
        
    }
}
