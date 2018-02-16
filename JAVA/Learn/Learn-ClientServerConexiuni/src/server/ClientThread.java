package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket socket = null;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		String cerere, raspuns;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			cerere = in.readLine();// primim cerere de la client
			raspuns = "Hello " + cerere + "!";
			out.println(raspuns);
			out.flush();
		} catch (IOException e) {
			System.err.println("Eroare IO Thread\n" + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println("Socketul nu poate fi inchis\n" + e);
			}
		}
	}
}
