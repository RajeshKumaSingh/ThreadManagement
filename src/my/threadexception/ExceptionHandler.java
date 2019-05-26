package my.threadexception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable e) {
		System.out.println("An exception has been captured");
		System.out.println("Thread: "+thread.getName());
		System.out.println("Exception: ");
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.println("Stack Trace: ");
		e.printStackTrace(System.out);
		System.out.println("Thread status: "+thread.getState());
	}
	
	

}
