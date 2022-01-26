package sort;

import java.util.Collections;
import java.util.List;

public class RankingSort {
	List<Integer> array;

	public RankingSort(List<Integer> array) {
		super();
		this.array = array;
	}

	public long sort() {
		Long timp = System.currentTimeMillis();
		int min = Collections.min(this.array);
		int max = Collections.max(this.array);
		int[] rank = new int[max - min + 1];
		for (int number : array) {
			rank[number - min]++;
		}
		int z = 0;
		for (int i = min; i <= max; i++) {
			while (rank[i - min] > 0) {
				array.set(z, i);
				z++;
				rank[i - min]--;
			}
		}
		return System.currentTimeMillis() - timp;
	}
}