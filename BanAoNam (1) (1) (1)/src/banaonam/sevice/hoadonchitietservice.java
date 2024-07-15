/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.hoadonchitiet;
import banaonam.untility.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN HUU LOC
 */
public class hoadonchitietservice {

    sanphamchitietService serviceSPCT = new sanphamchitietService();
    sanphamservice serviceSP = new sanphamservice();

    public List<hoadonchitiet> getHDByMAHD(int maHD) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select MAHDCT,SANPHAM.MASP,TENSP,TENMAU,TENCHATLIEU,TENSIZE,HOADONCHITIET.SOLUONG,CHITIETSANPHAM.GIA,HOADONCHITIET.TONGTIEN from HOADONCHITIET \n"
                + "join CHITIETSANPHAM on CHITIETSANPHAM.MACTSP = HOADONCHITIET.MACTSP \n"
                + "join SANPHAM on SANPHAM.MASP = CHITIETSANPHAM.MASP "
                + "				join MAUSAC on MAUSAC.MAMS = CHITIETSANPHAM.MAMS\n"
                + "				join CHATLIEU on CHATLIEU.MACL = CHITIETSANPHAM.MACL\n"
                + "				join SIZE on SIZE.MASIZE = CHITIETSANPHAM.MASIZE\n"
                + "where MAHD = ?";
        List<hoadonchitiet> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadonchitiet hdct = new hoadonchitiet();
                hdct.setMaHDCT(rs.getInt("MAHDCT"));
                hdct.setMaSP(rs.getString("MASP"));
                hdct.setTenSP(rs.getString("TENSP"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setGia(rs.getInt("GIA"));
                hdct.setTongTien(rs.getInt("TONGTIEN"));
                hdct.setMau(rs.getString("TENMAU"));
                hdct.setCl(rs.getString("TENCHATLIEU"));
                hdct.setSize(rs.getString("TENSIZE"));

                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<hoadonchitiet> getHDByMAHDByQLHD(int maHD) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select SANPHAM.MASP,TENSP,TENMAU,TENCHATLIEU,TENSIZE,HOADONCHITIET.SOLUONG,CHITIETSANPHAM.GIA,HOADONCHITIET.TONGTIEN from HOADONCHITIET \n"
                + "                join CHITIETSANPHAM on CHITIETSANPHAM.MACTSP = HOADONCHITIET.MACTSP \n"
                + "                join SANPHAM on SANPHAM.MASP = CHITIETSANPHAM.MASP\n"
                + "				join MAUSAC on MAUSAC.MAMS = CHITIETSANPHAM.MAMS\n"
                + "				join CHATLIEU on CHATLIEU.MACL = CHITIETSANPHAM.MACL\n"
                + "				join SIZE on SIZE.MASIZE = CHITIETSANPHAM.MASIZE\n"
                + "				where MAHD = ? ";
        List<hoadonchitiet> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadonchitiet hdct = new hoadonchitiet();
                hdct.setMau(rs.getString("TENMAU"));
                hdct.setCl(rs.getString("TENCHATLIEU"));
                hdct.setSize(rs.getString("TENSIZE"));
                hdct.setMaSP(rs.getString("MASP"));
                hdct.setTenSP(rs.getString("TENSP"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));
                hdct.setGia(rs.getInt("GIA"));
                hdct.setTongTien(rs.getInt("TONGTIEN"));

                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public int getMaCTSP(int maHDCT) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select MACTSP from HOADONCHITIET where MAHDCT = ?";
        hoadonchitiet hdct = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHDCT);
            rs = ps.executeQuery();
            while (rs.next()) {
                hdct = new hoadonchitiet();
                hdct.setMaCTSP(rs.getInt("MACTSP"));
            }

            return hdct.getMaCTSP();
        } catch (Exception e) {
            return 0;
        }
    }

    public hoadonchitiet checkTrungCTSP(int maHD, int maCTSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select MAHDCT,SOLUONG,TONGTIEN from HOADONCHITIET where MAHD = ? and MACTSP = ?";
        hoadonchitiet hdct = null;

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            ps.setObject(2, maCTSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                hdct = new hoadonchitiet();
                hdct.setMaHDCT(rs.getInt("MAHDCT"));
                hdct.setSoLuong(rs.getInt("SOLUONG"));

                hdct.setTongTien(rs.getInt("TONGTIEN"));
            }
            return hdct;
        } catch (Exception e) {
            return null;
        }
    }

    public int addHDCT(hoadonchitiet hdct) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "insert into HOADONCHITIET values (?,?,?,?,?)";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getMaCTSP());
            ps.setObject(2, hdct.getMaHD());
            ps.setObject(3, hdct.getTongTien());
            ps.setObject(4, hdct.getSoLuong());
            ps.setObject(5, hdct.getTrangThai());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int upfateSL(hoadonchitiet hdct, int sl) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "update HOADONCHITIET set SOLUONG = ? where MAHDCT = ? ";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);

            ps.setObject(2, hdct.getMaHDCT());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int upfateSL(hoadonchitiet hdct, int sl, int gia) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "update HOADONCHITIET set SOLUONG = ?,TONGTIEN=? where MAHDCT = ? ";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);
            ps.setObject(2, gia);
            ps.setObject(3, hdct.getMaHDCT());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThai(hoadonchitiet hdct, String tt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "update HOADONCHITIET set TRANGTHAI = ? where MAHDCT = ? ";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tt);
            ps.setObject(2, hdct.getMaHDCT());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThaiTT(hoadonchitiet hdct, String tt, int idKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "update HOADONCHITIET set TRANGTHAI = ?, idkm = ? where MAHDCT = ? ";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tt);
            ps.setObject(2, hdct.getMaHDCT());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteHDCT(int maHDCT) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "delete HOADONCHITIET where MAHDCT = ?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHDCT);

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
    public int getTT(int maHD){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select SUM(TONGTIEN) from HOADONCHITIET where MAHD = ?";
         try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }

           
        } catch (Exception e) {
            
        }
         return 0;
    }
}
