package entities;

import java.awt.Color;
import java.awt.Graphics;

import general.Main;

public class Player {

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	public Player(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	}
	
	public void move(int dir) {
		if(x + dir > 0 && x + dir + width < Main.getWidth()) {
			x += dir * speed;
		}
	}

}
