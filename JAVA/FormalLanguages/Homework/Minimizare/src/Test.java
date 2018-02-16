import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void serialize(Automat obj, String sursa) {
		try {
			FileOutputStream fis = new FileOutputStream(sursa);
			ObjectOutputStream obiect = new ObjectOutputStream(fis);
			obiect.writeObject(obj);
			fis.close();
			obiect.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fisierul nu a fost gasit!");
			System.err.println("Exceptie:" + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Eroare la scrierea in fisier!");
			e.printStackTrace();
		}

	}

	public static void citire(Automat a) {
		int nrStari = 0, nrStariFinale = 0, nrLitereAlfabet = 0, readInt, nrArce = 0;
		String readString;

		Scanner s = new Scanner(System.in);
		System.out.println("Dati numarul starilor: ");
		nrStari = Integer.parseInt(s.nextLine());
		for (int i = 0; i < nrStari; i++) {
			System.out.println("Dati starea:");
			readString = s.nextLine();
			a.addStare(readString);
		}
		System.out.println("Dati numarul starilor finale: ");
		nrStariFinale = Integer.parseInt(s.nextLine());
		System.out.println("Dati numarul de Litere: ");
		nrLitereAlfabet = Integer.parseInt(s.nextLine());
		System.out.println("Dati starea initiala: ");
		readString = s.nextLine();
		a.setStareInitiala(readString);
		for (int i = 0; i < nrStariFinale; i++) {
			System.out.println("Dati starea finala:");
			readString = s.nextLine();
			a.addStareFinala(readString);
		}
		System.out.println("Dati numarul de arce: ");
		nrArce = Integer.parseInt(s.nextLine());
		for (int i = 0; i < nrArce; i++) {
			Arc arc = new Arc();
			System.out.println("Stare stanga: ");
			readString = s.nextLine();
			arc.setSt(readString);

			System.out.println("Stare dreapta :");
			readString = s.nextLine();
			arc.setDr(readString);

			System.out.println("Merge prin litera: ");
			readString = s.nextLine();
			arc.setSimbolArc(readString);
			a.addArc(arc);

		}
		for (int i = 0; i < nrLitereAlfabet; i++) {
			System.out.println("Dati litera: ");
			readString = s.nextLine();
			a.addLiteraAlfabet(readString);
		}
		serialize(a, "fis.txt");

	}

	public static void main(String[] args) {
		String cuvant;
		Automat a = new Automat();
		Scanner s = new Scanner(System.in);
		System.out.println("Aveti un automat introdus in fisier? 1.Nu(Introduce) 2.Da(Verifica cuvant)");
		int opt;
		opt = Integer.parseInt(s.nextLine());
		if (opt == 1)
			citire(a);
		else {
			try {
				FileInputStream fis = new FileInputStream("fis.txt");
				ObjectInputStream obiect = new ObjectInputStream(fis);
				a = (Automat) obiect.readObject();
				fis.close();
				obiect.close();
			} catch (FileNotFoundException e) {
				System.err.println("Fisierul nu a fost gasit!");
				System.err.println("Exceptie:" + e.getMessage());
				System.exit(1);
			} catch (IOException e) {
				System.out.println("Eroare la citirea din fisier!");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(a);
		a.minimizare();

	}

}
