package Practical2;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] args) {
		try
		{
			//First create the input from the keyboard
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Server Program");
			
			//Get the port to listen on
			System.out.println("Enter port number to listen on: ");
			String port_string = input.readLine();
			
			//The port number needs to be an int, so convert the string to an int
			int port = Integer.parseInt(port_string);
			
			//create a ServerSocket to listen on this address
			ServerSocket server = new ServerSocket(port);
			
			//accept an incoming client connection on the server socket
			Socket sock = server.accept();
			
			//create the output stream to the client
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());
			
			//send message
			network.writeUTF("Welcome " + sock.getInetAddress().getHostName() + ". we are " + new Date() + "\n");
			
			//close sockets this will cause the client to exit
			sock.close();
			server.close();
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}

}
