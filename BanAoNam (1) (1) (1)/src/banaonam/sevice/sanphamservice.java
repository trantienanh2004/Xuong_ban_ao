/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.dangnhap;
import banaonam.model.sanpham;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class sanphamservice {

    public String getTenSP(String maSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select TENSP from SANPHAM where MASP = ?";
        sanpham sp = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp = new sanpham();
                sp.setTensp(rs.getString("TENSP"));
            }
            return sp.getTensp();
        } catch (Exception e) {
            return null;
        }
    }

    public List<sanpham> getallsanpham() {
        ArrayList<sanpham> dssp = new ArrayList<>();

        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM SANPHAM";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                sanpham sp = new sanpham();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setNgaytao(rs.getString(3));
                sp.setTrangthai(rs.getString(4));
                dssp.add(sp);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return dssp;
    }

    public List<sanpham> getallsanpham(int page) {
        ArrayList<sanpham> dssp = new ArrayList<>();

        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM SANPHAM\n"
                + "order by MASP\n"
                + "offset "+(page*3-3)+"   rows\n"
                + "fetch next 3 rows only";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                sanpham sp = new sanpham();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setNgaytao(rs.getString(3));
                sp.setTrangthai(rs.getString(4));
                dssp.add(sp);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return dssp;
    }

    public int getCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select count (*) from sanpham";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public Integer addSanPham(sanpham sp) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "INSERT INTO SANPHAM (MASP,TENSP,ngaytao,trangthai) VALUES(?,?,?,?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, sp.getMasp());
            pd.setString(2, sp.getTensp());
            pd.setString(3, sp.getNgaytao());
            pd.setString(4, sp.getTrangthai());

            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return row;
    }

    public Integer UpdateSanPham(sanpham sp) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "update sanpham\n"
                + "set TENSP = ?,ngaytao = ?\n"
                + "where Masp = ?";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, sp.getTensp());
            pd.setString(2, sp.getNgaytao());
            pd.setString(3, sp.getMasp());

            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return row;
    }
}
