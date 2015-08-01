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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {

    TTT ttt;
    boolean selected = false; // check whether this cell is played previously
    ImageIcon X, O;
    /*
     0:O
     1:X
     */

    public XOButton(TTT ttt) {
        X = new ImageIcon(this.getClass().getResource("/pic/X.png"));
        O = new ImageIcon(this.getClass().getResource("/pic/O.png"));
        this.addActionListener(this);
        this.ttt = ttt;
    }

    public TTT getTtt() {
        return ttt;
    }

    public void actionPerformed(ActionEvent e) {
        Object lock = ttt.getConsole().getGame().getLock();
       
        
        Console.freeToPlay = true;
        if (!(selected)) {

            // get the address of the seleceted cell to couple of static variables
            String buttonName = ((XOButton) e.getSource()).getName();
            ttt.setSelectedCellRow(Integer.parseInt(buttonName.substring(0, 1)));
            ttt.setSelectedCellCol(Integer.parseInt(buttonName.substring(1, 2)));

            selected = true;
            switch (ttt.getConsole().getGame().getActivePlayer()) {   // check that who did this move (player0 or player1)
                case 0:
                    setIcon(O);
                    // ttt.getConsole().getGame().getBoard()[ttt.getSelectedCellRow()][ttt.getSelectedCellCol()] = 'o'; // mark the play in the matrix
                    ttt.getConsole().getGame().updateBoard(ttt.getSelectedCellRow(), ttt.getSelectedCellCol(), 'o');
                    ttt.getConsole().getGame().printBoard();
                   
                    ttt.getConsole().getGame().setActivePlayer(1);   // give playing hand to player1
                    break;
                case 1:
                    setIcon(X);
                    //  ttt.getConsole().getGame().getBoard()[ttt.getSelectedCellRow()][ttt.getSelectedCellCol()] = 'x';  // mark the play in the matrix
                    ttt.getConsole().getGame().updateBoard(ttt.getSelectedCellRow(), ttt.getSelectedCellCol(), 'x');
                    ttt.getConsole().getGame().printBoard();
                     synchronized (lock) {

                        lock.notify();
                        System.out.println("notify");
                    }
                    ttt.getConsole().getGame().setActivePlayer(0);  // give playing hand to player0

            }
        }
    }
}
