package view;

public interface TicTacToeView {

    void displayNonEmptySpotError();

    void displayOutOfBoundsError();

    void switchToPlayerX();

    void switchToPlayerO();

    void updateBoardForX(int x, int y);

    void updateBoardForO(int x, int y);

    void gameOutcomeMessage();

    void userInput();

}
