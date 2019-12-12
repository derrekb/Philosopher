package Olatunde_Emmanuel_Bland_Elijah_Beeck_Derrek_Navas_Edwin;
/**
 * Class for DiningHall =>> Main Class
 */
import java.util.concurrent.Semaphore;
public class DiningHall {

	//Purpose: Implementing Chopsticks: s1...s5
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(1);
    private static Semaphore s3 = new Semaphore(1);
    private static Semaphore s4 = new Semaphore(1);
    private static Semaphore s5 = new Semaphore(1);
    //Purpose: Implementing Screen Semaphore
    private static Semaphore screen = new Semaphore(1);
    //Purpose: To implement a list of Philosophers
    private static AbPhilosopher[] pl;
    
   //Purpose:To run each Philosopher thread in pl vector
    private static void wineAndDine() {
    	System.out.println("Phil 0        Phil 1       Phil 2      Phil 3        Phil 4");
  		System.out.println("Thinking      Thinking	   Thinking    Thinking      Thinking");
        for(AbPhilosopher p : pl) {
          try{
              screen.acquire();}
          catch (Exception ignore){
              System.out.println("e");          }
          p.start();
          screen.release();      }  }

    //Purpose: Implements the main Method
    public static void main(String[] args) throws Exception {

        AbPhilosopher Aristotle = new PhilosopherR("Aristotle", s1, s2, screen);
        AbPhilosopher Plato = new PhilosopherR("Plato", s2, s3, screen);
        AbPhilosopher Socrates = new PhilosopherR("Socrates", s3, s4, screen);
        AbPhilosopher Kant = new PhilosopherR("Kant", s4, s5, screen);
        AbPhilosopher Leibniz = new PhilosopherL("Leibniz", s5, s1, screen);
        pl = new AbPhilosopher[]{Aristotle, Plato, Socrates, Kant, Leibniz};
        
       wineAndDine();
    }}
