package Din_Phil_Quiz;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Philosopher<X> extends Thread {
	
	//defining the semaphores, left, right, and screen
	Semaphore l, r,s;
	
	//a philosopher is composed of a string, screen semaphore, and left and right chopstick semaphore
	public Philosopher(String n,Semaphore screenSemaphore, Semaphore Lchopstick, Semaphore Rchopstick){
		
		  //super is used to invoke the parent class method 
			super (n); s = screenSemaphore; l = Lchopstick; r = Rchopstick; }

		@SuppressWarnings("unchecked")

		//main function to run
		public void run()	{ 
			while (true){ 
				
				//the instances of thinking, hungry, and eating are random and we need to define a new random
				Random R = new Random();
				
				if(R.nextInt(1001)<500) {
					
					//try to acquire the screen semaphore
					try {s.acquire(); }
					//once they have the screen they become hungry
					catch(InterruptedException e) {}
					
					//if the .getName is equal to the philosopher name then print out that they are hungry since they have the screen semaphore
					if(this.getName()=="Aristotle ") {
						System.out.println("Hungry");}
						if(this.getName()=="Plato ") {
							System.out.println("             Hungry");}
						if(this.getName()=="Socrates ") {
							System.out.println("             "+"             Hungry");}
						if(this.getName()=="Kant ") {
							System.out.println("             "+"             "+"             Hungry");}
						if(this.getName()=="Leibniz ")
						{System.out.println("             "+"             "+"             "+"             Hungry");}
				//release the screen semaphore
						s.release();
				
					//trying to acquire all 3 semaphores
					try {s.acquire(); r.acquire(); l.acquire(); }
					catch(InterruptedException e) {} 
					//once a philosopher has all three they can eat
					if(this.getName()=="Aristotle ") {
						System.out.println("Eating");}
						if(this.getName()=="Plato ") {
							System.out.println("             Eating");}
						if(this.getName()=="Socrates ") {
							System.out.println("             "+"             Eating");}
						if(this.getName()=="Kant ") {
							System.out.println("             "+"             "+"             Eating");}
						if(this.getName()=="Leibniz ")
						{System.out.println("             "+"             "+"             "+"             Eating");}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {e1.printStackTrace();}
						//once they have eaten, all the semaphores can be released
						s.release();r.release(); l.release();
						
						//try to acquire the screen semaphore again
					try {s.acquire();}
					catch(InterruptedException e) {} 
					//once they're done eating they go to back to thinking
					if(this.getName()=="Aristotle ") {
						System.out.println("Thinking");}
					if(this.getName()=="Plato ") {
						System.out.println("             Thinking");}
					if(this.getName()=="Socrates ") {
						System.out.println("             "+"             Thinking");}
					if(this.getName()=="Kant ") {
						System.out.println("             "+"             "+"             Thinking");}
					if(this.getName()=="Leibniz "){System.out.println("             "+"             "+"             "+"             Thinking");}
					//once the thinking has been printed out the three semaphores can be released.
					s.release();r.release(); l.release();
					
					} 
					
					
					
			
	}}} 	

		

