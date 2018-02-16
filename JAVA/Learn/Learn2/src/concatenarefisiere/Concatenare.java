package concatenarefisiere;
import java.io.*;
public class Concatenare {
public static void main(String[] args) {
	/*if(args.length<=1) {
		System.out.println("Argumente insuficiente!");
		System.exit(-1);
	}*/
	try {
		FileInputStream f1=new FileInputStream("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\concatenarefisiere\\in.txt");
		FileInputStream f2=new FileInputStream("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\concatenarefisiere\\out.txt");
		SequenceInputStream s=new SequenceInputStream(f1, f2);
		int c;
		while((c=s.read())!=-1)
			System.out.println((char)c);
		s.close();
	}catch(FileNotFoundException e) {
		System.err.println("Fisierul nu a fost gasit!");
		System.err.println("Exceptie:"+e.getMessage());
		System.exit(1);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
