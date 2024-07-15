/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author HP
 */
public class sanphamchitiet {
    private int SOLUONG,maspct,GIA;
    private  String MASP,SIZE,thanhtoan,tensp,mau,chatlieu,LinkAnh;
   

    public sanphamchitiet() {
    }

    public sanphamchitiet(int SOLUONG, int maspct, String MASP, String SIZE, String thanhtoan, String tensp, String mau, String chatlieu, String LinkAnh, int GIA) {
        this.SOLUONG = SOLUONG;
        this.maspct = maspct;
        this.MASP = MASP;
        this.SIZE = SIZE;
        this.thanhtoan = thanhtoan;
        this.tensp = tensp;
        this.mau = mau;
        this.chatlieu = chatlieu;
        this.LinkAnh = LinkAnh;
        this.GIA = GIA;
    }

    

    public int getMaspct() {
        return maspct;
    }

    public void setMaspct(int maspct) {
        this.maspct = maspct;
    }

    

    
    
    
    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }

  

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public int getGIA() {
        return GIA;
    }

    public void setGIA(int GIA) {
        this.GIA = GIA;
    }



    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String LinkAnh) {
        this.LinkAnh = LinkAnh;
    }

    public String getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(String thanhtoan) {
        this.thanhtoan = thanhtoan;
    }
    public int getThanhTien(int Gia,int sl){
        return Gia*sl;
    }


   

    
    
}
