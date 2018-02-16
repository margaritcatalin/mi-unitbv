package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
	public static final int PORT = 4444;
	private DatagramSocket socket = null;
	DatagramPacket cerere, raspuns = null;

	public void start() throws IOException {
		socket = new DatagramSocket(PORT);
		try {
			while (true) {
				byte[] buf = new byte[256];
				cerere = new DatagramPacket(buf, buf.length);
				System.out.println("Asteptam un pachet...");
				socket.receive(cerere);
				InetAddress adresa = cerere.getAddress();
				int port = cerere.getPort();
				String mesaj = "Hello " + new String(cerere.getData());
				buf = mesaj.getBytes();
				raspuns = new DatagramPacket(buf, buf.length, adresa, port);
				socket.send(raspuns);
			}
		} finally {
			if (socket != null)
				socket.close();
		}
	}

	public static void main(String[] args) throws IOException {
		new DatagramServer().start();
	}
}
