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


    /*Object[] possibleValues = { "First", "Second", "Third" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose one", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		Object[] options = {"GUI View", "Text View"};
		JOptionPane pane = new JOptionPane(frame,
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[0]);

	     Object selectedValue = pane.getValue();*/
    val ticTacToeController: ControllerImpl
    if (n == 0) {
        val gui = TicTacToeViewGUI()
        gui.title = "Battleship"
        gui.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        ticTacToeController = ControllerImpl(gui)
        /*JFrame frame = new JFrame();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.getContentPane().add(gui);
        	frame.setTitle("Battleship");
        	frame.setResizable(false);
        	//frame.add(gui);
        	frame.pack();
        	frame.setVisible(true);*/
    } else {
        println("You chose the text view")
        val text = TicTacToeViewText(10, 10)
        ticTacToeController = ControllerImpl(text)
    }
    ticTacToeController.startGame()
}