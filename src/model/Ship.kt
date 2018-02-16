package model

class Ship{

    var sunkStatus: Boolean
    var shipLocation: HashMap<Coordinates, String>


    constructor(name: String, size: Int) {
        shipLocation = HashMap<Coordinates, String>()
        sunkStatus = false

    }

    fun attack(coords: Coordinates): Boolean {

        // If the coordinates are in the ship location hash map, the ship /must/ be there.
        if(shipLocation.contains(coords)) {
            // Remove the ship/ship part from the hash map.
            shipLocation.remove(coords);

            // The attack was a success.
            return true;
        }

        // If the ship location's hash map doesn't contain the coordinates, a ship isn't there.
        // the attack is a failure.
        return false;

    }

    fun isSunk(): Boolean {
        return sunkStatus
    }

}