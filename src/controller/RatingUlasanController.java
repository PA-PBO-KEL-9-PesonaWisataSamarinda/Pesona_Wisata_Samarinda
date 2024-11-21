package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DatabaseModel;
import model.RatingUlasanModel;

public class RatingUlasanController {
    private JTable tableRatingUlasan;
    
    public RatingUlasanController (JTable tableRatingUlasan){
        this.tableRatingUlasan = tableRatingUlasan;
    }

    public boolean createRatingUlasan(String namaDestinasi, int rating, String ulasan, int id_user) {
        String getIdQuery = "SELECT id_destinasi FROM destinasi WHERE nama_destinasi = ?";
        String insertQuery = "INSERT INTO rating_dan_ulasan (DESTINASI_id_destinasi, rating, ulasan, tanggal_rating_ulasan, PENGUNJUNG_id_user) " +
                             "VALUES (?, ?, ?, NOW(), ?)";
    
        try (Connection connection = DatabaseModel.connect()) {
            int id_destinasi = -1;
            try (PreparedStatement getIdStmt = connection.prepareStatement(getIdQuery)) {
                getIdStmt.setString(1, namaDestinasi);
                ResultSet rs = getIdStmt.executeQuery();
                if (rs.next()) {
                    id_destinasi = rs.getInt("id_destinasi");
                } else {
                    JOptionPane.showMessageDialog(null, "Destinasi tidak ditemukan.");
                    return false;
                }
            }

            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, id_destinasi);
                insertStmt.setInt(2, rating);
                insertStmt.setString(3, ulasan);
                insertStmt.setInt(4, id_user);

                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    UserController.updateJumlahReview(); // Update jumlah review setelah ulasan berhasil disimpan
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } return false;
    }

    
    
    public static List<RatingUlasanModel> readAllRatingUlasan() {
        List<RatingUlasanModel> ratingList = new ArrayList<>();
        String query = "SELECT d.nama_destinasi, r.rating, r.ulasan, r.tanggal_rating_ulasan " +
                       "FROM destinasi d " +
                       "JOIN rating_dan_ulasan r ON d.id_destinasi = d.id_destinasi";
        
        try (Connection conn = DatabaseModel.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idRatingUlasan = rs.getInt("id_rating_ulasan");
                int rating = rs.getInt("rating");
                String ulasan = rs.getString("ulasan");
                Date tanggalRatingUlasan = rs.getDate("tanggal_rating_ulasan");
                
                ratingList.add(new RatingUlasanModel(idRatingUlasan, rating, ulasan, tanggalRatingUlasan));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratingList;
    }
    
    public static void loadUlasanToTable(JTable tableRatingUlasan, String namaDestinasi) {
        if (tableRatingUlasan == null) {
           JOptionPane.showMessageDialog(null, "Tabel belum diinisialisasi");
           return;
       }

       DefaultTableModel model = (DefaultTableModel) tableRatingUlasan.getModel();
       model.setRowCount(0);

       String query = "SELECT d.nama_destinasi, r.rating, r.ulasan, r.tanggal_rating_ulasan " +
                      "FROM destinasi d " +
                      "INNER JOIN rating_dan_ulasan r ON d.id_destinasi = d.id_destinasi " +
                      "WHERE d.nama_destinasi = ?";

       try (Connection connection = DatabaseModel.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

           preparedStatement.setString(1, namaDestinasi);
           ResultSet resultSet = preparedStatement.executeQuery();

           boolean hasData = false;
           while (resultSet.next()) {
               hasData = true;
               String nama = resultSet.getString("nama_destinasi");
               int rating = resultSet.getInt("rating");
               String ulasan = resultSet.getString("ulasan");
               Date tanggal = resultSet.getDate("tanggal_rating_ulasan");

               model.addRow(new Object[]{nama, rating, ulasan, tanggal});
           }

           if (!hasData) {
               JOptionPane.showMessageDialog(null, "Tidak ada ulasan untuk destinasi ini.");
           }

       } catch (SQLException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
       }
    }  
}
