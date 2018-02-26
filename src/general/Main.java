package general;

import viewcontroller.DesktopFrame;

public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 700;
	private static String TITLE = "Lighthouse Broject";
	
	public static DesktopFrame frame;

	public static void main(String[] args) {
		
		System.out.println("Hello World!");

		DesktopFrame frame = new DesktopFrame(WIDTH, HEIGHT, TITLE);
	}

}
