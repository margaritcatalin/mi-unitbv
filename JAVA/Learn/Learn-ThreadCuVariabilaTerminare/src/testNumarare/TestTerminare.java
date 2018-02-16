package testNumarare;
import java.io.*;
import numarare.NumaraSecunde;

public class TestTerminare {
public static void main(String[] args) throws IOException{
	NumaraSecunde fir=new NumaraSecunde();
	fir.start();
	System.out.println("Apasati tasta Enter");
	System.in.read();
	fir.executie=false;
	System.out.println("S-au scurs "+ fir.sec+" secunde");
}
}
