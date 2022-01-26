package twoDimensional;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static int searchCoruptedBitLine(Parity parityMatrix, int[] verticalparity) {
		int index = 0;
		for (int i = 0; i < parityMatrix.getLitere(); i++) {
			int bitCounter = 0;
			for (int j = 0; j < 7; j++) {
				if (parityMatrix.getMatrixBit(i, j) == 1) {
					bitCounter++;
				}
			}
			if (bitCounter % 2 != verticalparity[i]) {
				index = i;
			}
		}
		return index;
	}

	public static int searchCoruptedBitColumn(Parity parityMatrix, int[] horizontalparity) {
		int index = 0;
		for (int i = 0; i < 7; i++) {
			int bitCounter = 0;
			for (int j = 0; j < parityMatrix.getLitere(); j++) {
				if (parityMatrix.getMatrixBit(j, i) == 1) {
					bitCounter++;
				}
			}
			if (bitCounter % 2 != horizontalparity[i]) {
				index = i;
			}
		}
		return index;
	}

	public static void fixCoruptedBit(Parity parityMatrix, int[] verticalparity, int[] horizontalparity) {
		if (parityMatrix.getMatrixBit(searchCoruptedBitLine(parityMatrix, verticalparity),
				searchCoruptedBitColumn(parityMatrix, horizontalparity)) == 0) {
			parityMatrix.setMatrixBit(searchCoruptedBitLine(parityMatrix, verticalparity),
					searchCoruptedBitColumn(parityMatrix, horizontalparity), 1);
		} else {
			parityMatrix.setMatrixBit(searchCoruptedBitLine(parityMatrix, verticalparity),
					searchCoruptedBitColumn(parityMatrix, horizontalparity), 0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduceti sirul de caractere:");
		String cuvant = sc.nextLine();
		int ascii[] = ASCIIProcessor.getInstance(cuvant).toASCII();
		int binary[] = BinaryProcessor.getInstance(ascii).toBinary();
		System.out.println("String:" + cuvant + "\n");
		System.out.println("Ascii:\n" + Arrays.toString(ascii));
		System.out.println("binary:\n" + Arrays.toString(binary));
		Parity parityMatrix = Parity.getInstance(binary);
		int verticalparity[] = parityMatrix.getHorizontalParity();
		System.out.println("Vertical parity:\n" + Arrays.toString(verticalparity));
		int horizontalparity[] = parityMatrix.getVerticalParity();
		System.out.println("Horizontal parity:\n" + Arrays.toString(horizontalparity));
		int xor = parityMatrix.geXORParity();
		System.out.println("Parity bit:\n" + xor);
		parityMatrix.viewMatrix();
		Random rand = new Random();
		int randomIndexLine = rand.nextInt(parityMatrix.getLitere());
		int randomIndexColumn = rand.nextInt(7);
		parityMatrix.matrixCoruption(randomIndexLine, randomIndexColumn);
		System.out.println("Matricea dupa coruperea bitului:");
		parityMatrix.viewMatrix();
		fixCoruptedBit(parityMatrix, verticalparity, horizontalparity);
		System.out.println("Matricea dupa corectarea bitului:");
		parityMatrix.viewMatrix();

	}
}
