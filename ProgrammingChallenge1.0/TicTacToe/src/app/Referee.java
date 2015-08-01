/*
 Thread to see whether some one have won
 */
package app;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import db.DbConnector;
import db.PersonDAC;
import db.Person;
import java.io.IOException;
import java.sql.SQLException;

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
                System.out.print("play! ");
            }

            over = CheckGameStatus(new State(), pc.getxORo());

            if (over) {
                game.getTtt().closeGame();
                break;
            }

            pc.play();
            System.out.println("pc played!!!");

            over = CheckGameStatus(new State(), pc.getxORo());

            if (over) {
                game.getTtt().closeGame();
                break;
            }
            Console.freeToPlay = false; // lock the board until human plays
        }
    }

    /**
     * method to check whether the state is a win satate state - just played
     * state of the board played player's symbol (x or o)
     *
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
            updatePlayerDB(game.getPlayerName(), game.getDifficulty(), 'l');
            game.setGameOver(true);
            return true;

        } else if (win(state, SmartPc.opponentSymbol(pcCard))) {
            JOptionPane.showMessageDialog(null, "You Won!!!!");
            updatePlayerDB(game.getPlayerName(), game.getDifficulty(), 'w');
            game.setGameOver(true);
            return true;
        } else if (boardFull(state)) {
            JOptionPane.showMessageDialog(null, "Game is a draw!!!!");
            updatePlayerDB(game.getPlayerName(), game.getDifficulty(), 'd');
            game.setGameOver(true);
            return true;
        }
        return false;
    }

    public void updatePlayerDB(String PlayerName, Character difficulty, Character winningStatus) {
        try {
            DbConnector dbConnector = new DbConnector();
            PersonDAC personDAC = new PersonDAC(dbConnector.getMyConn());
            Person player = personDAC.searchPerson(PlayerName);
            
            String name = player.getName();
            int singleTotalPlays = player.getSingleTotalPlays();
            int singleEasyWins = player.getSingleEasyWins();
            int singleEasyDraws = player.getSingleEasyDraws();
            int singleHardWins = player.getSingleHardWins();
            int singleHardDraws = player.getSingleHardDraws();
            int multiTotalPlays = player.getMultiTotalPlays();
            int multidraws = player.getMultidraws();
            int multiWins = player.getMultiWins();
            
            if (difficulty == 'e') {
                if(winningStatus == 'w'){
                personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins+1,singleEasyDraws,singleHardWins,singleHardDraws,multiTotalPlays,multidraws,multiWins ));
                }
                if(winningStatus == 'd'){
                    personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins,singleEasyDraws+1,singleHardWins,singleHardDraws,multiTotalPlays,multidraws,multiWins ));
                }
                 if(winningStatus == 'l'){
                personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins,singleEasyDraws,singleHardWins,singleHardDraws,multiTotalPlays,multidraws,multiWins ));
                }
            } else {
                 if(winningStatus == 'w'){
                personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins,singleEasyDraws,singleHardWins+1,singleHardDraws,multiTotalPlays,multidraws,multiWins ));
                }
                if(winningStatus == 'd'){
                     personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins,singleEasyDraws,singleHardWins,singleHardDraws+1,multiTotalPlays,multidraws,multiWins ));
                }
                 if(winningStatus == 'l'){
                personDAC.updatePerson(new Person(PlayerName,singleTotalPlays+1,singleEasyWins,singleEasyDraws,singleHardWins,singleHardDraws,multiTotalPlays,multidraws,multiWins ));
                }
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
