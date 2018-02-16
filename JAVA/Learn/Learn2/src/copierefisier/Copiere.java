package copierefisier;
import java.io.*;
public class Copiere {
public static void main(String[] args) {
	try {
		FileReader in=new FileReader("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\copierefisier\\in.txt");
		FileWriter out=new FileWriter("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\copierefisier\\out.txt");
		int c;
		while((c=in.read())!=-1)
			out.write(c);
		in.close();
		out.close();
	}catch(FileNotFoundException e) {
		System.err.println("Fisierul nu a fost gasit!");
		System.err.println("Exceptie:"+e.getMessage());
		System.exit(1);
	}catch(IOException e) {
		System.err.println("Eroare la operatiile cu fisiere!");
		e.printStackTrace();
	}
}
}
