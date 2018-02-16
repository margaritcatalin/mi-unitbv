package complex;

public class TestComplex {
public static void main(String[] args) {
	Complex c1=new Complex(1,2);
	Complex c2=new Complex(2,3);
	Complex c3=(Complex)c1.clone();
	System.out.println(c1.aduna(c2));
	System.out.println(c1.equals(c2));//false
	System.out.println(c1.equals(c3));//true
}
}
