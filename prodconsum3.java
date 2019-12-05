package pc;

import java.util.concurrent.Semaphore;

public class prodconsum3
{ 
	private static stringBuffer buffer = new stringBuffer(10);
	private static Semaphore bufferSemaphore = new Semaphore(1);
	private static Semaphore screenSemaphore = new Semaphore(1);
	

	public static void main(String[] args)
{ 
	
		Thread c = new consumer3<String>(buffer, bufferSemaphore, screenSemaphore);
		Thread p = new producer3<String>(buffer, bufferSemaphore, screenSemaphore);

		try { screenSemaphore.acquire(); }

		catch(InterruptedException e) { }

		c.start();

		System.out.println("Consumer started...");

		screenSemaphore.release();

		try { screenSemaphore.acquire(); }

		catch(InterruptedException e) { }

		p.start();

		System.out.println("Producer started...");

		screenSemaphore.release(); } }