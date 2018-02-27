package general;

import entities.Ball;
import entities.Player;

public class UnitCollission {
	
	public static void check(Ball b, Player p) {
		xOutOfBounce(b, p);
		yOutOfBounce(b, p);
	}

	private static void xOutOfBounce(Ball b, Player p) {
		if(b.getX() < 0 || b.getX() + b.getWidth() > Main.getWidth()) {
			b.flipX();
		}
	}
	
	private static void yOutOfBounce(Ball b, Player p) {
		if(b.getY() < 0) {
			b.flipY();
		} else if(b.getY() + b.getWidth() > p.getY() && b.getX() > p.getX() && b.getX() + b.getWidth() < p.getX() + p.getWidth()){
			b.flipY();
		} else if(b.getY() + b.getWidth() / 2 > p.getY()) {
			p.getController().stopGame();
		}
	}

}
