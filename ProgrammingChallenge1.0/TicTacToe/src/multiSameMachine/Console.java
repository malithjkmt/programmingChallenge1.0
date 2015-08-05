/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiSameMachine;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

/**
 *
 * @author Malith
 */
public class Console {

    Game game;
    public static boolean freeToPlay = false;

    private String player1Name;
    private String player2Name;

//current game's score boars variables
    private int player1Wins;
    private int player2Wins;
    private int draw;

    public Console(String player1Name, String player2Name) {

        this.player1Name = player1Name;
        this.player2Name = player2Name;

        this.player1Wins = 0;
        this.player2Wins = 0;
        this.draw = 0;

        TTT ttt = new TTT(this);
        ttt.setVisible(true);

        game = new Game('x', 'o', ttt, player1Name, player2Name); //for an example I give x to human (that means human plays first)

        game.start();

    }

    public void createNewGame() {
        //make a new game
        TTT ttt = new TTT(this);

        ttt.setVisible(true);

        game = new Game('x', 'o', ttt, player1Name, player2Name);  //for an example I give x to human (that means human plays first)

        game.start();
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public void setPlayer1Wins(int player1Wins) {
        this.player1Wins = player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public void setPlayer2Wins(int PCWins) {
        this.player2Wins = PCWins;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public void setFreeToPlay(boolean freeToPlay) {
        this.freeToPlay = freeToPlay;
    }

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
            javax.swing.UIManager.setLookAndFeel(new NoireLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        new Console("Malith", "asdf");

    }
}
