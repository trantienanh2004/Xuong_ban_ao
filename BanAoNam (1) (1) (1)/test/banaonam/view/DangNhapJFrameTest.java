/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package banaonam.view;

import banaonam.model.dangnhap;
import banaonam.sevice.dangnhapservice;
import static banaonam.view.DangNhapJFrame.txtPass;
import static banaonam.view.DangNhapJFrame.txtUser;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class DangNhapJFrameTest {

    dangnhapservice dn = new dangnhapservice();

    
        @Test
        public void testLoginthanhcong() {
          boolean kiemtra = dangnhap("nhanviendz01", "123");
            System.out.println(kiemtra);
            assertTrue(kiemtra);
        }
        
   public boolean dangnhap(String txtUser, String txtPass) {
    if (txtUser == null || txtPass == null) {
        throw new IllegalArgumentException("null input");
    }

    List<dangnhap> danhSachDangNhap = dn.getalldangnhap();

    for (int i = 0; i < danhSachDangNhap.size(); i++) {
        dangnhap dangNhap = danhSachDangNhap.get(i);
        if (txtUser.equalsIgnoreCase(dangNhap.getTentk()) && txtPass.equalsIgnoreCase(dangNhap.getPass())) {
            return true;
        }
    }

    throw new IllegalArgumentException("invalid credentials");
}
}
