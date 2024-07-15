/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.sevice;
import banaonam.untility.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public class quenmatkhau {
    public Integer timtaikhoan(String taikhoan){
        Integer row = null;
        Connection cn = DB.getConnection();
        try {
            String sql = "select TENTK from NHANVIEN join TAIKHOAN on nhanvien.MATK = TAIKHOAN.MATK\n" +
"			where gmail = ?";
            PreparedStatement pd = cn.prepareStatement(sql);
            pd.setString(1, taikhoan);
            row = pd.executeUpdate();
        } catch (Exception e) {
            
        }
        return row;
    }
}
