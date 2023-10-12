package Repositories.Repository;

import Database.DbContext;
import Database.IDbContext;
import Models.ChiNhanh;
import Repositories.IDisposable.IDisposable;
import Repositories.IRepository.IChiNhanhRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiNhanhRepository implements IChiNhanhRepository {

    private IDbContext _dbcontext;

    public ChiNhanhRepository() {
        _dbcontext = new DbContext();
    }
    @Override
    public boolean insert(ChiNhanh model) {
        String sqlInsertString = String.format("INSERT INTO ChiNhanh (TenChiNhanh, DiaChi) VALUES " +
                "('%s', '%s');", model.getTenChiNhanh(), model.getDiaChi());
         return  _dbcontext.insertRecord(sqlInsertString);
    }
    @Override
    public ChiNhanh findById(int id) {
        try {
            String sqlInsertString = String.format("SELECT * FROM ChiNhanh WHERE MaChiNhanh = %d;", id);
            var result = _dbcontext.selectRecords(sqlInsertString);
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
    public List<ChiNhanh> findAll() {
        try {
            String sqlInsertString = "SELECT * FROM ChiNhanh;";
            ResultSet result = _dbcontext.selectRecords(sqlInsertString);
            List<ChiNhanh> chiNhanhs = new ArrayList<ChiNhanh>();
            while (result.next()) {
                chiNhanhs.add(Convert(result));
            }
            return  chiNhanhs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(ChiNhanh model) {
            String sqlInsertString = String.format("UPDATE ChiNhanh SET TenChiNhanh = '%s', " +
                            "DiaChi = '%s' WHERE MaChiNhanh = %d;",
                    model.getTenChiNhanh(),
                    model.getDiaChi(), model.getMaChiNhanh());
            return _dbcontext.updateRecord(sqlInsertString);
    }

    @Override
    public boolean delete(int id) {
        String sqlInsertString = String.format("DELETE FROM ChiNhanh WHERE MaChiNhanh = %d;",id
               );
        return _dbcontext.deleteRecord(sqlInsertString);
    }

    @Override
    public ChiNhanh Convert(ResultSet module) {
        try {
            int maChiNhanh = module.getInt(1);
            String TenChiNhanh = module.getString(2);
            String diaChi = module.getString(3);
            return new ChiNhanh(maChiNhanh, TenChiNhanh, diaChi);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    @Override
    public void Dispose() {
        _dbcontext.closeConnection();
    }
}
