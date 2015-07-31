/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Malith
 */
public class SmartPc extends Pc{

    int perfectRow;
    int perfectCol;
    Game game;
    char xORo;

    public SmartPc(char xORo, Game game) {
        this.xORo = xORo;
        this.game = game;
        
    }

    public void setPerfectAddress(int row, int col) {
        perfectRow = row;
        perfectCol = col;
    }

    public void play() {
        State initialState = new State(); //get the initial state to the temporary varialbe 'initialState'

        minimax(initialState, 0, xORo);   //after this minimax calling, now SmartPc knows(perfectRow, perfectCol variables are set) the address of the perfect cell, so pc clicks it

        game.getTtt().gclick(perfectRow, perfectCol); // pc clicks the perfect cell

        // check whether that this play ended the game // ???????????????????????? this is not a efficient code
        State temp = new State();
        //game.getRef().CheckGameStatus(temp, xORo);

        /*if(Referee.boardFull(temp) || Referee.win(temp, xORo)||Referee.win(temp, opponentSymbol(xORo))){
         Game.gameOver = true;
         JOptionPane.showMessageDialog(null, "SmartPc Won!!!!");
         }*/
        Console.freeToPlay = true;
    }

    // if current player wins, return positive value. if oponent wins returns negative value. else (draw) return 0
    // here I will do brute forse..... (later I'll think of a smart algo)
    public int score(State state, int depth) {
        if (game.getRef().win(state, xORo)) {
            return 10 - depth;
        } else if (game.getRef().win(state, opponentSymbol(xORo))) {
            return depth - 10;
        }
        return 0; // if the match is a draw
    }

    public int minimax(State state, int depth, char xORo) {

        // check whether the current state is a end game, if, return the score back.
        if (game.getRef().win(state, xORo) || game.getRef().win(state, opponentSymbol(xORo)) || game.getRef().boardFull(state)) {
            return score(state, depth);
        }
        depth += 1;
        ArrayList scores = new ArrayList();
        ArrayList movesRow = new ArrayList();
        ArrayList movesCol = new ArrayList();

        //travel through every cell on the board, generate all possible states and call minimax for each, store scores, moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(state.s[i][j], null)) {
                    State temp = new State(i, j, xORo, state.s);
                    scores.add(minimax(temp, depth, opponentSymbol(xORo))); // add the score get from minimax to the scores arraylist
                    movesRow.add(i); // save the relevent move address 
                    movesCol.add(j);
                }
            }
        }
        // if this is ( the relevent recursion) SmartPc's turn, return the maximum score(positive score) from score list and set the perfect move cell address
        if (this.xORo == xORo) {
            int max = (Integer) Collections.max(scores); // returns the maximum score from the list
            int maxIndex = scores.indexOf(max);   // get the index of the maximum score 
            setPerfectAddress((Integer) movesRow.get(maxIndex), (Integer) movesCol.get(maxIndex));  // get the cell address
            return max;
        } // if this is humans turn (in the recursion), return minimum score and set the perfect move cell address
        else {
            int min = (Integer) Collections.min(scores); // returns the maximum score from the list
            int minIndex = scores.indexOf(min);   // get the index of the maximum score 
            setPerfectAddress((Integer) movesRow.get(minIndex), (Integer) movesCol.get(minIndex));  // get the cell address
            return min;

        }

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
