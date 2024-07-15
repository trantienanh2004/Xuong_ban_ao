/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.mau;
import banaonam.model.size;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class sizeService {

    public ArrayList<size> getallchatlieu() {
        ArrayList<size> dssize = new ArrayList<>();
        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM SIZE";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                size sz = new size();
                sz.setMaSize(rs.getInt(1));
                sz.setTenSize(rs.getString(2));
                dssize.add(sz);
            }
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        return dssize;
    }

    public int getMaSize(String ten) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select MASIZE from SIZE where TENSIZE = ?";
        size s = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new size();
                s.setMaSize(rs.getInt("MASIZE"));
            }
            return s.getMaSize();
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer addsize(String size) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "INSERT INTO SIZE ( TENSIZE)\n"
                + "VALUES\n"
                + "( ?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setNString(1, size);
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        return row;
    }

}
