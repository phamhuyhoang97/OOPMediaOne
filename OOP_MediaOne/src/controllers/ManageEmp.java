/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import view.Home;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Employee;


/**
 *
 * @author hoang
 */
public class ManageEmp {
    
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    //lay du lieu o o nhap
    public void setData(Employee nv, String employeeName, String employeePhone, 
            String employeeEmail, String employeeAddress, String employeeSalary, String employeePassword){
        
        nv.setEmployeeName(employeeName);
        nv.setEmployeePhone(employeePhone);
        nv.setEmployeeEmail(employeeEmail);
        nv.setEmployeeAddress(employeeAddress);
        nv.setEmployeeSalary(Double.parseDouble(employeeSalary)*1000);
        nv.setEmployeePassword(employeePassword);
        nv.setStatus(1);
        nv.setCheckAdmin(1);
    }
    
    //luu du lieu len  DefaultTableModel de jt_hienthinhanvien doc
    public void updateData(ResultSet rs, DefaultTableModel tableModel){
            try {
                while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                    String rows[] = new String[7];
                    for(int i=0; i<7; i++){
                        rows[i] = rs.getString(i+1); // lấy dữ liệu tại cột số i (ứng với mã hàng)
                        System.out.println(rows[i]);
                    }
                    tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
                    //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }    
    
    public void deleteEmp(String idEmployee){
        Employee nv = new Employee();
        
        nv.setIdEmployee(idEmployee);
        nv.deleteEmployeeByUpdateStatus(nv);
        //xoa thong tin nhanvien
        JOptionPane.showMessageDialog(null, "Đã xoa' nhân viên xong");
    }
    
    public void changeEmp(String employeeName, String employeePhone, 
            String employeeEmail, String employeeAddress, String employeeSalary, String employeePassword){
        
        Employee nv = new Employee();
        //them dieu kien de xet xem da co Nhan Vien nay trong database chua
        
        //them thuoc tinh NhanVien
        setData(nv, employeeName, employeePhone, employeeEmail, employeeAddress, employeeSalary, employeePassword);
        
        //them vao database
        nv.changeEmployee(nv);
        
        JOptionPane.showMessageDialog(null, "Đã sửa nhân viên xong");
    }
    
    public void showEmp(DefaultTableModel tableModel){
        Employee nv = new Employee();
        //
        String []colsName = {"ID Nhân Viên", "Họ Tên Nhân Viên", "SDT", "Email", "Địa Chỉ",
             "Lương Nhân Viên", "Ngày Bắt Đầu Làm"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        tableModel.setRowCount(0);  //de refresh lai bang jtable
        
        updateData(nv.view(), tableModel);   //truy xuat du lieu len bang
        System.out.println("ok");
    }
           
    public void addEmp(String employeeName, String employeePhone, 
        String employeeEmail, String employeeAddress, String employeeSalary, String employeePassword){
        Employee nv = new Employee();
        //them dieu kien de xet xem da co Nhan Vien nay trong database chua
        
        //them thuoc tinh NhanVien
        setData(nv, employeeName, employeePhone, employeeEmail, employeeAddress, employeeSalary, employeePassword);
        
        //them vao database
        nv.addEmployee(nv);
        
        JOptionPane.showMessageDialog(null, "Đã thêm nhân viên xong");
    }
    
    
    public void searchEmp(DefaultTableModel model, String itemText, String employee){
        ResultSet rs = null;
        Employee nv = new Employee();
        
        if (itemText.equals(" ID Nhân Viên")) {
            nv.setIdEmployee(employee);
            rs = nv.searchEmployeeById(nv);
        } else {
            nv.setEmployeeName(employee);
            rs = nv.searchEmployeeByName(nv);
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
        String []colsName = {"ID Nhân Viên", "Họ Tên Nhân Viên", "SDT", "Email", "Địa Chỉ",
             "Lương Nhân Viên", "Ngày Bắt Đầu Làm"};
        model.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        
    }
}
