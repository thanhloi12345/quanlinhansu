package Models;

import java.util.List;

public class ChiNhanh {
    private int maChiNhanh;
    private String tenChiNhanh;
    private String diaChi;
    private List<PhongBan> phongBans;
    public ChiNhanh(String tenChiNhanh, String diaChi) {
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }
    public ChiNhanh(int maChiNhanh, String tenChiNhanh, String diaChi) {
        this.maChiNhanh = maChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<PhongBan> getPhongBans() {return phongBans;}

    public void setPhongBans(List<PhongBan> phongBans) {this.phongBans = phongBans;}

    @Override
    public String toString() {
        return String.format("Mã Chi nhánh: %d, Tên Chi Nhánh: %s, Địa Chỉ: %s", this.getMaChiNhanh(),
                this.getTenChiNhanh(),
                this.getDiaChi());
    }
}
