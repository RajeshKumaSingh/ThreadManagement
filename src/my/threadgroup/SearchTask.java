package my.threadgroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

	private Result result;
	
	public SearchTask(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Thread starts: "+name);
		try {
			doTask();
			result.setName(name);
		}catch(InterruptedException ie) {
			System.out.println("Thread "+name+" is interrupted");
			return;
		}
		System.out.println("Thread End: "+name);
	}

	private void doTask() throws InterruptedException {
		Random random = new Random(new Date().getTime());
		int value = (int)(random.nextDouble()*50);
		System.out.println("Thread: "+Thread.currentThread().getName()+" Value: "+value);
		TimeUnit.SECONDS.sleep(value);
	}
	

}
