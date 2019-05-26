package my.threaddeamon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {

	private Deque<Event> deque;
	
	
	public WriterTask(Deque<Event> deque) {
		super();
		this.deque = deque;
	}


	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			Event event=new Event(new Date(), "The thread "+Thread.currentThread().getId()+" has generated an event");
			deque.addFirst(event);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
