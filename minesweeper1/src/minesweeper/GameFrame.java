package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stack<int[][]> gameStateStack = new Stack<>();
	private LoadData loadData;

	private GamePanel gamePanel;

	private JMenuBar mnb;
	private JMenu menu;
	private JMenuItem basic, nomal, hard, newGame, exit,undo;

	public GameFrame(int w, int h, int boom) {

		loadData = new LoadData();

		setJMenuBar(mnb = new JMenuBar());
		mnb.add(menu = new JMenu("Game"));

		menu.add(newGame = new JMenuItem("New game"));
		menu.addSeparator();
		menu.add(basic = new JMenuItem("Basic"));
		menu.add(nomal = new JMenuItem("Nomal"));
		menu.add(hard = new JMenuItem("Hard"));
		menu.addSeparator();
		menu.add(exit = new JMenuItem("Exit"));
		menu.addSeparator();
		menu.add(undo = new JMenuItem("Undo"));

		if (w == 8) {
			basic.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		} else if (w == 16) {
			nomal.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		} else {
			hard.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		}

		basic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(8, 8, 10);
			}
		});

		nomal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(16, 16, 40);
			}
		});

		hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(16, 30, 99);
			}
		});

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(w, h, boom);
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		undo.addActionListener(new ActionListener() {

			@Override
			 public void actionPerformed(ActionEvent e) {
		        if (!gameStateStack.isEmpty()) {
		            int[][] previousState = gameStateStack.pop();
		            gamePanel.setGameState(previousState);
		            gamePanel.repaint();
		        }
		    }
		});
		
		add(gamePanel = new GamePanel(w, h, boom, this));

		setIconImage(loadData.getListImage().get("title"));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameFrame(8, 8, 10);
	}

	public LoadData getLoadData() {
		return loadData;
	}

	public void setLoadData(LoadData loadData) {
		this.loadData = loadData;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

}


//This is a Java class named "GameFrame", which extends the JFrame class. It is responsible for creating and managing the game window interface of a Minesweeper game.
//
//The class contains several components, including a menu bar, a menu, and various menu items such as "New game", "Basic", "Nomal" (misspelled), "Hard", and "Exit". These components are added to the menu bar using the setJMenuBar() method.
//
//The constructor takes three parameters: the width and height of the game board (in terms of number of tiles), and the number of bombs to be placed on the board. It creates a new instance of the "LoadData" class, which is used to load various images used in the game, such as the title icon, game tiles, and smiley faces.
//
//The menu items are set up with ActionListener objects that respond to user clicks. For example, clicking on "Basic" will create a new instance of the GameFrame class with an 8x8 game board and 10 bombs, and hide the current instance of the game window. The same process is repeated for the other difficulty levels.
//
//The class also contains a reference to the "GamePanel" class, which represents the game board and is responsible for handling user interactions with the board. The game panel is added to the frame using the add() method.
//
//Finally, the class contains getter and setter methods for the "LoadData" and "GamePanel" objects. The main() method creates a new instance of the "GameFrame" class with default values of 8x8 and 10 bombs.