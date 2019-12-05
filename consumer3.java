package pc;

import java.util.concurrent.Semaphore;


	public class consumer3<X> extends Thread
{
		IBuffer<X> B; Semaphore s, scr;

		public consumer3(IBuffer<X> t, Semaphore sembuffer, Semaphore screensem)
{ 
			B = t; s = sembuffer; scr =screensem;
			}

		public void run()
{ 
			X t;

			try { scr.acquire(); } catch(InterruptedException e) { }

			System.out.println("Hello from the consumer!");

			scr.release();

			while (true)
{ 
				try { scr.acquire(); s.acquire(); }

				catch(InterruptedException e) {}

				if (!B.isEmpty())
{
					t = B.remove();

					System.out.println("Processed: " + t); }

				scr.release();

				s.release();
} } }