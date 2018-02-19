package model

/**
 * This class is used to define a Coordinates data type. It will be useful
 * for the Grids' and Ships' Hash Map keys.
 */
class Coordinates(val row: Int, val column: Int) {
    override fun equals(other: Any?): Boolean {
        val equals = other?.let {
            other as Coordinates
            other.row == this.row && other.column == this.column
        } ?: false
        return equals
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        return result
    }
}