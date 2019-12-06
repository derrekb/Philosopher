package Philosopher;

public interface IPhilosopher<X> {
	
	//purpose: to determine if a philosopher has a left chopstick
	public boolean hasLeft();
	//purpose: to determine if a philosopher has a right chopstick
	public boolean hasRight();
	//purpose to determine if the philosopher is done eating
	public boolean hasEaten();
	//purpose: to determine if a philosopher is hungry
	public boolean isHungry();

}
