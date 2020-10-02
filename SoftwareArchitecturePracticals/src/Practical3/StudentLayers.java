package Practical3;
import java.io.*;

public class StudentLayers
{
	// As other methods will be accessing these, make them globally accessible
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StudentApplicationLayer appLayer;
	
	public static void main(String[] args)
	{
		// Create the data layer
		StudentDataLayer dataLayer = new StudentDataLayer();
		// Create the application layer, passing in the data layer
		appLayer = new StudentApplicationLayer(dataLayer);
		try
		{
			// Loop until programme is exited (or an exception occurs)
			while (true)
			{
				// Display the user menu
				displayMenu();
				// Get the user input
				int choice = Integer.parseInt(input.readLine());
				// Behave based on the user input
				switch (choice)
				{
					case 1:
						// 1 selected, add a new student
						addStudent();
						break;
					case 2:
						// 2 selected, get an existing student
						getStudent();
						break;
					case 3:
						// 3 selected, update an existing student
						updateStudent();
						break;
					case 4:
						// 4 selected, remove an existing student
						removeStudent();
						break;
					default:
						// Another value was entered.  Display error message
						System.out.println("\nInvalid choice");
						break;
				}
				System.out.println();
			}
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
	
	/**
	 * Displays the user menu
	 */
	private static void displayMenu()
	{
		System.out.println("Student Database");
		System.out.println("----------------");
		System.out.println("1) Add Student");
		System.out.println("2) Get Student Details");
		System.out.println("3) Update Student Details");
		System.out.println("4) Remove Student");
		System.out.print("\nEnter choice: ");
	}
	
	/**
	 * Adds a new Student record
	 * 
	 * @throws IOException Thrown if a problem occurs during keyboard I/O
	 */
	private static void addStudent() throws IOException
	{
		// Prompt and get all the student details
		System.out.print("\nStudent matric: ");
		String matric = input.readLine();
		System.out.print("Student name: ");
		String name = input.readLine();
		System.out.print("Student programme: ");
		String programme = input.readLine();
		// Get the result from trying to add the Student record to the app layer
		String result = appLayer.addStudent(matric, name, programme);
		// Display result
		System.out.println("\n" + result);
	}
	
	/**
	 * Gets an existing Student record
	 * 
	 * @throws IOException Thrown if a problem occurs during keyboard I/O
	 */
	private static void getStudent() throws IOException
	{
		// Prompt and get the Student's matric number
		System.out.print("\nStudent matric: ");
		String matric = input.readLine();
		// Get result from trying to retrieve the Student record
		String result = appLayer.getStudent(matric);
		// Display result
		System.out.println("\n" + result);
	}
	
	/**
	 * Updates an existing Student record
	 * 
	 * @throws IOException Thrown if a problem occurs during keyboard I/O
	 */
	private static void updateStudent() throws IOException
	{
		// Prompt and get the Student's matric number
		System.out.print("\nStudent matric: ");
		String matric = input.readLine();
		// Prompt and get the new Student's details
		System.out.print("New Student name: ");
		String name = input.readLine();
		System.out.print("New Student programme: ");
		String programme = input.readLine();
		// Get result from trying to update the Student record
		String result = appLayer.updateStudent(matric, name, programme);
		// Display result
		System.out.println("\n" + result);
	}
	
	/**
	 * Removes an existing Student record
	 * 
	 * @throws IOException Thrown if a problem occurs during keyboard I/O
	 */
	private static void removeStudent() throws IOException
	{
		// Prompt and get Student's matric number
		System.out.print("\nStudent matric: ");
		String matric = input.readLine();
		// Get result from trying to remove the Student record
		String result = appLayer.removeStudent(matric);
		// Display the result
		System.out.println("\n" + result);
	}
}
