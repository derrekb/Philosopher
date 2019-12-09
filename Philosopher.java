package Philosopher;
import java.util.concurrent.Semaphore;

public class Philosopher<X> extends Thread {
	
	IPhilosopher<X> P; 
	Semaphore l, r;
	
	public Philosopher(IPhilosopher<X> t, Semaphore Lchopstick, Semaphore Rchopstick)
	{
			P = t; l = Lchopstick; r = Rchopstick; }

		@SuppressWarnings("unchecked")

		public void run()
	{ 
			int n = 0;

			try { r.acquire(); } catch(InterruptedException e) { }

			System.out.println("waiting");

			r.release();
			
			int n1 = 0;
			
			try { l.acquire(); } catch(InterruptedException e) { }

			System.out.println("waiting");

			l.release();

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
					}
//Release both chopsticks when done
				
				r.release(); l.release();
	} } }
