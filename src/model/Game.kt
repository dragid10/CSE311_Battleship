package model

import java.util.*

class Game {

    // These values are used for determining who is making a move and who has won.
    val EMPTY_CELL = 0
    val PLAYER_X =   1
    val PLAYER_O =   2

    var turnCount = 1;

    fun main(args: Array<String>) {

        with(Scanner(System.`in`)) {
            val x = nextInt()
            val y = nextInt()
            val playerMove = Coordinates(x,y)
        }


    }

    fun gameOver() {
    }

}