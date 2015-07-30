
package app;

import app.Game;

/**
 *
 * @author Malith
 */
public class State{
    Character[][] s = new Character[3][3];

    public State() {
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                s[i][j] = Game.board[i][j];
            }
        }
    }
    
    // when pc make a tempory state with it's next possible move
    //symbol indicades who played that new move
    public State(int row, int col, char symbol, Character[][] previousState) {
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                s[i][j] = previousState[i][j];
            }
        }
        s[row][col]=symbol;
    }
    /*
    // when pc make a tempory state with it's next possible move
    public State(int row, int col, char symbol) {
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                s[i][j] = Game.board[i][j];
            }
        }
        s[row][col]=symbol;
    }*/
    
}
