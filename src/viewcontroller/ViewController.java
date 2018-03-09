package viewcontroller;

import general.Main;
import model.ModelController;

/**
 * Klasse, die für die "Verwaltung" der Views zuständig ist.
 *
 */
public class ViewController {
	
	private static int WIDTH = Main.getWidth();
	private static int HEIGHT = Main.getHeight();
	private static String TITLE = "Lighthouse Broject";
	
	private ModelController mController;
	
	private DesktopFrame dFrame;
	private LighthouseView lighthouse;

	/**
	 * Initialisiert eine neue Instanz der Klasse ViewController mit den vorhandenen Parametern.
	 * @param mController
	 * 				Der aktuelle ModelController.
	 */
	public ViewController(ModelController mController) {
		this.mController = mController;
	}
	
	/**
	 * "Startet" die Views.
	 */
	public void start() {
		dFrame = new DesktopFrame(WIDTH, HEIGHT, TITLE, this.mController);
		lighthouse = new LighthouseView(this.mController);
		lighthouse.start();
	}
	
	/**
	 * Gibt die aktuelle Instanz der LighthouseView zurück.
	 */
	public LighthouseView getLighthouseView() {
		return lighthouse;
	}

}
