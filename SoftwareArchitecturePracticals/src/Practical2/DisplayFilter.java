package Practical2;
import java.io.*;

public class DisplayFilter extends Thread {
	//the pipe coming in from the ConvertToEightFilter
	private PipedInputStream pipeIn;
	
	public DisplayFilter(PipedInputStream pipeIn)
	{
		this.pipeIn = pipeIn;
	}
	
	public void run()
	{
		try
		{
			//The ConvertToEightFilter sends objects (int[]) therefore we need to use an ObjectInputStream
			ObjectInputStream object_in = new ObjectInputStream(pipeIn);
			
			//read in the next int[]
			int[] ints = (int[])object_in.readObject();
			
			//loop until the termination signal (null) is sent
			while (ints != null)
			{
				//display each int in the array 
				for (int i = 0; i < ints.length; i++)
				{
					System.out.println(ints[i] + "\t");
				}
				System.out.println();
				//Read in the next int
				ints = (int[])object_in.readObject();
			}
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Unxpected object in stream");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
	}

}
