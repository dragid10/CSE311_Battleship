package model

class Game {

    // These values are used for determining who is making a move and who has won.
    val EMPTY_CELL = 0
    private val PLAYER_X = 1
    private val PLAYER_O = 2
    var turnCount = 1
    var gameGrid: Grid = Grid()

    // Used for checking if a player has won
    var currPlayer = 1
    var winner = 0
    var playerWon = false
    var gameOver = false

//    fun main(args: Array<String>) {
//
//        while (!gameOver) {
//
//            if (turnCount % 2 == 1) {
//                println("Player X's turn.")
//                currPlayer = PLAYER_X
//            } else {
//                println("Player O's turn.")
//                currPlayer = PLAYER_O
//            }
//
//            print("Please input your move: ")
//
//            val input = Scanner(System.`in`)
//            val x = input.nextInt()
//            val y = input.nextInt()
//            val lastMove = Coordinates(x, y)
//
//            if (gameGrid.getCellStatus(lastMove) == EMPTY_CELL) {
//                gameGrid.setCellStatus(lastMove, currPlayer)
//
//                playerWon = hasWon(currPlayer, lastMove)
//
//                if (playerWon) {
//                    gameOver = true
//                    winner = currPlayer
//                } else if (!playerWon && turnCount == 9) {
//                    gameOver = true
//                    winner = 0
//                } else {
//                    turnCount++
//
//                }
//            }
//        }
//    }

    fun hasWon(currPlayer: Int, lastMove: Coordinates): Boolean {

        val row = lastMove.row
        val col = lastMove.column

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

    fun updatePlayer(newPlayer: Int) {
        currPlayer = newPlayer
    }

}