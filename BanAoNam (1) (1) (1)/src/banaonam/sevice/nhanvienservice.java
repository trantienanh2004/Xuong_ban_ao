/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.nhanvien;
import banaonam.model.sanphamchitiet;
import banaonam.model.taikhoandoimk;
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
public class nhanvienservice {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    
    
    public int getMaNV(int maTK) {
        sql = "select MANV from NHANVIEN where MATK = ?";
        nhanvien nv = null;
        
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maTK);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanvien();
                nv.setMaNV(rs.getInt("MANV"));
            }
            return nv.getMaNV();
        } catch (Exception e) {
            return 0;
        }
    }
    public int getMaTK(int maNV) {
        sql = "select MATK from NHANVIEN where MANV = ?";
        nhanvien nv = null;
        
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanvien();
                nv.setMaTK(rs.getInt("MATK"));
            }
            return nv.getMaTK();
        } catch (Exception e) {
            return 0;
        }
    }
    public int getMaNV(String tenNV) {
        sql = "select MANV from NHANVIEN where tennv like ?";
        nhanvien nv = null;
        
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanvien();
                nv.setMaNV(rs.getInt("MANV"));
            }
            return nv.getMaNV();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public String tenNV(int maNV) {
        sql = "select TENNV from NHANVIEN where MANV = ?";
        nhanvien nv = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanvien();
                nv.setTenNV(rs.getString("TENNV"));
            }
            return nv.getTenNV();
        } catch (Exception e) {
            return null;
        }
    }

    public String chucvu(int maNV) {
        sql = "select chucvu from NHANVIEN where MANV = ?";
        nhanvien nv = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanvien();
                nv.setTenNV(rs.getString("TENNV"));
            }
            return nv.getTenNV();
        } catch (Exception e) {
            return null;
        }        
    }

    public List<nhanvien> getDSNV(){
        sql = "select TENNV,matk from nhanvien";
        List<nhanvien> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                nhanvien nv = new nhanvien();
                nv.setTenNV(rs.getString(1));
                nv.setMaTK(rs.getInt(2));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<nhanvien> getallnhanvien() {
        ArrayList<nhanvien> dsnv = new ArrayList<>();
        
        Connection cn = DB.getConnection();
        String sql = "SELECT * from nhanvien";
        
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getInt(1));
                nv.setMaTK(rs.getInt(2));
                nv.setTenNV(rs.getNString(3));
                nv.setSDT(rs.getString(4));
                nv.setGioiTinh(rs.getInt(5));
                nv.setDiaChi(rs.getNString(6));
                nv.setGmail(rs.getString(7));
                dsnv.add(nv);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return dsnv;
    }
    public ArrayList<taikhoandoimk> laygmail() {
        ArrayList<taikhoandoimk> tkdmk = new ArrayList<>();
        
        Connection cn = DB.getConnection();
        String sql = "select TENTK,gmail from NHANVIEN join TAIKHOAN on nhanvien.MATK = TAIKHOAN.MATK\n" +			
"			group by TENTK,gmail";
        
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
               taikhoandoimk tk = new taikhoandoimk();
               tk.setTaikhoan(rs.getString(1));
               tk.setGmail(rs.getString(2));
                tkdmk.add(tk);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return tkdmk;
    }
    
    public ArrayList<nhanvien> getAllNhanVien() {
        ArrayList<nhanvien> nv = new ArrayList<>();
        String sql = "select manv, tennv, sdt, gioitinh, diachi,gmail from nhanvien";
        
        try {
            Connection cn = DB.getConnection();
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            
            while (rs.next()) {
                nhanvien nv1 = new nhanvien();
                nv1.setMaNV(rs.getInt(1));
                nv1.setTenNV(rs.getString(2));
                nv1.setSDT(rs.getString(3));
                nv1.setGioiTinh(rs.getInt(4));
                nv1.setDiaChi(rs.getString(5));
                nv1.setGmail(rs.getString(6));
                nv.add(nv1);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        return nv;
    }
    
    public Integer addNV(nhanvien kh) {
        
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "Insert into nhanvien values (null,?,?,?,?,?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            
            pd.setString(1, kh.getTenNV());
            pd.setString(2, kh.getSDT());
            pd.setInt(3, kh.getGioiTinh());
            pd.setString(4, kh.getDiaChi());
            pd.setString(5, kh.getGmail());
            
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        return row;
        
    }
    
    public Integer updateNhanVien(nhanvien kh) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "update nhanvien \n"
                + "set TENNV = ?, SDT = ?, DIACHI = ?, GIOITINH = ?\n"
                + "where MANV = ?";
        
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, kh.getTenNV());
            pd.setString(2, kh.getSDT());
            pd.setString(3, kh.getDiaChi());
            pd.setInt(4, kh.getGioiTinh());
            pd.setInt(5, kh.getMaNV());
            
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        
        return row;
        
    }
    public Integer updateTaiKhoan(int maNV) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "update nhanvien \n"
                + "set MATK = ((select count(*) from TAIKHOAN))\n"
                + "where MANV = ?";
        
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
           pd.setInt(1, maNV);
            
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        
        return row;
        
    }
    
    public Integer deleteNhanVien(nhanvien kh) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = " delete  from NhanVien where TENNV =  ? ";
        
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            
            pd.setString(1, kh.getTenNV());
            
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        
        return row;
    }
    
}
