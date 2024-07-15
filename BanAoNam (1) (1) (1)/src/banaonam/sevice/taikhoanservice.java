/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

/**
 *
 * @author NGUYEN HUU LOC
 */
import banaonam.model.taikhoan;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class taikhoanservice {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public int getMaTK(String tenTK) {
        sql = "select MATK from TAIKHOAN where TENTK = ?";
        taikhoan tk = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenTK);

            rs = ps.executeQuery();
            while (rs.next()) {
                tk = new taikhoan();
                tk.setMaTK(rs.getInt("MATK"));
            }
            return tk.getMaTK();
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<taikhoan> getalltaikhoan() {
        ArrayList<taikhoan> dstk = new ArrayList<>();
        con = DB.getConnection();
        sql = "SELECT * FROM TAIKHOAN";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                taikhoan tk = new taikhoan();
                tk.setTenTK(rs.getString(2));
                tk.setMaTK(rs.getInt(1));
                tk.setMatKhau(rs.getString(3));
                tk.setChucVu(rs.getString(4));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(taikhoanservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }

    public Integer doimktaikhoan(taikhoan tk) {
        Integer row = null;
        con = DB.getConnection();
        sql = "update TAIKHOAN\n"
                + "set MATKHAU = ?\n"
                + "where tentk = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, tk.getMatKhau());
            ps.setString(2, tk.getTenTK());
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public int addTK(taikhoan tk) {
        sql = "INSERT INTO TAIKHOAN(MATK,TENTK,MATKHAU,CHUCVU) VALUES\n"
                + "(((select count(*) from TAIKHOAN)+1),?,?,'NHANVIEN')";
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tk.getTenTK());
            ps.setObject(2, tk.getMatKhau());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
