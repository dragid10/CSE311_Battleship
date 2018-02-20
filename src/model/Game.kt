package model

class Game(private val gameGrid: Grid) {

    // These values are used for determining who is making a move and who has won.
    private val EMPTY_CELL = 0
    private val PLAYER_X = 1
    private val PLAYER_O = 2

    // Used for which player is currently making a move.
    var currPlayer = 1

    // Determines if the game ended in a Draw (0) or if Player X (1) or Player O (2) won.
    private var winner = 0

    // Used to see if a player has won during their turn.
    private var playerWon = false

    // Used to see if the game has ended after a turn.
    private var gameOver = false

    // Used for determining which player goes next and if there is a tie.
    var turnCount = 1

    /**
     * Uses the currently player's move to determine if they won during their turn.
     * Checks the row and col the last move was made in and checks the two diagonals.
     * If all of the cells in a row, col, diagonal, or reverse diagonal are owned
     * by the player, then the player has won the game.     *
     *
     * @param currPlayer The player who is currently taking their turn.
     * @param lastMove The move the current player just made.
     * @return If the player has won the game.
     */
    fun hasWon(currPlayer: Int, lastMove: Coordinates): Boolean {
        val row = lastMove.row
        val col = lastMove.col

        var playerWon = false

        // Checks row win.
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(row, n)) != currPlayer) {
                break
            } else if (n == 3) {
                return true
            }
        }

        // Checks col win.
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(n, col)) != currPlayer) {
                break
            } else if (n == 3) {
                return true
            }
        }

        // Checks diagonal win.
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(n, n)) != currPlayer) {
                break
            } else if (n == 3) {
                return true
            }
        }

        // Checks reverse diagonal win.
        for (n in 1..3) {
            if (gameGrid.getCellStatus(Coordinates(4 - n, n)) != currPlayer) {
                break
            } else if (n == 3) {
                return true
            }
        }

        // If none of the win conditions return true. The player didn't won.
        return false
    }

    fun updatePlayer(newPlayer: Int) {
        currPlayer = newPlayer
    }


}