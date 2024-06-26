package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String filePath = "sql/find_max_projects_client.sql";
        try (Connection connection = Database.getInstance().getConnection()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                StringBuilder sql = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sql.append(line).append("\n");
                }
                try (Statement stmt = connection.createStatement();
                     ResultSet rs = stmt.executeQuery(sql.toString())) {
                    while (rs.next()) {
                        MaxProjectCountClient client = new MaxProjectCountClient();
                        client.setName(rs.getString("name"));
                        client.setProjectCount(rs.getInt("project_count"));
                        result.add(client);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
