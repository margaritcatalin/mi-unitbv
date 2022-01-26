package catalin.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import catalin.utils.Encryption;

public class Client {

	private static Scanner scanner;
	private static final int PORT = 8888;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		String localHostAdress = new String();
		Socket clientSocket;

		String messageToEncrypt;
		try {
			localHostAdress = new String(InetAddress.getLocalHost().getHostAddress());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			clientSocket = new Socket(localHostAdress, PORT);

			System.out.println("Read a message to encrypt : ");
			messageToEncrypt = scanner.nextLine();

			OutputStream out = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(out, true);
			ps.println(Encryption.encrypt("client", messageToEncrypt));
			System.out.println(Encryption.encrypt("client", messageToEncrypt));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
