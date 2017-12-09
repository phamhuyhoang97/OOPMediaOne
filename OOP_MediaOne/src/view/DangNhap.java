/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Employee;
import oop_mediaone.OOP_MediaOne;

/**
 *
 * @author hoang
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    
    public DangNhap() {
        initComponents();
    }
    
    public void dangnhap() {
            try {
            // TODO add your handling code here:
            
            OOP_MediaOne.currentEmployee =  Employee.login(taikhoan.getText(), new String(password.getText()));
            if (OOP_MediaOne.currentEmployee != null) {
                this.dispose();
                Home home = new Home();
                home.setVisible(true);
                home.setLocation(50,0);

                // Đóng hết các panel phần hiển thị:
                home.panel_sach.setVisible(false);
                home.panel_diaphim.setVisible(false);
                home.panel_dianhac.setVisible(false);

                // Đóng hết các panel chức năng con:
                home.panel_chucnangcon_khohang.setVisible(false);
                home.panel_chucnangcon_nhanvien.setVisible(false);
                home.panel_chucnangcon_thongke.setVisible(false);
                home.panel_chucnangcon_banhang.setVisible(false);

                // Hiển thị cái panel rỗng
                home.panel_sach.setVisible(false);
                home.panel_diaphim.setVisible(false);
                home.panel_dianhac.setVisible(false);
                home.panel_thongtinnhanvien.setVisible(false);
                home.panel_chiphiphatsinh.setVisible(false);
                home.panel_chiphidinhki.setVisible(false);
                home.panel_thongketien.setVisible(false);
                home.panel_banhang.setVisible(false);
                home.panel_hoadon.setVisible(false);
                
                if ((OOP_MediaOne.currentEmployee.getCheckAdmin()).equals("employee")) {
                    home.button_quanlinhanvien.setVisible(false);
                    home.button_chiphi.setVisible(false);
                    home.button_thongke.setVisible(false);
        }
            }
            else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        taikhoan = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        button_dangnhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng Nhập");

        jLabel2.setText("Tài Khoản");

        jLabel3.setText("Mật Khẩu");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        button_dangnhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_dangnhap.setText("Đăng Nhập");
        button_dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dangnhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_dangnhap)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(password))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(button_dangnhap)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_dangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dangnhapActionPerformed
        dangnhap();
    }//GEN-LAST:event_button_dangnhapActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dangnhap();
        }
    }//GEN-LAST:event_passwordKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_dangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField taikhoan;
    // End of variables declaration//GEN-END:variables
}
