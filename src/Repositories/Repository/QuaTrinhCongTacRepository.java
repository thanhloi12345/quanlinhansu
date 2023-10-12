package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.QuaTrinhCongTac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuaTrinhCongTacRepository {

    private IDbContext _dbContext;

    public QuaTrinhCongTacRepository() {
        _dbContext = new DbContext();
    }

    public void Dispose() {
        _dbContext.closeConnection();
    }

    public boolean insert(QuaTrinhCongTac model) {
        String sqlInsertString = String.format("INSERT INTO QuaTrinhCongTac (MaNhanVien, ThoiGianBatDau, ThoiGianKetThuc, MoTaCongViec) " +
                        "VALUES (%d, '%s', %s, '%s');", model.getMaNhanVien(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getThoiGianBatDau()),
                model.getThoiGianKetThuc() != null ? "'" + new SimpleDateFormat("yyyy-MM-dd").format(model.getThoiGianKetThuc()) + "'" : "NULL",
                model.getMoTaCongViec());
        return _dbContext.insertRecord(sqlInsertString);
    }

    public QuaTrinhCongTac findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM QuaTrinhCongTac WHERE MaQuaTrinh = %d;", id);
            var result = _dbContext.selectRecords(sqlInsertString);
            if (result.next()) {
                return Convert(result);
            } else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<QuaTrinhCongTac> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM QuaTrinhCongTac;";
            var result = _dbContext.selectRecords(sqlInsertString);
            List<QuaTrinhCongTac> quaTrinhCongTacs = new ArrayList<QuaTrinhCongTac>();
            while (result.next()) {
                quaTrinhCongTacs.add(Convert(result));
            }
            return quaTrinhCongTacs;
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public boolean update(QuaTrinhCongTac model) {
        String sqlInsertString = String.format("UPDATE QuaTrinhCongTac SET MaNhanVien = %d, " +
                        "ThoiGianBatDau = '%s', " +
                        "ThoiGianKetThuc = %s, " +
                        "MoTaCongViec = '%s' " +
                        "WHERE MaQuaTrinh = %d;", model.getMaNhanVien(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getThoiGianBatDau()),
                model.getThoiGianKetThuc() != null ? "'" + new SimpleDateFormat("yyyy-MM-dd").format(model.getThoiGianKetThuc()) + "'" : "NULL",
                model.getMoTaCongViec(),
                model.getMaQuaTrinh());
        return _dbContext.updateRecord(sqlInsertString);
    }

    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM QuaTrinhCongTac WHERE MaQuaTrinh = %d;", id);
        return _dbContext.deleteRecord(sqlInsertString);
    }

    public QuaTrinhCongTac Convert(ResultSet module) {
        try {
            int maQuaTrinh = module.getInt("MaQuaTrinh");
            int maNhanVien = module.getInt("MaNhanVien");
            Date thoiGianBatDau = module.getDate("ThoiGianBatDau");
            Date thoiGianKetThuc = module.getDate("ThoiGianKetThuc");
            String moTaCongViec = module.getString("MoTaCongViec");
            return new QuaTrinhCongTac(maQuaTrinh, maNhanVien, thoiGianBatDau, thoiGianKetThuc, moTaCongViec);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
