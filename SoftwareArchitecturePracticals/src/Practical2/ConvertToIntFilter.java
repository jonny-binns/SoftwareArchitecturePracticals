package Practical2;
import java.io.*;

public class ConvertToIntFilter extends Thread {
	//the pipe coming in from ReadFileFilter
	private PipedInputStream pipeIn;
	//pipe going to ConvertToEight Filter
	private PipedOutputStream pipeOut;
	
	public ConvertToIntFilter(PipedInputStream pipeIn, PipedOutputStream pipeOut)
	{
		this.pipeIn = pipeIn;
		this.pipeOut = pipeOut;
	}
	
	public void run()
	{
		try
		{
			//The ReadFileFilter is sending us objects (int[]), therefore we must use ObjectInputStream
			ObjectInputStream object_in = new ObjectInputStream(pipeIn);
			//The ConvertToEightFilter expects primitive integers, therefore we use DataOutputStream
			DataOutputStream int_out = new DataOutputStream(pipeOut);
			
			//read in the first int[]
			int[] ints = (int[])object_in.readObject();
			
			//While the termination signal (null) is not sent
			while (ints != null)
			{
				//Foreach int in the array
				for (int i = 0; i < ints.length; i++)
				{
					//write the int to the ConvertToEightFilter
					int_out.writeInt(ints[i]);
					//push the data through
					int_out.flush();
				}
				//read in the next int[]
				ints = (int[])object_in.readObject();
			}
			//the termination signal has been received, send our termination signal (-1)
			int_out.writeInt(-1);
			//push the data through
			int_out.flush();
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Unexpected class in file");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
	}

}
