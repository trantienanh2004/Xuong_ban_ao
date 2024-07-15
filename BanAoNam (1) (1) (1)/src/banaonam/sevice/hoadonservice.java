/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.hoadon;
import banaonam.untility.DB;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN HUU LOC
 */

public class hoadonservice {


    
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public List<hoadon> getAllHD() {
        sql = "select MAHD, MANV, TRANGTHAI,NGAYTAO from HOADON where TRANGTHAI = N'Chờ thanh toán' order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt("MAHD"));
                hd.setMaNV(rs.getInt("MANV"));
                hd.setTrangThai(rs.getString("TRANGTHAI"));
                hd.setNgayTao(rs.getString("NGAYTAO"));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<hoadon> getAllHDByQLHD() {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByTenNV(int maNV) {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where MANV = ? order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByNhanVien(int maNV) {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where MANV = ? order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByMaHD(int maHD) {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where MAHD = ? order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByHDVaNV(int maHD,int maNV) {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where MAHD = ? and MANV = ? order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            ps.setObject(2, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByQLHDByDaThanhToan() {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where TRANGTHAI like N'%Đã thanh toán%' order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public List<hoadon> getAllHDByQLHDByChoThanhToan() {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where TRANGTHAI like N'%Chờ thanh toán%' order by MAHD desc";
        List<hoadon> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                list.add(hd);

            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public hoadon getTrangThai(int maHD) {
        sql = "select MAHD, MANV,MAKH, TRANGTHAI,NGAYTAO,TONGTIEN  from HOADON where where TRANGTHAI like N'%Đã thanh toán%' and where MAHD = ? ";
        hoadon hd = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                 hd = new hoadon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getInt(2));
                hd.setMaKH(rs.getInt(3));
                hd.setTrangThai(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setThanhTien(rs.getInt(6));

                

            }
            return hd;
        } catch (Exception e) {
            return null;
        }
    }

    public int getMaKM(int maHD) {
        sql = "select idkm from hoadon where MAHD = ?";
        hoadon hd = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                 hd = new hoadon();
                hd.setKm(rs.getInt(1));
            }

            return hd.getKm();
        } catch (Exception e) {
            return 0;
        }
    }
    public int addHD(hoadon hd) {
        sql = "insert into HOADON values (?,?,?,?,null,null)";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getMaNV());
            ps.setObject(2, hd.getMaKH());
            ps.setObject(3, hd.getTrangThai());
            ps.setObject(4, hd.getNgayTao());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateHD(int maKH, int maHD,double tt) {
        sql = "update HOADON set TRANGTHAI = N' Đã thanh toán',MAKH = ?,tongtien = ? where MAHD=?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, maKH);           
            ps.setObject(2, tt);
            ps.setObject(3, maHD);

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
    public int updateHDKM(int idKM, int maHD) {
        sql = "update HOADON set idkm=? where MAHD=?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, idKM);
            ps.setObject(2, maHD);
         

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
