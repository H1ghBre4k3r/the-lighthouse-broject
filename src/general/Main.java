package general;

import entities.Ball;
import entities.Player;
import viewcontroller.DesktopFrame;

public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 700;
	private static String TITLE = "Lighthouse Broject";
	
	private static ModelController controller;
	
	public static DesktopFrame frame;

	public static void main(String[] args) {
		
		controller = new ModelController();

		frame = new DesktopFrame(WIDTH, HEIGHT, TITLE, controller.getPLAYER(), controller.getBALL());
	}
	
	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}
	
	public static ModelController getController() {
		return controller;
	}

}
