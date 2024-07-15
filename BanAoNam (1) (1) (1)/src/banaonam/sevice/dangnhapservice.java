/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import banaonam.model.dangnhap;
import banaonam.untility.DB;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class dangnhapservice {
    
    
    public ArrayList<dangnhap> getalldangnhap(){
        ArrayList<dangnhap> dstk = new ArrayList<>();
       
        Connection cn = DB.getConnection();
        String sql = "SELECT * FROM TAIKHOAN";
        try {
           PreparedStatement pd = cn.prepareStatement(sql);
           ResultSet rs = pd.executeQuery();
            while (rs.next()) {       
              dangnhap dn = new dangnhap();   
                dn.setTaikhoan(rs.getString(1));
                dn.setTentk(rs.getString(2));
                dn.setPass(rs.getString(3));
                dn.setRole(rs.getString(4));
                dstk.add(dn);
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }
        return dstk;
    }
    
}
