/*
 Thread to see whether some one have won
 */
package multiPlayerApp;

import audio.Sound;
import java.util.Objects;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class Referee {

    private Game game;
    Logger logger;

    public Referee(Game game) {
        this.game = game;
        logger=Logger.getLogger(Referee.class);
    }

    /**
     * method to check whether the state is a win satate state - just played
     * state of the board played player's symbol (x or o)
     *
     * @return *return true: if there's a win ; return false: if there isn't
     */
    public boolean win(char symbol) {
        //check for primary cross match
        if ((Objects.equals(game.s[0][0], game.s[1][1]) && Objects.equals(game.s[0][0], game.s[2][2])) && (Objects.equals(game.s[0][0], symbol))) {
            return true;
        }
        //check for secondary cross match
        if ((Objects.equals(game.s[2][0], game.s[1][1]) && Objects.equals(game.s[2][0], game.s[0][2])) && (Objects.equals(game.s[2][0], symbol))) {
            return true;
        }

        // check for horizontal match
        for (Character[] c : game.s) {
            if ((Objects.equals(c[0], c[1]) && Objects.equals(c[0], c[2])) && (Objects.equals(c[0], symbol))) {
                return true;
            }
        }
        // check for vertical match
        for (int i = 0; i < 3; i++) {
            if ((Objects.equals(game.s[0][i], game.s[1][i]) && Objects.equals(game.s[0][i], game.s[2][i])) && (Objects.equals(game.s[0][i], symbol))) {
                return true;
            }
        }
        return false;
    }  // should make a method withoust symbol variable as an input???

    // check whether the board is full
    public boolean boardFull(Game game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(game.s[i][j], null)) {
                    return false;
                }
            }
        }
        return true;
    }

    //check the last play, if it's an end game finish the game and display the result
    public boolean CheckGameStatus(char pcCard) {
        if (win(pcCard)) {
            new Thread(new Sound("ooh.wav")).start();
            JOptionPane.showMessageDialog(null, "Opponent Win");
            logger.info("Opponent win the game");
           // game.setGameOver(true);
            return true;

        } else if (win(opponentSymbol(pcCard))) {
            new Thread(new Sound("cheer.wav")).start();
            JOptionPane.showMessageDialog(null, "You Won!!!!");
            logger.info("Player won the game");

           // game.setGameOver(true);
            return true;
        } else if (boardFull(game)) {
            JOptionPane.showMessageDialog(null, "Game is a draw!!!!");
            logger.info("game is a draw");

           // game.setGameOver(true);
            return true;
        }
        return false;
    }

    // get the symbol of the human player

    public static char opponentSymbol(char pcSymbol) {
        char t;
        if (Objects.equals(pcSymbol, 'x')) {
            t = 'o';
        } else {
            t = 'x';
        }
        return t;
    }
}
