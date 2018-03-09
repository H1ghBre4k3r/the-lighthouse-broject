package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import general.Main;
import model.Brick;
import model.ModelController;

/**
 * Klasse, zur Repräsentation der Zeichenfläche auf dem JFrame.
 *
 */
public class DesktopPanel extends JPanel {
	
	private static int WIDTH;
	private static int HEIGHT;
	private ModelController mController;

	/**
	 * Initialisiert eine neue Instanz der Klasse DesktopPanel mit den vorhandenen Parametern.
	 * 
	 * @param width
	 * 			Die Breite der Zeichenfläche.
	 * @param height
	 * 			Die Höhe der Zeichenfläche.
	 * @param mController
	 * 			Der aktuelle ModelController.
	 */
	public DesktopPanel(int width, int height, ModelController mController) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.setBounds(0, 0, this.WIDTH, this.HEIGHT);
		
		this.mController = mController;
		
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Weiche Kanten
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Hintergrund  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(!Main.getMController().isLost() && !Main.getMController().isWon()) {
			
			if(!Main.getMController().hasBeenStarted()) {
				// Falls das Spiel noch nicht gestartet ist
				g.setColor(Color.WHITE);
				g.drawString("Drücke Enter um das Spiel zu starten", this.WIDTH / 2 - 120, this.HEIGHT / 2);
			}
		
			// Aktuelle Leben zeichnen
			g.setColor(Color.WHITE);
			g.drawString("Leben: " + Main.getMController().getLeben(), this.WIDTH - 70, 20);
			
			// Spieler zeichnen
			g.setColor(Color.RED);
			g.fillRect(mController.getPLAYER().getX(), mController.getPLAYER().getY(), mController.getPLAYER().getWidth(), mController.getPLAYER().getHeight());
			
			// Ball zeichnen
			g.setColor(Color.WHITE);
			g.fillArc(mController.getBALL().getX(), mController.getBALL().getY(), mController.getBALL().getWidth(), mController.getBALL().getWidth(), 0, 360);
			
			// Spielfeld zeichnen
			Brick[][] bricks = mController.getFeld().getBricks();
			int brickWidth = mController.getFeld().getBrickWidth();
			int brickHeight = mController.getFeld().getBrickHeight();
			int brickOffset = mController.getFeld().getBrickOffset();
			
			for(int x = 0; x < bricks.length; x++) {
				for(int y = 0; y < bricks[0].length; y++) {
					if(!bricks[x][y].isActive()) {
						continue;
					}
					g.setColor(bricks[x][y].getC());
					g.fillRect(x * brickWidth + 2, brickOffset + (y * (int) brickHeight) - 1, (int) brickWidth - 6, brickHeight - 5);
				}
			}
			
		} else if(mController.isLost()){
			// Wenn das Spiel verloren ist
			g.setColor(Color.WHITE);
			g.drawString("Du hast verloren... also du bist nicht so gut wollen wir damit sagen!", this.WIDTH / 2 - 200, this.HEIGHT / 2);
		} else if(mController.isWon()) {
			// Wenn das Spiel gewonnen ist
			g.setColor(Color.WHITE);
			g.drawString("Du hast gewonnen... also du bist ganz gut wollen wir damit sagen!", this.WIDTH / 2 - 200, this.HEIGHT / 2);
		}
		repaint();
	}
	

}
