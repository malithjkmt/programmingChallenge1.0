/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi;

/**
 *
 * @author Malith
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {

    boolean selected = false; // check whether this cell is played previously
    ImageIcon X, O;
    /*
     0:O
     1:X
     */

    public XOButton() {
        X = new ImageIcon(this.getClass().getResource("/pic/X.png"));
        O = new ImageIcon(this.getClass().getResource("/pic/O.png"));
        this.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
       
        if (!(selected)) {

            // get the address of the seleceted cell to couple of static variables
            String buttonName = ((XOButton) e.getSource()).getName();
            TTT.selectedCellRow = Integer.parseInt(buttonName.substring(0, 1));
            TTT.selectedCellCol = Integer.parseInt(buttonName.substring(1, 2));

            selected = true;
            switch (Game.activePlayer) {   // check that who did this move (player0 or player1)
                case 0:
                    setIcon(O);
                    Game.board[TTT.selectedCellRow][TTT.selectedCellCol] = 'o'; // mark the play in the matrix
                    Game.activePlayer = 1;   // give playing hand to player1
                    break;
                case 1:
                    setIcon(X);
                    Game.board[TTT.selectedCellRow][TTT.selectedCellCol] = 'x';  // mark the play in the matrix
                    Game.activePlayer = 0;    // give playing hand to player0

            }
        }
    }
}
