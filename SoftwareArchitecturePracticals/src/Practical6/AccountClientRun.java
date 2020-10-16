package Practical6;

import org.acplt.oncrpc.*;
import java.net.InetAddress;
import java.io.IOException;

public class AccountClientRun {

	public static void main(String[] args) {
		AccountClient client = null;
		try
		{
			client = new AccountClient(InetAddress.getByName(args[0]), OncRpcProtocols.ONCRPC_UDP);
			client.getClient().setTimeout(300*1000);
			client.deposit_1(new Double(args[1]).doubleValue());
			System.out.println("Total $" + client.balance_1());
			client.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}

	}

}
