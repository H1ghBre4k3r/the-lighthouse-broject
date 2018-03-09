package model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import general.Main;
import physics.UnitCollission;

/**
 * Klasse, die den Ball repräsentiert.
 *
 */
public class Ball {
	
	private int x;
	private int y;
	private int yOrigin;
	
	private int width;
	
	private int xDir;
	private int yDir;
	
	private Player p;
	
	private ModelController controller;

	Random generator;
	
	private BallMovementTimer timer;
	
	/**
	 * Initialisiert eine neue Instanz der Klasse Ball mit den vorhandenen Übergabeparamtern.
	 * 
	 * @param y
	 * 			Die y-Koordinate, an der der Ball "spawnen" soll.
	 * @param width
	 * 			Die Breite und die Höhe des Balls.
	 * @param xDir
	 * 			Ob der Ball nach rechts (true) oder nach links (false) starten soll.
	 * @param yDir
	 * 			Die Menge, um die sich die Y-Koordinate des Balls mit jeder Bewegung verändern soll.
	 * @param controller
	 * 			Die aktuelle Instanz des ModelControllers, der diese Klasse initialisiert hat.
	 */
	public Ball(int y, int width, boolean xDir, int yDir, ModelController controller) {
		
		generator = new Random();
		this.width = width;
		 
		this.x = generator.nextInt(Main.getWidth() - this.width) + 1;
		this.y = y;
		this.yOrigin = y;
		
		this.xDir = xDir? 1 : -1;
		this.yDir = yDir;
		
		this.p = controller.getPLAYER();
		
		this.controller = controller;
		
		timer = new BallMovementTimer(this);
		
	}
	
	/**
	 * Bewegt den Ball in die aktuellen Richtungen, welche vorher u.U. von der Collisions-Abfrage geändert wurden.
	 */
	public void move() {
		UnitCollission.check(controller);
		this.x += this.xDir;
		this.y += this.yDir;
	}
	
	/**
	 * Dreht die X-Richtung um.
	 */
	public void flipX() {
		this.xDir *= -1;
	}
	
	/**
	 * Dreht die Y-Richtung um.
	 */
	public void flipY() {
		this.yDir *= -1;
	}
	
	/**
	 * Resetet den Ball. (Also seine Position.)
	 */
	public void reset() {
		this.x = ThreadLocalRandom.current().nextInt(0, Main.getWidth() - this.width);
		this.y = this.yOrigin;
		this.yDir = -1;
	}
	
	/**
	 * Gibt die aktuelle X-Koordinate des Balls zurück.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gibt die aktuelle Y-Koordinate des Balls zurück.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Gibt die aktuelle Breite des Balls zurück.
	 */
	public int getWidth() {
		return this.width;
	}
	

	/**
	 * Gibt die aktuelle X-Richtung des Balls zurück.
	 */
	public int getxDir() {
		return xDir;
	}

	/**
	 * Gibt die aktuelle Y-Richtung des Balls zurück.
	 */
	public int getyDir() {
		return yDir;
	}
	
	/**
	 * Setzt die neue X-Richtung des Balls.
	 */
	public void setXDir(int xDir) {
		if(this.xDir > 0) {
			this.xDir = xDir;
		} else {
			this.xDir = - xDir;
		} 
	}


	/**
	 * Gibt den aktuellen BallMovementTimer zurück.
	 */
	public BallMovementTimer getTimer() {
		return timer;
	}
	
	/**
	 * Gibt den aktuellen ModelController zurück, von dem dieser Ball initialisiert wurde.
	 */
	public ModelController getController() {
		return controller;
	}
	
}
