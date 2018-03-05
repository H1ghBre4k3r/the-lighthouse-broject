package model;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovementTimer extends Timer {
	
	private Ball b;

	public BallMovementTimer(Ball b) {
		
		this.b = b;

		init();
	}
	
	private void init() {
		
		this.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(b.getController().hasBeenStarted()) {
					if(b.getController().isRunning()) {
						b.move();
					} else {
						this.cancel();
					}
				}
				
			}
			
		}, 0, 7);
	}

}
