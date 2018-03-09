package general;

import model.ModelController;
import viewcontroller.DesktopFrame;
import viewcontroller.ViewController;

/**
 * Klasse, mit der das Program gestartet wird.
 *
 */
public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 800;
	
	private static ModelController mController;
	private static ViewController vController;
	
	public static DesktopFrame frame;
	

	/**
	 * Methode, die beim Start des Programs aufgerufen wird. Sie initialisiert den Model- und den View-Controller.
	 * @param args
	 */
	public static void main(String[] args) {
		
		mController = new ModelController();
		vController = new ViewController(mController);
		vController.start();

	}
	
	/**
	 * Gibt die Breite des DESKTOPFENSTERS zurück.
	 */
	public static int getWidth() {
		return WIDTH;
	}
	
	/**
	 * Gibt die Höhe des DESKTOPFENSTERS zurück.
	 */
	public static int getHeight() {
		return HEIGHT;
	}
	
	/**
	 * Gibt den aktuellen ModelController zurück.
	 */
	public static ModelController getMController() {
		return mController;
	}
	
	/**
	 * Gibt den aktuellen ViewController zurück.
	 */
	public static ViewController getVController() {
		return vController;
	}

}
