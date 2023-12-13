package minesweeper;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private PanelNotification p1;
	private PanelPlayer p2;
	private GameFrame gameFrame;
	private World world;
	private int w;
	private int h;
	private int boom;
	private Stack<boolean[][]> gameStateStack;
	 private int[][] gameState;

	public GamePanel(int w, int h, int boom, GameFrame gameFrame) {

		this.gameFrame = gameFrame;

		this.boom = boom;
		this.w = w;
		this.h = h;

		world = new World(w, h, boom, this);

		setLayout(new BorderLayout(20, 20));

		add(p1 = new PanelNotification(this), BorderLayout.NORTH);
		add(p2 = new PanelPlayer(this), BorderLayout.CENTER);

		gameStateStack = new Stack<boolean[][]>();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		getP1().getBt().setStage(ButtonSmile.wow);
		getP1().getBt().repaint();
		ButtonPlay[][] arrayButton = p2.getArrayButton();
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				if (e.getButton() == 1 && e.getSource() == arrayButton[i][j] && !world.getArrayCamCo()[i][j]) {

					if (!getP1().getTime().isRunning()) {
						getP1().getTime().start();
					}

					if (!world.open(i, j)) {

						if (world.isComplete()) {

							getP1().getTime().stop();
							getP1().getBt().setStage(ButtonSmile.lose);
							getP1().getBt().repaint();

							int option = JOptionPane.showConfirmDialog(this, "You lost, play again?", "Notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new GameFrame(w, h, boom);
							} else {
								world.fullTrue();
							}
						} else if (world.isEnd()) {

							getP1().getTime().stop();
							getP1().getBt().setStage(ButtonSmile.win);
							getP1().getBt().repaint();

							int option = JOptionPane.showConfirmDialog(this, "You win, play again ?", "Notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new GameFrame(w, h, boom);
							}
						}
					}
				} else if (e.getButton() == 3 && e.getSource() == arrayButton[i][j]) {
					world.camCo(i, j);
				}
				if (e.getClickCount() == 2 && e.getSource() == arrayButton[i][j] && world.getArrayBoolean()[i][j]) {
					if (!world.clickDouble(i, j)) {

						int option = JOptionPane.showConfirmDialog(this, "You lost, play again?", "Notification",
								JOptionPane.YES_NO_OPTION);

						if (option == JOptionPane.YES_OPTION) {
							gameFrame.setVisible(false);
							new GameFrame(w, h, boom);
						} else {
							world.fullTrue();
						}
					}
				}
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		getP1().getBt().setStage(ButtonSmile.now);
		getP1().getBt().repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public int getBoom() {
		return boom;
	}

	public void setBoom(int boom) {
		this.boom = boom;
	}

	public PanelNotification getP1() {
		return p1;
	}

	public void setP1(PanelNotification p1) {
		this.p1 = p1;
	}

	public PanelPlayer getP2() {
		return p2;
	}

	public void setP2(PanelPlayer p2) {
		this.p2 = p2;
	}
	 public void setGameState(int[][] state) {
	        this.gameState = deepCopy(state);
	    }

	// Helper method to create deep copy of 2D boolean array
	 private int[][] deepCopy(int[][] original) {
	        if (original == null) {
	            return null;
	        }

	        int[][] copy = new int[original.length][];
	        for (int i = 0; i < original.length; i++) {
	            copy[i] = Arrays.copyOf(original[i], original[i].length);
	        }

	        return copy;
	    }
}


//This is a class called GamePanel that extends JPanel and implements the MouseListener interface. It represents the panel that contains the game board and handles user input through mouse events.
//
//The class has instance variables such as p1 and p2, which represent two different panels used for displaying game information, world which represents the game board, w, h, and boom, which are the width, height, and number of bombs respectively, and gameFrame, which represents the main game frame.
//
//The constructor initializes the world instance variable with the specified width, height, and number of bombs, and sets the layout of the panel to BorderLayout. It also adds p1 and p2 panels to the north and center of the panel respectively.
//
//The class implements several methods from the MouseListener interface to handle mouse input from the user. The mousePressed method listens for left and right mouse clicks on the game board, and calls the appropriate methods in the world object to update the game state. It also starts the timer in p1 if it is not already running.
//
//The mouseReleased method listens for the release of the mouse button, and updates the smiley face button in p1 to the normal state.

