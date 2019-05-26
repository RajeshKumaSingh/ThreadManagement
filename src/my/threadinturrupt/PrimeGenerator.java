package my.threadinturrupt;

public class PrimeGenerator implements Runnable {

	@Override
	public void run() {
		long number = 1L;
		while(true) {
			if(isPrime(number)) {
				System.out.println("Number "+number+" is Prime");
			}
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("The Prime Generator has been Interrupted");
				return;
			}
			number++;
		}
		

	}

	private boolean isPrime(long number) {
		if(number<=2) return true;
		for(long i=2; i< number/2;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
