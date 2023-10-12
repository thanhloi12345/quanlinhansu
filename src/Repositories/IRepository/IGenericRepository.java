package Repositories.IRepository;

import java.sql.ResultSet;
import java.util.List;

public interface IGenericRepository<T> {
    boolean insert(T model);
    T findById(int id);
    List<T> findAll();
    boolean update(T model);
    boolean delete(int id);
    T Convert(ResultSet module);
}
