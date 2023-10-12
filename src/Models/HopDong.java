package Models;

import java.util.Date;

public class HopDong {
    private int maHopDong;
    private  int maNhanVien;
    private NhanVien nhanVien;
    private Date ngayKy;
    private String loaiHopDong;

    public HopDong(int maHopDong, int maNhanVien, Date ngayKy, String loaiHopDong) {
        this.maHopDong = maHopDong;
        this.maNhanVien = maNhanVien;
        this.ngayKy = ngayKy;
        this.loaiHopDong = loaiHopDong;
    }

    public HopDong(int maNhanVien, Date ngayKy, String loaiHopDong) {
        this.maNhanVien = maNhanVien;
        this.ngayKy = ngayKy;
        this.loaiHopDong = loaiHopDong;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(String loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public Date getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        this.ngayKy = ngayKy;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
