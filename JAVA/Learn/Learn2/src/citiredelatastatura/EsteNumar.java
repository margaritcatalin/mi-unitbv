package citiredelatastatura;
import java.io.*;
public class EsteNumar {
public static void main(String[] args) {
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	try {
		while(true) {
			String s=stdin.readLine();
			if(s.equals("exit")||s.length()==0)
				break;
			System.out.println(s);
			try {
				Double.parseDouble(s);
				System.out.println(":DA");
			}catch(NumberFormatException e) {
				System.out.println(":NU");
			}
		}
	}catch(IOException e) {
		System.err.println("Eroare la intrarea standard!");
		e.printStackTrace();
	}
}
}
