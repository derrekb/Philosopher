package Olatunde_Emmanuel_Bland_Elijah_Beeck_Derrek_Navas_Edwin;
/**
 * Class for AbPhilosopher => Philosopher Abstract Class
 */
import java.util.Random;
import java.util.concurrent.Semaphore;
public abstract class AbPhilosopher extends Thread implements IPhilosopher {
	
    protected volatile int stateOfMind; 
    // 0: thinking   1: hungry   2: Eating
    protected volatile Semaphore chopStick1;
    //left chopstick
    protected volatile Semaphore chopStick2;
    //right chopstick
    protected volatile Semaphore screen;
    //screen-time
    protected volatile Random rand = new Random();
    protected final int RAND_NUMBER = 3000;

    //Purpose: To implement a Philosopher
    public AbPhilosopher(String name, Semaphore chopStick1, Semaphore chopStick2, Semaphore screen) {
        super(name);
        this.stateOfMind = 0;
        this.chopStick1 = chopStick1; 
        this.chopStick2 = chopStick2; 
        this.screen = screen;           }

    //Purpose: To print out the mind-state of the Philosopher
    protected void printState(String state) {
    	if(this.getName()=="Aristotle") {
			System.out.println(state);}
			if(this.getName()=="Plato") {
				System.out.println("               "+state);}
			if(this.getName()=="Socrates") {
				System.out.println("             "+"              "+state);}
			if(this.getName()=="Kant") {
				System.out.println("             "+"             "+"              "+state);}
			if(this.getName()=="Leibniz")
			{System.out.println("             "+"             "+"              "+"             "+state);}
    }

    //Purpose: To enable Philosopher acquire screen-time
    protected void acquireScreen() {
        try{
            screen.acquire();}
        catch (Exception e){
            e.printStackTrace();        }}
    
    //Purpose: To enable Philos0pher release screen-time
    protected void releaseScreen() {
    	screen.release();    }
    
   //Purpose: To execute the thread
    public void run() {
        while (true) {
            int num = rand.nextInt(RAND_NUMBER); // simulate down time
            if(num == 0){
               changState();          }  }  }
    
    /**Purpose:
     * Changes the state of the Philosopher is follows:
     *  - state is 0 => 1
     *  - state is 1 => 2
     *  - state is 2 => 0
     */
    public void changState() {
        switch (this.stateOfMind) {
        	//To Hungry State
            case 0:
                acquireScreen();
                this.stateOfMind = 1;
                printState("Hungry");
                releaseScreen();
                break;
            //To Eating State
            case 1 :
                acquirerChopSticks();
                releaseScreen();
                break;
            //To Thinking State
            case 2:
                acquireScreen();
                releaseChopSticks();
                releaseScreen();
                break;    }  }
}
