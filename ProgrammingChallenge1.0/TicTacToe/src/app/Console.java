/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.GameMenu;

/**
 *
 * @author Malith
 */
public class Console {

    public static boolean freeToPlay = false;
    private char difficulty;
    private String playerName;
    
   

    public Console(char difficulty, String playerName, GameMenu gameMenu) {
        gameMenu.setVisible(false);
        
        this.difficulty = difficulty;
        this.playerName = playerName;
        
        TTT ttt= new TTT(this);
        
       ttt.setVisible(true);
        
        Game game = new Game('x', 'o', ttt, difficulty, playerName); //for an example I give x to human (that means human plays first)
        //freeToPlay = true; // open the board to play
        game.start();
       
    }

    /* public void createNewGame(){
          //make a new game
        TTT ttt = new TTT(this);

        ttt.setVisible(true);

        Game game = new Game('x', 'o', ttt, 'd', playerName); //for an example I give x to human (that means human plays first)
        //freeToPlay = true; // open the board to play
        game.start();
     }*/
     
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

        //new Console('d',"Malith");

    }
}
