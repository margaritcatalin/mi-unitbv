package sort;

import java.util.List;

public class BitonicSort {
	List<Integer> array;

	public BitonicSort(List<Integer> array) {
		super();
		this.array = array;
	}
    public long sort() {
    	Long timp = System.currentTimeMillis();
        bitonicSort(0, array.size(), true);
        return System.currentTimeMillis() - timp;
    }

    private void bitonicSort(int pozStart, int pozEnd, boolean isAscending) {
        if (pozEnd > 1) {
            int pozMijloc = pozEnd / 2;
            bitonicSort(pozStart, pozMijloc, !isAscending);
            bitonicSort(pozStart + pozMijloc, pozEnd - pozMijloc, isAscending);
            bitonicMerge(pozStart, pozEnd, isAscending);
        }
    }

    private void bitonicMerge(int pozStart, int pozEnd, boolean dir) {
        if (pozEnd > 1) {
            int m = greatestPowerOfTwoLessThan(pozEnd);
            for (int i = pozStart; i < pozStart + pozEnd - m; i++) {
                compare(i, i + m, dir);
            }
            bitonicMerge(pozStart, m, dir);
            bitonicMerge(pozStart + m, pozEnd - m, dir);
        }
    }

    private void compare(int i, int j, boolean isSortingDirection) {
        if (isSortingDirection == (array.get(i) > array.get(j)))
            swap(i, j);
    }

    private void swap(int i, int j) {
        final int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }

    private int greatestPowerOfTwoLessThan(int n) {
        int k = 1;
        while (k < n)
            k = k << 1;
        return k >> 1;
    }
}
