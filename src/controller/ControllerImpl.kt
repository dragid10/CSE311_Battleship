package controller

import model.Coordinates
import model.Game
import model.Grid
import view.TicTacToeView

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    //val = immutable
    //var = mutable
    private val grid = Grid()
    private val game = Game()
    private var currPlayer = -1
    lateinit var coordinates: Coordinates


    // ========================= Overridden Functions =========================
    override fun startGame() {
        playGame()
    }


    override fun takeSpot(row: Int, column: Int) {
        currPlayer = game.currPlayer
        coordinates = Coordinates(row, column)
        if (grid.isFree(coordinates)) {
            grid.setCellStatus(coordinates, currPlayer)
        } else {
            view.displayNonEmptySpotError()
        }
    }

    // ========================= Member Functions =========================
    private fun playGame() {
        //user asked for move
        //Ask view for user input
        //view take input

//        Set the current user
        currPlayer = game.currPlayer
//        Ask the player to make their move
//        view.userInput()
//        After the user makes their move, check if the user has won the game
        if (game.checkIfWon(grid, currPlayer)) {
            endGame()
        } else {
            changePlayer()
            if (isPlayerOne()) view.switchToPlayerX()
            else view.switchToPlayerO()
        }
    }

    private fun changePlayer() {
        if (currPlayer == 1) game.updatePlayer(2)
        else game.updatePlayer(1)
    }

    private fun isPlayerOne(): Boolean {
        return currPlayer == 1
    }

    private fun endGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}