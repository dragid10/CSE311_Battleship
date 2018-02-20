package view;

import model.Coordinates;

import java.util.Scanner;

public class TicTacToeViewText implements TicTacToeView {
    Scanner input = new Scanner(System.in);
    private static final boolean DEBUG = false;
    private final String[][] board;
    private int row;
    private int col;

    public TicTacToeViewText() {
        board = new String[3][3];
        createBoard(board);
        showBoard(board);
    }


    private static void showBoard(String[][] board) {
        breakln();
        for (String[] aBoard : board) {
            if (DEBUG) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(" " + aBoard[c]);
                }
                System.out.println("");
            } else {
                for (int c = 0; c < board[0].length; c++) {
                    if (aBoard[c].equals("S")) {
                        System.out.print(" " + "-");
                    } else {
                        System.out.print(" " + aBoard[c]);
                    }
                }
                System.out.println("");
            }
        }
        breakln();
    }

    private static void breakln() {
        System.out.println("_____________________________________");
        System.out.println("Game Board layout: ");
        //System.out.println("     columns");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");

        System.out.println("");
    }

    private static void createBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }

    @Override
    public void playGame(int currPlayer) {
        for (int i = 0; i < 9; i++) {
            userInput();
            Coordinates coords = new Coordinates(getRow(), getCol());
            updateBoard(currPlayer, coords);
            updateUI();
            checkIfPlayerWon(currPlayer);
            if (currPlayer == 1) currPlayer = switchToPlayerO();
            else currPlayer = switchToPlayerX();
        }
    }

    private void checkIfPlayerWon(int currPlayer) {


    }

    private void updateUI() {
        showBoard(board);
    }

    private void updateBoard(int currPlayer, Coordinates coords) {
        if (currPlayer == 1) updateBoardForX(coords);
        else updateBoardForO(coords);
    }

    public void userInput() {
        Scanner input = new Scanner(System.in);
        int pos;
        System.out.println("Select a space to play in: ");
        pos = input.nextInt();

        switch (pos) {
            case 1:
                row = 1;
                col = 1;
                break;
            case 2:
                row = 1;
                col = 2;
                break;
            case 3:
                row = 1;
                col = 3;
                break;
            case 4:
                row = 2;
                col = 1;
                break;
            case 5:
                row = 2;
                col = 2;
                break;
            case 6:
                row = 2;
                col = 3;
                break;
            case 7:
                row = 3;
                col = 1;
                break;
            case 8:
                row = 3;
                col = 2;
                break;
            case 9:
                row = 3;
                col = 3;
                break;
            default:
                displayOutOfBoundsError();
                break;
        }
    }

    /**
     * gets the row of the user input
     *
     * @return int row
     */
    private int getRow() {
        System.out.println("Row: " + row);
        return row;
    }

    /**
     * gets the col of the user input
     *
     * @return int col
     */
    private int getCol() {
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
    public int switchToPlayerX() {
        //assuming we always start with player X
        // at beginning of game
        System.out.println("Player X's turn!");
        return 1;
    }

    @Override
    public int switchToPlayerO() {
        // assuming turn count starts at 0 and increments after a player has played their turn
        // if turn count is odd
        System.out.println("Player O's turn");
        return 2;
    }

    @Override
    public void updateBoardForX(Coordinates coords) {
        board[coords.getRow() - 1][coords.getCol() - 1] = "X";

    }


    @Override
    public void updateBoardForO(Coordinates coords) {
        board[coords.getRow() - 1][coords.getCol() - 1] = "O";
    }

    @Override
    public void displayWhoWon(int currPlayer) {
        switch (currPlayer) {
            case 1: //if player X wins
                System.out.println("Player X wins!");
                break;

            case 2:
                //if player o wins
                System.out.println("Player O wins!");
                break;

            default:         //if it is a draw
                System.out.println("It's a draw!");
                break;
        }
        endGame();
    }

    @Override
    public void endGame() {
        System.exit(0);
    }
}
