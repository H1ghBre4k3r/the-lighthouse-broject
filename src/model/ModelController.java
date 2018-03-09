package model;

import java.util.concurrent.ThreadLocalRandom;

import general.Main;

/**
 * Klasse für die Repräsentation des ModelControllers.
 *
 */
public class ModelController {
	
	private Player player;
	private Ball ball;
	private Spielfeld feld;
	private int leben;
	
	private boolean running = true;
	private boolean started = false;
	private boolean won = false;
	private boolean lost = false;
	
	private int speed = 140;

	/**
	 * Initialisiert eine neue Instanz von ModelController und erschafft alle wichtigen Objekte.
	 */
	public ModelController() {
		
		int WIDTH = Main.getWidth();
		int HEIGHT = Main.getHeight();
		
		leben = 3;

		feld = new Spielfeld(7, 5);
		
		int playerWidth = (Main.getWidth() / 14) * 4;
		player = new Player(WIDTH / 2 - playerWidth / 2, HEIGHT - (HEIGHT / 14), playerWidth, HEIGHT / 14, 20, this);
		
		ball = new Ball(HEIGHT - 90, Main.getWidth() / 28, ThreadLocalRandom.current().nextBoolean(), -1, this);
		
		
	}

	/**
	 * Gibt den aktuellen Spieler zurück.
	 */
	public Player getPLAYER() {
		return player;
	}

	/**
	 * Gibt den aktuellen Ball zurück.
	 */
	public Ball getBALL() {
		return ball;
	}
	
	/**
	 * Gibt das aktuelle Spielfeld zurück.
	 */
	public Spielfeld getFeld() {
		return feld;
	}

	/**
	 * Gibt zurück, ob das Spiel gerade läuft.
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * Lässt den Spieler ein Leben oder, wenn er keine Leben mehr hat, das Spiel verlieren.
	 */
	public void looseLife() {
		if(leben > 1) {
			leben -= 1;
			ball.reset();
			running = false;
			Main.getVController().getLighthouseView().loose();
		} else {
			leben -= 1;
			running = false;
			lost = true;
			System.out.println("Du hast verloren!");
			Main.getVController().getLighthouseView().loose();
		}
		
	}
	
	/**
	 * Lässt den Spieler das Spiel gewinnen.
	 */
	public void win() {
		running = false;
		won = true;
		System.out.println("Du hast Gewonnen!");
		Main.getVController().getLighthouseView().win();
	}
	
	/**
	 * Startet das Spiel.
	 */
	public void start() {
		this.started = true;
		this.running = true;
	}
	
	/**
	 * Gibt die aktuelle Anzahl an Leben zurück, die der Spieler noch hat.
	 */
	public int getLeben() {
		return this.leben;
	}
	
	/**
	 * Gibt zurück, ob das Spiel verloren ist.
	 */
	public boolean isLost() {
		return this.lost;
	}
	
	/**
	 * Gibt zurück, ob das Spiel gewonnen ist.
	 */
	public boolean isWon() {
		return this.won;
	}
	
	/**
	 * Gibt zurück, ob das Spiel schon gestartet wurde.
	 */
	public boolean hasBeenStarted() {
		return started;
	}
	
	/**
	 * Erhöht die Geschwindigkeit des Balls.
	 */
	public void speedUp() {
		speed *= 1.03;
	}
	
	/**
	 * Gibt die aktuelle Geschwindigkeit des Balls zurück.
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Pausiert das Spiel.
	 */
	public void pause() {
		running = false;
	}
	
	/**
	 * Setzt alle Parameter des Models wieder zurück.
	 */
	public void reset() {
		running = true;
		lost = false;
		won = false;
		started = false;
		
		leben = 3;
		
		feld = new Spielfeld(7, 5);
		
		ball = new Ball(Main.getHeight() - 90, Main.getWidth() / 28, ThreadLocalRandom.current().nextBoolean(), -1, this);
		
	}

}
