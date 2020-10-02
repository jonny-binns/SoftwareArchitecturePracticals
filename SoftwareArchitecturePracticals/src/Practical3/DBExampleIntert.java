package Practical3;
import java.io.*;
import java.sql.*;

public class DBExampleIntert {

	public static void main(String[] args) {
		try
		{
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//first we need to establish a connection to the DB
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students?user=Java&password=Java");
			//set up keyboard input
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//Prompt for new Student Details
			System.out.print("New Student matric: ");
			String matric = input.readLine();
			System.out.print("New Student name: ");
			String name = input.readLine();
			System.out.print("New Student programme: ");
			String programme = input.readLine();
			//Create a new SQL Statement
			Statement statement = conn.createStatement();
			//build insert statement
			String update = "INSERT INTO StudentRecord (StudentMatric, StudentName, StudentProgramme) " + "VALUES ('" + matric + "', '" + name + "', '" + programme + "')";
			//execute the statement
			statement.executeUpdate(update);
			//release the resources held by the statement
			statement.close();
			//release resources held by the connection, this also ensures the INSERT completes
			conn.close();
			System.out.println("Update Succerssful");
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/o");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
		catch (SQLException sqe)
		{
			System.err.println("Error performing SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}

	}

}
