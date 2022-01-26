package rendundantaCiclica;

import java.util.Scanner;

public class Main {
	public static int validare(String s) {
		int ok = 1;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0')
				if (s.charAt(i) != '1') {
					ok = 0;
				}
		}

		return ok;
	}

	public static void main(String[] args) {
		String m, c;
		StringBuilder t = new StringBuilder();
		int grad;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduceti mesajul extins:");
		m = sc.nextLine();
		System.out.println("Introduceti polinomul generator:");
		c = sc.nextLine();
		if (validare(m) == 0 || validare(c) == 0) {
			System.out.println("Unul din siruri este invalid");
			return;
		}
		grad=c.length()-1;
		t.append(m);
		for (int i = 0; i < c.length() - 1; i++)
			t.append("0");
		StringBuilder r = new StringBuilder();
		r.append(t);
		while (r.length() >= c.length()) {
			for (int i = 0; i < c.length(); i++)
				if ((r.charAt(i) == '1' && c.charAt(i) == '0') || (r.charAt(i) == '0' && c.charAt(i) == '1'))
					r.setCharAt(i, '1');
				else
					r.setCharAt(i, '0');
			while(r.length()!=0)
			if (r.charAt(0) != '1')
				r.deleteCharAt(0);
			else break;
			System.out.println(r);
		}
		int i = r.length()-1;
		int j = t.length()-1;
		while (i >= 0) {
			if ((t.charAt(j) == '1' && r.charAt(i) == '0') || (t.charAt(j) == '0' && r.charAt(i) == '1')) {
				t.setCharAt(j, '1');
			}
			i--;
			j--;
		}
		System.out.println("Mesajul final este:" + t);
	}
}
