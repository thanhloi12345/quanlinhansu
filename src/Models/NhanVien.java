package Models;

import java.util.Date;

public class NhanVien {
    private int maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private double luong;
    private  int maPhongBan;
    private PhongBan phongBan;

    public NhanVien(int maNhanVien, String hoTen, Date ngaySinh, String gioiTinh, double luong, int maPhongBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.maPhongBan = maPhongBan;
    }
    public  NhanVien(String hoTen, Date ngaySinh, String gioiTinh, double luong, int maPhongBan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.maPhongBan = maPhongBan;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }
}
