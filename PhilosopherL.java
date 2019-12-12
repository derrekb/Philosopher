package Olatunde_Emmanuel_Bland_Elijah_Beeck_Derrek_Navas_Edwin;
/**
 * Class for Philosopher: whom picks up right chopstick before left
 */
import java.util.concurrent.Semaphore;
public class PhilosopherL extends AbPhilosopher {

	//Purpose: To Impelement a Philosopher
    public PhilosopherL(String name, Semaphore chopStick1, Semaphore chopStick2, Semaphore screen) {
        super(name, chopStick1, chopStick2, screen);    }

    //Purpose: To enable Philosopher pick up chopsticks
    public void acquirerChopSticks() {
        try{
            chopStick2.acquire();
            chopStick1.acquire();
            acquireScreen();
            this.stateOfMind = 2;
            printState("Eating");
            Thread.sleep(1000);}
        catch (Exception e){
            chopStick2.release();
            chopStick1.release();       }}

    //Purpose: To enable Philosopher drop chopsticks
    public void releaseChopSticks() {
        try{
            printState("Thinking");
            chopStick2.release();
            chopStick1.release();
            this.stateOfMind = 0;}
        catch (Exception ignore){}    }

}
