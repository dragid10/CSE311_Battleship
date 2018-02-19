package model

import java.util.*

class Game {

    var gameGrid : Grid = Grid()

    // Used for checking if a player has won
    val gridSize = 3

    var gameOver = false

    // These values are used for determining who is making a move and who has won.
    val EMPTY_CELL = 0
    val PLAYER_X =   1
    val PLAYER_O =   2

    var winner = 0

    var turnCount = 1


    var currPlayer = PLAYER_X


    fun main(args: Array<String>) {

        while(!gameOver) {


            print("Please input your move: ")


            val input = Scanner(System.`in`)
            val x = input.nextInt()
            val y = input.nextInt()
            val playerMove: Coordinates = Coordinates(x, y)


            gameOver = hasWon(gameGrid, currPlayer)

            if(gameOver) {
                winner = currPlayer

            }

            if(turnCount == 9 && !gameOver) {
                gameOver = true;
            }
        }

    }

    fun hasWon(currGrid : Grid, currPlayer : Int) : Boolean {


        return false
    }

}