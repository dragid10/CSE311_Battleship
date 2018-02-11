package controller

import view.BattleshipView

class ControllerImpl(private val view: BattleshipView) : Controller {
    init {
        view.setController(this)
    }

    override fun hitCoordinate(coordinates: String) {

    }
}