/*
 Thread to see whether some one have won
 */
package app;

import app.Console;
import app.Game;
import app.State;
import java.util.Objects;
import javax.swing.JOptionPane;


public class Referee {
    
    public void reffer(Player human, Pc pc){
        
        while(!Game.gameOver){
            human.play();
            
            while(!(Console.freeToPlay)){System.out.println("you must play!!!");}      // infinity loop until human plays
                CheckGameStatus(new State(), human.xORo);
                if(Console.freeToPlay){
                    pc.play();
                    System.out.println("pc played!!!");
                }
                Console.freeToPlay = false; // lock the board until human plays
        }
    }
    //give chance to player1 and pc.... simultaniously (try threads, while loops )
    
    //return true: if there's a win
    //return false: if there isn't
    // can use this function to any player (only take the state as parameters
    public static boolean win(State state, char symbol){
        //check for primary cross match
        if((Objects.equals(state.s[0][0], state.s[1][1]) && Objects.equals(state.s[0][0], state.s[2][2]))&&(Objects.equals(state.s[0][0], symbol))){
            return true;
        }
         //check for secondary cross match
        if((Objects.equals(state.s[2][0], state.s[1][1]) && Objects.equals(state.s[2][0], state.s[0][2]))&&(Objects.equals(state.s[2][0], symbol))){
            return true;
        }

        // check for horizontal match
        for(Character[] c:state.s){
            if ((Objects.equals(c[0], c[1]) && Objects.equals(c[0], c[2]))&& (Objects.equals(c[0],symbol))){
                return true;
            }
        }
        // check for vertical match
        for(int i =0;i<3;i++){
            if((Objects.equals(state.s[0][i], state.s[1][i]) && Objects.equals(state.s[0][i], state.s[2][i]))&&(Objects.equals(state.s[0][i], symbol))){
                return true;
            }
        }
        return false;
    }  // should make a method withoust symbol variable as an input???
    
    // check whether the board is full
    public static boolean boardFull(State state){
            for (int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(Objects.equals(state.s[i][j],null)){return false;}
                }
            }
        return true;
    }
    
    //check the last play overed the game and display the result
    public static void CheckGameStatus(State state, char pcCard){
        if(win(state, pcCard)){
             JOptionPane.showMessageDialog(null, "Pc Won!!!!");
        }
        else if(win(state,Pc.opponentSymbol(pcCard) )){
             JOptionPane.showMessageDialog(null, "You Won!!!!");
        }
        else if(boardFull(state)){
             JOptionPane.showMessageDialog(null, "Game is a draw!!!!");
        }
    }
}
