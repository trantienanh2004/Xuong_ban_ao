/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author NGUYEN HUU LOC
 */
public class ThongKe {
    
    private int thang,soSPDaBan,tongGiaBan,doanhThu;
    private String ngayThang;

    public ThongKe() {
    }

    public ThongKe(int thang, int soSPDaBan, int tongGiaBan, int doanhThu) {
        this.thang = thang;
        this.soSPDaBan = soSPDaBan;
        this.tongGiaBan = tongGiaBan;
        this.doanhThu = doanhThu;
    }

    public int getThang() {
        return thang;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSoSPDaBan() {
        return soSPDaBan;
    }

    public void setSoSPDaBan(int soSPDaBan) {
        this.soSPDaBan = soSPDaBan;
    }

    public int getTongGiaBan() {
        return tongGiaBan;
    }

    public void setTongGiaBan(int tongGiaBan) {
        this.tongGiaBan = tongGiaBan;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    
    
    
    
}
