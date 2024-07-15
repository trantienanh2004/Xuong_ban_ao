/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author NGUYEN HUU LOC
 */
public class hoadonchitiet {
    private int maHDCT,maCTSP,maHD,soLuong,gia;
    private int tongTien;
    private String trangThai,maSP,tenSP;
    private String mau,cl,size;

    public hoadonchitiet() {
    }

    public hoadonchitiet(int maHDCT, int maCTSP, int maHD, int soLuong, int tongTien, int gia, String trangThai, String maSP, String tenSP, String mau, String cl, String size) {
        this.maHDCT = maHDCT;
        this.maCTSP = maCTSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.gia = gia;
        this.trangThai = trangThai;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mau = mau;
        this.cl = cl;
        this.size = size;
    }

    

    public int getMaHDCT() {
        return maHDCT;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(int maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public int getThanhTien(int gia,int sl){
        return gia*sl;
    }
    
    
}
