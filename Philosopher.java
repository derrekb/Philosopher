package Din_Phil_Quiz;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Philosopher<X> extends Thread {
	
	Semaphore l, r,s;
	
	public Philosopher(String n,Semaphore screenSemaphore, Semaphore Lchopstick, Semaphore Rchopstick){
			super (n); s = screenSemaphore; l = Lchopstick; r = Rchopstick; }

		@SuppressWarnings("unchecked")

		public void run()	{ 
			try {s.acquire(); } 
			catch(InterruptedException e) {}
			System.out.println(this.getName()+"Thinking");
			s.release();
			
			while (true){ 
				Random R = new Random();
				if(R.nextInt(1001)<50) {
					try {s.acquire(); }
					catch(InterruptedException e) {}
					System.out.println(this.getName()+"Hungry");
					s.release();
					
					try {s.acquire();r.acquire(); l.acquire(); }
					catch(InterruptedException e) {} 
					System.out.println(this.getName()+"Eating");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {e1.printStackTrace();}
					s.release();r.release(); l.release();
											
					try {s.acquire();}
					catch(InterruptedException e) {} 
					System.out.println(this.getName()+"Thinking");
					s.release();
					} 
					
					
					
			
	}}} 	

		

