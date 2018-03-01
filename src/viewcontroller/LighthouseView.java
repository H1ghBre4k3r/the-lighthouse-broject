package viewcontroller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import de.cau.infprogoo.lighthouse.LighthouseDisplay;
import general.Main;

public class LighthouseView {
	
	private LighthouseDisplay display;

	public LighthouseView() {
		init();
		draw();
	}
	
	private void init() {
		display = new LighthouseDisplay("louismeyer", "API_TOKEN", 1);
		try {
			display.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void draw() {
		byte[] bytes = new byte[1176];
		for(int i = 0; i < bytes.length; i++) {
			/*bytes[i] = (byte) 0;
			bytes[i + 1] = (byte) 255;
			bytes[i + 2] = (byte) 255;*/
			bytes[i] = (byte) ThreadLocalRandom.current().nextInt(0, 255);
		}
		try {
			display.send(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		draw();
	}

}
