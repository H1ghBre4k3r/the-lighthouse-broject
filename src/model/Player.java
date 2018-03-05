package model;

import general.Main;

public class Player {

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	ModelController controller;
	
	public Player(int x, int y, int width, int height, int speed, ModelController controller) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		
		this.controller = controller;
	}
	
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSpeed() {
		return speed;
	}
	
	public ModelController getController() {
		return controller;
	}
	
	public void setX(int newX) {
		if(newX < 0 || newX > Main.getWidth() - this.width) {
			return;
		}
		this.x = newX;
	}

}
