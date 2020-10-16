package Practical6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class Account extends Remote {
	double balance() throws RemoteException;
	void deposit(double amount) throws RemoteException;
	
}
