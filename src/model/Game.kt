package model

import java.util.*

class Game {

    // These values are used for determining who is making a move and who has won.
    val EMPTY_CELL = 0
    private val PLAYER_X = 1
    private val PLAYER_O = 2
    var turnCount = 1
    var gameGrid: Grid = Grid()

    // Used for checking if a player has won
//    val gridSize = 3
    var currPlayer = PLAYER_X
    var winner = 0
    var gameOver = false

    fun main(args: Array<String>) {

        while (!gameOver) {

            if (turnCount % 2 == 1) {
                println("Player X's turn.")
                currPlayer = PLAYER_X
            } else {
                println("Player O's turn.")
                currPlayer = PLAYER_O
            }

            print("Please input your move: ")

            val input = Scanner(System.`in`)
            val x = input.nextInt()
            val y = input.nextInt()
            val lastMove = Coordinates(x, y)


            if (gameGrid.isFree(lastMove)) {
                if (turnCount % 2 == 1) {
                    gameGrid.setCellStatus(lastMove, PLAYER_X)
                } else {
                    gameGrid.setCellStatus(lastMove, PLAYER_O)
                }
            }

            gameOver = hasWon(currPlayer, lastMove)

            if (!gameOver && turnCount == 9) {
                gameOver = true
                winner = 0
            }


        }
    }


    fun hasWon(currPlayer: Int, lastMove: Coordinates): Boolean {

        val row = lastMove.row
        val col = lastMove.col

        // Check row win
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(n, col)) != currPlayer) {
                break
            } else {
                return true
            }
        }

        // Check col win
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(row, n)) != currPlayer) {
                break
            } else {
                return true
            }
        }

        // Check diagonal win
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(n, n)) != currPlayer) {
                break
            } else {
                return true
            }
        }

        // Check reverse diagonal win
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(4 - n, n)) != currPlayer) {
                break
            } else {
                return true
            }
        }

        // If none of the win conditions return true. No one won. Return false.
        return false
    }

}