package model


class Grid {

    private val grid: HashMap<Coordinates, Int>

    /**
     * Returns the current "owner" of the cell. 1 for Player X, 2 for Player O and 0 if the cell is empty.
     *
     * @param coords The coordinates for the requested cell.
     */
    fun getCellStatus(coords: Coordinates): Int? {
        return grid[coords]
    }

    /**
     * Used to give "ownership" of a cell to a player after they've made a move.
     *
     * @param coords The coordinates of the player's move.
     * @param player The current player.
     */
    fun setCellStatus(coords: Coordinates, player: Int) {
        grid[coords] = player
    }

    /**
     * Initializes a 3x3 grid-like Hash Map with key being the Coordinate data type and the value
     * being the ownership of the cell.
     *
     * @return Hash Map
     */
    private fun initGrid(): HashMap<Coordinates, Int> {

        val newGrid = HashMap<Coordinates, Int>()
        for (i in 1..3) {
            for (j in 1..3) {
                val coords = Coordinates(i, j)
                newGrid[coords] = 0
            }
        }
        return newGrid
    }

    /**
     * Initializer for the Grid object.
     */
    init {
        grid = initGrid()
    }
}

