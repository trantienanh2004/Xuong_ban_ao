/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author NGUYEN HUU LOC
 */
public class hoadon {
    private int maHD,maNV,maKH,km;
    private int thanhTien;
    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    private String trangThai, ngayTao;

    public hoadon() {
    }

    public hoadon(int maHD, int maNV, int maKH, String trangThai, String ngayTao) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }



    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
    
}
