package view;

import model.Coordinates;

import java.util.Scanner;

public class TicTacToeViewText implements TicTacToeView {
    Scanner input = new Scanner(System.in);
    public static final boolean DEBUG = false;
    String[][] board;
    int row, col;

    public TicTacToeViewText() {
        board = new String[3][3];
        createBoard(board);
        showBoard(board);
        userInput();
        getRow();
        getCol();
    }


    public static void breakln() {
        System.out.println("_____________________________________");
        System.out.println("Game Board layout: ");
        //System.out.println("     columns");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");

        System.out.println("");
    }

    public static void createBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }

    public static void showBoard(String[][] board) {
        breakln();
        for (int r = 0; r < board.length; r++) {
            if (DEBUG == true) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(" " + board[r][c]);
                }
                System.out.println("");
            } else {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c].equals("S")) {
                        System.out.print(" " + "-");
                    } else {
                        System.out.print(" " + board[r][c]);
                    }
                }
                System.out.println("");
            }
        }
        breakln();
    }

    @Override
    public void userInput() {
        Scanner input = new Scanner(System.in);
        int pos;
        System.out.println("Select a space to play in: ");
        pos = input.nextInt();

        if (pos == 1) {
            row = 1;
            col = 1;
        } else if (pos == 2) {
            row = 1;
            col = 2;
        } else if (pos == 3) {
            row = 1;
            col = 3;
        } else if (pos == 4) {
            row = 2;
            col = 1;
        } else if (pos == 5) {
            row = 2;
            col = 2;
        } else if (pos == 6) {
            row = 2;
            col = 3;
        } else if (pos == 7) {
            row = 3;
            col = 1;
        } else if (pos == 8) {
            row = 3;
            col = 2;
        } else if (pos == 9) {
            row = 3;
            col = 3;
        } else {
            displayOutOfBoundsError();
        }
    }

    /**
     * gets the row of the user input
     *
     * @return int row
     */
    public int getRow() {
        System.out.println("Row: " + row);
        return row;
    }

    /**
     * gets the column of the user input
     *
     * @return int col
     */
    public int getCol() {
        System.out.println("Col: " + col);
        return col;
    }

    @Override
    public void displayNonEmptySpotError() {
        System.out.println("Error: This not an empty space.");

    }

    @Override
    public void displayOutOfBoundsError() {
        // if the user selects a value that is not between 1 and 9
        System.out.println("Error: That is not a valid spot on the game board!");
    }


    @Override
    public void switchToPlayerX() {
        //assuming we always start with player X
        // at beginning of game
        System.out.println("Player X's turn!");
    }

    @Override
    public void switchToPlayerO() {
        // assuming turn count starts at 0 and increments after a player has played their turn
        // if turn count is odd
        System.out.println("Player O's turn");
    }

    @Override
    public void updateBoardForX(Coordinates coords) {
        board[coords.getRow()][coords.getColumn()] = "X";

    }


    @Override
    public void updateBoardForO(Coordinates coords) {
        board[coords.getRow()][coords.getColumn()] = "O";
    }


    @Override
    public void gameOutcomeMessage() {
        // If player X wins
        System.out.println("Player X wins!");
        // If player Y wins
        System.out.println("Player Y wins!");
        // If neither player wins
        System.out.println("It's a draw!");
    }

}
