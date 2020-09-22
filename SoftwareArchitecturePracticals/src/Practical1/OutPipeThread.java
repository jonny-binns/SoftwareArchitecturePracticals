package Practical1;
import java.io.*;

public class OutPipeThread extends Thread {
	PipedReader pipeOut;
	private PrintWriter output_file;
	
	OutPipeThread(PipedReader pipeOut)
	{
		this.pipeOut = pipeOut;
	}
	
	public void run()
	{
		try
		{
			//put buffer on the pipe, enables string reading
			BufferedReader bufferedPipe = new BufferedReader(pipeOut);
			
			//create the output file
			FileWriter file = new FileWriter("output.txt");
			output_file = new PrintWriter(file);
			
			//loop forever
			while (true)
			{
				//read line from pipe
				String line = bufferedPipe.readLine();
				//display the line
				System.out.println("O/P pipe :" + line);
				//convert line to uppercase and write to file
				output_file.write(line.toUpperCase() + "\n");
				//flush the data to the file
				output_file.flush();
			}
		}
		catch (IOException ioe)
		{
			//do nothing, this will occur during the I/O operation
		}
	}

}