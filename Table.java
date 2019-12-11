package Din_Phil_Quiz;

import java.util.concurrent.Semaphore;

public class Table {
	
	
	private static Semaphore chopstick1 = new Semaphore(1);
	private static Semaphore chopstick2 = new Semaphore(1);
	private static Semaphore chopstick3 = new Semaphore(1);
	private static Semaphore chopstick4 = new Semaphore(1);
	private static Semaphore chopstick5 = new Semaphore(1);
	private static Semaphore screenSemaphore = new Semaphore(1);
	
	
	
	public static void main(String[] args) {
		
		
		Thread Aristotle = new Philosopher<String>("Aristotle ",screenSemaphore, chopstick1, chopstick2) ;
		Thread Plato = new Philosopher<String>("Plato ",screenSemaphore, chopstick2, chopstick3) ;
		Thread Socrates = new Philosopher<String>("Socrates ",screenSemaphore, chopstick3, chopstick4) ;
		Thread Kant = new Philosopher<String>("Kant ",screenSemaphore, chopstick4, chopstick5) ;
		Thread Leibniz = new Philosopher<String>("Leibniz ",screenSemaphore, chopstick5, chopstick1) ;
		System.out.println("Phil0        Phil1       Phil2        Phil3        Phil4");
		
		Aristotle.start();
		Plato.start();
		Socrates.start();
		Kant.start();
		Leibniz.start();
		
				
		}


	
	

}
