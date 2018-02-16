package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static final int PORT = 4444;

	public SimpleServer() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			while (true) {
				System.out.println("Asteptam un client...");
				Socket socket = serverSocket.accept();
				ClientThread t = new ClientThread(socket);
				t.start();
			}
		} catch (IOException e) {
			System.err.println("Eroare IO Server \n" + e);
		} finally {
			serverSocket.close();
		}
	}

	public static void main(String[] args) throws IOException {
		SimpleServer server = new SimpleServer();
	}
}
