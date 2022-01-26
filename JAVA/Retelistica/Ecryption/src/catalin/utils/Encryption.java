package catalin.utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Encryption {

	public static String encrypt(String key, String input) {
		if(input.length() % key.length() != 0) {
			input+="abcdefghijklmnopqrstuvwxyz".substring(0, key.length()-input.length() % key.length());
		}
		StringBuilder output = new StringBuilder();
		int totalRows = (int) Math.ceil((double) input.length() / key.length());

		char[][] rowChars = new char[totalRows][key.length()];
		char[][] colChars = new char[key.length()][totalRows];
		char[][] sortedColChars = new char[key.length()][totalRows];
		int currentRow, currentColumn;
		int[] shiftIndexes = new int[key.length()];
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < key.length(); i++) {
			m.put(key.charAt(i), i);
		}
		char tempArray[] = key.toCharArray();
		Arrays.sort(tempArray);
		for (int i = 0; i < tempArray.length; i++) {
			shiftIndexes[i] = m.get(tempArray[i]);
		}

		for (int i = 0; i < input.length(); ++i) {
			currentRow = i / key.length();
			currentColumn = i % key.length();
			rowChars[currentRow][currentColumn] = input.charAt(i);
		}

		for (int i = 0; i < totalRows; ++i)
			for (int j = 0; j < key.length(); ++j) {
				colChars[j][i] = rowChars[i][j];
			}

		for (int i = 0; i < key.length(); ++i)
			for (int j = 0; j < totalRows; ++j) {
				sortedColChars[shiftIndexes[i]][j] = colChars[i][j];
			}

		for (int i = 0; i < input.length(); ++i) {
			currentRow = i / totalRows;
			currentColumn = i % totalRows;
			output.append(sortedColChars[currentRow][currentColumn]);
		}
		return output.toString();
	}

	public static String decrypt(String key, String input) {
		StringBuilder output = new StringBuilder();
		int totalColumns = (int) Math.ceil((double) input.length() / key.length());
		char[][] rowChars = new char[key.length()][totalColumns];
		char[][] colChars = new char[totalColumns][key.length()];
		char[][] unsortedColChars = new char[totalColumns][key.length()];
		int currentRow, currentColumn;
		int[] shiftIndexes = new int[key.length()];
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < key.length(); i++) {
			m.put(key.charAt(i), i);
		}
		char tempArray[] = key.toCharArray();
		Arrays.sort(tempArray);
		for (int i = 0; i < tempArray.length; i++) {
			shiftIndexes[i] = m.get(tempArray[i]);
		}

		for (int i = 0; i < input.length(); ++i) {
			currentRow = i / totalColumns;
			currentColumn = i % totalColumns;
			rowChars[currentRow][currentColumn] = input.charAt(i);
		}

		for (int i = 0; i < key.length(); ++i)
			for (int j = 0; j < totalColumns; ++j) {
				colChars[j][i] = rowChars[i][j];
			}

		for (int i = 0; i < totalColumns; ++i)
			for (int j = 0; j < key.length(); ++j) {
				unsortedColChars[i][j] = colChars[i][shiftIndexes[j]];
			}

		for (int i = 0; i < input.length(); ++i) {
			currentRow = i / key.length();
			currentColumn = i % key.length();
			output.append(unsortedColChars[currentRow][currentColumn]);
		}
		
		return output.toString();
	}

}
