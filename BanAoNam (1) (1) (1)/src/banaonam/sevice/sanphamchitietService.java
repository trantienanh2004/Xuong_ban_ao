/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.sanpham;
import banaonam.model.sanphamchitiet;
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
public class sanphamchitietService {

    mauService mauservice = new mauService();
    ChatLieuService clservice = new ChatLieuService();
    sizeService sizeservice = new sizeService();

    public ArrayList<sanphamchitiet> getallsanphamchitiet() {
        ArrayList<sanphamchitiet> dsspct = new ArrayList<>();

        Connection cn = DB.getConnection();
        String sql = "SELECT sanpham.masp,TENSP,TENSIZE,TENMAU,TENCHATLIEU,gia,chitietsanpham.SOLUONG,MACTSP,CHITIETSANPHAM.HINHANH,trangthai FROM SANPHAM \n"
                + "join CHITIETSANPHAM on sanpham.MASP = CHITIETSANPHAM.masp \n"
                + "join MAUSAC on MAUSAC.MAMS = CHITIETSANPHAM.MAMS \n"
                + "join CHATLIEU on CHATLIEU.MACL = CHITIETSANPHAM.MACL \n"
                + "join SIZE on SIZE.MASIZE = CHITIETSANPHAM.MASIZE order by MACTSP";

        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                sanphamchitiet spct = new sanphamchitiet();
                spct.setMASP(rs.getString(1));
                spct.setTensp(rs.getString(2));
                spct.setSIZE(rs.getString(3));
                spct.setMau(rs.getString(4));
                spct.setChatlieu(rs.getString(5));
                spct.setGIA(rs.getInt(6));
                spct.setSOLUONG(rs.getInt(7));
                spct.setMaspct(rs.getInt(8));
                spct.setLinkAnh(rs.getString(9));
                spct.setThanhtoan(rs.getString(10));
                dsspct.add(spct);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return dsspct;
    }

