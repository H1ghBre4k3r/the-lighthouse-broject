package viewcontroller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import de.cau.infprogoo.lighthouse.LighthouseDisplay;
import general.Main;
import model.Brick;
import model.ModelController;

public class LighthouseView {
	
	private LighthouseDisplay display;
	private ModelController mController;

	public LighthouseView(ModelController mController) {
		this.mController = mController;
		init();
		draw();
	}
	
	private void init() {
		display = new LighthouseDisplay("louismeyer", "API-TOK_wpwd-jQii-s1id-VYZO-ZObT", 1);
		try {
			display.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void draw() {
		byte[] bytes = new byte[1176];
		
		// Bricks aufs Lighthouse bringen
		Brick[][] bricks = mController.getFeld().getBricks();
		int offSet = 28 * 3;
		int index = 0;
		
		for(int y = 0; y < bricks[0].length; y++) {
			for(int x = 0; x < bricks.length; x++) {
				if(bricks[x][y].isActive()) {
					for(int i = 0; i < 4; i ++) {
						bytes[index + offSet] = (byte) bricks[x][y].getC().getRed();
						bytes[index + 1 + offSet] = (byte) bricks[x][y].getC().getGreen();
						bytes[index + 2 + offSet] = (byte) bricks[x][y].getC().getBlue();
						index += 3;
					}
				} else {
					index += 12;
				}
			}
		}
		
		// Ball zeichnen
		int bX = mController.getBALL().getX() - 10;
		int bY = mController.getBALL().getY();
		
		int bXCoord = bX / (Main.getWidth() / 28);
		int bYCoord = bY / (Main.getHeight() / 14);

		bytes[(bYCoord * 28 + bXCoord) * 3] = (byte) 255;
		bytes[(bYCoord * 28 + bXCoord) * 3 + 1] = (byte) 255;
		bytes[(bYCoord * 28 + bXCoord) * 3 + 2] = (byte) 255;
		
		// Spieler Zeichnen
		int pX = mController.getPLAYER().getX();
		int pXCoord = pX / (Main.getWidth() / 28);
		
		for(int i = 0; i < 7; i++) {
			bytes[(13 * 28 + pXCoord) * 3] = (byte) 127;
			bytes[(13 * 28 + pXCoord) * 3 + 1] = (byte) 127;
			bytes[(13 * 28 + pXCoord) * 3 + 2] = (byte) 127;
			pXCoord += 1;
		}
		
		try {
			display.send(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000 / 30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		draw();
	}

}
