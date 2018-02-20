package controller

import model.Coordinates
import model.Game
import model.Grid
import view.TicTacToeView
import view.TicTacToeViewText

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    //val = immutable
    //var = mutable
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

    private fun doTextGame() {

    }


    override fun takeSpot(row: Int, column: Int) {
        currPlayer = game.currPlayer
        coordinates = Coordinates(row, column)
        if (grid.getCellStatus(coordinates) == 0) {
            grid.setCellStatus(coordinates, currPlayer)
            if (isPlayerOne()) view.updateBoardForX(coordinates) else view.updateBoardForO(coordinates)
        } else {
            view.displayNonEmptySpotError()
        }
        checkIfGameWon()
        changePlayer()
    }

    // ========================= Member Functions =========================
    private fun playGame() {
//        Set the current user
//        setCurrentPlayer()

//        After the user makes their move, check if the user has won the game
//        checkIfGameWon()
    }

    private fun setCurrentPlayer() {
        currPlayer = game.currPlayer
    }

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

    private fun updateTurnCount() {
        ++game.turnCount
    }

    private fun changePlayer() {
        if (currPlayer == 1) game.updatePlayer(2)
        else game.updatePlayer(1)
    }

    private fun isPlayerOne(): Boolean {
        return currPlayer == 1
    }

    private fun endGame() {
        // Tell view a player has won
        // Close stuff??
        view.displayWhoWon(currPlayer)
        view.endGame()
    }
}