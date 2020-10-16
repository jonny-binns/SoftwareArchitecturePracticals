package Practical4;
import java.io.IOException;
import java.sql.*;

public class DBExampleQuery {

	public static void main(String[] args) {
		try
		{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish connection to the DB
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students?user=Java&password=Java");
			//Next we create a statement to access the database
			Statement statement = conn.createStatement();
			//now create a simple query to get all records from the database
			String query = "SELECT * FROM student record";
			//and then get the results from executing the query
			ResultSet results = statement.executeQuery(query);
			//loop until no records are left
			while (results.next())
			{
				// Retrieve each field of the currently selected record
				String matric = results.getString("StudentMatric");
				String name = results.getString("StudentName");
				String programme = results.getString("StudentProgramme");
				// Display the student details
				System.out.println(matric);
				System.out.println(name);
				System.out.println(programme);
				System.out.println();
			}
			//release resources held by the statement
			statement.close();
			//release resouces held by DB connection
			conn.close();
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
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
