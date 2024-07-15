/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import banaonam.model.khuyenmai;
import banaonam.untility.DB;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class khuyenmaiService {

    public ArrayList<khuyenmai> getallkhuyenmai() {
        ArrayList<khuyenmai> dskm = new ArrayList<>();
        Connection cn = DB.getConnection();
        try {
            String sql = "select * from khuyenmai";
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                khuyenmai km = new khuyenmai();
                km.setId(rs.getInt(1));
                km.setNoidungkhuyenmai(rs.getString(2));
                km.setMakhuyenmai(rs.getString(3));                
                km.setNgaybatdau(rs.getDate(4));
                km.setNgayketthuc(rs.getDate(5));
                km.setTrangthai(rs.getString(6));
                km.setGiamgia(rs.getString(7));
               
                dskm.add(km);
            }
            return dskm;
        } catch (Exception e) {
            return null;
        }

    }

    public Integer them(khuyenmai km) {
        Integer row = null;
        Connection cn = DB.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateMO = sdf.format(km.getNgaybatdau());
        String datedong = sdf.format(km.getNgayketthuc());
        String sql = "INSERT INTO khuyenmai(noidungkhuyenmai,makhuyenmai,ngaybatdau,ngayketthuc,trangthai,giam)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, km.getNoidungkhuyenmai());
            pd.setString(2, km.getMakhuyenmai());           
            pd.setString(3, dateMO);
            pd.setString(4, datedong);
            pd.setString(5, km.getTrangthai());
            pd.setString(6, km.getGiamgia());
            row = pd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("lỗi ở khuyến mãi ser");
        }

        return row;
    }

    public Integer sua(khuyenmai km) {
        Integer row = null;
        Connection cn = DB.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateMO = sdf.format(km.getNgaybatdau());
        String datedong = sdf.format(km.getNgayketthuc());
        String sql = "update khuyenmai "
                + "set noidungkhuyenmai = ?, makhuyenmai = ?, giam= ?, ngaybatdau = ?,ngayketthuc = ?\n"
                + "			   where idKM = ?";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setNString(1, km.getNoidungkhuyenmai());
            pd.setString(2, km.getMakhuyenmai());
            pd.setString(3, km.getGiamgia());
            pd.setString(4, dateMO);
            pd.setString(5, datedong);
            pd.setInt(6, km.getId());
            row = pd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("lỗi ở khuyến mãi ser");
        }

        return row;
    }
    public Integer voHieuHoa(int idkm) {
        Integer row = null;
        Connection cn = DB.getConnection();

        String sql = "update khuyenmai set trangthai = N'Vô hiệu hóa' where idKM = ?";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
           pd.setObject(1, idkm);
            row = pd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("lỗi ở khuyến mãi ser");
        }

        return row;
    }

    public Integer xoa(int id) {
        Integer row = null;
        Connection cn = DB.getConnection();

        String sql = "delete from khuyenmai\n"
                + "				where idKM = ?";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setInt(1, id);

            row = pd.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("lỗi ở khuyến mãi ser");
        }

        return row;
    }

    // Mã giảm theo %
    public String FindMaTheoPhanTram(String maKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        khuyenmai km = null;
        sql = "select giam from khuyenmai where RIGHT(giam,1) = '%' and makhuyenmai = ? ";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new khuyenmai();
                km.setGiamgia(rs.getString(1));
            }
            return km.getGiamgia();
        } catch (Exception e) {
            return null;
        }
    }

    // Phần trăm giảm
    public String FindPhanTram(String maKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        khuyenmai km = null;
        sql = "select SUBSTRING(giam,1,2) from khuyenmai where giam like '%' and makhuyenmai = ?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {

        }
        return null;
    }

    // Tìm xem có mã giảm k
    public String FindGiam(String maKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        khuyenmai km = null;
        sql = "select giam from khuyenmai where makhuyenmai = ? and trangthai = N'vẫn hoạt động'";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new khuyenmai();
                km.setGiamgia(rs.getString(1));
            }
            return km.getGiamgia();
        } catch (Exception e) {
            return null;
        }
    }
    public int getByID(String maKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        khuyenmai km = null;
        sql = "select idkm from khuyenmai where makhuyenmai = ? and trangthai = N'vẫn hoạt động'";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new khuyenmai();
                km.setId(rs.getInt(1));
            }
            return km.getId();
        } catch (Exception e) {
            return 0;
        }
    }
    public String getMaKM(int idKM) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        khuyenmai km = null;
        sql = "select makhuyenmai from khuyenmai where idkm = ? and trangthai = N'vẫn hoạt động'";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new khuyenmai();
                km.setMakhuyenmai(rs.getString(1));
            }
            return km.getMakhuyenmai();
        } catch (Exception e) {
            return null;
        }
    }
}
