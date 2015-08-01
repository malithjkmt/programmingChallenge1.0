package multi;


/**
 *
 * @author Malith
 */
public class Game {

    static Character board[][] = new Character[3][3]; // this is commom for entire game, entire time....
    static int activePlayer = 1; // here I give the first move chance to player who gets '1' // haven't used???
    
    private boolean gameOver = false;

    char humanCard = 'x';// <<<<<<<<< this is a tempory fix...... this should be blank
    char pcCard = 'o';
    TTT ttt;

    
   

    public Game(char humanCard, char pcCard, TTT ttt) {
        this.humanCard = humanCard;
        this.ttt = ttt;
        this.pcCard = pcCard;
 
        
    }

   
    public void start() {
      
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

   

   
}
