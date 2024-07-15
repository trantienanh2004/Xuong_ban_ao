/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

/**
 *
 * @author NGUYEN HUU LOC
 */
import banaonam.model.ThongKe;
import banaonam.untility.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeService {

    public String DoanhThuNgay() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DECLARE @ngay varchar(5)\n"
                + "set @ngay = DAY(getdate())\n"
                + "select FORMAT( SUM(HOADONCHITIET.tongtien), 'N','vi-VN') from HOADONCHITIET join HOADON \n"
                + "on HOADON.MAHD = HOADONCHITIET.MAHD\n"
                + "where HOADON.TRANGTHAI like N'%Đã thanh toán' and DAY(NGAYTAO) = @ngay";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {

        }
        return "0";
    }

    public String DoanhThuThang() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DECLARE @ngay varchar(5)\n"
                + "set @ngay = MONTH(getdate())\n"
                + "select FORMAT( SUM(HOADONCHITIET.tongtien), 'N','vi-VN') from HOADONCHITIET join HOADON \n"
                + "on HOADON.MAHD = HOADONCHITIET.MAHD\n"
                + "where HOADON.TRANGTHAI like N'%Đã thanh toán' and MONTH(NGAYTAO) = @ngay";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {

        }
        return "0";
    }

    public String DoanhThuNam() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DECLARE @ngay varchar(5)\n"
                + "set @ngay = YEAR(getdate())\n"
                + "select FORMAT( SUM(HOADONCHITIET.tongtien), 'N','vi-VN') from HOADONCHITIET join HOADON \n"
                + "on HOADON.MAHD = HOADONCHITIET.MAHD\n"
                + "where HOADON.TRANGTHAI like N'%Đã thanh toán' and YEAR(NGAYTAO) = @ngay";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {

        }
        return "0";
    }

    public String TongDonHang() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DECLARE @ngay varchar(5)\n"
                + "set @ngay = MONTH(getdate())\n"
                + "select COUNT(*) from HOADON where TRANGTHAI like N'%Đã thanh toán%' and MONTH(NGAYTAO) = @ngay";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {

        }
        return " 0";
    }

    public List<ThongKe> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ThongKe> list = new ArrayList<>();
        String sql = "select MONTH(NGAYTAO),SUM(SOLUONG),SUM(HOADONCHITIET.TONGTIEN),SUM(HOADONCHITIET.TONGTIEN) from HOADON\n"
                + "               join HOADONCHITIET on HOADON.MAHD = HOADONCHITIET.MAHD\n"
                + "                where HOADON.TRANGTHAI like N'%Đã thanh toán%'\n"
                + "                group by MONTH(NGAYTAO)";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));

                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            return null;
        }

    }

    public List<ThongKe> getFind(String ngayBD, String ngayKT) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ThongKe> list = new ArrayList<>();
        String sql = "select concat(DAY(NGAYTAO),'/',MONTH(NGAYTAO)),SUM(SOLUONG),SUM(HOADONCHITIET.TONGTIEN),SUM(HOADONCHITIET.TONGTIEN) from HOADON\n"
                + "join HOADONCHITIET on HOADON.MAHD = HOADONCHITIET.MAHD\n"
                + "where HOADON.TRANGTHAI like N'%Đã thanh toán%' and NGAYTAO between '" + ngayBD + "' and '" + ngayKT + "'\n"
                + "group by MONTH(NGAYTAO),DAY(NGAYTAO)";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setNgayThang(rs.getString(1));
                tk.setSoSPDaBan(rs.getInt(2));
                tk.setTongGiaBan(rs.getInt(3));
                tk.setDoanhThu(rs.getInt(4));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            return null;
        }

    }

}
