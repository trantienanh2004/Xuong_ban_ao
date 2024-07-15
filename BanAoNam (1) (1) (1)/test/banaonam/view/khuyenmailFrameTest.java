/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package banaonam.view;

import banaonam.model.khuyenmai;
import banaonam.sevice.khuyenmaiService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author HP
 */
public class khuyenmailFrameTest {

    khuyenmaiService serKM = new khuyenmaiService();

    public String randommakhuyenmai() {
        String randomString;
        int length = 8;
        Random rd = new Random();
        //những chữ được quyền truy c
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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

    public khuyenmai layDLKM(Date txtDataKT, String lblID, String txtnoidung, String txtMaKhuyenMai, Date txtDataMo, String txtMucKM) {
        String trangthai = "vẫn hoạt động";
        Date dateX, dateY = txtDataKT;

        try {
            LocalDate currentDate = LocalDate.now();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateKT = sdf.format(txtDataKT.getDate());
            dateX = new SimpleDateFormat("yyyy-MM-dd").parse((String) currentDate.toString());
            dateY = new SimpleDateFormat("yyyy-MM-dd").parse(dateKT);

            if (dateX.after(dateY)) {
                System.out.println("Ngày tháng năm x lớn hơn ngày tháng năm y");
                trangthai = "đã quá ngày";
            } else if (dateX.before(dateY)) {
                System.out.println("Ngày tháng năm x nhỏ hơn ngày tháng năm y");
                trangthai = "vẫn hoạt động";
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        khuyenmai khuyenmai = new khuyenmai();
        khuyenmai.setId(Integer.parseInt(lblID));
        khuyenmai.setNoidungkhuyenmai(txtnoidung);
        khuyenmai.setMakhuyenmai(txtMaKhuyenMai);
        khuyenmai.setNgaybatdau(txtDataMo);
        khuyenmai.setNgayketthuc(txtDataKT);
        khuyenmai.setGiamgia(txtMucKM);
        khuyenmai.setTrangthai(trangthai);
        return khuyenmai;
    }

    public boolean suaKM(Date txtDataKT, String lblID, String txtnoidung, String txtMaKhuyenMai, Date txtDataMo, String txtMucKM) {
        boolean check = false;
        khuyenmai result = layDLKM(txtDataKT, lblID, txtnoidung, txtMaKhuyenMai, txtDataMo, txtMucKM);
        if (serKM.sua(result) != null) {
            check = true;
        } else {
//            JOptionPane.showMessageDialog(this, "sửa thất bại");
        }
        return check;
    }

    public boolean VoHieuHoaKM(String lblID) {
    try {
        int id = Integer.parseInt(lblID);
        boolean check = false;
        if (serKM.voHieuHoa(id) != null) {
            check = true;
        } else {
            // Có thể hiển thị thông báo hoặc thực hiện các thao tác khác ở đây
            // JOptionPane.showMessageDialog(this, "Vô hiệu hóa thất bại");
        }
        return check;
    } catch (NumberFormatException e) {
        // Xử lý khi chuỗi lblID không thể chuyển đổi thành số nguyên
        // Có thể hiển thị thông báo hoặc thực hiện các thao tác khác ở đây
        // JOptionPane.showMessageDialog(this, "ID không hợp lệ");
        return false;
    }
}


    public boolean themKM(Date txtDataKT, String lblID, String txtnoidung, String txtMaKhuyenMai, Date txtDataMo, String txtMucKM) {
        boolean check = false;
        khuyenmai result = layDLKM(txtDataKT, lblID, txtnoidung, txtMaKhuyenMai, txtDataMo, txtMucKM);
        if (serKM.them(result) != null) {
            check = true;
//            JOptionPane.showMessageDialog(this, "thêm thành công");
//            loadingtablekhuyenmai(serKM.getallkhuyenmai());
        } else {
            //          JOptionPane.showMessageDialog(this, "thêm thất bại");
        }
        return check;
    }
// mã khuyến mãi tự tạo ra 8 ký tự ngẫu nhiên
    @Test
    public void testRandommakhuyenmai() {
        String result = randommakhuyenmai();
        assertNotNull(result);
        assertEquals(8, result.length());
    }
// trạng thái của mã khuyến mãi
    @Test
    public void testLayDLKM() {
       Date txtDataMo = new Date();
        Date txtDataKT = new Date(System.currentTimeMillis() - 86400000); 
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung [] = {"Nội dung khuyến mãi","dsfjsdfsdf","tết","hsdsdsđs","trung thu"};
        String txtMaKhuyenMai = randommakhuyenmai();
       
        String txtMucKM = "10%";
//ngày đã quá 
       for (int i = 0; i < 5; i++) {
           khuyenmai result = layDLKM(txtDataKT, lblID[i], txtnoidung[i], txtMaKhuyenMai, txtDataMo, txtMucKM);
        assertNotNull(result);
        assertEquals("đã quá ngày", result.getTrangthai());
    }
    }
    @Test
    public void testLayDLKM_PassedEndDate() {
        // Test khi ngày kết thúc đã qua
           Date txtDataMo = new Date();
        Date txtDataKT = new Date(System.currentTimeMillis() - 86400000); 
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung [] = {"Nội dung khuyến mãi","dsfjsdfsdf","tết","hsdsdsđs","trung thu"};
        String txtMaKhuyenMai = randommakhuyenmai();
       
        String txtMucKM = "10%";
          for (int i = 0; i < 5; i++) {
           khuyenmai result = layDLKM(txtDataKT, lblID[i], txtnoidung[i], txtMaKhuyenMai, txtDataMo, txtMucKM);
        assertNotNull(result);
        assertEquals("đã quá ngày", result.getTrangthai()); 
        }
    }

    @Test
    public void testLayDLKM_FutureEndDate() {
        // Test khi ngày kết thúc là ngày trong tương lai
         Date txtDataMo = new Date();
        Date txtDataKT = new Date(System.currentTimeMillis() + 86400000); 
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung [] = {"Nội dung khuyến mãi","dsfjsdfsdf","tết","hsdsdsđs","trung thu"};
        String txtMaKhuyenMai = randommakhuyenmai();
       
        String txtMucKM = "10%";
        for (int i = 0; i < 5; i++) {
           khuyenmai result = layDLKM(txtDataKT, lblID[i], txtnoidung[i], txtMaKhuyenMai, txtDataMo, txtMucKM);
        assertNotNull(result);
        assertEquals("đã quá ngày", result.getTrangthai()); 
        }
        
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLayDLKM_InvalidDateFormat() {
        // Test khi định dạng ngày tháng không hợp lệ
        String txtDataMo [] = {"11-11-2024","11-11-2024","11-11-2024","11-11-2024","11-11-2024"}; 
        String txtDataKT [] = {"11-11-2024","11-11-2024","11-11-2024","11-11-2024","11-11-2024"};
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung [] = {"Nội dung khuyến mãi","dsfjsdfsdf","tết","hsdsdsđs","trung thu"};
        String txtMaKhuyenMai = randommakhuyenmai();
       
        String txtMucKM = "10%";
        for (int i = 0; i < 5; i++) {
            
        
        thrown.expect(IllegalArgumentException.class);
        layDLKM(
                java.sql.Date.valueOf(txtDataKT[i]),
                lblID[i],
                txtnoidung[i],
                txtMaKhuyenMai,
                java.sql.Date.valueOf(txtDataMo[i]),
                txtMucKM
        );
        }
    }

    public class khuyenmailFrameTestTest {

        private khuyenmailFrameTest testInstance;

        @Test
        public void testLayDLKM_NullEndDate() {
            // Test khi ngày kết thúc là null
            Date txtDataMo = new Date();
        Date txtDataKT = new Date(System.currentTimeMillis() - 86400000); 
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung [] = {"Nội dung khuyến mãi","dsfjsdfsdf","tết","hsdsdsđs","trung thu"};
        String txtMaKhuyenMai = randommakhuyenmai();
       
        String txtMucKM = "10%";
            for (int i = 0; i < 5; i++) {
            try {
                testInstance.layDLKM(null, lblID[i], txtnoidung[i], txtMaKhuyenMai, txtDataMo, txtMucKM);
                fail("Lỗi: Phương thức layDLKM không ném ra ngoại lệ khi ngày kết thúc là null");
            } catch (Exception e) {
                // Kiểm tra xem thông điệp của ngoại lệ có đúng không
                assertEquals("Ngày kết thúc không được phép null", e.getMessage());
            }
        } }
    }

    @Test
    public void testSuaKM() {
        // Test khi sửa khuyến mãi thành công
        Date txtDataKT = new Date();
        String lblID = "1";
        String txtnoidung = "Nội dung khuyến mãi";
        String txtMaKhuyenMai = "KM123456";
        Date txtDataMo = new Date();
        String txtMucKM = "10%";

        boolean result = suaKM(txtDataKT, lblID, txtnoidung, txtMaKhuyenMai, txtDataMo, txtMucKM);
        assertTrue(result);
    }

    @Test
    public void testVoHieuHoaKM() {
        // Test khi vô hiệu hóa khuyến mãi thành công
        
        String lblID[] = {"1","2"};
        for (int i = 0; i < 2; i++) {
           boolean result = VoHieuHoaKM(lblID[i]);
        assertTrue(result); 
        }
        
    }
@Test
    public void testVoHieuHoaKMIDsai() {
        // Test khi vô hiệu hóa khuyến với id sai
        String lblID = randommakhuyenmai();

        boolean result = VoHieuHoaKM(lblID);
        assertFalse(result);
    }
    @Test
    public void testVoHieuHoaKMIDRong() {
        // Test khi vô hiệu hóa khi id rong
        String lblID = "";

        boolean result = VoHieuHoaKM(lblID);
        assertFalse(result);
    }
    @Test
    public void testThemKM() {
        // Test khi thêm khuyến mãi thành công
        Date txtDataKT = new Date();
        String lblID[] = {"1","2","3","4","5"};
        String txtnoidung[] = {"Nội dung khuyến mãi","ooooo","abc","def","aaa"};
        String txtMaKhuyenMai = randommakhuyenmai();
        Date txtDataMo = new Date();
        String txtMucKM = "10%";
        for (int i = 0; i < 5; i++) {
           boolean result = themKM(txtDataKT, lblID[i], txtnoidung[i], txtMaKhuyenMai, txtDataMo, txtMucKM);
        assertTrue(result); 
        }
        
    }

}
