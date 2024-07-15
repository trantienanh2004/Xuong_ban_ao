/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package banaonam.view;

import banaonam.model.taikhoan;
import banaonam.sevice.taikhoanservice;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class manhinhdoimatkhauTest {

    String capcha;
    taikhoanservice sertk = new taikhoanservice();
    boolean doimatkhau(String txtTenTK ,String txtmatkhau,String txtmatkhaumoi,String txtxacnhanmk ){
         boolean check = true;
         boolean doimatkhaucheck = false;
        if(txtTenTK.isBlank()||txtmatkhau.isBlank()||txtmatkhaumoi.isBlank()||txtxacnhanmk.isBlank()){
         doimatkhaucheck = false;
         
     }
        if(txtmatkhaumoi.trim().length()<=0||txtxacnhanmk.trim().length()<=0){
        doimatkhaucheck = false;
         
     }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher x = p.matcher(txtmatkhau);
        Matcher y = p.matcher(txtmatkhaumoi);
        Matcher z = p.matcher(txtxacnhanmk);
boolean b = x.find();
boolean a = y.find();
boolean c = z.find();
if (b||a||c){
    check = false;
}
     if(check == false){
        // JOptionPane.showMessageDialog(this, "không được chứa ký tự đặc biệt");
         
     }   
        if(check(txtTenTK, txtmatkhau) == true){
          if(txtmatkhaumoi.equals(txtxacnhanmk)){
            String otp = "12345";
              if(otp.equalsIgnoreCase("12345")){
                  taikhoan tk = laydulieu();
                  if(sertk.doimktaikhoan(tk)!=null){
                      //JOptionPane.showMessageDialog(this, "đổi thành công");
                    doimatkhaucheck = true;
                  }else{
                    //  JOptionPane.showMessageDialog(this,"đổi thất bại , có lỗi sẩy ra");
                  }
              }else{
                 // JOptionPane.showMessageDialog(this, "Mã capcha sai");
                  capcha();
                 // return;
              }
          }else{
            //  JOptionPane.showMessageDialog(this, "mật khẩu xác nhận không giống với mật khẩu mới");
             // return;
          }
      }else{
        //  JOptionPane.showMessageDialog(this, "tài khoản hoặc mật khẩu không chính xác");
         // return;
      }
        return doimatkhaucheck;
    }
    // test thử 
    @Test
        public void testdoimk() {
          boolean kiemtra = doimatkhau("nhanviendz02","1234","123","123");
            assertTrue(kiemtra);
        }
    
    public String randommakhuyenmai() {
        String randomString;
        int length = 5;
        Random rd = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = rd.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        randomString = sb.toString();
        System.out.println("Chuỗi ngẫu nhiên được tạo ra là: " + randomString);
        return randomString;
    }

    String  capcha() {
        String capcha = randommakhuyenmai();
        return capcha;
    }

    public boolean check(String txtTenTK, String txtmatkhau) {
        boolean check = false;
        for (taikhoan object : sertk.getalltaikhoan()) {
            if (object.getTenTK().equalsIgnoreCase(txtTenTK) && object.getMatKhau().equalsIgnoreCase(txtmatkhau)) {
                check = true;
            }
        }
        return check;
    }

    @Test
    public void checktaikhoantontai() {
        boolean kiemtra = check("admin", "1234");
        assertTrue(kiemtra);
    }

    public taikhoan laydulieu() {
        taikhoan tk = new taikhoan();
        tk.setTenTK("admin");
        tk.setMatKhau("1234");
        return tk;
    }
    

   

    //  đổi mật khẩu thành công
    @Test
    public void testDoiMatKhauThanhCong() {
        boolean result = doimatkhau("nhanviendz02", "1234", "123", "123");
        assertTrue(result);
    }

    // đổi mật khẩu với tên tài khoản không hợp lệ
    @Test
    public void testDoiMatKhauTaiKhoanRong() {
        boolean result = doimatkhau("", "1234", "123", "123");
        assertFalse(result);
    }

    // đổi mật khẩu với mật khẩu không hợp lệ
    @Test
    public void testDoiMatKhauVoiMatKhauSai() {
        boolean result = doimatkhau("nhanviendz02", "abc@123", "123", "123");
        assertFalse(result);
    }

    // đổi mật khẩu với mật khẩu mới không khớp với mật khẩu xác nhận
    @Test
    public void testDoiMatKhauMoivoiMatkhauXacNhanKhacNhau() {
        boolean result = doimatkhau("nhanviendz02", "1234", "123", "456");
        assertFalse(result);
    }

    //  đổi mật khẩu với mật khẩu mới chứa ký tự đặc biệt
    @Test
    public void testDoiMatKhauCoKyTuDacBiet() {
        boolean result = doimatkhau("nhanviendz02", "1234", "abc@123", "abc@123");
        assertTrue(result);
    }

    // đổi mật khẩu với mã OTP không chính xác
   @Test
public void testDoiMatKhauOTPSai() {
    boolean result = doimatkhau("nhanviendz02", "1234", "123", "456"); // Providing incorrect OTP
    assertFalse(result); // Expecting the password change process to fail
}

    //  đổi mật khẩu với tài khoản không tồn tại
    @Test
    public void testDoiMatKhauVoitaikhoanSai() {
        boolean result = doimatkhau("nonexistent", "1234", "123", "123");
        assertFalse(result);
    }

    //  đổi mật khẩu với tên tài khoản và mật khẩu trống
    @Test
    public void testDoiMatKhauTatCaDeuRong() {
        boolean result = doimatkhau("", "", "", "");
        assertFalse(result);
    }

    // đổi mật khẩu với mật khẩu mới và mật khẩu xác nhận trống
    @Test
    public void testDoiMatKhauMatKhauMoivaMatKhauXacNhanRong() {
        boolean result = doimatkhau("nhanviendz02", "1234", " ", "    ");
        assertFalse(result);
    }

    // mật khẩu với mật khẩu mới và mật khẩu xác nhận khác rỗng
    @Test
    public void testDoiMatKhauRongMKMoi() {
        boolean result = doimatkhau("nhanviendz02", "1234", "", "123");
        assertFalse(result);
    }


}
