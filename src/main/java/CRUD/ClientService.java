package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final String url = "jdbc:postgresql://localhost:5437/postgres";
    private final String user = "postgres";
    private final String password = "password";

    public long create(String name) {
        validateName(name);
        String sql = "INSERT INTO client (name) VALUES (?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("Failed to retrieve client ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating client", e);
        }
    }


    public String getById(long id) {
        String sql = "SELECT name FROM client WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            } else {
                throw new SQLException("Client not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving client", e);
        }
    }


    public void setName(long id, String name) {
        validateName(name);
        String sql = "UPDATE client SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setLong(2, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Client not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating client", e);
        }
    }


    public void deleteById(long id) {
        String sql = "DELETE FROM client WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Client not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting client", e);
        }
    }


    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name FROM client";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                clients.add(new Client(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving clients", e);
        }

        return clients;
    }


    private void validateName(String name) {
        if (name == null || name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Name must be between 2 and 1000 characters long.");
        }
    }
}

