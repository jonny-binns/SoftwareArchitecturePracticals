package Practical2;
import java.io.*;
import java.util.StringTokenizer;

public class ShiftLineThread extends Thread{
	private PipedReader pipeOut;
	private PipedWriter pipeIn;
	
	ShiftLineThread(PipedReader pipeOut, PipedWriter pipeIn)
	{
		this.pipeOut = pipeOut;
		this.pipeIn = pipeIn;
	}
	
	public void run()
	{
		try
		{
			//the incoming pipe will send strings, simplest method is to buffer the pipe
			BufferedReader bufferedPipe = new BufferedReader(pipeOut);
			
			//we loop forever, when no data is left on the pipe the opposite end will close it, causing an IOException which is caught
			while (true)
			{
				//read the next line
				String line = bufferedPipe.readLine();
				
				//use StringTokenizer to turn the read line into its individual elements
				StringTokenizer tokenizer = new StringTokenizer(line, ".,;:()");
				
				//create an array to store all the elements in, the size of the array is the number of tokens in the tokenizer
				String[] tokens = new String[tokenizer.countTokens()];
				
				//now read the tokens into the array
				for (int i=0; tokenizer.hasMoreTokens(); i++)
				{
					tokens[i] = tokenizer.nextToken();
				}
				
				//time to shift the line, we do this as many times as we have tokens as this is the number of combinations of shifted words
				for(int tokenCount = 0; tokenCount < tokens.length; tokenCount++)
				{
					//this is the string we store the shifted line in
					String temp = "";
					
					//start the shifted line from 0
					int index = tokenCount;
					
					//now ensure we use all the tokens
					for (int i = 0; i < tokens.length; i++)
					{
						//index will eventually become bigger than the size of the token array
						if (index >= tokens.length)
						{
							index = 0;
						}
						
						//concatinate current shifted line with next token
						temp = temp + tokens[index] + " ";
						//increment index to use the next token
						index++;
					}
					
					//Write the shifted line to the pipe
					pipeIn.write(temp + "\n");
					//push the data through
					pipeIn.flush();
				}
			}
		}
		catch (IOException ioe)
		{
			//this will occur when the pipe is empty. no need to throw exception
		}
	}

}