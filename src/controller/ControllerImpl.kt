package controller

import model.Coordinates
import model.Game
import model.Grid
import model.Player
import view.TicTacToeView
import kotlin.coroutines.experimental.suspendCoroutine

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    lateinit var player: Player
    //val = immutable
    //var = mutable
    val grid = Grid()
    val game = Game()
    lateinit var coordinates: Coordinates


    // ========================= Overridden Functions =========================
    override fun startGame() {
        playGame()
    }


    override fun takeSpot(row: Int, column: Int) {
        coordinates = Coordinates(row, column)
        if (grid.getCellStatus(coordinates) == 0)
            grid.setCellStatus(coordinates)
        else
            view.displayNonEmptySpotError()


    }

    // ========================= Member Functions =========================
    private fun playGame() {

        if (game.checkIfWon(grid, player)) {
            endGame()
        } else {
            changePlayer()
            view.switchPlayer()
        }


    }

    private fun changePlayer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun endGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}