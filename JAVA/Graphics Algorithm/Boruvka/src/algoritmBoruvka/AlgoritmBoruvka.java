package algoritmBoruvka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlgoritmBoruvka {

  static ArrayList<Arc> e;
  static Arc[] min;
  static int[] id, sz;


    
  public static void Boruvka (ArrayList<Arc> A, int n, int m) {
    id = new int[m];
    sz = new int[m];

    for (int i = 0; i < m; i++) {
      id[i] = i;
      sz[i] = 1;
    }

    e = new ArrayList<Arc>();
    e.addAll(A);
    int nodesLeft = n;
    int res = 0;
    System.out.println("Arborele de cost minim contine muchiile :");
    while (nodesLeft > 1) {
      min = new Arc[m];
      for (Arc edge : e) {
        int rx = find(edge.getX());
        int ry = find(edge.getY());
        if (rx == ry)
          continue;
        if (min[rx] == null || min[rx].getValoare() > edge.getValoare())
          min[rx] = edge;
        if (min[ry] == null || min[ry].getValoare() > edge.getValoare())
          min[ry] = edge;
      }
      for (int i = 0; i < n; i++) {
        if (min[i] == null)
          continue;
        int rx = find(min[i].getX());
        int ry = find(min[i].getY());
        if (rx == ry)
          continue;
        merge(rx, ry);
        nodesLeft--;
        res += min[i].getValoare();
        System.out.println("("+(min[i].getX()) + ", " + (min[i].getY()) + ") valoare=" + min[i].getValoare());
      }
    }
    System.out.println("Arborele partial minim gasit are valoarea : " + res);
  }

  static int find (int x) {
    return x == id[x] ? x : (id[x] = find(id[x]));
  }

  static void merge (int x, int y) {
    if (sz[x] > sz[y]) {
      sz[x] += sz[y];
      id[y] = x;
    } else {
      sz[y] += sz[x];
      id[x] = y;
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
			f = new BufferedReader(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\boruvka.txt"));
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
			Boruvka(A, nrNoduri, nrArce);
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