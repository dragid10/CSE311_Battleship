package controller

import view.BattleshipView

class ControllerImpl(private val view: BattleshipView) : Controller {
    //    Member Variables
    lateinit var player1: Player
    lateinit var player2: Player

    //    Constructor
    init {
        view.setController(this)
    }

    //    Overridden Functions
    override fun hitCoordinate(coordinates: String) {

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