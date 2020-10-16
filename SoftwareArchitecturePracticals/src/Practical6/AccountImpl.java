package Practical6;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class AccountImpl extends UnicastRemoteObject implements Account {
	private double sum;
	
	public AccountImpl() throws RemoteException
	{
		sum = 0.0;
	}
	
	public double balance() throws RemoteException
	{
		return sum;
	}
	
	public void deposit(double amount) throws RemoteException
	{
		sum += amount;
	}

}
