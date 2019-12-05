package pc;

public interface IBuffer<X>
{ 
	// Purpose: To determine if the buffer is empty
	public boolean isEmpty();
	// Purpose: To determine if the buffer is full
	public boolean isFull();
	// Purpose: To add the given String to the buffer
	// Assumption: The buffer is not full
	public void add(X s);
	// Purpose: To remove the next X from this buffer
	public X remove();
	// Purpose: To get the number of elems in the buffer
	public int getNumelems();
	// Purpose: To print the buffer to the output screen
	public void printBuffer();
}