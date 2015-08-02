package multiPlayerApp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malith
 */
public class Game {

    static Character s[][] = new Character[3][3]; // this is commom for entire game, entire time....
    static int activePlayer = 1; // here I give the first move chance to player who gets '1' // haven't used???

    private boolean gameOver = false;

    char humanCard = 'x';// <<<<<<<<< this is a tempory fix...... this should be blank
    char pcCard = 'o';
    TTT ttt;
    ServerSock server;
    ClientSock client;
    String inet;
    int indicator;
    static boolean freeToPlay;
    static boolean freeToPaint;
    static int k;

    public Game(String inet, int indicator) {
        ttt = new TTT(this);
        client = new ClientSock(inet, this);
        server = new ServerSock(this);
        this.indicator = indicator;
        k = 0;
        //ttt.setVisible(true);
        if (indicator == 1) {
            try {
                freeToPlay = true;
                server.waitingForConnect();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (indicator == 2) {
            try {
                freeToPlay = false;
                client.establishConnection();
            } catch (Exception ex) {

                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public TTT getTtt() {
        return ttt;
    }

    public void paint(int in) {

        //if(indicator==1 && k%2!=0){freeToPlay=true;}
        //if(indicator==2 && k%2==0){freeToPlay=true;}
        freeToPaint = true;
        System.out.println("at paint:" + freeToPlay);
        char[] chars = ("" + in).toCharArray();
        int x = chars[0] - '0' - 1;
        int y = chars[1] - '0';

        ttt.gclick(x, y);
        freeToPlay = true;
        freeToPaint = false;
        //if(indicator==1 && k%2!=0){freeToPlay=true;}
        //if(indicator==2 && k%2==0){freeToPlay=true;}
        // k++;
    }

    public ServerSock getServer() {
        return server;
    }

    public ClientSock getClient() {
        return client;
    }

    public int getIndicator() {
        return indicator;
    }

    public void start() {

    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //Game game=new Game(InetAddress.getLocalHost().getHostAddress(),1);
            Game game = new Game(InetAddress.getLocalHost().getHostAddress(), 2);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
