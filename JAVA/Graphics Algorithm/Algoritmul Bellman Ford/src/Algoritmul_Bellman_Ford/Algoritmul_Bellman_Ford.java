package Algoritmul_Bellman_Ford;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Algoritmul_Bellman_Ford {
	public static int minim(ArrayList<Integer> d) {
		int minim;
		int poz = -1;
		minim = 99999;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i) < minim) {
				minim = d.get(i);
				poz = i;
			}
		}
		return poz;
	}

	public static boolean verif(ArrayList<Integer> d, ArrayList<Integer> d1) {
		for (int y = 0; y < d.size(); y++) {
			if (d.get(y) != d1.get(y))
				return false;
		}
		return true;
	}

	public static void Bellman_Ford(ArrayList<Arc> A, ArrayList<Integer> N, int nodSursa, int nrNoduri) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> d1;
		ArrayList<Integer> p = new ArrayList<Integer>();

		for (int y = 0; y < nrNoduri; y++) {
			d.add(9999);
			p.add(0);
		}
		d.set((nodSursa - 1), 0);
		p.set((nodSursa - 1), 0);

		System.out.println("d= " + d);
		System.out.println("p= " + p);
		System.out.println();

		do {
			d1 = new ArrayList<Integer>();
			d1.addAll(d);
			for (int y = 1; y <= nrNoduri; y++) {
				System.out.println("y=" + y);
				ArrayList<Integer> pred = new ArrayList<Integer>();
				ArrayList<Integer> suma = new ArrayList<Integer>();
				for (int j = 0; j < A.size(); j++) {
					if (A.get(j).getY() == y) {
						pred.add(A.get(j).getX());
						suma.add(A.get(j).getValoare());
					}
				}

				if (pred.size() > 0) {
					for (int j = 0; j < pred.size(); j++) {
						suma.set(j, suma.get(j) + d1.get(pred.get(j) - 1));
					}
					int k = minim(suma);
					int x = pred.get(k);
					System.out.println("x=" + x);
					if (suma.get(k) < d1.get(y - 1)) {
						d.set(y - 1, suma.get(k));
						p.set(y - 1, x);
					}

				}
				System.out.println("d(" + y + ")=" + d.get(y - 1));
				System.out.println("p(" + y + ")=" + p.get(y - 1));
				System.out.println();
			}
			System.out.println("d'= " + d1);
			System.out.println("d= " + d);
			System.out.println("p= " + p);
			System.out.println();
		} while (verif(d, d1) != true);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nrNoduri, nrArce, nodSursa, valoare, x, y;
		ArrayList<Arc> A = new ArrayList<Arc>();
		ArrayList<Integer> N = new ArrayList<Integer>();
		Arc arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\bellman.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrArce = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split("-");
				arc = new Arc(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]), Integer.parseInt(arce[2]));
				A.add(arc);
			}
			for (int i = 0; i < nrNoduri; i++) {
				N.add(i + 1);
			}
			nodSursa = Integer.parseInt(date[3]);
			Bellman_Ford(A, N, nodSursa, nrNoduri);
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
