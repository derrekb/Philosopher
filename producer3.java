package pc;

import java.util.concurrent.Semaphore;

public class producer3<X> extends Thread
{ 
	IBuffer<X> B; Semaphore s, scr;

	public producer3(IBuffer<X> t, Semaphore buffersem, Semaphore screensem)
{
		B = t; s = buffersem; scr = screensem; }

	@SuppressWarnings("unchecked")

	public void run()
{ 
		int n = 0;

		try { scr.acquire(); } catch(InterruptedException e) { }

		System.out.println("Hello from the producer!");

		scr.release();

		while (true)
{ 
			try { scr.acquire(); s.acquire(); } catch(InterruptedException e) {}

			if (!B.isFull())
{ 
				B.add((X) (n + ""));

				System.out.println("Produced: " + n);

				n = n + 1; }

			scr.release(); s.release();
} } }