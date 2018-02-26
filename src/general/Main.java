package general;

import entities.Ball;
import entities.Player;
import viewcontroller.DesktopFrame;

public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 700;
	private static String TITLE = "Lighthouse Broject";
	private static Player PLAYER;
	private static Ball BALL;
	
	public static DesktopFrame frame;

	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		Player PLAYER = new Player(WIDTH / 2 - 50, HEIGHT - 50, 100, 20);
		Ball BALL = new Ball(WIDTH / 2, HEIGHT - 80, 30);

		DesktopFrame frame = new DesktopFrame(WIDTH, HEIGHT, TITLE, PLAYER, BALL);
	}

}
