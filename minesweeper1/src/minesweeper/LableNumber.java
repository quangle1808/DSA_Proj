package minesweeper;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class LableNumber extends JLabel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private PanelNotification p;

	private String number;

	public LableNumber(PanelNotification p, String number) {
		this.p = p;
		this.number = number;
		setPreferredSize(new Dimension(78, 46));
	}

	@Override
	public void paint(Graphics g) {
		if (number.equals("voCuc")) {
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("voCuc"), 0, 0, 26, 46, null);
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("voCuc"), 26, 0, 26, 46, null);
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("voCuc"), 52, 0, 26, 46, null);
		} else {
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(0))),
					0, 0, 26, 46, null);
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(1))),
					26, 0, 26, 46, null);
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(2))),
					52, 0, 26, 46, null);
		}
	}

	public PanelNotification getP() {
		return p;
	}

	public void setP(PanelNotification p) {
		this.p = p;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
//This is a Java class called LableNumber that extends the JLabel class. It defines a custom label component that displays a number or a custom image.
//
//The class has two instance variables: p, which is an instance of PanelNotification, and number, which is a String representing the number to be displayed.
//
//The class has a constructor that takes two parameters: an instance of PanelNotification and a String representing the number to be displayed. The constructor sets the instance variables and also sets the preferred size of the label to be 78 pixels wide and 46 pixels tall.
//
//The class overrides the paint() method of JLabel to paint the number or custom image onto the label. If the number is "voCuc", the label displays a custom image by calling the getGame() method on the PanelNotification instance, and then calling the getGameFrame() and getLoadData() methods on that instance to retrieve the custom image from a list of images. If the number is not "voCuc", the label displays the number by calling the getGame() method on the PanelNotification instance, and then calling the getGameFrame() and getLoadData() methods on that instance to retrieve the individual digit images from a list of images.
//
//The class also has getter and setter methods for the p and number instance variables.
