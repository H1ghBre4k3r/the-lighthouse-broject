package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import entities.Ball;
import entities.Player;

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
		
		player.draw(g);
		ball.draw(g);
		
		repaint();
	}
	

}