    public List<sanphamchitiet> getallsanphamchitiet(int page) {
        List<sanphamchitiet> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT sanpham.masp,TENSP,TENSIZE,TENMAU,TENCHATLIEU,gia,chitietsanpham.SOLUONG,MACTSP,CHITIETSANPHAM.HINHANH,trangthai FROM SANPHAM \n"
                + "                 join CHITIETSANPHAM on sanpham.MASP = CHITIETSANPHAM.masp \n"
                + "               join MAUSAC on MAUSAC.MAMS = CHITIETSANPHAM.MAMS \n"
                + "                join CHATLIEU on CHATLIEU.MACL = CHITIETSANPHAM.MACL \n"
                + "              join SIZE on SIZE.MASIZE = CHITIETSANPHAM.MASIZE \n"
                + "			  order by MACTSP\n"
                + "offset " + (page * 3 - 3) + "  rows "
                + "fetch next 3 rows only";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                sanphamchitiet spct = new sanphamchitiet();

                spct.setMASP(rs.getString(1));
                spct.setTensp(rs.getString(2));
                spct.setSIZE(rs.getString(3));
                spct.setMau(rs.getString(4));
                spct.setChatlieu(rs.getString(5));
                spct.setGIA(rs.getInt(6));
                spct.setSOLUONG(rs.getInt(7));
                spct.setMaspct(rs.getInt(8));
                spct.setLinkAnh(rs.getString(9));
                spct.setThanhtoan(rs.getString(10));
                list.add(spct);
            }
            return list;
        } catch (Exception e) {
            return null;
        }

    }
    public List<sanphamchitiet> getallsanphamchitiet(int page,String maSP) {
        List<sanphamchitiet> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT sanpham.masp,TENSP,TENSIZE,TENMAU,TENCHATLIEU,gia,chitietsanpham.SOLUONG,MACTSP,CHITIETSANPHAM.HINHANH,trangthai FROM SANPHAM \n"
                + "                 join CHITIETSANPHAM on sanpham.MASP = CHITIETSANPHAM.masp \n"
                + "               join MAUSAC on MAUSAC.MAMS = CHITIETSANPHAM.MAMS \n"
                + "                join CHATLIEU on CHATLIEU.MACL = CHITIETSANPHAM.MACL \n"
                + "              join SIZE on SIZE.MASIZE = CHITIETSANPHAM.MASIZE \n"
                + " where SANPHAM.MASP = ?"
                + "			  order by MACTSP\n"
                + "offset " + (page * 3 - 3) + "  rows "
                + "fetch next 3 rows only";

        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                sanphamchitiet spct = new sanphamchitiet();

                spct.setMASP(rs.getString(1));
                spct.setTensp(rs.getString(2));
                spct.setSIZE(rs.getString(3));
                spct.setMau(rs.getString(4));
                spct.setChatlieu(rs.getString(5));
                spct.setGIA(rs.getInt(6));
                spct.setSOLUONG(rs.getInt(7));
                spct.setMaspct(rs.getInt(8));
                spct.setLinkAnh(rs.getString(9));
                spct.setThanhtoan(rs.getString(10));
                list.add(spct);
            }
            return list;
        } catch (Exception e) {
            return null;
        }

    }

    public int getCount(String maSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select count (*) from chitietsanpham where MASP = ?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }
    
    public int getCount() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select count (*) from chitietsanpham";
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

    public sanphamchitiet getMaSPCT(int maSPCT) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from CHITIETSANPHAM where MACTSP =?";
        sanphamchitiet spct = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSPCT);
            rs = ps.executeQuery();
            while (rs.next()) {
                spct = new sanphamchitiet();
                spct.setMASP(rs.getString("MASP"));
                spct.setGIA(rs.getInt("GIA"));
                spct.setSOLUONG(rs.getInt("SOLUONG"));
                spct.setMaspct(rs.getInt("MACTSP"));
            }
            return spct;
        } catch (Exception e) {
            return null;
        }
    }

    public int getMaSPCT(String mau, String chatlieu, String size, String maSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select MACTSP from CHITIETSANPHAM where MAMS=? and MACL =? and MASIZE =? and MASP =?";
        sanphamchitiet spct = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mauservice.getMaMau(mau));
            ps.setObject(2, clservice.getMaCL(chatlieu));
            ps.setObject(3, sizeservice.getMaSize(size));
            ps.setObject(4, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                spct = new sanphamchitiet();
                spct.setMaspct(rs.getInt("MACTSP"));
            }
            return spct.getMaspct();
        } catch (Exception e) {
            return 0;
        }
    }

    public int getSLSPCT(int maCTSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select SOLUONG from CHITIETSANPHAM where MACTSP = ?";
        sanphamchitiet spct = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maCTSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                spct = new sanphamchitiet();
                spct.setSOLUONG(rs.getInt("SOLUONG"));
            }
            return spct.getSOLUONG();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getMaSP(int maCTSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select MASP from CHITIETSANPHAM where MACTSP = ?";
        sanphamchitiet spct = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maCTSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                spct = new sanphamchitiet();
                spct.setMASP(rs.getString("MASP"));
            }
            return spct.getMASP();
        } catch (Exception e) {
            return null;
        }
    }

    public Integer addSPCT(sanphamchitiet SPCT) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "INSERT INTO CHITIETSANPHAM (MASP, MAMS, MACL, MASIZE, HINHANH, SOLUONG, GIA, MOTA)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);

            pd.setString(1, SPCT.getMASP());
            pd.setInt(2, Integer.valueOf(SPCT.getMau()));
            pd.setInt(3, Integer.valueOf(SPCT.getChatlieu()));
            pd.setInt(4, Integer.valueOf(SPCT.getSIZE()));
            pd.setNString(5, SPCT.getLinkAnh());
            pd.setInt(6, SPCT.getSOLUONG());
            pd.setDouble(7, SPCT.getGIA());
            pd.setNString(8, "null");
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }

        return row;

    }

    public Integer UPDATESPCT(sanphamchitiet SPCT) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "update CHITIETSANPHAM\n"
                + "set MASP = ? ,MAMS = ? ,MACL = ? , MASIZE = ? ,HINHANH = ? ,SOLUONG = ? , GIA =? ,MOTA = ?\n"
                + "where MACTSP = ?";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);

            pd.setString(1, SPCT.getMASP());
            pd.setInt(2, Integer.valueOf(SPCT.getMau()));
            pd.setInt(3, Integer.valueOf(SPCT.getChatlieu()));
            pd.setInt(4, Integer.valueOf(SPCT.getSIZE()));
            pd.setNString(5, SPCT.getLinkAnh());
            pd.setInt(6, SPCT.getSOLUONG());
            pd.setDouble(7, SPCT.getGIA());
            pd.setNString(8, "null");
            pd.setInt(9, SPCT.getMaspct());
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }

        return row;

    }

    public int updateSL(int maCTSP, int sl) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "update CHITIETSANPHAM set SOLUONG = ? where MACTSP = ?";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);
            ps.setObject(2, maCTSP);

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

}
