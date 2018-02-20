package view;

import model.Coordinates;

public interface TicTacToeView {

    void displayNonEmptySpotError();

    void displayOutOfBoundsError();

    void switchToPlayerX();

    void switchToPlayerO();

    void updateBoardForX(Coordinates coords);

    void updateBoardForO(Coordinates coords);

    void displayWhoWon(int currPlayer);

    void endGame();
}
