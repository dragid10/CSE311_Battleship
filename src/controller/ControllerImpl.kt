package controller

import model.Coordinates
import model.Game
import model.Grid
import view.TicTacToeView

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    lateinit var player: Player
    //val = immutable
    //var = mutable
    val grid = Grid()
    val game = Game()
    lateinit var coordinates: Coordinates

    // These values are used for determining who is making a move and who has won.
    val EMPTY_CELL = 0
    val PLAYER_X =   1
    val PLAYER_O =   2

    var turnCount = 1

    var currPlayer = PLAYER_X

    var gameOver = false



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
        if (turnCount % 2 == 1) {
            println("Player X's turn.")
            currPlayer = PLAYER_X
        } else {
            println("Player O's turn.")
            currPlayer = PLAYER_O
        }
    }

    private fun endGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}