package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.PhongBan;
import Repositories.IDisposable.IDisposable;
import Repositories.IRepository.IPhongBanRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongBanRepository implements IPhongBanRepository, IDisposable {

    private IDbContext _dbcontext;
    public PhongBanRepository() {
        _dbcontext = new DbContext();
    }
    @Override
    public boolean insert(PhongBan model) {
        String sqlInsertString = String.format("INSERT INTO PhongBan (%s, %d) VALUES ('Phòng ban A', 1);", model.getTenPhongBan(), model.getMaPhongBan());
        return  _dbcontext.insertRecord(sqlInsertString);
    }

    @Override
    public PhongBan findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM PhongBan WHERE MaPhongBan = %d;", id);
            var result = _dbcontext.selectRecords(sqlInsertString);
            if(result.next()) {
                return Convert(result);
            }
            else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<PhongBan> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM PhongBan;";
            var result = _dbcontext.selectRecords(sqlInsertString);
            List<PhongBan> phongBans = new ArrayList<PhongBan>();
            while (result.next()) {
                phongBans.add(Convert(result));
            }
            return  phongBans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(PhongBan model) {
        String sqlInsertString = String.format("UPDATE PhongBan " +
                        "SET TenPhongBan = '%s', MaChiNhanh = %d " +
                        "WHERE MaPhongBan = %d;",
                model.getTenPhongBan(),
                model.getMaChiNhanh(), model.getMaPhongBan());
        return _dbcontext.updateRecord(sqlInsertString);
    }

    @Override
    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM PhongBan WHERE MaPhongBan = %d;",id
        );
        return _dbcontext.deleteRecord(sqlInsertString);
    }
    @Override
    public PhongBan Convert(ResultSet module) {
        try {
            int maPhongBan = module.getInt(1);
            String TenPhongBan = module.getString(2);
            int maChiNhanh = module.getInt(3);
            return new PhongBan(maPhongBan, TenPhongBan, maChiNhanh);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    @Override
    public void Dispose() {
        _dbcontext.closeConnection();
    }
}
