package model;

import general.Main;

public class ModelController {
	
	private Player player;
	private Ball ball;
	private Spielfeld feld;
	private int leben;
	
	private boolean running = true;
	private boolean started = false;

	public ModelController() {
		
		int WIDTH = Main.getWidth();
		int HEIGHT = Main.getHeight();
		
		leben = 3;
		
		player = new Player(WIDTH / 2 - 50, HEIGHT - 50, 100, 20, 20, this);
		
		ball = new Ball(HEIGHT - 90, 30, 1, -1, player, this);
		
		feld = new Spielfeld(7, 6);
		
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
	
	public void stopGame() {
//		running = false;
//		System.out.println("Du hast verloren! DU LOOOOSER!");
		if(leben > 1) {
			leben -= 1;
			ball.reset();
		} else {
			running = false;
			System.out.println("Du hast verloren! DU LOOOOSER!");
		}
		
	}
	
	public void start() {
		this.started = true;
		this.running = true;
	}
	
	public int getLeben() {
		return this.leben;
	}
	
	public boolean hasBeenStarted() {
		return started;
	}

}
