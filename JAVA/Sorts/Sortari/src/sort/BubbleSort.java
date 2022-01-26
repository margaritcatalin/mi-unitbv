package sort;


import java.util.List;

public class BubbleSort {
	List<Integer> array;

	public BubbleSort(List<Integer> array) {
		super();
		this.array = array;
	}

	public long sort() {
		Long timp = System.currentTimeMillis();
		int size = array.size();
		do {

			for (int i = 0; i < size - 1; i++) {

				if (array.get(i) > array.get(i + 1)) {

					Integer temp1 = array.get(i + 1);
					Integer temp2 = array.get(i);
					array.set(i, temp1);
					array.set(i + 1, temp2);

				}
			}
			size = size - 1;
		} while (size != 1);
		return System.currentTimeMillis() - timp;
	}

	@Override
	public String toString() {
		return "BubbleSort [array=" + array + "]";
	}
}
