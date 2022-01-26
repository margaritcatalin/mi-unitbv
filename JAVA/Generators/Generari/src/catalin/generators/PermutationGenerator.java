package catalin.generators;

public class PermutationGenerator {
	public static int[] swapNumbers(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		return array;
	}

	public static void backtrackingGeneration(int[] list, int counter, int size) {
		int i;
		if (counter == size) {
			for (i = 0; i <= size; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		} else {
			for (i = counter; i <= size; i++) {
				list = swapNumbers(list, counter, i);
				backtrackingGeneration(list, counter + 1, size);
				list = swapNumbers(list, counter, i);
			}
		}
	}

	public static void generareLexicografica(int[] x) {
		while (!nextPermutation(x)) {
			for (int i : x) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static boolean nextPermutation(int[] elements) {
		int count = elements.length;

		boolean done = true;

		for (int i = count - 1; i > 0; i--) {
			int curr = elements[i];

			if (curr < elements[i - 1]) {
				continue;
			}

			done = false;
			int prev = elements[i - 1];

			int currIndex = i;

			for (int j = i + 1; j < count; j++) {
				int tmp = elements[j];

				if (tmp < curr && tmp > prev) {
					curr = tmp;
					currIndex = j;
				}
			}

			elements[currIndex] = prev;
			elements[i - 1] = curr;

			for (int j = count - 1; j > i; j--, i++) {
				elements=swapNumbers(elements,i,j);
			}

			break;
		}

		return done;
	}

}
