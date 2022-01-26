package catalin.generators;

public class KSubsetGenerator {
	static boolean isDone = false;

	public static void searchPermutations(int arr[], int x[], int start, int end, int index, int k) {
		if (index == k) {
			for (int j = 0; j < k; j++)
				System.out.print(x[j] + " ");
			System.out.println();
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= k - index; i++) {
			x[index] = arr[i];
			searchPermutations(arr, x, i + 1, end, index + 1, k);
		}
	}

	public static void backtrackingGenerator(int[] arr, int k) {
		int[] data = new int[k];
		searchPermutations(arr, data, 0, arr.length - 1, 0, k);
	}

	public static void generareLexicografica(int[] x, int k) {
		isDone = true;
		int[] v2 = x.clone();
		do {
			v2 = next(v2, k);
			if (isDone == true) {
				break;
			}
			for (int i = 0; i < k; i++) {
				System.out.print(v2[i] + 1 + " ");
			}
			System.out.println("");

		} while (true);

	}

	public static int[] next(int[] x, int k) {

		if (isDone == true) {
			for (int i = 0; i < k; i++) {
				x[i] = i;
			}
			isDone = false;
			return x;
		}

		int poz = -1;
		for (int i = k - 1; i >= 0; i--) {
			if (x[i] < x.length - k + i) {
				poz = i;
				break;
			}
		}

		if (poz == -1) {
			isDone = true;
			return x;
		}

		x[poz] = x[poz] + 1;
		for (int i = poz + 1; i < k; i++) {
			x[i] = x[i - 1] + 1;
		}
		return x;

	}
}