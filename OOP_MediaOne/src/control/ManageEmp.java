/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import frame.Home;
import javax.swing.JOptionPane;
import model.NhanVien;


/**
 *
 * @author hoang
 */
public class ManageEmp {
    Home home = new Home();
    
    
    public void deleteEmp(){
        Employee nv = new Employee();
        nv.connect();
        
        nv.setId(home.getTf_idnhanvien().getText().trim());
        //xoa thong tin nhanvien
        nv.deleteEmployee(nv);
        JOptionPane.showMessageDialog(null, "Đã xoa' nhân viên xong");
    }
}
