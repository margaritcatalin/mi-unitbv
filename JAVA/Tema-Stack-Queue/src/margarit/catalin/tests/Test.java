package margarit.catalin.tests;

import java.util.Iterator;
import java.util.Scanner;

import margarit.catalin.Exceptii.StructureException;
import margarit.catalin.queue.QueueImplement;
import margarit.catalin.stack.StackImplement;

public class Test {
	public static void afisare(Object s) {
		if (s instanceof StackImplement)
			System.out.println("Continutul stivei este:\n" + s);
		else if (s instanceof QueueImplement)
			System.out.println("Continutul cozii este:" + s);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Doriti sa fololositi o Stiva(Stack) sau o Coada(Queue)?");
		String alege = sc.nextLine();
		if (alege.compareTo("Stack") == 0 || alege.compareTo("Stiva") == 0) {
			StackImplement<Object> s = new StackImplement<Object>();
			boolean alg = true;
			while (alg) {
				System.out.println("Optiuni:" + "\n0.Iesire" + "\n1.Adauga elementele in stiva"
						+ "\n2.Scoate elementul din stiva" + "\n3.Afisati elementele stivei");
				int opt;
				opt = Integer.parseInt(sc.nextLine());
				switch (opt) {
				case 0:
					alg = false;
					break;
				case 1: {
					s.push(new Integer(1));
					s.push(new Double(3.14));
					s.push(new String("String Stiva"));
					break;
				}
				case 2: {
					try {
						s.pop();
					} catch (StructureException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3: {
					//afisare(s);
					Iterator Iterator = s.iterator();
			        while (Iterator.hasNext()) {
			            System.out.println(Iterator.next()); 
			            }
					break;
				}
				}
			}
		} else if (alege.compareTo("Queue") == 0 || alege.compareTo("Coada") == 0) {
			QueueImplement<Object> q = new QueueImplement<Object>();
			boolean alg = true;
			while (alg) {
				System.out.println("Optiuni:" + "\n0.Iesire" + "\n1.Adauga elementele in coada"
						+ "\n2.Scoate elementul din coada" + "\n3.Afisati elementele cozii");
				int opt;
				opt = Integer.parseInt(sc.nextLine());
				switch (opt) {
				case 0:
					alg = false;
					break;
				case 1: {
					q.push(new Integer(34));
					q.push(new Double(4.121));
					q.push(new String("String coada"));
					break;
				}
				case 2: {
					try {
						q.pop();
					} catch (StructureException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3: {
					//afisare(q);
					Iterator Iterator = q.iterator();
			        while (Iterator.hasNext()) {
			            System.out.println(Iterator.next()); 
			            }
					break;
				}
				}
			}
		} else
			System.err.print("Nu avem aceasta structura de date");
	}

}
