package inputcontroller;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import model.Player;
import viewcontroller.DesktopFrame;

public class InputController implements KeyListener, MouseMotionListener {
	
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
		case KeyEvent.VK_ESCAPE:
			if(p.getController().isRunning()) {
				p.getController().pause();
			} else {
				p.getController().start();
			}
			break;
		case KeyEvent.VK_ENTER:
			if(p.getController().isLost() || p.getController().isWon()) {
				p.getController().reset();
			} else {
				p.getController().start();
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if(!p.getController().isLost() && !p.getController().isWon()) {
				p.move(+1);
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if(!p.getController().isLost() && !p.getController().isWon()) {
				p.move(-1);
			}
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(!p.getController().isLost() && !p.getController().isWon()) {
			p.setX((int) (MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().getX()) - p.getWidth() / 2);
		}
		
	}

}
