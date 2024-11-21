package view;

import controller.UserController;
import javax.swing.JOptionPane;
import model.Admin;
import model.Pengunjung;
import model.UserModel;
import java.awt.event.KeyEvent;

public class Login extends javax.swing.JFrame {

    public Login() {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        jToggleButtonKeluar = new javax.swing.JToggleButton();
        inputPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BackgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonMasuk.setBackground(new java.awt.Color(244, 229, 218));
        jToggleButtonMasuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonMasuk.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonMasuk.setText("Masuk");
        jToggleButtonMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonMasukActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        inputUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(inputUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 320, 30));

        jToggleButtonKeluar.setBackground(new java.awt.Color(244, 229, 218));
        jToggleButtonKeluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButtonKeluar.setForeground(new java.awt.Color(50, 81, 118));
        jToggleButtonKeluar.setText("Keluar");
        jToggleButtonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, 30));
        getContentPane().add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 320, 30));

        jPanel1.setBackground(new java.awt.Color(50, 81, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(244, 229, 218));
        jLabel6.setText("Masukkan username dan password anda!");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 5, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 360, 250));

        BackgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BackgroundDefault.png"))); // NOI18N
        getContentPane().add(BackgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonMasukActionPerformed
        String username = inputUsername.getText();
        String password = inputPassword.getText(); 

        UserModel user = UserController.login(username, password);
        if (user != null) {
            UserController.setCurrentUser(user);
            JOptionPane.showMessageDialog(null, "Login berhasil!\n" + user.getUserInfo());

        if (user instanceof Admin) {
            HomeAdmin homeAdmin = new HomeAdmin();
            homeAdmin.setVisible(true);
            this.dispose();
            } else if (user instanceof Pengunjung) {
            HomePengunjung homePengunjung = new HomePengunjung();
            homePengunjung.setVisible(true);
            this.dispose();
            }
        } else {
        JOptionPane.showMessageDialog(null, "Login Gagal! Username atau Password salah.");
        }    
    }

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
                                             
    }//GEN-LAST:event_jToggleButtonMasukActionPerformed

    private void jToggleButtonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonKeluarActionPerformed
        UserController.clearSession();
        
        MainHome mainhome = new MainHome ();
        mainhome.setVisible(true);
        Login.this.dispose();
    }//GEN-LAST:event_jToggleButtonKeluarActionPerformed

    private void inputUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButtonKeluar;
    private javax.swing.JToggleButton jToggleButtonMasuk;
    // End of variables declaration//GEN-END:variables
}