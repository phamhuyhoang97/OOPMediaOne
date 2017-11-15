/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Khoa Nguyen
 */
public class DiaPhim {
    
    private String idDiaPhim;
    private String tenDiaPhim;
    private String dienVien;
    private String daoDien;
    private Integer soLuong;
    private Double giaMua;
    private Double giaBan;

    public String getIdDiaPhim() {
        return idDiaPhim;
    }

    public void setIdDiaPhim(String idDiaPhim) {
        this.idDiaPhim = idDiaPhim;
    }

    public String getTenDiaPhim() {
        return tenDiaPhim;
    }

    public void setTenDiaPhim(String tenDiaPhim) {
        this.tenDiaPhim = tenDiaPhim;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(Double giaMua) {
        this.giaMua = giaMua;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public DiaPhim(String idDiaPhim, String tenDiaPhim, String dienVien, String daoDien, Integer soLuong, Double giaMua, Double giaBan) {
        this.idDiaPhim = idDiaPhim;
        this.tenDiaPhim = tenDiaPhim;
        this.dienVien = dienVien;
        this.daoDien = daoDien;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public DiaPhim() {
    }
    
}
