package entities;

import java.util.concurrent.ThreadLocalRandom;

import general.BallMovementTimer;
import general.Main;
import general.ModelController;
import general.UnitCollission;

public class Ball {
	
	private int x;
	private int y;
	private int yOrigin;
	
	private int width;
	
	private int xDir;
	private int yDir;
	
	private Player p;
	
	private ModelController controller;
	
	private BallMovementTimer timer;
	
	public Ball(int y, int width, int xDir, int yDir, Player p, ModelController controller) {
		this.width = width;
		this.x = ThreadLocalRandom.current().nextInt(0, Main.getWidth() - this.width);
		this.y = y;
		this.yOrigin = y;
		
		this.xDir = xDir;
		this.yDir = yDir;
		
		this.p = p;
		
		this.controller = controller;
		
		timer = new BallMovementTimer(this);
		
	}
	
	public void move() {
		UnitCollission.check(this, p);
		this.x += this.xDir;
		this.y += this.yDir;
	}
	
	public void flipX() {
		this.xDir *= -1;
	}
	
	public void flipY() {
		this.yDir *= -1;
	}
	
	public void reset() {
		this.x = ThreadLocalRandom.current().nextInt(0, Main.getWidth() - this.width);
		this.y = this.yOrigin;
		this.yDir = -1;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	

	public int getxDir() {
		return xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public Player getP() {
		return p;
	}

	public BallMovementTimer getTimer() {
		return timer;
	}
	
	public ModelController getController() {
		return controller;
	}
	
}
