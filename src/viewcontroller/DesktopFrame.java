package viewcontroller;

import javax.swing.JFrame;

import entities.Ball;
import entities.Player;
import inputcontroller.InputController;


public class DesktopFrame extends JFrame {
	
	private static int WIDTH;
	private static int HEIGHT;
	private static String TITLE;
	private DesktopPanel dpanel;
	
	private Player p;
	private Ball b;
	
	public DesktopFrame(int width, int height, String title, Player p, Ball b) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.TITLE = title;
		
		this.p = p;
		this.b = b;
		init();
	}
	
	private void init() {
		this.setTitle("Lighthouse Broject");
		this.setSize(500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
		// KeyListener
		this.addKeyListener(new InputController(this));
		
		// Zeichenfläche
		this.dpanel = new DesktopPanel(WIDTH, HEIGHT, p, b);
		this.add(this.dpanel);

		this.requestFocus();
		

		this.setVisible(true);
	}
	
}
