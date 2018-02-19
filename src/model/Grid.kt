package model

//class Grid(gridCoords: Coordinates) {
class Grid {
    private val grid = hashMapOf<Coordinates, Int>()

    init {
//        initGrid(gridCoords)
        initGrid()
    }

    fun isFree(coords: Coordinates): Boolean {
        return grid[coords]?.let {
            println("Row: ${coords.row}\nCol: ${coords.col}")
            grid[coords] == 0

        } ?: false
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

