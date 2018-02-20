package controller

interface Controller {
    /**
     * Starts the game
     */
    fun startGame()

    /**
     * Takes the spot on the board
     * @param row the row to place the player at
     * @param column the row to place the player at
     */
    fun takeSpot(row: Int, column: Int)
}