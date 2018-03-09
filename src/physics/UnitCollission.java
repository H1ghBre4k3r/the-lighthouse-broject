package physics;

import general.Main;
import model.Ball;
import model.Brick;
import model.ModelController;
import model.Player;
import model.Spielfeld;

/**
 * Klasse, die für die Kollisions-Abfrage zustäding ist.
 */
public class UnitCollission {
	
	/**
	 * Wird als erstes aufgerufen. Ruft nacheinander die anderen Methoden auf, die überprüfen, ob der Ball mit irgendeinem Objekt kollidiert.
	 */
	public static void check(ModelController controller) {
		Player p = controller.getPLAYER();
		Ball b = controller.getBALL();
		
		xOutOfBounce(b, p);
		yOutOfBounce(b, p, controller);
		hitBrick(controller);
	}

	/**
	 * Überprüft, ob der Ball in x-Richtung aus dem Spielfeld fliegt und ändert dementsprechend die Flugrichtungen.
	 */
	private static void xOutOfBounce(Ball b, Player p) {
		if(b.getX() < 0 || b.getX() + b.getWidth() > Main.getWidth()) {
			b.flipX();
		}
	}
	
	/**
	 * Überprüft, ob der Ball in y-Richtung aus dem Spielfeld oder gegen den Spieler fliegt und ändert dementsprechend die Flugrichtungen.
	 */
	private static void yOutOfBounce(Ball b, Player p, ModelController controller) {
		if(b.getY() < 0) {
			// Game gewonnen!
			// controller.win();
			b.flipY();
		} else if(b.getY() + b.getWidth() == p.getY() && b.getX() + b.getWidth() > p.getX() && b.getX() < p.getX() + p.getWidth()){
			b.flipY();
			int aufgekommen =  b.getX() + b.getWidth() / 2 - p.getX();
			if(aufgekommen < p.getWidth() / 4) {
				b.setXDir(2);
			} else if(aufgekommen < p.getWidth() / 4 * 3) {
				b.setXDir(1);
			} else {
				b.setXDir(2);
			}
		} else if(b.getY() + b.getWidth() > Main.getHeight()) {
			p.getController().looseLife();
		}
	}
	
	/**
	 * Überprüft, ob der Ball gegen einen Brick fliegt und ändert dementsprechend die Flugrichtungen.
	 * @param controller
	 */
	private static void hitBrick(ModelController controller) {
		
		Ball b = controller.getBALL();
		Spielfeld feld = controller.getFeld();
		Brick[][] bricks = feld.getBricks();

		boolean flipX = false;
		boolean flipY = false;
		
		for(int x = 0; x < bricks.length; x++) {
			for(int y = 0; y < bricks[0].length; y++) {
				Brick brick = bricks[x][y];
				
				
				// Daten des aktuellen Bricks herausfinden
				int brickX = brick.getX() * feld.getBrickWidth();
				int brickY = feld.getBrickOffset() + brick.getY() * feld.getBrickHeight();
				int brickWidth = feld.getBrickWidth();
				int brickHeight = feld.getBrickHeight();
				
				// Wenn Brick nicht mehr aktiv ist, ueberspringen
				if(!brick.isActive()) {
					continue;
				}
				
				if((b.getY() <= brickY + brickHeight && b.getY() + b.getWidth() >= brickY) && b.getX() < brickX + brickWidth && b.getX() + b.getWidth() > brickX) {
					flipY = true;
					brick.del();
					controller.speedUp();
				}
				
				if((b.getX() <= brickX + brickWidth && b.getX() + b.getWidth() >= brickX) && b.getY() + b.getWidth() > brickY && b.getY() < brickY + brickHeight) {
					flipX = true;
					brick.del();
					controller.speedUp();
				}
				
			}
		}
		
		if(flipX) {
			b.flipX();
		}
		
		if(flipY) {
			b.flipY();
		}
		
	}

}
