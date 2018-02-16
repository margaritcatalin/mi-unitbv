package AlgoritmulDijkstra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlgoritmulDijkstra {
	public static int minim(ArrayList<Integer> d, int nrNoduri, ArrayList<Integer> W) {
		int minim, j;
		int poz = -1;
		minim = 99999;
		for (int i = 0; i < W.size(); i++) {
			j = W.get(i) - 1;
			if (d.get(j) < minim) {
				minim = d.get(j);
				poz = j;
			}
		}
		return poz;
	}

	public static void Dijkstra(ArrayList<Arc> A, ArrayList<Integer> W, int nodSursa, int nrNoduri) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();

		for (int i = 0; i < nrNoduri; i++) {
			W.add(i + 1);
		}

		for (int y = 0; y < nrNoduri; y++) {
			d.add(9999);
			p.add(0);
		}
		d.set((nodSursa - 1), 0);

		System.out.println("W= " + W);
		System.out.println("d= " + d);
		System.out.println("p= " + p);
		System.out.println();

		while (W.size() > 0) {
			int x = minim(d, nrNoduri, W) + 1;
			System.out.println("x= " + x);
			W.remove(W.indexOf(x));
			ArrayList<Integer> succ = new ArrayList<Integer>();

			for (int i = 0; i < A.size(); i++) {
				if (A.get(i).getX() == x) {
					succ.add(A.get(i).getY());
				}
			}

			for (int y = 0; y < succ.size(); y++) {
				if (W.contains(succ.get(y))) {
					for (int i = 0; i < A.size(); i++) {
						if (A.get(i).getX() == x && A.get(i).getY() == succ.get(y)) {
							int suma = d.get(x - 1) + A.get(i).getValoare();
							if (suma < d.get(succ.get(y) - 1)) {
								d.set(succ.get(y) - 1, d.get(x - 1) + A.get(i).getValoare());
								p.set(succ.get(y) - 1, x);
							}
						}
					}
				}
			}
			System.out.println("W= " + W);
			System.out.println("d= " + d);
			System.out.println("p= " + p);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int nrNoduri, nrArce, nodSursa;
		ArrayList<Arc> A = new ArrayList<Arc>();
		ArrayList<Integer> W = new ArrayList<Integer>();
		Arc arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("E:\\FACULTATE AN 2\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\graf.txt"));
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
			nodSursa = Integer.parseInt(date[3]);
			Dijkstra(A, W, nodSursa, nrNoduri);
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
