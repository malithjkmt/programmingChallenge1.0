/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabath s
 */
public class ServerSock {

    Game game;
    Socket client;
    boolean accepted;

    public ServerSock(Game game) {
        this.game = game;
        accepted = false;
    }

    public void waitingForConnect() throws IOException {
        ServerSocket server = new ServerSocket(1300);
        System.out.println("waiting for request from peer.....");

        client = server.accept();
        accepted = true;

        Server s = new Server(client, game);
        System.out.println("connect");

    }

    public boolean isAccepted() {
        return accepted;
    }

    public void sendData(int out) {
        try {
            client.getOutputStream().write(out);

        } catch (IOException ex) {
            Logger.getLogger(ServerSock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   // public static void main(String args[]) throws IOException {
    //    ServerSocket server = new ServerSocket(1300);
    //    System.out.println("waiting for request from peer.....");
     ///   Socket client = server.accept();
        //Server s = new Server(client);
    //s.t.start();
    //  System.out.println("request accepted");
    // BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
    // PrintStream ps2 = new PrintStream(client.getOutputStream());
    //  while (true) {
    //     String st = br2.readLine();
    //     ps2.println(st);
    //  }
    // }
}
