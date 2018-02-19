package view;

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

    private static JButton buttons[] = new JButton[9]; //create 9 buttons

    public TicTacToeViewGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(); //creating a panel with a box like a tic tac toe board
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
        panel.setBackground(Color.white);

        for (int i = 0; i <= 8; i++) { //placing the button onto the board
            buttons[i] = new JButton();
            buttons[i].addActionListener(new myButtonListener());
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
    public void switchPlayer() {
        //assuming we always start with player X at the beginning of the game
        //this.setTitle("TicTacToe - PLAYER X's TURN");
        // assuming turn count starts at 0 and increments after a player has played their turn
        // if turn count is odd
        this.setTitle("TicTacToe - PLAYER O's TURN");
        // if turn count is even
        this.setTitle("TicTacToe - PLAYER X's TURN");
    }

    @Override
    public void updateBoardForX(int x, int y) {
        // TODO Auto-generated method stub
        //?????

    }

    @Override
    public void updateBoardForO(int x, int y) {
        // TODO Auto-generated method stub
        //?????

    }

    @Override
    public void gameOutcomeMessage() {
        JFrame frame = new JFrame();
        //if player X wins
        JOptionPane.showMessageDialog(frame,
                "Player X wins!",
                "A plain message",
                JOptionPane.PLAIN_MESSAGE);

        //if player o wins
        JOptionPane.showMessageDialog(frame,
                "Player O wins!",
                "A plain message",
                JOptionPane.PLAIN_MESSAGE);

        //if it is a draw
        JOptionPane.showMessageDialog(frame,
                "It is a Draw!",
                "A plain message",
                JOptionPane.PLAIN_MESSAGE);

    }

    @Override
    public void userInput() {
        // TODO Auto-generated method stub
        //the button they clicked???
        //?????

    }

    private class myButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            // if it is x's turn (somehow call updateBoardForX())
            buttonClicked.setText("X");
            //if it is o's turn (somehow call updateBoardForO())
            buttonClicked.setText("O");
        }
    }

}