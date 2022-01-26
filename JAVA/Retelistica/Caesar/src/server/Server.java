package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static String decryptCezar(String mesaj, int cheie) {
		String msj = "";
		for (int i = 0; i < mesaj.length(); i++) {
			if (Character.isAlphabetic(mesaj.charAt(i))) {
				if (Character.isUpperCase(mesaj.charAt(i))) {
					msj += (char) ('A' + (mesaj.charAt(i) - 'A' - cheie) % 26);
				} else {
					msj += (char) ('a' + (mesaj.charAt(i) - 'a' - cheie) % 26);
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
		int b = sc.nextInt();
		int y = (int) (Math.pow(g, b) % p);
		dos.writeInt(y);
		System.out.println("Valoarea lui y a fost trimisa");
		int x = dis.readInt();
		System.out.println("Valoarea lui x a fost primita");
		int k = (int) (Math.pow(x, b) % p);
		return k;
	}

	public static void main(String[] args) throws IOException {
		ServerSocket dss = new ServerSocket(1342);
		Socket ds = dss.accept();
		DataInputStream dis = new DataInputStream(ds.getInputStream());
		DataOutputStream dos = new DataOutputStream(ds.getOutputStream());
		Scanner sc = new Scanner(System.in);
		int cheie = diffieHellman(sc, dis, dos);
		String mesaj = dis.readUTF();
		System.out.println("Mesaj criptat:");
		System.out.println(mesaj);
		System.out.println("Mesaj decriptat:");
		System.out.println(decryptCezar(mesaj, cheie));
		dss.close();
	}

}