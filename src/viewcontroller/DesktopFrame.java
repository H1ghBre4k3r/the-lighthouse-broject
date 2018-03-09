package viewcontroller;

import javax.swing.JFrame;

import inputcontroller.InputController;
import model.ModelController;


/**
 * Klasse, zur Repräsentation des Dekstopfensters.
 *
 */
public class DesktopFrame extends JFrame {
	
	private static int WIDTH;
	private static int HEIGHT;
	private static String TITLE;
	private DesktopPanel dpanel;
	
	private ModelController mController;
	
	/**
	 * Initialisiert eine neue Instanz der Klasse DesktopFrame mit den vorhandenen Parametern.
	 * 
	 * @param width
	 * 				Die Breite des Fensters.
	 * @param height
	 * 				Die Höhe des Fensters.
	 * @param title
	 * 				Der Titel des Fensters.
	 * @param mController
	 * 				Der ModelController, der für das Model des Spiels zuständig ist.
	 */
	public DesktopFrame(int width, int height, String title, ModelController mController) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.TITLE = title;
		
		this.mController = mController;
		
		init();
	}
	
	/**
	 * Gibt dem Fenster alle wichtigen Eigenschaften (Breite, Höhe etc.) und erschafft den InputController.
	 */
	private void init() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
		// KeyListener
		InputController iController = new InputController(this, mController.getPLAYER());
		
		this.addKeyListener(iController);
		
		this.addMouseMotionListener(iController);
		
		// Zeichenfläche
		this.dpanel = new DesktopPanel(WIDTH, HEIGHT, mController);
		this.add(this.dpanel);

		this.requestFocus();
		

		this.setVisible(true);
	}
	
}
