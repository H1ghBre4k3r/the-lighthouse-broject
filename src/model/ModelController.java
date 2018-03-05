package model;

import java.util.concurrent.ThreadLocalRandom;

import general.Main;

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

	public ModelController() {
		
		int WIDTH = Main.getWidth();
		int HEIGHT = Main.getHeight();
		
		leben = 3;

		feld = new Spielfeld(7, 5);
		
		int playerWidth = (Main.getWidth() / 14) * 4;
		player = new Player(WIDTH / 2 - playerWidth / 2, HEIGHT - (HEIGHT / 14), playerWidth, HEIGHT / 14, 20, this);
		
		ball = new Ball(HEIGHT - 90, Main.getWidth() / 28, ThreadLocalRandom.current().nextBoolean(), -1, player, this);
		
		
	}

	public Player getPLAYER() {
		return player;
	}

	public Ball getBALL() {
		return ball;
	}
	
	public Spielfeld getFeld() {
		return feld;
	}

	public boolean isRunning() {
		return running;
	}
	
	public void looseLife() {
//		running = false;
//		System.out.println("Du hast verloren! DU LOOOOSER!");
		if(leben > 1) {
			leben -= 1;
			ball.reset();
			running = false;
			Main.getVController().getLighthouseView().loose();
		} else {
			leben -= 1;
			running = false;
			lost = true;
			System.out.println("Du hast verloren! DU LOOOOSER!");
		}
		
	}
	
	public void win() {
		running = false;
		won = true;
		System.out.println("Du hast Gewonnen!");
		Main.getVController().getLighthouseView().win();
	}
	
	public void start() {
		this.started = true;
		this.running = true;
	}
	
	public int getLeben() {
		return this.leben;
	}
	
	public boolean isLost() {
		return this.lost;
	}
	
	public boolean isWon() {
		return this.won;
	}
	
	public boolean hasBeenStarted() {
		return started;
	}
	
	public void speedUp() {
		speed *= 1.05;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void pause() {
		running = false;
	}
	
	public void reset() {
		running = true;
		lost = false;
		won = false;
		started = false;
		
		leben = 3;
		
		feld = new Spielfeld(7, 3);
		
		ball = new Ball(Main.getHeight() - 90, Main.getWidth() / 28, ThreadLocalRandom.current().nextBoolean(), -1, player, this);
		
	}

}
