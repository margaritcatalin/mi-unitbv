
public class TestSingleton {
public static void main(String[] args) {
	Singleton s1=Singleton.createObj();
	Singleton s2=Singleton.createObj();
	System.out.println(s1==s2);//true
}
}
