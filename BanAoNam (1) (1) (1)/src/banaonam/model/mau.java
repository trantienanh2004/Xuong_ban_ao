/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banaonam.model;

/**
 *
 * @author HP
 */
public class mau {
     private int MaMau;
    private String TenMau;

    public mau(int MaMau, String TenMau) {
        this.MaMau = MaMau;
        this.TenMau = TenMau;
    }

    public mau() {
    }

    public int getMaMau() {
        return MaMau;
    }

    public void setMaMau(int MaMau) {
        this.MaMau = MaMau;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }
    
    
    
}
