package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.QuyetDinh;
import Repositories.IRepository.IQuyetDinhRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuyetDinhRepository implements IQuyetDinhRepository {

    private IDbContext _dbContext;

    public QuyetDinhRepository() {
        _dbContext = new DbContext();
    }

    @Override
    public void Dispose() {
        _dbContext.closeConnection();
    }

    @Override
    public boolean insert(QuyetDinh model) {
        String sqlInsertString = String.format("INSERT INTO QuyetDinh (MaNhanVien, LoaiQuyetDinh, NgayQuyetDinh) " +
                        "VALUES (%d, '%s', '%s');", model.getMaNhanVien(),
                model.getLoaiQuyetDinh(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgayQuyetDinh()));
        return _dbContext.insertRecord(sqlInsertString);
    }

    @Override
    public QuyetDinh findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM QuyetDinh WHERE MaQuyetDinh = %d;", id);
            var result = _dbContext.selectRecords(sqlInsertString);
            if (result.next()) {
                return Convert(result);
            } else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuyetDinh> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM QuyetDinh;";
            var result = _dbContext.selectRecords(sqlInsertString);
            List<QuyetDinh> quyetDinhs = new ArrayList<>();
            while (result.next()) {
                quyetDinhs.add(Convert(result));
            }
            return quyetDinhs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(QuyetDinh model) {
        String sqlInsertString = String.format("UPDATE QuyetDinh SET MaNhanVien = %d, " +
                        "LoaiQuyetDinh = '%s', " +
                        "NgayQuyetDinh = '%s' " +
                        "WHERE MaQuyetDinh = %d;", model.getMaNhanVien(),
                model.getLoaiQuyetDinh(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgayQuyetDinh()),
                model.getMaQuyetDinh()
        );
        return _dbContext.updateRecord(sqlInsertString);
    }

    @Override
    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM QuyetDinh WHERE MaQuyetDinh = %d;", id);
        return _dbContext.deleteRecord(sqlInsertString);
    }

    @Override
    public QuyetDinh Convert(ResultSet module) {
        try {
            int maQuyetDinh = module.getInt(1);
            int maNhanVien = module.getInt(2);
            String loaiQuyetDinh = module.getString(3);
            Date ngayQuyetDinh = module.getDate(4);
            return new QuyetDinh(maQuyetDinh, maNhanVien, loaiQuyetDinh, ngayQuyetDinh);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
