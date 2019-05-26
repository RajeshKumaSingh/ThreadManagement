package my.threadinturrupt;

public class MainThread {
	
	public static void main(String arg[]) {
		Thread task = new Thread(new PrimeGenerator());
		task.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.interrupt();
		
		boolean b=task.interrupted();  //  makes interrupt value as false
		System.out.println(b);
		
		/*
		The Thread class has an attribute that stores  a boolean value indicating whether the
		thread has been interrupted or not. When you call the interrupt() method of a thread,
		you set that attribute to true. The isInterrupted() method only returns the value of that attribute.
		*/
		
		
		
		
	}
	
}
