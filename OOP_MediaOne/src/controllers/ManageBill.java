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
import model.Bill;
import model.Employee;

/**
 *
 * @author hoang
 */
public class ManageBill {
    public void searchBill(DefaultTableModel model, String itemText, String bill) throws SQLException{
        ResultSet rs = null;
        Bill bi = new Bill();
        if (itemText.equals("ID Hóa Đơn")) {
            bi.setIdBill(bill);
            rs = bi.searchBillById(bi);
            
        } else {
            bi.setBillDate(bill);
            rs = bi.searchBillByDate(bi);
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
        String []colsName = {"ID Hóa Đơn", "Ngày Xuất Hóa Đơn", "Tổng Tiền"};
        model.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        
    }
}
