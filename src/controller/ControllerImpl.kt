package controller

import view.TicTacToeView

class ControllerImpl(private val view: TicTacToeView) : Controller {
    //    Member Variables
    lateinit var player1: Player
    lateinit var player2: Player

    //    Constructor
    init {
        view.setController(this)
    }

    //    Overridden Functions

    override fun startGame() {

    }

    override fun takeSpot(coordinate: String) {

    }

    //    Member Functions

    /**
     * This method initializes the game, by randomizing player's ship locations, and setting up the game board
     * @param
     * @return Void
     */
    fun setupGame() {
//        Create Players 1 & 2
        createPlayers()

//        Create gameboard
        TODO("Do Swing GUI stuff here eventually")
    }

    private fun createPlayers() {
        player1 = Player()
        player2 = Player()
    }
}