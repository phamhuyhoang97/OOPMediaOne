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
public class ChiPhiDinhKi {
    
    private Date ngayChi;
    private String tenChiPhi;
    private Double tienChi;

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getTenChiPhi() {
        return tenChiPhi;
    }

    public void setTenChiPhi(String tenChiPhi) {
        this.tenChiPhi = tenChiPhi;
    }

    public Double getTienChi() {
        return tienChi;
    }

    public void setTienChi(Double tienChi) {
        this.tienChi = tienChi;
    }

    public ChiPhiDinhKi(Date ngayChi, String tenChiPhi, Double tienChi) {
        this.ngayChi = ngayChi;
        this.tenChiPhi = tenChiPhi;
        this.tienChi = tienChi;
    }

    public ChiPhiDinhKi() {
    }
    
}
