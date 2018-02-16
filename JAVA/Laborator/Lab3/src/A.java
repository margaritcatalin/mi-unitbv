
public class A {
	public int nr;
	public A(int nr) {
		this.nr=nr;
	}
	public A() {
		
	}
	public A(int nr,String s) {
		//this(nr);
		this();//this trebuie sa fie mereu prima linie a constructorului
	}
	public A(A ceva)//constructor de copiere ce copiaza atributele celui specificat
	{
		//this(ceva.nr);
		this.nr=ceva.nr;
	}
}
