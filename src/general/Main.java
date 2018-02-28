package general;

import model.ModelController;
import viewcontroller.DesktopFrame;
import viewcontroller.ViewController;

public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 800;
	private static String TITLE = "Lighthouse Broject";
	
	private static ModelController mController;
	private static ViewController vController;
	
	public static DesktopFrame frame;

	public static void main(String[] args) {
		
		mController = new ModelController();
		vController = new ViewController(mController);

	}
	
	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}
	
	public static ModelController getMController() {
		return mController;
	}

}
