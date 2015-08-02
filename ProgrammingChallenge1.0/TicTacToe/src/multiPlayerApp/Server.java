/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;

/**
 *
 * @author prabath s
 */
import java.net.*;
import java.io.*;

class Server implements Runnable {

    Thread t;
    Socket client;

    int in;
    Game game;

    Server(Socket client, Game game) {
        this.client = client;

        t = new Thread(this);
        this.game = game;
        System.out.println("connect1");
        t.start();
    }

    public void run() {
        try {

            while (true) {
                in = client.getInputStream().read();

                game.paint(in);

            }
        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
