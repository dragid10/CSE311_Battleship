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

    /**
     * Prints out the current board view
     *
     * @param board the board to print out
     */
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

    /**
     * Prints out the moves a user can make
     */
    private static void breakln() {
        System.out.println("_____________________________________");
        System.out.println("Game Board layout: ");
        //System.out.println("     columns");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");

        System.out.println("");
    }

    /**
     * Creates and initializes the gameboard
     *
     * @param board 2D array containing the board
     */
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
            Coordinates coords;
            coords = new Coordinates(getRow(), getCol());
            while (!updateBoard(currPlayer, coords)) {
                userInput();
                coords = new Coordinates(getRow(), getCol());
//                updateBoard(currPlayer, coords);
            }
            updateUI();
            if (checkIfPlayerWon(currPlayer, coords)) {
                displayWhoWon(currPlayer);
            } else {
                if (currPlayer == 1) currPlayer = switchToPlayerO();
                else currPlayer = switchToPlayerX();
            }
        }

        displayWhoWon(0);
    }

    /**
     * Uses the currently player's move to determine if they won during their turn.
     * Checks the row and col the last move was made in and checks the two diagonals.
     * If all of the cells in a row, col, diagonal, or reverse diagonal are owned
     * by the player, then the player has won the game.
     *
     * @param currPlayer The player who is currently taking their turn.
     * @param lastMove   The move the current player just made.
     * @return If the player has won the game.
     */
    private boolean checkIfPlayerWon(int currPlayer, Coordinates lastMove) {
        int row = lastMove.getRow() - 1;
        int col = lastMove.getCol() - 1;
        String currPlayerSymbol = currPlayer == 1 ? "X" : "O";

        for (int i = 0; i < 3; i++) {
            if (!board[row][i].equals(currPlayerSymbol)) {
                break;
            } else if (i == 2) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!board[i][col].equals(currPlayerSymbol)) {
                break;
            } else if (i == 2) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!board[i][i].equals(currPlayerSymbol)) {
                break;
            } else if (i == 2) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!board[2 - i][i].equals(currPlayerSymbol)) {
                break;
            } else if (i == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Iterates through the gameboard array to display it
     */
    private void updateUI() {
        showBoard(board);
    }


    /**
     * Updates the gameboard with the move that the last player just made
     *
     * @param currPlayer The player who is currently taking their turn.
     * @param coords     The move the current player just made.
     */
    private boolean updateBoard(int currPlayer, Coordinates coords) {
        boolean updated;
        if (currPlayer == 1) {
            updated = updateBoardForX(coords);
        } else {
            updated = updateBoardForO(coords);
        }

        return updated;
    }

    /**
     * Takes in input from the user in order to make a move
     */
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
        return row;
    }

    /**
     * gets the col of the user input
     *
     * @return int col
     */
    private int getCol() {
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
    public boolean updateBoardForX(Coordinates coords) {
        if (board[coords.getRow() - 1][coords.getCol() - 1].equals("-")) {
            board[coords.getRow() - 1][coords.getCol() - 1] = "X";
            return true;
        }
        System.out.println("Spot already taken, choose a new spot!");
        return false;
    }


    @Override
    public boolean updateBoardForO(Coordinates coords) {
        if (board[coords.getRow() - 1][coords.getCol() - 1].equals("-")) {
            board[coords.getRow() - 1][coords.getCol() - 1] = "O";
            return true;
        }
        System.out.println("Spot already taken, choose a new spot!");
        return false;
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
