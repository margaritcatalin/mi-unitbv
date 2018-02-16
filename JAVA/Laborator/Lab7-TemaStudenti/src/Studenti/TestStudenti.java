package Studenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestStudenti {

	public static void citireNote(ArrayList<Note> nt) throws InputMismatchException,NumberFormatException {

		String readString = "";
		Double readNota = (double) 0;
		Note n1 = new Note();
		Scanner s = new Scanner(System.in);
		System.out.println("Introduceti numele materiei:");
		readString = s.nextLine();
		n1.setMaterie(readString);
		System.out.println("Introduceti nota la materia " + n1.getMaterie() + ":");
		readNota = Double.parseDouble(s.nextLine());
		n1.setNota(readNota);
		System.out.println("Introduceti data examenului:");
		readString = s.nextLine();
		n1.setData(readString);

	}

	public static void citire(ArrayList<Student> st) throws InputMismatchException,NumberFormatException {
		String readString;
		int nrMaterii;
		Student s1 = new Student();
		Scanner s = new Scanner(System.in);
		System.out.println("Introduceti numele studentului:");
		readString = s.nextLine();
		s1.setNume(readString);
		System.out.println("Introduceti prenumele studentului:");
		readString = s.nextLine();
		s1.setPrenume(readString);
		System.out.println("Introduceti CNP-ul studentului:");
		readString = s.nextLine();
		s1.setCnp(readString);
		System.out.println("Introduceti numarul de telefon al studentului:");
		readString = s.nextLine();
		s1.setNrTelefon(readString);
		System.out.println("Introduceti nr de materii ale studentului:");
		nrMaterii = Integer.parseInt(s.nextLine());
		for (int i = 0; i < nrMaterii; i++) {
			Double readNota = (double) 0;
			Note n1 = new Note();
			System.out.println("Introduceti numele materiei:");
			readString = s.nextLine();
			n1.setMaterie(readString);
			System.out.println("Introduceti nota la materia " + n1.getMaterie() + ":");
			readNota = Double.parseDouble(s.nextLine());
			n1.setNota(readNota);
			System.out.println("Introduceti data examenului:");
			readString = s.nextLine();
			n1.setData(readString);
			s1.addNota(n1);
		}
		st.add(s1);
	}

	public static Double mediaNotelorPesteOpt(Student s) {
		int contor = 0;
		Double suma = (double) 0;
		for (Note nota : s.getNote()) {
			if (nota.getNota() >= 8) {
				suma += nota.getNota();
				contor++;
			}
		}
		return suma / contor;
	}

	public static void main(String[] args) {
		ArrayList<Student> listaStudenti = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		boolean alg = true;
		while (alg) {
			System.out.println("Optiuni:" + "\n0.Iesire" + "\n1.Sortati lista de studenti dupa anul nasterii"
					+ "\n2.Afisati studentii care au numar de vodafone"
					+ "\n3.Afisati studentii care sunt nascuti de Craciun"
					+ "\n4.Afisati studentii care au peste 5 la MIP"
					+ "\n5.Afisati studentii cu restante impreuna cu restantele"
					+ "\n6.Media notelor peste 8 de la studentul x" + "\n7.Introduceti date");
			int opt;
			try {
				opt = Integer.parseInt(s.nextLine());
				switch (opt) {
				case 0:
					alg = false;
					break;
				case 1:
					Collections.sort(listaStudenti, new Comparator<Student>() {
						@Override
						public int compare(Student s1, Student s2) {
							if (s1.getAnulNasterii() > s2.getAnulNasterii())
								return 1;
							else if (s1.getAnulNasterii() < s2.getAnulNasterii())
								return -1;
							else
								return 0;
						}
					});
					System.out.println(listaStudenti);
					break;
				case 2:
					for (Student student : listaStudenti) {
						if (student.getPrefix() == 72 || student.getPrefix() == 73)
							System.out.println(student);
					}
					break;
				case 3:
					for (Student student : listaStudenti) {
						if (student.getLunaZiNastere() == 1225)
							System.out.println(student);
					}
					break;
				case 4:
					for (Student student : listaStudenti) {
						if (student.getNotaLaMateria("MIP") >= (double) 5)
							System.out.println(student);
					}
					break;
				case 5:
					for (Student student : listaStudenti) {
						if (student.studentCuRestante())
							student.afisareRestante();
					}
					break;
				case 6:
					System.out.println("Introduceti numele studentului:");
					String readNume = s.nextLine();
					for (Student student : listaStudenti) {
						if (student.getNume().compareTo(readNume) == 0)
							System.out.println("Media notelor peste 8 este:" + mediaNotelorPesteOpt(student));
					}
					break;
				case 7:
					citire(listaStudenti);
					break;
				default:
					System.out.println("Nu avem aceasta optiune");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduceti un numar!");
			} catch (NumberFormatException e) {
				System.out.println("Ati introdus un caracter sau string in locul unui numar.");
			}
		}
	}
}
