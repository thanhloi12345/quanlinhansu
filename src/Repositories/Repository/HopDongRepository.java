package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.HopDong;
import Repositories.IRepository.IHopDongRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HopDongRepository implements IHopDongRepository {
    private IDbContext _dbContext;
    public HopDongRepository() {
        _dbContext = new DbContext();
    }
    @Override
    public void Dispose() {
        _dbContext.closeConnection();
    }
    @Override
    public boolean insert(HopDong model) {
        String sqlInsertString = String.format("INSERT INTO HopDong (MaNhanVien, NgayKy, LoaiHopDong) " +
                        "VALUES (%d, '%s', '%s');", model.getMaNhanVien(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgayKy()),
                model.getLoaiHopDong());
        return _dbContext.insertRecord(sqlInsertString);
    }

    @Override
    public HopDong findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM HopDong WHERE MaHopDong = %d;", id);
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
    public List<HopDong> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM HopDong;";
            var result = _dbContext.selectRecords(sqlInsertString);
            List<HopDong> hopDongs = new ArrayList<>();
            while (result.next()) {
                hopDongs.add(Convert(result));
            }
            return hopDongs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(HopDong model) {
        String sqlInsertString = String.format("UPDATE HopDong SET MaNhanVien = %d, " +
                        "NgayKy = '%s', " +
                        "LoaiHopDong = '%s' " +
                        "WHERE MaHopDong = %d;", model.getMaNhanVien(),
                new SimpleDateFormat("yyyy-MM-dd").format(model.getNgayKy()),
                model.getLoaiHopDong(),
                model.getMaHopDong()
        );
        return _dbContext.updateRecord(sqlInsertString);
    }

    @Override
    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM HopDong WHERE MaHopDong = %d;", id);
        return _dbContext.deleteRecord(sqlInsertString);
    }

    @Override
    public HopDong Convert(ResultSet module) {
        try {
            int maHopDong = module.getInt(1);
            int maNhanVien = module.getInt(2);
            Date ngayKy = module.getDate(3);
            String loaiHopDong = module.getString(4);
            return new HopDong(maHopDong, maNhanVien, ngayKy, loaiHopDong);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
