package Practical3;

public interface StudentDataLayerInterface {
	/**
	 * Adds new student to the data store 
	 * 
	 * @param student, student to add to the data store
	 * @return true if student added, otherwise false
	 */
	public boolean addStudent(Student student);
	
	/**
	 * Returns a student record from the data stor
	 * 
	 * @param matric, stidents matric
	 * @return. student record if it exists
	 */
	public Student getStudent(String matric);
	
	/**
	 * removes a student from the datastore 
	 * 
	 * @param matric, students matric 
	 * @return, true if the student was removed false otherwise
	 */
	public boolean removeStudent(String matric);
	
	/**
	 * updates a student record in the data store
	 * 
	 * @param matric, the matric number of the student record to update
	 * @param student. the new student record
	 * @return true if record was updated, false otherwise
	 */
	public boolean updateStudent(String matric, Student student);

}
