package Controller

class ControllerImpl(val view: BattleshipView):Controller{
    init {
        view.setController(this)

    }
    override fun hitCoordinate(coordinates: String) {

    }
}