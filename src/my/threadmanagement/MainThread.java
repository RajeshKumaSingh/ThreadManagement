package my.threadmanagement;

import java.lang.Thread.State;

public class MainThread {

	public static void main(String[] args) {

		// Attributes to Identify a thread, know its status or control its priority

		System.out.println("Current Thread Id: " + Thread.currentThread().getId());
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		System.out.println("Current Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println("Current Thread Status: " + Thread.currentThread().getState() + "\n");

		System.out.println("Minimum Priority: " + Thread.MIN_PRIORITY);
		System.out.println("Normal Priority: " + Thread.NORM_PRIORITY);
		System.out.println("Maximum Priority: " + Thread.MAX_PRIORITY+"\n");

		Thread threads[];
		Thread.State status[];
		threads = new Thread[10];
		status = new Thread.State[10];
		
		// setPriority() method  can throw IllegalArgumentException if priority is out of 0-10 range

		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator());
			if(i%2==0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("MyThread_"+i);
		}

		for (int i = 0; i < 10; i++) {
			status[i]=threads[i].getState();
			threads[i].start();
		}
		
		// Thread class doesn't implement the setId()and setStatus() methods as these methods
		// introduce modification in the code
		// We can't modify the id and status of a thread 

		boolean finish = false;
		while(!finish) {
			for(int i=0;i<10;i++) {
				if(threads[i].getState()!=status[i]) {
					System.out.printf("Main : Id %d - %s\n", threads[i].getId(),threads[i].getName());
					System.out.printf("Main : Priority: %d\n",threads[i].getPriority());
					System.out.println("Main : Old State: "+status[i]);
					System.out.println("Main : New State: "+threads[i].getState());
					System.out.println("************************");
				}
			}
			finish = true;
			for(int i=0;i<10;i++) {
				finish = finish && (threads[i].getState()==State.TERMINATED);
			}
		}

	}

}
