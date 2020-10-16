package Practical2;
import java.io.*;

public class ReadLineThread extends Thread {
	private PipedWriter pipeIn;
	private BufferedReader input_file;
	
	ReadLineThread(PipedWriter pipeIn)
	{
		this.pipeIn = pipeIn;
	}
	
	public void run()
	{
		try
		{
			//open the file
			FileReader file = new FileReader("kwic.dat");
			input_file = new BufferedReader(file);
			
			//loop until EOF
			while (input_file.ready())
			{
				//read next line from file
				String line = input_file.readLine();
				//write line to the pipe
				pipeIn.write(line + "\n");
				//push the data through
				pipeIn.flush();
			}
		}
		catch (FileNotFoundException fnf)
		{
			System.err.println("Could not open file");
			System.err.println(fnf.getMessage());
			System.exit(-1);
		}
		catch (IOException ioe)
		{
			System.err.print("Error during I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}

}
