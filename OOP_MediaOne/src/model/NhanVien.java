/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hoang
 */
public class NhanVien {
    private String id;
    private String tenNhanVien;
    private String sDT;
    private String email;
    private String diaChi;
    private double luongCoBan;
    private double heSoLuong;
    private double luongNhanVien;

//    public NhanVien(String id, String tenNhanVien, String sDT, String email, 
//            String CMND, String diaChi, double luong){
//        super();
//        this.id = id;
//        this.tenNhanVien = tenNhanVien;
//        this.sDT = sDT;
//        this.email = email;
//        this.CMND = CMND;
//        this.diaChi = diaChi;
//        this.luong = luong;
//    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getLuongNhanVien() {
        return luongNhanVien;
    }

    public void setLuongNhanVien(double luongNhanVien) {
        this.luongNhanVien = luongNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return sDT;
    }

    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    
}
