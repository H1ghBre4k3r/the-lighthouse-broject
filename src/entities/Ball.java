package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int x;
	private int y;
	private int radius;
	
	public Ball(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		// sonst 0, 0
		g.fillArc(x, y, radius, radius, 0, 360);
	}
	
	
	
	
}
