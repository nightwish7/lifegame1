package lifegame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class World extends JPanel implements Runnable {
	int[][] currentGeneration= new int[40][50];
	int[][] nextGeneration= new int[40][50];
boolean isChanging = false;
boolean click =  false;

	void set(int i,int j,int status) {
		currentGeneration[i][j] =status;
	}


	@Override
	public void run() {
		while (true) {
			sleep(1);
				while (isChanging) 
				{
					repaint();
					sleep(1);
					for (int i = 0; i < 40; i++) {
						for (int j = 0; j < 50; j++) {
							if (evolve(i, j) == 0)
								nextGeneration[i][j] = 0;
							else if (evolve(i, j) == 1)
								nextGeneration[i][j] = 1;
							else if (evolve(i, j) == 2)
								nextGeneration[i][j] = currentGeneration[i][j];
						}
					}
					int[][] temp = null;
					temp = currentGeneration;
					currentGeneration = nextGeneration;
					nextGeneration = temp;
					for (int i = 0; i < 40; i++) {
						for (int j = 0; j < 50; j++) {
							nextGeneration[i][j] = 0;
						}
					}
			
				}
			
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 50; j++) {
				if (currentGeneration[i][j] == 1) {
					g.setColor(java.awt.Color.RED);
					g.fillRect(j * 20, i * 20, 20, 20);
				} 
					g.setColor(java.awt.Color.BLACK);
					g.drawRect(j * 20, i * 20, 20, 20);
				
			}
		}
	}





	
	int evolve(int x, int y) {
		int activeSurroundingCell = 0;

		if (isValidCell(x - 1, y - 1) && (currentGeneration[x - 1][y - 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x, y - 1) && (currentGeneration[x][y - 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x + 1, y - 1) && (currentGeneration[x + 1][y - 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x + 1, y) && (currentGeneration[x + 1][y] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x + 1, y + 1) && (currentGeneration[x + 1][y + 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x, y + 1) && (currentGeneration[x][y + 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x - 1, y + 1) && (currentGeneration[x - 1][y + 1] == 1)) {
			activeSurroundingCell++;
		}

		if (isValidCell(x - 1, y) && (currentGeneration[x - 1][y] == 1)) {
			activeSurroundingCell++;
		}
		if (activeSurroundingCell == 3) {
			return 1;
		} else if (activeSurroundingCell == 2) {
			return 2;
		} else {
			return 0;
		}
	}

	public boolean isValidCell(int x, int y) {
		if ((x >= 0) && (x < 40) && (y >= 0) && (y < 50)) {
			return true;
		} else {
			return false;
		}
	}

	 public void sleep(int x) {
		try {
			Thread.sleep(2000 * x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}}

