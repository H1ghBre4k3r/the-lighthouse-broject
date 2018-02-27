package model;

import java.awt.Color;

public class Spielfeld {
	
	private int width;
	private int height;
	
	private Brick[][] bricks;
	private Color[] brickColors = {Color.RED, Color.GREEN, Color.YELLOW};

	public Spielfeld(int width, int height) {
		this.width = width;
		this.height = height;
		init();
	}
	
	private void init() {
		bricks = new Brick[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				bricks[i][j] = new Brick(brickColors[j / 2]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void delBrick(int x, int y) {
		bricks[x][y].del();
	}
	
	public Brick getBrick(int x, int y) {
		return bricks[x][y];
	}
	
	public Brick[][] getBricks() {
		return bricks;
	}

}
