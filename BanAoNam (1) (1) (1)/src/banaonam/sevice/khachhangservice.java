/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.khachhang;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN HUU LOC
 */
public class khachhangservice {

    public int getMaKH;

    public String getTenKH(String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select TENKH from KHACHHANG where SDT = ?";
        khachhang kh = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sdt);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new khachhang();
                kh.setTenKH(rs.getString("TENKH"));
            }
            return kh.getTenKH();
        } catch (Exception e) {
            return "Khách hàng chưa tồn tại";
        }
    }
    public String getTenKHByMA(int ma) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select TENKH from KHACHHANG where MAKH = ?";
        khachhang kh = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new khachhang();
                kh.setTenKH(rs.getString("TENKH"));
            }
            return kh.getTenKH();
        } catch (Exception e) {
            return null;
        }
    }

    public int getMaKH(String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select MAKH from KHACHHANG where SDT = ?";
        khachhang kh = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sdt);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new khachhang();
                kh.setMaKH(rs.getInt("MAKH"));
            }
            return kh.getMaKH();
        } catch (Exception e) {
            return 0;
        }
    }

    public khachhang getBySDT(String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from KHACHHANG where SDT = ?";
        khachhang kh = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sdt);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new khachhang();
                kh.setMaKH(rs.getInt("MAKH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setSdt(rs.getString("SDT"));
                
                
            }
            return kh;
        } catch (Exception e) {
            return null;
        }
    }

    public List<khachhang> getALLKH() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<khachhang> list = new ArrayList<>();
        String sql = "select MAKH,TENKH,SDT from KHACHHANG where MAKH!=(select min(MAKH) from KHACHHANG)";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                khachhang kh = new khachhang();
                kh.setMaKH(rs.getInt("MAKH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setSdt(rs.getString("SDT"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public int addKH(khachhang kh) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into KHACHHANG values (?,?,null,null)";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getSdt());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
