/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class khuyenmai {

    private int id ;
    private Date ngayketthuc, ngaybatdau;
    private String makhuyenmai, trangthai, noidungkhuyenmai,giamgia;

    public khuyenmai() {
    }

    public khuyenmai(int id, Date ngayketthuc, Date ngaybatdau, String makhuyenmai, String trangthai, String noidungkhuyenmai, String giamgia) {
        this.id = id;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.makhuyenmai = makhuyenmai;
        this.trangthai = trangthai;
        this.noidungkhuyenmai = noidungkhuyenmai;
        this.giamgia = giamgia;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(String giamgia) {
        this.giamgia = giamgia;
    }

    

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(String makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getNoidungkhuyenmai() {
        return noidungkhuyenmai;
    }

    public void setNoidungkhuyenmai(String noidungkhuyenmai) {
        this.noidungkhuyenmai = noidungkhuyenmai;
    }

}
