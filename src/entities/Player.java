package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	}

}
