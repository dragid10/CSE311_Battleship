package model

import java.util.*

class Game {

    var gameGrid : Grid = Grid()

    // Used for checking if a player has won
    val gridSize = 3

    var gameOver = false


    fun main(args: Array<String>) {

        while(!gameOver) {


            print("Please input your move: ")


            val input = Scanner(System.`in`)
            val x = input.nextInt()
            val y = input.nextInt()
            val playerMove: Coordinates = Coordinates(x, y)


            gameOver = gameGrid.hasWon(currPlayer)
        }

    }

}