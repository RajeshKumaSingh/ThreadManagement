package my.threadlocalevariable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	
	/*
	Thread-local variables store a value of an attribute for each Thread that uses one of these
	variables. We can read the value using the get() method and change the value using the
	set() method. The first time we access the value of a thread-local variable, if it has no value
	for the Thread object that it is calling, the thread-local variable calls the initialValue()
	method to assign a value for that Thread and returns the initial value.
	*/

	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.println("Starting thread: "+Thread.currentThread().getName()+" at: "+startDate.get());
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished thread: "+Thread.currentThread().getName()+" at: "+startDate.get());
	}
	
	/*
	The thread-local class also provides the remove() method that deletes the value stored in
	the thread-local variable for the thread that it's calling.
	
	The Java Concurrency API includes the InheritableThreadLocal class that provides
	inheritance of values for threads created from a thread. If a thread A has a value in a thread-local
	variable and it creates another thread B, the thread B will have the same value as the
	thread A in the thread-local variable. You can override the childValue() method that is
	called to initialize the value of the child thread in the thread-local variable. It receives the
	value of the parent thread in the thread-local variable as a parameter.
	*/

}
