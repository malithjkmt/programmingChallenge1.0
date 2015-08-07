package SinglePlayerApp;

/**
 *
 * @author Malith
 */
public class Game {

    private Character board[][] = new Character[3][3]; // this is commom for entire game, entire time....
    private int activePlayer; // here I give the first move chance to player who gets '1' // haven't used???
    private char difficulty;
    private boolean gameOver = false;
   
    
    char humanCard ;// <<<<<<<<< this is a tempory fix...... this should be blank
    char pcCard;
    TTT ttt;

    private Referee ref;
    private Player human;
    private Pc pc;
    private String playerName;
    Thread t;
    private final Object lock = new Object();
   private boolean firstTurn;
    
    public Game(char humanCard, char pcCard, TTT ttt, char difficulty, String playerName) {
        this.humanCard = humanCard;
        this.ttt = ttt;
        this.pcCard = pcCard;
        this.playerName = playerName;
        this.difficulty = difficulty;
        
        switch(humanCard){
            case('o'):
                this.activePlayer = 0;
                break;
            
            case('x'):
                this.activePlayer = 1;
        }
        
        this.firstTurn = ttt.getConsole().isFirstTurn();
        
        
       
        human = new Player(humanCard);
        
        if(difficulty == 'd'){
            pc = new SmartPc(pcCard, this);
        }
        else{
            pc = new DumbPc(pcCard, this);
        }
         ref = new Referee(this, human, pc,lock); 
          t = new Thread(ref);
    }

   
    public Object getLock() {
        return lock;
    }



    
     // Let's assume player 1 is the human player
    // some thread has to run...... any player must not play until refree decide each play
    public void start() {
        t.start();
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

   
    public synchronized TTT getTtt() {
        return ttt;
    }

    public Character getDifficulty() {
        return difficulty;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public synchronized Character[][] getBoard() {
        return board;
    }

    public synchronized void setBoard(Character[][] board) {
        this.board = board;
    }
    public synchronized void updateBoard(int row, int col, Character symbol){
        board[row][col] = symbol;
               
    }
    public void printBoard(){
        for(int i=0;i<3;i++){
            System.out.println("");
            for (int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }
}
