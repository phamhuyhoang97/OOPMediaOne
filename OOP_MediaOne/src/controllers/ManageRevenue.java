/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Revenue;
import view.Home;

/**
 *
 * @author hoang
 */
public class ManageRevenue {
    
    //luu du lieu len  DefaultTableModel de jt_hienthinhanvien doc
    public void updateDataRevenue(ResultSet rs, DefaultTableModel tableModel){
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
    
    public void showRevenue(DefaultTableModel tableModel){
        Revenue revenue = new Revenue();
        String []colsName = {"Thời Gian", "Doanh Thu", "Chi Phí"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        tableModel.setRowCount(0);  //de refresh lai bang jtable
        updateDataRevenue(revenue.view(), tableModel);   //truy xuat du lieu len bang
        
    }
    
    public double calculateProfit(String tuNgay, String denNgay){
        Revenue revenue = new Revenue();
        double profit = 0;
        ResultSet rs = null;
        
        rs = revenue.profit(tuNgay, denNgay);
        try{
            while(rs.next()){
                profit = rs.getDouble(1);
            }
        }catch(SQLException e){
            
        }
        return profit;
    }
    
}
