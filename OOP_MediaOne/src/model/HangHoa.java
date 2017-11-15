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
public class HangHoa {
    
    private String idhangHoa;
    private String theLoai;
    private Integer soLuong;
    private Double giaMua;
    private Double giaBan;

    public String getIdhangHoa() {
        return idhangHoa;
    }

    public void setIdhangHoa(String idhangHoa) {
        this.idhangHoa = idhangHoa;
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

    public HangHoa(String idhangHoa, String theLoai, Integer soLuong, Double giaMua, Double giaBan) {
        this.idhangHoa = idhangHoa;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public HangHoa() {
    }
    
}
