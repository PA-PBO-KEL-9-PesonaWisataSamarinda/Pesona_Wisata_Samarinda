/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controller;

import model.DatabaseModel;
import model.UserModel;
import model.Admin;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DestinasiController {
    private JTable tableDestinasi;
    private JTable table;
    private JTextField inputNamaDestinasi;
    private JTextField inputJamOperasional;
    private JTextField inputDeskripsi;
    private JTextField inputLokasi;
    private JTextField inputFasilitas;
    private JTextField inputBiayaMasuk;

    public DestinasiController(JTable table) {
        if (table == null) {
            throw new IllegalArgumentException("Table tidak boleh null");
        }        
        this.table = table;
    }

    public DestinasiController(JTextField inputNamaDestinasi, JTextField inputJamOperasional, JTextField inputDeskripsi, 
            JTextField inputLokasi, JTextField inputFasilitas, JTextField inputBiayaMasuk, JTable tableDestinasi) {
        this.inputNamaDestinasi = inputNamaDestinasi;
        this.inputJamOperasional = inputJamOperasional;
        this.inputDeskripsi = inputDeskripsi;
        this.inputLokasi = inputLokasi;
        this.inputFasilitas = inputFasilitas;
        this.inputBiayaMasuk = inputBiayaMasuk;
        this.tableDestinasi = tableDestinasi;
    }

    public JTextField getNamaDestinasi() {
        return inputNamaDestinasi;
    }

    public JTextField getJamOperasional() {
        return inputJamOperasional;
    }

    public JTextField getDeskripsi() {
        return inputDeskripsi;
    }

    public JTextField getLokasi() {
        return inputLokasi;
    }

    public JTextField getFasilitas() {
        return inputFasilitas;
    }

    public JTextField getBiayaMasuk() {
        return inputBiayaMasuk;
    }
    
    public DestinasiController(String namaDestinasi, String jamOperasional, String deskripsi, String lokasi, String fasilitas, int biayaMasuk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean validateNamaDestinasi() {
        if (inputNamaDestinasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama destinasi tidak boleh kosong!");
            return false;
        }
        return true;
    }

    public void loadDataToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseModel.connect()) {
            String query = "SELECT * FROM destinasi";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String namaDestinasi = resultSet.getString("nama_Destinasi");
                    String jamOperasional = resultSet.getString("jam_Operasional");
                    String deskripsi = resultSet.getString("deskripsi");
                    String lokasi = resultSet.getString("lokasi");
                    String fasilitas = resultSet.getString("fasilitas");
                    int biayaMasuk = resultSet.getInt("biaya_masuk");

                    model.addRow(new Object[]{namaDestinasi, jamOperasional, deskripsi, lokasi, fasilitas, biayaMasuk});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan: " + e.getMessage());
        }
    }

    public void tambah() {
        if (!validateNamaDestinasi()) return;

        try (Connection connection = DatabaseModel.connect()) {
            String query = "INSERT INTO destinasi (nama_Destinasi, jam_Operasional, deskripsi, lokasi, fasilitas, biaya_masuk, ADMIN_id_user) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, inputNamaDestinasi.getText());
                preparedStatement.setString(2, inputJamOperasional.getText());
                preparedStatement.setString(3, inputDeskripsi.getText());
                preparedStatement.setString(4, inputLokasi.getText());
                preparedStatement.setString(5, inputFasilitas.getText());

                try {
                    int biayaMasuk = Integer.parseInt(inputBiayaMasuk.getText());
                    preparedStatement.setInt(6, biayaMasuk);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Biaya masuk harus berupa angka.");
                    return;
                }
                
                UserModel currentUser = UserController.getCurrentUser();
                if (currentUser == null || !(currentUser instanceof Admin)) {
                    JOptionPane.showMessageDialog(null, "Hanya admin yang dapat menambahkan destinasi!");
                    return;
                }
                
                preparedStatement.setInt(7, currentUser.getId_user()); // ID admin
                
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data destinasi berhasil ditambahkan!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan: " + e.getMessage());
        }
    }

    public void update() {
        if (!validateNamaDestinasi()) return;

        try (Connection connection = DatabaseModel.connect()) {
            String query = "UPDATE destinasi SET jam_Operasional = ?, deskripsi = ?, lokasi = ?, fasilitas = ?, biaya_masuk = ? WHERE nama_Destinasi = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, inputJamOperasional.getText());
                preparedStatement.setString(2, inputDeskripsi.getText());
                preparedStatement.setString(3, inputLokasi.getText());
                preparedStatement.setString(4, inputFasilitas.getText());

                try {
                    int biayaMasuk = Integer.parseInt(inputBiayaMasuk.getText());
                    preparedStatement.setInt(5, biayaMasuk);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Biaya masuk harus berupa angka.");
                    return;
                }

                preparedStatement.setString(6, inputNamaDestinasi.getText());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan: " + e.getMessage());
        }
    }

    public void hapus(String namaDestinasi) {
        if (namaDestinasi == null || namaDestinasi.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama destinasi tidak boleh kosong!");
            return;
        }

        try (Connection connection = DatabaseModel.connect()) {
            String query = "DELETE FROM destinasi WHERE nama_Destinasi = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, namaDestinasi);
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan: " + e.getMessage());
        }
    }

    public void read() {
        if (this.table == null) {
            JOptionPane.showMessageDialog(null, "Tabel belum diinisialisasi!");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseModel.connect()) {
            String query = "SELECT * FROM destinasi";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String namaDestinasi = resultSet.getString("nama_Destinasi");
                    String jamOperasional = resultSet.getString("jam_Operasional");
                    String deskripsi = resultSet.getString("deskripsi");
                    String lokasi = resultSet.getString("lokasi");
                    String fasilitas = resultSet.getString("fasilitas");
                    int biayaMasuk = resultSet.getInt("biaya_masuk");

                    model.addRow(new Object[]{namaDestinasi, jamOperasional, deskripsi, lokasi, fasilitas, biayaMasuk});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan: " + e.getMessage());
        }
    }
    
    public String getSelectedNamaDestinasi() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih destinasi terlebih dahulu!");
            return null;
        }
        return table.getValueAt(selectedRow, 0).toString();
    }
    
    public void refreshData() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection connection = DatabaseModel.connect();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM destinasi")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String namaDestinasi = rs.getString("nama_destinasi");
                String jamOperasional = rs.getString("jam_operasional");
                String deskripsi = rs.getString("deskripsi");
                String lokasi = rs.getString("lokasi");
                String fasilitas = rs.getString("fasilitas");
                int biayaMasuk = rs.getInt("biaya_masuk");

                model.addRow(new Object[]{namaDestinasi, jamOperasional, deskripsi, lokasi, fasilitas, biayaMasuk});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat memuat data");
        }
    }
    
    public static ArrayList<Object[]> cariDestinasiWisata(String namaDestinasi) throws SQLException {
        ArrayList<Object[]> destinasiList = new ArrayList<>();
        Connection conn = DatabaseModel.connect();
        String query = "SELECT * FROM Destinasi WHERE nama_destinasi LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, "%" + namaDestinasi + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            destinasiList.add(new Object[]{
                rs.getString("nama_destinasi"),
                rs.getString("lokasi"),
                rs.getString("jam_operasional"),
                rs.getString("deskripsi"),
                rs.getString("fasilitas"),
                rs.getDouble("biaya_masuk")
            });
        }

        rs.close();
        stmt.close();
        conn.close();
        return destinasiList;
    }
    
    public static void searching() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static ArrayList<Object[]> sortDestinasi(String sortBy) throws SQLException {
        ArrayList<Object[]> destinasiList = new ArrayList<>();
        Connection conn = DatabaseModel.connect();

        try {
            String query = switch (sortBy) {
                case "Wisata Berdasarkan Harga Tertinggi" -> "SELECT * FROM destinasi ORDER BY biaya_masuk DESC";
                case "Wisata Berdasarkan Harga Terendah" -> "SELECT * FROM destinasi ORDER BY biaya_masuk ASC";
                case "Wisata Berdasarkan Abjad A-Z" -> "SELECT * FROM destinasi ORDER BY nama_destinasi ASC";
                default -> throw new IllegalArgumentException("Pilihan sorting tidak valid!");
            };

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                destinasiList.add(new Object[]{
                    rs.getString("nama_destinasi"),
                    rs.getString("jam_operasional"),
                    rs.getString("deskripsi"),
                    rs.getString("lokasi"),
                    rs.getString("fasilitas"),
                    rs.getDouble("biaya_masuk")
                });
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Terjadi kesalahan saat melakukan sorting: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return destinasiList;
    } 
    
}
