package view;

public interface TicTacToeView {

    /**
     * Display hit on ship
     *
     * @param x
     * @param y
     */
    void updateBoardAsHit(int x, int y);

    /**
     * Display miss fire in water
     *
     * @param x
     * @param y
     */
    void updateBoardAsMiss(int x, int y);

    void displayNonEmptySpotError();

    void switchPlayer();

    /**
     * Display a sunken ship
     *
     * @param A ship
     */
    //public void displaySunkenShip(Ship ship);
}
