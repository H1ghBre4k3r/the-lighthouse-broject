package model;

import java.awt.Color;

import general.Main;

public class Spielfeld {
	
	private int width;
	private int height;
	
	
	private Brick[][] bricks;
	
	private int brickWidth;
	private int brickHeight;
	private int brickOffset;
	
	private Color[] brickColors = {Color.RED, Color.GREEN, Color.YELLOW};

	public Spielfeld(int width, int height) {
		this.width = width;
		this.height = height;
		
		brickOffset = 160;
		
		brickWidth = Main.getWidth() / this.width;
		brickHeight = 18;
		
		init();
	}
	
	private void init() {
		bricks = new Brick[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				bricks[i][j] = new Brick(i, j, brickColors[j / 2]);
			}
		}
	}
	
	public int getBrickWidth() {
		return brickWidth;
	}
	
	public int getBrickHeight() {
		return brickHeight;
	}
	
	public int getBrickOffset() {
		return brickOffset;
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
