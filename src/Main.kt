import controller.ControllerImpl
import view.TicTacToeViewGUI
import view.TicTacToeViewText
import javax.swing.JFrame
import javax.swing.JOptionPane

fun main(args: Array<String>) {

    val frame = JFrame()
    //Custom button text
    val options = arrayOf<Any>("GUI View", "Text View")
    val n = JOptionPane.showOptionDialog(frame,
            "What view would you like to play Battleship in?",
            "View Selection",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0])

    val ticTacToeController: ControllerImpl
    if (n == 0) {
//        val gui = TicTacToeViewGUI()
        val gameFrame = JFrame()
        val gui = TicTacToeViewGUI()
        ticTacToeController = ControllerImpl(gui)
    } else {
        println("You chose the text view")
        val text = TicTacToeViewText()
        ticTacToeController = ControllerImpl(text)
    }
    ticTacToeController.startGame()
}