package Philosopher;

import java.util.concurrent.Semaphore;

public class Table implements IPhilosopher{
	
	
	private static Semaphore chopstick1 = new Semaphore(1);
	private static Semaphore chopstick2 = new Semaphore(1);
	private static Semaphore chopstick3 = new Semaphore(1);
	private static Semaphore chopstick4 = new Semaphore(1);
	private static Semaphore chopstick5 = new Semaphore(1);
	private static Semaphore screenSemaphore = new Semaphore(1);
	
	
	
	public static void main(String[] args) {
		
		
		/*this is how I think it should be formated. in the other
		 * produconsum class we had 2 threads and they had a buffer,
		 * bufferesemaphore, and screen semaphore. buffer may need changing
		 * */
		 
	
		Thread Aristotle = new Philosopher<String>(screenSemaphore, chopstick1, chopstick2) ;
		Thread Plato = new Philosopher<String>(screenSemaphore, chopstick2, chopstick3) ;
		Thread Socrates = new Philosopher<String>(screenSemaphore, chopstick3, chopstick4) ;
		Thread Kant = new Philosopher<String>(screenSemaphore, chopstick4, chopstick5) ;
		Thread Leibniz = new Philosopher<String>(screenSemaphore, chopstick5, chopstick1) ;
		
		/*
		 * marco said we need to use try catch so thats what I'm trying to do here
		 * We need it so that randomly a philosopher gets hungry and when they do
		 *  they get put in a queue. At the first opening they grab a chopstick to their left
		 *  or right. Once they grab left for say, they would need to grab right. However we need to worry
		 *  about deadlock where each philosopher is hungry and has one chopstick and wont 
		 *  give it up
		 */
		
		
	
				System.out.println("Philosopher 1:        Philosopher 2:        Philosopher 3:        Philosopher 4:        Philosopher 5:");
		
				Aristotle.start();
				Plato.start();
				Socrates.start();
				Kant.start();
				Leibniz.start();
				
		
	}

	@Override
	public boolean hasLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEaten() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHungry() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
