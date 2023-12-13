package minesweeper;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GamePanel game;

	private ButtonPlay[][] arrayButton;

	public PanelPlayer(GamePanel game) {
		this.game = game;

		setLayout(new GridLayout(game.getW(), game.getH()));

		arrayButton = game.getWorld().getArrayButton();

		setBorder(BorderFactory.createLoweredBevelBorder());
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				add(arrayButton[i][j] = new ButtonPlay(this));
				arrayButton[i][j].addMouseListener(game);
			}
		}
	}

	public ButtonPlay[][] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(ButtonPlay[][] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}
	


}

//This is a Java class named PanelPlayer, which extends the JPanel class. It has two instance variables, game of type GamePanel and arrayButton of type ButtonPlay[][].
//
//The constructor takes a GamePanel object as a parameter and sets it as the value of the game instance variable. It then sets the layout of the panel to a GridLayout with dimensions of the width and height of the game. It sets the arrayButton instance variable to the array of ButtonPlay objects retrieved from the World object of the game. It also adds each button in the array to the panel, and adds the current instance of the PanelPlayer class as a MouseListener to each button in the array.
//
//The getArrayButton and setArrayButton methods are simple getters and setters for the arrayButton instance variable. The getGame and setGame methods are simple getters and setters for the game instance variable.