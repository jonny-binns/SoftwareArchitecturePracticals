package Practical4;

public interface StudentApplicationLayerInterface {
	/**
	 * Adds a new student to the underlying Data layer
	 * 
	 * @param matric, students matric number
	 * @param name, students name
	 * @param programme, students programme
	 * @return message indicating outcome of adding student
	 */
	public String addStudent(String matric, String name, String programme);
	
	/**
	 * updates an existing student record
	 * 
	 * @param matric, students matric number
	 * @param name. students name
	 * @param programme, students programme
	 * @return message indicating success of updating student
	 */
	public String updateStudent(String matric, String name, String programme);
	
	/**
	 * gets a student record
	 * 
	 * @param matric, students matric number
	 * @return message indicating the outcome of getting the student
	 */
	public String getStudent(String matric);
	
	/**
	 * removes a student record
	 * 
	 * @param matric, students matric number
	 * @return, message indicating the success of removing the student
	 */
	public String removeStudent(String matric);

}
