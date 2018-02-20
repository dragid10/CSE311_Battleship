package view;

import model.Coordinates;

public interface TicTacToeView {

    void playGame(int currPlayer);

    void displayNonEmptySpotError();

    void displayOutOfBoundsError();

    int switchToPlayerX();

    int switchToPlayerO();

    void updateBoardForX(Coordinates coords);

    void updateBoardForO(Coordinates coords);

    void displayWhoWon(int currPlayer);

    void endGame();
}
