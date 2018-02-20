import controller.ControllerImpl
import view.TicTacToeViewGUI
import view.TicTacToeViewText
import javax.swing.JFrame
import javax.swing.JOptionPane

fun main(args: Array<String>) {

//    Create JFrame stuff
    val frame = JFrame()
    //Custom button text
    val options = arrayOf<Any>("GUI View", "Text View")
    val n = JOptionPane.showOptionDialog(frame,
            "What view would you like to play Tic-Tac-Toe in?",
            "View Selection",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0])

//    Initializes and starts the tictactoe controller
    val ticTacToeController: ControllerImpl?
    ticTacToeController = if (n == 0) {
        val gameFrame = JFrame()
        val gui = TicTacToeViewGUI()
        ControllerImpl(gui)
    } else if (n == 1) {
        println("You chose the text view")
        val text = TicTacToeViewText()
        ControllerImpl(text)
    } else {
        null
    }
    ticTacToeController?.startGame() ?: System.exit(0)
}