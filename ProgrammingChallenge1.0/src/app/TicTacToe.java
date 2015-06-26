/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Malith
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class TicTacToe extends JFrame{
    JPanel tray = new JPanel();
    XOButton button[] = new XOButton[9];
    //static int value =1;
    

   /* public static void main (String args[]){
        new TicTacToe();
    }*/

    public TicTacToe(){
        
        super("TicTacToe");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tray.setLayout(new GridLayout(3,3));
        
        for(int i=0;i<9;i++){
            button[i] = new XOButton();
            tray.add(button[i]);
        }
        add(tray);
        setVisible(true);
    }

}
