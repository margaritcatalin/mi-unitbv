package catalin.sort.util;

import java.util.List;

public class LinearSort {
	List<Integer> array;
	int size;

	public LinearSort(List<Integer> array, int size) {
		super();
		this.array = array;
		this.size = size;
	}

	public List<Integer> sort() {
		int counter[] = new int[size + 1];
		for (int i : array) {
			counter[i]++;
		}
		int ndx = 0;
		for (int i = 0; i < counter.length; i++) {
			while (0 < counter[i]) {
				array.set(ndx++, i);
				counter[i]--;
			}
		}
		return array;
	}
}
