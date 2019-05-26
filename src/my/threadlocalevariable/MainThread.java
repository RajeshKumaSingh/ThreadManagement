package my.threadlocalevariable;

import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		/*
		One of the most critical aspects of a concurrent application is shared data. This has
		special importance in those objects that extend the Thread class or implement the
		Runnable interface.
		
		If we create an object of a class that implements the Runnable interface and then start
		various Thread objects using the same Runnable object, all the threads share the same
		attributes. This means that, if we change an attribute in a thread, all the threads will be
		affected by this change.
		
		Sometimes, we will be interested in having an attribute that won't be shared between all the
		threads that run the same object. The Java Concurrency API provides a clean mechanism
		called thread-local variables with a very good performance.
		*/
		
		UnsafeTask task = new UnsafeTask();
		for(int i=0;i<10;i++) {
			Thread thread= new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*
		In run we are not changing startdate. But startdate is different for start and finish
		Starting thread: Thread-5 at: Mon Apr 08 18:26:07 IST 2019
		Finished thread: Thread-5 at: Mon Apr 08 18:26:13 IST 2019
		*/
		
		SafeTask safetask = new SafeTask();
		for(int i=0;i<10;i++) {
			Thread thread= new Thread(safetask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*
		  Using ThreadLoacle all start and finish at same time
		  
		  Starting thread: Thread-18 at: Mon Apr 08 18:40:08 IST 2019
		  Finished thread: Thread-18 at: Mon Apr 08 18:40:08 IST 2019
		 */
		
		
	}

}
