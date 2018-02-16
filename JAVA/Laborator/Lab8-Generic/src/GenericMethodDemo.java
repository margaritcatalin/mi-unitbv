import java.util.ArrayList;

public class GenericMethodDemo {
	public static <T> void afisare(ArrayList<T> list) {
		for (T t : list) {
			System.out.println(t);
		}
	}
	public static <T> void afisare2(T obiect) {
		System.out.println(obiect);
	}
	public static void main(String[] args) {
		ArrayList<Integer> l1=new ArrayList<Integer>();
		l1.add(1);
		l1.add(3);
		l1.add(4);
		ArrayList<Character> l2=new ArrayList<Character>();
		l2.add('H');
		l2.add('E');
		l2.add('T');
		l2.add('S');
		l2.add('M');
		afisare(l1);
		afisare(l2);
	}
}
