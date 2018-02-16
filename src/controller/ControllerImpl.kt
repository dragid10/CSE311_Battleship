package controller

import model.Player
import view.TicTacToeView

class ControllerImpl(private val view: TicTacToeView) : Controller {
    // ========================= Member Variables =========================
    lateinit var player1: Player
    lateinit var player2: Player

    // ========================= Overridden Functions =========================
    override fun startGame() {
        playGame()
    }


    override fun takeSpot(coordinate: String) {

    }

    // ========================= Member Functions =========================
    private fun playGame() {

    }
}