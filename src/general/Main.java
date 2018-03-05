package general;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.concurrent.ThreadLocalRandom;

import de.cau.infprogoo.lighthouse.LighthouseDisplay;
import model.ModelController;
import viewcontroller.DesktopFrame;
import viewcontroller.ViewController;

public class Main {

	private static int WIDTH = 500;
	private static int HEIGHT = 800;
	private static String TITLE = "Lighthouse Broject Beta";
	
	private static ModelController mController;
	private static ViewController vController;
	
	public static DesktopFrame frame;
	

	public static void main(String[] args) {
		
		mController = new ModelController();
		vController = new ViewController(mController);
		vController.start();

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
	
	public static ViewController getVController() {
		return vController;
	}

}
