package viewcontroller;

import javax.swing.JFrame;

import inputcontroller.InputController;


public class DesktopFrame extends JFrame {
	
	private static int WIDTH;
	private static int HEIGHT;
	private static String TITLE;
	private DesktopPanel dpanel;
	
	public DesktopFrame(int width, int height, String title) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.TITLE = title;
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
		this.dpanel = new DesktopPanel(WIDTH, HEIGHT);
		this.add(this.dpanel);

		this.requestFocus();
		

		this.setVisible(true);
	}
	
}
