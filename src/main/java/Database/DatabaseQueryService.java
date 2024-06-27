package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String filePath = "sql/find_max_projects_client.sql";
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            try (PreparedStatement pstmt = connection.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MaxProjectCountClient client = new MaxProjectCountClient();
                    client.setName(rs.getString("name"));
                    client.setProjectCount(rs.getInt("project_count"));
                    result.add(client);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String filePath = "sql/find_max_salary_worker.sql";
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            try (PreparedStatement pstmt = connection.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MaxSalaryWorker worker = new MaxSalaryWorker();
                    worker.setName(rs.getString("name"));
                    worker.setSalary(rs.getInt("salary"));
                    result.add(worker);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String filePath = "sql/find_longest_project.sql";
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            try (PreparedStatement pstmt = connection.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LongestProject project = new LongestProject();
                    project.setName(rs.getString("name"));
                    project.setDuration(rs.getInt("duration"));
                    result.add(project);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        String filePath = "sql/find_youngest_eldest_workers.sql";
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            try (PreparedStatement pstmt = connection.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    YoungestEldestWorkers worker = new YoungestEldestWorkers();
                    worker.setType(rs.getString("type"));
                    worker.setName(rs.getString("name"));
                    worker.setBirthday(rs.getString("birthday"));
                    result.add(worker);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        String filePath = "sql/print_project_prices.sql";
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
            try (PreparedStatement pstmt = connection.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ProjectPrice projectPrice = new ProjectPrice();
                    projectPrice.setProjectName(rs.getString("project_name"));
                    projectPrice.setPrice(rs.getDouble("price"));
                    result.add(projectPrice);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
