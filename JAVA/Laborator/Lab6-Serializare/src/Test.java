
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {
public static void serialize(ObjectToSerialize obj,String sursa) {
	try {
		FileOutputStream fis=new FileOutputStream(sursa);
		ObjectOutputStream obiect = new ObjectOutputStream(fis);
		obiect.writeObject(obj);
		fis.close();
		obiect.close();
	}catch(FileNotFoundException e) {
		System.err.println("Fisierul nu a fost gasit!");
		System.err.println("Exceptie:"+e.getMessage());
		System.exit(1);
	} catch (IOException e) {
		System.out.println("Eroare la scrierea in fisier!");
		e.printStackTrace();
	}
	
}
public static void deSerialize(String sursa) {
	try {
		FileInputStream fis=new FileInputStream(sursa);
		ObjectInputStream obiect = new ObjectInputStream(fis);
		ObjectToSerialize obj;
		obj=(ObjectToSerialize) obiect.readObject();
		System.out.println(obj);
		fis.close();
		obiect.close();
	}catch(FileNotFoundException e) {
		System.err.println("Fisierul nu a fost gasit!");
		System.err.println("Exceptie:"+e.getMessage());
		System.exit(1);
	} catch (IOException e) {
		System.out.println("Eroare la citirea din fisier!");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void main(String[] args) {
	Owner o1 = new Owner("Andronache", "Marius");
	Owner o2 = new Owner("Anton", "Andrei");
	Car c1= new Car(o1,"Mercedes","C",2005);
	Car c2= new Car(o2,"Audi","A8",2017);
	Car c3= new Car(o1,"BMW","C",2016);
	ArrayList<Car> cars=new ArrayList<Car>();
	cars.add(c1);
	cars.add(c2);
	cars.add(c3);
	ObjectToSerialize obiect = new ObjectToSerialize(cars);
	serialize(obiect,"fis.txt");
	deSerialize("fis.txt");
}
}
