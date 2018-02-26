package inputcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;
import viewcontroller.DesktopFrame;

public class InputController implements KeyListener {
	
	private DesktopFrame frame;
	private Player p;

	public InputController(DesktopFrame frame, Player p) {
		this.frame = frame;
		this.p = p;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			p.move(+1);
			break;
			
		case KeyEvent.VK_LEFT:
			p.move(-1);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
