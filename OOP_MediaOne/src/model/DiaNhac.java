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
public class DiaNhac {
    
    private String idDiaNhac;
    private String tenDiaNhac;
    private String tenCaSi;
    private String theLoai;
    private Integer soLuong;
    private Double giaMua;
    private Double giaBan;

    public String getIdDiaNhac() {
        return idDiaNhac;
    }

    public void setIdDiaNhac(String idDiaNhac) {
        this.idDiaNhac = idDiaNhac;
    }

    public String getTenDiaNhac() {
        return tenDiaNhac;
    }

    public void setTenDiaNhac(String tenDiaNhac) {
        this.tenDiaNhac = tenDiaNhac;
    }

    public String gettenCaSi() {
        return tenCaSi;
    }

    public void settenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
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

    public DiaNhac(String idDiaNhac, String tenDiaNhac, String tenCaSi, String theLoai, Integer soLuong, Double giaMua, Double giaBan) {
        this.idDiaNhac = idDiaNhac;
        this.tenDiaNhac = tenDiaNhac;
        this.tenCaSi = tenCaSi;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    } 

    public DiaNhac() {
    }
    
}
