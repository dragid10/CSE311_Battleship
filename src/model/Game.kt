package model

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
    var gameOver = false

    fun updatePlayer(newPlayer: Int) {
        if (newPlayer == 1 || newPlayer == 2)
            turnCount = newPlayer
    }

    fun checkIfWon(grid: Grid, player: Int): Boolean {

        for (i in 1..3) {
        }

        return false
    }
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
//            val playerMove: Coordinates = Coordinates(x, y)
//
//
//            if (gameGrid.isFree(playerMove)) {
//                if (turnCount % 2 == 1) {
//                    gameGrid.setCellStatus(playerMove, PLAYER_X)
//                } else {
//                    gameGrid.setCellStatus(playerMove, PLAYER_O)
//                }
//            }
//
//            gameOver = gameGrid.hasWon(currPlayer)
//        }
//    }
}