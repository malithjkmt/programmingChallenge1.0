/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerUI;

import SinglePlayerUI.MainMenue;
import javax.swing.JOptionPane;
import multiPlayerApp.Game;

/**
 *
 * @author prabath s
 */
public class AsClient extends javax.swing.JDialog {

    /**
     * Creates new form AsClient2
     */
    public AsClient(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ipTxt = new javax.swing.JTextField();
        connectBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(336, 430));
        setResizable(false);
        getContentPane().setLayout(null);

        ipTxt.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        ipTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ipTxt.setText("192.168.137.1");
        getContentPane().add(ipTxt);
        ipTxt.setBounds(33, 219, 140, 30);

        connectBtn.setFont(new java.awt.Font("Kristen ITC", 3, 20)); // NOI18N
        connectBtn.setForeground(new java.awt.Color(255, 255, 255));
        connectBtn.setText("Connect");
        connectBtn.setBorder(null);
        connectBtn.setContentAreaFilled(false);
        connectBtn.setFocusPainted(false);
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });
        getContentPane().add(connectBtn);
        connectBtn.setBounds(180, 210, 140, 40);

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter the Ip address of the");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 290, 20);

        jButton3.setFont(new java.awt.Font("Kristen ITC", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 340, 110, 40);

        jButton1.setFont(new java.awt.Font("Kristen ITC", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Main Menu");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 330, 140, 50);

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("computer you want to connect");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 130, 310, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/BlackWodBig.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(338, 550));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 340, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
        // TODO add your handling code here:
        Game game = null;
        try {
            game = new Game(ipTxt.getText(), 2);

        } catch (Exception e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(rootPane, "Error!!");
        }
        try {
            if (!game.getClient().hasError()) {
                this.dispose();
                game.getTtt().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error in connection!!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_connectBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new ServerOrClient(null, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new MainMenue().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AsClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsClient dialog = new AsClient(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectBtn;
    private javax.swing.JTextField ipTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}