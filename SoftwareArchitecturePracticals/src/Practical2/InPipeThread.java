package Practical2;
import java.io.*;

public class InPipeThread extends Thread {
	//the writing at the end of the pipe
	private PipedWriter pipeIn;
	private BufferedReader input_file;
	
	InPipeThread(PipedWriter pipeIn)
	{
		this.pipeIn = pipeIn;
	}
	
	public void run()
	{
		try
		{
			String input;
			
			//open the input file
			FileReader file = new FileReader("inputReadFilePipe.txt");
			input_file = new BufferedReader(file);
			
			//loop until EOF
			while (input_file.ready())
			{
				//read the next line from the file
				input = input_file.readLine();
				//display the line
				System.out.println(input+ "\n");
				//flush the pipe (pushes the data through)
				pipeIn.flush();
			}
		}
		catch (FileNotFoundException fnf)
		{
			System.err.println("File not found");
			System.err.println(fnf.getMessage());
			System.exit(-1);
		}
		catch (IOException ioe)
		{
			System.err.println("Error During I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
}