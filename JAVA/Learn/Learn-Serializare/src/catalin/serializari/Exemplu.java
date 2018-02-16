package catalin.serializari;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exemplu {
public static void test(Object obj) throws IOException{
	FileOutputStream fos=new FileOutputStream("fisier.ser");
	ObjectOutputStream out= new ObjectOutputStream(fos);
	out.writeObject(obj);
	out.flush();
	fos.close();
	System.out.println("A fost salvat obiectul:"+obj);
	FileInputStream fis=new FileInputStream("fisier.ser");
	ObjectInputStream in =new ObjectInputStream(fis);
	try {
		obj=in.readObject();
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	fis.close();
	System.out.println("A fost restaurat obiectul:"+obj);
}
public static void main(String[] args) throws IOException{
	test(new Test1());
	try {
		test(new Test2());
	}catch(NotSerializableException e) {
		System.out.println("Obiect neserializabil:"+e);
	}
	test(new Test3());
}
}
