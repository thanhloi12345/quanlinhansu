package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbContext implements IDbContext {

    private static final String url = "jdbc:mysql://localhost:3306/quanlinhansu";
    private static final String username = "root";
    private static final String password = "thanhloi12345";
    private Connection connection;

    public DbContext() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu. Lỗi: " + e.getMessage());
        }
    }

    @Override
    public boolean insertRecord(String sql) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                return statement.executeUpdate(sql) > 0;
            } else {
                System.err.println("Không có kết nối đến cơ sở dữ liệu.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Không thể thêm mới một bản ghi. Lỗi: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ResultSet selectRecords(String sql) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                return statement.executeQuery(sql);
            } else {
                System.err.println("Không có kết nối đến cơ sở dữ liệu.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Không thể lấy ra một bản ghi. Lỗi: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateRecord(String sql) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                return statement.executeUpdate(sql) > 0;
            } else {
                System.err.println("Không có kết nối đến cơ sở dữ liệu.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Không thể update một bản ghi. Lỗi: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRecord(String sql) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                return statement.executeUpdate(sql) > 0;
            } else {
                System.err.println("Không có kết nối đến cơ sở dữ liệu.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Không thể xóa một bản ghi. Lỗi: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            } else {
                System.err.println("Không có kết nối đến cơ sở dữ liệu để đóng.");
            }
        } catch (SQLException e) {
            System.err.println("Không thể đóng cổng. Lỗi: " + e.getMessage());
        }
    }
}

