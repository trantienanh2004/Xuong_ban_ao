/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author HP
 */
public class chatlieu {
     private int MaChatLieu;
    private String TenChatLieu;

    public chatlieu() {
    }

    public chatlieu(int MaChatLieu, String TenChatLieu) {
        this.MaChatLieu = MaChatLieu;
        this.TenChatLieu = TenChatLieu;
    }

    public int getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(int MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }
    
    
}
