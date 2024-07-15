/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import banaonam.model.chatlieu;
import banaonam.untility.DB;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ChatLieuService {

    public ArrayList<chatlieu> getallchatlieu() {
        ArrayList<chatlieu> dscl = new ArrayList<>();
        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM CHatlieu";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {
                chatlieu cl = new chatlieu();
                cl.setMaChatLieu(rs.getInt(1));
                cl.setTenChatLieu(rs.getString(2));
                dscl.add(cl);
            }
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        return dscl;
    }

    public int getMaCL(String tenCL) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        sql = "select MACL from CHATLIEU where TENCHATLIEU = ?";
        chatlieu cl = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenCL);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl = new chatlieu();
                cl.setMaChatLieu(rs.getInt("MACL"));
            }
            return cl.getMaChatLieu();
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer addchatlieu(String tenchatlieu) {
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "INSERT INTO CHATLIEU(TENCHATLIEU) VALUES\n"
                + "(?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, tenchatlieu);
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }

        return row;
    }
}
