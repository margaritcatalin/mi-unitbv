package catalin.test;

import java.util.ArrayList;
import java.util.List;

import catalin.generators.KSubsetGenerator;
import catalin.generators.PermutationGenerator;
import catalin.generators.SubsetGenerator;

public class Main {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4};
		for (int i : array) {
			System.out.print(i + " ");
		}
	/*	System.out.println("Permutari prin metoda backtracking:");
		System.out.println();
		//PermutationGenerator.backtrackingGeneration(array, 0, 3);
		System.out.println("Permutari prin metoda lexicografica:");
		System.out.println();
		//PermutationGenerator.generareLexicografica(array);
	System.out.println();
		System.out.println("Submultimi prin metoda backtracking:");
		List<Integer> multime = new ArrayList<Integer>();
		int n=10;
		for(int i=1;i<=n;i++)
			multime.add(i);
		List<List<Integer>> subset = SubsetGenerator.backtrackingGenerator(multime);
		for (List<Integer> list : subset) {
			System.out.println();
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
		}*/
		System.out.println();
		System.out.println("Submultimi prin metoda lexicografica:");
		SubsetGenerator.generareLexicografica(array);
	/*	System.out.println();
		System.out.println("K Submultimi prin metoda backtracking:");
		System.out.println();
		KSubsetGenerator.backtrackingGenerator(array, 3);
		System.out.println("K Submultimi prin metoda lexicografica:");
		KSubsetGenerator.generareLexicografica(array, 3);
*/
	}
}
