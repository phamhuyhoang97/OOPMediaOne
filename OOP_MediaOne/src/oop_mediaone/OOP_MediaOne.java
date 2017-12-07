/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_mediaone;

import frame.DangNhap;
import java.awt.HeadlessException;
import java.sql.SQLException;
import model.Employee;


public class OOP_MediaOne {

    /**
     * @param args the command line arguments
     */
    
    public static Employee currentEmployee;
    public static void main(String[] args) throws HeadlessException, ClassNotFoundException, SQLException {
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        dn.setLocation(500, 150);
        
    }
    
}
