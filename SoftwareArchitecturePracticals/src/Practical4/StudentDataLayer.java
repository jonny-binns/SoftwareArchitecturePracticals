package Practical4;
import java.util.*;

public class StudentDataLayer implements StudentDataLayerInterface {
	//the data store holding the Student details 
	private HashMap<String, Student> students = new HashMap<String, Student>();
	
	/**
	 * Default constructor
	 */
	public StudentDataLayer()
	{
	}
	
	public boolean addStudent(Student student)
	{
		//first check that no student with the same matric number exists
		if (students.containsKey(student.getMatric()))
		{
			//Student with that matric number exists, return false
			return false;
		}
		else
		{
			//no student with that matric exists, add student to the data store 
			students.put(student.getMatric(), student);
			//return true
			return true;
		}
	}
	
	public Student getStudent(String matric)
	{
		//retrieve the student from the data store
		Student student = students.get(matric);
		//if no student with that matric number is stored in the data store then the previous operation will return null
		//return what the outcome of the previous call was
		return student;
	}
	
	public boolean removeStudent (String matric)
	{
		//first check if a Student with that matric number exists 
		if (students.containsKey(matric))
		{
			//student exists, remove student records from data store
			students.remove(matric);
			//return true
			return true;
		}
		else
		{
			//student does not exist, return false
			return false;
		}
	}
	
	public boolean updateStudent(String matric, Student student)
	{
		//first check if the student record exists
		if (students.containsKey(matric))
		{
			//the student record exists, therefore we can update it
			//first retrieve the student record from the data store
			Student toUpdate = students.get(matric);
			//Now update the student record with the new name and programme
			toUpdate.setName(student.getName());
			toUpdate.setProgramme(student.getProgramme());
			return true;
		}
		else
		{
			//student does not exist
			return false;
		}
	}

}
