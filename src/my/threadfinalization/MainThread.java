package my.threadfinalization;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String[] args) {
		/*
		In some situation, we will have to wait for the finalization of a thread. For example,
		we may have a program that will being initialization the resources it needs before proceeding with
		the rest of the execution. We can run the initialization tasks  as threads and wait for its finalization
		before continuing with the rest of the program.
		
		For this purpose, we can use the join() method of the Thread class. When we call this method using
		a thread object, it suspends the execution of the calling thread until the object called finishes 
		its execution.
		*/
		
		Thread dataSourceLoaderThread = new Thread(()-> {
			System.out.println("Begining of data source loader at "+new Date());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Data source loading completed");
		});
		
		Thread networkConnectionLoaderThread = new Thread(()-> {
			System.out.println("Begining of network connection source loader at "+new Date());
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Network connection source loading completed");
		});
		
		dataSourceLoaderThread.start();
		networkConnectionLoaderThread.start();
		
		try {
			dataSourceLoaderThread.join();
			networkConnectionLoaderThread.join();
			
			/*  
			   join(long millisecond)
			   join(long millisecond, long nanosecond)
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main: Configuration has been loaded at "+new Date());

	}

}
