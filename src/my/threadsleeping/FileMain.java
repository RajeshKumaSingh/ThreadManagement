package my.threadsleeping;

import java.util.concurrent.TimeUnit;

public class FileMain {

	public static void main(String[] args) {
		FileClock fileClock = new FileClock();
		Thread thread = new Thread(fileClock);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
		
		/*
		When thread is sleeping and interrupted, the method throws an InterruptedException exception
		immediately and doesn't wait until sleeping time finishes
		*/
	}

}
