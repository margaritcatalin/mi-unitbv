package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) throws IOException {
		String adresaServer = "127.0.0.1";
		//InetAddress address = InetAddress.getByName("127.0.0.1");
		//System.out.println(address);
		int port = 4444;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String cerere, raspuns;
		try {
			new Socket(adresaServer, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			cerere = "Margarit";
			out.println(cerere);
			raspuns = in.readLine();
			System.out.println(raspuns);
		} catch (UnknownHostException e) {
			System.err.println("Serverul nu poate fi gasit\n" + e);
			System.exit(1);
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
			if (socket != null)
				socket.close();
		}
	}
}
