package model;

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

	public ModelController() {
		
		int WIDTH = Main.getWidth();
		int HEIGHT = Main.getHeight();
		System.out.println(HEIGHT / 14);
		
		leben = 3;
		
		int playerWidth = (Main.getWidth() / 14) * 4;
		player = new Player(WIDTH / 2 - playerWidth / 2, HEIGHT - (HEIGHT / 14), playerWidth, HEIGHT / 14, 20, this);
		
		ball = new Ball(HEIGHT - 90, Main.getWidth() / 28, ThreadLocalRandom.current().nextBoolean(), -1, player, this);
		
		feld = new Spielfeld(7, 3);
		
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
		} else {
			running = false;
			lost = true;
			System.out.println("Du hast verloren! DU LOOOOSER!");
		}
		
	}
	
	public void win() {
		running = false;
		won = true;
		System.out.println("Du hast Gewonnen!");
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

}
