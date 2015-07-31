/*
 Thread to see whether some one have won
 */
package app;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Referee {

    private Game game;

    public Referee(Game game) {
        this.game = game;
    }

    public void reffer(Player human, Pc pc) {
        boolean over = false;

        while (!game.isGameOver()) {
            human.play();
            
             // infinity loop until human plays
            while (!(Console.freeToPlay)) {
                try {Thread.sleep(1);} catch (InterruptedException ex) {Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);}
            }     
            
            over = CheckGameStatus(new State(), pc.getxORo());

            if (over) {
                
                break;
            }

            pc.play();
            System.out.println("pc played!!!");

            over = CheckGameStatus(new State(), pc.getxORo());

            if (over) {
                    
                break;
            }
            Console.freeToPlay = false; // lock the board until human plays
        }
    }

    
    /**
     * method to check whether the state is a win satate
     * state - just played state of the board
     * played player's symbol (x or o)
     * @return *return true: if there's a win ; return false: if there isn't
     */
    
    public boolean win(State state, char symbol) {
        //check for primary cross match
        if ((Objects.equals(state.s[0][0], state.s[1][1]) && Objects.equals(state.s[0][0], state.s[2][2])) && (Objects.equals(state.s[0][0], symbol))) {
            return true;
        }
        //check for secondary cross match
        if ((Objects.equals(state.s[2][0], state.s[1][1]) && Objects.equals(state.s[2][0], state.s[0][2])) && (Objects.equals(state.s[2][0], symbol))) {
            return true;
        }

        // check for horizontal match
        for (Character[] c : state.s) {
            if ((Objects.equals(c[0], c[1]) && Objects.equals(c[0], c[2])) && (Objects.equals(c[0], symbol))) {
                return true;
            }
        }
        // check for vertical match
        for (int i = 0; i < 3; i++) {
            if ((Objects.equals(state.s[0][i], state.s[1][i]) && Objects.equals(state.s[0][i], state.s[2][i])) && (Objects.equals(state.s[0][i], symbol))) {
                return true;
            }
        }
        return false;
    }  // should make a method withoust symbol variable as an input???

    // check whether the board is full
    public boolean boardFull(State state) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(state.s[i][j], null)) {
                    return false;
                }
            }
        }
        return true;
    }

    //check the last play, if it's an end game finish the game and display the result
    public boolean CheckGameStatus(State state, char pcCard) {
        if (win(state, pcCard)) {
            JOptionPane.showMessageDialog(null, "Pc Won!");
            game.setGameOver(true);
            return true;

        } else if (win(state, SmartPc.opponentSymbol(pcCard))) {
            JOptionPane.showMessageDialog(null, "You Won!!!!");
            game.setGameOver(true);
            return true;
        } else if (boardFull(state)) {
            JOptionPane.showMessageDialog(null, "Game is a draw!!!!");
            game.setGameOver(true);
            return true;
        }
        return false;
    }
}
