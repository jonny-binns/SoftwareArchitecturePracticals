package Practical1;
import java.io.*;

public class ReadFileFilter extends Thread {
	//the pipe connected to the ConvertToIntFilter
	private PipedOutputStream pipeOut;
	private ObjectInputStream input_file;
	
	public ReadFileFilter (PipedOutputStream pipeOut)
	{
		this.pipeOut = pipeOut;
	}
	
	public void run()
	{
		try
		{
			//open the file
			FileInputStream file = new FileInputStream("three.dat");
			input_file = new ObjectInputStream(file);
			//We are sending objects (int[]) to the ConvertToIntFilter so we use ObjectOutputStream
			ObjectOutputStream object_out = new ObjectOutputStream(pipeOut);
			
			//loop until file is empty
			while(file.available() > 0)
			{
				//read in the next object from file
				Object obj = input_file.readObject();
				//write the object to the ConvertToIntFilter
				object_out.writeObject(obj);
				//push the data through
				object_out.flush();
			}
			
			//file is empty send termination signal (null)
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
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Unexpected class in file");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
	}

}
