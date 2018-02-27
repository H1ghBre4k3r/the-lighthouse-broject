package viewcontroller;

import general.Main;
import model.ModelController;

public class ViewController {
	
	private static int WIDTH = Main.getWidth();
	private static int HEIGHT = Main.getHeight();
	private static String TITLE = "Lighthouse Broject";
	
	private ModelController mController;
	
	private DesktopFrame dFrame;

	public ViewController(ModelController mController) {
		this.mController = mController;
		dFrame = new DesktopFrame(WIDTH, HEIGHT, TITLE, this.mController);
	}
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}

}
