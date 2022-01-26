package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private static String cryptCezar(String mesaj, int cheie) {
		String msj = "";
		for (int i = 0; i < mesaj.length(); i++) {
			if (Character.isAlphabetic(mesaj.charAt(i))) {
				if (Character.isUpperCase(mesaj.charAt(i))) {
					msj += (char) ('A' + (mesaj.charAt(i) - 'A' + cheie) % 26);
				} else {
					msj += (char) ('a' + (mesaj.charAt(i) - 'a' + cheie) % 26);
				}
			} else
				msj += mesaj.charAt(i);
		}
		return msj;
	}

	private static int diffieHellman(Scanner sc, DataInputStream dis, DataOutputStream dos) throws IOException {
		System.out.println("Introduceti valoare prima:");
		int p = sc.nextInt();
		System.out.println("Introduceti radacina primitiva:");
		int g = sc.nextInt();
		System.out.println("Introduceti valoare:");
		int a = sc.nextInt();
		int x = (int) (Math.pow(g, a) % p);
		dos.writeInt(x);
		System.out.println("Valoarea lui X a fost trimisa");
		int y = dis.readInt();
		System.out.println("Valoarea lui y a fost primita");
		int k = (int) (Math.pow(y, a) % p);
		return k;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		Socket ss = new Socket("127.0.0.1", 1342);
		DataInputStream dis = new DataInputStream(ss.getInputStream());
		DataOutputStream dos = new DataOutputStream(ss.getOutputStream());
		System.out.println("Introduceti mesajul:");
		String mesaj = sc.nextLine();
		int cheie = diffieHellman(sc,dis,dos);
		dos.writeUTF(cryptCezar(mesaj, cheie));
		ss.close();
	}

}