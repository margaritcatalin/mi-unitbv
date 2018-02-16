package Algoritmul_Floyd_Warshall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Algoritmul_Floyd_Warshall {
	public static void Floyd_Warshall(ArrayList<Arc> A, int n) {
		System.out.print("\n");
		int D[][] = new int[n][n];
		int B[][] = new int[n][n];
		int P[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (Arc ar : A) {
					if (i == j) {
						B[i][j] = 0;
						break;
					} else if (i != j) {
						if (ar.getX() != (i + 1) && ar.getY() != (j + 1)) {
							B[i][j] = 99999;
						} else if (ar.getX() == (i + 1) && ar.getY() == (j + 1)) {
							B[i][j] = ar.getValoare();
							break;
						}
					}
				}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				D[i][j] = B[i][j];
				if (i != j && D[i][j] < 99999)
					P[i][j] = i + 1;
				else
					P[i][j] = 0;
			}
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (D[i][k] < 99999 && D[k][j] < 99999 && D[i][k] + D[k][j] < D[i][j]) {
						D[i][j] = D[i][k] + D[k][j];
						P[i][j] = P[k][j];
					}
				}

		System.out.println("Matricea P :");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(P[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("Matricea D :");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (D[i][j] == 99999)
					System.out.print("inf" + "\t");
				else {
					if (D[i][j] >= 0)
						System.out.print(" ");
					System.out.print(D[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nrNoduri, nrArce, nodSursa, valoare, x, y;
		ArrayList<Arc> A = new ArrayList<Arc>();
		ArrayList<Integer> N = new ArrayList<Integer>();
		Arc arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\floyd.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrArce = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split(" ");
				arc = new Arc(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]), Integer.parseInt(arce[2]));
				A.add(arc);
			}
			for (int i = 0; i < nrNoduri; i++) {
				N.add(i + 1);
			}
			nodSursa = Integer.parseInt(date[3]);
			Floyd_Warshall(A, nrNoduri);
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
