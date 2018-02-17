package controller

import model.Coordinates
import model.Game
import model.Grid
import model.Player
import view.TicTacToeView

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    lateinit var player1: Player
    //val = immutable
    //var = mutable
    val grid = Grid()
    val game = Game()
    lateinit var coordinates: Coordinates



    // ========================= Overridden Functions =========================
    override fun startGame() {
        playGame()
    }


    override fun takeSpot(row: Int, column: Int ) {
        coordinates = Coordinates(row,column)
        
    }

    // ========================= Member Functions =========================
    private fun playGame() {
        //user asked for move
        //Ask view for user input
        //view take input

        takeSpot()

    }
}