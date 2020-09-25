package Practical2;
import java.rmi.*;

public interface StudentInterface extends Remote {
	/**
	 * gets the student name
	 * @return the name of the student
	 * @throws RemoteException if problem not in rmi
	 */
	public String getName() throws RemoteException;
	
	/**
	 * Changes the student name
	 * 
	 * @param name the new name for the student
	 * @throws RemoteException Thrown if problem not in RMI
	 */
	public void setName(String name) throws RemoteException;
	
	
	/**
	 * gets the student matric number
	 * 
	 * @return the matric number of the student
	 * @throws RemoteException thrown if problem not in rmi
	 */
	public String getMatric() throws RemoteException;
	
	/**
	 * changes the student matric number
	 * 
	 * @param matric the new student matric number
	 * @throws RemoteException thrown if problem with the RMI
	 */
	public String setMatric(String metric) throws RemoteException;
	
	/**
	 * Gets the student programme 
	 * 
	 * @return the student programme
	 * @throws RemoteException thrown if problem with the RMI
	 */
	public String getProgramme() throws RemoteException;
	
	/**
	 * changes the student programme
	 * 
	 * @param programme the new student programme
	 * @throws RemoteException thrown if problem with the RMI
	 */
	public void setProgramme(String programme) throws RemoteException;
}
