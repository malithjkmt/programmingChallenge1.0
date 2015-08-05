/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;


import SinglePlayerUI.MainMenue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Malith
 */
public class TTT extends javax.swing.JFrame {

    static int selectedCellRow;
    static int selectedCellCol;

    private Game game;

    /**
     * Creates new form TTT
     */
    public TTT(Game game) {
        initComponents(game);
        this.game = game;
        setLocationRelativeTo(null);  // *** this will center the app ***


    }
    
    
    
   

    //unit tested(working)
    public void gclick(int r, int c) {

        //map address from the matrix to button's variable name
        String button = "b" + Integer.toString(r) + Integer.toString(c);
        Map<String, XOButton> map = new HashMap<>();
        map.put("b00", b00);
        map.put("b01", b01);
        map.put("b02", b02);
        map.put("b10", b10);
        map.put("b11", b11);
        map.put("b12", b12);
        map.put("b20", b20);
        map.put("b21", b21);
        map.put("b22", b22);

        // do the click(this means Pc plays a step)
        map.get(button).doClick();
    }

    public void closeGame() {
        b00.setEnabled(false);
        b01.setEnabled(false);
        b02.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b20.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Game game) {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup2 = new javax.swing.ButtonGroup();
        NewGame = new javax.swing.JFrame();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        MultiPlayerData = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        gameLevel = new javax.swing.JFrame();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        b00 = new multiPlayerApp.XOButton(game);
        b01 = new multiPlayerApp.XOButton(game);
        b02 = new multiPlayerApp.XOButton(game);
        b12 = new multiPlayerApp.XOButton(game);
        b11 = new multiPlayerApp.XOButton(game);
        b10 = new multiPlayerApp.XOButton(game);
        b20 = new multiPlayerApp.XOButton(game);
        b21 = new multiPlayerApp.XOButton(game);
        b22 = new multiPlayerApp.XOButton(game);
        jLabel10 = new javax.swing.JLabel();

        NewGame.setMinimumSize(new java.awt.Dimension(400, 300));
        NewGame.setResizable(false);

        jButton5.setText("Single Player");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Two Player");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewGameLayout = new javax.swing.GroupLayout(NewGame.getContentPane());
        NewGame.getContentPane().setLayout(NewGameLayout);
        NewGameLayout.setHorizontalGroup(
            NewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewGameLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(NewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        NewGameLayout.setVerticalGroup(
            NewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewGameLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        MultiPlayerData.setMinimumSize(new java.awt.Dimension(400, 300));
        MultiPlayerData.setResizable(false);

        jLabel1.setText("Player 1 name");

        jLabel3.setText("Player 2 name");

        javax.swing.GroupLayout MultiPlayerDataLayout = new javax.swing.GroupLayout(MultiPlayerData.getContentPane());
        MultiPlayerData.getContentPane().setLayout(MultiPlayerDataLayout);
        MultiPlayerDataLayout.setHorizontalGroup(
            MultiPlayerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MultiPlayerDataLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(MultiPlayerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MultiPlayerDataLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MultiPlayerDataLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        MultiPlayerDataLayout.setVerticalGroup(
            MultiPlayerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MultiPlayerDataLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(MultiPlayerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(MultiPlayerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        gameLevel.setMinimumSize(new java.awt.Dimension(400, 300));
        gameLevel.setResizable(false);

        jButton3.setText("Easy");

        jButton4.setText("Hard");

        javax.swing.GroupLayout gameLevelLayout = new javax.swing.GroupLayout(gameLevel.getContentPane());
        gameLevel.getContentPane().setLayout(gameLevelLayout);
        gameLevelLayout.setHorizontalGroup(
            gameLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLevelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        gameLevelLayout.setVerticalGroup(
            gameLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLevelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(gameLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe 2015");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton7.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 51, 0));
        jButton7.setText("Main Menue");
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 170, 0, 0);
        getContentPane().add(jButton7, gridBagConstraints);

        jPanel1.setOpaque(false);

        b00.setBorder(null);
        b00.setBorderPainted(false);
        b00.setContentAreaFilled(false);
        b00.setName("00"); // NOI18N

        b01.setBorder(null);
        b01.setBorderPainted(false);
        b01.setContentAreaFilled(false);
        b01.setName("01"); // NOI18N

        b02.setBorder(null);
        b02.setBorderPainted(false);
        b02.setContentAreaFilled(false);
        b02.setName("02"); // NOI18N

        b12.setBorder(null);
        b12.setBorderPainted(false);
        b12.setContentAreaFilled(false);
        b12.setName("12"); // NOI18N

        b11.setBorder(null);
        b11.setBorderPainted(false);
        b11.setContentAreaFilled(false);
        b11.setName("11"); // NOI18N

        b10.setBorder(null);
        b10.setBorderPainted(false);
        b10.setContentAreaFilled(false);
        b10.setName("10"); // NOI18N

        b20.setBorder(null);
        b20.setBorderPainted(false);
        b20.setContentAreaFilled(false);
        b20.setName("20"); // NOI18N

        b21.setBorder(null);
        b21.setBorderPainted(false);
        b21.setContentAreaFilled(false);
        b21.setName("21"); // NOI18N

        b22.setBorder(null);
        b22.setBorderPainted(false);
        b22.setContentAreaFilled(false);
        b22.setName("22"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b00, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(b01, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(b02, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b00, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b01, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b02, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -10;
        gridBagConstraints.ipady = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 43, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/canvas.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        gameLevel.setVisible(true);
        NewGame.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MultiPlayerData.setVisible(true);
        NewGame.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         this.dispose();
        new MainMenue().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame MultiPlayerData;
    private javax.swing.JFrame NewGame;
    private multiPlayerApp.XOButton b00;
    private multiPlayerApp.XOButton b01;
    private multiPlayerApp.XOButton b02;
    private multiPlayerApp.XOButton b10;
    private multiPlayerApp.XOButton b11;
    private multiPlayerApp.XOButton b12;
    private multiPlayerApp.XOButton b20;
    private multiPlayerApp.XOButton b21;
    private multiPlayerApp.XOButton b22;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFrame gameLevel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
