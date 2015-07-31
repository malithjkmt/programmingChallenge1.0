package app;

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

    private Referee ref;
    private Player human;
    private Pc pc;


    public Game(char humanCard, char pcCard, TTT ttt, char difficulty) {
        this.humanCard = humanCard;
        this.ttt = ttt;
        this.pcCard = pcCard;

        ref = new Referee(this); 
        human = new Player(humanCard);
        if(difficulty == 'd'){
            pc = new SmartPc(pcCard, this);
        }
        else{
            pc = new DumbPc(pcCard, this);
        }
        
    }

    
     // Let's assume player 1 is the human player
    // some thread has to run...... any player must not play until refree decide each play
    public void start() {
        ref.reffer(human, pc);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Referee getRef() {
        return ref;
    }

   
    public TTT getTtt() {
        return ttt;
    }

}
