package multiSameMachine;

/**
 *
 * @author Malith
 */
public class Game {

    private Character board[][] = new Character[3][3]; // this is commom for entire game, entire time....
    private int activePlayer = 1; // here I give the first move chance to player who gets '1' // haven't used???
    private Character difficulty;
    private boolean gameOver = false;

    char player1Card = 'x';
    char player2Card = 'o';
    TTT ttt;

    private final Referee ref;
    private final Player player1;
    private final Player player2;

    private final String player1Name;
    private final String player2Name;
    
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    Thread t;

    public Game(char player1Card, char player2Card, TTT ttt, String player1Name, String player2Name) {

        this.ttt = ttt;
        this.player1Card = player1Card;
        this.player2Card = player2Card;

        this.player1Name = player1Name;
        this.player2Name = player1Name;

        player1 = new Player(player1Card);
        player2 = new Player(player2Card);

        ref = new Referee(this, player1, player2,lock1, lock2);
         t = new Thread(ref);

    }
    public void start(){
        t.start();
    }
     // Let's assume player 1 is the human player
    // some thread has to run...... any player must not play until refree decide each play
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Referee getRef() {
        return ref;
    }

    public Object getLock1() {
        return lock1;
    }

    public Object getLock2() {
        return lock2;
    }

    public TTT getTtt() {
        return ttt;
    }

    public Character getDifficulty() {
        return difficulty;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Character[][] getBoard() {
        return board;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }

    public void updateBoard(int row, int col, Character symbol) {
        board[row][col] = symbol;

    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
}
