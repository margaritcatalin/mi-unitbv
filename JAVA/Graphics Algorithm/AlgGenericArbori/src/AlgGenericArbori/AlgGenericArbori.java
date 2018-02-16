package AlgGenericArbori;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgGenericArbori {
	public static Muchie minim(ArrayList<Muchie> A) {
		int min = 9999;
		Muchie m = new Muchie();
		for (int y = 0; y < A.size(); y++) {
			if (A.get(y).getValoare() <= min) {
				min = A.get(y).getValoare();
				m.setX(A.get(y).getX());
				m.setY(A.get(y).getY());
				m.setValoare(A.get(y).getValoare());
			}
		}
		return m;
	}

	public static void programGeneric(ArrayList<Muchie> A, int nrNoduri, int nrMuchii,
			ArrayList<ArrayList<Integer>> N) {
		ArrayList<Integer> Ni, Nj;

		for (int i = 0; i < nrNoduri; i++) {
			Ni = new ArrayList<Integer>();
			Ni.add(i + 1);
			N.add(Ni);
		}

		ArrayList<ArrayList<Muchie>> Ap = new ArrayList<ArrayList<Muchie>>();
		for (int i = 0; i < nrNoduri; i++) {
			Ap.add(new ArrayList<Muchie>());
		}

		for (int i = 0; i < nrNoduri - 1; i++) {
			ArrayList<Muchie> af = new ArrayList<Muchie>();
			ArrayList<Muchie> ai = new ArrayList<Muchie>();
			Random rand = new Random();
			int nr = rand.nextInt(N.size());
			Ni = N.get(nr);
			ai = Ap.get(nr);
			System.out.println("N= " + N);
			System.out.println("Ni = " + Ni);

			for (int j = 0; j < A.size(); j++) {
				for (int k = 0; k < Ni.size(); k++) {
					if (Ni.get(k) == A.get(j).getX() && !Ni.contains(A.get(j).getY())) {
						af.add(A.get(j));
					}
				}
			}
			Muchie m = new Muchie();

			System.out.println("Muchii " + af);
			m = minim(af);
			System.out.println("Muchia minima este = " + m);

			int yb = m.getY();
			System.out.println("y barat =" + yb);

			int poz = -1;
			for (int p = 0; p < N.size(); p++) {
				if (N.get(p).contains(yb))
					poz = p;
			}

			Nj = new ArrayList<Integer>();
			Nj = N.get(poz);
			System.out.println("Nj=" + Nj);
			for (int j = 0; j < Nj.size(); j++) {
				Ni.add(Nj.get(j));
			}
			N.remove(poz);
			System.out.println("Ni = " + Ni);
			Ap.get(nr).add(m);
			for (int j = 0; j < Ap.get(poz).size(); j++) {
				m = Ap.get(poz).get(j);
				Ap.get(nr).add(m);
			}
			Ap.remove(poz);
			System.out.println("Ai'=" + ai);
			System.out.println();

		}
		System.out.println("A'=" + Ap);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nrNoduri, nrMuchii, valoare, x, y;
		ArrayList<Muchie> m = new ArrayList<Muchie>();
		Muchie arc;
		ArrayList<ArrayList<Integer>> N = new ArrayList<ArrayList<Integer>>();
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader(
					"C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\generic.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrMuchii = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split("-");
				arc = new Muchie(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]), Integer.parseInt(arce[2]));
				m.add(arc);
				arc = new Muchie(Integer.parseInt(arce[1]), Integer.parseInt(arce[0]), Integer.parseInt(arce[2]));
				m.add(arc);
			}
			programGeneric(m, nrNoduri, nrMuchii, N);
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
