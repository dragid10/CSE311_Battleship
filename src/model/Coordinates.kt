package model

/**
 * This class is used to define a Coordinates data type. It will be useful
 * for the Grids' and Ships' Hash Map keys.
 */
class Coordinates(val row: Int, val col: Int) {
    override fun equals(other: Any?): Boolean {
        return other?.let {
            other as Coordinates
            other.row == row && other.col == col
        } ?: false
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + col
        return result
    }
}