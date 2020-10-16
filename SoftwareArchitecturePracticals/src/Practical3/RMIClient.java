package Practical3;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;


public class RMIClient {

	public static void main(String[] args) {
		try
		{
			//set up the keyboard input
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("RMI Client Program");
			
			//Get IP address of the RMI Registry
			System.out.println("Enter IP Address of RMI Registry: ");
			String ip = input.readLine();
			
			//connect to the registry
			Registry registry = LocateRegistry.getRegistry(ip);
			
			//get the remotely declared student object
			StudentInterface student = (StudentInterface)registry.lookup("student");
			
			//display the current student details
			System.out.println("Student details:");
			System.out.println("Name: " + student.getName());
			System.out.println("Matric: " + student.getMatric());
			System.out.println("Programme: " + student.getProgramme());
			
			//change the student details
			System.out.println("Enter the new student name: ");
			String name = input.readLine();
			student.setName(name);
			System.out.println("Enter the new student metric: ");
			String matric = input.readLine();
			student.setMatric(matric);
			System.out.println("Enter the new student programme: ");
			String programme = input.readLine();
			student.setProgramme(programme);
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
		catch (NotBoundException nbe)
		{
			System.err.println("Error in I/O");
			System.err.println(nbe.getMessage());
			System.exit(-1);
		}
	}

}
