package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static List<Integer> getRand(Integer size) {
		List<Integer> a = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			a.add(rand.nextInt(size));
		}
		return a;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduceti dimensiunea vectorului:");
		Integer size = sc.nextInt();
		System.out.print("Introduceti cate repetari vreti sa faceti pentru a vedea media timpului de executie:");
		Integer numarRepetari = sc.nextInt();
		do {
			System.out.println(
					"Introduceti ce sortare doriti:\n1.BubbleSort\n2.MergeSort\n3.RankingSort\n4.LinearSort\n5.BitonicSort");
			Integer opitune = sc.nextInt();
			Long sumaTimpi = (long) 0;
			switch (opitune) {
			default: {
				System.out.println("Nu avem aceasta sortare!");
				break;
			}
			case 1: {
				List<BubbleSort> bubble=new ArrayList<BubbleSort>();
				for (int i = 0; i < numarRepetari; i++) {
					bubble.add(new BubbleSort(getRand(size)));
					sumaTimpi += bubble.get(i).sort();
				}
				System.out.println("Media timpului de executie pentru BubbleSort este:" + sumaTimpi / numarRepetari);
				break;
			}
			case 2: {
				List<MergeSort> merge=new ArrayList<MergeSort>();
				for (int i = 0; i < numarRepetari; i++) {
					merge.add(new MergeSort(getRand(size)));
					sumaTimpi += merge.get(i).sort();
				}
				System.out.println("Media timpului de executie pentru MergeSort este:" + sumaTimpi / numarRepetari);
				break;
			}
			case 3: {
				List<RankingSort> rank=new ArrayList<RankingSort>();
				for (int i = 0; i < numarRepetari; i++) {
					rank.add(new RankingSort(getRand(size)));
					sumaTimpi += rank.get(i).sort();
				}
				System.out.println("Media timpului de executie pentru RankingSort este:" + sumaTimpi / numarRepetari);
				break;
			}
			case 4: {
				List<LinearSort> linear=new ArrayList<LinearSort>();
				for (int i = 0; i < numarRepetari; i++) {
					linear.add(new LinearSort(getRand(size),size));
					sumaTimpi += linear.get(i).sort();
				}
				System.out.println("Media timpului de executie pentru LinearSort este:" + sumaTimpi / numarRepetari);
				break;
			}
			case 5: {
				List<BitonicSort> bitonic=new ArrayList<BitonicSort>();
				for (int i = 0; i < numarRepetari; i++) {
					bitonic.add(new BitonicSort(getRand(size)));
					sumaTimpi += bitonic.get(i).sort();
				}
				System.out.println("Media timpului de executie pentru BitonicSort este:" + sumaTimpi / numarRepetari);
				break;
			}
			}
		} while (true);
	}
}
