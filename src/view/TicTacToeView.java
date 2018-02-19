package view;

public interface TicTacToeView {

    void displayNonEmptySpotError();

    void displayOutOfBoundsError();

    void switchPlayer();

    void updateBoardForX(int x, int y);

    void updateBoardForO(int x, int y);

    void gameOutcomeMessage();

    void userInput();

}
