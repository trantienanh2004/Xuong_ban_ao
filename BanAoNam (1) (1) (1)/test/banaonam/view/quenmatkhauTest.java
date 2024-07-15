/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package banaonam.view;

import banaonam.model.taikhoan;
import banaonam.model.taikhoandoimk;
import banaonam.sevice.nhanvienservice;
import banaonam.sevice.taikhoanservice;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class quenmatkhauTest {
     String otp = random();
    String taikhoan = "";
    taikhoanservice sertk = new taikhoanservice();
    public quenmatkhauTest() {
        
    }

    
    
    boolean taikhoan(String taikhoan){
        nhanvienservice sernv = new nhanvienservice();

        boolean check = false;

        for (taikhoandoimk object : sernv.laygmail()) {
            if (object.getGmail().equals(taikhoan)) {
                check = true;
                taikhoan = object.getTaikhoan();
               
            }
        }
        if (check == false) {
//            JOptionPane.showMessageDialog(this, "gmail không tồn tại ");
          
        }
        String sub = "quên mật khẩu : ";
        String mess = "mã otp :" + " " + otp 
        + "không tiết lộ mã này cho bất kỳ ai";
        String tk = "conbotthoiok@gmail.com";
        String mk = "v j b p n z x v m c s r e j n n";
        guimail("anhttph40973@fpt.edu.vn", sub, mess, tk, mk);
       // JOptionPane.showMessageDialog(this, "mã đã được gửi đến gmail");
       return check;
    }
    
   
    @Test
        public void testnhaptk() {
          boolean kiemtra = taikhoan("anhttph40973@gmail.com");
            assertTrue(kiemtra);
        }
    @Test
        public void testdoimk() {
          boolean kiemtra = quenmatkhau("1234","1234");
            assertTrue(kiemtra);
        }
        /// mã otp cố định hiện tại là 12345
    
   boolean  quenmatkhau(String txtmatkhaumoi ,String txtmatkhauxacnhan  ){
        
       boolean check = true;    
       boolean kqcheck = false;

        if (txtmatkhaumoi.isBlank() || txtmatkhaumoi.isBlank() || txtmatkhauxacnhan.isBlank()) {
          
            //null
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher x = p.matcher(txtmatkhaumoi);
        Matcher y = p.matcher(txtmatkhauxacnhan);

        boolean b = x.find();
        boolean a = y.find();

        if (b || a) {
            check = false;
        }
        if (check == false) {
           //ký tự đặc biệt
        }

        if (txtmatkhaumoi.equals(txtmatkhauxacnhan)) {

            taikhoan tk = laydulieu();
            if (sertk.doimktaikhoan(tk) != null) {
            //    JOptionPane.showMessageDialog(this, "đổi thành công");
              kqcheck = true;
               
            } else {
               // JOptionPane.showMessageDialog(this, "đổi thất bại , có lỗi sẩy ra");
            }

        } else {
           // JOptionPane.showMessageDialog(this, "mật khẩu xác nhận không giống với mật khẩu mới");
         //   mật khẩu xác nhận không giống với mật khẩu mới
        }
        return kqcheck;
    }
    public boolean guimail(String to, String sub, String msg, String tk, String mk) {
        Properties ppts = new Properties();
boolean check = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(tk, mk);
            }
        });
        try {
            MimeMessage massage = new MimeMessage(session);
            massage.setFrom(new InternetAddress(tk));
            massage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            massage.setSubject(sub);
            massage.setContent(msg, "text/html");
            Transport.send(massage);
check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public String random() {
        String randomString;
        int length = 6;
        Random rd = new Random();
        String characters = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = rd.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);

        }
        randomString = sb.toString();

        return randomString;
    }
    public taikhoan laydulieu() {
        taikhoan tk = new taikhoan();
        tk.setTenTK("abc");
        tk.setMatKhau("abc");
        return tk;
    }
    
    
    
     String sub = "quên mật khẩu : ";
        String mess = "mã otp :" + " " + otp 
        + "không tiết lộ mã này cho bất kỳ ai";
        String tk = "conbotthoiok@gmail.com";
        String mk = "v j b p n z x v m c s r e j n n";
        
    // tài khoản đúng
    @Test
    public void testTaikhoan() {
        boolean kiemtra = taikhoan("anhttph40973@gmail.com");
        assertTrue(kiemtra);
    }
    // đổi mật khẩu thành công
    @Test
    public void testDoimk() {
        boolean kiemtra = quenmatkhau("1234","1234");
        assertTrue(kiemtra);
    }
    // mật khẩu mới để trống
    @Test
    public void testMatKhauMoiTrong() {
        assertFalse(quenmatkhau("", "1234"));
    }
    // mật khẩu xác nhận để trống
    @Test
    public void testMatKhauXacNhanTrong() {
        assertFalse(quenmatkhau("1234", ""));
    }
    //mật khẩu có chứa ký tự đặt biệt
    @Test
    public void testMatKhauMoiChuaKyTuDacBiet() {
        assertTrue(quenmatkhau("abc!@#", "abc!@#"));
    }
    //mật khẩu xác nhận có chứa ký tự đặt biệt
    @Test
    public void testMatKhauXacNhanChuaKyTuDacBiet() {
        assertFalse(quenmatkhau("1234", "1234!@#"));
    }
    //mật khẩu không khớp
    @Test
    public void testMatKhauKhongKhop() {
        assertFalse(quenmatkhau("1234", "5678"));
    }
    // tài khoản không tồn tại
    @Test
    public void testTaiKhoanKhongTonTai() {
        assertFalse(taikhoan("nonexistent@gmail.com"));
    }
    // gửi mail xác nhận thành công
    @Test
    public void testGuiMailThanhCong() {
        assertTrue(guimail("anhttph40973@gmail.com", sub,  mess, tk,  mk));
    }
    // gửi mail xác nhận thất bại
    @Test
    public void testGuiMailThatBai() {
        assertFalse(guimail("anhttph40973@gmail.com", sub,  mess, tk, "sai"));
    }

    
}

