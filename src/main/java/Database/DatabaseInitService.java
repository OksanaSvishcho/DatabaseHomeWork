package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        String filePath = "sql/init_db.sql";
        try (Connection connection = Database.getInstance().getConnection()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                StringBuilder sql = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sql.append(line).append("\n");
                }
                try (Statement stmt = connection.createStatement()) {
                    stmt.execute(sql.toString());
                    System.out.println("Database initialized successfully.");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
