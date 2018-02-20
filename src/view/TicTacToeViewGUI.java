package view;

import controller.Controller;
import controller.ControllerImpl;
import model.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Game's graphical user interface
 *
 * @author Christian Metz
 * @version 2.0
 * @date 17.01.2012
 */
public class TicTacToeViewGUI extends JFrame implements TicTacToeView {

    private static final JButton[] buttons = new JButton[9]; //create 9 buttons
    private JButton buttonClicked;
    private final Controller myController = new ControllerImpl(this);

    public TicTacToeViewGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(); //creating a panel with a box like a tic tac toe board
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
        panel.setBackground(Color.white);

        for (int i = 0; i <= 8; i++) { //placing the button onto the board
            buttons[i] = new JButton();
            buttons[i].addActionListener(new MyButtonListener());
            panel.add(buttons[i]);
        }

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setTitle("Tic Tac Toe - PLAYER X's TURN");
    }

    @Override
    public void displayNonEmptySpotError() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Error: This not an empty space!",
                "Inane warning",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void displayOutOfBoundsError() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Error: That is not a valid spot on the game board!",
                "Inane warning",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public int switchToPlayerX() {
        //assuming we always start with player X at the beginning of the game
        //this.setTitle("TicTacToe - PLAYER X's TURN");
        // assuming turn count starts at 0 and increments after a player has played their turn
        // if turn count is even
        this.setTitle("TicTacToe - PLAYER X's TURN");
        return 0;
    }

    @Override
    public int switchToPlayerO() {
        //assuming we always start with player X at the beginning of the game
        //this.setTitle("TicTacToe - PLAYER X's TURN");
        // assuming turn count starts at 0 and increments after a player has played their turn
        // if turn count is odd
        this.setTitle("TicTacToe - PLAYER O's TURN");
        return 0;
    }

    @Override
    public boolean updateBoardForX(Coordinates coords) {
        int row = coords.getRow();
        int col = coords.getCol();
        buttonClicked.setText("X");
        buttonClicked.updateUI();
        return true;

    }

    @Override
    public boolean updateBoardForO(Coordinates coords) {
        int row = coords.getRow();
        int col = coords.getCol();
        buttonClicked.setText("O");
        buttonClicked.updateUI();
        return true;
    }

    @Override
    public void displayWhoWon(int currPlayer) {
        JFrame frame = new JFrame();
        switch (currPlayer) {
            case 1: //if player X wins
                JOptionPane.showMessageDialog(frame,
                        "Player X wins!",
                        "A plain message",
                        JOptionPane.PLAIN_MESSAGE);
                break;

            case 2:
                //if player o wins
                JOptionPane.showMessageDialog(frame,
                        "Player O wins!",
                        "A plain message",
                        JOptionPane.PLAIN_MESSAGE);
                break;

            default:         //if it is a draw
                JOptionPane.showMessageDialog(frame,
                        "It is a Draw!",
                        "A plain message",
                        JOptionPane.PLAIN_MESSAGE);
                break;
        }
        endGame();
    }

    @Override
    public void endGame() {
        System.exit(0);
    }

    @Override
    public void playGame(int currPlayer) {

    }

    // On Click Listener
    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            buttonClicked = (JButton) e.getSource();

            // https://stackoverflow.com/questions/22580243/get-position-of-the-button-on-gridlayout
            // http://www.cbseguy.com/row-column-major-address-calculations-cbse/
            for (int i = 0; i < 9; i++) {
                if (buttons[i] == buttonClicked) {
                    int row = i / 3;
                    int col = i % 3;
//                    System.out.printf("Row: %s", row);
//                    System.out.println();
//                    System.out.printf("Col: %s", col);
//                    System.out.println();
                    myController.takeSpot(row + 1, col + 1);
                }
            }
            // if it is x's turn (somehow call updateBoardForX())
//            buttonClicked.setText("X");
            //if it is o's turn (somehow call updateBoardForO())
//            buttonClicked.setText("O");
        }
    }

}