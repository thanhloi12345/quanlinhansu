package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.ChiNhanh;
import Models.NhanVien;
import Models.PhongBan;
import Repositories.IRepository.INhanVienRepository;
import Repositories.IRepository.IPhongBanRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVienRepository implements INhanVienRepository {

    private  IDbContext _dbContext;

    public NhanVienRepository() {
        _dbContext = new DbContext();
    }
    @Override
    public void Dispose() {
        _dbContext.closeConnection();
    }

    @Override
    public boolean insert(NhanVien model) {
        String sqlInsertString = String.format("INSERT INTO NhanVien (HoTen, NgaySinh, GioiTinh, Luong, MaPhongBan) " +
                "VALUES ('%s', '%s', '%s', '%.3f', '%d');", model.getHoTen(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgaySinh()),
                model.getGioiTinh(), model.getLuong(), model.getMaPhongBan());
        return  _dbContext.insertRecord(sqlInsertString);
    }

    @Override
    public NhanVien findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM NhanVien WHERE MaNhanVien = %d;", id);
            var result = _dbContext.selectRecords(sqlInsertString);
            if(result.next()) {
                return  Convert(result);
            }
            else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<NhanVien> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM NhanVien;";
            var result = _dbContext.selectRecords(sqlInsertString);
            List<NhanVien> nhanViens = new ArrayList<NhanVien>();
            while (result.next()) {
                 nhanViens.add(Convert(result));
            }
            return nhanViens;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(NhanVien model) {
        String sqlInsertString = String.format("UPDATE NhanVien SET HoTen = '%s', " +
                        "NgaySinh = '%s', " +
                        "GioiTinh = '%s', " +
                        "Luong = %.3f, " +
                        "MaPhongBan = %d " +
                        "WHERE MaNhanVien = %d;", model.getHoTen(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgaySinh()),
                model.getGioiTinh(),
                model.getLuong(),
                model.getMaPhongBan(),
                model.getMaNhanVien()
        );
        return _dbContext.updateRecord(sqlInsertString);
    }
    @Override
    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM NhanVien WHERE MaNhanVien = %d;",id
        );
        return _dbContext.deleteRecord(sqlInsertString);
    }
    @Override
    public NhanVien Convert(ResultSet module) {
        try {
            int maNhanVien = module.getInt(1);
            String HoTen = module.getString(2);
            Date ngaySinh = module.getDate(3);
            String gioiTinh = module.getString(4);
            double luong = module.getDouble(5);
            int maPhongBan = module.getInt(6);
            return new NhanVien(maNhanVien, HoTen, ngaySinh, gioiTinh, luong, maPhongBan);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
