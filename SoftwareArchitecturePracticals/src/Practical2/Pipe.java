package Practical2;
import java.io.*;

public class Pipe {

	public static void main(String[] args) {
		try
		{
			//create the pipe
			PipedReader pipeOut = new PipedReader();
			PipedWriter pipeIn = new PipedWriter(pipeOut);
			
			//create the two threads
			InPipeThread t1 = new InPipeThread(pipeIn);
			OutPipeThread t2 = new OutPipeThread(pipeOut);
			
			//start the threads
			t1.start();
			t2.start();
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}

	}

}