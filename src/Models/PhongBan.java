package Models;

import java.util.List;

public class PhongBan {
    private int maPhongBan;
    private String tenPhongBan;

    private int maChiNhanh;
    private ChiNhanh chiNhanh;

    private List<NhanVien> nhanViens;

    public PhongBan(int maPhongBan, String tenPhongBan, int maChiNhanh) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.maChiNhanh = maChiNhanh;
    }

    public PhongBan(String tenPhongBan, int maChiNhanh) {
        this.tenPhongBan =tenPhongBan;
        this.maChiNhanh = maChiNhanh;
    }


    public int getMaPhongBan() {
        return maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
