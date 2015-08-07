/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiSameMachine;

/**
 *
 * @author Malith
 */
import audio.Sound;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {

    boolean selected = false; // check whether this cell is played previously
    ImageIcon X, O;
    TTT ttt;

    /*
     0:O
     1:X
     */
    public XOButton() {

    }

    public XOButton(TTT ttt) {
        this.ttt = ttt;
        X = new ImageIcon(this.getClass().getResource("/pic/X.png"));
        O = new ImageIcon(this.getClass().getResource("/pic/O.png"));
        this.addActionListener(this);

    }

    public synchronized void actionPerformed(ActionEvent e) {
        Object lock1 = ttt.getConsole().getGame().getLock1();
        Object lock2 = ttt.getConsole().getGame().getLock2();

        // Console.freeToPlay = true;
        if (!(selected)) {

            // get the address of the seleceted cell to couple of static variables
            String buttonName = ((XOButton) e.getSource()).getName();
            ttt.setSelectedCellRow(Integer.parseInt(buttonName.substring(0, 1)));
            ttt.setSelectedCellCol(Integer.parseInt(buttonName.substring(1, 2)));

            selected = true;
            switch (ttt.getConsole().getGame().getActivePlayer()) {   // check that who did this move (player0 or player1)
                case 0:
                    new Thread(new Sound("button.wav")).start();
                    setIcon(O);
                    ttt.getConsole().getGame().updateBoard(ttt.getSelectedCellRow(), ttt.getSelectedCellCol(), 'o'); // mark the play in the matrix
                    synchronized (lock1) {

                        lock1.notify();
                        System.out.println("notify1");
                    }
                    ttt.getConsole().getGame().setActivePlayer(1);     // give playing hand to player1
                    break;
                case 1:
                    new Thread(new Sound("button.wav")).start();
                    setIcon(X);
                    ttt.getConsole().getGame().updateBoard(ttt.getSelectedCellRow(), ttt.getSelectedCellCol(), 'x'); // mark the play in the matrix
                    synchronized (lock2) {

                        lock2.notify();
                        System.out.println("notify2");
                    }

                    ttt.getConsole().getGame().setActivePlayer(0);    // give playing hand to player0

            }
        }
    }
}
