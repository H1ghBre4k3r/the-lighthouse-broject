package model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasse, die für die (regelmäßige) Bewegung des Balls zuständing ist.
 *
 */
public class BallMovementTimer extends Timer {
	
	private Ball b;

	/**
	 * Initialisiert eine neue Instanz von BallMovementTimer mit den vorhandenen Parametern.
	 * @param b
	 * 			Der Ballm, der bewegt werden muss.
	 */
	public BallMovementTimer(Ball b) {
		
		this.b = b;

		init();
	}
	
	/**
	 * Die Instanz bekommt ihre Funktionen.
	 */
	private void init() {
		
		this.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Bewegung, abhängig davon, ob das Spiel schon gestartet wurde, man gewonnen/verloren hat etc. d
				if(b.getController().hasBeenStarted()) {
					if(b.getController().isRunning()) {
						b.move();
						try {
							Thread.sleep(1000 / b.getController().getSpeed());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(b.getController().isLost()){
						this.cancel();
					}
				}
				
				// Check, ob das ganze Feld leer ist, dann gewonnen
				if(b.getController().getFeld().isEmpty()) {
					b.getController().win();
					this.cancel();
				}
				
			}
			
		}, 0, 1);
	}

}
