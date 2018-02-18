package controller

interface Controller {
    fun startGame()
    fun takeSpot(row: Int, column: Int)
}