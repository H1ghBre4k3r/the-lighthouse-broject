package model;

import java.awt.Color;

import general.Main;

/**
 * Klasse zur Repräsentation des Spielfelds.
 *
 */
public class Spielfeld {
	
	private int width;
	private int height;
	
	
	private Brick[][] bricks;
	
	private int brickWidth;
	private int brickHeight;
	private int brickOffset;
	
	private Color[] brickColors = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.MAGENTA};

	/**
	 * Initialisiert eine neue Instanz des Spielfelds mit den vorhandenen Parametern.
	 * @param width
	 * 				Die Breite des Spielfelds.
	 * @param height
	 * 				Die Höhe des Spielfelds.
	 */
	public Spielfeld(int width, int height) {
		this.width = width;
		this.height = height;
		
		brickWidth = Main.getWidth() / this.width;
		brickHeight = Main.getHeight() / 14;
		
		brickOffset = brickHeight;
		
		init();
	}
	
	/**
	 * Initialisiert den Inhalt des Spielfelds.
	 */
	private void init() {
		bricks = new Brick[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				bricks[i][j] = new Brick(i, j, brickColors[j % brickColors.length]);
			}
		}
	}
	
	/**
	 * Gibt die Breite der einzelnen Bricks zurück.
	 */
	public int getBrickWidth() {
		return brickWidth;
	}
	
	/**
	 * Gibt die Höhe der einzelnen Bricks zurück.
	 */
	public int getBrickHeight() {
		return brickHeight;
	}
	
	/**
	 * Gibt den Brick-Offset, also das, wie weit die Bricks nach unten versetzte gezeichnet werden, zurück.
	 */
	public int getBrickOffset() {
		return brickOffset;
	}
	
	/**
	 * Gibt die Breite des Spielfelds zurück.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gibt die Höhe des Spielfelds zurück.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Löscht einen Brick an der gegebenen Position.
	 * 
	 * @param x
	 * 			x-Koordinate des zu löschenden Bricks.
	 * @param y
	 * 			y-Koordinate des zu löschenden Bricks.
	 */
	public void delBrick(int x, int y) {
		bricks[x][y].del();
	}
	
	/**
	 * Gibt einen Brick von der gegebenen Position zurück.
	 * 
	 * @param x
	 * 			x-Koordinate des gesuchten Bricks.
	 * @param y
	 * 			y-Koordinate des gesuchten Bricks.
	 */
	public Brick getBrick(int x, int y) {
		return bricks[x][y];
	}
	
	/**
	 * Gibt den Brick-Array, der das Spielfeld darstellt, zurück.
	 */
	public Brick[][] getBricks() {
		return bricks;
	}
	
	/**
	 * Gibt zurück, ob das gesamte Spielfeld schon leer ist.
	 */
	public boolean isEmpty() {
		for(int i = 0; i < bricks.length; i++) {
			for(int j = 0; j < bricks[0].length; j++) {
				if(bricks[i][j].isActive()) {
					return false;
				}
			}
		}
		return true;
	}

}
