package Models;

import java.util.Date;

public class QuaTrinhCongTac {
    private int maQuaTrinh;
    private int maNhanVien;
    private NhanVien nhanVien;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private String moTaCongViec;

    public QuaTrinhCongTac(int maQuaTrinh, int maNhanVien, Date thoiGianBatDau, Date thoiGianKetThuc, String moTaCongViec) {
        this.maQuaTrinh = maQuaTrinh;
        this.maNhanVien = maNhanVien;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.moTaCongViec = moTaCongViec;
    }
    public QuaTrinhCongTac(int maNhanVien, Date thoiGianBatDau, Date thoiGianKetThuc, String moTaCongViec){

        this.maNhanVien = maNhanVien;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.moTaCongViec = moTaCongViec;
    }

    public int getMaQuaTrinh() {
        return maQuaTrinh;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMoTaCongViec() {
        return moTaCongViec;
    }

    public void setMoTaCongViec(String moTaCongViec) {
        this.moTaCongViec = moTaCongViec;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
