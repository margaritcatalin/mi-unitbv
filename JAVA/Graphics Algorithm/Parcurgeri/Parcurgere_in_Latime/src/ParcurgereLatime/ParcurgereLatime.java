package ParcurgereLatime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParcurgereLatime {

	public static void parcurgereInLatime(ArrayList<Arc> A, int nodSursa, int nrNoduri, ArrayList<Integer> U,
			ArrayList<Integer> W, ArrayList<Integer> V, ArrayList<Integer> l, ArrayList<Integer> p,
			ArrayList<Integer> N) {
		U.remove(U.indexOf(nodSursa));
		V.add(nodSursa);
		for (int y = 0; y < nrNoduri; y++) {
			p.add(0);
		}

		for (int y = 0; y < nrNoduri; y++) {
			l.add(-1);
		}
		l.set((nodSursa - 1), 0);

		System.out.println("U= " + U);
		System.out.println("V= " + V);
		System.out.println("p= " + p);
		System.out.println("l= " + l);
		System.out.println();

		while (V.size() != 0) {
			Arc a = new Arc();
			int x = V.get(0);
			a.setX(x);
			for (int y = 0; y < nrNoduri; y++) {
				a.setY(y + 1);
				if (U.contains(y + 1)) {
					for (int i = 0; i < A.size(); i++) {
						if (A.get(i).getX() == a.getX() && A.get(i).getY() == a.getY()) {
							System.out.println("x= " + x);
							System.out.println("Exista arcul " + a + "  cu y= " + (y + 1) + " apartine lui U");
							U.remove(U.indexOf(y + 1));
							V.add(y + 1);
							p.set(y, x);
							l.set(y, l.get(x - 1) + 1);
							System.out.println("U= " + U);
							System.out.println("V= " + V);
							System.out.println("p= " + p);
							System.out.println("l= " + l);
							System.out.println();
						}
					}
				}
			}

			System.out.println("x= " + x);
			V.remove(V.indexOf(x));
			W.add(x);
			System.out.println("V= " + V);
			System.out.println("W= " + W);
			System.out.println();

		}
		System.out.println("p= " + p);
		System.out.println("l= " + l);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> N = new ArrayList<Integer>();
		ArrayList<Integer> U = new ArrayList<Integer>();
		ArrayList<Integer> W = new ArrayList<Integer>();
		ArrayList<Integer> V = new ArrayList<Integer>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Arc> A = new ArrayList<Arc>();
		int nodSursa, nrArce, nrNoduri;
		Arc arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("E:\\FACULTATE AN 2\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\parcurgere.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrArce = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split("-");
				arc = new Arc(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]));
				A.add(arc);
			}

			for (int i = 0; i < nrNoduri; i++) {
				U.add(i + 1);
			}

			for (int i = 0; i < nrNoduri; i++) {
				N.add(i + 1);
			}

			System.out.println("A= " + A);
			nodSursa = Integer.parseInt(date[3]);
			System.out.println("Nodul sursa este =  " + nodSursa);
			parcurgereInLatime(A, nodSursa, nrNoduri, U, W, V, l, p, N);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
