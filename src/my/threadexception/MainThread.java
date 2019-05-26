package my.threadexception;

public class MainThread {

	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
			int num = Integer.parseInt("TT");
		});
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
		
		/*
		 
		When an exception is thrown in a thread and is not caught (it has to be an unchecked
		exception), the JVM checks if the thread has an uncaught exception handler set by the
		corresponding method. If it has, the JVM invokes this method with the Thread object and
		Exception as arguments.
		
		If the thread has not got an uncaught exception handler, the JVM prints the stack trace in the
		console and exits the program.
		
		The Thread class has another method related to the process of uncaught exceptions. It's the
		static method setDefaultUncaughtExceptionHandler() that establishes an exception
		handler for all the Thread objects in the application.
		
		When an uncaught exception is thrown in Thread, the JVM looks for below possible handlers
		for this exception.
			First, it looks for the uncaught exception handler of the Thread objects. 
			
			If this handler doesn't exist, then the JVM looks for the uncaught exception handler
				for ThreadGroup of the Thread objects. 
				
			If this method doesn't exist, the JVM looks for the default uncaught exception handler.
			
			If none of the handlers exits, the JVM writes the stack trace of the exception in the console
			and exits the program.
		*/
	}

}
