package my.threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	
	/*
	Java provides an interface, the ThreadFactory interface to implement a Thread
	object factory. Some advanced utilities of the Java concurrency API use thread factories
	to create threads.
	*/
	
	/*
	The ThreadFactory interface has only one method called newThread. It receives a
	Runnable object as a parameter and returns a Thread object. When you implement a
	ThreadFactory interface, you have to implement that interface and override this method.
	Most basic ThreadFactory, has only one line.
	return new Thread(r);
	
	We can improve this implementation by adding some variants by:
	# Creating personalized threads, as in the example, using a special format for the name
	or even creating our own thread class that inherits the Java Thread class
	# Saving thread creation statistics, as shown in the previous example
	# Limiting the number of threads created
	# Validating the creation of the threads
	# And anything more you can imagine
	
	The use of the factory design pattern is a good programming practice but, if you implement a
	ThreadFactory interface to centralize the creation of threads, you have to review the code
	to guarantee that all threads are created using that factory.
	*/
	
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name) {
		super();
		this.name = name;
		this.counter = 0;
		this.stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable,name+"-Thread_"+counter);
		counter++;
		stats.add("Created thread "+thread.getId()+" with name "+thread.getName()+" on "+new Date());
		return thread;
	}
	
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		if(stats !=null) {
			for(String str: stats) {
				sb.append(str+"\n");
			}
		}
		return sb.toString();
	}

}
