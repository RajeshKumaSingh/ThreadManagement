package my.threadgroup;

import java.util.concurrent.TimeUnit;

public class MainThread {

	public static void main(String arg[]) {
		
		/*
		An interesting functionality offered by the concurrency API of Java is the ability to group the
		threads. This allows us to treat the threads of a group as a single unit and provides access to
		the Thread objects that belong to a group to do an operation with them. For example, you have
		some threads doing the same task and you want to control them, irrespective of how many
		threads are still running, the status of each one will interrupt all of them with a single call.
		
		Java provides the ThreadGroup class to work with groups of threads. A ThreadGroup object
		can be formed by Thread objects and by another ThreadGroup object, generating a tree
		structure of threads.
		*/
		
		ThreadGroup threadGroup=new ThreadGroup("Searcher") {
			
			/*
			Override the uncaughtException() method. This method is called when an
			exception is thrown in one of the threads of the ThreadGroup class. In this case,
			this method will write in the console information about the exception and Thread
			that throws it and interrupts the rest of the threads in the ThreadGroup class.
			*/
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("The thread %s has thrown an Exception\n",t.
			getId());
			e.printStackTrace(System.out);
			System.out.printf("Terminating the rest of the Threads\n");
			interrupt();
			}
		};
		
		Result result = new Result();
		SearchTask searchTask=new SearchTask(result);
		for(int i=0;i<5;i++) {
			Thread thread = new Thread(threadGroup,searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		// Write information about the ThreadGroup object using the list() method.
		
		System.out.println("Number of threads: "+threadGroup.activeCount());
		System.out.println("Information about the ThreadGroup: \n");
		threadGroup.list();
		
		/*
		Use the activeCount() and enumerate() methods to know how many Thread
		objects are associated with the ThreadGroup objects and get a list of them. We can
		use this method to get, for example, the state of each Thread.
		*/
		
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for(int i=0;i<threadGroup.activeCount();i++) {
			System.out.println("Thread: "+threads[i].getName()+" Status: "+threads[i].getState());
		}
		
		//It will use the activeCount() method to control the end of one of the threads.
		
		while(threadGroup.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		threadGroup.interrupt();
	}
}
