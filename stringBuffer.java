package pc;

public class stringBuffer implements IBuffer<String>
{ 
	private String[] buffer; private int cindex, pindex, numelems;

	public stringBuffer(int n)
{ 
		buffer = new String[n]; 
		cindex = 0;
		pindex = 0;
		numelems = 0;
		}
	
	public boolean isEmpty() {return(numelems == 0); }
	public boolean isFull() {return(numelems == buffer.length);}
	public int getNumelems() { return(numelems); }
	public void add(String s)
{
		buffer[pindex] = s;

		pindex = (pindex + 1) % buffer.length;
		numelems = numelems + 1;
		
 }
	
	public String remove()
	{ 
		String t = buffer[cindex];
		buffer[cindex] = null;
		cindex = (cindex + 1) % buffer.length;
		numelems = numelems - 1;
	return(t);
	}
	public void printBuffer()
	{ 
		for(int i=0; i<buffer.length ; i++)
			
	System.out.print(buffer[i] + " ");
	}
	}
