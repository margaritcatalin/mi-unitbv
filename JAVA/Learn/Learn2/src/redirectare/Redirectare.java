package redirectare;
import java.io.*;

import javax.imageio.stream.FileImageInputStream;
public class Redirectare {
public static void main(String[] args) {
	try {
		BufferedInputStream in=new BufferedInputStream(new FileInputStream("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\redirectare\\intrare.txt"));
		PrintStream out= new PrintStream(new FileOutputStream("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\redirectare\\rezultate.txt"));
		PrintStream err=new PrintStream(new FileOutputStream("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\redirectare\\erori.txt"));
		System.setIn(in);
		System.setOut(out);
		System.setErr(err);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		throw new IOException("Test");
	}catch(IOException e) {
		System.err.println("Eroare intrare/iesire!");
		e.printStackTrace();
	}
}
}
