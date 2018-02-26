package viewcontroller;

import javax.swing.JFrame;

import entities.Ball;
import entities.Player;
import general.ModelController;
import inputcontroller.InputController;


public class DesktopFrame extends JFrame {
	
	private static int WIDTH;
	private static int HEIGHT;
	private static String TITLE;
	private DesktopPanel dpanel;
	
	private ModelController mController;
	
	public DesktopFrame(int width, int height, String title, ModelController mController) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.TITLE = title;
		
		this.mController = mController;
		
		init();
	}
	
	private void init() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
		// KeyListener
		this.addKeyListener(new InputController(this, mController.getPLAYER()));
		
		// Zeichenfläche
		this.dpanel = new DesktopPanel(WIDTH, HEIGHT, mController);
		this.add(this.dpanel);

		this.requestFocus();
		

		this.setVisible(true);
	}
	
}
