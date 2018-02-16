package catalin.angajat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestiuneAngajati {
	ArrayList ang = new ArrayList();

	public void citire() throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("angajat.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			ang = (ArrayList) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Fisierul nou...");
		} catch (Exception e) {
			System.out.println("Eroare la citirea datelor...");
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
		}
		System.out.println("Lista angajatilor:\n" + ang);
	}

	public void salvare() throws IOException {
		FileOutputStream fos = new FileOutputStream("angajati.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(ang);
	}

	public void adaugare() throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\nNume:");
			String nume = stdin.readLine();
			System.out.println("\nSalariu:");
			int salariu = Integer.parseInt(stdin.readLine());
			System.out.println("\nParola:");
			String parola = stdin.readLine();
			ang.add(new Angajat(nume, salariu, parola));
			System.out.println("Mai adaugat? (D/N)");
			String raspuns = stdin.readLine().toUpperCase();
			if (raspuns.startsWith("N"))
				break;

		}
	}

	public static void main(String[] args) throws IOException {
		GestiuneAngajati app = new GestiuneAngajati();
		app.citire();
		app.adaugare();
		app.salvare();
	}
}
