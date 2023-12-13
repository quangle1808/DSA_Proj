package minesweeper;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class ButtonPlay extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int number;

	private PanelPlayer p;

	public ButtonPlay(PanelPlayer p) {
		number = -1;
		this.p = p;
		setPreferredSize(new Dimension(30, 30));
	}

	@Override
	public void paint(Graphics g) {
		switch (number) {

		case -1:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("noUse"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 0:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b0"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 1:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b1"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 2:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b2"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 3:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b3"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 4:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b4"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 5:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b5"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 6:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b6"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 7:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b7"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		case 8:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("b8"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 9:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("co"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 10:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("boom"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 11:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("boomRed"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 12:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("boomX"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		default:
			break;
		}
	}

	public void setNumber(int number) {
		this.number = number;
	}

}

//This code is a Java class called "ButtonPlay" which extends the JButton class. The purpose of this class is to create a custom button for a game interface that displays different images depending on its current state, represented by an integer value called "number".
//
//The class has the following attributes:
//
//"number": an integer value representing the current state of the button.
//"p": an instance of a "PanelPlayer" class, which is used to retrieve image resources for the button.
//The constructor initializes the "number" attribute to -1 and sets the preferred size of the button to a 30x30 pixel dimension.
//
//The "paint" method is overridden to paint the button with the appropriate image based on the current "number" state. This method uses the "p" attribute to retrieve images from a resource list and draws them on the button's surface.
//
//The "setNumber" method allows the "number" attribute to be set from external classes. This is used to update the button's image based on game state changes.
//
//Overall, this class provides a custom button with the ability to display different images based on its current state, which is useful for creating game interfaces with custom graphics.
