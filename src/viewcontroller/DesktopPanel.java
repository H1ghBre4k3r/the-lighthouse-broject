package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import entities.Ball;
import entities.Player;
import general.Main;

public class DesktopPanel extends JPanel {
	
	private static int WIDTH;
	private static int HEIGHT;
	private static Player player;
	private static Ball ball;

	public DesktopPanel(int width, int height, Player player, Ball ball) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.setBounds(0, 0, this.WIDTH, this.HEIGHT);
		
		this.player = player;
		this.ball = ball;
		
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		/* Weiche Kanten */
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(Main.getController().isRunning()) {
			
			if(!Main.getController().hasBeenStarted()) {
				g.setColor(Color.WHITE);
				g.drawString("Drücke Enter um das Spiel zu starten", this.WIDTH / 2 - 120, this.HEIGHT / 2);
			}
		
			g.setColor(Color.WHITE);
			g.drawString("Leben: " + Main.getController().getLeben(), this.WIDTH - 70, 20);
			
			// Spieler zeichnen
			g.setColor(Color.GRAY);
			g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			
			// Ball zeichnen
			g.setColor(Color.WHITE);
			g.fillArc(ball.getX(), ball.getY(), ball.getWidth(), ball.getWidth(), 0, 360);
			
			
			repaint();
		} else {
			g.setColor(Color.WHITE);
			g.drawString("Du hast verloren... also du bist nicht so gut wollen wir damit sagen!", this.WIDTH / 2 - 200, this.HEIGHT / 2);
		}
	}
	

}
