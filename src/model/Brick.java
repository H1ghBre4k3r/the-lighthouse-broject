package model;

import java.awt.Color;

/**
 * Klasse zur Repräsentation eines "Steins" in Breakout.
 *
 */
public class Brick {
	
	private int x;
	private int y;
	
	private Color c;
	boolean active;

	/**
	 * Initialisiert eine neue Instanz von Brick mit den vorhandenen Parametern und setzt ihn auf "aktiv".
	 * @param x
	 * 			Die x-Koordinate im Brick-Array.
	 * @param y
	 * 			Die y-Koordinate im Brick-Array.
	 * @param c
	 * 			Die Farbe des Bricks.
	 */
	public Brick(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
		active = true;
	}
	
	/**
	 * Gibt die Farbe des Bricks zurück.
	 */
	public Color getC() {
		return c;
	}
	
	/**
	 * "Löscht" den Brick. (Setzt ihn auf "inaktiv")
	 */
	public void del() {
		active = false;
	}
	
	/**
	 * Abfrage, ob der Brick noch aktiv ist.
	 * @return
	 * 			{@code True}, wenn der Brick aktiv ist. <br>
	 * 			{@code False}, wenn der Brick inaktiv ist.
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Gibt die x-Koordinate des Bricks zurück.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gibt die y-Koordinate des Bricks zurück.
	 */
	public int getY() {
		return y;
	}

}
