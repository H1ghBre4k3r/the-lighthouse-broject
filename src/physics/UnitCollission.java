package physics;

import general.Main;
import model.Ball;
import model.Brick;
import model.ModelController;
import model.Player;
import model.Spielfeld;

public class UnitCollission {
	
	public static void check(ModelController controller) {
		Player p = controller.getPLAYER();
		Ball b = controller.getBALL();
		Spielfeld feld = controller.getFeld();
		
		xOutOfBounce(b, p);
		yOutOfBounce(b, p, controller);
		hitBrick(b, feld);
	}

	private static void xOutOfBounce(Ball b, Player p) {
		if(b.getX() < 0 || b.getX() + b.getWidth() > Main.getWidth()) {
			b.flipX();
		}
	}
	
	private static void yOutOfBounce(Ball b, Player p, ModelController controller) {
		if(b.getY() < 0) {
			// Game gewonnen!
			controller.win();
		} else if(b.getY() + b.getWidth() == p.getY() && b.getX() + b.getWidth() > p.getX() && b.getX() < p.getX() + p.getWidth()){
			b.flipY();
		} else if(b.getY() + b.getWidth() > Main.getHeight()) {
			p.getController().looseLife();
		}
	}
	
	private static void hitBrick(Ball b, Spielfeld feld) {
		
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
				
				// Wenn Brick nicht mehr aktiv ist, �berspringen
				if(!brick.isActive()) {
					continue;
				}
				
				if(b.getY() == brickY + brickHeight && b.getX() < brickX + brickWidth && b.getX() + b.getWidth() > brickX) {
					flipY = true;
					brick.del();
				}
				
				if((b.getX() == brickX + brickWidth || b.getX() + b.getWidth() == brickX) && b.getY() + b.getWidth() > brickY && b.getY() < brickY + brickHeight) {
					flipX = true;
					brick.del();
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
