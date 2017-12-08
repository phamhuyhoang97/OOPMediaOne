/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hoang
 */
public class Employee {
    public enum checkAdmin {
        employee, manager;
    }
    
    private String idEmployee;
    private String employeeName;
    private String employeePhone;
    private String employeeEmail;
    private String employeePassword;
    private String employeeAddress;
    private double employeeSalary;
    private int status;
    private checkAdmin checkAdmin;
    private String beginDate;
    private String endDate;

    //xoa nhan vien
    public void deleteEmployee(Employee employee){
        
    }
    
    //sua thong tin nhan vien
    public void changeEmployee(Employee employee){
        
    }
    
    //truy xuat du lieu len bang
    public ResultSet view(){
        
    }
    
    //them Nhan vien
    public void addEmployee(Employee employee){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        Employee employ = null;
        AutoId id = new AutoId();
        idEmployee = id.autoId("employee", "EM");
        try {
            String sql = "insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, idEmployee);
            prepareStatement.setString(2, employee.getEmployeeName());
            prepareStatement.setString(3, employee.getEmployeePhone());
            prepareStatement.setString(4, employee.getEmployeeEmail());
            prepareStatement.setString(5, employee.getEmployeePassword());
            prepareStatement.setString(6, employee.getEmployeeAddress());
            prepareStatement.setString(7, String.valueOf(employee.getEmployeeSalary()));
            prepareStatement.setString(8, String.valueOf(employee.getStatus()));
            prepareStatement.setString(9, String.valueOf(employee.checkAdmin));
            
            ResultSet resultSet = prepareStatement.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employ;
    }
    
    //tim nhan vien theo id
    public ResultSet searchEmployeeById(Employee employee){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        ResultSet rs = null;
        try {
            String sql = "select * from employee where idEmployee = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getIdEmployee());
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    //tim nhan vien theo ten
    public Employee searchEmployeeByName (Employee employee){
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        Employee employ = null;
        try {
            String sql = "select * from employee where employeeName = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getEmployeeName());
            ResultSet resultSet = prepareStatement.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employ;
    } 
    
    //dang nhap cho nhan vien
    public static Employee login(String username, String password) throws ClassNotFoundException {
        //Them ket noi CSDL vao duoi
        MyConnect connect = new MyConnect();
        Connection connection = connect.connect();
        Employee employee = null;
        try {
            String sql = "select * from employee where employeeEmail = ? and employeePassword = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString("idEmployee"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setEmployeePhone(resultSet.getString("employeePhone"));
                employee.setEmployeeEmail(resultSet.getString("employeeEmail"));
                employee.setEmployeePassword(resultSet.getString("employeePassword"));
                employee.setEmployeeAddress(resultSet.getString("employeeAddress"));
                employee.setEmployeeSalary(Integer.parseInt(resultSet.getString("employeeSalary")));
                employee.setStatus(Integer.parseInt(resultSet.getString("status")));
                employee.setCheckAdmin(employee.checkAdmin.valueOf(resultSet.getString("checkAdmin")));
                employee.setBeginDate(resultSet.getString("beginDate"));
                employee.setEndDate(resultSet.getString("endDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
    
    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public checkAdmin getCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(checkAdmin checkAdmin) {
        this.checkAdmin = checkAdmin;
    }
    
    
    
}
