package Database;
import java.sql.Connection;
import java.sql.ResultSet;

public interface IDbContext {
    boolean insertRecord(String sql);
    ResultSet selectRecords(String sql);
    boolean updateRecord(String sql);
    boolean deleteRecord(String sql);
    void closeConnection();
}
