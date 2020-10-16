package Practical2;
import java.io.*;

public class ConvertToEightFilter extends Thread {
	//the pipe coming from the ConvertToIntFilter
	private PipedInputStream pipeIn;
	//the pipe going out to the DisplayFilter
	private PipedOutputStream pipeOut;
	
	public ConvertToEightFilter(PipedInputStream pipeIn, PipedOutputStream pipeOut)
	{
		this.pipeIn = pipeIn;
		this.pipeOut = pipeOut;
	}
	
	public void run ()
	{
		try
		{
			//The ConvertIntToFilter is sending us primitive ints therefore we use a DataInputStream
			DataInputStream int_in = new DataInputStream(pipeIn);
			//The DisplayFilter in expecting objects (int[]) therefore we use an ObjectOutputStream
			ObjectOutputStream object_out = new ObjectOutputStream(pipeOut);
			
			//read in an int
			int read = int_in.readInt();
			
			//loop until termination signal (-1) is received
			while (read != -1)
			{
				//create a new eight array 
				int[] eight = new int[8];
				//fill the array
				for (int i = 0; i < 8; i++)
				{
					eight[i] = read;
					read = int_in.readInt();
				}
				//send the array to the DisplayFilter
				object_out.writeObject(eight);
				//push the data through
				object_out.flush();
			}
			//termination signal received, send termination to the DisplayFilter
			object_out.writeObject(null);
			//push the data through
			object_out.flush();
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
	

}
