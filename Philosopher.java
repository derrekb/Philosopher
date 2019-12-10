package Philosopher;
import java.util.concurrent.Semaphore;

public class Philosopher<X> extends Thread {
	
	IPhilosopher<X> P; 
	Semaphore l, r,s;
	
	public Philosopher(Semaphore screenSemaphore, Semaphore Lchopstick, Semaphore Rchopstick)
	{
			s = screenSemaphore; l = Lchopstick; r = Rchopstick; }

		@SuppressWarnings("unchecked")

		public void run()
	{ 
			int n = 0;

			try { r.acquire(); } catch(InterruptedException e) { }

			System.out.println("thinking");

		
			
			int n1 = 0;
			
			try { l.acquire(); } catch(InterruptedException e) { }

			System.out.println("thinking");


			
			int n2 = 0;
			
			try { s.acquire(); } catch(InterruptedException e) { }

			System.out.println("thinking");

			while (true)
	{ 
				try { r.acquire(); l.acquire(); } catch(InterruptedException e) {}
//once the philosopher has eaten they can drop the chosticks
				if (P.hasEaten())
	{ 
					//P.add((X) (n + ""));

					System.out.println(P + "ate");

					n = n + 1; 
					n1 = n1 + 1;
					n2 = n2 + 1;
					}
//Release both chopsticks when done
				
				s.release();r.release(); l.release();
	} } }
