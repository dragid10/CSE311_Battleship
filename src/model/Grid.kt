package model


class Grid {

    private val grid: HashMap<Coordinates, Int>

    constructor() {
        grid = initGrid()
    }

    fun getCellStatus(coords: Coordinates): Int? {
        return grid[coords]
    }

    fun setCellStatus(coords: Coordinates, player: Int) {
            grid[coords] = player
    }

    private fun initGrid(): HashMap<Coordinates, Int> {
        for (i in 1..3) {
            for (j in 1..3) {
                val coords = Coordinates(i, j)
                grid[coords] = 0
            }
        }
    }
}

