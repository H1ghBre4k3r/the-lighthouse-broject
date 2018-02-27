package model;

import java.awt.Color;

public class Brick {
	
	private int x;
	private int y;
	
	private Color c;
	boolean active;

	public Brick() {
		c = Color.RED;
		active = true;
	}
	
	public Brick(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
		active = true;
	}
	
	public Color getC() {
		return c;
	}
	
	public void del() {
		active = false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
