package catalin.server;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import catalin.utils.Encryption;

public class Server {
	
	private static final int PORT = 8888;

	public static void main(String[] args) {
		
		ServerSocket serverSocket;
		Socket clientSocket;
		
		try {
			
			serverSocket = new ServerSocket(PORT);
			clientSocket = serverSocket.accept();
			
			InputStream in = clientSocket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String messageToDecrypt = br.readLine();
			
			System.out.println(Encryption.decrypt("client", messageToDecrypt));
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
