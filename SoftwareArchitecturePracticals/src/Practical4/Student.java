package Practical4;

public class Student {
	//Attributes of Student Object
	private String matric;
	private String name;
	private String programme;
	
	/**
	 * Default constructor
	 * @param matric the Students matric number
	 * @param name the students name
	 * @param programme the students programme 
	 */
	public Student(String matric, String name, String programme)
	{
		this.matric = matric; 
		this.name = name;
		this.programme = programme;
	}
	
	/**
	 * Gets the students matric number
	 * 
	 * @return the matric number of the student
	 */
	public String getMatric()
	{
		return matric;
	}
	
	/**
	 * changes the students matric number
	 * 
	 * @param matric the new matric number
	 */
	public void setMatric(String matric)
	{
		this.matric = matric;
	}
	
	/**
	 * gets the students name
	 * 
	 * @return the name of the student
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * changes the students name
	 * 
	 * @param name, the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * gets the students programme 
	 * 
	 * @return the programme of the student
	 */
	public String getProgramme()
	{
		return programme;
	}
	
	/**
	 * changes the students programme
	 * 
	 * @param programme, the new programme of the student
	 */
	public void setProgramme(String programme)
	{
		this.programme = programme;
	}

}
