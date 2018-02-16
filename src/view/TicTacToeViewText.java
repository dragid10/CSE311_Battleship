package view;

import controller.ControllerImpl;

import java.util.Scanner;

public class TicTacToeViewText implements TicTacToeView {
    Scanner input = new Scanner(System.in);
    public static final boolean DEBUG = false;
    String[][] board;

    public TicTacToeViewText(int numRows, int numCols) {
        board = new String[numRows][numCols];
        createBoard(board);
        showBoard(board);
    }


    public static void breakln() {
        System.out.println("_____________________________________");
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
    public void setController(ControllerImpl controller) {

    }

    @Override
    public void updateBoardAsHit(int x, int y) {
        // TODO Auto-generated method stub
        board[x][y] = "*";

    }

    @Override
    public void updateBoardAsMiss(int x, int y) {
        // TODO Auto-generated method stub
        board[x][y] = "M";

    }
}
