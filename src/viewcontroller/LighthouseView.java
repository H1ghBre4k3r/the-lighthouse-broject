package viewcontroller;

import java.io.IOException;

import de.cau.infprogoo.lighthouse.LighthouseDisplay;
import general.Main;
import model.Brick;
import model.ModelController;

/**
 * Klasse zum "zeichnen" auf dem Lighthouse.
 * @author louis
 *
 */
public class LighthouseView {
	
	private LighthouseDisplay display;
	private ModelController mController;
	
	private int wonTimer = 0;
	private int looseTimer = 0;
	private int lebenTimer = 0;

	/**
	 * Erstellt eine neue Instanz der Klasse mit dem aktuellen ModelController als Übergabewert.
	 * @param mController
	 * 				Der aktuelle Modelkontroller.
	 */
	public LighthouseView(ModelController mController) {
		this.mController = mController;
	}
	
	/**
	 * Startet die Klasse. (Extra Methode, damit die Initialisierung der Instanz abgeschlossen werden kann.)
	 */
	public void start() {
		init();
		draw();
	}
	
	/**
	 * Stellt eine Verbindung zum Lighthouse her.
	 */
	private void init() {
		display = new LighthouseDisplay("louismeyer", "API-TOK_wpwd-jQii-s1id-VYZO-ZObT", 1);
		try {
			display.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Erstellt einen Byte-Array anhand der vorhandenen Daten über das Spiel und sendet diesen dann ans Lighthouse.
	 */
	private void draw() {
		byte[] bytes = new byte[1176];
		
		if(wonTimer == 0) {
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
				bytes[(13 * 28 + pXCoord) * 3] = (byte) 255;
				bytes[(13 * 28 + pXCoord) * 3 + 1] = (byte) 0;
				bytes[(13 * 28 + pXCoord) * 3 + 2] = (byte) 0;
				pXCoord += 1;
			}
	
			// Leben malen
			if((lebenTimer / 15) % 2 == 0) {
				for(int i = 0; i < mController.getLeben(); i ++) {
					bytes[(27 - i) * 3] = (byte) 255;
					bytes[(27 - i) * 3 + 1] = (byte) 128;
					bytes[(27 - i) * 3 + 2] = (byte) 128;
				}
			}
			lebenTimer += 1;
		} else {
			for(int i = 0; i < bytes.length / 3; i++) {
				bytes[i * 3] = (byte) 0;
				bytes[i * 3 + 1] = (byte) (255 * ((wonTimer / 15) % 2));
				bytes[i * 3 + 2] = (byte) 0;
			}
			wonTimer -= 1;
		}
		
		if(looseTimer > 0) {
			for(int i = 0; i < bytes.length / 3; i++) {
				bytes[i * 3] = (byte) 255;
				bytes[i * 3 + 1] = (byte) 0;
				bytes[i * 3 + 2] = (byte) 0;
			}
			looseTimer -= 1;
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
	
	/**
	 * Wird aufgerufen, sobald das Spiel gewonnen ist. Setzt den Timer für das aufblinken des Displays.
	 */
	public void win() {
		wonTimer = 60;
	}
	
	/**
	 * Wird aufgerufen, sobald der Spieler ein Leben verliert. Setzt den Timer für das aufblinken den Displays.
	 */
	public void loose() {
		looseTimer = 10;
	}

}
