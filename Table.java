package Din_Phil_Quiz;

import java.util.concurrent.Semaphore;

public class Table {
	
	/*defining the semaphores. 
	 we need a sempaphore for each chopstick and a screen
	 
	 */
	private static Semaphore chopstick1 = new Semaphore(1);
	private static Semaphore chopstick2 = new Semaphore(1);
	private static Semaphore chopstick3 = new Semaphore(1);
	private static Semaphore chopstick4 = new Semaphore(1);
	private static Semaphore chopstick5 = new Semaphore(1);
	private static Semaphore screenSemaphore = new Semaphore(1);
	
	
	
	public static void main(String[] args) {
		/*defining our threads. Each philosopher is their own thread.
		Each philosopher has a name, a screen, and 2 chopsticks that are specific to their location
		*/
		Thread Aristotle = new Philosopher<String>("Aristotle ",screenSemaphore, chopstick1, chopstick2) ;
		Thread Plato = new Philosopher<String>("Plato ",screenSemaphore, chopstick2, chopstick3) ;
		Thread Socrates = new Philosopher<String>("Socrates ",screenSemaphore, chopstick3, chopstick4) ;
		Thread Kant = new Philosopher<String>("Kant ",screenSemaphore, chopstick4, chopstick5) ;
		Thread Leibniz = new Philosopher<String>("Leibniz ",screenSemaphore, chopstick5, chopstick1) ;
		
		//They all start out thinking first
		System.out.println("Phil 0        Phil 1       Phil 2      Phil 3        Phil 4");
		System.out.println("Thinking      Thinking	   Thinking    Thinking      Thinking");
		
		//starting each of the philosophers up
		Aristotle.start();
		Plato.start();
		Socrates.start();
		Kant.start();
		Leibniz.start();
		
				
		}


	
	

}
