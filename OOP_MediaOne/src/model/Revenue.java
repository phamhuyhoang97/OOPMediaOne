/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hoang
 */
public class Revenue {
    
    
    //thuc hien truy xuat trong database
        public ResultSet view() throws SQLException{
            MyConnect connect = MyConnect.getInstance();
            Connection connection = connect.getConnection();
            ResultSet result = null;
            String sql = "select distinct billDate ThoiGian , " +
                    " (select sum(billTotal) from bill where billType = 1) DoanhThu, " +
                    " (select sum(costMoney) from other_cost where costType = 1) ChiPhiDinhKi, " +
                    " (select sum(costMoney) from other_cost where costType = 0) ChiPhiPhatSinh " +
                    "from bill, other_cost";
            try {
                Statement statement = (Statement)connection.createStatement();
                return statement.executeQuery(sql);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Có Lỗi, Hãy Nhập Lại");
            }
            return result;
        }

        
        public ResultSet profit(String tuNgay, String denNgay) throws SQLException{
            MyConnect connect = MyConnect.getInstance();
            Connection connection = connect.getConnection();
            ResultSet result = null;
            String sql = "select distinct \n" +
                "(select sum(billTotal) from bill where billType = 1)\n" +
                " -(select sum(costMoney) from other_cost ) \n" +
                "   -(select sum(employeeSalary) from employee where status = 1 and checkAdmin = 1)" +
                "from bill, other_cost, employee\n" +
                "where (billDate between '"+ tuNgay +"' and '"+ denNgay +"') "
                    + "and (costDate between '"+ tuNgay +"' and '"+ denNgay +"')";
            try {
                Statement statement = (Statement)connection.createStatement();
                return statement.executeQuery(sql);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Có Lỗi, Hãy Nhập Lại");
            }
            System.out.println(result);
            return result;
        }
        
    
}
