/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabath s
 */
public class ClientSock {

    String inetAddress;
    Socket client;

    Game game;
    boolean error = false;

    public ClientSock(String inetAddress, Game game) {
        this.inetAddress = inetAddress;
        client = null;
        this.game = game;
    }

    public Socket establishConnection() throws IOException {
        try {
            client = new Socket(inetAddress, 1300);
        } catch (Exception e) {
            error = true;
        }
        System.out.println("connect");
        Client c = new Client(client, game);

        return client;
    }

    public boolean hasError() {
        return error;
    }

    public void sendData(int a) {
        try {
            client.getOutputStream().write(a);
        } catch (IOException ex) {
            Logger.getLogger(ClientSock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   // public static void main(String args[]) throws IOException {
    //   try {
    //    System.out.println("sending request to peer....");
    //  Socket client = new Socket(InetAddress.getLocalHost().getHostAddress(), 1300);
    //   System.out.println("successfully conneted");
    //Client c = new Client(client,m);
          //  BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    //  PrintStream ps = new PrintStream(client.getOutputStream());
    //  while (true) {
    //      String s = br1.readLine();
    //      ps.println(s);
    // }
    //} catch (Exception e) {
    // System.out.println(e);
    // }
    // }
}
