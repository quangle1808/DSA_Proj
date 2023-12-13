package minesweeper;


import java.util.Random;


public class World {

	private Random rd;

	private ButtonPlay[][] arrayButton;
	private int[][] arrayMin;

	private boolean[][] arrayBoolean;

	private boolean[][] arrayCamCo;
	private int co;

	private boolean isComplete;
	private boolean isEnd;

	private ButtonSmile buttonSmile;
	private LableNumber lbTime, lbBoom;

	private int boom;

	private GamePanel game;

	public World(int w, int h, int boom, GamePanel game) {

		this.game = game;
		this.boom = boom;

		arrayButton = new ButtonPlay[w][h];
		arrayMin = new int[w][h];
		arrayBoolean = new boolean[w][h];
		arrayCamCo = new boolean[w][h];

		rd = new Random();

		createArrayMin(boom, w, h);
		dienSo();

	}

	public boolean clickDouble(int i, int j) {

		boolean isCoMin = false;

		for (int l = i - 1; l <= i + 1; l++) {
			for (int k = j - 1; k <= j + 1; k++) {
				if (l >= 0 && l <= arrayMin.length - 1 && k >= 0 && k <= arrayMin[i].length - 1) {
					if (!arrayCamCo[l][k]) {
						if (arrayMin[l][k] == -1) {
							isCoMin = true;
							arrayButton[l][k].setNumber(12);
							arrayButton[l][k].repaint();
							arrayBoolean[l][k] = true;
						} else if (!arrayBoolean[l][k]) {
							if (arrayMin[l][k] == 0) {
								open(l, k);
							} else {
								arrayButton[l][k].setNumber(arrayMin[l][k]);
								arrayButton[l][k].repaint();
								arrayBoolean[l][k] = true;
							}
						}
					}
				}
			}
		}

		if (isCoMin) {
			for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
				for (int k = 0; k < arrayBoolean[i].length; k++) {
					if (arrayMin[j2][k] == -1 && !arrayBoolean[j2][k]) {
						arrayButton[j2][k].setNumber(10);
						arrayButton[j2][k].repaint();
					}
				}
			}
			return false;
		}

		return true;
	}

	public void camCo(int i, int j) {
		if (!arrayBoolean[i][j]) {
			if (arrayCamCo[i][j]) {
				co--;
				arrayCamCo[i][j] = false;
				arrayButton[i][j].setNumber(-1);
				arrayButton[i][j].repaint();
				game.getP1().updateLbBoom();
			} else if (co < boom) {
				co++;
				arrayCamCo[i][j] = true;
				arrayButton[i][j].setNumber(9);
				arrayButton[i][j].repaint();
				game.getP1().updateLbBoom();
			}
		}

	}

	public boolean open(int i, int j) {

		if (!isComplete && !isEnd) {
			if (!arrayBoolean[i][j]) {
				if (arrayMin[i][j] == 0) {

					arrayBoolean[i][j] = true;
					arrayButton[i][j].setNumber(0);
					arrayButton[i][j].repaint();

					if (checkWin()) {
						isEnd = true;

						return false;
					}

					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayMin.length - 1 && k >= 0 && k <= arrayMin[i].length - 1) {
								if (!arrayBoolean[l][k]) {
									open(l, k);
								}
							}
						}
					}

					if (checkWin()) {
						isEnd = true;

						return false;
					}

				} else {

					int number = arrayMin[i][j];

					if (number != -1) {

						arrayBoolean[i][j] = true;

						arrayButton[i][j].setNumber(number);
						arrayButton[i][j].repaint();

						if (checkWin()) {
							isEnd = true;

							return false;
						}

						return true;
					}
				}
			}

			if (arrayMin[i][j] == -1) {
				arrayButton[i][j].setNumber(11);
				arrayButton[i][j].repaint();
				isComplete = true;

				for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
					for (int k = 0; k < arrayBoolean[i].length; k++) {
						if (arrayMin[j2][k] == -1 && !arrayBoolean[j2][k]) {
							if (j2 != i || k != j) {
								arrayButton[j2][k].setNumber(10);
								arrayButton[j2][k].repaint();
							}
						}
					}
				}

				return false;
			} else {

				if (checkWin()) {
					isEnd = true;

					return false;
				}

				return true;
			}
		} else

			return false;

	}

	public boolean checkWin() {
		int count = 0;
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					count++;
				}
			}
		}
		if (count == boom)
			return true;
		else
			return false;
	}

	public void dienSo() {
		for (int i = 0; i < arrayMin.length; i++) {
			for (int j = 0; j < arrayMin[i].length; j++) {
				if (arrayMin[i][j] == 0) {
					int count = 0;
					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayMin.length - 1 && k >= 0 && k <= arrayMin[i].length - 1)
								if (arrayMin[l][k] == -1) {
									count++;
								}
						}
					}
					arrayMin[i][j] = count;
				}
			}
		}
	}

	public void createArrayMin(int boom, int w, int h) {
		int locationX = rd.nextInt(w);
		int locationY = rd.nextInt(h);

		arrayMin[locationX][locationY] = -1;
		int count = 1;
		while (count != boom) {
			locationX = rd.nextInt(w);
			locationY = rd.nextInt(h);
			if (arrayMin[locationX][locationY] != -1) {

				arrayMin[locationX][locationY] = -1;

				count = 0;
				for (int i = 0; i < arrayMin.length; i++) {
					for (int j = 0; j < arrayMin[i].length; j++) {
						if (arrayMin[i][j] == -1)
							count++;
					}
				}
			}
		}

	}

	public void fullTrue() {
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					arrayBoolean[i][j] = true;
				}
			}
		}
	}

	public ButtonPlay[][] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(ButtonPlay[][] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public ButtonSmile getButtonSmile() {
		return buttonSmile;
	}

	public void setButtonSmile(ButtonSmile buttonSmile) {
		this.buttonSmile = buttonSmile;
	}

	public LableNumber getLbTime() {
		return lbTime;
	}

	public void setLbTime(LableNumber lbTime) {
		this.lbTime = lbTime;
	}

	public LableNumber getLbBoom() {
		return lbBoom;
	}

	public void setLbBoom(LableNumber lbBoom) {
		this.lbBoom = lbBoom;
	}

	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}

	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean[][] getArrayCamCo() {
		return arrayCamCo;
	}

	public void setArrayCamCo(boolean[][] arrayCamCo) {
		this.arrayCamCo = arrayCamCo;
	}

	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

}
//the class World appears to be implementing the game logic for a Minesweeper game. The class contains methods for initializing the game board, processing player moves, and checking for game completion.
//
//The World class uses a 2D array to represent the game board, with each element in the array representing a button that can be clicked by the player. The arrayMin array is used to store the locations of the mines on the game board. When a player clicks on a button, the open method is called, which recursively checks the neighboring buttons to see if they need to be opened based on the position of the mines.
//
//The clickDouble method is called when the player performs a double-click on a button. This method checks the surrounding buttons and opens them if they do not contain a mine. If any of the surrounding buttons do contain a mine, the method sets the button's number to 12 to indicate that it is a mine.
//
//The camCo method is called when the player right-clicks on a button to flag it as a mine. This method sets the arrayCamCo array to true for the corresponding button, indicating that it has been flagged as a mine.
//
//The World class also contains several boolean variables that keep track of the game state, such as whether the game is complete or has ended, as well as an integer variable to keep track of the number of mines remaining to be flagged by the player. Finally, the World class contains references to several other objects, such as the ButtonPlay and ButtonSmile classes, which are used to display the game board and game buttons.