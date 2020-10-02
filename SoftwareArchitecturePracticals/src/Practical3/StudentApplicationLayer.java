package Practical3;

public class StudentApplicationLayer implements StudentApplicationLayerInterface {
	//the underlying data layer this application layer sits upon
	private StudentDataLayerInterface dataLayer;
	
	/**
	 * Default constructor
	 * 
	 * @param dataLayer the data layer that this layer sits upon
	 */
	 public StudentApplicationLayer(StudentDataLayerInterface dataLayer)
	 {
		 this.dataLayer = dataLayer;
	 }
	 
	 public String addStudent(String matric, String name, String programme)
	 {
		 //First create a student record object
		 Student student = new Student(matric, name, programme);
		 //Try and add the record to the data layer 
		 boolean success = dataLayer.addStudent(student);
		 //Either the record was added or not, return an appropriate message
		 if (success)
		 {
			 return "Student " + matric + " added";
		 }
		 else
		 {
			 return "Failed to add Student: " + matric;
		 }
	 }
	 
	 public String getStudent (String matric)
	 {
		 //try amd get the student record object from the data layer
		 Student student = dataLayer.getStudent(matric);
		 //if the student record does not exist, the data layer will return null
		 if (student != null)
		 {
			 //return textual representation of the student record
			 return student.getMatric() + "\n" + student.getName() + "\n" + student.getProgramme();
  		 }
		 else
		 {
			 //return fail message
			 return "Student " + matric + " does not exist"; 
		 }
	 }
	 
	 public String removeStudent(String matric)
	 {
		 //try and remove the student from the data layer
		 boolean success = dataLayer.removeStudent(matric);
		 
		 //return appropriate message if removal was successful or not
		 if (success)
		 {
			 return "Student " + matric + " Removed";
		 }
		 else
		 {
			 return "Failed to remove student " + matric;
		 }
	 }
	 
	 public String updateStudent(String matric, String name, String programme)
	 {
		 //Create a new student record object 
		 Student student = new Student(matric, name, programme);
		 //try and update the student record with the data layer
		 boolean success = dataLayer.updateStudent(matric, student);
		 
		 //return appropriate message if update was successful or not
		 if (success)
		 {
			 return "Student " + matric + " successfully updated";
		 }
		 else
		 {
			 return "Student " + matric  + " not updated";
		 }
	 }

}
