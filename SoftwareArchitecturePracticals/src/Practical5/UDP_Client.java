package Practical5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Client {

	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		try
		{
			aSocket = new DatagramSocket();
			//byte[] m = args[0].getBytes();
			byte[] m = "Hello".getBytes();
			//InetAddress aHost = InetAddress.getByName(args[1]);
			InetAddress aHost = InetAddress.getByName("127.0.0.1");
			DatagramPacket reuqest = new DatagramPacket(m, m.length, aHost, 6789);
			aSocket.send(reuqest);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData(), 0, reply.getLength()));
		}
		catch (Exception e)
		{
			aSocket.close();
			System.out.println("Socket " + e.getMessage());
		}
	}

}
