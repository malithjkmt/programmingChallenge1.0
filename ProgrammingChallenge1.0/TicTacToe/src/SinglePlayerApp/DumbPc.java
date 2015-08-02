/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglePlayerApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Malith
 */
public class DumbPc extends Pc {

    int perfectRow;
    int perfectCol;
    Game game;
    char xORo;
    Random rn;

    public DumbPc(char xORo, Game game) {
        this.xORo = xORo;
        this.game = game;
        rn = new Random();
        
    }

    public void setPerfectAddress(int row, int col) {
        perfectRow = row;
        perfectCol = col;
    }

    public void play() {
        State initialState = new State(game.getBoard()); //get the initial state to the temporary varialbe 'initialState'

        dumbMax(initialState, xORo);   //after this minimax calling, now Pc knows(perfectRow, perfectCol variables are set) the address of the perfect cell, so pc clicks it

        game.getTtt().gclick(perfectRow, perfectCol); // pc clicks the perfect cell

        // check whether that this play ended the game // ???????????????????????? this is not a efficient code
        State temp = new State(game.getBoard());
        
        Console.freeToPlay = true;
    }

  

    public void dumbMax(State state, char xORo) {
        ArrayList row = new ArrayList();
        ArrayList column = new ArrayList();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(Objects.equals(state.s[i][j] , null)){
                    row.add(i);
                    column.add(j);
                } 
                   
            }
        }
        int size = row.size();
        int temp;
        
        
        temp = rn.nextInt(size-1 - 0 + 1) + 0;
        setPerfectAddress((int) row.get(temp), (int) column.get(temp));
        

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

    public char getxORo() {
        return xORo;
    }

}
