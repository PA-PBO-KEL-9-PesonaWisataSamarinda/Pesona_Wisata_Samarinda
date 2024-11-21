package view;

import javax.swing.table.DefaultTableModel;
import controller.DestinasiController;
import model.DatabaseModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.KeyEvent;


public class MenuAdmin extends javax.swing.JFrame {
    DefaultTableModel model;
        private String namaDestinasi;
        private String jamOperasional;
        private String deskripsi;
        private String lokasi;
        private String fasilitas;
        private int biayaMasuk;
    private DefaultTableModel tableModel;
    private final JTable tableDestinasi;

    public MenuAdmin() {
        initComponents();
        tableDestinasi = new javax.swing.JTable();
        table();
        
        DestinasiController crudController = new DestinasiController(jTableDataWisata); 
        crudController.read();
        
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        void table(){
        tableModel = new DefaultTableModel();
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
            }
        } catch (Exception e) {
        }
      }  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        inputFasilitas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputJamOperasional = new javax.swing.JTextField();
        inputLokasi = new javax.swing.JTextField();
        inputNamaDestinasi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputBiayaMasuk = new javax.swing.JTextField();
        inputDeskripsi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDataWisata = new javax.swing.JTable();
        jToggleButtonKembali = new javax.swing.JToggleButton();
        jToggleButtonSegarkanData = new javax.swing.JToggleButton();
        jToggleButtonEdit = new javax.swing.JToggleButton();
        jToggleButtonHapus = new javax.swing.JToggleButton();
        jToggleButtonTambahDestinasi = new javax.swing.JToggleButton();
        BackgroundMenuAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Fasilitas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));
        getContentPane().add(inputFasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 330, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nama Destinasi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Jam Operasional");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        getContentPane().add(inputJamOperasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 330, 30));
        getContentPane().add(inputLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 330, 30));

        inputNamaDestinasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaDestinasiActionPerformed(evt);
            }
        });
        getContentPane().add(inputNamaDestinasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 330, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Deskripsi");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        getContentPane().add(inputBiayaMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 330, 30));

        inputDeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDeskripsiActionPerformed(evt);
            }
        });
        getContentPane().add(inputDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 330, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Biaya Masuk");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Lokasi");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jTableDataWisata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Destinasi", "Jam Operasional", "Deskripsi", "Lokasi", "Fasilitas", "HTM"
            }
        ));
        jTableDataWisata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataWisataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDataWisata);
        if (jTableDataWisata.getColumnModel().getColumnCount() > 0) {
            jTableDataWisata.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableDataWisata.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 700, 130));

        jToggleButtonKembali.setBackground(new java.awt.Color(50, 81, 118));
        jToggleButtonKembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonKembali.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonKembali.setText("Kembali");
        jToggleButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 120, -1));

        jToggleButtonSegarkanData.setBackground(new java.awt.Color(249, 222, 181));
        jToggleButtonSegarkanData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonSegarkanData.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonSegarkanData.setText("Segarkan Data");
        jToggleButtonSegarkanData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSegarkanDataActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonSegarkanData, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 120, -1));

        jToggleButtonEdit.setBackground(new java.awt.Color(249, 222, 181));
        jToggleButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonEdit.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonEdit.setText("Edit");
        jToggleButtonEdit.setToolTipText("");
        jToggleButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEditActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 140, -1));

        jToggleButtonHapus.setBackground(new java.awt.Color(249, 222, 181));
        jToggleButtonHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonHapus.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonHapus.setText("Hapus");
        jToggleButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonHapusActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 140, -1));

        jToggleButtonTambahDestinasi.setBackground(new java.awt.Color(249, 222, 181));
        jToggleButtonTambahDestinasi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonTambahDestinasi.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonTambahDestinasi.setText("Tambah Destinasi");
        jToggleButtonTambahDestinasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonTambahDestinasiActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonTambahDestinasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 140, -1));

        BackgroundMenuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BackgroundDefault.png"))); // NOI18N
        BackgroundMenuAdmin.setText("jLabel1");
        getContentPane().add(BackgroundMenuAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonKembaliActionPerformed
        HomeAdmin homeadmin = new HomeAdmin ();
        homeadmin.setVisible(true);
        MenuAdmin.this.dispose();
    }//GEN-LAST:event_jToggleButtonKembaliActionPerformed

    private void jToggleButtonTambahDestinasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonTambahDestinasiActionPerformed
        String namaDestinasi = inputNamaDestinasi.getText().trim();

        for (int i = 0; i < jTableDataWisata.getRowCount(); i++) {
            String existingNamaDestinasi = jTableDataWisata.getValueAt(i, 0).toString();
            if (namaDestinasi.equalsIgnoreCase(existingNamaDestinasi)) {
                JOptionPane.showMessageDialog(null, 
                    "Data destinasi sudah ada! Tidak dapat menambahkan duplikat.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        DestinasiController tambahData = new DestinasiController(
            inputNamaDestinasi,
            inputJamOperasional,
            inputDeskripsi,
            inputLokasi,
            inputFasilitas,
            inputBiayaMasuk,
            tableDestinasi
        );
        tambahData.tambah();

        inputNamaDestinasi.setEditable(true);
        inputNamaDestinasi.setText("");
        inputJamOperasional.setText("");
        inputDeskripsi.setText("");
        inputLokasi.setText("");
        inputFasilitas.setText("");
        inputBiayaMasuk.setText("");
    }//GEN-LAST:event_jToggleButtonTambahDestinasiActionPerformed

    private void jToggleButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonHapusActionPerformed
        String namaDestinasi = inputNamaDestinasi.getText().trim();

        if (namaDestinasi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama destinasi tidak boleh kosong!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null, 
            "Apakah Anda yakin ingin menghapus destinasi: " + namaDestinasi + "?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            DestinasiController hapusData = new DestinasiController(tableDestinasi);

            hapusData.hapus(namaDestinasi);

            inputNamaDestinasi.setText("");
            inputJamOperasional.setText("");
            inputDeskripsi.setText("");
            inputLokasi.setText("");
            inputFasilitas.setText("");
            inputBiayaMasuk.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.");
        }
    }//GEN-LAST:event_jToggleButtonHapusActionPerformed

    private void jToggleButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEditActionPerformed
    DestinasiController editData = new DestinasiController(
        inputNamaDestinasi,
        inputJamOperasional,
        inputDeskripsi,
        inputLokasi,
        inputFasilitas,
        inputBiayaMasuk,
        tableDestinasi
    );
    editData.update();

    }//GEN-LAST:event_jToggleButtonEditActionPerformed

    private void jToggleButtonSegarkanDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSegarkanDataActionPerformed
        DestinasiController controller = new DestinasiController(jTableDataWisata);
        controller.refreshData();
        inputNamaDestinasi.setText("");
        inputJamOperasional.setText("");
        inputDeskripsi.setText("");
        inputLokasi.setText("");
        inputFasilitas.setText("");
        inputBiayaMasuk.setText("");

        inputNamaDestinasi.setEditable(true);        

        JOptionPane.showMessageDialog(this, "Data berhasil disegarkan!");   
    }//GEN-LAST:event_jToggleButtonSegarkanDataActionPerformed

    private void inputDeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDeskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDeskripsiActionPerformed

    private void inputNamaDestinasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaDestinasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaDestinasiActionPerformed

    private void jTableDataWisataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataWisataMouseClicked
        int row = jTableDataWisata.getSelectedRow();
        if (row != -1) {
            String namaDestinasi = jTableDataWisata.getValueAt(row, 0).toString();
            String jamOperasional = jTableDataWisata.getValueAt(row, 1).toString();
            String deskripsi = jTableDataWisata.getValueAt(row, 2).toString();
            String lokasi = jTableDataWisata.getValueAt(row, 3).toString();
            String fasilitas = jTableDataWisata.getValueAt(row, 4).toString();

            int biayaMasuk = Integer.parseInt(jTableDataWisata.getValueAt(row, 5).toString());

            inputNamaDestinasi.setText(namaDestinasi);
            inputJamOperasional.setText(jamOperasional);
            inputDeskripsi.setText(deskripsi);
            inputLokasi.setText(lokasi);
            inputFasilitas.setText(fasilitas);

            inputBiayaMasuk.setText(String.valueOf(biayaMasuk));
            inputNamaDestinasi.setEditable(false);
        }
    }//GEN-LAST:event_jTableDataWisataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMenuAdmin;
    private javax.swing.JTextField inputBiayaMasuk;
    private javax.swing.JTextField inputDeskripsi;
    private javax.swing.JTextField inputFasilitas;
    private javax.swing.JTextField inputJamOperasional;
    private javax.swing.JTextField inputLokasi;
    private javax.swing.JTextField inputNamaDestinasi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDataWisata;
    private javax.swing.JToggleButton jToggleButtonEdit;
    private javax.swing.JToggleButton jToggleButtonHapus;
    private javax.swing.JToggleButton jToggleButtonKembali;
    private javax.swing.JToggleButton jToggleButtonSegarkanData;
    private javax.swing.JToggleButton jToggleButtonTambahDestinasi;
    // End of variables declaration//GEN-END:variables

    private void read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}