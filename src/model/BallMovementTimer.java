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
				
				if(b.getController().getFeld().isEmpty()) {
					b.getController().win();
					this.cancel();
				}
				
			}
			
		}, 0, 1);
	}

}
