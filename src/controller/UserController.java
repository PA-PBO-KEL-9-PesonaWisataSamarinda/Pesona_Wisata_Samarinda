package controller;

import model.DatabaseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.UserModel;
import model.Admin;
import model.Pengunjung;

public class UserController {
    private static UserModel currentUser;
    
    public static UserModel getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }

    public static void clearSession() {
        currentUser = null;
    }
    
    public static boolean registerPengunjung(String username, String password, String email, String no_telepon) {
        Connection conn = null;
        PreparedStatement stmtUser = null;
        PreparedStatement stmtPengunjung = null;
        
        String queryUser = "INSERT INTO user (username, password, no_telepon, email) VALUES (?, ?, ?, ?)";
        String queryPengunjung = "INSERT INTO pengunjung (id_user, jumlah_review) VALUES (?, 0)";
        
        try {
        conn = DatabaseModel.connect();
        conn.setAutoCommit(false);

        stmtUser = conn.prepareStatement(queryUser, stmtUser.RETURN_GENERATED_KEYS);
        stmtUser.setString(1, username);
        stmtUser.setString(2, password);
        stmtUser.setString(4, email);
        stmtUser.setString(3, no_telepon);
        stmtUser.executeUpdate();

        ResultSet generatedKeys = stmtUser.getGeneratedKeys();
        int id_user = 0;
        if (generatedKeys.next()) {
            id_user = generatedKeys.getInt(1);
        } else {
            throw new SQLException("Gagal mendapatkan id_user.");
        }

        stmtPengunjung = conn.prepareStatement(queryPengunjung);
        stmtPengunjung.setInt(1, id_user);
        stmtPengunjung.executeUpdate();

        conn.commit();
        return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            return false;
        }
    }
    
    public static UserModel login(String username, String password) {
        UserModel user = null;

        String sqlSupertype = "SELECT * FROM user WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseModel.connect();
            PreparedStatement stmt = conn.prepareStatement(sqlSupertype)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_user = rs.getInt("id_user");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String no_telepon = rs.getString("no_telepon");

                if ("admin".equalsIgnoreCase(role)) {
                    user = getAdminById(conn, id_user, username, password, email, no_telepon, role);
                } else if ("pengunjung".equalsIgnoreCase(role)) {
                    user = getPengunjungById(conn, id_user, username, password, email, no_telepon, role);
                }
                
                setCurrentUser(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    private static Admin getAdminById(Connection conn, int id_user, String username, String password, String email, String no_telepon, String role) throws SQLException {
        String sql = "SELECT * FROM admin WHERE id_user = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_user);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                return new Admin(id_user, username, password, email, no_telepon, role, status);
            }
        }
        return null;
    }
    
    private static Pengunjung getPengunjungById(Connection conn, int id_user, String username, String password, String email, String no_telepon, String role) throws SQLException {
        String sql = "SELECT * FROM pengunjung WHERE id_user = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_user);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int jumlah_review = rs.getInt("jumlah_review"); // Properti spesifik Pengunjung
                return new Pengunjung(id_user, username, password, email, no_telepon, role, jumlah_review);
            }
        }
        return null;
    }
    
    public static void updateJumlahReview() {
        String query = "UPDATE pengunjung p " +
                       "JOIN ( " +
                       "    SELECT PENGUNJUNG_id_user AS id_user, COUNT(*) AS total_review " +
                       "    FROM rating_dan_ulasan " +
                       "    GROUP BY PENGUNJUNG_id_user " +
                       ") r ON p.id_user = r.id_user " +
                       "SET p.jumlah_review = r.total_review";

        try (Connection conn = DatabaseModel.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }

}
