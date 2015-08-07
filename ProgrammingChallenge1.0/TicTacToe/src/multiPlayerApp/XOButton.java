/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiPlayerApp;

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
    Game game;
    Referee ref = new Referee(game);
    /*
     0:O
     1:X
     */
    int indicator;
   public XOButton() {
   }
    public XOButton(Game game) {
        X = new ImageIcon(this.getClass().getResource("/pic/X.png"));
        O = new ImageIcon(this.getClass().getResource("/pic/O.png"));
        this.game = game;

        this.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (!(selected)) {

            if (Game.freeToPlay) {

                // get the address of the seleceted cell to couple of static variables
                String buttonName = ((XOButton) e.getSource()).getName();
                int x = TTT.selectedCellRow = Integer.parseInt(buttonName.substring(0, 1));
                int y = TTT.selectedCellCol = Integer.parseInt(buttonName.substring(1, 2));
                String s = String.valueOf(x) + String.valueOf(y);
                int out = Integer.parseInt(s) + 10;
                System.out.println("s:" + out);
                //if(game.isGameOver()){}
                selected = true;
                switch (Game.activePlayer) {   // check that who did this move (player0 or player1)
                    case 0:
                         new Thread(new Sound("button.wav")).start();
                        setIcon(O);
                        Game.s[TTT.selectedCellRow][TTT.selectedCellCol] = 'o'; // mark the play in the matrix
                        Game.activePlayer = 1;   // give playing hand to player1
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(Game.s[i][j] + " ");
                            }
                            System.out.println();
                        }

                        break;

                    case 1:
                         new Thread(new Sound("button.wav")).start();
                        setIcon(X);
                        Game.s[TTT.selectedCellRow][TTT.selectedCellCol] = 'x';  // mark the play in the matrix
                        Game.activePlayer = 0;    // give playing hand to player0
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(Game.s[i][j] + " ");
                            }
                            System.out.println();
                        }

                }
                if (game.getIndicator() == 1) {
                    game.getServer().sendData(out);

                } else if (game.getIndicator() == 2) {
                    game.getClient().sendData(out);

                }
                Game.k++;
                Game.freeToPlay = false;
            }
            if (Game.freeToPaint) {
                String buttonName = ((XOButton) e.getSource()).getName();
                int x = TTT.selectedCellRow = Integer.parseInt(buttonName.substring(0, 1));
                int y = TTT.selectedCellCol = Integer.parseInt(buttonName.substring(1, 2));
                String s = String.valueOf(x) + String.valueOf(y);
                int out = Integer.parseInt(s) + 10;
                System.out.println("s:" + out);

                selected = true;
                switch (Game.activePlayer) {   // check that who did this move (player0 or player1)
                    case 0:

                        setIcon(O);
                        Game.s[TTT.selectedCellRow][TTT.selectedCellCol] = 'o'; // mark the play in the matrix
                        Game.activePlayer = 1;   // give playing hand to player1
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(Game.s[i][j] + " ");
                            }
                            System.out.println();
                        }

                        break;

                    case 1:

                        setIcon(X);
                        Game.s[TTT.selectedCellRow][TTT.selectedCellCol] = 'x';  // mark the play in the matrix
                        Game.activePlayer = 0;    // give playing hand to player0
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(Game.s[i][j] + " ");
                            }
                            System.out.println();
                        }

                }
            }
            if (game.getIndicator() == 2) {
                ref.CheckGameStatus('x');
            } else if (game.getIndicator() == 1) {
                ref.CheckGameStatus('o');
            }
        }
    }
}
