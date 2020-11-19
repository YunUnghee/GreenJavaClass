package version_01;

import java.io.File;

public class Main {
	public static final int SCREEN_WIDTH = 1500;
	public static final int SCREEN_HEIGHT = 1000;
	
	public static void main(String[] args) {
		LoginFrame ui = new LoginFrame();
		SearchFrame sf = new SearchFrame();
		sf.Run();
//		ui.run();
		
	}

}
