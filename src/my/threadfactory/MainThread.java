package my.threadfactory;

import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		
		/*
		Java provides an interface, the ThreadFactory interface to implement a Thread
		object factory. Some advanced utilities of the Java concurrency API use thread factories
		to create threads.
		*/

		MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		Thread thread;
		for (int i = 0; i < 10; i++) {
			thread = threadFactory.newThread(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			thread.start();
		}
		
		System.out.println("Factory Stats : \n"+threadFactory.getStats());

	}

}
