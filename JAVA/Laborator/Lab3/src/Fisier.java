import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

import jdk.jfr.events.FileWriteEvent;

public class Fisier {
public static void main(String args[])
{
	Vector<Integer> v=new Vector<Integer>();
	try {
	File f=new File("numere.txt");
	Scanner sc=new Scanner(f);
	while(sc.hasNextLine())
	{
		int nr=sc.nextInt();
		v.add(nr);
	}
	}catch(FileNotFoundException e)
	{
		System.out.println("Nu gasesc fisierul!");
	}
	catch(NoSuchElementException e)
	{
		
	}
	for(int a:v)
		System.out.println(a);
	v.add(100);
	try {
		PrintWriter pw=new PrintWriter("numere.txt");
		for(int a:v)
			pw.println(a);
		pw.close();
	FileWriter fw=new FileWriter("numere.txt",true);
	PrintWriter pw2=new PrintWriter(fw,true);
	pw2.println(2007);
	pw2.close();
	fw.close();
	}catch(IOException e)
	{
	}
}
}
