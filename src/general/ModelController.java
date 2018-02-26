package general;

import entities.Ball;
import entities.Player;

public class ModelController {
	
	private Player PLAYER;
	private Ball BALL;
	private int leben;
	
	private boolean running = true;

	public ModelController() {
		
		int WIDTH = Main.getWidth();
		int HEIGHT = Main.getHeight();
		
		leben = 3;
		
		PLAYER = new Player(WIDTH / 2 - 50, HEIGHT - 50, 100, 20, 20, this);
		
		BALL = new Ball(HEIGHT - 90, 30, 1, -1, PLAYER, this);
		
	}

	public Player getPLAYER() {
		return PLAYER;
	}

	public Ball getBALL() {
		return BALL;
	}

	public boolean isRunning() {
		return running;
	}
	
	public void stopGame() {
//		running = false;
//		System.out.println("Du hast verloren! DU LOOOOSER!");
		if(leben > 1) {
			leben -= 1;
			BALL.reset();
		} else {
			running = false;
			System.out.println("Du hast verloren! DU LOOOOSER!");
		}
		
	}
	
	public int getLeben() {
		return this.leben;
	}

}
