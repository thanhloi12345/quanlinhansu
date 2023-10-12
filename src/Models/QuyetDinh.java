package Models;

import java.util.Date;

public class QuyetDinh {
    private int maQuyetDinh;

    private int maNhanVien;
    private NhanVien nhanVien;
    private String loaiQuyetDinh;
    private Date ngayQuyetDinh;

    public QuyetDinh(int maQuyetDinh, int maNhanVien, String loaiQuyetDinh, Date ngayQuyetDinh) {
        this.maQuyetDinh = maQuyetDinh;
        this.maNhanVien = maNhanVien;
        this.loaiQuyetDinh = loaiQuyetDinh;
        this.ngayQuyetDinh = ngayQuyetDinh;
    }
    public QuyetDinh(int maNhanVien, String loaiQuyetDinh, Date ngayQuyetDinh) {
        this.maNhanVien = maNhanVien;
        this.loaiQuyetDinh = loaiQuyetDinh;
        this.ngayQuyetDinh = ngayQuyetDinh;
    }


    public Date getNgayQuyetDinh() {
        return ngayQuyetDinh;
    }

    public void setNgayQuyetDinh(Date ngayQuyetDinh) {
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    public int getMaQuyetDinh() {
        return maQuyetDinh;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getLoaiQuyetDinh() {
        return loaiQuyetDinh;
    }

    public void setLoaiQuyetDinh(String loaiQuyetDinh) {
        this.loaiQuyetDinh = loaiQuyetDinh;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
