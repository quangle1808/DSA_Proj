package minesweeper;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int win = 0;
	public static final int lose = 1;
	public static final int press = 2;
	public static final int wow = 3;
	public static final int now = 4;

	private PanelNotification p;

	private int stage;

	public ButtonSmile(PanelNotification p) {
		this.p = p;
		setPreferredSize(new Dimension(50, 50));

		stage = now;
	}

	@Override
	public void paint(Graphics g) {
		switch (stage) {
		case win:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smileWin"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case lose:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smileLose"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case press:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smilePress"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case wow:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smilePressPlay"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case now:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smile"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		default:
			break;
		}

	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

}


//This is a Java code for a custom button class called "ButtonSmile" that extends the "JButton" class. It has several constants defined at the beginning of the class with the values "win", "lose", "press", "wow", and "now" assigned to them.
//
//The class also has a private field "p" of type "PanelNotification" and an integer field "stage" which represents the current stage of the button.
//
//The constructor of the class takes an object of type "PanelNotification" as an argument, sets the preferred size of the button to 50x50, and initializes the "stage" field to "now".
//
//The class overrides the "paint" method of the "JButton" class and uses a switch statement to determine which image to draw based on the current value of the "stage" field. It gets the images from a list of images stored in the "LoadData" object of the "GameFrame" object of the "Game" object of the "PanelNotification" object.
//
//Finally, the class provides getter and setter methods for the "stage" field.
