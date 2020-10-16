package Practical3;
import java.io.*;
import java.net.*;


public class Client {

	public static void main(String[] args) {
		try
		{
			//first create the input from keyboard
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client Program");
			
			//Next we need to find out the IP address and port number of the server
			System.out.print("Enter IP Address of server: ");
			String ip = input.readLine();
			System.out.print("Enter port number of server: ");
			String port_string = input.readLine();
			
			//The port number needs to be an int, so convert the string to an int
			int port = Integer.parseInt(port_string);
			
			Socket sock = new Socket(ip, port);
			
			//create the incoming stream to read messages from
			DataInputStream network = new DataInputStream(sock.getInputStream());
			
			//Display our address
			System.out.println("Address: " + sock.getInetAddress());
			String line;
			
			//loop until the connection closes, reading from the network
			while ((line = network.readUTF()) != null)
			{
				//display the recieved message
				System.out.println(line);
			}
		}
		catch (IOException ioe)
		{
			// This is expected when the server closes the network connection
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}

}
