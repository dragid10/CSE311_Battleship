package model

//class Grid(gridCoords: Coordinates) {
class Grid {
    private val grid = hashMapOf<Coordinates, Int>()

    init {
//        initGrid(gridCoords)
        initGrid()
    }

    fun isFree(coords: Coordinates): Boolean {
        val retVal = grid[coords]?.let {
            println("Row: ${coords.row}\nCol: ${coords.column}")
            grid[coords]?.toInt() == 0

        } ?: false
        return retVal
    }

    fun getCellStatus(coords: Coordinates): Int? {
        return grid[coords]
    }

    fun setCellStatus(coords: Coordinates, player: Int) {
        grid[coords] = player
    }

    private fun initGrid() {
        for (i in 1..3) {
            for (j in 1..3) {
                val coords = Coordinates(i, j)
                grid[coords] = 0
            }
        }
    }
}

