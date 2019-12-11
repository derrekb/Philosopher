package Din_Phil_Quiz;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Philosopher<X> extends Thread implements IPhilosopher<X>{
	
	Semaphore l, r,s;
	
	public Philosopher(String n,Semaphore screenSemaphore, Semaphore Lchopstick, Semaphore Rchopstick){
			super (n);s = screenSemaphore; l = Lchopstick; r = Rchopstick; }

		@SuppressWarnings("unchecked")

		public void run()	{ 
			System.out.println(this.getName()+"Thinking");
			int I = 1;
			while (I==1){ 
				try {s.acquire(); } catch(InterruptedException e) {}
					System.out.println(this.getName()+"Thinking");
					Random R = new Random();
					if(R.nextInt(1001)<100) {
					System.out.println(this.getName()+"Hungry");	
					try {r.acquire(); l.acquire(); 
						System.out.println(this.getName()+"Eating");
					} catch(InterruptedException e) {} }
					
			s.release();r.release(); l.release();
	} }
		
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
		}}

