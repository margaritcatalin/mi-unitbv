package ThisSiSuper;

public class B extends A{
	B(){
		this(0);
	}
	B(int x){
		super(x);
		System.out.println(x);
	}
	void metoda() {
		super.metoda();
		System.out.println(x);
	}
}
