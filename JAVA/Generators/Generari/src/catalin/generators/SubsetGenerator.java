package catalin.generators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubsetGenerator {
	static boolean isDone = false;

	public static <T> List<List<T>> backtrackingGenerator(Collection<T> list) {
		List<List<T>> ps = new ArrayList<List<T>>();
		ps.add(new ArrayList<T>());
		for (T item : list) {
			List<List<T>> newPs = new ArrayList<List<T>>();
			for (List<T> subset : ps) {
				newPs.add(subset);
				List<T> newSubset = new ArrayList<T>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}
			ps = newPs;
		}
		return ps;
	}

	public static int[] next(int[] x) {
		int count = x.length;
		if (isDone == true) {
			for (int i = 0; i < count; i++) {
				x[i] = 0;
			}
			isDone = false;
			return x;
		}
		int pos = -1;
		for (int i = count - 1; i >= 0; i--) {
			if (x[i] == 0) {
				pos = i;
				break;
			}
		}
		if (pos == -1) {
			isDone = true;
			return x;
		}
		x[pos] = 1;
		for (int i = pos + 1; i < count; i++) {
			x[i] = 0;
		}
		return x;
	}

	public static void generareLexicografica(int[] x) {
		isDone = true;
		int[] v2 = x.clone();
		do {
			v2 = next(v2);
			for (int i = 0; i < x.length; i++) {
				if (v2[i] == 1) {
					System.out.print(x[i] + " ");
				}
			}
			System.out.println();
			if (isDone == true) {
				break;
			}
		} while (true);
	}
}
