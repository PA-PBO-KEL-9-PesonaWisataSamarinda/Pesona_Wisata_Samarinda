package model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableModel {
    DefaultTableModel model;
    private String namaDestinasi;
    private String jamOperasional;
    private String deskripsi;
    private String lokasi;
    private String fasilitas;
    private int biayaMasuk;
    private DefaultTableModel tableModel;
    private final JTable tableDestinasi = null;

      void table(){
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"ID Destinasi", "Nama Destinasi", "Jam Operasional", "Deskripsi", "Lokasi", "Fasilitas", "HTM"}, 0);
        tableModel.setRowCount(0);
        tableModel.addColumn("Nama_Destinasi");
        tableModel.addColumn("Jam_operasional");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Lokasi");
        tableModel.addColumn("Fasilitas");
        tableModel.addColumn("Biaya_Masuk");
        try {
            Statement statement = DatabaseModel.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM nama_destinasi");
            while (resultSet.next()){                
                String namaDestinasi = resultSet.getString("namaDestinasi");
                String jamOperasional = resultSet.getString("jamOperasional");
                String deskripsi = resultSet.getString("deskripsi");
                String lokasi = resultSet.getString("lokasi");
                String fasilitas = resultSet.getString("fasilitas");
                int biayaMasuk = resultSet.getInt("biayaMasuk");
                
                tableModel.addRow(new Object[]{
                     
                    namaDestinasi, 
                    jamOperasional, 
                    deskripsi,
                    lokasi,
                    fasilitas,
                    biayaMasuk});
                tableDestinasi.setModel(tableModel);
                tableDestinasi.getColumnModel().getColumn(0).setMinWidth(0);
                tableDestinasi.getColumnModel().getColumn(0).setMaxWidth(0);
                tableDestinasi.getColumnModel().getColumn(0).setWidth(0);
            }
        } catch (Exception e) {
        }
    } 
}
