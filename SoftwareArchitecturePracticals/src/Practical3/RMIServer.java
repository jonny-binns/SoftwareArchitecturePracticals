package Practical3;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

	public static void main(String[] args) {
		try
		{
			//Setup the keyboard input
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Student RMI Server");
			
			//Ask for the IP address of the RMI Registry
			System.out.print("IP address of RMI Registry: ");
			String ip = input.readLine();
			
			//create a new student object
			RMIStudent student = new RMIStudent("John Smith", "01234567", "BEng Software Engineering");
			
			//create the remote version of the student object
			StudentInterface student_stub = (StudentInterface)UnicastRemoteObject.exportObject(student);
			
			//connect to the RMI Registry
			Registry registry = LocateRegistry.getRegistry(ip);
			
			//Declare the object with the registry
			registry.rebind("student", student_stub);
			System.out.println("Student bound");
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}

}
