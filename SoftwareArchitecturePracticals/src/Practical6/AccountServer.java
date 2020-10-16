package Practical6;

import java.rmi.Naming;

public class AccountServer {

	public static void main(String[] args) {
		try
		{
			AccountImpl acc = new AccountImpl();
			String url = "rmi://localhost:1099/Account";
			Naming.rebind(url, acc);
			System.out.println("account ready");
		}
		catch (Exception e)
		{
			System.out.println("AccountServer: exception: ");
			e.printStackTrace();
		}
	}

}
