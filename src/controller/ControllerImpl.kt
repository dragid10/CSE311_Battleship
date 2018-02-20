package controller

import model.Coordinates
import model.Game
import model.Grid
import view.TicTacToeView
import view.TicTacToeViewText

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    private val grid = Grid()
    private val game = Game(grid)
    private var currPlayer = -1
    private lateinit var coordinates: Coordinates


    // ========================= Overridden Functions =========================
    override fun startGame() {
        setCurrentPlayer()
        if (view is TicTacToeViewText) {
            doTextGame()
        }
    }

    override fun takeSpot(row: Int, column: Int) {
//        Sets the current player
        currPlayer = game.currPlayer

//        Gets the row and column as a coordinate
        coordinates = Coordinates(row, column)

//        Checks to see if that space is filled in map
        if (grid.getCellStatus(coordinates) == 0) {
            grid.setCellStatus(coordinates, currPlayer)
            if (isPlayerOne()) view.updateBoardForX(coordinates) else view.updateBoardForO(coordinates)
        } else {
            view.displayNonEmptySpotError()
        }

//        Checks if game if won, and if not changes player
        checkIfGameWon()
        changePlayer()
    }

    // ========================= Member Functions =========================
    /**
     * Sets the current player to the player X
     */
    private fun setCurrentPlayer() {
        currPlayer = game.currPlayer
    }

    /**
     * Plays the text-based version of the game
     */
    private fun doTextGame() {
        view.playGame(currPlayer)
    }

    /**
     * Checks if the game ahs been won by a player (hor, vert, diag)
     */
    private fun checkIfGameWon() {
        if (game.hasWon(currPlayer, coordinates)) {
            endGame()
        } else if (game.turnCount == 9) {
            currPlayer = 0
            endGame()
        } else {
            changePlayer()
            updateTurnCount()
            if (isPlayerOne()) view.switchToPlayerX()
            else view.switchToPlayerO()
        }
    }

    /**
     * Updates the turn count for the game
     */
    private fun updateTurnCount() {
        ++game.turnCount
    }

    /**
     * Changes players x to o or o to x
     */
    private fun changePlayer() {
        if (currPlayer == 1) game.updatePlayer(2)
        else game.updatePlayer(1)
    }

    /**
     * Checks to see if the currplayer is player 1
     */
    private fun isPlayerOne(): Boolean {
        return currPlayer == 1
    }

    /**
     * Ends the game by closing it
     */
    private fun endGame() {
        view.displayWhoWon(currPlayer)
        view.endGame()
    }
}