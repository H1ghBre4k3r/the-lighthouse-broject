package model;

import java.awt.Color;

public class Brick {
	
	private Color c;
	boolean active;

	public Brick() {
		c = Color.RED;
		active = true;
	}
	
	public Brick(Color c) {
		this.c = c;
		active = true;
	}
	
	public Color getC() {
		return c;
	}
	
	public void del() {
		active = false;
	}

}
