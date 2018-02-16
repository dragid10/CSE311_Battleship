package model

class Grid{

    var gridCoords: HashMap<Coordinates, Int>
    var gridOwner: Player

    val gridSize = 3;

    constructor(gridOwner: Player) {
        gridCoords = HashMap<Coordinates, Int>()
        this.gridOwner = gridOwner
    }

    fun getCellStatus(coords: Coordinates): Int? {
        return gridCoords.get(coords);
    }

    fun setCellStatus(coords: Coordinates): {
        if(getCellStatus(coords) == 0)
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

