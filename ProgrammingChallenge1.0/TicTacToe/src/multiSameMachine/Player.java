package multiSameMachine;

import SinglePlayerApp.*;

/**
 *
 * @author Malith
 */
public class Player {
    boolean hand;
    char xORo;

    public Player(char xORo) {
        this.xORo = xORo;
    }
    
    public void play(){
        System.out.println("Hello!!! bugger, now it's your move.. please hurry");
        
    }

    public char getxORo() {
        return xORo;
    }
  
    
}
