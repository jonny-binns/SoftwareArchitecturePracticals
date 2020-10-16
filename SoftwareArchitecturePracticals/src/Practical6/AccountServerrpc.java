package Practical6;

import org.acplt.oncrpc.*;
import org.acplt.oncrpc.server.*;
import java.io.IOException;

public class AccountServerrpc extends AccountServerStub {
	private double sum;
	
	public AccountServer() throws OncRpcException, IOException {
		sum 0.0;
	}
	
	public double balance_1() {
		return sum;
	}

	public void deposit_1(double d) {
		sum += d;
	}

	public static void main(String[] args) {
		try { 
			AccountServer server = new AccountServer();
			System.out.println("Account ready");
			server.run();
		} 
		catch ( Exception e ) 
		{ 
			e.printStackTrace(System.out); 
		}
	}
}
