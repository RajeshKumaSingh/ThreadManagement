package my.threadinturrupt.control;

import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) {
		/*
		If the implements a complex algorithm divided into some methods,
		or it has methods with recursive calls, we can use a better mechanism to control
		the interruption of Thread. Java provides the InterruptException exception for this Purpose.
		We can throw this exception when we detect the interruption of the thread and catch it in the run method.
		*/
		
		FileSearch fileSearch = new FileSearch("D:\\", "Paltan 2018.mp4");
		Thread thread = new Thread(fileSearch);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
