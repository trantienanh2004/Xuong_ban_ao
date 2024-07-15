/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;

import banaonam.model.chatlieu;
import banaonam.model.mau;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class mauService {
   
    public ArrayList<mau> getallchatlieu(){
        ArrayList<mau> dsmau = new ArrayList<>();
        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM MauSAC";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
            ResultSet rs = pd.executeQuery();
            while (rs.next()) {                
                mau m =new mau();
                m.setMaMau(rs.getInt(1));
                m.setTenMau(rs.getString(2));
                dsmau.add(m);
            }
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        return dsmau;
    }
    
    public int getMaMau(String tenMau){
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        
        sql = "select MAMS from MAUSAC where TENMAU = ?";
        mau ms = null;
        try {
            con = DB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenMau);
            rs = ps.executeQuery();
            while(rs.next()){
                ms = new mau();
                ms.setMaMau(rs.getInt("MAMS"));
            }
            return ms.getMaMau();
        } catch (Exception e) {
            return 0;
        }
    }
    public Integer addmau(String tenmau){
        Integer row = null;
        Connection cn = DB.getConnection();
        String sql = "INSERT INTO MAUSAC(TENMAU) VALUES\n" +
"(?)";
        try {
            PreparedStatement pd = cn.prepareStatement(sql);
         pd.setString(1,tenmau );
            row = pd.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi");
            e.printStackTrace();
        }
        
        return row;
    }
    
}
