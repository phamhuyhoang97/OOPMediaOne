/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Khoa Nguyen
 */
public class HoaDon {
    
    private String idHoaDon;
    private Date ngayXuat;
    private Double tongTien;

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    } 

    public HoaDon(String idHoaDon, Date ngayXuat, Double tongTien) {
        this.idHoaDon = idHoaDon;
        this.ngayXuat = ngayXuat;
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }
    
}
