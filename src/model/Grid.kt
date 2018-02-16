package model

class Grid(val gridCoords: HashMap<Coordinates, Int>) {
//    val gridSize = 3

    init {
        initGrid(gridCoords)
    }

    private fun getCellStatus(coords: Coordinates): Int? {
        return gridCoords[coords]
    }

    private fun setCellStatus(coords: Coordinates, player: Int) {
        if (getCellStatus(coords) == 0) {
            gridCoords[coords] = player
        }
    }

    private fun initGrid(gridCoords: HashMap<Coordinates, Int>) {
        for (i in 1..3) {
            for (j in i..3) {
                var coords = Coordinates(i, j)
                gridCoords[coords] = 0
            }
        }
    }
}

