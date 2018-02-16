package fisier;

import java.io.*;

public class CitesteFisier {
public static void citesteFisier(String fis) {
	FileReader f=null;
	try {
		//Deschidem fisierul
		System.out.println("Deschidem fisierul "+fis);
		f=new FileReader(fis);
		//Citim si afisam fisierul caracter cu caracter
		int c;
		while((c=f.read())!=-1)
			System.out.println((char)c);
	}catch(FileNotFoundException e) {
		System.err.println("Fisierul nu a fost gasit!");
		System.err.println("Exceptie:"+e.getMessage());
		System.exit(1);
	} catch (IOException e) {
		System.out.println("Eroare la citirea din fisier!");
		e.printStackTrace();
	}finally {
		if(f!=null) {
			System.out.println("\nInchidem fisierul.");
			try {
				f.close();
			} catch (IOException e) {
				System.out.println("Fisierul nu poate fi inchis!");
				e.printStackTrace();
		}
	}
	}
}
public static void main(String[] args) {
	if(args.length>0)
		citesteFisier(args[0]);//apel din cmd java CitesteFisier <cale>
	else
		System.out.println("Lipseste numele fisierului!");
	citesteFisier("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\fisier\\test.txt");
}
}
