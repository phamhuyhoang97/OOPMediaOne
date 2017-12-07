/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import frame.Home;
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
    public void getNhanVien(Employee nv){
        Home home = new Home();
        nv.setIdEmployee(home.tf_idnhanvien.getText().trim());
        nv.setEmployeeName(home.tf_tennhanvien.getText().trim());
        nv.setEmployeePhone(home.tf_sdt.getText().trim());
        nv.setEmployeeEmail(home.tf_email.getText().trim());
        nv.setEmployeeAddress(home.tf_diachi.getText().trim());
        nv.setEmployeeSalary(Double.parseDouble(home.tf_luongnhanvien.getText())*1000);
        nv.setBeginDate(home.tf_ngaybatdau.getText().trim());
        nv.setEmployeePassword(home.tf_password.getText().trim());
        nv.setStatus(1);
        nv.setCheckAdmin(Employee.checkAdmin.employee);
    }
    
    //luu du lieu len  DefaultTableModel de jt_hienthinhanvien doc
    public void capNhatNhanVien(ResultSet rs){
            try {
                while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                    String rows[] = new String[8];
                    for(int i=0; i<8; i++){
                        rows[i] = rs.getString(i+1); // lấy dữ liệu tại cột số i (ứng với mã hàng)
                    }
                    tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
                    //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }    
    
    public void deleteEmp(){
        Home home = new Home();
        Employee nv = new Employee();
        
        nv.setIdEmployee(home.tf_idnhanvien.getText().trim());
        //xoa thong tin nhanvien
        nv.deleteEmployee(nv);
        JOptionPane.showMessageDialog(null, "Đã xoa' nhân viên xong");
    }
    
    public void changeEmp(){
        Employee nv = new Employee();
        //them dieu kien de xet xem da co Nhan Vien nay trong database chua
        
        //them thuoc tinh NhanVien
        getNhanVien(nv);
        
        //them vao database
        nv.changeEmployee(nv);
        
        JOptionPane.showMessageDialog(null, "Đã sửa nhân viên xong");
    }
    
    public void showEmp(){
        Home home = new Home();
        Employee nv = new Employee();
        //
        String []colsName = {"ID Nhân Viên", "Họ Tên Nhân Viên", "SDT", "Email", "Địa Chỉ",
            "Lương Cơ Bản", "Hệ Số Lương", "Lương Nhân Viên"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        tableModel.setRowCount(0);  //de refresh lai bang jtable
        home.jt_hienthinhanvien.setModel(tableModel);//ket noi jtalbe voi TableModel
        
//        capNhatNhanVien(nv.view());   //truy xuat du lieu len bang
        System.out.println("ok");
    }
           
    public void addEmp(){
        Employee nv = new Employee();
        //them dieu kien de xet xem da co Nhan Vien nay trong database chua
        
        //them thuoc tinh NhanVien
        getNhanVien(nv);
        
        //them vao database
//        nv.addEmployee(nv);
        
        JOptionPane.showMessageDialog(null, "Đã thêm nhân viên xong");
    }
    
    
    public void searchEmp(){
        Home home = new Home();
        ResultSet rs = null;
        Employee nv = new Employee();
        
        String itemText = (String)home.jcb_timkiemnhanvien.getSelectedItem( );
        if (itemText.equals(home.jcb_timkiemnhanvien.getItemAt(0))) {
            nv.setIdEmployee(home.tf_timkiemnhanvien.getText());
//            rs = nv.searchID(nv);
        } else {
            nv.setEmployeeName(home.tf_timkiemnhanvien.getText());
//            rs = nv.searchName(nv);
        }

        DefaultTableModel model = new DefaultTableModel();
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
            "Lương Cơ Bản", "Hệ Số Lương", "Lương Nhân Viên"};
        model.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        home.jt_hienthinhanvien.setModel(model);
    }
}
