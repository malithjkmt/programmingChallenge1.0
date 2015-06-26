
package app;

/**
 *
 * @author Malith
 */
public class Game {
    static Character board[][] = new Character[3][3]; // this is commom for entire game....
    static int activePlayer = 1; // here I give the first move chance to player who gets '1' // haven't used???
    static boolean gameOver = false;
    char humanCard = 'x';// <<<<<<<<< this is a tempory fix...... this should be blank
    char pcCard = 'o';
    
    public Game(){
        
    }
       
    public Game(char humanCard, char pcCard){
        this.humanCard = humanCard;
        //System.out.println("mmmmmmmmmmmmmmmmm");
        this.pcCard = pcCard;
    }
    Referee ref = new Referee();////////????
    Player human = new Player(humanCard);
    Pc pc = new Pc(pcCard);
    
    public void start(){
        ref.reffer(human, pc);
    }
    
    // Let's assume player 1 is the human player
    // some thread has to run...... any player must not play until refree decide each play
    
    
    
}
