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
			if(this.getName()=="Aristotle ") {
			System.out.println("Thinking");}
			if(this.getName()=="Plato ") {
				System.out.println("             Thinking");}
			if(this.getName()=="Socrates ") {
				System.out.println("             "+"             Thinking");}
			if(this.getName()=="Kant ") {
				System.out.println("             "+"             "+"             Thinking");}
			if(this.getName()=="Leibniz "){System.out.println("             "+"             "+"             "+"             Thinking");}
			s.release();
			
			while (true){ 
				Random R = new Random();
				if(R.nextInt(1001)<50) {
					try {s.acquire(); }
					catch(InterruptedException e) {}
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
					s.release();
					
					if(this.isAlive()) {
					try {s.acquire(); r.acquire(); l.acquire(); }
					catch(InterruptedException e) {} 
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
					s.release();r.release(); l.release();}
											
					try {s.acquire();}
					catch(InterruptedException e) {} 
					if(this.getName()=="Aristotle ") {
						System.out.println("Eating");}
					if(this.getName()=="Plato ") {
						System.out.println("             Thinking");}
					if(this.getName()=="Socrates ") {
						System.out.println("             "+"             Thinking");}
					if(this.getName()=="Kant ") {
						System.out.println("             "+"             "+"             Thinking");}
					if(this.getName()=="Leibniz "){System.out.println("             "+"             "+"             "+"             Thinking");}
					s.release();
					} 
					
					
					
			
	}}} 	

		

