package model

class Grid{

    var gridCoords: HashMap<Coordinates, String>
    var gridOwner: Player

    val gridSize = 10;

    constructor(gridOwner: Player) {
        gridCoords = HashMap<Coordinates, String>()
        this.gridOwner = gridOwner
    }

        fun attack(coords: Coordinates) {
            if(gridCoords.containsKey(coords)) {
                if(gridCoords.get(coords) == "Not guessed") {

                }
            }

        }

    fun getCellStatus(coords: Coordinates): String? {
        return gridCoords.get(coords);
    }


}

