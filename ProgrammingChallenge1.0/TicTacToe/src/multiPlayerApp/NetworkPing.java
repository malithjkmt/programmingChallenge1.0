/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author prabath s
 */
public class NetworkPing extends JFrame {

    ArrayList<String> list = new ArrayList();

    public NetworkPing() {
    }

    public static void main(String[] args) throws UnknownHostException {

    }

    public ArrayList<String> getClient() throws IOException {
        InetAddress localhost = null;

        try {
            localhost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // this code assumes IPv4 is used 
        byte[] ip = localhost.getAddress();
        for (int i = 0; i < 255; i++) {//should be i<255 changed for demonstrational purpusos
            ip[3] = (byte) i;
            InetAddress address = InetAddress.getByAddress(ip);

            System.out.println(i);
            if (address.isReachable(1)) {
                InetAddress a = InetAddress.getByName(address.getHostAddress());
                System.out.println("can b pinged");
                System.out.println(address.getAddress());
                //list.add(address.getHostName());

                // machine is turned on and can be pinged 
            } else if (!address.getHostAddress().equals(address.getHostName())) {
                System.out.println("Name is......" + address.getHostName() + "\tIP is......." + address.getHostAddress());
                // machine is known in a DNS lookup 
            } else {
                //System.out.println("nothing");
                // the host address and host name are equal, meaning the host name could not be resolved 
            }
        }
        return list;
    }
}//
