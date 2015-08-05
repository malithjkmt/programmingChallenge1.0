/*
 Thread to see whether some one have won
 */
package multiSameMachine;

import SinglePlayerApp.State;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import db.DbConnector;
import db.PersonDAC;
import db.Person;
import java.io.IOException;
import java.sql.SQLException;

public class Referee implements Runnable {

    Player player1;
    Player player2;
    private Game game;

    Object lock1;
    Object lock2;
    
    public Referee(Game game, Player player1, Player player2,Object lock1,Object lock2) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.lock1 =lock1;
        this.lock2 = lock2;

    }

    public void reffer() {
        boolean over = false;

        while (!game.isGameOver()) {

            player1.play();
            
             try {
                synchronized (lock1) {

                    lock1.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("INterrupted!!!! lock 1");
            }


            over = CheckGameStatus(new State(game.getBoard()), player2.getxORo());

            if (over) {
                game.getTtt().closeGame();
                break;
            }

            player2.play();
               try {
                synchronized (lock2) {

                    lock2.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("INterrupted!!!! lock 2");
            }

            over = CheckGameStatus(new State(game.getBoard()), player2.getxORo());

            if (over) {
                game.getTtt().closeGame();
                break;
            }
            Console.freeToPlay = false; // lock the board until player2 plays

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
            game.getTtt().getConsole().setPlayer2Wins(game.getTtt().getConsole().getPlayer2Wins()+1);
             game.getTtt().displayPlayer2Score();

            JOptionPane.showMessageDialog(game.getTtt(), game.getTtt().getConsole().getPlayer2Name()+" Won!");

             updatePlayerDB(game.getPlayer2Name(), 'l');
            game.setGameOver(true);
            return true;

        } else if (win(state, opponentSymbol(pcCard))) {
            game.getTtt().getConsole().setPlayer1Wins(game.getTtt().getConsole().getPlayer1Wins() + 1);
            game.getTtt().displayPlayer1Score();

            JOptionPane.showMessageDialog(game.getTtt(), game.getTtt().getConsole().getPlayer1Name()+" Won!!!!");

              updatePlayerDB(game.getPlayer1Name(), 'w');
            game.setGameOver(true);
            return true;
        } else if (boardFull(state)) {
            game.getTtt().getConsole().setDraw(game.getTtt().getConsole().getDraw()+1);
             game.getTtt().displayDraw();

            JOptionPane.showMessageDialog(game.getTtt(), "Game is a draw!!!!");

             updatePlayerDB(game.getPlayer1Name(), 'd');
             updatePlayerDB(game.getPlayer2Name(), 'd');
            game.setGameOver(true);
            return true;
        }
        return false;
    }

    public void updatePlayerDB(String PlayerName, Character winningStatus) {
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

           
                if (winningStatus == 'w') {
                    personDAC.updatePerson(new Person(PlayerName, singleTotalPlays , singleEasyWins , singleEasyDraws, singleHardWins, singleHardDraws, multiTotalPlays+1, multidraws, multiWins+1));
                }
                if (winningStatus == 'd') {
                    personDAC.updatePerson(new Person(PlayerName, singleTotalPlays , singleEasyWins, singleEasyDraws , singleHardWins, singleHardDraws, multiTotalPlays+1, multidraws+1, multiWins));
                }
                if (winningStatus == 'l') {
                    personDAC.updatePerson(new Person(PlayerName, singleTotalPlays , singleEasyWins, singleEasyDraws, singleHardWins, singleHardDraws, multiTotalPlays+1, multidraws, multiWins));
                }
           
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        reffer();
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
