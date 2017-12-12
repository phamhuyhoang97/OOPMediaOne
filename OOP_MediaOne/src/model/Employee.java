/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hoang
 */
public class Employee {
    
    private String idEmployee;
    private String employeeName;
    private String employeePhone;
    private String employeeEmail;
    private String employeePassword;
    private String employeeAddress;
    private double employeeSalary;
    private int status;
    private int checkAdmin;
    private String beginDate;
    private String endDate;

    //xoa nhan vien
    public void deleteEmployee(Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        try {
            String sql = "delete from employee where idEmployee = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getIdEmployee());

            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //sua thong tin nhan vien
    public void changeEmployee(Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        int rs = 0;
        try {
            String sql = "update employee set employeeName = ?, employeePhone = ?, employeeEmail = ?,"
                    + " employeePassword = ?, employeeAddress = ?, employeeSalary = ? Where idEmployee = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            prepareStatement.setString(1, employee.getEmployeeName());
            prepareStatement.setString(2, employee.getEmployeePhone());
            prepareStatement.setString(3, employee.getEmployeeEmail());
            prepareStatement.setString(4, employee.getEmployeePassword());
            prepareStatement.setString(5, employee.getEmployeeAddress());
            prepareStatement.setString(6, String.valueOf(employee.getEmployeeSalary()));       
            prepareStatement.setString(7, employee.getIdEmployee());
            
            rs = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployeeByUpdateStatus(Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        int rs = 0;
        try {
            String sql = "update employee set status = '0', endDate = current_date() Where idEmployee = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getIdEmployee());
            rs = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //truy xuat du lieu len bang
    public ResultSet view() throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select idEmployee, employeeName, employeePhone, employeeEmail, "
                    + "employeeAddress, employeeSalary, beginDate from employee where status = '1'";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    //them Nhan vien
    public void addEmployee(Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        Employee employ = null;
        AutoId id = new AutoId();

        try {            
            String sql = "insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, current_date, null);";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, id.autoId("employee", "EM"));
            prepareStatement.setString(2, employee.getEmployeeName());
            prepareStatement.setString(3, employee.getEmployeePhone());
            prepareStatement.setString(4, employee.getEmployeeEmail());
            prepareStatement.setString(5, employee.getEmployeePassword());
            prepareStatement.setString(6, employee.getEmployeeAddress());
            prepareStatement.setString(7, String.valueOf(employee.getEmployeeSalary()));
            prepareStatement.setString(8, String.valueOf(employee.getStatus()));
            prepareStatement.setString(9, String.valueOf(employee.getCheckAdmin()));
            
            int resultSet = prepareStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //tim nhan vien theo id
    public ResultSet searchEmployeeById(Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select * from employee where idEmployee = ? and status = '1'";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getIdEmployee());
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    //tim nhan vien theo ten
    public ResultSet searchEmployeeByName (Employee employee) throws SQLException{
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select * from employee where employeeName = ? and status = '1'";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, employee.getEmployeeName());
            rs = prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    } 
    
    //dang nhap cho nhan vien
    public static Employee login(String username, String password) throws ClassNotFoundException, SQLException {
        //Them ket noi CSDL vao duoi
        MyConnect connect = MyConnect.getInstance();
        Connection connection = connect.getConnection();
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
                employee.setCheckAdmin(Integer.parseInt(resultSet.getString("checkAdmin")));
                employee.setBeginDate(resultSet.getString("beginDate"));
                employee.setEndDate(resultSet.getString("endDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (employee.getStatus() == 0) {
            employee = null;
        }
        
        return employee;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Employee emp = new Employee();
        
        Employee employ = new Employee();
        employ.setIdEmployee("EM001");
        employ.setEmployeeName("hieu");
        employ.setEmployeeEmail("hieu1");
        employ.setEmployeePhone("1234");
        employ.setEmployeePassword("1");
        employ.setEmployeeAddress("ha noi");
        employ.setEmployeeSalary(20145);
        employ.setStatus(1);
        employ.setCheckAdmin(1);
        employ.setBeginDate("2017-01-21");
        
        emp.deleteEmployee(employ);
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

    public int getCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(int checkAdmin) {
        this.checkAdmin = checkAdmin;
    }



}
