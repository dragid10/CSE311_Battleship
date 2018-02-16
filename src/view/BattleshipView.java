import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface BattleshipView {

	/**
	 * Display hit on ship
	 * @param x
	 * @param y
	 */
	public void updateBoardAsHit(int x, int y);

	/**
	 * Display miss fire in water
	 * @param x
	 * @param y
	 */
	public void updateBoardAsMiss(int x, int y);

	/**
	 * Display a sunken ship
	 * @param ship
	 */
	//public void displaySunkenShip(Ship ship);

	public static void main(String[] args){
		JFrame frame = new JFrame();
		//Custom button text
		Object[] options = {"GUI View",
		                    "Text View"};
		int n = JOptionPane.showOptionDialog(frame,
		    "What view would you like to play Battleship in?",
		    "View Selection",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[0]);



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

		if(n == 0) {
			BattleshipViewGUI gui = new BattleshipViewGUI();
			gui.setTitle("Battleship");
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			/*JFrame frame = new JFrame();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.getContentPane().add(gui);
        	frame.setTitle("Battleship");
        	frame.setResizable(false);
        	//frame.add(gui);
        	frame.pack();
        	frame.setVisible(true);*/
		}else {
			System.out.println("You chose the text view");
			BattleshipViewText text = new BattleshipViewText(10,10);

		}

	}
}
