package inputcontroller;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import model.Player;
import viewcontroller.DesktopFrame;

/**
 * Klasse, die dafür zuständig ist, den User-Input zu verwalten (über Tastatur und Maus).
 *
 */
public class InputController implements KeyListener, MouseMotionListener {
	
	private DesktopFrame frame;
	private Player p;

	/**
	 * Initialisiert einen neue Instanz von InputController mit den Übergabeparametern
	 * @param frame
	 * 			Der DesktopFrame, zu dem dieser InputController gehört.
	 * @param p
	 * 			Der aktuelle Spieler.
	 */
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
			// Spiel pausieren
			if(p.getController().isRunning()) {
				p.getController().pause();
			} else {
				p.getController().start();
			}
			break;
			
		case KeyEvent.VK_ENTER:
			// Spiel neustarten bzw nach Pause fortsetzen
			if(p.getController().isLost() || p.getController().isWon()) {
				p.getController().reset();
			} else {
				p.getController().start();
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			// Spieler nach rechts bewegen
			if(!p.getController().isLost() && !p.getController().isWon()) {
				p.move(+1);
			}
			break;
			
		case KeyEvent.VK_LEFT:
			// Spieler nach links bewegen
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
		// Position des Spielers an die Position der Maus über dem Frame anpassen
		if(!p.getController().isLost() && !p.getController().isWon()) {
			p.setX((int) (MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().getX()) - p.getWidth() / 2);
		}
		
	}

}
