package model;

import general.Main;

/**
 * Klasse zur Repräsentation des Spielers.
 *
 */
public class Player {

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	ModelController controller;
	
	/**
	 * Initialisiert eine neue Instanz des Spielers mit den Parametern.
	 * 
	 * @param x
	 * 			x-Koordinate, an der der Spieler spawnen soll.
	 * @param y
	 * 			y-Koordinate, an der der Spieler spawnen soll.
	 * @param width
	 * 			Breite des Spielers.
	 * @param height
	 * 			Höhe des Spielers.
	 * @param speed
	 * 			Geschwindigkeit, mit der der Spieler sich beim Drücken der Pfeiltasten bewegen soll.
	 * @param controller
	 * 			Der aktuelle ModelController, von dem dieser Spieler erschaffen wurde.
	 */
	public Player(int x, int y, int width, int height, int speed, ModelController controller) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		
		this.controller = controller;
	}
	
	/**
	 * Bewegt den Spieler in eine Richtung auf der x-Achse.
	 */
	public void move(int dir) {
		if(x + dir > 0 ) {
			x += dir * speed;
		} else {
			x = 0;
		} 
		
		if(x + dir + width < Main.getWidth()) {
			x += dir * speed;
		} else {
			x = Main.getWidth() - width;
		}
	}

	/**
	 * Gibt die x-Koordinate des Spielers zurück.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gibt die y-Koordinate des Spielers zurück.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gibt die Breite des Spielers zurück.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gibt die Höhe des Spielers zurück.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gibt die Geschwindigkeit des Spielers zurück.
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Gibt den ModelController zurück, von dem dieser Ball erschaffen wurde.
	 */
	public ModelController getController() {
		return controller;
	}
	
	/**
	 * Setzt die x-Koordinate des Spielers neu.
	 */
	public void setX(int newX) {
		if(newX < 0 || newX > Main.getWidth() - this.width) {
			return;
		}
		this.x = newX;
	}

}
