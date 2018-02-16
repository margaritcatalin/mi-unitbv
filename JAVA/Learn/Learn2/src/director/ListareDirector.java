package director;
import java.io.*;
import java.util.*;

import javax.sound.midi.Synthesizer;
public class ListareDirector {
private static void info(File f) {
	String nume=f.getName();
	if(f.isFile())
		System.out.println("Fisier:"+nume);
	else
		if(f.isDirectory())
			System.out.println("Director:"+nume);
	System.out.println("Cale absoluta:"+f.getAbsolutePath()+
			"\nPoate citi:"+f.canRead()+
			"\nPoate scrie:"+f.canWrite()+
			"\nParinte:"+f.getParent()+
			"\nCale:"+f.getPath()+
			"\nLungime:"+f.length()+
			"Data ultimei modificari:"+new Date(f.lastModified()));
	System.out.println("--------------------------------------------");
	
}
public static void main(String[] args) {
	String nume;
	if(args.length==0)
	nume = ".";
	else
		nume=args[0];
	try {
		File director=new File(nume);
		File[] continut= director.listFiles();
		for(int i=0;i<continut.length;i++)
			info(continut[i]);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
