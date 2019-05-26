package my.threaddeamon;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
	private Deque<Event> deque;

	public CleanerTask(Deque<Event> deque) {
		super();
		this.deque = deque;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(true) {
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {
		long differance;
		boolean delete;
		
		if(deque.size()==0) {
			return;
		}
		delete=false;
		do {
			Event e = deque.getLast();
			differance = date.getTime() - e.getDate().getTime();
			if(differance > 10000) {
				System.out.println("Cleaner: "+e.getEvent());
				deque.removeLast();
				delete=true;
			}
		}while(differance > 10000);
		
		if(delete) {
			System.out.println("Cleaner: Size of the queue: "+deque.size());
		}
		
	}
	
	
}
