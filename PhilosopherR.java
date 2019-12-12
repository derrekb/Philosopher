package Olatunde_Emmanuel_Bland_Elijah_Beeck_Derrek_Navas_Edwin;
/**
 * Class for Philosopher: whom picks up left chopstick before right
 */
import java.util.concurrent.Semaphore;
public class PhilosopherR extends AbPhilosopher {

	//Purpose: To Impelement a Philosopher
    public PhilosopherR(String name, Semaphore chopStick1, Semaphore chopStick2, Semaphore screen) {
       super(name, chopStick1, chopStick2, screen);    }
   
    //Purpose: To enable Philosopher pick up chopsticks
    public void acquirerChopSticks() {
        try{
            chopStick1.acquire();
            chopStick2.acquire();
            acquireScreen();
            this.stateOfMind = 2;
            printState("Eating");
            Thread.sleep(1000);}
        catch (Exception e){
            chopStick1.release();
            chopStick2.release();       }}

    //Purpose: To enable Philosopher drop chopsticks
    public void releaseChopSticks() {
        try{
            printState("Thinking");
            chopStick1.release();
            chopStick2.release();
            this.stateOfMind = 0;}
        catch (Exception ignore){}    }

}
