package my.threadsleeping;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {
				System.out.println("The File Clock has been interrupted");
				
				/*
				When thread is sleeping and interrupted, the method throws an InterruptedException exception
				immediately and doesn't wait until sleeping time finishes
				*/
			}
		}
	}

}
