package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {

	public static void main(String[] args) throws IOException {
		InetAddress adresa = InetAddress.getByName("127.0.0.1");
		int port = 4444;
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		byte buf[];
		try {
			socket = new DatagramSocket();
			buf = "Margarit".getBytes();
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()));
		} finally {
			if (socket != null)
				socket.close();
		}
	}

}
