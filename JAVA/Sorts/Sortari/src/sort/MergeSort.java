package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	List<Integer> array;

	public MergeSort(List<Integer> array) {
		super();
		this.array = array;
	}

	public long sort() {
		Long timp = System.currentTimeMillis();
		mergeSort(0, array.size() - 1, array, new ArrayList<Integer>(array));
		return System.currentTimeMillis() - timp;
	}

	private void mergeSort(int low, int high, List<Integer> values, List<Integer> aux) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid, values, aux);
			mergeSort(mid + 1, high, values, aux);
			merge(low, mid, high, values, aux);
		}
	}

	private void merge(int low, int mid, int high, List<Integer> values, List<Integer> aux) {

		int left = low;
		int right = mid + 1;

		for (int i = low; i <= high; i++) {
			aux.set(i, values.get(i));
		}

		while (left <= mid && right <= high) {
			values.set(low++, aux.get(left).compareTo(aux.get(right)) < 0 ? aux.get(left++) : aux.get(right++));
		}

		while (left <= mid) {
			values.set(low++, aux.get(left++));
		}
	}
}
