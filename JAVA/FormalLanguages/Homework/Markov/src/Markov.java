import java.util.*;

public class Markov {

	public static void main(String[] args) {
		String stringInit, stringOut = null, readString = null;
		int numberRules;
		List leftRules = new ArrayList<String>();
		List rightRules = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		System.out.println("Stringul initial este:");
		stringInit = s.nextLine();
		System.out.println("numarul de reguli este:");
		numberRules = in.nextInt();
		System.out.println();
		stringOut = stringInit;

		for (int i = 0; i < numberRules; i++) {
			System.out.println("regula stanga");
			readString = s.nextLine();
			leftRules.add(readString);
			System.out.println("regula dreapta");
			readString = s.nextLine();
			rightRules.add(readString);
		}
		System.out.println(leftRules);
		System.out.println(rightRules);

		for (int i = 0; i < numberRules; i++) {
			if (rightRules.get(i).toString().startsWith(".") && rightRules.get(i).toString().length() == 1)
				break;// terminating rule
			if (rightRules.get(i).toString().startsWith(".") && rightRules.get(i).toString().length() > 1) {
				stringOut = stringOut.replaceAll(leftRules.get(i).toString(),
						rightRules.get(i).toString().substring(1));
				break;// last rule applied 
			}
			stringOut = stringOut.replaceAll(leftRules.get(i).toString(), rightRules.get(i).toString());
		}
		System.out.println(stringOut);
	}

}