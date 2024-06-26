package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5437/goit-lesson-db";
    private String username = "postgres";
    private String password = "password";

    private Database() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
    }
}
