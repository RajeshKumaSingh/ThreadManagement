package my.threadmanagement;

public class Calculator implements Runnable {

	@Override
	public void run() {

		long current = 1l;
		long max = 2000l;
		long numPrimes = 0l;
		
		System.out.printf("Thread '%s': START\n",Thread.currentThread().getName());
		
		while(current<=max) {
			if(isPrime(current)) {
				numPrimes++;
			}
			current++;
		}
		System.out.printf("Thread '%s': END. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes);
	

	}
	
	private static boolean isPrime(long current) {
		if(current < 2) return true;
		for(long i=2; i<current/2;i++) {
			if(current % i==0) {
				return false;
			}
		}
		return true;
	}

}
