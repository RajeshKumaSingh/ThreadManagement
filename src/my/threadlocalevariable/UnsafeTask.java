package my.threadlocalevariable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	
	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.println("Starting thread: "+Thread.currentThread().getName()+" at: "+startDate);
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished thread: "+Thread.currentThread().getName()+" at: "+startDate);
	}

}
