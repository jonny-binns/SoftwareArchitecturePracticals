package Practical6;

import java.rmi.Naming;

public class AccountClient {
	public static void main(String[] args) {
		try
		{
			String host = System.getProperty("rmiregistry.host");
			String port = System.getProperty("rmiregistry.port");
			String url = "rmi://" + host + ":" + port + "/Account";
			Account acc = (Account) Naming.lookup(url);
			acc.deposit(new Double(args[0]).doubleValue());
			System.out.println("Total $" + acc.balance());
		}
		catch (Exception e)
		{
			System.out.println("AccountClient: exception:");
			e.printStackTrace();
		}
	}

}
