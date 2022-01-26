package twoDimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Parity {
	private int litere;
	private int[][] matrix;

	private static Parity instance;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	private Parity() {
	}

	public static Parity getInstance(int[] input) {
		if (instance == null) {
			instance = new Parity();
		}
		instance.setInput(input);
		return instance;
	}

	public int[][] getInput() {
		return matrix;
	}

	public void setInput(int[] input) {
		this.matrix = new int[input.length][7];
		setLitere(input.length);
		for (int i = 0; i < input.length; i++) {
			for (int j = 6; j >= 0; j--) {
				this.matrix[i][j] = input[i] % 10;
				input[i] /= 10;

			}
		}
	}

	public void afiseaza() {
		for (int i = 0; i < this.getLitere(); i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getMatrixBit(int indexLine, int indexColumn) {
		return matrix[indexLine][indexColumn];
	}

	public int[] getVerticalParity() {
		int result[] = new int[7];
		for (int j = 0; j < 7; j++) {
			int nrap = 0;
			for (int i = 0; i < this.getLitere(); i++) {
				if (this.matrix[i][j] == 1) {
					nrap++;
				}
			}
			if (nrap % 2 == 0) {
				result[j] = 0;
			} else {
				result[j] = 1;
			}
		}
		return result;
	}

	public int geXORParity() {
		int result = 0;
		int hresult[] = new int[this.getLitere()];
		int vresult[] = new int[7];
		hresult = this.getHorizontalParity();
		vresult = this.getVerticalParity();
		int hnrap = 0;
		int vnrap = 0;
		for (int i = 0; i < this.getLitere(); i++) {
			if (hresult[i] == 1) {
				hnrap++;
			}
		}
		for (int i = 0; i < 7; i++) {
			if (vresult[i] == 1) {
				vnrap++;
			}
		}
		int phresult = hnrap % 2;
		int pvresult = vnrap % 2;
		return phresult ^ pvresult;
	}

	public int[] getHorizontalParity() {
		int result[] = new int[this.getLitere()];
		for (int i = 0; i < this.getLitere(); i++) {
			int nrap = 0;
			for (int j = 0; j < 7; j++) {
				if (this.matrix[i][j] == 1) {
					nrap++;
				}
			}
			if (nrap % 2 == 0) {
				result[i] = 0;
			} else {
				result[i] = 1;
			}
		}
		return result;
	}

	public void matrixCoruption(int IndexLine, int IndexColumn) {
		if (matrix[IndexLine][IndexColumn] == 0) {
			matrix[IndexLine][IndexColumn] = 1;
		} else {
			matrix[IndexLine][IndexColumn] = 0;
		}
	}

	public int getLitere() {
		return litere;
	}

	public void setLitere(int litere) {
		this.litere = litere;
	}

	public void viewMatrix() {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}

	public void setMatrixBit(int columnIndex, int lineIndex, int i) {
		matrix[columnIndex][lineIndex] = i;
	}

}
