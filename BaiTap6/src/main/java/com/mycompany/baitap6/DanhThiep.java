/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap6;

import java.io.Serializable;

/**
 *
 * @author Desktop
 */
public class DanhThiep implements Serializable{
    private String hoVaTen;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String hinhAnh;

    public DanhThiep() {
    }
    
    public DanhThiep(String hoVaTen, String diaChi, String soDienThoai, String email, String hinhAnh) {
        this.hoVaTen = hoVaTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.hinhAnh = hinhAnh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "DanhThiep{" + "hoVaTen=" + hoVaTen + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email=" + email + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
}
