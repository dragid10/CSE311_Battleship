package view;

import model.Coordinates;

public interface TicTacToeView {

    /**
     * Plays through a round of the game
     *
     * @param currPlayer the player whose turn it is
     */
    void playGame(int currPlayer);

    /**
     * Displays an error if the spot is not empty
     */
    void displayNonEmptySpotError();

    /**
     * Displays an error if the input is out of bounds
     */
    void displayOutOfBoundsError();

    /**
     * Switches to player X
     *
     * @return the player as an int
     */
    int switchToPlayerX();

    /**
     * Switches to player O
     *
     * @return the player as an int
     */
    int switchToPlayerO();

    /**
     * Places "X" at the spot
     *
     * @param coords the coordinates to place X at
     * @return a true if it was update, false otherwise
     */
    boolean updateBoardForX(Coordinates coords);

    /**
     * Places "O" at the spot
     *
     * @param coords the coordinates to place O at
     * @return a true if it was update, false otherwise
     */
    boolean updateBoardForO(Coordinates coords);

    /**
     * Print out who won the game
     *
     * @param currPlayer checks to see the current player
     */
    void displayWhoWon(int currPlayer);

    /**
     * End the game
     */
    void endGame();
}
