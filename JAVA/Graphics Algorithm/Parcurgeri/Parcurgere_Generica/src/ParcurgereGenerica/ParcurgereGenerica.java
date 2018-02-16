package ParcurgereGenerica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParcurgereGenerica {

	public static void parcurgereGenerica(ArrayList<Arc> A, int nodSursa, int nrNoduri, ArrayList<Integer> U,
			ArrayList<Integer> W, ArrayList<Integer> V, ArrayList<Integer> o, ArrayList<Integer> p) {
		U.remove(U.indexOf(nodSursa));
		V.add(nodSursa);
		int k = 1;

		for (int y = 0; y < nrNoduri; y++) {
			p.add(0);
		}

		for (int y = 0; y < nrNoduri; y++) {
			o.add(-1);
		}
		o.set((nodSursa - 1), 1);

		System.out.println("U= " + U);
		System.out.println("V= " + V);
		System.out.println("p= " + p);
		System.out.println("o= " + o);
		System.out.println();

		while (V.size() != 0) {
			Random rand = new Random();
			int nr = rand.nextInt(V.size());
			int x = V.get(nr);
			Arc a = new Arc();
			a.setX(x);
			for (int y = 0; y < nrNoduri; y++) {
				a.setY(y + 1);
				if (U.contains(y + 1)) {
					for (int i = 0; i < A.size(); i++) {
						if (A.get(i).getX() == a.getX() && A.get(i).getY() == a.getY()) {
							System.out.println("x= " + x);
							System.out.println("Exista arcul " + a + "  cu y= " + (y + 1));
							U.remove(U.indexOf(y + 1));
							V.add(y + 1);
							p.set(y, x);
							k++;
							o.set(y, k);
							System.out.println("U= " + U);
							System.out.println("V= " + V);
							System.out.println("p= " + p);
							System.out.println("o= " + o);
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
		System.out.println("o= " + o);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> U = new ArrayList<Integer>();
		ArrayList<Integer> W = new ArrayList<Integer>();
		ArrayList<Integer> V = new ArrayList<Integer>();
		ArrayList<Integer> o = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Arc> A = new ArrayList<Arc>();
		ArrayList<Arc> Ap = new ArrayList<Arc>();
		int nodSursa, nrArce, nrNoduri;
		Arc arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader(
					"C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\parcurgere.txt"));
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

			System.out.println("A= " + A);

			nodSursa = Integer.parseInt(date[3]);

			parcurgereGenerica(A, nodSursa, nrNoduri, U, W, V, o, p);
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
