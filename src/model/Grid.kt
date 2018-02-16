package model

class Grid{

    var gridCoords: HashMap<Coordinates, Int>

    val gridSize = 3;

    constructor() {
        gridCoords = initGrid()
    }

    fun getCellStatus(coords: Coordinates): Int? {
        return gridCoords.get(coords);
    }

    fun setCellStatus(coords: Coordinates, player: Int): {
        if(getCellStatus(coords) == 0) {
            gridCoords.set(coords, player)
        }
    }

    fun initGrid(): HashMap<Coordinates, Int> {
        for(i in 1..3) {
            for(j in i..3) {
                var coords : Coordinates = Coordinates(i,j)
                gridCoords.put(coords, 0)
            }
        }
    }


}

