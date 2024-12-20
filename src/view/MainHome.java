package view;
import java.awt.event.KeyEvent;


public class MainHome extends javax.swing.JFrame {

    public MainHome() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButtonMasuk = new javax.swing.JToggleButton();
        jToggleButtonRegistrasi = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BackgroundMainHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonMasuk.setBackground(new java.awt.Color(50, 81, 118));
        jToggleButtonMasuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonMasuk.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonMasuk.setText("Masuk");
        jToggleButtonMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonMasukActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 140, 30));

        jToggleButtonRegistrasi.setBackground(new java.awt.Color(50, 81, 118));
        jToggleButtonRegistrasi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonRegistrasi.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonRegistrasi.setText("Registrasi");
        jToggleButtonRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRegistrasiActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonRegistrasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 140, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 222, 181));
        jLabel2.setText("Teras Samarinda");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 222, 181));
        jLabel3.setText("Taman Samarendah");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(249, 222, 181));
        jLabel4.setText("Masjid Islamic Center");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        BackgroundMainHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BackgroundHome.png"))); // NOI18N
        getContentPane().add(BackgroundMainHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRegistrasiActionPerformed
        Registrasi registrasi = new Registrasi();
        registrasi.setVisible(true);
        MainHome.this.dispose();
        
    }//GEN-LAST:event_jToggleButtonRegistrasiActionPerformed

    private void jToggleButtonMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonMasukActionPerformed
        Login login = new Login();
        login.setVisible(true);
        MainHome.this.dispose();
    }//GEN-LAST:event_jToggleButtonMasukActionPerformed

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
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainHome().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMainHome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButtonMasuk;
    private javax.swing.JToggleButton jToggleButtonRegistrasi;
    // End of variables declaration//GEN-END:variables
}
